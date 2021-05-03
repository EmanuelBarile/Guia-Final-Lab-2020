package com.company;

public class Envio {

    private Cliente clienteEnvio; // pasarle cliente o solo el nombre y validar si existe?
    private Producto productoEnvio;
    private int cantidadKm;
    private static double costoKm;



    public Envio (Cliente clienteEnvio, Producto productoEnvio, int cantidadKm){

        this.clienteEnvio=clienteEnvio;
        this.productoEnvio=productoEnvio;
        this.cantidadKm=cantidadKm;
        this.costoKm= 40;

    }

    public static double calcularCostoTotal(Cliente cliente ,Producto producto, int cantidadKm){

        double costoTotal=0;

        if(cliente.isMayorista()== true){

            costoTotal= (producto.getPrecio()+ (cantidadKm* costoKm))*0.85;
        }
        else{
            costoTotal= (producto.getPrecio()+ (cantidadKm* costoKm));

        }
        return costoTotal;
    }

    @Override
    public String toString() {
        return "Envio{ " +
                "cliente= " + clienteEnvio.getNombre() +
                ", producto= " + productoEnvio.getNombre() +
                ", cantidadKm= " + cantidadKm +
                ", costoKm= " + costoKm +
                '}';
    }

    public int getCantidadKm() {
        return cantidadKm;
    }

    public double getCostoKm() {
        return costoKm;
    }

    public Cliente getClienteEnvio() {
        return clienteEnvio;
    }

    public Producto getProductoEnvio() {
        return productoEnvio;
    }
}
