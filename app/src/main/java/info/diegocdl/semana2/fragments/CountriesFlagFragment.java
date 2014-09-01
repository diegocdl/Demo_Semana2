package info.diegocdl.semana2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.diegocdl.semana2.R;
import info.diegocdl.semana2.data.FlagPagerAdapter;

/**
 * Created by Diego on 8/31/2014.
 */
public class CountriesFlagFragment extends Fragment {
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries_flags, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FlagPagerAdapter adapter = new FlagPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
    }
}
