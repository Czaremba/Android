package com.lc.giftthecode.apply;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lc.giftthecode.R;
import com.lc.giftthecode.donors.AddActivity;

public class ApplySelection extends AppCompatActivity {

    private Button mDonor;
    private Button mVolunteer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_selection);
        setUpToolbar();

        mDonor = (Button) findViewById(R.id.buttondonate);
        mVolunteer = (Button) findViewById(R.id.buttonvolunteer);

        mDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyDonor();
            }
        });

        mVolunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyVolunteer();
            }
        });
    }

    private void setUpToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void applyDonor(){
        Intent intent = new Intent(this, ApplyDonateActivity.class);
        startActivity(intent);
    }

    private void applyVolunteer(){
        Intent intent = new Intent(this, ApplyVolunteerActivity.class);
        startActivity(intent);
    }

}
