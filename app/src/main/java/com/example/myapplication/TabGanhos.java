package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_ganhos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerViewPoupanca = (RecyclerView) getView().findViewById(R.id.poupancaList);

        List<item_list> itemsPoupanca = new ArrayList<item_list>();

        itemsPoupanca.add(new item_list ("R$ -300,00", "23/09/2023"));
        itemsPoupanca.add(new item_list ("R$ -500,00", "25/09/2023"));
        itemsPoupanca.add(new item_list ("R$ -700,00", "27/09/2023"));
        itemsPoupanca.add(new item_list ("R$ -590,00", "07/08/2023"));
        itemsPoupanca.add(new item_list ("R$ -200,00", "10/10/2023"));

        recyclerViewPoupanca.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPoupanca.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsPoupanca));

        RecyclerView recyclerViewContas = (RecyclerView) getView().findViewById(R.id.contasList);

        List<item_list> itemsContas = new ArrayList<item_list>();

        itemsContas.add(new item_list ("R$ -700,00", "16/06/2023"));
        itemsContas.add(new item_list ("R$ -590,00", "07/08/2023"));
        itemsContas.add(new item_list ("R$ -200,00", "10/10/2023"));
        itemsContas.add(new item_list ("R$ -590,00", "07/08/2023"));
        itemsContas.add(new item_list ("R$ -200,00", "10/10/2023"));

        recyclerViewContas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContas.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsContas));

        RecyclerView recyclerViewInvestimento = (RecyclerView) getView().findViewById(R.id.investimentoList);

        List<item_list> itemsInvestimento = new ArrayList<item_list>();

        itemsInvestimento.add(new item_list ("R$ -900,00", "20/09/2023"));
        itemsInvestimento.add(new item_list ("R$ -160,00", "10/05/2023"));
        itemsInvestimento.add(new item_list ("R$ -50,00", "10/12/2023"));
        itemsInvestimento.add(new item_list ("R$ -50,00", "10/12/2023"));
        itemsInvestimento.add(new item_list ("R$ -50,00", "10/12/2023"));

        recyclerViewInvestimento.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewInvestimento.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsInvestimento));

        RecyclerView recyclerViewCompras = (RecyclerView) getView().findViewById(R.id.comprasList);

        List<item_list> itemsCompras = new ArrayList<item_list>();

        itemsCompras.add(new item_list ("R$ -900,00", "20/09/2023"));
        itemsCompras.add(new item_list ("R$ -160,00", "10/05/2023"));
        itemsCompras.add(new item_list ("R$ -50,00", "10/12/2023"));
        itemsCompras.add(new item_list ("R$ -50,00", "10/12/2023"));
        itemsCompras.add(new item_list ("R$ -50,00", "10/12/2023"));

        recyclerViewCompras.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewCompras.setAdapter(new MyAdapter(getActivity().getApplicationContext(), itemsCompras));
    }
}