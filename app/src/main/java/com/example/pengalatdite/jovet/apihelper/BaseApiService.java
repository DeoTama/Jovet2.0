package com.example.pengalatdite.jovet.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("name") String name,
                                       @Field("email") String email,
                                       @Field("username") String username,
                                       @Field("password") String password,
                                       @Field("website") String website);
}
