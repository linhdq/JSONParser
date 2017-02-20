package com.example.linhdq.jsonparser.json_model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by linhdq on 2/20/17.
 */

public class Wind {
    @SerializedName("speed")
    private float speed;

    public Wind(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
