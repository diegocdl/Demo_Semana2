package info.diegocdl.semana2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.diegocdl.semana2.R;
import info.diegocdl.semana2.activities.MainActivity;

/**
 * Created by Diego on 8/31/2014.
 */
public class CountriesContentFragment extends Fragment implements ActionBar.TabListener{

    Fragment[] fragments = new Fragment[]{
            new CountriesListFragment(),
            new CountriesFlagFragment()
    };


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_countries_content, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActionBar actionBar = ((MainActivity)getActivity()).getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(
                actionBar.newTab()
                        .setText(getString(R.string.title_fragment_list))
                        .setTabListener(this)
        );
        actionBar.addTab(
                actionBar.newTab()
                        .setText(getString(R.string.title_fragment_flags))
                        .setTabListener(this)
        );

        fragments[0].setHasOptionsMenu(true);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.mainContent,fragments[0])
                .add(R.id.mainContent,fragments[1])
                .hide(fragments[1])
                .commit();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Fragment toHide = null;
        Fragment toShow = null;
        switch (tab.getPosition()){
            case 0:
                toHide = fragments[1];
                toShow = fragments[0];
                break;
            case 1:
                toHide = fragments[0];
                toShow = fragments[1];
                break;
        }
        FragmentManager manager = getActivity().getSupportFragmentManager();

        manager.beginTransaction()
                .hide(toHide)
                .show(toShow)
                .commit();
    }


    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
