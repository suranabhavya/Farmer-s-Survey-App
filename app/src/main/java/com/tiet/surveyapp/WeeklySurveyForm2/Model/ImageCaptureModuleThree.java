package com.tiet.surveyapp.WeeklySurveyForm2.Model;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tiet.surveyapp.R;

import ernestoyaquello.com.verticalstepperform.Step;

public class ImageCaptureModuleThree extends Step<String>  {

    static ImageView imageView;
    static int choice=101;

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void ImageViewInvisible(){
        imageView.setVisibility(View.GONE);
    }

    public void SetImageView(Bitmap bmp){
        ImageViewInvisible();
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageBitmap(bmp);

    }
    Activity defaultActivity;
    public ImageCaptureModuleThree(String title) {
        super(title);
    }

    @Override
    public String getStepData() {
        return null;
    }

    @Override
    public String getStepDataAsHumanReadableString() {
        return null;
    }

    @Override
    public void restoreStepData(String data) {

    }

    @Override
    protected IsDataValid isStepDataValid(String stepData) {
        return null;
    }

    @Override
    protected View createStepContentLayout() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View imageCaptureView;
        imageCaptureView = inflater.inflate(R.layout.capture_image_layout, null, false);
        imageView = imageCaptureView.findViewById(R.id.imageView5);

        ImageViewInvisible();
        Button cameraButton = imageCaptureView.findViewById(R.id.button2);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               defaultActivity = (Activity) getContext();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                defaultActivity.startActivityForResult(cameraIntent,choice);

            }
        });
        return imageCaptureView;
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
