package com.example.devas.lab3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by devas on 9/19/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int count;

    MovieData movieData = new MovieData();
   Movie_details_fragment movie_details_fragment;
    public ViewPagerAdapter(FragmentManager fm, int size) {
        super(fm);
        count = size;
    }

    @Override
    public Fragment getItem(int position)
    {

        return movie_details_fragment.newInstance((HashMap<String,?>)movieData.getItem(position));
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        Locale l = Locale.getDefault();
        HashMap<String, ?>movie = (HashMap<String, ?>)movieData.getItem(position);
        String name =  (String)movie.get("name");
        return name.toUpperCase(l);
    }
}
