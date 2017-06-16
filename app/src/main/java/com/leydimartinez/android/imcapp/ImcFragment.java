package com.leydimartinez.android.imcapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Leydi_Daniela on 16/06/2017.
 */

public class ImcFragment extends android.support.v4.app.Fragment {

    private EditText mCampoPeso, mCampoEstatura;
    private Button mBotonCalcular, mBotonLimpiar;
    private TextView mEtiquetaImc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Obtenemos las vistas del fragment_imc
        View v = inflater.inflate(R.layout.fragment_imc, container, false);

        //Variables de instancia para peso, estatura, imc y botones calcular y limpiar
        mCampoPeso = (EditText) v.findViewById(R.id.weight);
        mCampoEstatura = (EditText) v.findViewById(R.id.height);
        mBotonCalcular = (Button) v.findViewById(R.id.calculate);
        mBotonLimpiar = (Button) v.findViewById(R.id.clean);
        mEtiquetaImc = (TextView) v.findViewById(R.id.imc);

        //Acción del botón "Calcular"
        mBotonCalcular.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Obtención del valor peso como String
                String s = mCampoPeso.getText().toString();
                //Conversión del valor peso a Double guardándolo en una variable
                double peso = Double.parseDouble(s);
                //Obtención del valor estatura como String
                s = mCampoEstatura.getText().toString();
                //Conversión del valor estatura a Douuble guardándolo en una variable
                double estatura = Double.parseDouble(s);
                //Cálculo del IMC
                double imc = peso / (estatura * estatura);
                //Estableciendo formato de 2 decimales para el IMC
                s = String.format("%2.2f", imc);
                //"Imprimiendo" el valor del IMC
                mEtiquetaImc.setText(s);
            }
        });

        //Acción del botón "Limpiar"
        mBotonLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se "Limpian" los campos peso, estatura e IMC
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaImc.setText("0.0");
            }
        });

        //Actualiza las vistas de fragment_imc
        return v;
    }
}
