package com.example.pengalatdite.jovet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
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

public class LoginActivity extends AppCompatActivity  {

    Button Login_button;
    EditText password_text, username_text;
    TextView register_here;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        initComponents();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    private void initComponents() {


        password_text = (EditText) findViewById(R.id.password_text);
        username_text = (EditText) findViewById(R.id.username_text);
        Login_button = (Button) findViewById(R.id.login_button);
        register_here = (TextView) findViewById(R.id.register_here);

        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                requestLogin();
            }
        });

        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, RegisterActivity.class));
            }
        });
    }

    private void requestLogin() {
            mApiService.loginRequest(username_text.getText().toString(), password_text.getText().toString())
                    .enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()){
                                loading.dismiss();
                                try {
                                    JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                    if (jsonRESULTS.getString("error").equals("false")){
                                        // Jika login berhasil maka data nama yang ada di response API
                                        // akan diparsing ke activity selanjutnya.
                                        Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                        String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                        Intent intent = new Intent(mContext, MainActivity.class);
                                        intent.putExtra("result_nama", nama);
                                        startActivity(intent);
                                    } else {
                                        // Jika login gagal
                                        String error_message = jsonRESULTS.getString("error_msg");
                                        Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                loading.dismiss();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Log.e("debug", "onFailure: ERROR > " + t.toString());
                            loading.dismiss();
                        }
                    });
        }

    }





