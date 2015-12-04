package br.com.lucasfogaca.listadetarefas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.RatingBar;

import java.util.ArrayList;

/**
 * Created by lucasfogaca on 23/11/15.
 */
public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome, String desc, String data, Integer nota){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();

        valores = new ContentValues();

        valores.put(CriaBanco.NOME, nome);
        valores.put(CriaBanco.DESC, desc);
        valores.put(CriaBanco.DATA, data);
        valores.put(CriaBanco.NOTA, nota);
        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";


    }

    public ArrayList carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME, banco.DESC, banco.DATA, banco.NOTA};
        String order = " nota DESC";
        ArrayList<Tarefa> array = new ArrayList<>();
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, order, null);

        cursor.moveToFirst();
        do{


            String nT1   = cursor.getString(1);
            String nT2 = cursor.getString(2);
            String nT3 = cursor.getString(3);
            int nT4 = cursor.getInt(4);
            Tarefa t = new Tarefa(nT1,nT2, nT3, nT4);
            t.setId(cursor.getInt(0));
            array.add(t);

        }while (cursor.moveToNext());
        db.close();
        return array;
    }

    public Tarefa carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME,banco.DESC,banco.DATA, banco.NOTA};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA, campos, where, null, null, null, null, null);
    Tarefa tar;

        cursor.moveToFirst();
        do{

            String nT1   = cursor.getString(1);
            String nT2 = cursor.getString(2);
            String nT3 = cursor.getString(3);
            int nT4 = cursor.getInt(4);

            Tarefa t = new Tarefa(nT1,nT2, nT3, nT4);
            t.setId(cursor.getInt(0));
              tar=t;

        }while (cursor.moveToNext());
        db.close();
        return tar;


    }

    public void alteraRegistro(int id, String nome, String desc, String data, Float estrelas){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.NOME, nome);
        valores.put(CriaBanco.DESC, desc);
        valores.put(CriaBanco.DATA, data);
        valores.put(CriaBanco.NOTA, String.valueOf(estrelas));

        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro(int id){
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }

}
