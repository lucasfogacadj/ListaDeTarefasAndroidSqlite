package br.com.lucasfogaca.listadetarefas;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        BancoController crud = new BancoController(getApplicationContext());



       // String [] nomeCampos = new String[]{CriaBanco.ID, CriaBanco.NOME, CriaBanco.DESC, CriaBanco.DATA, CriaBanco.NOTA};
    //    int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro, R.id.descricao, R.id.datal, R.id.nota};
        final ArrayList<Tarefa> array=crud.carregaDados();


        TarefaAdapter adaptador = new TarefaAdapter(getBaseContext(),R.layout.layout,array);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                String xx=null;

                codigo = xx.valueOf(array.get(position).getId());
                Intent intent = new Intent(Resultado.this, AlteraCadastro.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }
}
