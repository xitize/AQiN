package com.xitiz.airqualityindexnepal_aqin.util;

public class AirQualityScale {

    public static String calculateColorLevel(String aqi) {
        int _aqi = Integer.parseInt(aqi);
        if (0 <= _aqi && _aqi <= 50) {
            return "#009966";
        } else if (51 <= _aqi && _aqi <= 100) {
            return "#ffde33";
        } else if (101 <= _aqi && _aqi <= 150) {
            return "#ff9933";
        } else if (151 <= _aqi && _aqi <= 200) {
            return "#cc0033";
        } else if (201 <= _aqi && _aqi <= 300) {
            return "#660099";
        } else if (_aqi >= 300) {
            return "#7e0023";
        }
        return "";
    }

    public static String calculatePollutionLevel(String aqi) {
        int _aqi = Integer.parseInt(aqi);
        if (0 <= _aqi && _aqi <= 50) {
            return "GOOD";
        } else if (51 <= _aqi && _aqi <= 100) {
            return "Moderate";
        } else if (101 <= _aqi && _aqi <= 150) {
            return "Sensitive";
        } else if (151 <= _aqi && _aqi <= 200) {
            return "Unhealthy";
        } else if (201 <= _aqi && _aqi <= 300) {
            return "Very Unhealthy";
        } else if (_aqi >= 300) {
            return "Hazardous";
        }
        return "";
    }


    public static String calculateHealthImplications(String aqi) {
        if (aqi.contains("-")) {
            return "";
        } else {
            int _aqi = Integer.parseInt(aqi);
            if (0 <= _aqi && _aqi <= 50) {
                return "Air quality is considered satisfactory, " +
                        "and air pollution poses little or no risk";
            } else if (51 <= _aqi && _aqi <= 100) {
                return "Air quality is acceptable; however, for some pollutants there may be a moderate health" +
                        " concern for a very small number of people who are unusually sensitive to air pollution.";
            } else if (101 <= _aqi && _aqi <= 150) {
                return "Members of sensitive groups may experience health effects. " +
                        "The general public is not likely to be affected.";
            } else if (151 <= _aqi && _aqi <= 200) {
                return "Everyone may begin to experience health effects; members of sensitive" +
                        " groups may experience more serious health effects";
            } else if (201 <= _aqi && _aqi <= 300) {
                return "Health warnings of emergency conditions." +
                        " The entire population is more likely to be affected.";
            } else if (_aqi >= 300) {
                return "Health alert: everyone may experience more serious health effects";
            }
            return "";
        }


    }

}
