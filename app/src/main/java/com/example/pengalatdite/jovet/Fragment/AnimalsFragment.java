package com.example.pengalatdite.jovet.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.pengalatdite.jovet.Adapter.AnimalsAdapter;
import com.example.pengalatdite.jovet.Animals;
import com.example.pengalatdite.jovet.Model.AnimalsModel;
import com.example.pengalatdite.jovet.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsFragment extends Fragment {

    private static final String TAG = "AnimalsFragment";

    private Context mContext;
    private List<Animals> animalsList = new ArrayList<>();
    AnimalsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animals, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstance){
        super.onViewCreated(view, savedInstance);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        adapter = new AnimalsAdapter(animalsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);

        animalsData();

    }

    private void animalsData(){
        Log.d(TAG, "animalsData: preparing data");

//        mImages.add(R.drawable.foto_kucing_persiamedium);
//        mNames.add("Kucing Persia");

        Animals animals = new Animals("Kucing","Kucing Persia", R.drawable.foto_kucing_persiamedium);
        animalsList.add(animals);

//        mImages.add(R.drawable.kucing_persia_asli);
//        mNames.add("Kucing Anggora");

        animals = new Animals("Kucing", "Kucing Anggora", R.drawable.kucing_persia_asli);
        animalsList.add(animals);
//
//        mImages.add(R.drawable.kucing_persia_asli);
//        mNames.add("Kucing Kampung");

        animals = new Animals("Kucing", "Kucing Kampung", R.drawable.kucing_persia_asli);
        animalsList.add(animals);

//        mImages.add(R.drawable.doberman2);
//        mNames.add("Anjing Doberman");

        animals = new Animals("Anjing", "Anjing Doberman", R.drawable.doberman2);
        animalsList.add(animals);

//        mImages.add(R.drawable.retriver);
//        mNames.add("Anjing Retriver");

        animals = new Animals("Anjing", "Anjing Retriver", R.drawable.retriver);
        animalsList.add(animals);

//        mImages.add(R.drawable.german_shepherd);
//        mNames.add("Anjing Shepherd");

        animals = new Animals("Anjing", "Anjing Shepherd", R.drawable.german_shepherd);
        animalsList.add(animals);

        adapter.notifyDataSetChanged();

    }

    public void onAttach (Context mContext){
        super.onAttach(mContext);
        this.mContext = mContext;
    }
}
