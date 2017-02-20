package com.example.linhdq.jsonparser.json_model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by linhdq on 2/20/17.
 */

public class Main {
    @SerializedName("temp")
    private float temp;
    @SerializedName("pressure")
    private float pressure;
    @SerializedName("humidity")
    private int humidity;

    public Main(float temp, float pressure, int humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
