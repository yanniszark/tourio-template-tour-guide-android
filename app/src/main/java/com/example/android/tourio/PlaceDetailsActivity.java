package com.example.android.tourio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

/**
 * Place detail screen that is entered when a user clicks on a place list entry.
 */

public class PlaceDetailsActivity extends AppCompatActivity {
    private static final String TAG = PlaceOfTheDayActivity.class.getSimpleName();

    ImageView placeImage;
    TextView placeName;
    TextView placeCategory;
    TextView placeRating;
    TextView placeDescription;
    FloatingActionButton showLocation;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_of_the_day);
        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        final Place place;

        String jsonMyObject;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonMyObject = extras.getString("PLACE");
            place = new Gson().fromJson(jsonMyObject, Place.class);
        }
        else
            return;


        /* Setup place's details */
        placeImage = (ImageView) findViewById(R.id.imageview_place_image);
        placeImage.setImageResource(place.getImageResourceId());

        placeName = (TextView) findViewById(R.id.textview_place_name);
        placeName.setText(place.getName());
        getSupportActionBar().setTitle(place.getName());

        placeCategory = (TextView) findViewById(R.id.textview_place_category);
        placeCategory.setText(place.getCategory());

        placeRating = (TextView) findViewById(R.id.textview_place_rating);
        Float rating = place.getRating();
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
                double latitude = place.getPlaceLocation().getLatitude();
                double longitude = place.getPlaceLocation().getLongitude();
                String label = place.getPlaceLocation().getProvider();
                ;
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
