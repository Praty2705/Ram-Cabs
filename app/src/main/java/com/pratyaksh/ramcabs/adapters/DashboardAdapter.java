package com.pratyaksh.ramcabs.adapters;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.pratyaksh.ramcabs.fragemnt.LocalFragment;
import com.pratyaksh.ramcabs.fragemnt.OutstationFragement;

public class DashboardAdapter extends FragmentPagerAdapter {

    int tabcount; FragmentManager fm;
    Context context;
    public DashboardAdapter(@NonNull FragmentManager fm, int behavior,Context context) {
        super(fm, behavior);
         tabcount=behavior;
         this.fm=fm;
         this.context=context;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("asdf","Dashboard Adapter");
        switch (position)
        {
            case 0:
                return new OutstationFragement(fm,context);
            case 1:
                return new LocalFragment(fm,context);
        }
        return new OutstationFragement(fm, context);
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
