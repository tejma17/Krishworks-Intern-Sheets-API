package com.tejma.krishworksandroidintern.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SheetGrid implements Serializable
{

    @SerializedName("sheetId")
    @Expose
    private Integer sheetId;
    @SerializedName("startRowIndex")
    @Expose
    private Integer startRowIndex;
    @SerializedName("endRowIndex")
    @Expose
    private Integer endRowIndex;
    @SerializedName("startColumnIndex")
    @Expose
    private Integer startColumnIndex;
    @SerializedName("endColumnIndex")
    @Expose
    private Integer endColumnIndex;

    /**
     * No args constructor for use in serialization
     *
     */
    public SheetGrid() {
    }

    /**
     *
     * @param endColumnIndex
     * @param endRowIndex
     * @param sheetId
     * @param startColumnIndex
     * @param startRowIndex
     */
    public SheetGrid(Integer sheetId, Integer startRowIndex, Integer endRowIndex, Integer startColumnIndex, Integer endColumnIndex) {
        super();
        this.sheetId = sheetId;
        this.startRowIndex = startRowIndex;
        this.endRowIndex = endRowIndex;
        this.startColumnIndex = startColumnIndex;
        this.endColumnIndex = endColumnIndex;
    }

    public Integer getSheetId() {
        return sheetId;
    }

    public void setSheetId(Integer sheetId) {
        this.sheetId = sheetId;
    }

    public Integer getStartRowIndex() {
        return startRowIndex;
    }

    public void setStartRowIndex(Integer startRowIndex) {
        this.startRowIndex = startRowIndex;
    }

    public Integer getEndRowIndex() {
        return endRowIndex;
    }

    public void setEndRowIndex(Integer endRowIndex) {
        this.endRowIndex = endRowIndex;
    }

    public Integer getStartColumnIndex() {
        return startColumnIndex;
    }

    public void setStartColumnIndex(Integer startColumnIndex) {
        this.startColumnIndex = startColumnIndex;
    }

    public Integer getEndColumnIndex() {
        return endColumnIndex;
    }

    public void setEndColumnIndex(Integer endColumnIndex) {
        this.endColumnIndex = endColumnIndex;
    }

}