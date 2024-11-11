package com.tiet.surveyapp.WeeklySurveyForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class WeedingGroup extends Step<WeedingGroup.WeedingGroupData> {
    WeedingGroupData weedingGroupData;
    public class WeedingGroupData {
        public WeedingGroupData(String weed_menace, String weed_treatment, String other_weed_treatment) {
            this.weed_menace = weed_menace;
            this.weed_treatment = weed_treatment;
            this.other_weed_treatment = other_weed_treatment;
        }

        public String weed_menace;
        public String weed_treatment;
        public String other_weed_treatment;

        public String getWeed_menace() {
            return weed_menace;
        }

        public String getWeed_treatment() {
            return weed_treatment;
        }

        public String getOther_weed_treatment() {
            return other_weed_treatment;
        }

        public void setWeed_menace(String weed_menace) {
            this.weed_menace = weed_menace;
        }

        public void setWeed_treatment(String weed_treatment) {
            this.weed_treatment = weed_treatment;
        }

        public void setOther_weed_treatment(String other_weed_treatment) {
            this.other_weed_treatment = other_weed_treatment;
        }
    }

    public WeedingGroup(String title) {
        super(title);
    }

    @Override
    public WeedingGroupData getStepData() {
        return weedingGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(WeedingGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(WeedingGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View weedingGroup = inflater.inflate(R.layout.activity_weeding_group, null, false);
        RadioGroup weedingRadioGroup1 = (RadioGroup) weedingGroup.findViewById(R.id.rg13);
        TextView textView1 = weedingGroup.findViewById(R.id.textView11);
        RadioGroup weedingRadioGroup2 = (RadioGroup) weedingGroup.findViewById(R.id.rg14);
        EditText otherTechniqueName = weedingGroup.findViewById(R.id.editTextTextPersonName10);
         weedingGroupData = new WeedingGroupData("**","**","**");

        otherTechniqueName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                weedingGroupData.setOther_weed_treatment(s.toString());
            }
        });

        weedingRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();

                if(checkedString.equals("Yes")){
                    weedingGroupData.setWeed_menace("Yes");
                    //make the next radio button group visible
                    textView1.setVisibility(View.VISIBLE);
                    weedingRadioGroup2.setVisibility(View.VISIBLE);
                    weedingRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                            String checkedString = checked.getText().toString();

                            if(checkedString.equals("Other")){
                                otherTechniqueName.setVisibility(View.VISIBLE);
                            }
                            else {
                                weedingGroupData.setWeed_treatment(checkedString);
                            }
                        }
                    });
                }else{
                    weedingGroupData.setWeed_menace("No");
                }
            }
        });

        return weedingGroup;
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