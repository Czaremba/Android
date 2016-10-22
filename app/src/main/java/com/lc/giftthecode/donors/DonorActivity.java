package com.lc.giftthecode.donors;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lc.giftthecode.MainActivity;
import com.lc.giftthecode.R;

public class DonorActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private Button mPickedUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigateToActvitiy();
            }
        });

        mPickedUpButton = (Button) findViewById(R.id.pickedup);
        mPickedUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        getDelivery();
    }

    private void getDelivery(){

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
                addActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addActivity(){
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }

    private void NavigateToActvitiy(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Picked Up?");
        alertDialogBuilder
                .setMessage("Did the volunteer picked up the food donation?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        pickedUp();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    private void pickedUp(){
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }
}
