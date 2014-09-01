package info.diegocdl.semana2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import info.diegocdl.semana2.R;

/**
 * Created by Diego on 8/31/2014.
 */
public class FlagFragment extends Fragment {
    public final static String RESOURCE = "resource";
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flag, null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        Bundle args = getArguments();

        imageView.setImageResource(args.getInt(RESOURCE));

        return view;
    }
}
