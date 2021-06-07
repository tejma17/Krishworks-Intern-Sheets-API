package com.tejma.krishworksandroidintern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.tejma.krishworksandroidintern.api.ApiClient;
import com.tejma.krishworksandroidintern.pojo.AddSheetObject;
import com.tejma.krishworksandroidintern.pojo.CopyPasteObject;
import com.tejma.krishworksandroidintern.pojo.SheetGrid;
import com.tejma.krishworksandroidintern.pojo.SheetProperties;
import com.tejma.krishworksandroidintern.pojo.ValueClass;
import com.tejma.krishworksandroidintern.databinding.ActivitySheetsBinding;
import com.tejma.krishworksandroidintern.requests.AddSheetRequest;
import com.tejma.krishworksandroidintern.requests.AddSheetRequestBody;
import com.tejma.krishworksandroidintern.requests.CopyPasteRequestBody;
import com.tejma.krishworksandroidintern.requests.CopyPasteSheetRequest;
import com.tejma.krishworksandroidintern.responses.BatchUpdateResponse;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SheetsActivity extends AppCompatActivity {

    private ActivitySheetsBinding binding;
    private String token, sheetId;
    int oldSheetId = 0;
    int newSheetId = 1;
    private String[] list, updateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySheetsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        //sheet URL: "https://docs.google.com/spreadsheets/d/1xJMOWI1_uT8oAtiM4vxUmDYk_EcHTj4wkqQZuxnu0T4/edit"

        token = "Bearer ya29.a0AfH6SMDLzvxpVNkmsJ0nvNl8uACrH_2ayocDWqx803Ee0qym0MXERNXAsHJGUws0lWVgSmEmhdSjgzzUsVxq_29EhMORqvq9-fHBhv5LMVdvgchfd-ZF9ds-FBIbj2eYbqCYwOvfB-BPY8hssoOXpzvi0IpCrw";
        sheetId = "1xJMOWI1_uT8oAtiM4vxUmDYk_EcHTj4wkqQZuxnu0T4";


        binding.trigger.setOnClickListener(view->getValues());

    }


    //First get values from sheet to assess the results
    private void getValues() {
        Toast.makeText(this, "Trigger activated", Toast.LENGTH_SHORT).show();

        Call<ValueClass> userRequestCall = ApiClient.getUserService().getValues(token, sheetId, "C2:C10","COLUMNS");
        userRequestCall.enqueue(new Callback<ValueClass>() {
            @Override
            public void onResponse(Call<ValueClass> call, Response<ValueClass> response) {
                if(response.isSuccessful()) {
                    ValueClass valueClass = response.body();
                    list = valueClass.getArr()[0];
                    Log.d("TAG", "GOT VALUES");
                    updateList();
                } else {
                    Log.d("TAG", "ERROR GETTING");
                }
            }
            @Override
            public void onFailure(Call<ValueClass> call, Throwable t) {
                Log.d("TAG", "ERROR GETTING 2");
            }
        });

    }

    //update labels pass or fail
    //Criteria: pass if marks >= 40
    private void updateList() {
        int listSize = list.length;
        updateList = new String[listSize+1];
        updateList[0] = "Status";
        for(int i=0; i<listSize; i++) {
            if (Integer.parseInt(list[i]) < 40)
                updateList[i+1] = "Fail";
            else
                updateList[i+1] = "Pass";
        }
        createSheet(updateList);

    }


    //create a second sheet named "Results" in same spreadsheet
    private void createSheet(String[] updateList) {
        SheetProperties properties = new SheetProperties(newSheetId, "Results");
        AddSheetObject addSheetObject = new AddSheetObject(properties);
        AddSheetRequest addSheetRequest = new AddSheetRequest(addSheetObject);
        List<AddSheetRequest> sheetRequestList = new ArrayList<>();
        sheetRequestList.add(addSheetRequest);
        AddSheetRequestBody addSheetRequestBody = new AddSheetRequestBody(sheetRequestList);


        Call<BatchUpdateResponse> userRequestCall = ApiClient.getUserService().createNewSheet(token, sheetId, addSheetRequestBody);
        userRequestCall.enqueue(new Callback<BatchUpdateResponse>() {
            @Override
            public void onResponse(Call<BatchUpdateResponse> call, Response<BatchUpdateResponse> response) {
                if(response.isSuccessful()) {
                    Log.d("TAG", "CREATED NEW SHEET");
                    copyToNewSheet(updateList);
                } else {
                    Log.d("TAG", "ERROR CREATING");
                }
            }
            @Override
            public void onFailure(Call<BatchUpdateResponse> call, Throwable t) {
                Log.d("TAG", "ERROR CREATING 2");
            }
        });
    }


    //copy data from first sheet to newly created sheet
    private void copyToNewSheet(String[] updateList) {

        SheetGrid source = new SheetGrid(oldSheetId, 0, updateList.length, 0, 3);
        SheetGrid destination = new SheetGrid(newSheetId, 0, updateList.length, 0, 3);
        CopyPasteObject copyPasteObject = new CopyPasteObject(source, destination);
        CopyPasteSheetRequest copyPasteSheetRequest = new CopyPasteSheetRequest(copyPasteObject);
        List<CopyPasteSheetRequest> copyPasteSheetRequests = new ArrayList<>();
        copyPasteSheetRequests.add(copyPasteSheetRequest);
        CopyPasteRequestBody copyPasteRequestBody = new CopyPasteRequestBody(copyPasteSheetRequests);

        Call<ResponseBody> userRequestCall = ApiClient.getUserService().copyPasteValues(token, sheetId, copyPasteRequestBody);
        userRequestCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    Log.d("TAG", "COPY PASTE SUCCESSFUL");
                    updateValues(updateList);
                } else {
                    Log.d("TAG", "ERROR COPY PASTE");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "ERROR COPY PASTE2");
            }
        });
    }


    //append the Results column in newly created sheet
    private void updateValues(String[] updateList) {
        String[][] arr = new String[1][updateList.length];
        arr[0] = updateList;
        String range = "Results!D1:D"+updateList.length;
        ValueClass valueClass = new ValueClass(range, "COLUMNS", arr);

        Call<ResponseBody> userRequestCall = ApiClient.getUserService().updateResult(token, sheetId, range,
                "USER_ENTERED", valueClass);
        userRequestCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    Log.d("TAG", "UPDATE SUCCESSFUL");
                    Toast.makeText(SheetsActivity.this, "Operation Completed", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("TAG", "ERROR UPDATING");
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "ERROR UPDATING2");
            }
        });
    }

}