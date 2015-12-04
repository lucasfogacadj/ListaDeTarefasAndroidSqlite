package br.com.lucasfogaca.listadetarefas;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton add;
    ImageButton listar;

    public static ArrayList<Tarefa> tarefa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add =  (ImageButton)  findViewById(R.id.add);
        listar = (ImageButton) findViewById(R.id.listar);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Cadastro.class);

                startActivity(intent);


            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Resultado.class);

                startActivity(intent);

            }
        });

    }



}
