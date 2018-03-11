package com.example.aakas.busbay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("bus");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int place_id = 3;
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Bus bus = new Bus();

                    //inside each bus
                    int bus_id = snapshot.child("id").getValue(Integer.class);
                    int max_seat = snapshot.child("maxSeat").getValue(Integer.class);
                    int seat_filled = snapshot.child("seatFilled").getValue(Integer.class);
                    bus.setId(bus_id);
                    bus.setSeatFilled(seat_filled);
                    bus.setMaxSeat(max_seat);

                    int max_length = 0;

                    //inside each route
                    for (DataSnapshot snap : snapshot.child("routes").getChildren()) {
                        max_length++;
                        if (snap.child("place_id").getValue(Integer.class) == place_id) {
                            int length = snap.child("length").getValue(Integer.class);
                            bus.setLength(length);
                        }
                    }
                    bus.setMaxLength(max_length);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}
