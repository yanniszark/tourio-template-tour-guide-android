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
            String placeArray[] = getResources().getStringArray(R.array.museum_examples);
            String category = getResources().getString(R.string.category_museum);
            places.add(new Place(placeArray[0], R.drawable.museum_acropolis, category, 9.5f, 45456, "", 37.971515, 23.725735));
            places.add(new Place(placeArray[1], R.drawable.museum_benaki, category, 9.7f, 654544, "", 37.969291, 23.733095));
            places.add(new Place(placeArray[2], R.drawable.museum_national_archaeological, category, 7.1f, 456456, "", 37.970679, 23.729427));
            places.add(new Place(placeArray[3], R.drawable.museum_war, category, 4.9f, 78676, "", 37.968338, 23.741037));
            places.add(new Place(placeArray[4], R.drawable.museum_numismatic, category, 7.9f, 254196, "", 37.596143, 23.079243));
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
