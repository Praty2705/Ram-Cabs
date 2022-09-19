package com.pratyaksh.ramcabs;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class LoginActivity extends AppCompatActivity {

    Loader loader;
    Button sendOTP;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = LoginActivity.this;

        loader = new Loader(context);


        //loader.hideLottieDialog();

        LottieAnimationView animationView = findViewById(R.id.lottieAnimationView);

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


        sendOTP = findViewById(R.id.sendOTP);

         sendOTP.setOnClickListener(v ->
         {
            // loader.showLottieDialog();
             startActivity(new Intent(this, OtpActivity.class));

         } );
    }


}