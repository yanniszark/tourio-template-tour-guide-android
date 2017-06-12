package com.example.android.tourio;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Fragment adapter to display food and drink fragments
 */

public class FoodDrinkFragmentAdapter extends FragmentPagerAdapter {

    private int mPageCount;
    private String mTabTitles[];

    public FoodDrinkFragmentAdapter(FragmentManager fm, String tabTitles[]) {
        super(fm);
        mTabTitles = tabTitles;
        mPageCount = tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }

    @Override
    public int getCount() {
        return mPageCount;
    }

    @Override
    public Fragment getItem(int position) {
        return FoodDrinkFragment.newInstance(position);
    }
}
