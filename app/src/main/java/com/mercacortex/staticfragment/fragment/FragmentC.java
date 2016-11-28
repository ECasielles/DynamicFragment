package com.mercacortex.staticfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.mercacortex.staticfragment.R;

public class FragmentC extends Fragment {

    private WebView wvAbout;

    public FragmentC() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_c, container, false);
        wvAbout = (WebView) rootView.findViewById(R.id.wvFrgCHtml);
        wvAbout.loadData(getResources().getString(R.string.about), "text/html","utf-8");
        return rootView;
    }



}
