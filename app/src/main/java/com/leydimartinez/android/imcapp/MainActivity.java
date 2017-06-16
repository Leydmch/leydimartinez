package com.leydimartinez.android.imcapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Se crea la ventana de la aplicación
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se crean los componentes de vista principal de la aplicación
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = new ImcFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }
}
