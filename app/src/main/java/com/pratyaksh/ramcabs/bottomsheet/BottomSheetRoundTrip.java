package com.pratyaksh.ramcabs.bottomsheet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pratyaksh.ramcabs.R;

public class BottomSheetRoundTrip extends BottomSheetDialogFragment {


    FragmentManager fm;
    Context context;

    Button roundtripminibookBTN,roundtripsedanbookBTN,roundtripsuvbookBTN,roundtripinnovabookBTN;
    TextView roundtripminiprice,roundtripsedanprice,roundtripsuvprice, roundtripinnovaprice;
    
    
    public BottomSheetRoundTrip(FragmentManager fm, Context context) {
        this.fm = fm;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_bottom_sheet_round_trip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        roundtripminibookBTN= view.findViewById(R.id.roundtripminibookBTN);
        roundtripsedanbookBTN= view.findViewById(R.id. roundtripsedanbookBTN);
        roundtripsuvbookBTN = view.findViewById(R.id.roundtripsuvbookBTN);
        roundtripinnovabookBTN =view.findViewById(R.id.roundtripinnovabookBTN);
        roundtripminiprice =view.findViewById(R.id.roundtripminiprice);
        roundtripsedanprice =view.findViewById(R.id.roundtripsedanprice);
        roundtripsuvprice  =view.findViewById(R.id.roundtripsuvprice);
        roundtripinnovaprice  =view.findViewById(R.id.roundtripinnovaprice);


    }
}