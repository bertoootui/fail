package com.example.bd_app_tfc_alberto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bd_app_tfc_alberto.R;
import com.example.bd_app_tfc_alberto.clases.Empleados;

import java.time.temporal.Temporal;
import java.util.ArrayList;

public class RvEmpAdapter extends RecyclerView.Adapter<RvEmpAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Empleados> listaemp;

    public RvEmpAdapter(Context context, ArrayList<Empleados> listaemp)
    {
        this.context = context;
        this.listaemp = listaemp;
    }

    @NonNull
    @Override
    public RvEmpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_empleados,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvEmpAdapter.ViewHolder holder, int position) {

        holder.txtemp.setText(listaemp.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaemp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgfoto;
        TextView txtemp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgfoto = itemView.findViewById(R.id.imgcardemp);
            txtemp = itemView.findViewById(R.id.txtcardemp);
        }
    }
}
