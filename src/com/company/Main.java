package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {


        Distribuidora distribuidoraUnica= new Distribuidora();


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
        distribuidoraUnica.realizarUnEnvio("Lucia","Llavero",112);
        distribuidoraUnica.realizarUnEnvio("Jose","Destapador",44);
        distribuidoraUnica.realizarUnEnvio("Jose","Destapador",28);
        distribuidoraUnica.realizarUnEnvio("Jose","Llavero",77);

        imprimirEnvios(distribuidoraUnica);
        imprimirProductos(distribuidoraUnica);

        System.out.println("el promedio total de vendidos es: "+ promedioDeTotalVendido(distribuidoraUnica));
        imprimirClienteConMasCompras(distribuidoraUnica);

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

    //4) Realizar 5 ventas por consola y mostrar el promedio de totales vendidos (costo
    //del producto + envío).

    public static double promedioDeTotalVendido(Distribuidora distribuidora){

        double promedioTotal=0;
        for (Envio envio : distribuidora.getListaEnvios() ) {
            if(envio !=null){
                promedioTotal+= Envio.calcularCostoTotal(envio.getClienteEnvio(), envio.getProductoEnvio(), envio.getCantidadKm());
            }
        }
        return promedioTotal / distribuidora.getListaEnvios().size();
    }

    //5) Indicar por consola, quien fue el cliente que más compras realizó y mostrar sus
    //atributos

    public static void imprimirClienteConMasCompras(Distribuidora distribuidora){

        int contador=0;     // guardo las frecuencias al terminar cada ronda
        int frecuencia=0;   // cuento las frecuencias de cada cliente
        int indice=-1;      // -1 para marcar el primer sub indice en 0
        int j=0;

        for (int i=0; i<distribuidora.getListaClientes().size(); i++){
            Cliente cliente= distribuidora.getListaClientes().get(i); // guardo el cliente de primer sub indice

            for (j=0; j<distribuidora.getListaEnvios().size();j++){
                if (cliente.equals(distribuidora.getListaEnvios().get(j).getClienteEnvio()) ){ // lo comparo con el cliente de la lista de envios
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

        System.out.println("Cliente con mayor cantidad de compras es: "+ distribuidora.getListaClientes().get(indice));
        System.out.println("con un total de ventas igual a :"+contador );
    }

}
