package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Distribuidora {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Envio> listaEnvios = new ArrayList<>();

    //Constructor
    public Distribuidora (ArrayList<Cliente> listaClientes, ArrayList<Producto> listaProductos, ArrayList<Envio> listaEnvios){

        this.listaClientes=listaClientes;
        this.listaProductos=listaProductos;
        this.listaEnvios=listaEnvios;

    }


    public void  insertarCliente (String nombre, String direccion, int telefono, boolean isMayorista){

        Cliente cliente = new Cliente(nombre, direccion, telefono, isMayorista);
        listaClientes.add(cliente);
    }

    public void insertarProducto(String nombre, double precio, int stock){

        Producto producto = new Producto(nombre, precio, stock);
        listaProductos.add(producto);

    }

    public void insertarEnvio(Producto producto, Cliente cliente, int cantidadKm){
        Envio envio =new Envio(cliente,producto,cantidadKm);
        listaEnvios.add(envio);

    }

    public Cliente buscarCliente (String nombre){ //busco y retorno un cliente por su nombre

        for (Cliente cliente  : listaClientes  ) {
            if (cliente!=null && cliente.getNombre().equals(nombre)){
                return cliente;
            }
        }
                return null;
    }

    public Producto buscarProducto (String nombre){ //busco y retorno un producto por su nombre

        for (Producto producto : listaProductos ) {
            if (producto!=null && producto.getNombre().equals(nombre)){
                return producto;
            }
        }
                return null;

    }



    //envio es la operacion que engloba a las demas clases, aca preciso validar tanto cliente
    // como producto y luego ingreso el envio a mi lista de envios

    public void realizarUnEnvio (String nombreCliente, String nombreProducto, int cantidadKm){
        Producto producto = buscarProducto(nombreProducto);
        Cliente cliente = buscarCliente(nombreCliente);
        System.out.println("el costo total del envio es:" +Envio.calcularCostoTotal(cliente,producto,cantidadKm));
        System.out.println("¿desea confirmar el pedido?");
        // falta la confirmacion
        if ( producto!=null && cliente!=null && producto.verificarStock()==true){ // verifico

            insertarEnvio(producto,cliente,cantidadKm);
            producto.disminuirStock();

        }
        else{
            System.out.println("Algo ha fallado, no se puede realizar el envio");
        }
    }


    @Override
    public String toString() {
        return "Distribuidora{" +
                "listaClientes=" + listaClientes +
                ", listaProductos=" + listaProductos +
                ", listaEnvios=" + listaEnvios +
                '}';
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public ArrayList<Envio> getListaEnvios() {
        return listaEnvios;
    }
}
