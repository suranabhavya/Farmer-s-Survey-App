package com.tiet.surveyapp.WeeklySurveyForm2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tiet.surveyapp.MainActivity;
import com.tiet.surveyapp.PlotTrackerForm.PlotTrackerActivity;
import com.tiet.surveyapp.R;
import com.tiet.surveyapp.WeeklySurveyForm.Model.ImageCaptureModule;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.GeneralInfoGroup;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.ImageCaptureModuleTwo;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.WeeklySurveyTwoData;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import es.dmoral.toasty.Toasty;

public class WeeklySurveyActivity extends AppCompatActivity {
    VerticalStepperFormView verticalStepperFormView;
    GeneralInfoGroup generalInfoGroup;
    ImageCaptureModule imageCaptureModule;
    ImageCaptureModuleTwo imageCaptureModule2;
    String imageName;
    String url1,url2;
    String ImageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_survey);
        verticalStepperFormView = findViewById(R.id.verticalstepperform9);
        imageCaptureModule = new ImageCaptureModule("Plot Photo");
        imageCaptureModule2 = new ImageCaptureModuleTwo("Plot Photo Rows");
        generalInfoGroup = new GeneralInfoGroup("General Info");
        final String[] crop = new String[1];

        List<Step> formSteps = new ArrayList<Step>();
        formSteps.add(0,generalInfoGroup);
        imageCaptureModule.setChoice(101);
        formSteps.add(1,imageCaptureModule);

        formSteps.add(2,imageCaptureModule2);

        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
                WeeklySurveyTwoData.setGeneralInfoGroupData(generalInfoGroup.getStepData());
            crop[0] = generalInfoGroup.getStepData().getCrop();
            GeneralInfoGroup.GeneralInfoGroupData generalInfoGroupData=generalInfoGroup.getStepData();
            generalInfoGroupData.setPlot_pic(url1);
            generalInfoGroupData.setPlot_photo_rows(url2);
            WeeklySurveyTwoData.setGeneralInfoGroupData(generalInfoGroupData);
                Toasty.success(WeeklySurveyActivity.this, "Data Recorded Successfully!", Toast.LENGTH_SHORT, true).show();

                Intent intent = new Intent(WeeklySurveyActivity.this, CropMeasurementActivity.class);
            intent.putExtra("crop_type",generalInfoGroup.getStepData().getCrop());
            startActivity(intent);
            }

            @Override
            public void onCancelledForm() {

            }
        };

        verticalStepperFormView.setup(stepperFormListener,formSteps).init();

    }  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
           if(verticalStepperFormView.getOpenStepPosition()==1){
                imageCaptureModule.SetImageView(photo);
                url1=imageUploadToFirebase(photo);
           }
           else if(verticalStepperFormView.getOpenStepPosition()==2) {
               imageCaptureModule2.SetImageView(photo);
               url2=imageUploadToFirebase(photo);
           }
            Log.d("TEST","101 This gets called");

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
        imageName = WeekSurveyData.getUserID()+ verticalStepperFormView.getOpenStep().getTitle().replaceAll("\\s", "")+ Calendar.getInstance().getTime().toString().trim()+".jpg";

        StorageReference mountainsRef = storageRef.child(imageName);
        UploadTask uploadTask = mountainsRef.putBytes(datanew);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception){
                // Handle unsuccessful Uploads
                Toast.makeText(WeeklySurveyActivity.this,"Picture Upload Failed !",Toast.LENGTH_LONG).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata(); contains file metadata such as size, content-type, etc.
                Toast.makeText(WeeklySurveyActivity.this,"Picture uploaded !",Toast.LENGTH_LONG).show();
                Log.d("TEST",ImageURI);
            }
        });
        ImageURI="gs://tietsurveyapp.appspot.com/"+imageName.replaceAll("\\s", "");
        return ImageURI;
    }
}