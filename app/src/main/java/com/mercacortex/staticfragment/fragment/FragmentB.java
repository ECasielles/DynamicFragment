package com.mercacortex.staticfragment.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mercacortex.staticfragment.R;


public class FragmentB extends Fragment {

    private TextView txvFragmentB;

    // Required empty public constructor
    public FragmentB() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Siempre implementar el superconstructor aunque no lo ponga el AS
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        //Comprobación muy útil. La vista lo ha inflado ya y nos lo da.
        if (rootView == null)
            txvFragmentB = (TextView) rootView.findViewById(R.id.txvFrgBText);

        return rootView;
    }

}
