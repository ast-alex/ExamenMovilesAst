package com.moviles.examenmovilesast.ui.Listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.moviles.examenmovilesast.Modelo.Persona;
import com.moviles.examenmovilesast.databinding.FragmentListarBinding;

import java.util.List;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel vm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm = new ViewModelProvider(this).get(ListarViewModel.class);

        vm.getPersonas().observe(getViewLifecycleOwner(), new Observer<List<Persona>>() {
            @Override
            public void onChanged(List<Persona> personas) {
                ListarAdapter adapter = new ListarAdapter(personas);
                binding.lista.setLayoutManager(new LinearLayoutManager(getContext()));
                binding.lista.setAdapter(adapter);
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        vm.actualizarLista();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}