package com.giphy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.giphy.Adapter.FragPageAdapter;
import com.giphy.Database.GifsDB;
import com.giphy.Fragment.FavTrendingGifFragment;
import com.giphy.Fragment.TrendingGifFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    private GifsDB gifsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.viewPager);
        addpages(vp);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
    }

    //add all pages
    private void addpages(final ViewPager pager) {
        FragPageAdapter adapter = new FragPageAdapter(getSupportFragmentManager());
        adapter.addPage(new TrendingGifFragment());
        adapter.addPage(new FavTrendingGifFragment());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pager.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}

