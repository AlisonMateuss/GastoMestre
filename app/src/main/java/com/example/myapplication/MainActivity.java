package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.myapplication.ui.home.HomeFragment;
import com.gastomestre.myapplication.db.BancoController;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    Button btnEntrar;
    EditText txtEmailLogin, txtSenhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        txtEmailLogin = (EditText) findViewById(R.id.txtEmailLogin);
        txtSenhaLogin = (EditText) findViewById(R.id.txtSenhaLogin);

        btnEntrar.setOnClickListener(this);
    }


    public void abrirCadastro(View v) {
        Intent intent;
        intent = new Intent(MainActivity.this, cadastro.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        String email = txtEmailLogin.getText().toString();
        String senha = txtSenhaLogin.getText().toString();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosParaLogin(email, senha) ;

        if(dados.moveToFirst()){
            Intent intent = new Intent(MainActivity.this, home.class);
            Intent intentHomeFrag = new Intent(MainActivity.this, HomeFragment.class);
            String nome = dados.getString(1);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            parametros.putString("email",email);
            parametros.putString("senha", senha);
            intent.putExtras(parametros);
            intentHomeFrag.putExtras(parametros);
            startActivity(intent);
        }else{
            String msg= "Usuário e/ou Senha inválida!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}