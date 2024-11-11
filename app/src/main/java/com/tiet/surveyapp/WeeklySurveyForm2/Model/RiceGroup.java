package com.tiet.surveyapp.WeeklySurveyForm2.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class RiceGroup extends Step<RiceGroup.RiceGroupData> {
    RiceGroupData riceGroupData;
    public static class RiceGroupData {
        public String rice_plant_height;
        public String rice_num_tillers;
        public String rice_num_flowers;
        public String rice_plant_gps_loc;
        public String rice_plant_photo;
        public String rice_leaf_photo;
        public String rice_flower_photo;

        public RiceGroupData(String rice_plant_height, String rice_num_tillers, String rice_num_flowers, String rice_plant_gps_loc, String rice_plant_photo, String rice_leaf_photo, String rice_flower_photo) {
            this.rice_plant_height = rice_plant_height;
            this.rice_num_tillers = rice_num_tillers;
            this.rice_num_flowers = rice_num_flowers;
            this.rice_plant_gps_loc = rice_plant_gps_loc;
            this.rice_plant_photo = rice_plant_photo;
            this.rice_leaf_photo = rice_leaf_photo;
            this.rice_flower_photo = rice_flower_photo;
        }

        public String getRice_plant_height() {
            return rice_plant_height;
        }

        public String getRice_num_tillers() {
            return rice_num_tillers;
        }

        public String getRice_num_flowers() {
            return rice_num_flowers;
        }

        public String getRice_plant_gps_loc() {
            return rice_plant_gps_loc;
        }

        public String getRice_plant_photo() {
            return rice_plant_photo;
        }

        public String getRice_leaf_photo() {
            return rice_leaf_photo;
        }

        public String getRice_flower_photo() {
            return rice_flower_photo;
        }

        public void setRice_plant_height(String rice_plant_height) {
            this.rice_plant_height = rice_plant_height;
        }

        public void setRice_num_tillers(String rice_num_tillers) {
            this.rice_num_tillers = rice_num_tillers;
        }

        public void setRice_num_flowers(String rice_num_flowers) {
            this.rice_num_flowers = rice_num_flowers;
        }

        public void setRice_plant_gps_loc(String rice_plant_gps_loc) {
            this.rice_plant_gps_loc = rice_plant_gps_loc;
        }

        public void setRice_plant_photo(String rice_plant_photo) {
            this.rice_plant_photo = rice_plant_photo;
        }

        public void setRice_leaf_photo(String rice_leaf_photo) {
            this.rice_leaf_photo = rice_leaf_photo;
        }

        public void setRice_flower_photo(String rice_flower_photo) {
            this.rice_flower_photo = rice_flower_photo;
        }
    }

    public RiceGroup(String title) {
        super(title);
    }

    @Override
    public RiceGroupData getStepData() {
        return riceGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(RiceGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(RiceGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View riceGroup = inflater.inflate(R.layout.activity_rice_group, null, false);
        EditText rice_plant_height = riceGroup.findViewById(R.id.editTextTextPersonName22);
        EditText rice_num_tillers = riceGroup.findViewById(R.id.editTextTextPersonName23);
        EditText rice_num_flowers = riceGroup.findViewById(R.id.editTextTextPersonName24);
         riceGroupData = new RiceGroupData("**","**","**","**","**","**","**");

        rice_plant_height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                riceGroupData.setRice_plant_height(s.toString());
            }
        });

        rice_num_tillers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                riceGroupData.setRice_num_tillers(s.toString());
            }
        });

        rice_num_flowers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                riceGroupData.setRice_num_flowers(s.toString());
            }
        });

        return riceGroup;
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