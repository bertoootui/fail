package com.example.bd_app_tfc_alberto.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bd_app_tfc_alberto.R;
import com.example.bd_app_tfc_alberto.clases.ConfigPreferences;
import com.example.bd_app_tfc_alberto.database.Empleados_DB;
import com.example.bd_app_tfc_alberto.database.Servicios_DB;

import org.w3c.dom.Text;


public class NewDate2Fragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void onViewCreated(View view, Bundle savedInstaceState)
    {
        super.onViewCreated(view,savedInstaceState);
        TextView txtServ = view.findViewById(R.id.txtservND);
        TextView txtemp = view.findViewById(R.id.txtuserND);
        ConfigPreferences config = new ConfigPreferences();
        int id_emp = config.getEmpSel(getContext());
        int id_serv = config.getServSel(getContext());
        Empleados_DB empleados_db = new Empleados_DB(getContext());
        String nombreemp = empleados_db.getNameEmp(id_emp);
        txtemp.setText(nombreemp);
        Servicios_DB servicios_db = new Servicios_DB(getContext());
        String servicio = servicios_db.getServName(id_serv);
        txtServ.setText(servicio);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_date2, container, false);
    }
}