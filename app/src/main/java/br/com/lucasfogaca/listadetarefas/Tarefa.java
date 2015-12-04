package br.com.lucasfogaca.listadetarefas;

import android.widget.RatingBar;

import java.util.Date;

/**
 * Created by lucasfogaca on 20/11/15.
 */
public class Tarefa {
    private  int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String desc;
    private String data;
    private int ratingBar;

    public Tarefa(String nome, String desc, String data, int ratingBar) {
        this.nome = nome;
        this.desc = desc;
        this.data = data;
        this.ratingBar=ratingBar;
    }

    public Tarefa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(int r) {
        this.ratingBar=r;
    }
}
