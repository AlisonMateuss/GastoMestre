package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.databinding.FragmentPerfilBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil extends Fragment {
    EditText TxtNameMeusDados, TxtEmailMeusDados, TxtSenhaMeusDados, TxtConfirmarSenhaMeusDados, TxtAlterarSenhaMeusDados;
    private static final String ARG_PARAM1 = "param1";
    private FragmentPerfilBinding binding;
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    EditText txtNameMeusDados;
    private String mParam2;

    public Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static Perfil newInstance(String param1, String param2) {
        Perfil fragment = new Perfil();
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
        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Intent intent = getActivity().getIntent();
        Bundle parametros = intent.getExtras();
        txtNameMeusDados = root.findViewById(R.id.txtNomeMeusDados);
        String nome = parametros.getString("nome");
        txtNameMeusDados.setText(nome);
        return inflater.inflate(R.layout.fragment_perfil, container, false);

    }
}