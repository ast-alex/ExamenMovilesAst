package com.moviles.examenmovilesast.ui.Listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.moviles.examenmovilesast.Modelo.Persona;
import com.moviles.examenmovilesast.MainActivity;

import java.util.List;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<List<Persona>> mPersonas;

    public ListarViewModel(@NonNull Application application) {
        super(application);
        mPersonas = new MutableLiveData<>();
        cargarPersonas();
    }

    public LiveData<List<Persona>> getPersonas() {

        return mPersonas;
    }

    private void cargarPersonas() {
        mPersonas.setValue(MainActivity.listaPersonas);
    }

    public void actualizarLista() {
        mPersonas.setValue(MainActivity.listaPersonas);
    }
}