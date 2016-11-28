package com.mercacortex.staticfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
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
        if (rootView != null)
            txvFragmentB = (TextView) rootView.findViewById(R.id.txvFrgBText);

        return rootView;
    }

    public void changeTextProperties(String text, int fontSize){
        txvFragmentB.setText(text);
        txvFragmentB.setTextSize(fontSize);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("text", txvFragmentB.getText().toString());
        outState.putInt("size", (int) txvFragmentB.getTextSize());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            txvFragmentB.setText(savedInstanceState.getString("text"));
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            txvFragmentB.setTextSize(savedInstanceState.getInt("size") / metrics.density);
        }
    }
}
