package com.pratyaksh.ramcabs;

import static android.os.Binder.getCallingUid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        LottieAnimationView animationView = findViewById(R.id.animationView);




        boolean hasAndroidPermissions = hasPermissions(getApplicationContext(), Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.CAMERA,
                Manifest.permission.WAKE_LOCK,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAPTURE_AUDIO_OUTPUT,
                Manifest.permission.MODIFY_AUDIO_SETTINGS);

        if (hasAndroidPermissions) {

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
            new Handler().postDelayed(() ->
            {
                startActivity(new Intent(this,LoginActivity.class));
                finish();
            }, 5000);
        }
        else
        {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.INTERNET,
                            Manifest.permission.ACCESS_NETWORK_STATE,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.CAMERA,
                            Manifest.permission.CALL_PHONE,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WAKE_LOCK,
                            Manifest.permission.RECORD_AUDIO,
                            Manifest.permission.CAPTURE_AUDIO_OUTPUT,
                            Manifest.permission.MODIFY_AUDIO_SETTINGS,
                    },
                    1);
        }
    }



    public static boolean hasPermissions(Context context, String... permissions) {

        boolean hasAllPermissions = true;
        for (String permission : permissions) {
            //return false instead of assigning, but with this you can log all permission values
            if (!hasPermission(context, permission)) {
                hasAllPermissions = false;
            }
        }
        return hasAllPermissions;
    }

    public static boolean hasPermission(Context context, String permission) {

        PackageManager pm = context.getPackageManager();
        return (PackageManager.PERMISSION_GRANTED == pm.checkPermission(permission, pm.getNameForUid(getCallingUid())));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                //If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    /*LottieAnimationView animationView = findViewById(R.id.animation_view);
                    animationView
                            .playAnimation();
                    ValueAnimator animator
                            = ValueAnimator.ofFloat(0f, 1f);
                    animator
                            .addUpdateListener(animation -> animationView
                                    .setProgress(
                                            (Float) animation
                                                    .getAnimatedValue()));
                    animator.start();*/
                    new Handler().postDelayed(() ->
                    {
                        startActivity(new Intent(this,LoginActivity.class));
                        finish();
                    }, 4000);
                }
                else
                {
                    Toast.makeText(this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }












       /* LottieAnimationView animationView = findViewById(R.id.animationView);

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

        new Handler().postDelayed(() ->
        {
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            finish();
        }, 5000);
*/
    }
}