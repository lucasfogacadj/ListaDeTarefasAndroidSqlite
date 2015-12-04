package br.com.lucasfogaca.listadetarefas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.Date;

public class Cadastro extends AppCompatActivity {

    Button  gravar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        gravar = (Button) findViewById(R.id.gravar);

        gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BancoController crud = new BancoController(getBaseContext());

                EditText nome = (EditText) findViewById(R.id.nome);
                EditText desc = (EditText) findViewById(R.id.desc);
                EditText data = (EditText) findViewById(R.id.data);
                RatingBar nota = (RatingBar) findViewById(R.id.ratingBar);

                String nomeString = nome.getText().toString();
                String descString = desc.getText().toString();
                String dataString = data.getText().toString();
                int notaInteger = (int) nota.getRating();

                String resultado;

                resultado = crud.insereDado(nomeString, descString, dataString, notaInteger);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

            }
        });


    }
}
