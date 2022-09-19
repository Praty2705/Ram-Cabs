package com.pratyaksh.ramcabs.fragemnt;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.pratyaksh.ramcabs.R;
import com.pratyaksh.ramcabs.adapters.DashboardAdapter;

public class DashboardFragment extends Fragment {

    Context context;
    ViewPager viewPager;
    TabLayout tabLayout;
    DashboardAdapter dashboardAdapter;
    FragmentManager fragmentManager;

    public DashboardFragment(Context context, FragmentManager fragmentManager) {
   this.context= context;
   this.fragmentManager=fragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume: ");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = view.findViewById(R.id.vpager);
        tabLayout = view.findViewById(R.id.tablayout);

        Log.d("asdf","DFragment");

        dashboardAdapter = new DashboardAdapter(fragmentManager, tabLayout.getTabCount(), context);
        viewPager.setAdapter(dashboardAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1) {
                    dashboardAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }


}