package com.example.android.tourio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Activity containing suggested attractions
 */



public class AttractionsActivity extends AppCompatActivity{

    private static final String TAG = AttractionsActivity.class.getSimpleName();

    ArrayList<Place> places = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_container);

        /* Setup List of Attractions */
        try {
            String placeArray[] = getResources().getStringArray(R.array.attraction_examples);
            String category = getResources().getString(R.string.category_attraction);
            places.add(new Place(placeArray[0], R.drawable.attraction_acropolis, category, 9.4f, 9451752, "", 37.971515, 23.725735));
            places.add(new Place(placeArray[1], R.drawable.attraction_temple_of_olympian_zeus, category, 9.1f, 10000000, "", 37.969291, 23.733095));
            places.add(new Place(placeArray[2], R.drawable.attraction_plaka, category, 9.3f, 10000000, "", 37.970679, 23.729427));
            places.add(new Place(placeArray[3], R.drawable.attraction_epidaurus_theater, category, 8.9f, 254196, "", 37.596143, 23.079243));
            places.add(new Place(placeArray[4], R.drawable.attraction_kallimarmaro, category, 7.2f, 10000000, "", 37.968338, 23.741037));
            places.add(new Place(placeArray[5], R.drawable.attraction_lekavittos_hill_theater, category, 8.5f, 10000000, "", 37.981849, 23.743398));
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
        listView.setOnItemClickListener(new PlaceOnItemClickListener());
    }



}
