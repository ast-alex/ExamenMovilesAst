package com.moviles.examenmovilesast.ui.Cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.moviles.examenmovilesast.MainActivity;
import com.moviles.examenmovilesast.Modelo.Persona;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mError;

    public CargarViewModel(@NonNull Application application) {
        super(application);

    }


    public LiveData<String> getError() {
        if (mError == null) {
            mError = new MutableLiveData<>();
        }
        return mError;
    }

    public void cargarPersona(String dni, String apellido, String nombre, String edadS) {
        if (dni.isEmpty() || apellido.isEmpty() || nombre.isEmpty() || edadS.isEmpty()) {
            mError.setValue("Todos los campos deben estar completos");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadS);
        } catch (NumberFormatException e) {
            mError.setValue("La edad debe ser un número válido");
            return;
        }


        for (Persona persona : MainActivity.listaPersonas) {
            if (persona.getDni().equals(dni)) {
                mError.setValue("El DNI ya está registrado");
                return;
            }
        }

        Persona nuevaPersona = new Persona(dni, apellido, nombre, edad);
        MainActivity.listaPersonas.add(nuevaPersona);
        mError.setValue(null);
    }
}