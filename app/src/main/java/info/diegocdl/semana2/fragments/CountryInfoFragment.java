package info.diegocdl.semana2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import info.diegocdl.semana2.R;


/**
 * Created by Diego on 8/27/2014.
 */
public class CountryInfoFragment extends Fragment {
    public WebView webView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if(activity instanceof info.diegocdl.semana2.activities.CountryDetailActivity) {
            String country = ((info.diegocdl.semana2.activities.CountryDetailActivity)getActivity()).getCountry();
            loadWebViewContent(country);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_info, container, false);
        webView = (WebView)view.findViewById(R.id.webView);
        return view;
    }

    public void loadWebViewContent(String country ){
        webView.loadUrl("http://es.m.wikipedia.org/wiki/" + country);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
