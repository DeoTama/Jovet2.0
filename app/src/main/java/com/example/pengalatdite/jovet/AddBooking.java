package com.example.pengalatdite.jovet;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class AddBooking extends AppCompatActivity {

    private static final String TAG = "AddBooking";

    Calendar dateTime = Calendar.getInstance();
    DateFormat dateFormat = DateFormat.getDateTimeInstance();

    private TextView mDisplayDate;
    private TextView mDisplayTime;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;

    private Button btnAdd;

    String dateHrBln, dateThn, time;

    public static String EXTRA_DATE = "extra_date";
    public static String EXTRA_TIME = "extra_time";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_booking);
        mDisplayDate = (TextView)findViewById(R.id.tvDate);
        mDisplayTime = (TextView) findViewById(R.id.tvTime);
        btnAdd = (Button)findViewById(R.id.add_booking_button);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                int tahun = myCalendar.get(Calendar.YEAR);
                int bulan = myCalendar.get(Calendar.MONTH);
                int hari = myCalendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddBooking.this,
                        mDateSetListener,
                        tahun, bulan, hari);
                dialog.show();
            }
        });

        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myTime = Calendar.getInstance();
                int jam = myTime.get(Calendar.HOUR_OF_DAY);
                int menit = myTime.get(Calendar.MINUTE);

                TimePickerDialog dialog = new TimePickerDialog(
                        AddBooking.this,
                        mTimeSetListener,
                        jam, menit,
                        android.text.format.DateFormat.is24HourFormat(AddBooking.this));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yy: " + dayOfMonth + "/" + month + "/" + year);

                String date = dayOfMonth + "/" + month + "/" + year;
                mDisplayDate.setText(date);

                dateHrBln = dayOfMonth + "/" + month;
                dateThn = "/" + year;
            }
        };

        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d(TAG, "onTimeSet: hh:mm" + hourOfDay + "/" + minute);

                time = hourOfDay + ":" + minute;
                mDisplayTime.setText(time);
            }
        };

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBooking();
            }
        });

    }

    private void addBooking (){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, time);
        intent.putExtra(EXTRA_DATE, dateHrBln+dateThn);
//        intent.putExtra(EXTRA_DATE_THN, dateThn)
        Log.d(TAG, "addBooking: Date " + dateHrBln+dateThn);
        Log.d(TAG, "addBooking: Time " + time);

        setResult(Activity.RESULT_OK, intent);
        finish();

    }

}
