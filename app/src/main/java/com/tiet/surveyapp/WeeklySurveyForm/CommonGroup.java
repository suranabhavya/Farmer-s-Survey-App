package com.tiet.surveyapp.WeeklySurveyForm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tiet.surveyapp.MainActivity;
import com.tiet.surveyapp.R;
import com.tiet.surveyapp.WeeklySurveyForm.Model.FertilizerGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.GeneralWork;
import com.tiet.surveyapp.WeeklySurveyForm.Model.HarvestingGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.HerbicideGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.IrrigationGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.LandPreparation;
import com.tiet.surveyapp.WeeklySurveyForm.Model.MachineryGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.MaintenanceGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.MarketingGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.PesticideGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeedingGroup;
import com.tiet.surveyapp.WeeklySurveyForm.Model.WeekSurveyData;
import com.tiet.surveyapp.WeeklySurveyForm2.CropMeasurementActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ernestoyaquello.com.verticalstepperform.Step;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormView;
import ernestoyaquello.com.verticalstepperform.listener.StepperFormListener;
import es.dmoral.toasty.Toasty;

public class CommonGroup extends AppCompatActivity {
    VerticalStepperFormView verticalStepperFormView;
    FertilizerGroup fertilizerGroup;
    HerbicideGroup herbicideGroup;
    GeneralWork generalWork;
    MachineryGroup machineryGroup;
    PesticideGroup pesticideGroup;
    WeedingGroup weedingGroup;
    LandPreparation landPreparation;
    IrrigationGroup irrigationGroup;
    MaintenanceGroup maintenanceGroup;
    HarvestingGroup harvestingGroup;
    MarketingGroup marketingGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_group);
        verticalStepperFormView = findViewById(R.id.verticalstepperform9);
        List<Step> formSteps = new ArrayList<>();
        fertilizerGroup= new FertilizerGroup("Fertilizer Group");
        herbicideGroup = new HerbicideGroup("Herbicide Group");
        generalWork = new GeneralWork("General Work");
        machineryGroup = new MachineryGroup("Machinery Group");
        pesticideGroup = new PesticideGroup("Pesticide Group");
        weedingGroup = new WeedingGroup("Weeding Group");
        landPreparation = new LandPreparation("Land Preparation");
        irrigationGroup= new IrrigationGroup("Irrigation Group");
        maintenanceGroup = new MaintenanceGroup("Maintenance Group");
        harvestingGroup = new HarvestingGroup("Harvesting Group");
        marketingGroup = new MarketingGroup("Marketing Group");

        formSteps.add(landPreparation);
        formSteps.add(fertilizerGroup);
        formSteps.add(herbicideGroup);
        formSteps.add(pesticideGroup);
        formSteps.add(weedingGroup);
        formSteps.add(machineryGroup);
        formSteps.add(irrigationGroup);
        formSteps.add(generalWork);
        formSteps.add(maintenanceGroup);
        formSteps.add(harvestingGroup);
        formSteps.add(marketingGroup);

        StepperFormListener stepperFormListener = new StepperFormListener() {
            @Override
            public void onCompletedForm() {
                // Write a message to the database
                WeekSurveyData.setiRrigationGroupData(irrigationGroup.getStepData());
                WeekSurveyData.setLandPreparationData(landPreparation.getStepData());
                WeekSurveyData.setFertilizerGroupData(fertilizerGroup.getStepData());
                WeekSurveyData.setMachineryGroupData(machineryGroup.getStepData());
                WeekSurveyData.setGeneralWorkData(generalWork.getStepData());
                WeekSurveyData.setHerbicideGroupData(herbicideGroup.getStepData());
                WeekSurveyData.setPesticideGroupData(pesticideGroup.getStepData());
                WeekSurveyData.setWeedingGroupData(weedingGroup.getStepData());
                WeekSurveyData.setHarvestingGroupData(harvestingGroup.getStepData());
                WeekSurveyData.setMaintenanceGroupData(maintenanceGroup.getStepData());
                WeekSurveyData.setMarketingGroupData(marketingGroup.getStepData());
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("User ID:"+ FirebaseAuth.getInstance().getUid());
                String temp = Calendar.getInstance().getTime().toString().trim();
                myRef.child(MainActivity.getFarmerId()).child("Basic Survey Data").child(temp).setValue(WeekSurveyData.getBasicSurveyData());
                myRef.child(MainActivity.getFarmerId()).child("Fertilizer Group Data").child(temp).setValue(WeekSurveyData.getFertilizerGroupData());
                myRef.child(MainActivity.getFarmerId()).child("General Work Data").child(temp).setValue(WeekSurveyData.getGeneralWorkData());
                myRef.child(MainActivity.getFarmerId()).child("Herbicide Group Data").child(temp).setValue(WeekSurveyData.getHerbicideGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Irrigation Group Data").child(temp).setValue(WeekSurveyData.getiRrigationGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Pesticide Group Data").child(temp).setValue(WeekSurveyData.getPesticideGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Land Preparation Data").child(temp).setValue(WeekSurveyData.getLandPreparationData());
                myRef.child(MainActivity.getFarmerId()).child("Machinery Group Data").child(temp).setValue(WeekSurveyData.getMachineryGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Weeding Group Data").child(temp).setValue(WeekSurveyData.getWeedingGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Harvesting Group Data").child(temp).setValue(WeekSurveyData.getHarvestingGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Maintenance Group Data").child(temp).setValue(WeekSurveyData.getMaintenanceGroupData());
                myRef.child(MainActivity.getFarmerId()).child("Marketing Group Data").child(temp).setValue(WeekSurveyData.getMarketingGroupData());
                Toasty.success(CommonGroup.this, "Data Recorded Successfully!", Toast.LENGTH_SHORT, true).show();
                startActivity(new Intent(CommonGroup.this, MainActivity.class));

                //myRef.child(Calendar.getInstance().getTime().toString().trim()).child("Crop Damage Group Data").setValue(WeekSurveyData.getCropDamageGroupData());
            }

            @Override
            public void onCancelledForm() {

            }
        };

        verticalStepperFormView
                .setup(stepperFormListener, formSteps)
                .init();
    }
}