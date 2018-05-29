package com.example.pengalatdite.jovet.Model;

import android.util.Log;

import com.example.pengalatdite.jovet.Animals;
import com.example.pengalatdite.jovet.R;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class AnimalsModel {

    private ArrayList<Animals> model = new ArrayList<>();

    public void animalsData(){
        Log.d(TAG, "animalsData: preparing data");

        model.add(new Animals("Kucing Persia","", R.drawable.foto_kucing_persiamedium));
        model.add(new Animals("Kucing Anggora","", R.drawable.kucing_persia_asli));
        model.add(new Animals("Kucing Kampung","", R.drawable.kucing_persia_asli));
        model.add(new Animals("Anjing Doberman","", R.drawable.doberman2));
        model.add(new Animals("Kucing Retriver","", R.drawable.retriver));
        model.add(new Animals("Kucing Shepherd","", R.drawable.german_shepherd));



    }

    public ArrayList<Animals> getModel() {
        return model;
    }

    public void setModel(ArrayList<Animals> model) {

        this.model = model;
    }
}
