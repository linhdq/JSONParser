package com.example.linhdq.jsonparser.json_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by linhdq on 2/20/17.
 */

public class WeatherInfo {
    @SerializedName("weather")
    private List<WeatherItem> weatherItemList;
    @SerializedName("main")
    private Main mainModel;
    @SerializedName("wind")
    private Wind windModel;

    public WeatherInfo(List<WeatherItem> weatherItemList, Main mainModel, Wind windModel) {
        this.weatherItemList = weatherItemList;
        this.mainModel = mainModel;
        this.windModel = windModel;
    }

    public List<WeatherItem> getWeatherItemList() {
        return weatherItemList;
    }

    public void setWeatherItemList(List<WeatherItem> weatherItemList) {
        this.weatherItemList = weatherItemList;
    }

    public Main getMainModel() {
        return mainModel;
    }

    public void setMainModel(Main mainModel) {
        this.mainModel = mainModel;
    }

    public Wind getWindModel() {
        return windModel;
    }

    public void setWindModel(Wind windModel) {
        this.windModel = windModel;
    }
}
