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

public class HarvestingGroup extends Step<HarvestingGroup.HarvestingGroupData> {
    HarvestingGroupData harvestingGroupData;
    public class HarvestingGroupData {
        public String harvest_yesno;
        public String harvest_KG;
        public String harvest_storage;
        public String harvest_damage;
        public String post_harvest_damage_cause;

        public HarvestingGroupData(String harvest_yesno, String harvest_KG, String harvest_storage, String harvest_damage, String post_harvest_damage_cause) {
            this.harvest_yesno = harvest_yesno;
            this.harvest_KG = harvest_KG;
            this.harvest_storage = harvest_storage;
            this.harvest_damage = harvest_damage;
            this.post_harvest_damage_cause = post_harvest_damage_cause;
        }

        public void setHarvest_yesno(String harvest_yesno) {
            this.harvest_yesno = harvest_yesno;
        }

        public void setHarvest_KG(String harvest_KG) {
            this.harvest_KG = harvest_KG;
        }

        public void setHarvest_storage(String harvest_storage) {
            this.harvest_storage = harvest_storage;
        }

        public void setHarvest_damage(String harvest_damage) {
            this.harvest_damage = harvest_damage;
        }

        public void setPost_harvest_damage_cause(String post_harvest_damage_cause) {
            this.post_harvest_damage_cause = post_harvest_damage_cause;
        }
    }

    public HarvestingGroup(String title) {
        super(title);
    }

    @Override
    public HarvestingGroupData getStepData() {
        return harvestingGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(HarvestingGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(HarvestingGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View harvestingGroup = inflater.inflate(R.layout.activity_harvesting_group, null, false);
        RadioGroup harvest_yesno = (RadioGroup) harvestingGroup.findViewById(R.id.rg26);
        EditText harvest_KG = harvestingGroup.findViewById(R.id.editTextTextPersonName46);
        EditText harvest_storage = harvestingGroup.findViewById(R.id.editTextTextPersonName47);
        EditText harvest_damage = harvestingGroup.findViewById(R.id.editTextTextPersonName48);
        EditText post_harvest_damage_cause = harvestingGroup.findViewById(R.id.editTextTextPersonName49);
        harvestingGroupData = new HarvestingGroupData("**","**","**","**","**");

        harvest_KG.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                harvestingGroupData.setHarvest_KG(s.toString());
            }
        });

        harvest_storage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                harvestingGroupData.setHarvest_storage(s.toString());
            }
        });

        harvest_damage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                harvestingGroupData.setHarvest_damage(s.toString());
            }
        });

        post_harvest_damage_cause.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                harvestingGroupData.setPost_harvest_damage_cause(s.toString());
            }
        });

        harvest_yesno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                harvestingGroupData.setHarvest_yesno(checkedString);
                if(checkedString.equals("Yes")){
                    harvest_KG.setVisibility(View.VISIBLE);
                    harvest_storage.setVisibility(View.VISIBLE);
                    harvest_damage.setVisibility(View.VISIBLE);
                    post_harvest_damage_cause.setVisibility(View.VISIBLE);
                }
            }
        });

        return harvestingGroup;
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