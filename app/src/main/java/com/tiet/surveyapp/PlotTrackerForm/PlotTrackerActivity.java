package com.tiet.surveyapp.PlotTrackerForm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tiet.surveyapp.FarmerDetailsForm.FarmerDetailsActivity;
import com.tiet.surveyapp.MainActivity;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotBasicInfo;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotDripGroup;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotGroup;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotIrrigationGroup;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotPastGroup;
import com.tiet.surveyapp.PlotTrackerForm.Model.PlotTrackerData;
import com.tiet.surveyapp.PlotTrackerForm.Model.PumpGroup;
import com.tiet.surveyapp.PlotTrackerForm.Model.WaterSourceGroup;
import com.tiet.surveyapp.R;
import com.tiet.surveyapp.WeeklySurveyForm.Model.ImageCaptureModule;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;
import com.tiet.surveyapp.WeeklySurveyForm2.CropMeasurementActivity;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.ImageCaptureModuleThree;
import com.tiet.surveyapp.WeeklySurveyForm2.Model.ImageCaptureModuleTwo;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import es.dmoral.toasty.Toasty;

public class PlotTrackerActivity extends AppCompatActivity {
VerticalStepperFormView verticalStepperFormView;
PlotBasicInfo plotBasicInfo;
PlotDripGroup plotDripGroup;
PlotIrrigationGroup plotIrrigationGroup;
PumpGroup pumpGroup;
PlotPastGroup plotPastGroup;
WaterSourceGroup waterSourceGroup;
PlotGroup plotGroup;
String imageName,ImageURI;
String url1,url2,url3;
ImageCaptureModule imageCaptureModule;
ImageCaptureModuleTwo imageCaptureModuleTwo;
ImageCaptureModuleThree imageCaptureModuleThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot_tracker);
        verticalStepperFormView = findViewById(R.id.verticalstepperform9);
        plotBasicInfo = new PlotBasicInfo("Plot Basic Info");
        plotDripGroup = new PlotDripGroup("Plot Drip Group");
        plotIrrigationGroup = new PlotIrrigationGroup("Plot Irrigation Group");
        pumpGroup = new PumpGroup("Pump Group");
        plotPastGroup = new PlotPastGroup("Plot Past Group");
        waterSourceGroup = new WaterSourceGroup("Water Source Group");
        plotGroup = new PlotGroup("Plot Group");
        imageCaptureModule = new ImageCaptureModule("Water Source Picture");
        imageCaptureModuleTwo = new ImageCaptureModuleTwo("Water Pump Picture");
        imageCaptureModuleThree = new ImageCaptureModuleThree("Water Pump Specification Picture");

        List<Step> formSteps = new ArrayList<Step>();
        formSteps.add(plotBasicInfo);
        formSteps.add(plotGroup);
        formSteps.add(plotIrrigationGroup);
        formSteps.add(plotDripGroup);
        formSteps.add(plotPastGroup);
        formSteps.add(waterSourceGroup);
        formSteps.add(imageCaptureModule);
        formSteps.add(pumpGroup);
        formSteps.add(imageCaptureModuleTwo);
        formSteps.add(imageCaptureModuleThree);

        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
                WaterSourceGroup.WaterSourceGroupData waterSourceGroupData = waterSourceGroup.getStepData();
                PumpGroup.PumpGroupData pumpGroupData = pumpGroup.getStepData();
                waterSourceGroupData.setWater_pic(url1);
                pumpGroupData.setPump_pic_exmpl(url2);
                pumpGroupData.setPump_spec(url3);
                PlotTrackerData.setPlotBasicInfoData(plotBasicInfo.getStepData());
                PlotTrackerData.setPlotDripGroupData(plotDripGroup.getStepData());
                PlotTrackerData.setPlotGroupData(plotGroup.getStepData());
                PlotTrackerData.setPlotIrrigationGroupData(plotIrrigationGroup.getStepData());
                PlotTrackerData.setPlotPastGroupData(plotPastGroup.getStepData());
                PlotTrackerData.setPumpGroupData(pumpGroupData);
                PlotTrackerData.setWaterSourceGroupData(waterSourceGroupData);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("User ID: "+ FirebaseAuth.getInstance().getUid());
                String temp =  Calendar.getInstance().getTime().toString().trim();
                myRef.child(MainActivity.getFarmerId()).child("Plot Basic Info Data").child(temp).setValue(PlotTrackerData.getPlotBasicInfoData());
                myRef.child(MainActivity.getFarmerId()).child("Plot Group Data").child(temp).setValue(PlotTrackerData.getPlotGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Plot Drip Data").child(temp).setValue(PlotTrackerData.getPlotDripGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Plot Irrigation Data").child(temp).setValue(PlotTrackerData.getPlotIrrigationGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Plot Past Data").child(temp).setValue(PlotTrackerData.getPlotPastGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Plot Pump Group Data").child(temp).setValue(PlotTrackerData.getPumpGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Plot Water Source Data").child(temp).setValue(PlotTrackerData.getWaterSourceGroupData());
                Toasty.success(PlotTrackerActivity.this, "Data Recorded Successfully!", Toast.LENGTH_SHORT, true).show();
                startActivity(new Intent(PlotTrackerActivity.this, MainActivity.class));

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
            if(verticalStepperFormView.getOpenStep().getPosition()==6){
               url1=imageUploadToFirebase(photo);
                 imageCaptureModule.SetImageView(photo);}
            if(verticalStepperFormView.getOpenStep().getPosition()==8){
                url2=imageUploadToFirebase(photo);
                imageCaptureModuleTwo.SetImageView(photo);}
            if(verticalStepperFormView.getOpenStep().getPosition()==9){
               url3= imageUploadToFirebase(photo);
                imageCaptureModuleThree.SetImageView(photo);}
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
                Toast.makeText(PlotTrackerActivity.this,"Picture Upload Failed !",Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata(); contains file metadata such as size, content-type, etc.
                //Toast.makeText(PlotTrackerActivity.this,"Picture uploaded !",Toast.LENGTH_LONG).show();
                Log.d("TEST",ImageURI);
            }
        });
        ImageURI="gs://tietsurveyapp.appspot.com/"+imageName.replaceAll("\\s", "");
        return ImageURI;
    }
}