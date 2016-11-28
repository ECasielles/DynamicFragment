package com.mercacortex.staticfragment;


import android.app.Activity;
import android.os.Bundle;

import com.mercacortex.staticfragment.fragment.FragmentA;
import com.mercacortex.staticfragment.fragment.FragmentB;

public class MainActivity extends Activity implements FragmentA.FragmentIterationListener{

    // Es correcto hacerlo porque son estáticos
    // En los dinámicos preguntaremos
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Versión con librería support
        //fragmentB = getSupportFragmentManager().findFragmentById(R.id.frgBMain);
        fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.frgBMain);
    }

    // Que implemente la interfaz del FragmentA.FragmentIterationListener
    @Override
    public void onFragmentIterationListener(String text, int size) {
        fragmentB.changeTextProperties(text, size);
    }

}
