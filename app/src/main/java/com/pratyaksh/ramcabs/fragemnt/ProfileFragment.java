package com.pratyaksh.ramcabs.fragemnt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.pratyaksh.ramcabs.LoginActivity;
import com.pratyaksh.ramcabs.R;

import java.util.Objects;


public class ProfileFragment extends Fragment {

ToggleButton toggleButton;
Button logoutBTN;
EditText pnameET,pemailET,pnumberET;
Context context;
View view;
    public ProfileFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toggleButton = view.findViewById(R.id.toggleButton);
        pnameET = view.findViewById(R.id.profilenameET);
        pemailET = view.findViewById(R.id.profileemailET);
        pnumberET = view.findViewById(R.id.profilenumberET);
        logoutBTN = view.findViewById(R.id.profilelogoutBTN);


        logoutBTN.setOnClickListener(v -> processlogout());

        toggleButton.setOnClickListener(v ->
        {
            if (toggleButton.isChecked()) {
                pnameET.setEnabled(true);
                pnumberET.setEnabled(true);
                pemailET.setEnabled(true);
                Toast.makeText(context, "Now edit your profile", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Changes saved successfully ", Toast.LENGTH_SHORT).show();
                pnameET.setEnabled(false);
                pnumberET.setEnabled(false);
                pemailET.setEnabled(false);
            }
        });

        {

        }
    }

    private void processlogout() {
        startActivity(new Intent(context, LoginActivity.class));
        requireActivity().finish();
    }
}