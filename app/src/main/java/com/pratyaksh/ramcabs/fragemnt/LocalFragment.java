package com.pratyaksh.ramcabs.fragemnt;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pratyaksh.ramcabs.R;
import com.pratyaksh.ramcabs.bottomsheet.BottomSheetLocal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LocalFragment extends Fragment  {

    EditText pickupdate,pickuptime,localstartcity,localendcity;
    String date;
    Button localpricesBTN,localaddcityBTN;
    private int year,month,day,hour,minute;
    Context context;
    Calendar calendar;
    FragmentManager fm;

    public LocalFragment(FragmentManager fm, Context context) {
        this.fm = fm;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        date="";
        calendar=Calendar.getInstance();
        pickupdate = view.findViewById(R.id.localdateET);
        pickuptime= view.findViewById(R.id.localtimeET);
        localpricesBTN = view.findViewById(R.id.localgetprices);
        localaddcityBTN = view.findViewById(R.id.localaddcityBTN);

        pickupdate.setOnClickListener(v ->dateshow());
        pickuptime.setOnClickListener(v -> timeshow());
        localpricesBTN.setOnClickListener(v -> bottomsheet());


    }

    private void bottomsheet() {
        BottomSheetLocal bottomSheet = new BottomSheetLocal(fm,context);
        bottomSheet.show(fm,"Modal");
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
}