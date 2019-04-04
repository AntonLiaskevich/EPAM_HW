package com.example.user.epam_hw;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "New Episodes", "In progress", "Downloads" };

    ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
    }

    @Override public int getCount() {
        return 3;
    }

    @Override public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewEpisodesFragment.newInstance(position + 1);
            case 1:
                return ProgressFragmentIn.newInstance(position + 1);
            case 2:
                return DownloadsFragment.newInstance(position + 1);
        }
        return null;
    }

    @Override public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}