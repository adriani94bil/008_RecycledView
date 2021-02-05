package com.recyclerview.model;

public class Pais {
    private String nombre;
    private int bandera;  //R.drawable.haity_flag

    public Pais(String nombre, int bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
}
