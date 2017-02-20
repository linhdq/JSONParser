package com.example.linhdq.jsonparser.json_model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by linhdq on 2/20/17.
 */

public class WeatherItem {
    @SerializedName("description")
    private String description;

    public WeatherItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
