package com.tiet.surveyapp.CropDiseaseSurveyForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class CropDamageGroup extends Step<CropDamageGroup.CropDamageGroupData> {
    CropDamageGroupData cropDamageGroupData;

    public class CropDamageGroupData{
        public String crop_damage;
        public String crop_damage_type;
        public String crop_damage_number;
        public String crop_damage_note;
        public String crop_pic_url;

        public CropDamageGroupData(String crop_damage, String crop_damage_type, String crop_damage_number, String crop_damage_note, String crop_pic_url) {
            this.crop_damage = crop_damage;
            this.crop_damage_type = crop_damage_type;
            this.crop_damage_number = crop_damage_number;
            this.crop_damage_note = crop_damage_note;
            this.crop_pic_url = crop_pic_url;
        }

        public String getCrop_damage_number() {
            return crop_damage_number;
        }

        public void setCrop_damage_number(String crop_damage_number) {
            this.crop_damage_number = crop_damage_number;
        }

        public String getCrop_damage_note() {
            return crop_damage_note;
        }

        public void setCrop_damage_note(String crop_damage_note) {
            this.crop_damage_note = crop_damage_note;
        }

        public String getCrop_pic_url() {
            return crop_pic_url;
        }

        public void setCrop_pic_url(String crop_pic_url) {
            this.crop_pic_url = crop_pic_url;
        }

        public String getCrop_damage() {
            return crop_damage;
        }

        public void setCrop_damage(String crop_damage) {
            this.crop_damage = crop_damage;
        }

        public String getCrop_damage_type() {
            return crop_damage_type;
        }

        public void setCrop_damage_type(String crop_damage_type) {
            this.crop_damage_type = crop_damage_type;
        }
    }
    public CropDamageGroup(String title) {
        super(title);
    }

    @Override
    public CropDamageGroupData getStepData() {
        return cropDamageGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(CropDamageGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(CropDamageGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        cropDamageGroupData = new CropDamageGroupData("**","**","**","**","**");
        View cropGroup = inflater.inflate(R.layout.cropdamage_group, null, false);
        RadioGroup radioGroup2 = cropGroup.findViewById(R.id.rg2);
        EditText otherSpecify = cropGroup.findViewById(R.id.editText10);
        EditText damage_number = cropGroup.findViewById(R.id.crop10);
        EditText damage_note = cropGroup.findViewById(R.id.crop11);
        otherSpecify.setVisibility(View.GONE);
        damage_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            cropDamageGroupData.setCrop_damage_note(s.toString());
            }
        });
        damage_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            cropDamageGroupData.setCrop_damage_number(s.toString());
            }
        });
        RadioGroup radioGroup1 = cropGroup.findViewById(R.id.rg1);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton radioButtonPressed = group.findViewById(group.getCheckedRadioButtonId());
                String choice=radioButtonPressed.getText().toString();
                if(choice.equals("Yes")){
                    radioGroup2.setVisibility(View.VISIBLE);
                    cropDamageGroupData.setCrop_damage("Yes");
                    radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton radioButtonPressed = group.findViewById(group.getCheckedRadioButtonId());
                            String choice=radioButtonPressed.getText().toString();
                            if(choice.equals("Other")){
                                otherSpecify.setVisibility(View.VISIBLE);
                                cropDamageGroupData.setCrop_damage_type(otherSpecify.getText().toString());
                            }else{
                                cropDamageGroupData.setCrop_damage_type(choice);
                            }
                        }
                    });

                }else{
                    cropDamageGroupData.setCrop_damage("No");
                }
            }
        });
        return cropGroup;
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

