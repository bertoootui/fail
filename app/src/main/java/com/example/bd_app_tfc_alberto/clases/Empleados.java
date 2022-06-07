package com.example.bd_app_tfc_alberto.clases;

public class Empleados {
    private String nombre;
    private String foto;

    public Empleados(String nombre, String foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public Empleados() {}//CONSTRUCTOR VACÍO

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
