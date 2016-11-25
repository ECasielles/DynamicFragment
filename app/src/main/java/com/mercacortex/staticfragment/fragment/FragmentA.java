package com.mercacortex.staticfragment.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.mercacortex.staticfragment.R;


public class FragmentA extends Fragment {

    private EditText edtFragmentA;
    private Button btnFrgAChangeText;
    private SeekBar skbFragmentA;

    //Interfaz para poder capturar la excepción
    private FragmentIterationListener mCallBack;

    public interface FragmentIterationListener {
        //Modifica el texto y su tamaño
        void onFragmentIterationListener(String text, int size);
    }

    // Required empty public constructor
    public FragmentA() { }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Siempre un try con ClassCastException
        try {
            mCallBack = (FragmentIterationListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + " FragmentIterationListener must be implemented");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Siempre implementar el superconstructor aunque no lo ponga el AS (por correccion)
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        //Comprobación muy útil. La vista lo ha inflado ya y nos lo da.
        if (rootView == null) {
            edtFragmentA = (EditText) rootView.findViewById(R.id.edtFrgAText);
            btnFrgAChangeText = (Button) rootView.findViewById(R.id.btnFrgAOk);
            btnFrgAChangeText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallBack.onFragmentIterationListener(edtFragmentA.getText().toString(), skbFragmentA.getProgress());
                }
            });
            skbFragmentA = (SeekBar) rootView.findViewById(R.id.skbFrgABar);
        }

        return rootView;
    }
}
