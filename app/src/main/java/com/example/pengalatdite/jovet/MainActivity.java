package com.example.pengalatdite.jovet;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.pengalatdite.jovet.Fragment.AnimalsFragment;
import com.example.pengalatdite.jovet.Fragment.BookingFragment;
import com.example.pengalatdite.jovet.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private FragmentManager fragmentManager;
    private android.support.v4.app.Fragment fragment;
    private BookingFragment bookingFragment;
    private AnimalsFragment animalsFragment;
    private ProfileFragment profileFragment;

//    public static ArrayList<Add> model = new AddBookingModel().getModel();

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

//        bookingFragment = new BookingFragment();
//        animalsFragment = new AnimalsFragment();
//        profileFragment = new ProfileFragment();
        fragmentManager = getSupportFragmentManager();

//        setFragment(bookingFragment);

        bottomNavigationView(mMainNav);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("Menu:", String.valueOf(item.getItemId()));
                switch (item.getItemId()){

                    case R.id.nav_animals:
                        mMainNav.setItemBackgroundResource(R.color.colorBrownYellow);
//                        setFragment(animalsFragment);
                        fragment = new AnimalsFragment();
//                        return true;
                        break;

                    case R.id.nav_booking:
                        mMainNav.setItemBackgroundResource(R.color.colorLightOrange);
//                        setFragment(bookingFragment);
                        fragment = new BookingFragment();
//                        return true;
                        break;

                    case R.id.nav_profile:
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
//                        setFragment(profileFragment);
                        fragment = new ProfileFragment();
//                        return true;
                        break;

                        default:
                            return false;
                }
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_frame, fragment).commit();

                return true;

            }
        });
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_frame, new BookingFragment()).commit();


//        ImageButton addBooking = (ImageButton)findViewById(R.id.addButton);
//        addBooking.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, AddBooking.class);
//                startActivityForResult(intent, 1);
//            }
//        });

    }

//    private void setFragment(android.support.v4.app.Fragment fragment) {
//
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.main_frame, fragment).commit();
//
//    }

    public void bottomNavigationView(BottomNavigationView bottomNavigationView){
        bottomNavigationView.setSelectedItemId(R.id.nav_booking);
    }

//    public void onActivityResult(int requestCode, int resultCode, Intent data){
//        if (requestCode == 1){
//            if ((resultCode == Activity.RESULT_OK)){
//                Bundle extras = data.getExtras();
//                if (extras != null){
//                    String date = extras.getString(AddBooking.EXTRA_DATE);
//                    String time = extras.getString(AddBooking.EXTRA_TIME);
//                    Log.d(TAG, "onActivityResult: date recived " + date);
//                    Log.d(TAG, "onActivityResult: time recived " + time);
//                    Add addBooking = new Add(date, time);
//                    model.add(addBooking);
//                    BookingFragment.adapter.setBookingList(model);
//                    BookingFragment.adapter.notifyItemInserted(model.size());
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

}
