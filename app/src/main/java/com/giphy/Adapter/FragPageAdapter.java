package com.giphy.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.giphy.Fragment.FavTrendingGifFragment;

import java.util.ArrayList;

/**
 * Created by ND on 2018-01-19.
 */

public class FragPageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pages= new ArrayList<Fragment>();

    public FragPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
    public void addPage(Fragment fragment)
    {
        pages.add(fragment);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pages.get(position).toString();
    }
    @Override
    public int getItemPosition(Object object) {
// POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_NONE;
    }

}
