package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.ui.home.HomeFragment;
import com.gastomestre.myapplication.db.BancoController;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabGastos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabGastos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabGastos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabGastos.
     */
    // TODO: Rename and change types and number of parameters
    public static TabGastos newInstance(String param1, String param2) {
        TabGastos fragment = new TabGastos();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_gastos, container, false);
    }

    public static class ViewPagerAdapter extends FragmentStateAdapter {
        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0: return new TabGastos();
                case 1: return new TabGanhos();
                default: return new TabGastos();
            }
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    public void addItemsToCategoryList(String categoriaParam, List<item_list> listName){
        BancoController bd = new BancoController(getActivity().getBaseContext());

        Cursor dados = bd.carregaGastosPeloId(MainActivity.IdUserLogado, categoriaParam);

        int position = 0;

        while(dados.moveToPosition(position)){
            Double valorGasto = dados.getDouble(0);
            String dataGasto = dados.getString(1);
            Formatter valorGastoFormatter = new Formatter();
            valorGastoFormatter.format("%.2f", valorGasto);
            String valorGastoFormatado = "R$ -" + valorGastoFormatter;
            valorGastoFormatado = valorGastoFormatado.replace(".", ",");
            //String categoria = dados.getString(2);

            listName.add(new item_list(valorGastoFormatado, dataGasto));

            position = position + 1;
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerViewPoupanca = (RecyclerView) getView().findViewById(R.id.poupancaList);
        RecyclerView recyclerViewInvestimento = (RecyclerView) getView().findViewById(R.id.investimentoList);
        RecyclerView recyclerViewCompras = (RecyclerView) getView().findViewById(R.id.comprasList);
        RecyclerView recyclerViewContas = (RecyclerView) getView().findViewById(R.id.contasList);

        List<item_list> itemsPoupanca = new ArrayList<item_list>();
        List<item_list> itemsInvestimento = new ArrayList<item_list>();
        List<item_list> itemsCompras = new ArrayList<item_list>();
        List<item_list> itemsContas = new ArrayList<item_list>();


        addItemsToCategoryList("Poupança", itemsPoupanca);
        addItemsToCategoryList("Investimento", itemsInvestimento);
        addItemsToCategoryList("Compras", itemsCompras);
        addItemsToCategoryList("Contas", itemsContas);


        recyclerViewPoupanca.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPoupanca.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsPoupanca));

        recyclerViewContas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContas.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsContas));


        recyclerViewInvestimento.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewInvestimento.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsInvestimento));


        recyclerViewCompras.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewCompras.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsCompras));
    }
}