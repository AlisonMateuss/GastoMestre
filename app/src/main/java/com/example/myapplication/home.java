package com.example.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.HomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class home extends AppCompatActivity {
    FloatingActionButton add_btn,ganho_btn,gasto_btn;
    TextView txtUserName;

    public static String userNameText;

    boolean aBoolean=true;

    private HomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_home);
        NavigationUI.setupWithNavController(binding.navView, navController);

        add_btn=findViewById(R.id.add_btn);
        ganho_btn=findViewById(R.id.ganho_btn);
        gasto_btn=findViewById(R.id.gasto_btn);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aBoolean){
                    ganho_btn.show();
                    gasto_btn.show();
                    aBoolean =false;

                }else {
                    ganho_btn.hide();
                    gasto_btn.hide();
                    aBoolean =true;
                }

            }
        });

        Intent intent = getIntent();
        userNameText = intent.getStringExtra("nome");
        Bundle parametros = intent.getExtras();
        HomeFragment homeFrag = new HomeFragment();
        homeFrag.setArguments(parametros);
    }
    public void cadastrarGasto(View v) {
        Intent intent;
        intent = new Intent(home.this, cadastrar_gasto.class);
        startActivity(intent);
    }
}