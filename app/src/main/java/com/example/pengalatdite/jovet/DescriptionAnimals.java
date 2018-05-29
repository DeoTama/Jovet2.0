package com.example.pengalatdite.jovet;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DescriptionAnimals extends AppCompatActivity {

    private static final String TAG = "DescriptionAnimals";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animals_description);
        Log.d(TAG, "onCreate: started");

        getComingIntent();
    }

    private void getComingIntent() {
        Log.d(TAG, "getComingIntent: checking for coming intent");

        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")) {
            Log.d(TAG, "getComingIntent: found intent extras");

            int imageUrl = getIntent().getIntExtra("image_url", 0);
            String imageName = getIntent().getStringExtra("image_name");

            setImage(imageUrl, imageName);

        }
    }

    private void setImage(int imageUrl, String imageName) {
        Log.d(TAG, "setImage: setting the image and name to widgets");

        TextView name = findViewById(R.id.animals_descriprion_image_text);
        name.setText(imageName);

        ImageView image = findViewById(R.id.animals_descriprion_image);
        image.setImageResource(imageUrl);
    }

}
