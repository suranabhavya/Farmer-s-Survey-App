package com.tiet.surveyapp.WeeklySurveyForm2.Model;

public class WeeklySurveyTwoData {
    public static GeneralInfoGroup.GeneralInfoGroupData generalInfoGroupData;
    public static RiceGroup.RiceGroupData riceGroupData;
    public static WheatGroup.WheatGroupData wheatGroupData;

    public WeeklySurveyTwoData() {
    }

    public static GeneralInfoGroup.GeneralInfoGroupData getGeneralInfoGroupData() {
        return generalInfoGroupData;
    }

    public static void setGeneralInfoGroupData(GeneralInfoGroup.GeneralInfoGroupData generalInfoGroupData) {
        WeeklySurveyTwoData.generalInfoGroupData = generalInfoGroupData;
    }

    public static RiceGroup.RiceGroupData getRiceGroupData() {
        return riceGroupData;
    }

    public static void setRiceGroupData(RiceGroup.RiceGroupData riceGroupData) {
        WeeklySurveyTwoData.riceGroupData = riceGroupData;
    }

    public static WheatGroup.WheatGroupData getWheatGroupData() {
        return wheatGroupData;
    }

    public static void setWheatGroupData(WheatGroup.WheatGroupData wheatGroupData) {
        WeeklySurveyTwoData.wheatGroupData = wheatGroupData;
    }
}
