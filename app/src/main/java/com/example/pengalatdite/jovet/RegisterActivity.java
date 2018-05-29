package com.example.pengalatdite.jovet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pengalatdite.jovet.apihelper.BaseApiService;
import com.example.pengalatdite.jovet.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Deotama on 5/28/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    Button register_button;
    EditText nameRegister, emailRegister, usernameRegister, passwordRegister,webRegister;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initComponents();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




//        register_button.setOnClickListener(this);
    }

    private void initComponents() {
        nameRegister = (EditText) findViewById(R.id.nameRegister);
        emailRegister = (EditText) findViewById(R.id.emailRegister);
        usernameRegister = (EditText) findViewById(R.id.usernameRegister);
        passwordRegister = (EditText) findViewById(R.id.passwordRegister);
        webRegister = (EditText) findViewById(R.id.webRegister);
        register_button = (Button) findViewById(R.id.register_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestRegister();
            }
        });
    }

    private void requestRegister() {
        mApiService.registerRequest(nameRegister.getText().toString(),
                emailRegister.getText().toString(),
                passwordRegister.getText().toString(),
                usernameRegister.getText().toString(),
                webRegister.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Log.i("debug", "onResponse: BERHASIL");
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Toast.makeText(mContext, "BERHASIL REGISTRASI", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(mContext, LoginActivity.class));
                                } else {
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.i("debug", "onResponse: GA BERHASIL");
                            loading.dismiss();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.getMessage());
                        Toast.makeText(mContext, "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    }



