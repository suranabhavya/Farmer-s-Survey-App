package com.tiet.surveyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.tiet.surveyapp.CropDiseaseSurveyForm.CropDiseaseActivity;
import com.tiet.surveyapp.FarmerDetailsForm.FarmerDetailsActivity;
import com.tiet.surveyapp.PlotTrackerForm.PlotTrackerActivity;
import com.tiet.surveyapp.WeeklySurveyForm.BasicSurvey;
import com.tiet.surveyapp.WeeklySurveyForm2.WeeklySurveyActivity;

public class MainActivity extends AppCompatActivity {
    static String farmerId;

    public static String getFarmerId() {
        return farmerId;
    }

    public static void setFarmerId(String farmerId) {
        MainActivity.farmerId = farmerId;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.developer_info:
                startActivity(new Intent(MainActivity.this,DeveloperInfo.class));
                break;

            case R.id.action_add:
                //signout
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,SplashScreen.class));
                break;


        }
        return true;
    }
    public boolean DisplayDialogBox(Intent intent){
        final boolean[] tempValue = {true};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Farmer ID (Whose field you are surveying)");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("Start Survey", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                farmerId = input.getText().toString();
                startActivity(intent);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tempValue[0] = false;
                dialog.cancel();
            }
        });

        builder.show();
        return tempValue[0];
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.weekly_forrm1);
        Button farmSnap = findViewById(R.id.weekly_forrm2);
        Button farmersProfile = findViewById(R.id.weekly_forrm);
        Button cropDetails = findViewById(R.id.weekly_forrm3);
        Button plotTracker = findViewById(R.id.weekly_forrm4);
        Button cropDisease = findViewById(R.id.weekly_forrm5);

        cropDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, CropDiseaseActivity.class);
                DisplayDialogBox(intent);
            }
        });
        plotTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, PlotTrackerActivity.class);
                DisplayDialogBox(intent);
            }
        });
        cropDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, WeeklySurveyActivity.class);
                DisplayDialogBox(intent);
            }
        });

        farmersProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FarmerDetailsActivity.class);
                DisplayDialogBox(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicSurvey.class);
                DisplayDialogBox(intent);
            }
        });

        farmSnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this,FieldPhotoActivity.class);
                DisplayDialogBox(intent);
            }
        });
    }
}