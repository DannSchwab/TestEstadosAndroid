package com.example.tema4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        String [] opciones = {"Opcion1","Opcion2","Opcion3","Opcion4","Opcion5"};
        AutoCompleteTextView textoLeido = findViewById(R.id.miAutoComplete);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,opciones);

        textoLeido.setAdapter(adaptador);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView miTexto = findViewById(R.id.texto);
        Button boton1 = findViewById(R.id.miBotonMover);
        Button boton2 = findViewById(R.id.miBotonParar);
        Button boton3 = findViewById(R.id.miBotonRotar);

        // Estilos iniciales del texto
        miTexto.setText("Nuevo texto a mostrar");
        miTexto.setTextColor(Color.RED);
        miTexto.setTextSize(24);
        miTexto.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);

        // Carga de animaciones
        Animation miAnimacionMover = AnimationUtils.loadAnimation(this, R.anim.animacion);
        Animation miAnimacionRotar = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        // Acción: Mover
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miTexto.setText("Moviendo texto...");
                miAnimacionMover.setRepeatMode(Animation.RESTART);
                miAnimacionMover.setRepeatCount(20);
                miTexto.startAnimation(miAnimacionMover);
            }
        });

        // Acción: Parar
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (miTexto.getAnimation() != null) {
                    miTexto.clearAnimation();
                    miTexto.setText("Animación detenida");
                }
            }
        });

        // Acción: Rotar
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miTexto.setText("Ahora gira el texto");
                miAnimacionRotar.setRepeatMode(Animation.RESTART);
                miAnimacionRotar.setRepeatCount(20);
                miTexto.startAnimation(miAnimacionRotar);
            }
        });

        // Inicia animación al abrir la pantalla
        miTexto.startAnimation(miAnimacionMover);


        Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);
        String[] valores = {"opcion1","opcion2","opcion3","opcion4","opcion5"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, valores));

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Has seleccionado el valor:" + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.out.println("No has seleccionado nada");
            }
        });
    }
}