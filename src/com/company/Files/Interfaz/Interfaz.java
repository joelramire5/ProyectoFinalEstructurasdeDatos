package com.company.Files.Interfaz;

import com.company.Files.Logica;

import java.util.Scanner;

public class Interfaz {
    private static Scanner input = new Scanner(System.in);
    private static int option = 0;
    Logica L = new Logica();



    public void menuPrincipal() {


        System.out.println("------- Bienvenido al simulador de colas de espera del Banco Caliche ------");
        System.out.println("--------------------------------------------------");
        System.out.println("Seleccione el numero de cajas que desea ingresar: ");
        L.Data(this.CantidaddeCajas());
        L.obtenerTiempoPromedioColas();
        L.obtenerTiempoPromedioTramites();
        L.obtenerTiempoPromedioTotal();
        L.obtenerPersonasenColaYPromedio();






    }

    public int CantidaddeCajas(){
        System.out.println("Ingrese la Cantidad de Cajas");

        return input.nextInt();
    }

}

