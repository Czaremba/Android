package com.lc.giftthecode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lc.giftthecode.donors.DonorActivity;

public class MainActivity extends AppCompatActivity {

    private Button mSignin;

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
    }

    private void NavigateToActvitiy(){
        Intent intent = new Intent(this, DonorActivity.class);
        startActivity(intent);
    }
}
