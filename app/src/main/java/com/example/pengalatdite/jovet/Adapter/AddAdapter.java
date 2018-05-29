package com.example.pengalatdite.jovet.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pengalatdite.jovet.Add;
import com.example.pengalatdite.jovet.R;

import java.util.ArrayList;
import java.util.List;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.AddViewHolder> {

    private static final String TAG = "AddRecyclerViewAdapter";
    private List<Add> listBooking;
//    private ArrayList<String> dateList;
//    private ArrayList<String> timeList;
    Context mContext;

    public AddAdapter(List<Add> listBooking) {
//        this.dateList = dateList;
//        this.timeList = timeList;
//        this.mContext = mContext;

        this.listBooking = listBooking;

    }

//    public ArrayList<Add> getList() {
//        return dateList;
//    }
//
//    public void setBookingList(ArrayList<Add> bookingList) {
//        this.dateList = bookingList;
//    }

    @NonNull
    @Override
    public AddViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_history, parent, false);
//        AddViewHolder holder = new AddViewHolder(view);
        return new  AddViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Add add = listBooking.get(position);

        holder.date.setText(add.getDate());
        holder.time.setText(add.getTime());
    }

    @Override
    public int getItemCount() {
        return listBooking.size();
    }

    public class AddViewHolder extends RecyclerView.ViewHolder {
        TextView date, time;
        ImageButton deleteButton;
        FrameLayout addListBooking;

        public AddViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.text_view_hari_bulan);
            time = itemView.findViewById(R.id.waktu);
            addListBooking = itemView.findViewById(R.id.rv_booking_history);

            deleteButton = (ImageButton) itemView.findViewById(R.id.delete_jadwal_booking);
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listBooking.remove(getAdapterPosition());
//                    timeList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });
        }
    }
}
