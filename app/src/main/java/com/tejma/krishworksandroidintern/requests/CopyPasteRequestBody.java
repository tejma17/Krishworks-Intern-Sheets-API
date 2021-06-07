package com.tejma.krishworksandroidintern.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CopyPasteRequestBody {

    @SerializedName("requests")
    @Expose
    private List<CopyPasteSheetRequest> requests = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CopyPasteRequestBody() {
    }

    /**
     *
     * @param requests
     */
    public CopyPasteRequestBody(List<CopyPasteSheetRequest> requests) {
        super();
        this.requests = requests;
    }

    public List<CopyPasteSheetRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<CopyPasteSheetRequest> requests) {
        this.requests = requests;
    }
}
