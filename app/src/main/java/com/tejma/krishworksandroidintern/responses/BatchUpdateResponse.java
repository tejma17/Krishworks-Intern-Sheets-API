package com.tejma.krishworksandroidintern.responses;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tejma.krishworksandroidintern.requests.AddSheetRequest;

public class BatchUpdateResponse implements Serializable
{

    @SerializedName("spreadsheetId")
    @Expose
    private String spreadsheetId;
    @SerializedName("replies")
    @Expose
    private List<AddSheetRequest> replies = null;
    private final static long serialVersionUID = 6056310328117147547L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BatchUpdateResponse() {
    }

    /**
     *
     * @param replies
     * @param spreadsheetId
     */
    public BatchUpdateResponse(String spreadsheetId, List<AddSheetRequest> replies) {
        super();
        this.spreadsheetId = spreadsheetId;
        this.replies = replies;
    }

    public String getSpreadsheetId() {
        return spreadsheetId;
    }

    public void setSpreadsheetId(String spreadsheetId) {
        this.spreadsheetId = spreadsheetId;
    }

    public List<AddSheetRequest> getReplies() {
        return replies;
    }

    public void setReplies(List<AddSheetRequest> replies) {
        this.replies = replies;
    }

}