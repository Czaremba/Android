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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lc.giftthecode.MainActivity;
import com.lc.giftthecode.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DonorActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    private Button mPickedUpButton;
    private final OkHttpClient client = new OkHttpClient();

    private TextView mDonorName;
    private TextView mDonorFood;
    private TextView mDonorLocation;
    private TextView mDonorSchedule;

    private ImageView mImageRespond;
    private ImageView mImagePickUp;
    private ImageView mImageAgency;



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

        mDonorName = (TextView) findViewById(R.id.donorname);
        mDonorFood = (TextView) findViewById(R.id.donorfood);
        mDonorLocation = (TextView) findViewById(R.id.donorlocation);
        mDonorSchedule = (TextView) findViewById(R.id.donorschedule);

        mImageRespond = (ImageView) findViewById(R.id.respond);
        mImageAgency = (ImageView) findViewById(R.id.agency);
        mImagePickUp = (ImageView) findViewById(R.id.pickup);

        getDelivery();
    }

    private void getDelivery(){
        Request request = new Request.Builder()
                .url(getString(R.string.BASE_URL) + "/donor/getdelivery")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                DonorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(DonorActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                DonorActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String responseData = response.body().string();
                            JSONObject json = new JSONObject(responseData);
                            mDonorName.setText(json.getString("donor"));
                            mDonorFood.setText(json.getString("food"));
                            mDonorLocation.setText(json.getString("location"));
                            mDonorSchedule.setText(json.getString("time"));

                            setUpUI(json.getInt("time"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        });
    }

    private void setUpUI(int status){
        if(status == 0){
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.onwayoff));
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.orderoff));
            mImageRespond.setImageDrawable(getDrawable(R.drawable.completeoff));
        } else if (status == 1){
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.onway));
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.orderoff));
            mImageRespond.setImageDrawable(getDrawable(R.drawable.completeoff));
        } else if (status == 2){
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.onway));
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.order));
            mImageRespond.setImageDrawable(getDrawable(R.drawable.completeoff));
        } else if (status == 3){
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.onway));
            mImagePickUp.setImageDrawable(getDrawable(R.drawable.order));
            mImageRespond.setImageDrawable(getDrawable(R.drawable.complete));
        }
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
