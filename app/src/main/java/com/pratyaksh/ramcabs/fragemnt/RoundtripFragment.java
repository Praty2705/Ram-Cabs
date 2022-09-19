package com.pratyaksh.ramcabs.fragemnt;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.pratyaksh.ramcabs.R;
import com.pratyaksh.ramcabs.bottomsheet.BottomSheetRoundTrip;

import java.util.Calendar;

public class RoundtripFragment extends Fragment {

    EditText pickupdate,pickuptime,returndate;
    String date;
    Context context;
    Button roundtrippriceBTN;
    FragmentManager fm;
    Calendar calendar;
    private int year,month,day,hour,minute;

    public RoundtripFragment(Context context, FragmentManager fm) {
        this.context =context;
        this.fm = fm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_roundtrip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        date="";
        calendar= Calendar.getInstance();
        pickupdate = view.findViewById(R.id.roundtripdateET);
        pickuptime= view.findViewById(R.id.roundtriptimeET);
        returndate=view.findViewById(R.id.roundtripenddateET);
        roundtrippriceBTN = view.findViewById(R.id.roundtrippriceBTN);


        roundtrippriceBTN.setOnClickListener(v -> bottomsheet());


        pickupdate.setOnClickListener(v  ->
       dateshow() );

        returndate.setOnClickListener(v  -> retuendateshow());

        pickuptime.setOnClickListener(v -> timeshow());

    }

    private void retuendateshow() {
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog=new DatePickerDialog(requireContext(), (view, year, month, dayOfMonth) -> returndate.setText(dayOfMonth+"-" + (month+1)+"-"+year),year,month,day);
        datePickerDialog.show();
    }

    void dateshow()
    {
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog=new DatePickerDialog(requireContext(), (view, year, month, dayOfMonth) -> pickupdate.setText(dayOfMonth+"-" + (month+1)+"-"+year),year,month,day);
        datePickerDialog.show();
    }
    private void timeshow() {
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        @SuppressLint("SetTextI18n") TimePickerDialog timePickerDialog=new TimePickerDialog(requireContext(), (view, hour, minute) -> pickuptime.setText(hour + ":" + minute),hour,minute,false);
        timePickerDialog.show();
    }

    private void bottomsheet() {
        BottomSheetRoundTrip bottomSheet = new BottomSheetRoundTrip(fm, context);
        bottomSheet.show(fm,"Modal");
    }

}