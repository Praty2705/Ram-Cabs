package com.pratyaksh.ramcabs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class CurrentBookingActivity extends AppCompatActivity {

    Dialog mDialog;
    ImageView backarrow;
    Button continueBTN;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_booking);
        mDialog=new Dialog(this);
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mDialog.setContentView(R.layout.cabboookingpopup);
        mDialog.show();




        backarrow = findViewById(R.id.backarrow);
        continueBTN = mDialog.findViewById(R.id.continueBTN);
        continueBTN.setOnClickListener(v -> mDialog.dismiss());
        backarrow.setOnClickListener(v -> finish());




    }
}