package com.pratyaksh.ramcabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    Button signupBTN;
    Context context;
    Loader loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);






        context = SignupActivity.this;
        loader = new Loader(context);

      //  loader.hideLottieDialog();


        signupBTN = findViewById(R.id.signupBTN);

        signupBTN.setOnClickListener(v ->
        {
           // loader.showLottieDialog();
            startActivity(new Intent(this,DashboardActivity.class));
            finish();
        });


    }
}