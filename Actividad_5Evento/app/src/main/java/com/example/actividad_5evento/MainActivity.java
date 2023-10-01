package com.example.actividad_5evento;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNumero1;
    private EditText etNumero2;
    private EditText etNumero3;
    private TextView mayor;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumero1 = findViewById(R.id.etNumero3);
        etNumero2 = findViewById(R.id.etNumero2);
        etNumero3 = findViewById(R.id.etNumero3);

        mayor = findViewById(R.id.ftNumeroMayor);
        btnCalcular = findViewById(R.id.btnCalcular);

        etNumero1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    // Si se presiona "Next", mover el enfoque a la segunda caja de texto
                    etNumero2.requestFocus();
                    return true;
                }
                return false;
            }
        });

        // lo que tenemos en los paretesis es que creamos una instancia que es una interfaz para escuchar acciones del editor.
        etNumero2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    // Si se presiona "Next", mover el enfoque a la tercera caja de texto
                    etNumero3.requestFocus();
                    return true;
                }
                return false;
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strN1 = etNumero1.getText().toString();
                String strN2 = etNumero2.getText().toString();
                String strN3 = etNumero3.getText().toString();

                int n1 = Integer.parseInt(strN1);
                int n2 = Integer.parseInt(strN2);
                int n3 = Integer.parseInt(strN3);

                int numeroMayor = (n1 > n2) ? ((n1 > n3) ? n1 : n3) : ((n2 > n3) ? n2 : n3);

                mayor.setText("El número mayor es: " + numeroMayor);
            }
        });


    }
}