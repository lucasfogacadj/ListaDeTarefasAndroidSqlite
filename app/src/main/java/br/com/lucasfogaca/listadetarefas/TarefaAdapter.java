package br.com.lucasfogaca.listadetarefas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucasfogaca on 26/11/15.
 */
public class TarefaAdapter extends ArrayAdapter <Tarefa> {


    public TarefaAdapter(Context context, int textViewResourceId, ArrayList<Tarefa> objects) {
        super(context,  textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View linha = LayoutInflater.from(getContext()).inflate(R.layout.layout, null);

        TextView id = (TextView) linha.findViewById(R.id.idLivro);
        TextView nome = (TextView) linha.findViewById(R.id.nomeLivro);
        TextView desc = (TextView) linha.findViewById(R.id.descricao);
        TextView data = (TextView) linha.findViewById(R.id.datal);
        RatingBar nota = (RatingBar) linha.findViewById(R.id.nstar);

        Tarefa tarefa = getItem(position);

        id.setText(String.valueOf(tarefa.getId()));
        nome.setText(tarefa.getNome());
        desc.setText(tarefa.getDesc());
        data.setText(tarefa.getData());
        nota.setRating(tarefa.getRatingBar());


        return linha;
        //return super.getView(position, convertView, parent);
    }
}
