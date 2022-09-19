package com.pratyaksh.ramcabs.fragemnt;
import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.pratyaksh.ramcabs.CurrentBookingActivity;
import com.pratyaksh.ramcabs.R;
import com.pratyaksh.ramcabs.RentalCabActivity;
import com.pratyaksh.ramcabs.bottomsheet.BottomSheetForAddCity;
import com.pratyaksh.ramcabs.bottomsheet.BottomSheetOneway;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class OnewayFragment extends Fragment
{


    EditText pickupdate,pickuptime,startcityET,endcityET;
    String date;
    private int year,month,day,hour,minute;
    Context context;
    FragmentManager fm;
    Button onewaypriceBTN,onewayaddcityBTN;
    Calendar calendar;
    String knowfragment;
    String str,str2 ;
    TextView addcity1;
    CardView cardView4;
    ImageView onwaycrossIV,onewayRentalIV;

    private static final String apiKey ="AIzaSyB5RgWeIPEgqbehm9BaGZeBHN5jxe-GR4M";
    private static final int AUTOCOMPLETE_REQUEST_CODE = 1;



    public OnewayFragment(Context context,FragmentManager fm) {
        this.context = context;
        this.fm = fm;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_oneway, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        knowfragment = "onewayfragment";
        str ="";
        str2="";
        date="";
        pickupdate = view.findViewById(R.id.onewaydateET);
        pickuptime= view.findViewById(R.id.onewaytimeET);
        startcityET = view.findViewById(R.id.onewaystartcityET);
        endcityET = view.findViewById(R.id.onewayendcityET);
        addcity1= view.findViewById(R.id.addcity1);
        onewaypriceBTN = view.findViewById(R.id.onewaypriceBTN);
        onewayaddcityBTN = view.findViewById(R.id.onewayaddcityBTN);
        onwaycrossIV=view.findViewById(R.id.onwaycrossIV);
        cardView4=view.findViewById(R.id.cardView4);
        onewayRentalIV=view.findViewById(R.id.onewayRentalIV);




        onewayRentalIV.setOnClickListener(v -> startActivity(new Intent(context, RentalCabActivity.class)));


        calendar=Calendar.getInstance();
        pickupdate.setOnClickListener(v -> dateshow() );
        pickuptime.setOnClickListener(v -> timeshow());
        onewaypriceBTN.setOnClickListener(v -> bottomsheetforcars());


        //location and place name.
        Places.initialize(context.getApplicationContext(), apiKey);

        startcityET.setOnClickListener(v -> {

            List<Place.Field> fieldlist = Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG);
            Intent intent =  new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldlist).build(context).putExtra("tag",str);
            startActivityForResult(intent,100);
        });
        endcityET.setOnClickListener(v ->
        {

            List<Place.Field> fieldlist = Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG);
            Intent intent =  new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldlist).build(context);
            startActivityForResult(intent,101);
        });

        onewayaddcityBTN.setOnClickListener(v ->{
            List<Place.Field> fieldlist = Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG);
            Intent intent =  new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY,fieldlist).build(context);
            startActivityForResult(intent,102);
        });


        //deleting the added the city
        onwaycrossIV.setOnClickListener(v -> {
           cardView4.setVisibility(View.GONE);
           endcityET.setText(str2);
        });





    }

    private void timeshow() {
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        @SuppressLint("SetTextI18n") TimePickerDialog timePickerDialog=new TimePickerDialog(requireContext(), (view, hour, minute) -> pickuptime.setText(hour + ":" + minute),hour,minute,false);
        timePickerDialog.show();
    }

    void dateshow()
    {
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog=new DatePickerDialog(requireContext(), (view, year, month, dayOfMonth) -> pickupdate.setText(dayOfMonth+"-" + (month+1)+"-"+year),year,month,day);
        datePickerDialog.show();
    }
    private void bottomsheetforcars() {
        BottomSheetOneway bottomSheet = new BottomSheetOneway(fm, context);
        bottomSheet.show(fm,"Modal");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            assert data != null;
            Log.d("asdf", String.valueOf(requestCode));
            if (requestCode==100) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                startcityET.setText(place.getName());

            }
            if (requestCode==101)
            {
                Place place = Autocomplete.getPlaceFromIntent(data);
                endcityET.setText(place.getName());
                str2= endcityET.getText().toString();
                onewayaddcityBTN.setVisibility(View.VISIBLE);

            }
            if (requestCode==102)
            {
                Place place = Autocomplete.getPlaceFromIntent(data);
                cardView4.setVisibility(View.VISIBLE);
                str= endcityET.getText().toString();
                addcity1.setText(str);
                endcityET.setText(place.getName());
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}