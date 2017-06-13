package com.example.android.tourio;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * {@link PlaceViewHolder} implements ViewHolder design pattern to use with the PlaceAdapter in the ListView
 * for improved performance.
 */

public class PlaceViewHolder{

    private TextView placeNameTextView;
    private ImageView placeImageView;
    private TextView placeRating;
    private TextView placeNumberOfVisits;

    public PlaceViewHolder(@NonNull View view){

        placeNameTextView = (TextView) view.findViewById(R.id.list_item_name);
        placeImageView = (ImageView) view.findViewById(R.id.list_item_image);
        placeRating = (TextView) view.findViewById(R.id.list_item_rating);
        placeNumberOfVisits = (TextView) view.findViewById(R.id.list_item_visits);
    }
}


