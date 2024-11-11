package com.tiet.surveyapp.WeeklySurveyForm.Model;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

import android.text.Editable;

public class GeneralWork extends Step<GeneralWork.GeneralWorkData> {
    GeneralWorkData generalWorkData;

    public class GeneralWorkData{

        public String general_work_kind;
        public String hh_work_days;
        public String labor_work_days;
        public String labors_num;
        public String paid_labor_cost;

        public GeneralWorkData(String general_work_kind, String hh_work_days, String labor_work_days, String labors_num, String paid_labor_cost) {
            this.general_work_kind = general_work_kind;
            this.hh_work_days = hh_work_days;
            this.labor_work_days = labor_work_days;
            this.labors_num = labors_num;
            this.paid_labor_cost = paid_labor_cost;
        }

        public String getGeneral_work_kind() {
            return general_work_kind;
        }

        public String getHh_work_days() {
            return hh_work_days;
        }

        public String getLabor_work_days() {
            return labor_work_days;
        }

        public String getLabors_num() {
            return labors_num;
        }

        public String getPaid_labor_cost() {
            return paid_labor_cost;
        }

        public void setGeneral_work_kind(String general_work_kind) {
            this.general_work_kind = general_work_kind;
        }

        public void setHh_work_days(String hh_work_days) {
            this.hh_work_days = hh_work_days;
        }

        public void setLabor_work_days(String labor_work_days) {
            this.labor_work_days = labor_work_days;
        }

        public void setLabors_num(String labors_num) {
            this.labors_num = labors_num;
        }

        public void setPaid_labor_cost(String paid_labor_cost) {
            this.paid_labor_cost = paid_labor_cost;
        }
    }

    public GeneralWork(String title) {
        super(title);
    }

    @Override
    public GeneralWorkData getStepData() {
        return generalWorkData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(GeneralWorkData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(GeneralWorkData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View generalWork = inflater.inflate(R.layout.activity_general_work, null, false);
        EditText otherWork = generalWork.findViewById(R.id.editTextTextPersonName16);
        EditText hhWork = generalWork.findViewById(R.id.editTextTextPersonName17);
        EditText laborWorkDays = generalWork.findViewById(R.id.editTextTextPersonName18);
        EditText noOfLaborWork = generalWork.findViewById(R.id.editTextTextPersonName19);
        EditText costLabor = generalWork.findViewById(R.id.editTextTextPersonName20);
         generalWorkData = new GeneralWorkData("**","**","**","**","**");

        otherWork.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                generalWorkData.setGeneral_work_kind(s.toString());
            }
        });

        hhWork.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                generalWorkData.setHh_work_days(s.toString());
            }
        });

        laborWorkDays.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                generalWorkData.setLabor_work_days(s.toString());
            }
        });

        noOfLaborWork.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                generalWorkData.setLabors_num(s.toString());
            }
        });

        costLabor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                generalWorkData.setPaid_labor_cost(s.toString());
            }
        });

        return generalWork;
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