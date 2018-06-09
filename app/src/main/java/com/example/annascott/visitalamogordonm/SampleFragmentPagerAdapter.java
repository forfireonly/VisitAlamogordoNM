package com.example.annascott.visitalamogordonm;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.annascott.visitalamogordonm.CalendarFragment;
import com.example.annascott.visitalamogordonm.DiningFragment;
import com.example.annascott.visitalamogordonm.ExperienceFragment;
import com.example.annascott.visitalamogordonm.LodgingFragment;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Sights", "Dining", "Lodging", "Events" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ExperienceFragment();
        } else if (position == 1){
            return new DiningFragment();
        } else if (position ==2){
            return new LodgingFragment();
        }else {return new CalendarFragment();}
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}