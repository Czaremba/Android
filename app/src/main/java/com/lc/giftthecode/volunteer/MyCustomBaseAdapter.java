package com.lc.giftthecode.volunteer;
import java.util.ArrayList;

import com.lc.giftthecode.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lc.giftthecode.volunteer.OneFragment.*;

public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<SearchResults> searchArrayList;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public void updateSearchArrayList(ArrayList<SearchResults> newList){
        searchArrayList = newList;
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_row_view, null);
            holder = new ViewHolder();
            holder.txtDonorName = (TextView) convertView.findViewById(R.id.name);
            holder.txtFood = (TextView) convertView
                    .findViewById(R.id.cityState);
            holder.txtLocation = (TextView) convertView.findViewById(R.id.phone);
            holder.txtTime = (TextView) convertView.findViewById(R.id.time);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        holder.txtDonorName.setText(searchArrayList.get(position).getDonorName());
        holder.txtFood.setText(searchArrayList.get(position)
                .getFood());
        holder.txtLocation.setText(searchArrayList.get(position).getLocation());
        holder.txtTime.setText(searchArrayList.get(position).getTime());
        return convertView;
    }

    static class ViewHolder {
        TextView txtDonorName;
        TextView txtFood;
        TextView txtLocation;
        TextView txtTime;
    }
}
