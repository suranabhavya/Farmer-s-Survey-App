package com.tiet.surveyapp.WeeklySurveyForm.Model;

import com.tiet.surveyapp.CropDiseaseSurveyForm.Model.CropDamageGroup;

public class WeekSurveyData {
    public WeekSurveyData() {
    }

    static public String userID;
    static public BasicSurveyDetails.BasicSurveyData basicSurveyData;
    static public LandPreparation.LandPreparationData landPreparationData;
    static public IrrigationGroup.IRrigationGroupData iRrigationGroupData;
    static public FertilizerGroup.FertilizerGroupData fertilizerGroupData;
    static public GeneralWork.GeneralWorkData generalWorkData;
    static public HerbicideGroup.HerbicideGroupData herbicideGroupData;
    static public MachineryGroup.MachineryGroupData machineryGroupData;
    static public PesticideGroup.PesticideGroupData pesticideGroupData;
    static public WeedingGroup.WeedingGroupData weedingGroupData;
    static public HarvestingGroup.HarvestingGroupData harvestingGroupData;
    static public MaintenanceGroup.MaintenanceGroupData maintenanceGroupData;
    static public MarketingGroup.MarketingGroupData marketingGroupData;

    public static HarvestingGroup.HarvestingGroupData getHarvestingGroupData() {
        return harvestingGroupData;
    }

    public static void setHarvestingGroupData(HarvestingGroup.HarvestingGroupData harvestingGroupData) {
        WeekSurveyData.harvestingGroupData = harvestingGroupData;
    }

    public static MaintenanceGroup.MaintenanceGroupData getMaintenanceGroupData() {
        return maintenanceGroupData;
    }

    public static void setMaintenanceGroupData(MaintenanceGroup.MaintenanceGroupData maintenanceGroupData) {
        WeekSurveyData.maintenanceGroupData = maintenanceGroupData;
    }

    public static MarketingGroup.MarketingGroupData getMarketingGroupData() {
        return marketingGroupData;
    }

    public static void setMarketingGroupData(MarketingGroup.MarketingGroupData marketingGroupData) {
        WeekSurveyData.marketingGroupData = marketingGroupData;
    }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        WeekSurveyData.userID = userID;
    }

    public static BasicSurveyDetails.BasicSurveyData getBasicSurveyData() {
        return basicSurveyData;
    }

    public static void setBasicSurveyData(BasicSurveyDetails.BasicSurveyData basicSurveyData) {
        WeekSurveyData.basicSurveyData = basicSurveyData;
    }

    public static LandPreparation.LandPreparationData getLandPreparationData() {
        return landPreparationData;
    }

    public static void setLandPreparationData(LandPreparation.LandPreparationData landPreparationData) {
        WeekSurveyData.landPreparationData = landPreparationData;
    }

    public static IrrigationGroup.IRrigationGroupData getiRrigationGroupData() {
        return iRrigationGroupData;
    }

    public static void setiRrigationGroupData(IrrigationGroup.IRrigationGroupData iRrigationGroupData) {
        WeekSurveyData.iRrigationGroupData = iRrigationGroupData;
    }

    public static FertilizerGroup.FertilizerGroupData getFertilizerGroupData() {
        return fertilizerGroupData;
    }

    public static void setFertilizerGroupData(FertilizerGroup.FertilizerGroupData fertilizerGroupData) {
        WeekSurveyData.fertilizerGroupData = fertilizerGroupData;
    }

    public static GeneralWork.GeneralWorkData getGeneralWorkData() {
        return generalWorkData;
    }

    public static void setGeneralWorkData(GeneralWork.GeneralWorkData generalWorkData) {
        WeekSurveyData.generalWorkData = generalWorkData;
    }

    public static HerbicideGroup.HerbicideGroupData getHerbicideGroupData() {
        return herbicideGroupData;
    }

    public static void setHerbicideGroupData(HerbicideGroup.HerbicideGroupData herbicideGroupData) {
        WeekSurveyData.herbicideGroupData = herbicideGroupData;
    }

    public static MachineryGroup.MachineryGroupData getMachineryGroupData() {
        return machineryGroupData;
    }

    public static void setMachineryGroupData(MachineryGroup.MachineryGroupData machineryGroupData) {
        WeekSurveyData.machineryGroupData = machineryGroupData;
    }

    public static PesticideGroup.PesticideGroupData getPesticideGroupData() {
        return pesticideGroupData;
    }

    public static void setPesticideGroupData(PesticideGroup.PesticideGroupData pesticideGroupData) {
        WeekSurveyData.pesticideGroupData = pesticideGroupData;
    }

    public static WeedingGroup.WeedingGroupData getWeedingGroupData() {
        return weedingGroupData;
    }

    public static void setWeedingGroupData(WeedingGroup.WeedingGroupData weedingGroupData) {
        WeekSurveyData.weedingGroupData = weedingGroupData;
    }
}
