package com.example.myapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;
import com.example.myapplication.databinding.GastoBinding;
import com.example.myapplication.item_list;

import java.util.ArrayList;
import java.util.List;

public class GastoFragment extends Fragment {

    private GastoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GastoViewModel GastoViewModel =
                new ViewModelProvider(this).get(GastoViewModel.class);

        binding = GastoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}