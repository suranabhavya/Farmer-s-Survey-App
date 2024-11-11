package com.tiet.surveyapp.PlotTrackerForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class PlotPastGroup extends Step<PlotPastGroup.PlotPastGroupData> {
    PlotPastGroupData plotPastGroupData;
    public class PlotPastGroupData {
        public String crop_thisSeason;
        public String crop_thisSeason_other;
        public String past_crop1;
        public String other_past_crops1;
        public String past_method1;
        public String other_past_method_1;
        public String past_crop2;
        public String other_crop2;
        public String past_method2;

        public PlotPastGroupData(String crop_thisSeason, String crop_thisSeason_other, String past_crop1, String other_past_crops1, String past_method1, String other_past_method_1, String past_crop2, String other_crop2, String past_method2, String other_past_method2) {
            this.crop_thisSeason = crop_thisSeason;
            this.crop_thisSeason_other = crop_thisSeason_other;
            this.past_crop1 = past_crop1;
            this.other_past_crops1 = other_past_crops1;
            this.past_method1 = past_method1;
            this.other_past_method_1 = other_past_method_1;
            this.past_crop2 = past_crop2;
            this.other_crop2 = other_crop2;
            this.past_method2 = past_method2;
            this.other_past_method2 = other_past_method2;
        }

        public void setCrop_thisSeason(String crop_thisSeason) {
            this.crop_thisSeason = crop_thisSeason;
        }

        public void setCrop_thisSeason_other(String crop_thisSeason_other) {
            this.crop_thisSeason_other = crop_thisSeason_other;
        }

        public void setPast_crop1(String past_crop1) {
            this.past_crop1 = past_crop1;
        }

        public void setOther_past_crops1(String other_past_crops1) {
            this.other_past_crops1 = other_past_crops1;
        }

        public void setPast_method1(String past_method1) {
            this.past_method1 = past_method1;
        }

        public void setOther_past_method_1(String other_past_method_1) {
            this.other_past_method_1 = other_past_method_1;
        }

        public void setPast_crop2(String past_crop2) {
            this.past_crop2 = past_crop2;
        }

        public void setOther_crop2(String other_crop2) {
            this.other_crop2 = other_crop2;
        }

        public void setPast_method2(String past_method2) {
            this.past_method2 = past_method2;
        }

        public void setOther_past_method2(String other_past_method2) {
            this.other_past_method2 = other_past_method2;
        }

        String other_past_method2;
    }

    public PlotPastGroup(String title) {
        super(title);
    }

    @Override
    public PlotPastGroupData getStepData() {
        return plotPastGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(PlotPastGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(PlotPastGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View plotPastGroup = inflater.inflate(R.layout.activity_plot_past_group, null, false);
        Spinner crop_thisSeason = (Spinner) plotPastGroup.findViewById(R.id.spinner9);
        EditText crop_thisSeason_other = plotPastGroup.findViewById(R.id.editTextTextPersonName38);
        Spinner past_crop1 = (Spinner) plotPastGroup.findViewById(R.id.spinner10);
        EditText other_past_crops1 = plotPastGroup.findViewById(R.id.editTextTextPersonName39);
        RadioGroup past_method1 = (RadioGroup) plotPastGroup.findViewById(R.id.rg22);
        EditText other_past_method_1 = plotPastGroup.findViewById(R.id.editTextTextPersonName37);
        Spinner past_crop2 = (Spinner) plotPastGroup.findViewById(R.id.spinner11);
        EditText other_crop2 = plotPastGroup.findViewById(R.id.editTextTextPersonName40);
        RadioGroup past_method2 = (RadioGroup) plotPastGroup.findViewById(R.id.rg23);
        EditText other_past_method2 = plotPastGroup.findViewById(R.id.editTextTextPersonName41);
         plotPastGroupData = new PlotPastGroupData("**","**","**","**","**","**","**","**","**","**");

        crop_thisSeason_other.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotPastGroupData.setCrop_thisSeason_other(s.toString());
            }
        });

        other_past_crops1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotPastGroupData.setOther_past_crops1(s.toString());
            }
        });

        other_past_method_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotPastGroupData.setOther_past_method_1(s.toString());
            }
        });

        other_crop2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotPastGroupData.setOther_crop2(s.toString());
            }
        });

        other_past_method2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotPastGroupData.setOther_past_method2(s.toString());
            }
        });

        crop_thisSeason.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                plotPastGroupData.setCrop_thisSeason(text);
                if(text.equals("Other")) {
                    crop_thisSeason_other.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        past_crop1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                plotPastGroupData.setPast_crop1(text);
                if(text.equals("Other")) {
                    other_past_crops1.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        past_method1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                plotPastGroupData.setPast_method1(checkedString);
                if(checkedString.equals("Other")) {
                    other_past_method_1.setVisibility(View.VISIBLE);
                }
            }
        });

        past_crop2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                plotPastGroupData.setPast_crop2(text);
                if(text.equals("Other")) {
                    other_crop2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        past_method2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                plotPastGroupData.setPast_method2(checkedString);
                if(checkedString.equals("Other")) {
                    other_past_method2.setVisibility(View.VISIBLE);
                }
            }
        });

        return plotPastGroup;
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