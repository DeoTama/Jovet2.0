package com.example.pengalatdite.jovet.Model;

import com.example.pengalatdite.jovet.Add;
import com.example.pengalatdite.jovet.AddBooking;

import java.util.ArrayList;

public class AddBookingModel {

    private ArrayList<Add> model = new ArrayList<Add>();

    public AddBookingModel(){
        model.add(new Add("12/12/2018", "16.00"));
        model.add(new Add("01/07/2018", "15.00"));
        model.add(new Add("02/04/2018", "19.00"));

    }

    public ArrayList<Add> getModel() {
        return model;
    }

    public void setModel(ArrayList<Add> model) {
        this.model = model;
    }
}
