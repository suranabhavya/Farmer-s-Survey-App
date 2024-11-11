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

public class MaintenanceGroup extends Step<MaintenanceGroup.MaintenanceGroupData> {
    MaintenanceGroupData maintenanceGroupData;
    public class MaintenanceGroupData {
        public String otherexpns_yesno;
        public String expenses_names;
        public String expense_cost;

        public MaintenanceGroupData(String otherexpns_yesno, String expenses_names, String expense_cost) {
            this.otherexpns_yesno = otherexpns_yesno;
            this.expenses_names = expenses_names;
            this.expense_cost = expense_cost;
        }

        public void setOtherexpns_yesno(String otherexpns_yesno) {
            this.otherexpns_yesno = otherexpns_yesno;
        }

        public void setExpenses_names(String expenses_names) {
            this.expenses_names = expenses_names;
        }

        public void setExpense_cost(String expense_cost) {
            this.expense_cost = expense_cost;
        }
    }

    public MaintenanceGroup(String title) {
        super(title);
    }

    @Override
    public MaintenanceGroupData getStepData() {
        return maintenanceGroupData ;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(MaintenanceGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(MaintenanceGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View maintenanceGroup = inflater.inflate(R.layout.activity_maintenance_group, null, false);
        RadioGroup otherexpns_yesno = (RadioGroup) maintenanceGroup.findViewById(R.id.rg27);
        EditText expenses_names = maintenanceGroup.findViewById(R.id.editTextTextPersonName50);
        EditText expense_cost = maintenanceGroup.findViewById(R.id.editTextTextPersonName53);
        maintenanceGroupData = new MaintenanceGroupData("**","**","**");

        expenses_names.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                maintenanceGroupData.setExpenses_names(s.toString());
            }
        });

        expense_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                maintenanceGroupData.setExpense_cost(s.toString());
            }
        });

        otherexpns_yesno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                maintenanceGroupData.setOtherexpns_yesno(checkedString);
                if(checkedString.equals("Yes")) {
                    expenses_names.setVisibility(View.VISIBLE);
                    expense_cost.setVisibility(View.VISIBLE);
                }
            }
        });

        return maintenanceGroup;
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