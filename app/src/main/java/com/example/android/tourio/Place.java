package com.example.android.tourio;

import android.location.Location;
import android.support.annotation.NonNull;

/**
 * Class that represents a place in our tour guide app.
 * A {@link Place} can be a tourist attraction, a museum, a restaurant or a coffee place.
 */

public class Place {

    /** Name of the place */
    String mName;

    /** Image of the place */
    int mImageResourceId;

    /** Category of this place (museum, attraction, cafe) */
    String mCategory;

    /** Average rating score for this place */
    Float mRating;

    /** Number of visits in this place */
    int mVisits;

    /** A short description for the place */
    String mDescription;

    /** The place's location */
    Location mPlaceLocation;

    /** Constructor for the Place Object */
    public Place(@NonNull String name, int imageResourceId, @NonNull String category, Float rating, int visits,
                      String description, double latitude, double longitude) throws Exception {

        if ((rating < 0) || (rating > 10))
            throw new Exception("Rating value must be between 0 and 10");

        mName = name;
        mImageResourceId = imageResourceId;
        mCategory = category;
        mRating = rating;
        mVisits = visits;
        mDescription = description;
        mPlaceLocation = new Location(mName);
        mPlaceLocation.setLongitude(longitude);
        mPlaceLocation.setLatitude(latitude);

    }

    /** Get the place name */
    public String getName(){
        return mName;
    }

    /** Get the place image */
    public int getImageResourceId(){
        return mImageResourceId;
    }

    /** Get the place category */
    public String getCategory(){
        return mCategory;
    }

    /** Get the place's rating */
    public Float getRating() {
        return mRating;
    }

    /** Get the place's number of visits */
    public int getVisits() {
        return mVisits;
    }

    /** Get the place's description */
    public String getDescription() {
        return mDescription;
    }

    /** Get the place's location */
    public Location getPlaceLocation() {
        return mPlaceLocation;
    }
}
