package com.tejma.krishworksandroidintern.requests;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tejma.krishworksandroidintern.pojo.AddSheetObject;

public class AddSheetRequest implements Serializable
{

    @SerializedName("addSheet")
    @Expose
    private AddSheetObject addSheet;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddSheetRequest() {
    }

    /**
     *
     * @param addSheet
     */
    public AddSheetRequest(AddSheetObject addSheet) {
        super();
        this.addSheet = addSheet;
    }

    public AddSheetObject getAddSheet() {
        return addSheet;
    }

    public void setAddSheet(AddSheetObject addSheet) {
        this.addSheet = addSheet;
    }

}