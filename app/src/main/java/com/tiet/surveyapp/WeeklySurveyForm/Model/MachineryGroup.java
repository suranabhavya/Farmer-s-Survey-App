package com.tiet.surveyapp.WeeklySurveyForm.Model;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class MachineryGroup extends Step<MachineryGroup.MachineryGroupData> {

    static String checkedString1;
    EditText otherMachineryName;
    EditText machineryHours;
    MachineryGroupData machineryGroupData;

    public class MachineryGroupData{

        public String machinery_yesno;
        public String machinery_type;
        public String other_machinery_type;
        public String machinery_hours;

        public MachineryGroupData(String machinery_yesno, String machinery_type, String other_machinery_type, String machinery_hours) {
            this.machinery_yesno = machinery_yesno;
            this.machinery_type = machinery_type;
            this.other_machinery_type = other_machinery_type;
            this.machinery_hours = machinery_hours;
        }

        public String getMachinery_yesno() {
            return machinery_yesno;
        }

        public String getMachinery_type() {
            return machinery_type;
        }

        public String getOther_machinery_type() {
            return other_machinery_type;
        }

        public String getMachinery_hours() {
            return machinery_hours;
        }

        public void setMachinery_yesno(String machinery_yesno) {
            this.machinery_yesno = machinery_yesno;
        }

        public void setMachinery_type(String machinery_type) {
            this.machinery_type = machinery_type;
        }

        public void setOther_machinery_type(String other_machinery_type) {
            this.other_machinery_type = other_machinery_type;
        }

        public void setMachinery_hours(String machinery_hours) {
            this.machinery_hours = machinery_hours;
        }
    }

    public MachineryGroup(String title) {
        super(title);
    }

    @Override
    public MachineryGroupData getStepData() {
        return machineryGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(MachineryGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(MachineryGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View machineryGroup = inflater.inflate(R.layout.activity_machinery_group, null, false);
        RadioGroup machineryRadioGroup1 = (RadioGroup) machineryGroup.findViewById(R.id.rg8);
        TextView textView1 = machineryGroup.findViewById((R.id.textView17));
        RadioGroup machineryRadioGroup2 = (RadioGroup) machineryGroup.findViewById(R.id.rg9);
        otherMachineryName = machineryGroup.findViewById(R.id.editTextTextPersonName15);
        machineryHours = machineryGroup.findViewById(R.id.editTextNumber7);

        machineryGroupData = new MachineryGroupData("**","**","**","**");

        otherMachineryName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                machineryGroupData.setOther_machinery_type(otherMachineryName.getText().toString());
            }
        });

        machineryHours.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                machineryGroupData.setMachinery_hours(s.toString());
            }
        });


        machineryRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();

                if(checkedString.equals("Yes")){
                    machineryGroupData.setMachinery_yesno("Yes");
                    //make the next radio button group visible
                    textView1.setVisibility(View.VISIBLE);
                    machineryRadioGroup2.setVisibility(View.VISIBLE);
                    machineryRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                            machineryHours.setVisibility(View.VISIBLE);
                            checkedString1 = checked.getText().toString();
                            machineryGroupData.setMachinery_type(checkedString1);
                            if(checkedString1.equals("Other")){
                                otherMachineryName.setVisibility(View.VISIBLE);
                            }

                        }
                    });
                }else{
                    machineryGroupData.setMachinery_yesno("No");
                }

            }
        });

        return machineryGroup;
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