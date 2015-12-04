package br.com.lucasfogaca.listadetarefas;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class AlteraCadastro extends AppCompatActivity {

    EditText nome;
    EditText descricao;
    EditText data;
    BancoController crud;
    String codigo;
    Button alterar;
    Cursor cursor;
    Button deletar;
    RatingBar estrelas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_cadastro);

        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());


        nome = (EditText) findViewById(R.id.nome);
        descricao = (EditText) findViewById(R.id.desc);
        data = (EditText) findViewById(R.id.data);
        alterar = (Button) findViewById(R.id.alterar);
        deletar = (Button) findViewById(R.id.deletar);
        estrelas = (RatingBar) findViewById(R.id.estrelass);

        Tarefa t = crud.carregaDadoById(Integer.parseInt(codigo));
        nome.setText(t.getNome());
        descricao.setText(t.getDesc());
        data.setText(t.getData());
        estrelas.setRating(t.getRatingBar());

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                crud.alteraRegistro(Integer.parseInt(codigo), nome.getText().toString(), descricao.getText().toString(), data.getText().toString(), estrelas.getRating());

                Intent intent = new Intent(AlteraCadastro.this, Resultado.class);

                startActivity(intent);
                finish();

            }
        });

        deletar = (Button)findViewById(R.id.deletar);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlteraCadastro.this, Resultado.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
