package com.example.android.tourio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    FrameLayout buttonPlaceOfTheDay;
    FrameLayout buttonAttractions;
    FrameLayout buttonMuseums;
    FrameLayout buttonFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Hide android action bar */

        setContentView(R.layout.activity_main);
        try {
            getSupportActionBar().hide();
        } catch (NullPointerException npe) {
            Log.d(TAG, "ActionBar returned null pointer, continuing anyway...");
        }

        /* Setup the menu buttons */
        buttonPlaceOfTheDay = (FrameLayout) findViewById(R.id.imageview_main_menu_place_of_the_day);
        buttonPlaceOfTheDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlaceOfTheDayActivity.class);
                startActivity(i);
            }
        });

        buttonAttractions = (FrameLayout) findViewById(R.id.imageview_main_menu_attractions);
        buttonAttractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AttractionsActivity.class);
                startActivity(i);
            }
        });

        buttonMuseums = (FrameLayout) findViewById(R.id.imageview_main_menu_museums);
        buttonMuseums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MuseumsActivity.class);
                startActivity(i);
            }
        });

        buttonFood = (FrameLayout) findViewById(R.id.imageview_main_menu_food);
        buttonFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(i);
            }
        });
    }


}
