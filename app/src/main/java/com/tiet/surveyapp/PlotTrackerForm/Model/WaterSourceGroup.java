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

public class WaterSourceGroup extends Step<WaterSourceGroup.WaterSourceGroupData> {
    WaterSourceGroupData waterSourceGroupData;
    public class WaterSourceGroupData {
        public WaterSourceGroupData(String water_source, String other_water_source, String water_dist, String water_pic) {
            this.water_source = water_source;
            this.other_water_source = other_water_source;
            this.water_dist = water_dist;
            this.water_pic = water_pic;
        }

        public String water_source;
        public String other_water_source;
        public String water_dist;
        public String water_pic;

        public String getWater_pic() {
            return water_pic;
        }

        public void setWater_pic(String water_pic) {
            this.water_pic = water_pic;
        }

        public void setWater_source(String water_source) {
            this.water_source = water_source;
        }

        public void setOther_water_source(String other_water_source) {
            this.other_water_source = other_water_source;
        }

        public void setWater_dist(String water_dist) {
            this.water_dist = water_dist;
        }
    }

    public WaterSourceGroup(String title) {
        super(title);
    }

    @Override
    public WaterSourceGroupData getStepData() {
        return waterSourceGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(WaterSourceGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(WaterSourceGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View waterSourceGroup = inflater.inflate(R.layout.activity_water_source_group, null, false);
        RadioGroup water_source = (RadioGroup) waterSourceGroup.findViewById(R.id.rg24);
        EditText other_water_source = waterSourceGroup.findViewById(R.id.editTextTextPersonName42);
        EditText water_dist = waterSourceGroup.findViewById(R.id.editTextTextPersonName43);
        waterSourceGroupData = new WaterSourceGroupData("**","**","**","**");

        other_water_source.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                waterSourceGroupData.setOther_water_source(s.toString());
            }
        });

        water_dist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                waterSourceGroupData.setWater_dist(s.toString());
            }
        });

        water_source.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                waterSourceGroupData.setWater_source(checkedString);
                if (checkedString.equals("Other")) {
                    other_water_source.setVisibility(View.VISIBLE);
                }
            }
        });

        return waterSourceGroup;
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