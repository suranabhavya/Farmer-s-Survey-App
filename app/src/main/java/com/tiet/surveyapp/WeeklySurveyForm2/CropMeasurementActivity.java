package com.tiet.surveyapp.WeeklySurveyForm2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tiet.surveyapp.MainActivity;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotTrackerData;
import com.tiet.surveyapp.PlotTrackerForm.PlotTrackerActivity;
import com.tiet.surveyapp.R;
import com.tiet.surveyapp.WeeklySurveyForm.Model.ImageCaptureModule;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.ImageCaptureModuleThree;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.ImageCaptureModuleTwo;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.RiceGroup;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.WeeklySurveyTwoData;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.WheatGroup;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import es.dmoral.toasty.Toasty;

public class CropMeasurementActivity extends AppCompatActivity {
    VerticalStepperFormView verticalStepperFormView;
    RiceGroup riceGroup;
    WheatGroup wheatGroup;
    String cropSelected;
    String imageName;
    String ImageURI;
    String url1,url2,url3;
    ImageCaptureModule imageCaptureModule;
    ImageCaptureModuleTwo imageCaptureModuleTwo;
    ImageCaptureModuleThree imageCaptureModuleThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_measurement);
        verticalStepperFormView = findViewById(R.id.verticalstepperform9);
        cropSelected = String.valueOf(getIntent().getStringExtra("crop_type"));
        riceGroup = new RiceGroup("Rice Crop Details");
        wheatGroup = new WheatGroup("Wheat Crop Details");

        List<Step> formSteps = new ArrayList<Step>();

        if(cropSelected.equalsIgnoreCase("rice")){
            formSteps.add(riceGroup);
            imageCaptureModule = new ImageCaptureModule("Rice Plant Photo");
            imageCaptureModuleTwo = new ImageCaptureModuleTwo("Rice Leaf Photo");
            imageCaptureModuleThree = new ImageCaptureModuleThree("Rice Flower Photo");
        }else{
            formSteps.add(wheatGroup);
            imageCaptureModule = new ImageCaptureModule("Wheat Plant Photo");
            imageCaptureModuleTwo = new ImageCaptureModuleTwo("Wheat Leaf Photo");
            imageCaptureModuleThree = new ImageCaptureModuleThree("Wheat Spike Photo");
        }
        formSteps.add(imageCaptureModule);
        formSteps.add(imageCaptureModuleTwo);
        formSteps.add(imageCaptureModuleThree);

        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
                RiceGroup.RiceGroupData riceGroupData;
                WheatGroup.WheatGroupData wheatGroupData;

                if (cropSelected.equalsIgnoreCase("rice")) {
                    riceGroupData = riceGroup.getStepData();
                    riceGroupData.setRice_plant_photo(url1);
                    riceGroupData.setRice_leaf_photo(url2);
                    riceGroupData.setRice_flower_photo(url3);
                    Log.d("TEST","finally url 1 is "+url1);
                    WeeklySurveyTwoData.setRiceGroupData(riceGroupData);
                } else {
                    wheatGroupData = wheatGroup.getStepData();
                    wheatGroupData.setPlant_photo_url(url1);
                    wheatGroupData.setLeaf_photo_url(url2);
                    wheatGroupData.setSpike_photo_url(url3);
                    WeeklySurveyTwoData.setWheatGroupData(wheatGroupData);
                }

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(" User ID: " + FirebaseAuth.getInstance().getUid());
                myRef.child(MainActivity.getFarmerId()).child(Calendar.getInstance().getTime().toString().trim()).child("General Info").setValue(WeeklySurveyTwoData.getGeneralInfoGroupData());
                if (cropSelected.equalsIgnoreCase("rice")) {
                    myRef.child("Rice Group Data").child(Calendar.getInstance().getTime().toString().trim()).setValue(WeeklySurveyTwoData.getRiceGroupData());
                } else {
                    myRef.child("Wheat Group Data").child(Calendar.getInstance().getTime().toString().trim()).setValue(WeeklySurveyTwoData.getWheatGroupData());
                }
                Toasty.success(CropMeasurementActivity.this, "Data Recorded Successfully!", Toast.LENGTH_SHORT, true).show();
                startActivity(new Intent(CropMeasurementActivity.this, MainActivity.class));

            }

            @Override
            public void onCancelledForm() {

            }
        };

        verticalStepperFormView.setup(stepperFormListener,formSteps).init();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            if(verticalStepperFormView.getOpenStep().getPosition()==1){
                imageCaptureModule.SetImageView(photo);
                url1 = imageUploadToFirebase(photo);
                Log.d("TEST","url 1 is "+url3);
            }
            if(verticalStepperFormView.getOpenStep().getPosition()==2){
                imageCaptureModuleTwo.SetImageView(photo);
                url2 = imageUploadToFirebase(photo);
            }
            if(verticalStepperFormView.getOpenStep().getPosition()==3){
                imageCaptureModuleThree.SetImageView(photo);
                 url3 = imageUploadToFirebase(photo);
            }

            Log.d("TEST","This gets called");
        }
    }
    public String imageUploadToFirebase(Bitmap bmp){
        // Create a Cloud Storage reference from the app
        StorageReference storageRef;
        FirebaseStorage storage = FirebaseStorage.getInstance("gs://tietsurveyapp.appspot.com");
        storageRef =  storage.getReference();
        Bitmap bitmap = bmp;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] datanew= baos.toByteArray();
        imageName = WeekSurveyData.getUserID()+ verticalStepperFormView.getOpenStep().getTitle().replaceAll("\\s", "")+Calendar.getInstance().getTime().toString().trim()+".jpg";

        StorageReference mountainsRef = storageRef.child(imageName);
        UploadTask uploadTask = mountainsRef.putBytes(datanew);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception){
                // Handle unsuccessful Uploads
                Toast.makeText(CropMeasurementActivity.this,"Picture Upload Failed !",Toast.LENGTH_LONG).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata(); contains file metadata such as size, content-type, etc.

                Log.d("TEST",ImageURI);
            }
        });
        ImageURI="gs://tietsurveyapp.appspot.com/"+imageName.replaceAll("\\s", "");
        return ImageURI;
    }
}