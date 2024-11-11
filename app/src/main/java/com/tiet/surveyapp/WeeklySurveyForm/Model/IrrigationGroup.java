package com.tiet.surveyapp.WeeklySurveyForm.Model;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.dpro.widgets.OnWeekdaysChangeListener;
import com.dpro.widgets.WeekdaysPicker;
import com.tiet.surveyapp.R;

import java.util.List;

import ernestoyaquello.com.verticalstepperform.Step;

public class IrrigationGroup extends Step<IrrigationGroup.IRrigationGroupData> {
    IRrigationGroupData iRrigationGroupData;

    public class IRrigationGroupData{
        public  String irrigation_yesterday;
        public String irrigation_2daysago;
        public String irrigation_3daysago;
        public String irrigation_4daysago;
        public String irrigation_5daysago;
        public String irrigation_6daysago;
        public String irrigation_7daysago;
        public String irrigation_days;
        public List<String> selectedDays;
        public String irrigation_minutes;
        public String water_cost;

        public IRrigationGroupData(String irrigation_yesterday, String irrigation_2daysago, String irrigation_3daysago, String irrigation_4daysago, String irrigation_5daysago, String irrigation_6daysago, String irrigation_7daysago, String irrigation_days, List<String> selectedDays, String irrigation_minutes, String water_cost) {
            this.irrigation_yesterday = irrigation_yesterday;
            this.irrigation_2daysago = irrigation_2daysago;
            this.irrigation_3daysago = irrigation_3daysago;
            this.irrigation_4daysago = irrigation_4daysago;
            this.irrigation_5daysago = irrigation_5daysago;
            this.irrigation_6daysago = irrigation_6daysago;
            this.irrigation_7daysago = irrigation_7daysago;
            this.irrigation_days = irrigation_days;
            this.selectedDays = selectedDays;
            this.irrigation_minutes = irrigation_minutes;
            this.water_cost = water_cost;
        }

        public String getIrrigation_yesterday() {
            return irrigation_yesterday;
        }

        public void setIrrigation_yesterday(String irrigation_yesterday) {
            this.irrigation_yesterday = irrigation_yesterday;
        }

        public String getIrrigation_2daysago() {
            return irrigation_2daysago;
        }

        public void setIrrigation_2daysago(String irrigation_2daysago) {
            this.irrigation_2daysago = irrigation_2daysago;
        }

        public String getIrrigation_3daysago() {
            return irrigation_3daysago;
        }

        public void setIrrigation_3daysago(String irrigation_3daysago) {
            this.irrigation_3daysago = irrigation_3daysago;
        }

        public String getIrrigation_4daysago() {
            return irrigation_4daysago;
        }

        public void setIrrigation_4daysago(String irrigation_4daysago) {
            this.irrigation_4daysago = irrigation_4daysago;
        }

        public String getIrrigation_5daysago() {
            return irrigation_5daysago;
        }

        public void setIrrigation_5daysago(String irrigation_5daysago) {
            this.irrigation_5daysago = irrigation_5daysago;
        }

        public String getIrrigation_6daysago() {
            return irrigation_6daysago;
        }

        public void setIrrigation_6daysago(String irrigation_6daysago) {
            this.irrigation_6daysago = irrigation_6daysago;
        }

        public String getIrrigation_7daysago() {
            return irrigation_7daysago;
        }

        public void setIrrigation_7daysago(String irrigation_7daysago) {
            this.irrigation_7daysago = irrigation_7daysago;
        }

        public String getIrrigation_days() {
            return irrigation_days;
        }

        public void setIrrigation_days(String irrigation_days) {
            this.irrigation_days = irrigation_days;
        }

        public List<String> getSelectedDays() {
            return selectedDays;
        }

        public void setSelectedDays(List<String> selectedDays) {
            this.selectedDays = selectedDays;
        }

        public String getIrrigation_minutes() {
            return irrigation_minutes;
        }

        public void setIrrigation_minutes(String irrigation_minutes) {
            this.irrigation_minutes = irrigation_minutes;
        }

        public String getWater_cost() {
            return water_cost;
        }

        public void setWater_cost(String water_cost) {
            this.water_cost = water_cost;
        }
    }


    public IrrigationGroup(String title) {
        super(title);
    }

    @Override
    public IRrigationGroupData getStepData() {

        return iRrigationGroupData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(IRrigationGroupData data) {

    }

    @Override
    protected IsDataValid isStepDataValid(IRrigationGroupData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        iRrigationGroupData = new IRrigationGroupData("**","**","**","**","**","**","**","**",null,"**","**");
        View irrigationGroup = inflater.inflate(R.layout.irrigation_group, null, false);
        EditText yesterdayET=irrigationGroup.findViewById(R.id.editTextTextPersonName);
        EditText twodaysagoET=irrigationGroup.findViewById(R.id.editTextTextPersonName2);
        EditText threedaysagoET=irrigationGroup.findViewById(R.id.editTextTextPersonName3);
        EditText fourdaysagoET=irrigationGroup.findViewById(R.id.editTextTextPersonName4);
        EditText fivedaysagoET=irrigationGroup.findViewById(R.id.editTextTextPersonName5);
        EditText sixdaysagoET=irrigationGroup.findViewById(R.id.editTextTextPersonName6);
        EditText sevendaysagoET=irrigationGroup.findViewById(R.id.editTextTextPersonName7);
        EditText irrigationTimeET = irrigationGroup.findViewById(R.id.editTextTextPersonName8);
        EditText irrigationCostET = irrigationGroup.findViewById(R.id.editTextTextPersonName9);

        irrigationTimeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                iRrigationGroupData.setIrrigation_minutes(s.toString());
            }
        });
        irrigationCostET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                iRrigationGroupData.setWater_cost(s.toString());
            }
        });

        sevendaysagoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                iRrigationGroupData.setIrrigation_7daysago(s.toString());
            }
        });
        sixdaysagoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                iRrigationGroupData.setIrrigation_6daysago(s.toString());
            }
        });
        fivedaysagoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                iRrigationGroupData.setIrrigation_5daysago(s.toString());
            }
        });
        fourdaysagoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                iRrigationGroupData.setIrrigation_4daysago(s.toString());
            }
        });
        threedaysagoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            iRrigationGroupData.setIrrigation_3daysago(s.toString());
            }
        });

        twodaysagoET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            iRrigationGroupData.setIrrigation_2daysago(s.toString());
            }
        });

        yesterdayET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            iRrigationGroupData.setIrrigation_yesterday(s.toString());
            }
        });

        WeekdaysPicker widget = (WeekdaysPicker) irrigationGroup.findViewById(R.id.weekdays);

        widget.setOnWeekdaysChangeListener(new OnWeekdaysChangeListener() {
            @Override
            public void onChange(View view, int clickedDayOfWeek, List<Integer> selectedDays) {
              iRrigationGroupData.setSelectedDays(widget.getSelectedDaysText());

            }
        });

        return irrigationGroup;
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
