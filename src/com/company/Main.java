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


       distribuidoraUnica.imprimirProductos();
       distribuidoraUnica.imprimirClientes();

        //cargo envios

        distribuidoraUnica.realizarUnEnvio("Lucia","Cubetera",11);
        distribuidoraUnica.realizarUnEnvio("Jose","Billetera",15);
        distribuidoraUnica.realizarUnEnvio("Lucia","Billetera",65);
        distribuidoraUnica.realizarUnEnvio("Lucia","Llavero",112);
        distribuidoraUnica.realizarUnEnvio("Jose","Destapador",44);
        distribuidoraUnica.realizarUnEnvio("Jose","Destapador",28);
        distribuidoraUnica.realizarUnEnvio("Jose","Llavero",77);

        distribuidoraUnica.imprimirEnvios();
        distribuidoraUnica.imprimirProductos();

        System.out.println("el promedio total de vendidos es: "+ distribuidoraUnica.promedioDeTotalVendido());
        distribuidoraUnica.imprimirClienteConMasCompras();

    }








}
