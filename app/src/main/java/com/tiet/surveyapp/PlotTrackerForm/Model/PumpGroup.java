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

public class PumpGroup extends Step<PumpGroup.PumpGroupData> {
    PumpGroupData pumpGroupData;
    public class PumpGroupData {
        public PumpGroupData(String pump_type, String other_pump_type, String comments, String pump_pic_exmpl, String pump_spec) {
            this.pump_type = pump_type;
            this.other_pump_type = other_pump_type;
            this.comments = comments;
            this.pump_pic_exmpl = pump_pic_exmpl;
            this.pump_spec = pump_spec;
        }

        public String pump_type;
        public String other_pump_type;
        public String comments;
        public String pump_pic_exmpl;
        public String pump_spec;

        public String getPump_pic_exmpl() {
            return pump_pic_exmpl;
        }

        public void setPump_pic_exmpl(String pump_pic_exmpl) {
            this.pump_pic_exmpl = pump_pic_exmpl;
        }

        public String getPump_spec() {
            return pump_spec;
        }

        public void setPump_spec(String pump_spec) {
            this.pump_spec = pump_spec;
        }

        public void setPump_type(String pump_type) {
            this.pump_type = pump_type;
        }

        public void setOther_pump_type(String other_pump_type) {
            this.other_pump_type = other_pump_type;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }
    }

    public PumpGroup(String title) {
        super(title);
    }

    @Override
    public PumpGroupData getStepData() {
        return pumpGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(PumpGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(PumpGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View pumpGroup = inflater.inflate(R.layout.activity_pump_group, null, false);
        RadioGroup pump_type = (RadioGroup) pumpGroup.findViewById(R.id.rg25);
        EditText other_pump_type = pumpGroup.findViewById(R.id.editTextTextPersonName44);
        EditText comments = pumpGroup.findViewById(R.id.editTextTextPersonName45);
         pumpGroupData = new PumpGroupData("**","**","**","**","**");

        other_pump_type.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                pumpGroupData.setOther_pump_type(s.toString());
            }
        });

        comments.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                pumpGroupData.setComments(s.toString());
            }
        });

        pump_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                pumpGroupData.setPump_type(checkedString);
                if(checkedString.equals("Other")) {
                    other_pump_type.setVisibility(View.VISIBLE);
                }
            }
        });

        return pumpGroup;
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