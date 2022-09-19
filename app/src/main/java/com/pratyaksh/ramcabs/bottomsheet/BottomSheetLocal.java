package com.pratyaksh.ramcabs.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pratyaksh.ramcabs.R;

public class BottomSheetLocal extends BottomSheetDialogFragment {

    FragmentManager fm;
    Context context;
    Button lcoalminibookBTN,lcoalsedanbookBTN,lcoalsuvbookBTN,lcoalinnovabookBTN;
    TextView localminiprice,localsedanprice,localsuvprice, localinnovaprice;

    public BottomSheetLocal(FragmentManager fm, Context context) {
        this.fm =fm;
        this.context = context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_bottom_sheet_local, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lcoalminibookBTN = view.findViewById(R.id.lcoalminibookBTN);
        lcoalsedanbookBTN= view.findViewById(R.id.lcoalsedanbookBTN);
        lcoalsuvbookBTN = view.findViewById(R.id.lcoalsuvbookBTN);
        lcoalinnovabookBTN =view.findViewById(R.id.lcoalinnovabookBTN);
        localminiprice =view.findViewById(R.id.localminiprice);
        localsedanprice =view.findViewById(R.id.localsedanprice);
        localsuvprice  =view.findViewById(R.id.localsuvprice);
        localinnovaprice  =view.findViewById(R.id.localinnovaprice);



    }
}