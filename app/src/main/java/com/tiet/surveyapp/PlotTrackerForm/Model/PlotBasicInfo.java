package com.tiet.surveyapp.PlotTrackerForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class PlotBasicInfo extends Step<PlotBasicInfo.PlotBasicInfoData> {
    PlotBasicInfoData plotBasicInfoData;

    public class PlotBasicInfoData {
        public PlotBasicInfoData(String cultivator_name, String owner_name, String state, String district_punjab, String district_kerala, String district_ap, String mandal, String village) {
            this.cultivator_name = cultivator_name;
            this.owner_name = owner_name;
            this.state = state;
            this.district_punjab = district_punjab;
            this.district_kerala = district_kerala;
            this.district_ap = district_ap;
            this.mandal = mandal;
            this.village = village;
        }

        public String cultivator_name;
        public String owner_name;
        public String state;
        public String district_punjab;
        public String district_kerala;
        public String district_ap;
        public String mandal;
        public String village;

        public void setCultivator_name(String cultivator_name) {
            this.cultivator_name = cultivator_name;
        }

        public void setOwner_name(String owner_name) {
            this.owner_name = owner_name;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setDistrict_punjab(String district_punjab) {
            this.district_punjab = district_punjab;
        }

        public void setDistrict_kerala(String district_kerala) {
            this.district_kerala = district_kerala;
        }

        public void setDistrict_ap(String district_ap) {
            this.district_ap = district_ap;
        }

        public void setMandal(String mandal) {
            this.mandal = mandal;
        }

        public void setVillage(String village) {
            this.village = village;
        }
    }

    public PlotBasicInfo(String title) {
        super(title);
    }

    @Override
    public PlotBasicInfoData getStepData() {
        return plotBasicInfoData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(PlotBasicInfoData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(PlotBasicInfoData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View plotBasicInfo = inflater.inflate(R.layout.activity_plot_basic_info, null, false);
        EditText cultivator_name = plotBasicInfo.findViewById(R.id.editTextTextPersonName29);
        EditText owner_name = plotBasicInfo.findViewById(R.id.editTextTextPersonName30);
        Spinner state = (Spinner) plotBasicInfo.findViewById(R.id.spinner5);
        TextView punjabText = plotBasicInfo.findViewById(R.id.textView23);
        Spinner district_punjab = (Spinner) plotBasicInfo.findViewById(R.id.spinner6);
        TextView keralaText = plotBasicInfo.findViewById(R.id.textView25);
        Spinner district_kerala = (Spinner) plotBasicInfo.findViewById(R.id.spinner7);
        TextView apText = plotBasicInfo.findViewById(R.id.textView24);
        Spinner district_ap = (Spinner) plotBasicInfo.findViewById(R.id.spinner8);
        EditText mandal = plotBasicInfo.findViewById(R.id.editTextTextPersonName31);
        EditText village = plotBasicInfo.findViewById(R.id.editTextTextPersonName32);
         plotBasicInfoData = new PlotBasicInfoData("**","**","**","**","**","**","**","**");

        cultivator_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotBasicInfoData.setCultivator_name(s.toString());
            }
        });

        owner_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                plotBasicInfoData.setOwner_name(s.toString());
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
                plotBasicInfoData.setMandal(s.toString());
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
                plotBasicInfoData.setVillage(s.toString());
            }
        });

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                if(text.equals("Punjab")) {
                    plotBasicInfoData.setState(text);
                    punjabText.setVisibility(View.VISIBLE);
                    district_punjab.setVisibility(View.VISIBLE);
                    district_punjab.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String text1 = parent.getItemAtPosition(position).toString();
                            plotBasicInfoData.setDistrict_punjab(text1);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (text.equals("Kerala")) {
                    plotBasicInfoData.setState(text);
                    keralaText.setVisibility(View.VISIBLE);
                    district_kerala.setVisibility(View.VISIBLE);
                    district_kerala.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String text1 = parent.getItemAtPosition(position).toString();
                            plotBasicInfoData.setDistrict_kerala(text1);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (text.equals("Andhra Pradesh")) {
                    plotBasicInfoData.setState(text);
                    apText.setVisibility(View.VISIBLE);
                    district_ap.setVisibility(View.VISIBLE);
                    district_ap.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            String text1 = parent.getItemAtPosition(position).toString();
                            plotBasicInfoData.setDistrict_ap(text1);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return plotBasicInfo;
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