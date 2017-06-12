package com.example.android.tourio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;


public class MuseumsActivity extends AppCompatActivity{

    private static final String TAG = MuseumsActivity.class.getSimpleName();

    ArrayList<Place> places = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_container);

        /* Setup List of Attractions */
        try {
            places.add(new Place("Acropolis Museum", R.drawable.museum_acropolis, "food", 9.5f, 45456, "", 37.971515, 23.725735));
            places.add(new Place("Benaki Museum", R.drawable.museum_benaki, "food", 9.7f, 654544, "", 37.969291, 23.733095));
            places.add(new Place("National Archaeological Museum", R.drawable.museum_national_archaeological, "food", 7.1f, 456456, "", 37.970679, 23.729427));
            places.add(new Place("War Museum", R.drawable.museum_war, "food", 4.9f, 78676, "", 37.968338, 23.741037));
            places.add(new Place("Numismatic Museum", R.drawable.museum_numismatic, "food", 7.9f, 254196, "", 37.596143, 23.079243));
        }
        catch (Exception e){
            Log.e(TAG, "Error acquiring place object.");
            return;
        }

        listView = (ListView) findViewById(R.id.list_view_places);

        /* Setup a new adapter for our ListView */
        PlaceAdapter adapter = new PlaceAdapter(this, places);
        /* Bind adapter to our ListView */
        listView.setAdapter(adapter);
    }
}
