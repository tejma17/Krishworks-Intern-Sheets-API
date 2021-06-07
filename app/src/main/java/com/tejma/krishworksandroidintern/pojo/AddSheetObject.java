package com.tejma.krishworksandroidintern.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddSheetObject implements Serializable
{

    @SerializedName("properties")
    @Expose
    private SheetProperties properties;

    public AddSheetObject() {
    }

    /**
     *
     * @param properties
     */
    public AddSheetObject(SheetProperties properties) {
        super();
        this.properties = properties;
    }

    public SheetProperties getProperties() {
        return properties;
    }

    public void setProperties(SheetProperties properties) {
        this.properties = properties;
    }

}