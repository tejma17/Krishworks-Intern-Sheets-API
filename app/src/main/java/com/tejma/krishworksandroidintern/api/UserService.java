package com.tejma.krishworksandroidintern.api;


import com.tejma.krishworksandroidintern.pojo.ValueClass;
import com.tejma.krishworksandroidintern.requests.AddSheetRequestBody;
import com.tejma.krishworksandroidintern.requests.CopyPasteRequestBody;
import com.tejma.krishworksandroidintern.requests.CopyPasteSheetRequest;
import com.tejma.krishworksandroidintern.responses.BatchUpdateResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {


        @POST("/v4/spreadsheets/{spreadSheetId}:batchUpdate")
        Call<BatchUpdateResponse> createNewSheet(@Header ("Authorization") String token,
                                                 @Path("spreadSheetId") String spreadSheetId,
                                                 @Body AddSheetRequestBody addSheetRequestBody);

        @POST("/v4/spreadsheets/{spreadSheetId}:batchUpdate")
        Call<ResponseBody> copyPasteValues(@Header ("Authorization") String token,
                                           @Path("spreadSheetId") String id,
                                           @Body CopyPasteRequestBody copyPasteRequestBody);

        @GET("/v4/spreadsheets/{spreadSheetId}/values/{range}")
        Call<ValueClass> getValues(@Header ("Authorization") String token,
                                   @Path("spreadSheetId") String id,
                                   @Path("range") String range,
                                   @Query("majorDimension") String column);


        @PUT("/v4/spreadsheets/{spreadSheetId}/values/{range}")
        Call<ResponseBody> updateResult(@Header ("Authorization") String token,
                                      @Path("spreadSheetId") String id,
                                      @Path("range") String range,
                                      @Query("valueInputOption") String valueOption,
                                      @Body ValueClass valueClass);
}
