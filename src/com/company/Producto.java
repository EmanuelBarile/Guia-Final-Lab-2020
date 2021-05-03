package com.company;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;



    public Producto (String nombre, double precio, int stock){

        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;

    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void disminuirStock (){
        this.stock= stock-1;

    }

    public boolean verificarStock( ){
        if (this.getStock()>0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
