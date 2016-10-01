package com.busfilter.busfileter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 01/10/2016.
 */
public class ListViewAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;

    HashMap<String, String> resultp = new HashMap<String, String>();
    public ListViewAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;

        data = arraylist;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
        TextView bus_name,bus_type,bus_seating,price;
        // Get the position
        resultp = data.get(position);
        // Locate the TextViews in listview_item.xml
        bus_name = (TextView) itemView.findViewById(R.id.bus_name);
        bus_name.setText(resultp.get("bus_name"));
        bus_type = (TextView) itemView.findViewById(R.id.bus_type);
        bus_type.setText(resultp.get("bus_type"));
        bus_seating = (TextView) itemView.findViewById(R.id.bus_seating);
        bus_seating.setText(resultp.get("bus_seating"));
        price = (TextView) itemView.findViewById(R.id.bus_price);
        price.setText(resultp.get("price"));
        return itemView;
    }
}
