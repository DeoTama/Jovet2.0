package com.example.pengalatdite.jovet.apihelper;

public class UtilsApi {
    public static final String BASE_URL_API = "jovet.000webhostapp.com";

    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}