package com.example.pengalatdite.jovet.Fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.pengalatdite.jovet.Adapter.AddAdapter;
import com.example.pengalatdite.jovet.Add;
import com.example.pengalatdite.jovet.AddBooking;
import com.example.pengalatdite.jovet.MainActivity;
import com.example.pengalatdite.jovet.Model.AddBookingModel;
import com.example.pengalatdite.jovet.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */

public class BookingFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "BookingFragment";

    public static AddAdapter adapter;
    private List<Add> addList = new ArrayList<>();
//    public static ArrayList<String> mDate = new ArrayList<>();
//    public static ArrayList<String> mTime = new ArrayList<>();
    private Context mContext;

    public BookingFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_booking, container, false);
//        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.rv_booking);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new AddAdapter(BookingFragment.model, getContext());
//        recyclerView.setAdapter(adapter);
//
        ImageButton addBtn = (ImageButton) v.findViewById(R.id.addButton);
        addBtn.setOnClickListener((View.OnClickListener) this);

        mContext = container.getContext();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_booking);
        AddAdapter adapter = new AddAdapter(addList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);

        bookingData();
    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(mContext ,AddBooking.class);
//        startActivity(intent);
//
//    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        if (requestCode == 1){
//            if ((resultCode == Activity.RESULT_OK)){
//                Bundle extras = data.getExtras();
//                if (extras != null){
//                    String date = extras.getString(AddBooking.EXTRA_DATE);
//                    String time = extras.getString(AddBooking.EXTRA_TIME);
//                        Log.d(TAG, "onActivityResult: date recived " + date);
//                        Log.d(TAG, "onActivityResult: time recived " + time);
//                    Add addBooking = new Add(date, time);
//                    model.add(addBooking);
//                    adapter.setBookingList(model);
//                    adapter.notifyItemInserted(model.size());
//                }
//
//            }
//
//            if (resultCode == Activity.RESULT_CANCELED){
//
//            }
//        }
//
//    }

    protected void bookingData(){
        Log.d(TAG, "bookingData: preparing data");

//        mDate.add("08/08/2018");
//        mTime.add("19.00");

        Add add = new Add("08/08/2018", "19.00");
        addList.add(add);

//        mDate.add("02/04/2018");
//        mTime.add("13.00");

        add = new Add("02/04/2018", "13.00");
        addList.add(add);

//        mDate.add("27/10/2018");
//        mTime.add("12.00");

        add = new Add("27/10/2018", "12.00");
        addList.add(add);

    }

    public static AddAdapter getAdapter() {
        return adapter;
    }

    public static void setAdapter(AddAdapter adapter) {
        BookingFragment.adapter = adapter;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext ,AddBooking.class);
        startActivity(intent);
    }
}
