package com.example.aakas.busbay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner arrival,destination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrival = findViewById(R.id.arrival);
        destination = findViewById(R.id.destination);
        arrival.setOnItemSelectedListener(this);
        destination.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> bus_stops = new ArrayList <String>();
        bus_stops.add("CET");
        bus_stops.add("KHANDAGIRI");
        bus_stops.add("FIRESTATION");
        bus_stops.add("CRP");
        bus_stops.add("NAYAPALLI");
        bus_stops.add("JAVDEVBIHAR");
        bus_stops.add("ACHARYABIHAR");

        List<String> choice = new ArrayList<String>();
        choice.add("Arrival");
        choice.add("Departure");

        // Creating adapter for spinner
        ArrayAdapter <String> dataAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, bus_stops);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destination.setAdapter(dataAdapter);

        ArrayAdapter <String> choiceAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, choice);
        choiceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrival.setAdapter(choiceAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Spinner spinner = (Spinner)adapterView;
        if(spinner.getId() == R.id.arrival){
            String arr = adapterView.getItemAtPosition(i).toString();
        }
        else if(spinner.getId() == R.id.destination){
            String dest = adapterView.getItemAtPosition(i).toString();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
