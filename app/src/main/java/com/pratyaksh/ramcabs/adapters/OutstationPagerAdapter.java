package com.pratyaksh.ramcabs.adapters;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.pratyaksh.ramcabs.fragemnt.OnewayFragment;
import com.pratyaksh.ramcabs.fragemnt.RoundtripFragment;

public class OutstationPagerAdapter extends FragmentPagerAdapter {
    int tabcount;
    Context context;
    FragmentManager fm;
    public OutstationPagerAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        tabcount = behavior;
        this.context = context;
        this.fm = fm;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("asdf","Outstation Adapter");
        switch (position) {
            case 0:
                return new OnewayFragment(context,fm);
            case 1:
                return new RoundtripFragment(context,fm);
        }
        return new OnewayFragment(context,fm);
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
