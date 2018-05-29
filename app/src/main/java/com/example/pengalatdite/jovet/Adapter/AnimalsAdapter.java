package com.example.pengalatdite.jovet.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pengalatdite.jovet.Animals;
import com.example.pengalatdite.jovet.DescriptionAnimals;
import com.example.pengalatdite.jovet.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private List<Animals> listHewan;
//    private ArrayList<String> mTxtJenis;
//    private ArrayList<Integer> mIcon;

    public AnimalsAdapter(List<Animals> listHewan) {
//        this.mTxtJenis = mTxtJenis;
//        this.mIcon = mIcon;
//        this.mContext = mContext;

        this.listHewan = listHewan;
    }

    @NonNull
    @Override
    public AnimalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_animals, parent, false);
//        AnimalsViewHolder holder = new AnimalsViewHolder(view);
        return new AnimalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final Context context = holder.itemView.getContext();

        final Animals hewan = listHewan.get(position);

        Glide.with(context)
                .asBitmap()
                .load(hewan.getImageId())
                .into(holder.icon);

        holder.txtJenis.setText(hewan.getDeskripsiHewan());

        holder.listAnimalsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + hewan.getDeskripsiHewan());

                Toast.makeText(context, hewan.getDeskripsiHewan(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DescriptionAnimals.class);
                intent.putExtra("image_url", hewan.getImageId());
                intent.putExtra("image_name", hewan.getDeskripsiHewan());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listHewan.size();
    }


    public class AnimalsViewHolder extends RecyclerView.ViewHolder {
        public TextView txtJenis;
        public CircleImageView icon;
        FrameLayout listAnimalsLayout;

        public AnimalsViewHolder(View itemView) {
            super(itemView);
            txtJenis = itemView.findViewById(R.id.jenis_hewan);
            icon = itemView.findViewById(R.id.imageView2);
            listAnimalsLayout = itemView.findViewById(R.id.list_animals_layout);
        }
    }
}
