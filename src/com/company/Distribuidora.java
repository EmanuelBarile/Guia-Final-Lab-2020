package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Distribuidora {

    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Envio> listaEnvios = new ArrayList<>();

    //Constructor


    public Distribuidora (){

        this.listaClientes=new ArrayList<>();
        this.listaProductos=new ArrayList<>();
        this.listaEnvios=new ArrayList<>();

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



    //Envio es la operacion que engloba a las demas clases, aca preciso validar tanto cliente
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

    public  void imprimirProductos() {
        System.out.println("\n///// Listado de  productos /////"); // probar declararlo en clase distribuidora
        for (Producto produ : this.getListaProductos() ) {
            if (produ != null) System.out.println(produ);
        }
    }

    public  void  imprimirClientes ( ){
        System.out.println("\n////// Listado de clientes ///// " );
        for (Cliente cliente  : this.getListaClientes()  ) {
            if(cliente !=null) System.out.println(cliente);

        }

    }

    public  void imprimirEnvios (){

        System.out.println("\n////// Listado de envios ///// ");
        for ( Envio envio : this.getListaEnvios() ) {
            if (envio !=null) System.out.println(envio);

        }
    }

    //4) Realizar 5 ventas por consola y mostrar el promedio de totales vendidos (costo
    //del producto + envío).

    public  double promedioDeTotalVendido(){

        double promedioTotal=0;
        for (Envio envio : this.getListaEnvios() ) {
            if(envio !=null){
                promedioTotal+= Envio.calcularCostoTotal(envio.getClienteEnvio(), envio.getProductoEnvio(), envio.getCantidadKm());
            }
        }
        return promedioTotal / this.getListaEnvios().size();
    }

    //5) Indicar por consola, quien fue el cliente que más compras realizó y mostrar sus
    //atributos

    public  void imprimirClienteConMasCompras(){

        int contador=0;     // guardo las frecuencias al terminar cada ronda
        int frecuencia=0;   // cuento las frecuencias de cada cliente
        int indice=-1;      // -1 para marcar el primer sub indice en 0
        int j=0;

        for (int i=0; i<this.getListaClientes().size(); i++){
            Cliente cliente= this.getListaClientes().get(i); // guardo el cliente de primer sub indice

            for (j=0; j<this.getListaEnvios().size();j++){
                if (cliente.equals(this.getListaEnvios().get(j).getClienteEnvio()) ){ // lo comparo con el cliente de la lista de envios
                    frecuencia++; // acumulo frecuencia de coincidencias
                }

            }
            j=0; // reseteo j para recorrer la listaEnvios desde el principio en la proxima vuelta
            if (frecuencia>contador){   //si la frecuencia de la reciente vuelta es mayor a contador hago los reemplazos
                indice++;               // guardo el indice del cliente con mayor cantidad de compras
                contador=frecuencia;    // guardo las frecuencias en contador
                frecuencia=0;           // reseteo frecuencias
            }
        }

        System.out.println("Cliente con mayor cantidad de compras es: "+ this.getListaClientes().get(indice));
        System.out.println("con un total de ventas igual a :"+contador );
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
