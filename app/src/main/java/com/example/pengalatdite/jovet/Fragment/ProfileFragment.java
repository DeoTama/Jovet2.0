package com.example.pengalatdite.jovet.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pengalatdite.jovet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    String resultNama;
    TextView tvResultNama;

    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initComponents();
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null)
            resultNama = extras.getString("result_nama");
        tvResultNama.setText(resultNama);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    private void initComponents() {
       {
            tvResultNama = (TextView) getView().findViewById(R.id.tvResultNama);
        }
    }

}
