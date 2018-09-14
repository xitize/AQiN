package com.xitiz.airqualityindexnepal.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.xitiz.airqualityindexnepal.R;
import com.xitiz.airqualityindexnepal.SearchResponseViewModel;
import com.xitiz.airqualityindexnepal.db.entity.SearchResponse;
import com.xitiz.airqualityindexnepal.util.Loc;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FusedLocationProviderClient fusedLocationProviderClient;
    Loc loc;
    List<Loc> sortedListLoc = new ArrayList<>();
    SearchResponseViewModel searchResponseViewModel;
    SearchAdapter searchAdapter;


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchResponseViewModel = ViewModelProviders.of(this).get(SearchResponseViewModel.class);
        recyclerView = findViewById(R.id.recycler_view);
        searchAdapter = new SearchAdapter(this);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        /*loads the current last location by GPS*/
        //  loadLatestLocation();
        searchResponseViewModel.loadFormWebSearchResponse();
        searchResponseViewModel.getResponseFromDB().observe(this, new Observer<SearchResponse>() {
            @Override
            public void onChanged(@Nullable SearchResponse searchResponse) {

                searchAdapter.setDataItems(searchResponse.getData());
            }
        });

       /* restService.getSearchResponse(Const.token, " Nepal")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<SearchResponse>() {
                    @Override
                    public void onNext(SearchResponse searchResponse) {
                        Log.d("TAG", "" + searchResponse.toString());
                        sortedListLoc = searchResponse.getListOfLatLong();
                        Collections.sort(sortedListLoc, new SortPlaces(loc));

                        Log.d("TAG", "sorted nearest distance location is  : "
                                + sortedListLoc.get(0).getLat() + " lng : "
                                + sortedListLoc.get(0).getLng());

                        Paper.book().write("RESPONSE_STATION", searchResponse);
                        recyclerView.setAdapter(new SearchAdapter(searchResponse.getData()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("TAG", "error " + e.getCause());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("TAG", "completed ");
                    }
                });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_map:
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(123)
    private void loadLatestLocation() {
        String[] perms = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        Log.d("TAG", location.getLatitude() + " " + location.getLongitude());
                        loc = new Loc(location.getLatitude(), location.getLongitude());
                    }
                }
            });

//already have permission
        } else {
            //donot have permission do it now
            // Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_ask),
                    123, perms);
        }
    }
}
