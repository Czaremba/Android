package com.lc.giftthecode.volunteer;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.lc.giftthecode.MainActivity;
import com.lc.giftthecode.R;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

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

        tablayout.setupWithViewPager(viewPager);
        //ArrayList<SearchResults> searchResults = GetSearchResults();
        //final ListView lv = (ListView) findViewById(R.id.listview);
        //lv.setAdapter(new MyCustomBaseAdapter(this, searchResults));


       // lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @Override
            //public void onItemClick(AdapterView<?> a, View v, int position, long id) {
              //  Object o = lv.getItemAtPosition(position);
               // SearchResults fullObject = (SearchResults)o;
                AlertDialog.Builder dialog = new AlertDialog.Builder(VolunteerActivity.this).setMessage("Are you sure you want to take on this job?").setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(VolunteerActivity.this, "YESS!!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = Toast.makeText(VolunteerActivity.this, "NO!!!", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        });
                dialog.show();
            }

    //private ArrayList<SearchResults> GetSearchResults(){
       // ArrayList<SearchResults> results = new ArrayList<SearchResults>();

        //SearchResults sr = new SearchResults();
        //sr.setDonorName("Starbucks");
        //sr.setFood("Sandwiches: 10lb");
        //sr.setLocation("200 Bay St, Toronto");
        //sr.setTime("Time For Pickup: 2:30pm");
        //results.add(sr);

        /*sr = new SearchResults();
        sr.setDonorName("Kensington Market");
        sr.setFood("Vegetables: 75lb, Meat: 50lb, Dried Foods: 40lb");
        sr.setLocation("Kensington Ave, Toronto");
        sr.setTime("Time For Pickup: 7:00pm");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Tim Hortons");
        sr.setFood("Baked Goods: 25lb, Bread: 30lb");
        sr.setLocation("Simcoe Place, 340 Front St W, Toronto");
        sr.setTime("Time For Pickup: 3:45pm");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("McDonald's");
        sr.setFood("Poultry: 50lb, Baked Goods: 10lb");
        sr.setLocation("675 Yonge St, Toronto");
        sr.setTime("Time For Pickup: 4:20pm");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Luciano's No Frills");
        sr.setFood("Beef - 20lb, Vegetables - 45lb");
        sr.setLocation("200 Front St E, Toronto");
        sr.setTime("Time For Pickup: 6:30pm");
        results.add(sr);



        sr = new SearchResults();
        sr.setDonorName("Donald Fagen");
        sr.setFood("Los Angeles, CA");
        sr.setLocation("424-555-1234");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Steve Rude");
        sr.setFood("Oakland, CA");
        sr.setLocation("515-555-2222");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Roland Bloom");
        sr.setFood("Chelmsford, MA");
        sr.setLocation("978-555-1111");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Sandy Baguskas");
        sr.setFood("Chelmsford, MA");
        sr.setLocation("978-555-2222");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Scott Taylor");
        sr.setFood("Austin, TX");
        sr.setLocation("512-555-2222");
        results.add(sr);

        return results;
    }
    */


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Unassigned Food Pickups");
        adapter.addFragment(new TwoFragment(), "Food Pickups I'm Assigned");
        viewPager.setAdapter(adapter);
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