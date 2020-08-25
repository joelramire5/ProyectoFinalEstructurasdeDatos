package com.company.Files.Interfaz;

import com.company.Files.Logica;

import java.util.Scanner;

public class Interfaz {
    private static Scanner input = new Scanner(System.in);
    Logica L = new Logica();
    int cantidaddecajas;


    public void menuPrincipal() {


        System.out.println("------- Bienvenido al simulador de colas de espera del Banco Caliche ------");
        System.out.println("--------------------------------------------------");
        System.out.println("Seleccione el numero de cajas que desea ingresar: ");
        cantidaddecajas=input.nextInt();
        L.Data(cantidaddecajas);
        L.obtenerTiempoPromedioColas();
        L.obtenerTiempoPromedioTramites();
        L.obtenerTiempoPromedioTotal();
        L.obtenerPersonasenColaYPromedio();






    }


}

