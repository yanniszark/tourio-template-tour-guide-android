package com.example.android.tourio;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.rating;

/**
 * Adapter for Place objects.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(@NonNull Context context, @NonNull List<Place> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /* Get place at current position */
        Place currentPlace = (Place) getItem(position);
        /* If there is no recycled view then inflate a new one */
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_place, parent, false);
        }

        /* Set the place's image */
        ImageView placeImage = (ImageView) convertView.findViewById(R.id.list_item_image);
        placeImage.setImageResource(currentPlace.getImageResourceId());

        /* Set the place's name */
        TextView placeName = (TextView) convertView.findViewById(R.id.list_item_name);
        placeName.setText(currentPlace.getName());

        /* Set the place's number of visits */
        TextView placeNumberOfVisits = (TextView) convertView.findViewById(R.id.list_item_visits);
        placeNumberOfVisits.setText(String.valueOf(currentPlace.getVisits()));

        /* Set the place's rating */
        TextView placeRating = (TextView) convertView.findViewById(R.id.list_item_rating);
        Float rating = currentPlace.getRating();
        placeRating.setText(String.format("%.2f", rating));

        /* Modify rating background color according to rating value */
        if (rating < 5)
            placeRating.setBackgroundResource(R.drawable.rounded_rectangle_red);
        else if (rating < 7.5)
            placeRating.setBackgroundResource(R.drawable.rounded_rectangle_orange);
        else if (rating <= 10)
            placeRating.setBackgroundResource(R.drawable.rounded_rectangle_green);

        return convertView;
    }
}
