package com.example.android.tourio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class PlaceOfTheDayActivity extends AppCompatActivity{

    private static final String TAG = PlaceOfTheDayActivity.class.getSimpleName();

    ImageView placeImage;
    TextView placeName;
    TextView placeCategory;
    TextView placeRating;
    TextView placeDescription;
    FloatingActionButton showLocation;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_the_day);

        final Place placeOfTheDay;
        try {
            placeOfTheDay = new Place("Juicy Burger", R.drawable.place_of_the_day_juicy_burger,
                    "food", 9.8f, 56451218, "", 37.998753, 23.800050);
        }
        catch (Exception e){
            Log.e(TAG , "Error acquiring placeOfTheDay object.");
            return;
        }

        /* Setup place's details */
        placeImage = (ImageView) findViewById(R.id.imageview_place_image);
        placeImage.setImageResource(placeOfTheDay.getImageResourceId());

        placeName = (TextView) findViewById(R.id.textview_place_name);
        placeName.setText(placeOfTheDay.getName());

        placeCategory = (TextView) findViewById(R.id.textview_place_category);
        placeCategory.setText(placeOfTheDay.getCategory());

        placeRating = (TextView) findViewById(R.id.textview_place_rating);
        Float rating = placeOfTheDay.getRating();
        placeRating.setText(String.format("%.1f", rating));

        /* Modify rating background color according to rating value */
        if (rating < 5)
            placeRating.setBackgroundResource(R.drawable.rounded_rectangle_red);
        else if (rating < 7.5)
            placeRating.setBackgroundResource(R.drawable.rounded_rectangle_orange);
        else if (rating <= 10)
            placeRating.setBackgroundResource(R.drawable.rounded_rectangle_green);

        showLocation = (FloatingActionButton) findViewById(R.id.floating_action_button_show_location);
        showLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = placeOfTheDay.getPlaceLocation().getLatitude();
                double longitude = placeOfTheDay.getPlaceLocation().getLongitude();
                String label = placeOfTheDay.getPlaceLocation().getProvider();;
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
