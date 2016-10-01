package com.busfilter.busfileter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    ListViewAdapter adapter;
    String jsonObject="{\"status\":200,\"data\":[{\"bus_type\":\"ac\",\"bus_name\":\"Saini Travels\",\"bus_seating\":\"sleeper\",\"price\":\"750\"},{\"bus_type\":\"non-ac\",\"bus_name\":\"Maharashtra Travels\",\"bus_seating\":\"non-sleeper\",\"price\":\"500\"},{\"bus_type\":\"ac\",\"bus_name\":\"Mahendra Travels\",\"bus_seating\":\"sleeper\",\"price\":\"650\"},{\"bus_type\":\"ac\",\"bus_name\":\"Raj Travels\",\"bus_seating\":\"sleeper\",\"price\":\"650\"},{\"bus_type\":\"non-ac\",\"bus_name\":\"Jp Travels\",\"bus_seating\":\"non-sleeper\",\"price\":\"400\"},{\"bus_type\":\"ac\",\"bus_name\":\"Purple Travlers\",\"bus_seating\":\"sleeper\",\"price\":\"600\"},{\"bus_type\":\"ac\",\"bus_name\":\"JD Travlers\",\"bus_seating\":\"sleeper\",\"price\":\"600\"},{\"bus_type\":\"ac\",\"bus_name\":\"Rahul Travlers\",\"bus_seating\":\"sleeper\",\"price\":\"600\"}]}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab_ac = (FloatingActionButton) findViewById(R.id.fab_ac);
        ListView list = (ListView) findViewById(R.id.theatre_list_view);
        ArrayList<HashMap<String, String>> titles = new ArrayList<>();
        fab_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        try {
            JSONObject jObj = new JSONObject(jsonObject);
            int status = Integer.parseInt(jObj.getString("status"));
            String get_data = jObj.getString("data");
            //JSONObject jObj1 = new JSONObject(get_data);
            if (status == 200) {
                JSONArray jarray = new JSONArray(get_data);

                for (int i = 0; i < jarray.length(); ++i) {
                    JSONObject rec = jarray.getJSONObject(i);
                    HashMap<String, String> map = new HashMap<String, String>();
                    map.put("bus_type", rec.getString("bus_type"));
                    map.put("bus_name", rec.getString("bus_name"));
                    map.put("bus_seating", rec.getString("bus_seating"));
                    map.put("price", rec.getString("price"));
                    titles.add(map);

                }
                adapter = new ListViewAdapter(this, titles);
                list.setAdapter(adapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
