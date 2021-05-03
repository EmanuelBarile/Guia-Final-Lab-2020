package com.company;

public class Main {

    final  static int dimension =20;

    public static void main(String[] args) {

        Cliente listaClientes[]= new Cliente[dimension];
        Producto listaProductos[]= new Producto[dimension];
        Envio listaEnvios[]= new Envio[dimension];

        Distribuidora distribuidoraUnica= new Distribuidora(listaClientes,listaProductos,listaEnvios);

        //carga de datos

        distribuidoraUnica.insertarCliente("Jose","Larrea 1382",2235478,true);
        distribuidoraUnica.insertarCliente("Lucia","Arenales 2464",2235447,false);

        distribuidoraUnica.insertarProducto("Llavero",18,200);
        distribuidoraUnica.insertarProducto("Billetera",220,40);
        distribuidoraUnica.insertarProducto("Destapador",32,150);
        distribuidoraUnica.insertarProducto("Cubetera",36,60);


        imprimirProductos(distribuidoraUnica);
        imprimirClientes(distribuidoraUnica);

        //cargo envios

        distribuidoraUnica.realizarUnEnvio("Lucia","Cubetera",11);
        distribuidoraUnica.realizarUnEnvio("Jose","Billetera",15);
        distribuidoraUnica.realizarUnEnvio("Lucia","Billetera",65);

        imprimirEnvios(distribuidoraUnica);
        imprimirProductos(distribuidoraUnica);

        System.out.println("el promedio total de vendidos es: "+ promedioDeTotalVendido(distribuidoraUnica));
    }


    // Métodos estáticos , duda de si declararlos acá en main o en la clase Distribuidora

    public static void imprimirProductos(Distribuidora distribuidora ) {
        System.out.println("\n///// Listado de  productos /////"); // probar declararlo en clase distribuidora
        for (Producto produ : distribuidora.getListaProductos() ) {
            if (produ != null) System.out.println(produ);
        }
    }

    public static void  imprimirClientes (Distribuidora distribuidora){
        System.out.println("\n////// Listado de clientes ///// " );
        for (Cliente cliente  : distribuidora.getListaClientes()  ) {
            if(cliente !=null) System.out.println(cliente);

        }

    }

    public static void imprimirEnvios (Distribuidora distribuidora){

        System.out.println("\n////// Listado de envios ///// ");
        for ( Envio envio : distribuidora.getListaEnvios() ) {
            if (envio !=null) System.out.println(envio);

        }
    }

    public static double promedioDeTotalVendido(Distribuidora distribuidora){

        double promedioTotal=0;
        int cont=0; // se soluciona usando ArrayList en vez de Array comun
        for (Envio envio : distribuidora.getListaEnvios() ) {
            if(envio !=null){
                promedioTotal+= Envio.calcularCostoTotal(envio.getClienteEnvio(), envio.getProductoEnvio(), envio.getCantidadKm());
                cont++;
            }

        }
        return promedioTotal / cont;
    }

    public static void ImprimirClienteConMasCompras(Distribuidora distribuidora){

        // realizar y ver diferencias usando arraylist
    }

}
