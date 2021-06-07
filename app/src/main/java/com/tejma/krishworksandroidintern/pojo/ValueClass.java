package com.tejma.krishworksandroidintern.pojo;

import com.google.gson.annotations.SerializedName;

public class ValueClass {

    @SerializedName("range")
    String range;

    @SerializedName("majorDimension")
    String majorDim;

    @SerializedName("values")
    String arr[][];

    public ValueClass(String range, String majorDim, String[][] arr) {
        this.range = range;
        this.majorDim = majorDim;
        this.arr = arr;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMajorDim() {
        return majorDim;
    }

    public void setMajorDim(String majorDim) {
        this.majorDim = majorDim;
    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }
}
