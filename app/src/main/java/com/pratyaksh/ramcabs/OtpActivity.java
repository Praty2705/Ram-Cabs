package com.pratyaksh.ramcabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;


public class OtpActivity extends AppCompatActivity {


    Button verifyotpBTN;
    Loader loader;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        context = OtpActivity.this;
      //  loader = new Loader(context);


        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView1);
        verifyotpBTN= findViewById(R.id.veryifyBTN);

        verifyotpBTN.setOnClickListener(v ->
        {
            startActivity(new Intent(this,SignupActivity.class));
            finish();
        });

        animationView
                .playAnimation();

        ValueAnimator animator
                = ValueAnimator.ofFloat(0f, 1f);
        animator
                .addUpdateListener(animation -> animationView
                        .setProgress(
                                (Float) animation
                                        .getAnimatedValue()));
        animator.start();


    }
}