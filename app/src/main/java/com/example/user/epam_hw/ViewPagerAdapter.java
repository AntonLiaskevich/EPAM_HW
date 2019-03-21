package com.example.user.epam_hw;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "New Episodes", "In progress", "Downloads" };
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override public int getCount() {
        return PAGE_COUNT;
    }

    @Override public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentNewEpisodes.newInstance(position + 1);
            case 1:
                return FragmentInProgress.newInstance(position + 1);
            case 2:
                return FragmentDownloads.newInstance(position + 1);
        }
        return null;
    }

    @Override public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}