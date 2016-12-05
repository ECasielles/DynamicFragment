package com.mercacortex.dynamicfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mercacortex.dynamicfragment.R;

import static android.R.attr.fragment;


public class FragmentB extends Fragment {

    private TextView txvFragmentB;

    //Inicialmente esto debería estar en el presentador
    public static final String TEXT_KEY = "text";
    public static final String SIZE_KEY = "text_size";
    public static final String TAG_FRAGMENTB = "fragmentB";

    // Required empty public constructor
    public FragmentB() { }

    // Al escribir new, AS te deja sobreescribir directamente
    // Igualmente mejor hacerlo a mano
    public static FragmentB newInstance(Bundle arguments) {
        FragmentB fragmentB = new FragmentB();
        if(arguments != null)
            fragmentB.setArguments(arguments);
        return fragmentB;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Siempre implementar el superconstructor aunque no lo ponga el AS
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        // Para que no reinicie y se superponga
        setRetainInstance(true);

        if (rootView != null) {
            txvFragmentB = (TextView) rootView.findViewById(R.id.txvFrgBText);
            Bundle bundle = getArguments();
            if(bundle != null) {
                txvFragmentB.setText(bundle.getString(TEXT_KEY));
                txvFragmentB.setTextSize((float) bundle.getInt(SIZE_KEY));
            }
        }
        return rootView;
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
