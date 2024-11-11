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

public class MarketingGroup extends Step<MarketingGroup.MarketingGroupData> {
    MarketingGroupData marketingGroupData;
    public class MarketingGroupData {
        public String sell_yesno;
        public String sold_in_kg;
        public String selling_options;
        public String other_selling_options;
        public String transportation_cost;
        public String produce_price_yesno;
        public String price_def_reason;
        public String other_pricedef_reason;
        public String average_price;
        public String revenue;

        public MarketingGroupData(String sell_yesno, String sold_in_kg, String selling_options, String other_selling_options, String transportation_cost, String produce_price_yesno, String price_def_reason, String other_pricedef_reason, String average_price, String revenue) {
            this.sell_yesno = sell_yesno;
            this.sold_in_kg = sold_in_kg;
            this.selling_options = selling_options;
            this.other_selling_options = other_selling_options;
            this.transportation_cost = transportation_cost;
            this.produce_price_yesno = produce_price_yesno;
            this.price_def_reason = price_def_reason;
            this.other_pricedef_reason = other_pricedef_reason;
            this.average_price = average_price;
            this.revenue = revenue;
        }

        public void setSell_yesno(String sell_yesno) {
            this.sell_yesno = sell_yesno;
        }

        public void setSold_in_kg(String sold_in_kg) {
            this.sold_in_kg = sold_in_kg;
        }

        public void setSelling_options(String selling_options) {
            this.selling_options = selling_options;
        }

        public void setOther_selling_options(String other_selling_options) {
            this.other_selling_options = other_selling_options;
        }

        public void setTransportation_cost(String transportation_cost) {
            this.transportation_cost = transportation_cost;
        }

        public void setProduce_price_yesno(String produce_price_yesno) {
            this.produce_price_yesno = produce_price_yesno;
        }

        public void setPrice_def_reason(String price_def_reason) {
            this.price_def_reason = price_def_reason;
        }

        public void setOther_pricedef_reason(String other_pricedef_reason) {
            this.other_pricedef_reason = other_pricedef_reason;
        }

        public void setAverage_price(String average_price) {
            this.average_price = average_price;
        }

        public void setRevenue(String revenue) {
            this.revenue = revenue;
        }
    }

    public MarketingGroup(String title) {
        super(title);
    }

    @Override
    public MarketingGroupData getStepData() {
        return marketingGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(MarketingGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(MarketingGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View marketingGroup = inflater.inflate(R.layout.activity_marketing_group, null, false);
        RadioGroup sell_yesno = (RadioGroup) marketingGroup.findViewById(R.id.rg28);
        EditText KG_sold = marketingGroup.findViewById(R.id.editTextTextPersonName51);
        TextView sellingText = marketingGroup.findViewById(R.id.textView36);
        RadioGroup selling_options = (RadioGroup) marketingGroup.findViewById(R.id.rg29);
        EditText other_selling_options = marketingGroup.findViewById(R.id.editTextTextPersonName52);
        EditText transportation_cost = marketingGroup.findViewById(R.id.editTextTextPersonName54);
        TextView produceText = marketingGroup.findViewById(R.id.textView37);
        RadioGroup produce_price_yesno = (RadioGroup) marketingGroup.findViewById(R.id.rg30);
        TextView priceText = marketingGroup.findViewById(R.id.textView38);
        RadioGroup price_def_reason = (RadioGroup) marketingGroup.findViewById(R.id.rg31);
        EditText other_pricedef_reason = marketingGroup.findViewById(R.id.editTextTextPersonName55);
        EditText average_price = marketingGroup.findViewById(R.id.editTextTextPersonName56);
        EditText revenue = marketingGroup.findViewById(R.id.editTextTextPersonName57);
         marketingGroupData = new MarketingGroupData("**","**","**","**","**","**","**","**","**","**");

        KG_sold.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                marketingGroupData.setSold_in_kg(s.toString());
            }
        });

        other_selling_options.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                marketingGroupData.setOther_selling_options(s.toString());
            }
        });

        transportation_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                marketingGroupData.setTransportation_cost(s.toString());
            }
        });

        other_pricedef_reason.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                marketingGroupData.setOther_pricedef_reason(s.toString());
            }
        });

        average_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                marketingGroupData.setAverage_price(s.toString());
            }
        });

        revenue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                marketingGroupData.setRevenue(s.toString());
            }
        });

        sell_yesno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                String checkedString = checked.getText().toString();
                marketingGroupData.setSell_yesno(checkedString);
                if(checkedString.equals("Yes")) {
                    KG_sold.setVisibility(View.VISIBLE);
                    sellingText.setVisibility(View.VISIBLE);
                    selling_options.setVisibility(View.VISIBLE);
                    selling_options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                            String checkedString = checked.getText().toString();
                            marketingGroupData.setSelling_options(checkedString);
                            if(checkedString.equals("Other")) {
                                other_selling_options.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    transportation_cost.setVisibility(View.VISIBLE);
                    produceText.setVisibility(View.VISIBLE);
                    produce_price_yesno.setVisibility(View.VISIBLE);
                    produce_price_yesno.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                            String checkedString = checked.getText().toString();
                            marketingGroupData.setProduce_price_yesno(checkedString);
                            if(checkedString.equals("No")) {
                                priceText.setVisibility(View.VISIBLE);
                                price_def_reason.setVisibility(View.VISIBLE);
                                price_def_reason.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                        RadioButton checked = group.findViewById(group.getCheckedRadioButtonId());
                                        String checkedString = checked.getText().toString();
                                        marketingGroupData.setPrice_def_reason(checkedString);
                                        if(checkedString.equals("Other")) {
                                            other_pricedef_reason.setVisibility(View.VISIBLE);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    average_price.setVisibility(View.VISIBLE);
                    revenue.setVisibility(View.VISIBLE);
                }
            }
        });

        return marketingGroup;
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