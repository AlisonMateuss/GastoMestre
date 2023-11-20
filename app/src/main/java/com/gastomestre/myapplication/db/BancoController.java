package com.gastomestre.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDados(String txtNome, String txtEmail) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("email", txtEmail);

        resultado = db.insert("contatos", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public String cadastraGasto(int idUser, Double valorGasto, String dataGasto, String categoria) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("id_user", idUser);
        valores.put("valor_gasto", valorGasto);
        valores.put("data_gasto", dataGasto);
        valores.put("categoria", categoria);

        resultado = db.insert("gasto", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Gasto cadastrado com sucesso";
    }

    public Cursor carregaDadosParaLogin(String email, String senha) {
        Cursor cursor;
        String[] campos = { "codigo", "nome", "email","senha" };
        String filtro = "email='" + email + "' and senha='"+ senha+"'";

        db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, filtro, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor carregaDadosPeloCodigo(int id) {
        Cursor cursor;
        String[] campos = { "codigo", "nome", "email" };
        String where = "codigo=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query("contatos", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }


    public Cursor carregaGastosPeloId(int id, String categoria) {
        Cursor cursor;
        String[] campos = { "valor_gasto", "data_gasto", "categoria" };
        String where = "id_user=" + id + " AND categoria='" + categoria + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("gasto", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }



    public String AlterarDadosUsuario(int id, String senha){
        String msg = "Dados alterados com sucesso!!!" ;

        db = banco.getReadableDatabase();

        ContentValues valores = new ContentValues() ;
        //valores.put("nome" , nome ) ;
        //valores.put("email", email) ;
        valores.put("senha" , senha ) ;

        String condicao = "codigo = " + id;

        int linha ;
        linha = db.update("usuarios", valores, condicao, null) ;
        if (linha < 1){
            msg = "Erro ao alterar os dados do usuário" ;
        }
        db.close();
        return msg;
    }

    public String alteraDados(int id, String nome, String email){

        String msg = "Dados alterados com sucesso!!!" ;

        db = banco.getReadableDatabase();

        ContentValues valores = new ContentValues() ;
        valores.put("nome" , nome ) ;
        valores.put("email", email) ;

        String condicao = "codigo = " + id;

        int linha ;
        linha = db.update("contatos", valores, condicao, null) ;

        if (linha < 1){
            msg = "Erro ao alterar os dados" ;
        }

        db.close();
        return msg;
    }


    public String excluirDados(int id){
        String msg = "Registro Excluído" ;

        db = banco.getReadableDatabase();

        String condicao = "codigo = " + id ;

        int linhas ;
        linhas = db.delete("contatos", condicao, null) ;

        if ( linhas < 1) {
            msg = "Erro ao Excluir" ;
        }

        db.close();
        return msg;
    }

    // programa do cadastre_Se
    public String insereDadosUsuario(String txtNome, String txtEmail, String txtSenha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("email", txtEmail);
        valores.put("senha",txtSenha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir o registro do usuário";
        else
            return "Registro do usuário inserido com sucesso";
    }

}
