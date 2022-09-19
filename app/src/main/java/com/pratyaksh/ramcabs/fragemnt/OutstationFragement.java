package com.pratyaksh.ramcabs.fragemnt;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.pratyaksh.ramcabs.R;
import com.pratyaksh.ramcabs.adapters.DashboardAdapter;
import com.pratyaksh.ramcabs.adapters.OutstationPagerAdapter;
import com.pratyaksh.ramcabs.bottomsheet.BottomSheetLocal;


public class OutstationFragement extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    OutstationPagerAdapter outstationPagerAdapter;
    FragmentManager fm;
    Context context;
    public OutstationFragement(FragmentManager fm, Context context) {
        this.fm=fm;
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_outstation_fragement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.outstationvpager);
        tabLayout = view.findViewById(R.id.outstationtablayout);
        outstationPagerAdapter = new OutstationPagerAdapter(fm, tabLayout.getTabCount(),context);

        viewPager.setAdapter(outstationPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1) {
                    outstationPagerAdapter.notifyDataSetChanged();
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