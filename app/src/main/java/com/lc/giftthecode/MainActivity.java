package com.lc.giftthecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.lc.giftthecode.volunteer.VolunteerActivity;
import com.lc.giftthecode.volunteer.VolunteeringBlank;
import com.lc.giftthecode.apply.ApplySelection;
import com.lc.giftthecode.donors.DonorActivity;

public class MainActivity extends AppCompatActivity {

    private Button mSignin;
    private Button mApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignin = (Button) findViewById(R.id.signin);

        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigateToActvitiy();
            }
        });

        mApply = (Button) findViewById(R.id.apply);

        mApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply();
            }
        });
    }

    private void NavigateToActvitiy(){
        Intent intent = new Intent(this, VolunteerActivity.class);
        startActivity(intent);
    }

    private void apply(){
        Intent intent = new Intent(this, ApplySelection.class);
        startActivity(intent);
    }
}
