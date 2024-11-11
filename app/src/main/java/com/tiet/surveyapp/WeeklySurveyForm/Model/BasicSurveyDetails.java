package com.tiet.surveyapp.WeeklySurveyForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

import static android.os.Build.VERSION_CODES.R;

public class BasicSurveyDetails extends Step<BasicSurveyDetails.BasicSurveyData> {
    BasicSurveyData basicSurveyData;
    EditText farmer_id;
    EditText farmer_name;

    public BasicSurveyDetails(String title) {
        super(title);
    }

    @Override
    public BasicSurveyData getStepData() {
        return basicSurveyData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(BasicSurveyData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(BasicSurveyData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        basicSurveyData = new BasicSurveyData("**","**","**","**");
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View basicDetailsLayout = inflater.inflate(com.tiet.surveyapp.R.layout.basic_survey_layout, null, false);
        farmer_id = basicDetailsLayout.findViewById(com.tiet.surveyapp.R.id.editTextTextPersonName);
        farmer_name = basicDetailsLayout.findViewById(com.tiet.surveyapp.R.id.editTextTextPersonName2);
        RadioGroup plantation_group = basicDetailsLayout.findViewById(com.tiet.surveyapp.R.id.rg1);
        RadioGroup crop_type_group = basicDetailsLayout.findViewById(com.tiet.surveyapp.R.id.rg2);
        farmer_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                basicSurveyData.setFarmer_name(s.toString());
            }
        });


        farmer_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                basicSurveyData.setFarmer_id(s.toString());
            }
        });
        plantation_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButtonChecked = group.findViewById(group.getCheckedRadioButtonId());
                basicSurveyData.setPlot_status(radioButtonChecked.getText().toString());
            }
        });

        crop_type_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButtonChecked2 = group.findViewById(group.getCheckedRadioButtonId());
                basicSurveyData.setCrop(radioButtonChecked2.getText().toString());
            }
        });
        return basicDetailsLayout;
    }

    @Override
    protected void onStepOpened(boolean animated) {

    }

    @Override
    protected void onStepClosed(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsCompleted(boolean animated) {

    }

    @Override
    protected void onStepMarkedAsUncompleted(boolean animated) {

    }

    public class BasicSurveyData{
    public String farmer_id;
   public String farmer_name;
    public String plot_status;
    public String crop;

        public BasicSurveyData(String farmer_id, String farmer_name, String plot_status, String crop) {
            this.farmer_id = farmer_id;
            this.farmer_name = farmer_name;
            this.plot_status = plot_status;
            this.crop = crop;
        }

        public String getFarmer_id() {
            return farmer_id;
        }

        public void setFarmer_id(String farmer_id) {
            this.farmer_id = farmer_id;
        }

        public String getFarmer_name() {
            return farmer_name;
        }

        public void setFarmer_name(String farmer_name) {
            this.farmer_name = farmer_name;
        }

        public String getPlot_status() {
            return plot_status;
        }

        public void setPlot_status(String plot_status) {
            this.plot_status = plot_status;
        }

        public String getCrop() {
            return crop;
        }

        public void setCrop(String crop) {
            this.crop = crop;
        }
    }
}
