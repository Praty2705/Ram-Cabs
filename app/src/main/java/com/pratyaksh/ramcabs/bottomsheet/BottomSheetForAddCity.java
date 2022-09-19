package com.pratyaksh.ramcabs.bottomsheet;

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
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pratyaksh.ramcabs.R;

public class BottomSheetForAddCity extends BottomSheetDialogFragment
{
    String knowfragment;
    FragmentManager fm;
    Context context;
    Button bottomsheetaddcityBTN;
    TextView bottonsheetcancelTV;

    public BottomSheetForAddCity(FragmentManager fm, Context context,String knowfragment) {
        this.fm = fm;
        this.context = context;
        this.knowfragment =knowfragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet_for_add_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        bottomsheetaddcityBTN = view.findViewById(R.id.bottomsheetaddcityBTN);
        bottonsheetcancelTV = view.findViewById(R.id.bottonsheetcancelTV);

        bottomsheetaddcityBTN.setOnClickListener(v ->{
            
        });



    }
}