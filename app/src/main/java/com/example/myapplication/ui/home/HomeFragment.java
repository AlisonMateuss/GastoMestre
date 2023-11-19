package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.home;

public class HomeFragment extends Fragment {

    TextView txtUserName;
    String userNameText  = home.userNameText;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        txtUserName = root.findViewById(R.id.txtUserName);

        Intent intent = getActivity().getIntent();
        Bundle parametros = intent.getExtras();

        String nome = parametros.getString("nome");

        txtUserName.setText(nome);


        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtUserName = getActivity().findViewById(R.id.txtUserName);

        Intent intent = getActivity().getIntent();
        Bundle parametros = intent.getExtras();

        String nome = parametros.getString("nome");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}