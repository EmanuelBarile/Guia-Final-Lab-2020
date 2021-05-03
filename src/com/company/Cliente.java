package com.company;

public class Cliente {

    private String nombre;
    private String direccion;
    private int telefono;
    private  boolean isMayorista= false;



    public Cliente (String nombre, String direccion, int telefono, boolean isMayorista){

        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
        this.isMayorista=isMayorista;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public boolean isMayorista() {
        return isMayorista;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", isMayorista=" + isMayorista +
                '}';
    }
}
