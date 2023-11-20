package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gastomestre.myapplication.db.BancoController;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabGanhos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabGanhos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public TabGanhos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabGanhos.
     */
    // TODO: Rename and change types and number of parameters

    public static TabGanhos newInstance(String param1, String param2) {
        TabGanhos fragment = new TabGanhos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void addItemsToCategoryList(String categoriaParam, List<item_list> listName){
        BancoController bd = new BancoController(getActivity().getBaseContext());

        Cursor dados = bd.carregaGanhosPeloId(MainActivity.IdUserLogado, categoriaParam);

        int position = 0;

        while(dados.moveToPosition(position)){
            Double valorGasto = dados.getDouble(0);
            String dataGasto = dados.getString(1);
            Formatter valorGastoFormatter = new Formatter();
            valorGastoFormatter.format("%.2f", valorGasto);
            String valorGastoFormatado = "R$ " + valorGastoFormatter;
            valorGastoFormatado = valorGastoFormatado.replace(".", ",");
            //String categoria = dados.getString(2);

            listName.add(new item_list(valorGastoFormatado, dataGasto));

            position = position + 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_ganhos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerViewSalario = (RecyclerView) getView().findViewById(R.id.salarioList);
        RecyclerView recyclerViewInvestimento = (RecyclerView) getView().findViewById(R.id.investimentoList);
        RecyclerView recyclerViewVendas = (RecyclerView) getView().findViewById(R.id.vendasList);

        List<item_list> itemsSalario = new ArrayList<item_list>();
        List<item_list> itemsInvestimento = new ArrayList<item_list>();
        List<item_list> itemsVendas = new ArrayList<item_list>();

        addItemsToCategoryList("Salário", itemsSalario);
        addItemsToCategoryList("Investimento", itemsInvestimento);
        addItemsToCategoryList("Vendas", itemsVendas);

        recyclerViewSalario.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSalario.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsSalario));

        recyclerViewInvestimento.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewInvestimento.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsInvestimento));

        recyclerViewVendas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewVendas.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsVendas));

    }
}