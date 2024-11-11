package com.tiet.surveyapp.WeeklySurveyForm.Model;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import ernestoyaquello.com.verticalstepperform.Step;

public class LandPreparation extends Step<LandPreparation.LandPreparationData> {
    LandPreparationData landPreparationData;
    public LandPreparation(String title) {
        super(title);
    }

    @Override
    public LandPreparationData getStepData() {
        return landPreparationData;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(LandPreparationData data) {

    }

    EditText landprepdetails;

public class LandPreparationData{

    public  String landprepdetailsString;
    public  String landPrepStatus;

    public LandPreparationData(String landprepdetailsString, String landPrepStatus) {
        this.landprepdetailsString = landprepdetailsString;
        this.landPrepStatus = landPrepStatus;
    }

    public String getLandprepdetailsString() {
        return landprepdetailsString;
    }

    public void setLandprepdetailsString(String landprepdetailsString) {
        this.landprepdetailsString = landprepdetailsString;
    }

    public String getLandPrepStatus() {
        return landPrepStatus;
    }

    public void setLandPrepStatus(String landPrepStatus) {
        this.landPrepStatus = landPrepStatus;
    }
}

    @Override
    protected IsDataValid isStepDataValid(LandPreparationData stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LinearLayout layout = new LinearLayout(getContext());
        landPreparationData = new LandPreparationData("**","**");
        layout.setOrientation(LinearLayout.VERTICAL);
        final RadioButton[] rb = new RadioButton[5];
        RadioGroup rg = new RadioGroup(getContext()); //create the RadioGroup
        rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
        String fields[]={"Yes","No"};
        for(int i=0; i<fields.length; i++){
            rb[i]  = new RadioButton(getContext());
            rb[i].setText(fields[i]);
            rb[i].setId(i + 100);
            rg.addView(rb[i]);
        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                markAsCompleted(true);
                RadioButton rbPressed = group.findViewById(group.getCheckedRadioButtonId());


                if(rbPressed.getText().equals("Yes")){
                    landPreparationData.setLandprepdetailsString("Yes");
                    TextView text = new TextView(getContext());
                    text.setText("What kind of land preparation was done this week?");
                    layout.addView(text);
                    RadioGroup rg2 = new RadioGroup(getContext()); //create the RadioGroup
                    rg2.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
                    String fields[]={"Plowing","Raising beds","Other"};
                    landprepdetails = new EditText(getContext());
                    landprepdetails.setHint("Please specify");
                    final RadioButton[] rb2 = new RadioButton[5];
                    for(int i=0; i<fields.length; i++){
                        rb2[i]  = new RadioButton(getContext());
                        rb2[i].setText(fields[i]);
                        rb2[i].setId(i + 200);
                        rg2.addView(rb2[i]);
                    }
                    layout.addView(rg2);
                    rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            RadioButton rbPressed = group.findViewById(group.getCheckedRadioButtonId());
                            if(rbPressed.getText().equals("Other")){
                                layout.addView(landprepdetails);
                                rb2[0].setEnabled(false);
                                rb2[1].setEnabled(false);

                            }else{
                                landPreparationData.setLandprepdetailsString((String) rbPressed.getText());

                            }
                        }
                    });

                }else if(rbPressed.getText().equals("No")){
                    landPreparationData.setLandPrepStatus("No");
                }
                Toast.makeText(getContext(), "Selected "+rbPressed.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        layout.addView(rg);//you add the whole RadioGroup to the layout

        return layout;
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
