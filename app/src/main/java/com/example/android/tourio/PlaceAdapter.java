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

    /**
     * {@link PlaceViewHolder} implements ViewHolder design pattern to use with the PlaceAdapter in the ListView
     * for improved performance.
     */

    class PlaceViewHolder {

        private TextView placeNameTextView;
        private ImageView placeImageView;
        private TextView placeRatingTextView;
        private TextView placeNumberOfVisitsTextView;

        public PlaceViewHolder(@NonNull View view) {

            placeNameTextView = (TextView) view.findViewById(R.id.list_item_name);
            placeImageView = (ImageView) view.findViewById(R.id.list_item_image);
            placeRatingTextView = (TextView) view.findViewById(R.id.list_item_rating);
            placeNumberOfVisitsTextView = (TextView) view.findViewById(R.id.list_item_visits);
        }
    }

    public PlaceAdapter(@NonNull Context context, @NonNull List<Place> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /* Get place at current position */
        Place currentPlace = (Place) getItem(position);
        PlaceViewHolder viewHolder;
        /* If there is no recycled view then inflate a new one */
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_place, parent, false);
            viewHolder = new PlaceViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else
            viewHolder = (PlaceViewHolder) convertView.getTag();

        /* Set the place's image */
        viewHolder.placeImageView.setImageResource(currentPlace.getImageResourceId());

        /* Set the place's name */
        viewHolder.placeNameTextView.setText(currentPlace.getName());

        /* Set the place's number of visits */
        viewHolder.placeNumberOfVisitsTextView.setText(String.valueOf(currentPlace.getVisits()));

        /* Set the place's rating */
        TextView placeRating = viewHolder.placeRatingTextView;
        Float rating = currentPlace.getRating();
        placeRating.setText(String.format("%.1f", rating));

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
