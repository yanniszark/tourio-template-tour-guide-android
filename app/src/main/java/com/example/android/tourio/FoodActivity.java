package com.example.android.tourio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Activity to display recommended restaurants.
 */

public class FoodActivity extends AppCompatActivity {

    ArrayList<Place> places = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_container);

        /* Setup List of Attractions */
        places.add(new Place("Anafiotika Tavern", R.drawable.food_anafiotika, "food", 9.5f, 9451752, "", 37.971515, 23.725735 ));
        places.add(new Place("Falafellas Falafels", R.drawable.food_falafellas, "food", 9.7f, 10000000, "", 37.969291, 23.733095 ));
        places.add(new Place("Thanassis Kebab", R.drawable.food_kebab_thanasis, "food", 7.1f, 10000000, "", 37.970679, 23.729427 ));
        places.add(new Place("Mirch", R.drawable.food_mirch, "food", 7.9f, 254196, "", 37.596143, 23.079243 ));
        places.add(new Place("Savvas Souvlaki", R.drawable.food_souvlaki_savvas, "food", 4.9f, 10000000, "", 37.968338, 23.741037 ));

        listView = (ListView) findViewById(R.id.list_view_places);

        /* Setup a new adapter for our ListView */
        PlaceAdapter adapter = new PlaceAdapter(this, places);
        /* Bind adapter to our ListView */
        listView.setAdapter(adapter);
    }


}
