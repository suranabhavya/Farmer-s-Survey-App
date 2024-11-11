package com.tiet.surveyapp.WeeklySurveyForm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.tiet.surveyapp.R;
import com.tiet.surveyapp.WeeklySurveyForm.Model.BasicSurveyDetails;
import com.tiet.surveyapp.WeeklySurveyForm.Model.ImageCaptureModule;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;

public class BasicSurvey extends AppCompatActivity {

    private VerticalStepperFormView verticalStepperForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_survey);
        verticalStepperForm = findViewById(R.id.vertiicalstepperform1);

        BasicSurveyDetails basicSurveyDetails = new BasicSurveyDetails("Basic Survey Details");
        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
            BasicSurveyDetails.BasicSurveyData basicSurveyData=basicSurveyDetails.getStepData();
                WeekSurveyData.setBasicSurveyData(basicSurveyData);
                if(basicSurveyData.getPlot_status().toString().equals("After Planting")){
                    startActivity(new Intent(BasicSurvey.this,CommonGroup.class));
                }else{
                    startActivity(new Intent(BasicSurvey.this,CommonGroup.class));
                }
            }

            @Override
            public void onCancelledForm() {
            }
        };

        verticalStepperForm.setup(stepperFormListener, basicSurveyDetails).init();
    }


}