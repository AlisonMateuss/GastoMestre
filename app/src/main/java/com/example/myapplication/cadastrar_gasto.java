package com.example.myapplication;

import android.icu.text.DecimalFormat;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class cadastrar_gasto extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinnerTextSize;

    private String current = "";


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
        EditText inputValor = (EditText) findViewById(R.id.valorGasto);

        DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.simpleDatePicker); // initiate a date picker
        simpleDatePicker.setCalendarViewShown(false);

//        inputValor.addTextChangedListener(new CurrencyTextWatcher());

        inputValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            private String current = "";
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().equals(current)) {
                    Locale myLocale = new Locale("pt", "BR");
                    //Nesse bloco ele monta a maskara para money
                    inputValor.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[R$,.\\s+]", "");
                    Double parsed = Double.parseDouble(cleanString);
                    String formatted = NumberFormat.getCurrencyInstance(myLocale).format((parsed / 100));
                    current = formatted;
                    inputValor.setText(formatted);
                    inputValor.setSelection(formatted.length());


                    inputValor.addTextChangedListener(this);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        String[] textSizes = getResources().getStringArray(R.array.font_sizes);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTextSize.setAdapter(adapter);

        Long a = Long.parseLong("999999999999999999");
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(a));
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

//class CurrencyTextWatcher implements TextWatcher {
//
//    boolean mEditing;
//
//    public CurrencyTextWatcher() {
//        mEditing = false;
//    }
//    @Override
//    public synchronized void afterTextChanged(Editable s) {
//        if(!mEditing) {
//            mEditing = true;
//
//            String digits = s.toString().replaceAll("\\D", "");
//            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
//            try{
//                String formatted = nf.format(Double.parseDouble(digits)/100);
//                s.replace(0, s.length(), formatted);
//            } catch (NumberFormatException nfe) {
//                s.clear();
//            }
//
//            mEditing = false;
//        }
//    }
//
//    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//    public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//}

