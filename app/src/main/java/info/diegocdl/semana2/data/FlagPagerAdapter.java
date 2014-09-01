package info.diegocdl.semana2.data;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import info.diegocdl.semana2.R;
import info.diegocdl.semana2.fragments.FlagFragment;

/**
 * Created by Diego on 8/31/2014.
 */
public class FlagPagerAdapter extends FragmentPagerAdapter {

    int[] arrayFlags = new int[]{
            R.drawable.mexico,
            R.drawable.colombia,
            R.drawable.argentina,
            R.drawable.peru,
            R.drawable.venezuela,
            R.drawable.chile,
            R.drawable.ecuador,
            R.drawable.guatemala,
            R.drawable.cuba
    };

    public FlagPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new FlagFragment();
        Bundle args = new Bundle();
        args.putInt(FlagFragment.RESOURCE, arrayFlags[i]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return arrayFlags.length;
//        return 0;
    }
}
