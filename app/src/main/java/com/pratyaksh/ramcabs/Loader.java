package com.pratyaksh.ramcabs;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AlertDialog;

import com.airbnb.lottie.LottieAnimationView;

public class Loader {
    private final Context context;
    private AlertDialog alertDialog;
    private LayoutInflater layoutInflater;

    public  Loader (Context context)
    {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        initDialog();
    }

    private void initDialog()
    {
        //  LottieAnimationView animationView = animationView.findViewById(R.id.animation_view);
        AlertDialog.Builder dialog = new AlertDialog.Builder(context, R.style.Theme_RamCabs);
        View dialogView = layoutInflater.inflate(R.layout.lottieloader, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        LottieAnimationView animationView = dialogView.findViewById(R.id.animation_view);
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

        alertDialog = dialog.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

    }
    public void showLottieDialog()
    {
        alertDialog.show();
    }

    public void hideLottieDialog() {
        alertDialog.dismiss();
    }

}
