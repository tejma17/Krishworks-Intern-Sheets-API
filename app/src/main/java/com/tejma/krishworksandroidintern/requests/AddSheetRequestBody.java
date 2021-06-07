package com.tejma.krishworksandroidintern.requests;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddSheetRequestBody implements Serializable
{

    @SerializedName("requests")
    @Expose
    private List<AddSheetRequest> requests = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddSheetRequestBody() {
    }

    /**
     *
     * @param requests
     */
    public AddSheetRequestBody(List<AddSheetRequest> requests) {
        super();
        this.requests = requests;
    }

    public List<AddSheetRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<AddSheetRequest> requests) {
        this.requests = requests;
    }

}