package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gastomestre.myapplication.db.BancoController;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Formatter;
import java.util.Locale;

public class cadastrar_ganho extends AppCompatActivity {

    private Spinner spinnerTextSize;

    private String current = "";

    EditText txtValorGanho;

    Spinner txtCategoriaGanho;

    Button salvarGanho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_ganho);

        spinnerTextSize = findViewById(R.id.txtCategoriaGanho);
        EditText inputValor = (EditText) findViewById(R.id.valorGanho);

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


        String[] textSizes = getResources().getStringArray(R.array.array_categoria_ganho);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTextSize.setAdapter(adapter);

        Long a = Long.parseLong("999999999999999999");
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(a));
    }

    public void salvarGanho(View view) throws ParseException {
        DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.simpleDatePicker);
        txtValorGanho = (EditText) findViewById(R.id.valorGanho);
        String txtValorGanhoStr = txtValorGanho.getText().toString().replaceAll("[R$\\s+]", "");
        String valorGanhoString = txtValorGanhoStr.replace(",", ".");
        final Locale myLocale = new Locale("pt", "BR");
        NumberFormat format = NumberFormat.getInstance(myLocale);
        Double valorGanhoDouble = format.parse(txtValorGanhoStr).doubleValue();
        Formatter valorGanhoFormatter = new Formatter();
        valorGanhoFormatter.format("%.2f", valorGanhoDouble);
        Double valorGanhoDoubleFinal = Double.parseDouble(valorGanhoFormatter.toString());

        String dataGanho = simpleDatePicker.getDayOfMonth() + "/" + (simpleDatePicker.getMonth() + 1) + "/" + simpleDatePicker.getYear() ;

        txtCategoriaGanho = (Spinner) findViewById(R.id.txtCategoriaGanho);

        String categoria = txtCategoriaGanho.getSelectedItem().toString();

        salvarGanho = (Button) findViewById(R.id.salvarGanho);

        Log.d("Teste valor", valorGanhoDoubleFinal.toString());
        Log.d("Teste data", dataGanho);
        Log.d("Teste categoria", categoria);

        BancoController bd = new BancoController(getBaseContext());

        String resultado = bd.cadastraGanho(MainActivity.IdUserLogado, valorGanhoDoubleFinal, dataGanho,
                categoria) ;

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

    }
}