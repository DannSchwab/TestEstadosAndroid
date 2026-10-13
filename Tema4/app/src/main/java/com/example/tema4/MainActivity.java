package com.example.tema4;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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
    }
}