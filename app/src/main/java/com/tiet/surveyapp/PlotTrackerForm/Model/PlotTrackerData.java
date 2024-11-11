package com.tiet.surveyapp.PlotTrackerForm.Model;

public class PlotTrackerData {

    public static  String userID;;
    static public PlotBasicInfo.PlotBasicInfoData plotBasicInfoData;
    static public PlotDripGroup.PlotDripGroupData plotDripGroupData;
    static public PlotGroup.PlotGroupData plotGroupData;
    static public PlotIrrigationGroup.PlotIrrigationGroupData plotIrrigationGroupData;
    static public PlotPastGroup.PlotPastGroupData plotPastGroupData;
    static public PumpGroup.PumpGroupData pumpGroupData;
    static public WaterSourceGroup.WaterSourceGroupData waterSourceGroupData;

    public PlotTrackerData() {
    }

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        PlotTrackerData.userID = userID;
    }

    public static PlotBasicInfo.PlotBasicInfoData getPlotBasicInfoData() {
        return plotBasicInfoData;
    }

    public static void setPlotBasicInfoData(PlotBasicInfo.PlotBasicInfoData plotBasicInfoData) {
        PlotTrackerData.plotBasicInfoData = plotBasicInfoData;
    }

    public static PlotDripGroup.PlotDripGroupData getPlotDripGroupData() {
        return plotDripGroupData;
    }

    public static void setPlotDripGroupData(PlotDripGroup.PlotDripGroupData plotDripGroupData) {
        PlotTrackerData.plotDripGroupData = plotDripGroupData;
    }

    public static PlotGroup.PlotGroupData getPlotGroupData() {
        return plotGroupData;
    }

    public static void setPlotGroupData(PlotGroup.PlotGroupData plotGroupData) {
        PlotTrackerData.plotGroupData = plotGroupData;
    }

    public static PlotIrrigationGroup.PlotIrrigationGroupData getPlotIrrigationGroupData() {
        return plotIrrigationGroupData;
    }

    public static void setPlotIrrigationGroupData(PlotIrrigationGroup.PlotIrrigationGroupData plotIrrigationGroupData) {
        PlotTrackerData.plotIrrigationGroupData = plotIrrigationGroupData;
    }

    public static PlotPastGroup.PlotPastGroupData getPlotPastGroupData() {
        return plotPastGroupData;
    }

    public static void setPlotPastGroupData(PlotPastGroup.PlotPastGroupData plotPastGroupData) {
        PlotTrackerData.plotPastGroupData = plotPastGroupData;
    }

    public static PumpGroup.PumpGroupData getPumpGroupData() {
        return pumpGroupData;
    }

    public static void setPumpGroupData(PumpGroup.PumpGroupData pumpGroupData) {
        PlotTrackerData.pumpGroupData = pumpGroupData;
    }

    public static WaterSourceGroup.WaterSourceGroupData getWaterSourceGroupData() {
        return waterSourceGroupData;
    }

    public static void setWaterSourceGroupData(WaterSourceGroup.WaterSourceGroupData waterSourceGroupData) {
        PlotTrackerData.waterSourceGroupData = waterSourceGroupData;
    }
}
