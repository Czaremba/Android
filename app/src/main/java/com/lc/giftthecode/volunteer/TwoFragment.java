package com.lc.giftthecode.volunteer;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ContentFrameLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.lc.giftthecode.R;

import java.util.ArrayList;


public class TwoFragment extends Fragment {

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.listoffood, container, false);
        ArrayList<SearchResults> searchResults = GetSearchResults();
        final ListView lv = (ListView) v.findViewById(R.id.listview);
        lv.setAdapter(new MyCustomBaseAdapter(getActivity(), searchResults));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, android.view.View view, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                SearchResults fullObject = (SearchResults) o;
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity()).setMessage("Are you sure you want to take on this job?").setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getActivity(), "YESS!!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = Toast.makeText(getActivity(), "NO!!!", Toast.LENGTH_LONG);
                                toast.show();
                            }
                        });
                dialog.show();
            }
        });
        return v;
    }

    private ArrayList<SearchResults> GetSearchResults() {
        ArrayList<SearchResults> results = new ArrayList<SearchResults>();

        SearchResults sr = new SearchResults();
        sr.setDonorName("Justin Schultz");
        sr.setFood("San Francisco, CA");
        sr.setLocation("415-555-1234");
        sr.setTime("");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Jane Doe");
        sr.setFood("Las Vegas, NV");
        sr.setLocation("702-555-1234");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Lauren Sherman");
        sr.setFood("San Francisco, CA");
        sr.setLocation("415-555-1234");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Fred Jones");
        sr.setFood("Minneapolis, MN");
        sr.setLocation("612-555-8214");
        results.add(sr);

        sr = new SearchResults();
        sr.setDonorName("Bill Withers");
        sr.setFood("Los Angeles, CA");
        sr.setLocation("424-555-8214");
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
}