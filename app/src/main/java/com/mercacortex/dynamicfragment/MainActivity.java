package com.mercacortex.dynamicfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.mercacortex.dynamicfragment.fragment.FragmentA;
import com.mercacortex.dynamicfragment.fragment.FragmentB;

//Recuerda que no estamos usando la librería support
public class MainActivity extends Activity implements FragmentA.FragmentIterationListener{

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Maneja el cambio de configuración
        FragmentManager fragmentManager = getFragmentManager();
        fragmentA = (FragmentA) fragmentManager.findFragmentByTag(FragmentA.TAG_FRAGMENTA);

        // IMPORTANTE:
        // fragmentA = new FragmentA(); Sólo podemos hacer esto porque
        // no se le pasan argumentos. Si se le pasan argumentos,
        // se hace con newInstance según los apuntes.

        if(fragmentA == null) {
            fragmentA = new FragmentA();
            getFragmentManager().beginTransaction().add(R.id.activity_main, fragmentA, FragmentA.TAG_FRAGMENTA).commit();
        }
    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        Bundle bundle = new Bundle();
        bundle.putString(FragmentB.TEXT_KEY, text);
        bundle.putInt(FragmentB.SIZE_KEY, size);
        fragmentB = FragmentB.newInstance(bundle);

        // Se empieza la transacción (y mejor ponerle un nombre en particular)
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragmentB);

        // null puede ser un nombre para el estado
        // Si no introducimos addToBackStack, no se guarda el estado anterior y
        // al darle a atrás, la actividad se cerraría porque la actividad es la única
        // en la pila.
        // Además, siempre debe hacerse antes del commit.
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

}
