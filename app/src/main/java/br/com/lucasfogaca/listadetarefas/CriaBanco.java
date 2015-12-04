package br.com.lucasfogaca.listadetarefas;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by lucasfogaca on 23/11/15.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "tarefas";
    public static final String ID = "_id";
    public static final String DESC = "descrição";
    public static final String DATA = "data";
    public static final String NOME = "nome";
    public static final String NOTA = "nota";
    public static final int VERSAO = 1;

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABELA+" ("
                + ID + " integer primary key autoincrement,"
                + DESC + " text, "
                + DATA + " text, "
                + NOTA + " integer, "
                + NOME + " text "
                +" ) ";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);

    }


}