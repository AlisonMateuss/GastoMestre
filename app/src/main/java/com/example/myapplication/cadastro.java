package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.gastomestre.myapplication.db.BancoController;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro extends AppCompatActivity implements View.OnClickListener {
    Button btnCadastrar;
    EditText txtNome, txtEmail, txtSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        btnCadastrar.setOnClickListener(this);
    }

    public void voltarParaLogin(View view){
        Intent intent;
        intent = new Intent(cadastro.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        String name = txtNome.getText().toString();
        String email = txtEmail.getText().toString();
        String senha = txtSenha.getText().toString();
        String msg;

        if(name.length()==0){
            msg = "O Campo Nome deve ser preenchido corretamente";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        } else {
            if(email.length()==0){
                msg = "O Campo E-mail deve ser preenchido corretamente";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            } else {
                if(senha.length()==0){
                    msg = "O Campo Senha deve ser preenchido corretamente";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else {
                    // gravar o rayo
                    BancoController bd = new BancoController(getBaseContext());

                    msg = bd.insereDadosUsuario(name, email, senha);

                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");

                    Intent intent;
                    intent = new Intent(cadastro.this, MainActivity.class);

                    startActivity(intent);
                }
            }
        }
    }
}