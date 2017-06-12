package com.example.android.tourio;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;

public class PlaceOnItemClickListener implements AdapterView.OnItemClickListener{

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        /* Get item at current position */
        Place mPlace = (Place) parent.getItemAtPosition(position);
        Intent activity = new Intent(view.getContext(),PlaceDetailsActivity.class);
        activity.putExtra("PLACE", new Gson().toJson(mPlace));
        view.getContext().startActivity(activity);
    }
}
