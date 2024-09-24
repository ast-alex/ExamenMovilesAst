package com.moviles.examenmovilesast.ui.Listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moviles.examenmovilesast.R;
import com.moviles.examenmovilesast.Modelo.Persona;

import java.util.List;

public class ListarAdapter extends RecyclerView.Adapter<ListarAdapter.PersonaViewHolder> {

    private List<Persona> listaPersonas;

    public ListarAdapter(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        Persona persona = listaPersonas.get(position);
        holder.tvDni.setText("DNI: " + persona.getDni());
        holder.tvApellido.setText("Apellido: " + persona.getApellido());
        holder.tvNombre.setText("Nombre: " + persona.getNombre());
        holder.tvEdad.setText("Edad: " + persona.getEdad());
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder {
        TextView tvDni, tvApellido, tvNombre, tvEdad;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDni = itemView.findViewById(R.id.tvDni);
            tvApellido = itemView.findViewById(R.id.tvApellido);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEdad = itemView.findViewById(R.id.tvEdad);
        }
    }
}
