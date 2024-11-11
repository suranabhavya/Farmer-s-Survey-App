
package com.tiet.surveyapp.CropDiseaseSurveyForm;

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
import com.tiet.surveyapp.CropDiseaseSurveyForm.Model.CropDamageGroup;
import com.tiet.surveyapp.FarmerDetailsForm.FarmerDetailsActivity;
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

public class CropDiseaseActivity extends AppCompatActivity {
VerticalStepperFormView verticalStepperFormView;
CropDamageGroup cropDamageGroup;
String ImageURI;
String imageName;
ImageCaptureModule imageCaptureModule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_disease);
        verticalStepperFormView = findViewById(R.id.verticalstepperform9);
        cropDamageGroup = new CropDamageGroup("Crop Damage Group");
        imageCaptureModule = new ImageCaptureModule("Crop Damage Example Picture");

        List<Step> formSteps = new ArrayList<>();
        formSteps.add(cropDamageGroup);
        formSteps.add(imageCaptureModule);
        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                CropDamageGroup.CropDamageGroupData cropDamageGroupData= cropDamageGroup.getStepData();
                cropDamageGroupData.setCrop_pic_url(ImageURI);
                DatabaseReference myRef = database.getReference("User ID:"+ FirebaseAuth.getInstance().getUid());
                myRef.child(MainActivity.getFarmerId()).child("Crop Damage Group").child(Calendar.getInstance().getTime().toString().trim()).setValue(cropDamageGroup.getStepData());
                Toasty.success(CropDiseaseActivity.this, "Data Recorded Successfully!", Toast.LENGTH_SHORT, true).show();
                startActivity(new Intent(CropDiseaseActivity.this, MainActivity.class));
            }

            @Override
            public void onCancelledForm() {

            }
        };

        verticalStepperFormView
                .setup(stepperFormListener, formSteps)
                .init();

    }  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
        imageName = WeekSurveyData.getUserID()+ verticalStepperFormView.getOpenStep().getTitle().replaceAll("\\s", "")+Calendar.getInstance().getTime().toString().trim()+".jpg";
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