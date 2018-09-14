package com.xitiz.airqualityindexnepal.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xitiz.airqualityindexnepal.R;
import com.xitiz.airqualityindexnepal.db.entity.DataItem;
import com.xitiz.airqualityindexnepal.util.AirQualityScale;

import java.util.List;

class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    private List<DataItem> dataItems;
    private LayoutInflater layoutInflater;

    SearchAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    void setDataItems(List<DataItem> dataItems) {
        this.dataItems = dataItems;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataItem dataItem = dataItems.get(position);
        holder.tv_loc.setText(dataItem.getStation().getName());
        holder.tv_aqi.setText(dataItem.getAqi());
        /*handling the - not data error on AQI by try catch*/
        try {
            holder.pol_level_background.setBackgroundColor(Color.parseColor(AirQualityScale.calculateColorLevel(dataItem.getAqi())));
            holder.pol_level_indicator.setText(AirQualityScale.calculatePollutionLevel(dataItem.getAqi()));
        } catch (Exception e) {
            Log.e("TAG", "error some data not available");
        }

    }


    @Override
    public int getItemCount() {
        if (dataItems != null) {
            return dataItems.size();
        } else
            return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_loc, tv_aqi, pol_level_indicator;
        LinearLayout pol_level_background;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_loc = itemView.findViewById(R.id.tv_location);
            tv_aqi = itemView.findViewById(R.id.tv_aqi);
            pol_level_background = itemView.findViewById(R.id.pollution_level_background);
            pol_level_indicator = itemView.findViewById(R.id.pollution_level);
        }
    }
}
