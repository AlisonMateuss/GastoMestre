package com.gastomestre.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco_CRUD.db";
    private static final int VERSAO = 2;
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlGasto = "CREATE TABLE gasto ("
                + "id_gasto integer primary key autoincrement,"
                + "id_user integer,"
                + "valor_gasto numeric,"
                + "data_gasto text,"
                + "categoria text)";
        db.execSQL(sqlGasto);
        String sql = "CREATE TABLE usuarios ("
                + "codigo integer primary key autoincrement,"
                + "nome text,"
                + "email text,"
                + "senha text)";
        db.execSQL(sql);
        String sqlGanho = "CREATE TABLE ganho ("
                + "id_ganho integer primary key autoincrement,"
                + "id_user integer,"
                + "valor_ganho numeric,"
                + "data_ganho text,"
                + "categoria text)";
        db.execSQL(sqlGanho);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS gasto");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
