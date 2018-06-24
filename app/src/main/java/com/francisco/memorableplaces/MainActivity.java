package com.francisco.memorableplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static ArrayList<String> places = new ArrayList<>();
    static ArrayList<LatLng> latLngs = new ArrayList<>();
    static ArrayAdapter  arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.places_listview);
        places.add("Add a new placce");
        latLngs.add(new LatLng(0, 0));

       arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("Placenumber", i);
                startActivity(intent);
            }
        });
    }
}
