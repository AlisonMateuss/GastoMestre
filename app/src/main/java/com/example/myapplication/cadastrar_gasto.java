package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextWatcher;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.NumberFormat;

public class cadastrar_gasto extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinnerTextSize;

    // private String current = "";

    // EditText inputValor = findViewById(R.id.valorGasto);

    //public void onTextChanged(CharSequence s, int start, int before, int count) {
    //    if(!s.toString().equals(current)){
    //   inputValor.removeTextChangedListener((TextWatcher) this);

    //        String cleanString = s.toString().replaceAll("[$,.]", "");

    //        double parsed = Double.parseDouble(cleanString);
    //        String formatted = NumberFormat.getCurrencyInstance().format((parsed/100));

    //        current = formatted;
    //   inputValor.setText(formatted);
    //   inputValor.setSelection(formatted.length());

    //   inputValor.addTextChangedListener((TextWatcher) this);
    //    }
    //}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_gasto);

        spinnerTextSize = findViewById(R.id.spinnerTextSize);

        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTextSize.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

