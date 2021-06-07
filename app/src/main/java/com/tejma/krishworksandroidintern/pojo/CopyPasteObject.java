package com.tejma.krishworksandroidintern.pojo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CopyPasteObject implements Serializable
{

    @SerializedName("source")
    @Expose
    private SheetGrid source;
    @SerializedName("destination")
    @Expose
    private SheetGrid destination;
    private final static long serialVersionUID = 4706610739653392502L;

    /**
     * No args constructor for use in serialization
     *
     */
    public CopyPasteObject() {
    }

    /**
     *
     * @param destination
     * @param source
     */
    public CopyPasteObject(SheetGrid source, SheetGrid destination) {
        super();
        this.source = source;
        this.destination = destination;
    }

    public SheetGrid getSource() {
        return source;
    }

    public void setSource(SheetGrid source) {
        this.source = source;
    }

    public SheetGrid getDestination() {
        return destination;
    }

    public void setDestination(SheetGrid destination) {
        this.destination = destination;
    }

}