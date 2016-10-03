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
    String jsonObject = "{\"status\":200,\"data\":[{\"bus_type\":\"non-ac\",\"bus_name\":\"Saini Travels\",\"bus_seating\":\"sleeper\",\"price\":\"750\"},{\"bus_type\":\"non-ac\",\"bus_name\":\"Maharashtra Travels\",\"bus_seating\":\"non-sleeper\",\"price\":\"500\"},{\"bus_type\":\"ac\",\"bus_name\":\"Mahendra Travels\",\"bus_seating\":\"sleeper\",\"price\":\"650\"},{\"bus_type\":\"ac\",\"bus_name\":\"Raj Travels\",\"bus_seating\":\"sleeper\",\"price\":\"650\"},{\"bus_type\":\"non-ac\",\"bus_name\":\"Jp Travels\",\"bus_seating\":\"non-sleeper\",\"price\":\"400\"},{\"bus_type\":\"ac\",\"bus_name\":\"Purple Travlers\",\"bus_seating\":\"sleeper\",\"price\":\"600\"},{\"bus_type\":\"ac\",\"bus_name\":\"JD Travlers\",\"bus_seating\":\"sleeper\",\"price\":\"600\"},{\"bus_type\":\"ac\",\"bus_name\":\"Rahul Travlers\",\"bus_seating\":\"sleeper\",\"price\":\"600\"}]}";
    ListView list;
    FloatingActionButton fab_ac,fab_sleeping;
    Boolean ac_favicon=false;
    Boolean sleeper_favicon=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_ac = (FloatingActionButton) findViewById(R.id.fab_ac);
        fab_sleeping = (FloatingActionButton) findViewById(R.id.fab_sleeping);
        list = (ListView) findViewById(R.id.theatre_list_view);

        fab_ac.setBackgroundTintList(getResources().getColorStateList(R.color.faviconColor));
        fab_sleeping.setBackgroundTintList(getResources().getColorStateList(R.color.faviconColor));

        fab_sleeping.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ac_favicon=false;
                fab_ac.setBackgroundTintList(getResources().getColorStateList(R.color.faviconColor));
                list = (ListView) findViewById(R.id.theatre_list_view);
                try {
                    JSONObject jObj = new JSONObject(jsonObject);
                    int status = Integer.parseInt(jObj.getString("status"));
                    String get_data = jObj.getString("data");
                    ArrayList<HashMap<String, String>> titles = new ArrayList<>();
                    if (status == 200) {
                        JSONArray jarray = new JSONArray(get_data);
                        if (!sleeper_favicon) {
                            sleeper_favicon = true;
                            fab_sleeping.setBackgroundTintList(getResources().getColorStateList(R.color.faviconSelectedColor));
                            for (int i = 0; i < jarray.length(); ++i) {
                                JSONObject rec = jarray.getJSONObject(i);
                                HashMap<String, String> map = new HashMap<String, String>();
                                if (rec.getString("bus_seating").equals("sleeper")) {
                                    map.put("bus_type", rec.getString("bus_type"));
                                    map.put("bus_name", rec.getString("bus_name"));
                                    map.put("bus_seating", rec.getString("bus_seating"));
                                    map.put("price", rec.getString("price"));
                                    titles.add(map);
                                }
                            }
                        } else {
                            sleeper_favicon = false;
                            fab_sleeping.setBackgroundTintList(getResources().getColorStateList(R.color.faviconColor));
                            for (int i = 0; i < jarray.length(); ++i) {
                                JSONObject rec = jarray.getJSONObject(i);
                                HashMap<String, String> map = new HashMap<String, String>();
                                map.put("bus_type", rec.getString("bus_type"));
                                map.put("bus_name", rec.getString("bus_name"));
                                map.put("bus_seating", rec.getString("bus_seating"));
                                map.put("price", rec.getString("price"));
                                titles.add(map);
                            }
                        }
                        adapter = new ListViewAdapter(MainActivity.this, titles);
                        list.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        fab_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab_sleeping.setBackgroundTintList(getResources().getColorStateList(R.color.faviconColor));
                sleeper_favicon=false;
                list = (ListView) findViewById(R.id.theatre_list_view);
                try {
                    JSONObject jObj = new JSONObject(jsonObject);
                    int status = Integer.parseInt(jObj.getString("status"));
                    String get_data = jObj.getString("data");
                    ArrayList<HashMap<String, String>> titles = new ArrayList<>();
                    if (status == 200) {
                        JSONArray jarray = new JSONArray(get_data);
                        if (!ac_favicon) {
                            ac_favicon = true;
                            fab_ac.setBackgroundTintList(getResources().getColorStateList(R.color.faviconSelectedColor));
                            for (int i = 0; i < jarray.length(); ++i) {
                                JSONObject rec = jarray.getJSONObject(i);
                                HashMap<String, String> map = new HashMap<String, String>();
                                if (rec.getString("bus_type").equals("ac")) {
                                    map.put("bus_type", rec.getString("bus_type"));
                                    map.put("bus_name", rec.getString("bus_name"));
                                    map.put("bus_seating", rec.getString("bus_seating"));
                                    map.put("price", rec.getString("price"));
                                    titles.add(map);
                                }
                            }
                        } else {
                            ac_favicon = false;
                            fab_ac.setBackgroundTintList(getResources().getColorStateList(R.color.faviconColor));
                            for (int i = 0; i < jarray.length(); ++i) {
                                JSONObject rec = jarray.getJSONObject(i);
                                HashMap<String, String> map = new HashMap<String, String>();
                                map.put("bus_type", rec.getString("bus_type"));
                                map.put("bus_name", rec.getString("bus_name"));
                                map.put("bus_seating", rec.getString("bus_seating"));
                                map.put("price", rec.getString("price"));
                                titles.add(map);
                            }
                        }
                        adapter = new ListViewAdapter(MainActivity.this, titles);
                        list.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


        try {
            JSONObject jObj = new JSONObject(jsonObject);
            int status = Integer.parseInt(jObj.getString("status"));
            String get_data = jObj.getString("data");
            //JSONObject jObj1 = new JSONObject(get_data);
            if (status == 200) {
                JSONArray jarray = new JSONArray(get_data);
                ArrayList<HashMap<String, String>> titles = new ArrayList<>();
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
