package com.tiet.surveyapp.WeeklySurveyForm2.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class WheatGroup extends Step<WheatGroup.WheatGroupData> {
    public WheatGroupData wheatGroupData;
    public static class WheatGroupData {
        public String wheat_plant_height;
        public String wheat_num_leafs;
        public String wheat_num_stalks;
        public String wheat_num_spikes;
        public String plant_photo_url;
        public String leaf_photo_url;
        public String spike_photo_url;

        public WheatGroupData(String wheat_plant_height, String wheat_num_leafs, String wheat_num_stalks, String wheat_num_spikes, String plant_photo_url, String leaf_photo_url, String spike_photo_url) {
            this.wheat_plant_height = wheat_plant_height;
            this.wheat_num_leafs = wheat_num_leafs;
            this.wheat_num_stalks = wheat_num_stalks;
            this.wheat_num_spikes = wheat_num_spikes;
            this.plant_photo_url = plant_photo_url;
            this.leaf_photo_url = leaf_photo_url;
            this.spike_photo_url = spike_photo_url;
        }

        public String getWheat_plant_height() {
            return wheat_plant_height;
        }

        public String getWheat_num_leafs() {
            return wheat_num_leafs;
        }

        public String getWheat_num_stalks() {
            return wheat_num_stalks;
        }

        public String getWheat_num_spikes() {
            return wheat_num_spikes;
        }

        public String getPlant_photo_url() {
            return plant_photo_url;
        }

        public void setPlant_photo_url(String plant_photo_url) {
            this.plant_photo_url = plant_photo_url;
        }

        public String getLeaf_photo_url() {
            return leaf_photo_url;
        }

        public void setLeaf_photo_url(String leaf_photo_url) {
            this.leaf_photo_url = leaf_photo_url;
        }

        public String getSpike_photo_url() {
            return spike_photo_url;
        }

        public void setSpike_photo_url(String spike_photo_url) {
            this.spike_photo_url = spike_photo_url;
        }

        public void setWheat_plant_height(String wheat_plant_height) {
            this.wheat_plant_height = wheat_plant_height;
        }

        public void setWheat_num_leafs(String wheat_num_leafs) {
            this.wheat_num_leafs = wheat_num_leafs;
        }

        public void setWheat_num_stalks(String wheat_num_stalks) {
            this.wheat_num_stalks = wheat_num_stalks;
        }

        public void setWheat_num_spikes(String wheat_num_spikes) {
            this.wheat_num_spikes = wheat_num_spikes;
        }
    }

    public WheatGroup(String title) {
        super(title);
    }

    @Override
    public WheatGroupData getStepData() {
        return wheatGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(WheatGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(WheatGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View wheatGroup = inflater.inflate(R.layout.activity_wheat_group, null, false);
        EditText wheat_plant_height = wheatGroup.findViewById(R.id.editTextTextPersonName25);
        EditText wheat_num_leafs = wheatGroup.findViewById(R.id.editTextTextPersonName26);
        EditText wheat_num_stalks = wheatGroup.findViewById(R.id.editTextTextPersonName27);
        EditText wheat_num_spikes = wheatGroup.findViewById(R.id.editTextTextPersonName28);
        wheatGroupData = new WheatGroupData("**","**","**","**","**","**","**");

        wheat_plant_height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                wheatGroupData.setWheat_plant_height(s.toString());
            }
        });

        wheat_num_leafs.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                wheatGroupData.setWheat_num_leafs(s.toString());
            }
        });

        wheat_num_stalks.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                wheatGroupData.setWheat_num_stalks(s.toString());
            }
        });

        wheat_num_spikes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                wheatGroupData.setWheat_num_spikes(s.toString());
            }
        });

        return wheatGroup;
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