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


public class HerbicideGroup extends Step<HerbicideGroup.HerbicideGroupData> {
    HerbicideGroupData herbicideGroupData;
    public class HerbicideGroupData{
        public String herbicide_use;
        public String herbicide_used_name_wheat;
        public String other_herbicide_used_wheat;
        public String herbicides_units;
        public String other_herbicide_units;
        public String herbicide_volume;
        public String herbicide_bags_amount_;

        public HerbicideGroupData(String herbicide_use, String herbicide_used_name_wheat, String other_herbicide_used_wheat, String herbicides_units, String other_herbicide_units, String herbicide_volume, String herbicide_bags_amount_) {
            this.herbicide_use = herbicide_use;
            this.herbicide_used_name_wheat = herbicide_used_name_wheat;
            this.other_herbicide_used_wheat = other_herbicide_used_wheat;
            this.herbicides_units = herbicides_units;
            this.other_herbicide_units = other_herbicide_units;
            this.herbicide_volume = herbicide_volume;
            this.herbicide_bags_amount_ = herbicide_bags_amount_;
        }

        public void setHerbicide_used_name_wheat(String herbicide_used_name_wheat) {
            this.herbicide_used_name_wheat = herbicide_used_name_wheat;
        }

        public void setOther_herbicide_used_wheat(String other_herbicide_used_wheat) {
            this.other_herbicide_used_wheat = other_herbicide_used_wheat;
        }

        public void setHerbicides_units(String herbicides_units) {
            this.herbicides_units = herbicides_units;
        }

        public void setOther_herbicide_units(String other_herbicide_units) {
            this.other_herbicide_units = other_herbicide_units;
        }

        public void setHerbicide_volume(String herbicide_volume) {
            this.herbicide_volume = herbicide_volume;
        }

        public void setHerbicide_bags_amount_(String herbicide_bags_amount_) {
            this.herbicide_bags_amount_ = herbicide_bags_amount_;
        }

        public void setHerbicide_use(String herbicide_use) {
            this.herbicide_use = herbicide_use;
        }
    }

    public HerbicideGroup(String title) {
        super(title);
    }

    @Override
    public HerbicideGroupData getStepData() {
        return herbicideGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(HerbicideGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(HerbicideGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View herbicideGroup = inflater.inflate(R.layout.activity_herbicide_group, null, false);
        RadioGroup herbicideRadioGroup1 = (RadioGroup) herbicideGroup.findViewById(R.id.rg5);

        TextView textView2 = herbicideGroup.findViewById(R.id.textView14);
        RadioGroup herbicideRadioGroup2 = (RadioGroup) herbicideGroup.findViewById(R.id.rg6);
        EditText otherHerbicideName = herbicideGroup.findViewById(R.id.editTextTextPersonName11);
        TextView textView3 = herbicideGroup.findViewById(R.id.textView15);
        RadioGroup herbicideRadioGroup3 = (RadioGroup) herbicideGroup.findViewById(R.id.rg7);
        EditText otherHerbicideUnit = herbicideGroup.findViewById(R.id.editTextTextPersonName12);
        EditText herbicideBagVolume = herbicideGroup.findViewById(R.id.editTextNumber5);
        EditText noOfHerbicideBag = herbicideGroup.findViewById(R.id.editTextNumber6);
        herbicideGroupData = new HerbicideGroupData("**","**","**","**","**","**","**");



        otherHerbicideName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                herbicideGroupData.setOther_herbicide_used_wheat(s.toString());
            }
        });

        otherHerbicideUnit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                herbicideGroupData.setOther_herbicide_units(s.toString());
            }
        });

        herbicideBagVolume.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                herbicideGroupData.setHerbicide_volume(s.toString());
            }
        });

        noOfHerbicideBag.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                herbicideGroupData.setHerbicide_bags_amount_(s.toString());
            }
        });

        herbicideRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();

                if(checkedString.equals("Yes")){
                    herbicideGroupData.setHerbicide_use("Yes");
                    //make the next radio button group visible

                    textView2.setVisibility(View.VISIBLE);
                    herbicideRadioGroup2.setVisibility(View.VISIBLE);
                    otherHerbicideUnit.setVisibility(View.GONE);
                    otherHerbicideName.setVisibility(View.GONE);
                    herbicideRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                            String checkedString = checked.getText().toString();

                            if(checkedString.equals("Other")){
                                otherHerbicideName.setVisibility(View.VISIBLE);
                            }
                            else {
                                herbicideGroupData.setHerbicide_used_name_wheat(checkedString);
                            }
                            textView3.setVisibility(View.VISIBLE);
                            herbicideRadioGroup3.setVisibility(View.VISIBLE);
                            herbicideRadioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(RadioGroup group, int checkedId) {
                                    RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                                    String checkedString = checked.getText().toString();

                                    if(checkedString.equals("Other")) {
                                        otherHerbicideUnit.setVisibility(View.VISIBLE);
                                    }
                                    else {
                                        herbicideGroupData.setHerbicides_units(checkedString);
                                    }
                                    herbicideBagVolume.setVisibility(View.VISIBLE);
                                    noOfHerbicideBag.setVisibility(View.VISIBLE);
                                }
                            });
                        }
                    });
                }else{
                    herbicideGroupData.setHerbicide_use("No");
                }
            }
        });

        return herbicideGroup;
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