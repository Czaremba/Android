package com.lc.giftthecode.donors;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.lc.giftthecode.R;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Button mSetTime;
    private Button mSetDate;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private String mDateString = "";
    private String mTimeString = "";
    private boolean mIsDateSet = false;
    private boolean mIsTimeSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mSetDate = (Button) findViewById(R.id.btn_date_picker);
        mSetTime = (Button) findViewById(R.id.btn_time_picker);

        mSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        mSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker();
            }
        });

        setUpToolbar();
    }

    private void setUpToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.donor_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                sendDeliveries();
                return true;
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void sendDeliveries() {
        finish();
    }

    private void showTimePicker(){
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mTimeString = hourOfDay +  ":" + minute;
                        mSetTime.setText(hourOfDay + ":" + minute);

                        mIsTimeSet = true;
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void showDatePicker(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDateString = (monthOfYear + 1) + "/" + dayOfMonth  + "/" + year;
                mSetDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                mIsDateSet = true;
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
