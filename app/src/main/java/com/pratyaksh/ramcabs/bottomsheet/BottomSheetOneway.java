package com.pratyaksh.ramcabs.bottomsheet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.pratyaksh.ramcabs.CurrentBookingActivity;
import com.pratyaksh.ramcabs.R;

public class BottomSheetOneway extends BottomSheetDialogFragment {

    FragmentManager fm;
    Context context;
    Button onewayminibookBTN,onewaysedanbookBTN,onewaysuvbookBTN,onewayinnovabookBTN;
    TextView onewayminiprice,onewaysedanprice,onewaysuvprice, onewayinnovaprice;

    public BottomSheetOneway(FragmentManager fm, Context context) {
        this.fm=fm;
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_bottom_sheet_oneway, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        onewayminibookBTN= view.findViewById(R.id.onewayminibookBTN);
        onewaysedanbookBTN= view.findViewById(R.id. onewaysedanbookBTN);
        onewaysuvbookBTN = view.findViewById(R.id.onewaysuvbookBTN);
        onewayinnovabookBTN =view.findViewById(R.id.onewayinnovabookBTN);
        onewayminiprice =view.findViewById(R.id.onewayminiprice);
        onewaysedanprice =view.findViewById(R.id.onewaysedanprice);
        onewaysuvprice  =view.findViewById(R.id.onewaysuvprice);
        onewayinnovaprice  =view.findViewById(R.id.onewayinnovaprice);





        onewayminibookBTN.setOnClickListener(v ->
        {
            startActivity(new Intent(context, CurrentBookingActivity.class));
        });


    }
}