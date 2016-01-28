package com.udacity.gradle.builditbigger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alecmedina on 1/20/16.
 */
public class Joke {

    @SerializedName("data")
    @Expose
    private String[] data;

    /**
     *
     * @return
     * The data
     */
    public String[] getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(String[] data) {
        this.data = data;
    }

}
