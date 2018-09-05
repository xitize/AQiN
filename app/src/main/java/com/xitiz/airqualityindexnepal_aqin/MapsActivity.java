package com.xitiz.airqualityindexnepal_aqin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.xitiz.airqualityindexnepal_aqin.model.Loc;
import com.xitiz.airqualityindexnepal_aqin.model.SearchResponse;
import com.xitiz.airqualityindexnepal_aqin.model.Station;
import com.xitiz.airqualityindexnepal_aqin.util.AirQualityScale;

import io.paperdb.Paper;

public class MapsActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                SearchResponse searchResponse = Paper.book().read("RESPONSE_STATION");
                Log.d("TAG", "Loc size " + searchResponse.getListOfLatLong().size());

                for (int i = 0; i < searchResponse.getListOfLatLong().size(); i++) {
                    Loc loc = searchResponse.getListOfLatLong().get(i);
                    Station station = searchResponse.getData().get(i).getStation();
                    String aqi = searchResponse.getData().get(i).getAqi();
                    String health_implications = AirQualityScale.calculateHealthImplications(searchResponse.getData().get(i).getAqi());
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(loc.getLat(), loc.getLng())).title(station.getName())).setSnippet("AQI "+aqi + ", " + health_implications);
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(loc.getLat(), loc.getLng()), 6));
                    googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                        @Override
                        public View getInfoWindow(Marker arg0) {
                            return null;
                        }

                        @Override
                        public View getInfoContents(Marker marker) {

                            LinearLayout info = new LinearLayout(getApplicationContext());
                            info.setOrientation(LinearLayout.VERTICAL);

                            TextView title = new TextView(getApplicationContext());
                            title.setTextColor(Color.BLACK);
                            title.setGravity(Gravity.CENTER);
                            title.setTypeface(null, Typeface.BOLD);
                            title.setText(marker.getTitle());

                            TextView snippet = new TextView(getApplicationContext());
                            snippet.setTextColor(Color.GRAY);
                            snippet.setText(marker.getSnippet());

                            info.addView(title);
                            info.addView(snippet);

                            return info;
                        }
                    });

                }

            }

        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


}
