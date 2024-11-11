package com.tiet.surveyapp.FarmerDetailsForm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tiet.surveyapp.FarmerDetailsForm.Model.FarmerProfileGroup;
import com.tiet.surveyapp.FieldPhotoActivity;
import com.tiet.surveyapp.MainActivity;
import com.tiet.surveyapp.R;
import com.tiet.surveyapp.WeeklySurveyForm.Model.ImageCaptureModule;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import es.dmoral.toasty.Toasty;

public class FarmerDetailsActivity extends AppCompatActivity {
    VerticalStepperFormView verticalStepperFormView;
    ImageCaptureModule imageCaptureModule;
    String ImageURI;
    String imageName;
    FarmerProfileGroup.FarmerProfileGroupData farmerProfileGroupData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_details);
        verticalStepperFormView = findViewById(R.id.verticalstepperform9);
        List<Step> formSteps = new ArrayList<Step>();
        FarmerProfileGroup farmerProfileGroup = new FarmerProfileGroup("Farmer's Details");
        formSteps.add(farmerProfileGroup);
        imageCaptureModule = new ImageCaptureModule("Farmer's Image");

        formSteps.add(imageCaptureModule);
        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
            farmerProfileGroupData=farmerProfileGroup.getStepData();
            farmerProfileGroupData.setFarmer_pic_url(ImageURI);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("User ID:"+FirebaseAuth.getInstance().getUid());
                myRef.child(MainActivity.getFarmerId()).child("Farmer's Profile Group").child(Calendar.getInstance().getTime().toString().trim()).setValue(farmerProfileGroupData);
                Toasty.success(FarmerDetailsActivity.this, "Data Recorded Successfully!", Toast.LENGTH_SHORT, true).show();
                startActivity(new Intent(FarmerDetailsActivity.this,MainActivity.class));
            }

            @Override
            public void onCancelledForm() {
                Toasty.error(FarmerDetailsActivity.this,"Data not Recorded !!",Toasty.LENGTH_SHORT,true).show();
            }
        };

        verticalStepperFormView.setup(stepperFormListener, formSteps).init();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageCaptureModule.SetImageView(photo);
            imageUploadToFirebase(photo);
            Log.d("TEST","This gets called");
        }
    }
    public void imageUploadToFirebase(Bitmap bmp){
        // Create a Cloud Storage reference from the app
        StorageReference storageRef;
        FirebaseStorage storage = FirebaseStorage.getInstance("gs://tietsurveyapp.appspot.com");
        storageRef =  storage.getReference();
        Bitmap bitmap = bmp;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] datanew= baos.toByteArray();
        imageName = FirebaseAuth.getInstance().getUid() + verticalStepperFormView.getOpenStep().getTitle().replaceAll("\\s", "")+Calendar.getInstance().getTime().toString().trim()+".jpg";
        ImageURI="gs://tietsurveyapp.appspot.com/"+imageName.replaceAll("\\s", "");

        StorageReference mountainsRef = storageRef.child(imageName);
        UploadTask uploadTask = mountainsRef.putBytes(datanew);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception){
                // Handle unsuccessful Uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata(); contains file metadata such as size, content-type, etc.
                // Toast.makeText(FarmerDetailsActivity.this,"Picture uploaded !",Toast.LENGTH_LONG).show();
               Log.d("TEST",ImageURI);
            }
        });

    }
}