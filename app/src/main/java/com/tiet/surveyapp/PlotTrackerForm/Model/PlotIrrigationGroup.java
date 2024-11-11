package com.tiet.surveyapp.PlotTrackerForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class PlotIrrigationGroup extends Step<PlotIrrigationGroup.PlotIrrigationGroupData> {
    PlotIrrigationGroupData plotIrrigationGroupData;
    public class PlotIrrigationGroupData {
        public String irri_method;
        public String other_irri_method;

        public PlotIrrigationGroupData(String irri_method, String other_irri_method) {
            this.irri_method = irri_method;
            this.other_irri_method = other_irri_method;
        }

        public void setIrri_method(String irri_method) {
            this.irri_method = irri_method;
        }

        public void setOther_irri_method(String other_irri_method) {
            this.other_irri_method = other_irri_method;
        }
    }

    public PlotIrrigationGroup(String title) {
        super(title);
    }

    @Override
    public PlotIrrigationGroupData getStepData() {
        return plotIrrigationGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(PlotIrrigationGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(PlotIrrigationGroupData stepData) {

        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View plotIrrigationGroup = inflater.inflate(R.layout.activity_plot_irrigation_group, null, false);
        RadioGroup irri_method = (RadioGroup) plotIrrigationGroup.findViewById(R.id.rg20);
        EditText other_irri_method = plotIrrigationGroup.findViewById(R.id.editTextTextPersonName34);
        other_irri_method.setVisibility(View.GONE);
         plotIrrigationGroupData = new PlotIrrigationGroupData("**","**");

        other_irri_method.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotIrrigationGroupData.setOther_irri_method(s.toString());
            }
        });

        irri_method.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                plotIrrigationGroupData.setIrri_method(checkedString);
                if(checkedString.equals("Other")){
                    other_irri_method.setVisibility(View.VISIBLE);
                }
            }
        });

        return plotIrrigationGroup;
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
}