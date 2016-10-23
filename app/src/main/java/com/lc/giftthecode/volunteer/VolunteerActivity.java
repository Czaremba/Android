package com.lc.giftthecode.volunteer;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.lc.giftthecode.R;

import java.util.ArrayList;
import java.util.List;


public class VolunteerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tablayout = (TabLayout) findViewById(R.id.tabs);

        tablayout.setupWithViewPager(viewPager);}



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Unassigned Food Pickups");
        adapter.addFragment(new TwoFragment(), "Food Pickups I'm Assigned");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
            viewPager.setAdapter(adapter);
        }else{
            AlertDialog.Builder dialog1 = new AlertDialog.Builder(VolunteerActivity.this).setMessage("Your version of Android is too old to run this App properly, Please update to a newer version and try again");
            dialog1.show();
        }
    }}

class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }



}