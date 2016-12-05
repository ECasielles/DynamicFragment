package com.mercacortex.dynamicfragment.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.mercacortex.dynamicfragment.R;

public class FragmentA extends Fragment {

    private EditText edtFragmentA;
    private Button btnFrgAChangeText;
    private SeekBar skbFragmentA;
    public static final String TAG_FRAGMENTA = "fragmentA";

    private FragmentIterationListener mCallBack;

    public interface FragmentIterationListener {
        void onFragmentIterationListener(String text, int size);
    }

    public FragmentA() { }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack = (FragmentIterationListener) activity;
        } catch (ClassCastException ex) {
            throw new ClassCastException(activity.toString() + " FragmentIterationListener must be implemented");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        // Para que retenga los cambios y no se superponga
        setRetainInstance(true);

        if (rootView != null) {
            edtFragmentA = (EditText) rootView.findViewById(R.id.edtFrgAText);
            skbFragmentA = (SeekBar) rootView.findViewById(R.id.skbFrgABar);

            btnFrgAChangeText = (Button) rootView.findViewById(R.id.btnFrgAOk);

            btnFrgAChangeText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallBack.onFragmentIterationListener(edtFragmentA.getText().toString(), skbFragmentA.getProgress());
                }
            });

        }

        return rootView;
    }

}
