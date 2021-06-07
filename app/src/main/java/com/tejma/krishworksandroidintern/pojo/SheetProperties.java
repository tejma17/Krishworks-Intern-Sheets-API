package com.tejma.krishworksandroidintern.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SheetProperties implements Serializable
{

    @SerializedName("sheetId")
    @Expose
    private Integer sheetId;
    @SerializedName("title")
    @Expose
    private String title;

    /**
     * No args constructor for use in serialization
     *
     */
    public SheetProperties() {
    }

    /**
     *
     * @param sheetId
     * @param title
     */
    public SheetProperties(Integer sheetId, String title) {
        super();
        this.sheetId = sheetId;
        this.title = title;
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
