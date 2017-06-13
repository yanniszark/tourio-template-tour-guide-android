package com.example.android.tourio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

// In this case, the fragment displays simple text based on the page
public class FoodDrinkFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    private static final String TAG = FoodDrinkFragment.class.getSimpleName();

    private int mPage;
    ArrayList<Place> places = new ArrayList<>();
    ListView listView;

    public static FoodDrinkFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FoodDrinkFragment fragment = new FoodDrinkFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_container, container, false);

        if (mPage == 0) {
        /* Setup List of Attractions */
            try {
                String placeArray[] = getResources().getStringArray(R.array.food_examples);
                String category = getResources().getString(R.string.category_food);
                places.add(new Place(placeArray[0], R.drawable.food_anafiotika, category, 9.5f, 9451752, "", 37.971515, 23.725735));
                places.add(new Place(placeArray[1], R.drawable.food_falafellas,category, 9.7f, 10000000, "", 37.969291, 23.733095));
                places.add(new Place(placeArray[2], R.drawable.food_kebab_thanasis, category, 7.1f, 10000000, "", 37.970679, 23.729427));
                places.add(new Place(placeArray[3], R.drawable.food_mirch, category, 7.9f, 254196, "", 37.596143, 23.079243));
                places.add(new Place(placeArray[4], R.drawable.food_souvlaki_savvas, category, 4.9f, 10000000, "", 37.968338, 23.741037));
            } catch (Exception e) {
                Log.e(TAG, "Error acquiring place object.");
                return view;
            }
        }
        else if (mPage == 1){
            try {
                String placeArray[] = getResources().getStringArray(R.array.drink_examples);
                String category = getResources().getString(R.string.category_drink);
                places.add(new Place(placeArray[0], R.drawable.drink_360_bar, category, 9.5f, 9451752, "", 37.971515, 23.725735));
                places.add(new Place(placeArray[1], R.drawable.drink_a_for_athens, category, 9.7f, 10000000, "", 37.969291, 23.733095));
                places.add(new Place(placeArray[2], R.drawable.drink_baba_au_rum, category, 7.1f, 10000000, "", 37.970679, 23.729427));
                places.add(new Place(placeArray[3], R.drawable.drink_six_dogs, category, 7.9f, 254196, "", 37.596143, 23.079243));
            } catch (Exception e) {
                Log.e(TAG, "Error acquiring place object.");
                return view;
            }
        }

        listView = (ListView) view.findViewById(R.id.list_view_places);

        /* Setup a new adapter for our ListView */
        PlaceAdapter adapter = new PlaceAdapter(getContext(), places);
        /* Bind adapter to our ListView */
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new PlaceOnItemClickListener());
        return view;
    }
}