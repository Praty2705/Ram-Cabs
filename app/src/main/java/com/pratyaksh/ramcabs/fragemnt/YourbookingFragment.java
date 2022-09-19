package com.pratyaksh.ramcabs.fragemnt;

import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.pratyaksh.ramcabs.R;


public class YourbookingFragment extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yourbooking, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       Toast.makeText(getContext(),"No past bookings found ",Toast.LENGTH_SHORT).show();
        LottieAnimationView animationView = view.findViewById(R.id.animationView4);
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