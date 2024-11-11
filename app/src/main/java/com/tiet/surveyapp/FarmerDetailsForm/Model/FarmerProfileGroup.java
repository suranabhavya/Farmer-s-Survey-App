package com.tiet.surveyapp.FarmerDetailsForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import android.widget.Spinner;


import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class FarmerProfileGroup extends Step<FarmerProfileGroup.FarmerProfileGroupData> {
    FarmerProfileGroupData farmerProfileGroupData;
    public static class FarmerProfileGroupData {

        public FarmerProfileGroupData(String farmer_name, String state, String mandal, String district_punjab, String village, String phone, String hh_partof, String hh_shg, String hh_bpl, String hh_farmers, String acres_owned, String acres_leased, String additional_comments_q, String farmer_pic_url) {
            this.farmer_name = farmer_name;
            this.state = state;
            this.mandal = mandal;
            this.district_punjab = district_punjab;
            this.village = village;
            this.phone = phone;
            this.hh_partof = hh_partof;
            this.hh_shg = hh_shg;
            this.hh_bpl = hh_bpl;
            this.hh_farmers = hh_farmers;
            this.acres_owned = acres_owned;
            this.acres_leased = acres_leased;
            this.additional_comments_q = additional_comments_q;
            this.farmer_pic_url = farmer_pic_url;
        }

        public String farmer_name;
        public String state;
        public String mandal;
        public String district_punjab;
        public String village;
        public String phone;
        public String hh_partof;
        public String hh_shg;
        public String hh_bpl;
        public String hh_farmers;
        public String acres_owned;
        public String acres_leased;
        public String additional_comments_q;
        public String farmer_pic_url;

        public String getFarmer_pic_url() {
            return farmer_pic_url;
        }

        public void setFarmer_pic_url(String farmer_pic_url) {
            this.farmer_pic_url = farmer_pic_url;
        }

        public String getDistrict_punjab() {
            return district_punjab;
        }

        public void setDistrict_punjab(String district_punjab) {
            this.district_punjab = district_punjab;
        }

        public void setFarmer_name(String farmer_name) {
            this.farmer_name = farmer_name;
        }

        public void setState(String state) {
            this.state = state;
        }


        public void setMandal(String mandal) {
            this.mandal = mandal;
        }

        public void setVillage(String village) {
            this.village = village;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }


        public void setHh_partof(String hh_partof) {
            this.hh_partof = hh_partof;
        }

        public void setHh_shg(String hh_shg) {
            this.hh_shg = hh_shg;
        }

        public void setHh_bpl(String hh_bpl) {
            this.hh_bpl = hh_bpl;
        }

        public void setHh_farmers(String hh_farmers) {
            this.hh_farmers = hh_farmers;
        }

        public void setAcres_owned(String acres_owned) {
            this.acres_owned = acres_owned;
        }

        public void setAcres_leased(String acres_leased) {
            this.acres_leased = acres_leased;
        }

        public void setAdditional_comments_q(String additional_comments_q) {
            this.additional_comments_q = additional_comments_q;
        }
    }

    public FarmerProfileGroup(String title) {
        super(title);
    }

    @Override
    public FarmerProfileGroupData getStepData() {
        return farmerProfileGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(FarmerProfileGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(FarmerProfileGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View farmerProfileGroup = inflater.inflate(R.layout.activity_farmer_profile_group, null, false);
        EditText farmer_name = farmerProfileGroup.findViewById(R.id.editTextTextPersonName4);
        Spinner state = (Spinner) farmerProfileGroup.findViewById(R.id.spinner);
        Spinner district_punjab = (Spinner) farmerProfileGroup.findViewById(R.id.spinner);
        EditText mandal = farmerProfileGroup.findViewById(R.id.editTextTextPersonName5);
        EditText village = farmerProfileGroup.findViewById(R.id.editTextTextPersonName8);
        EditText phone = farmerProfileGroup.findViewById(R.id.editTextPhone);
        EditText hh_partof = farmerProfileGroup.findViewById(R.id.editTextNumber12);
        EditText hh_shg = farmerProfileGroup.findViewById(R.id.editTextTextPersonName9);
        EditText hh_farmers = farmerProfileGroup.findViewById(R.id.editTextNumber13);
        EditText acres_owned = farmerProfileGroup.findViewById(R.id.editTextNumber14);
        EditText acres_lease = farmerProfileGroup.findViewById(R.id.editTextNumber15);
        EditText additional_comments_q = farmerProfileGroup.findViewById(R.id.editTextTextPersonName13);
        farmerProfileGroupData = new FarmerProfileGroupData("**","**","**","**","**","**","**","**","**","**","**","**","**","**");

        farmer_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setFarmer_name(s.toString());
            }
        });

        mandal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setMandal(s.toString());
            }
        });

        village.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setVillage(s.toString());
            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setPhone(s.toString());
            }
        });



        hh_partof.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setHh_partof(s.toString());
            }
        });

        hh_shg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setHh_shg(s.toString());
            }
        });

        hh_farmers.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setHh_farmers(s.toString());
            }
        });

        acres_owned.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setAcres_owned(s.toString());
            }
        });

        acres_lease.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setAcres_leased(s.toString());
            }
        });

        additional_comments_q.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                farmerProfileGroupData.setAdditional_comments_q(s.toString());
            }
        });
        district_punjab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                farmerProfileGroupData.setDistrict_punjab(text);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                farmerProfileGroupData.setState(text);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return farmerProfileGroup;
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