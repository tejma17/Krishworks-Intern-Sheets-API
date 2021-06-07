package com.tejma.krishworksandroidintern.requests;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tejma.krishworksandroidintern.pojo.CopyPasteObject;

public class CopyPasteSheetRequest implements Serializable
{

    @SerializedName("copyPaste")
    @Expose
    private CopyPasteObject copyPaste;

    /**
     * No args constructor for use in serialization
     *
     */
    public CopyPasteSheetRequest() {
    }

    /**
     *
     * @param copyPaste
     */
    public CopyPasteSheetRequest(CopyPasteObject copyPaste) {
        super();
        this.copyPaste = copyPaste;
    }

    public CopyPasteObject getCopyPaste() {
        return copyPaste;
    }

    public void setCopyPaste(CopyPasteObject copyPaste) {
        this.copyPaste = copyPaste;
    }

}