package com.pratyaksh.ramcabs.fragemnt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pratyaksh.ramcabs.R;

public class SupportFragment extends Fragment {

    Context context;
    FragmentManager fm;
   ImageView callicon;


    public SupportFragment(Context context, FragmentManager supportFragmentManager) {
        this.context = context;
        this.fm = supportFragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_support, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callicon = view.findViewById(R.id.callicon);



        callicon.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            String phoneNumber = "+918840064187";
            callIntent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(callIntent);

        });
    }
}