package com.company.Files.Interfaz;

import com.company.Files.Logica;

import java.util.Scanner;

public class Interfaz {
    private static Scanner input = new Scanner(System.in);
    private static int option = 0;
    Logica L = new Logica();



    public void menuPrincipal() {




        System.out.println("------------------------------------------------------");
        System.out.println("Presione la opcion que desea realizar: ");
        System.out.println("1. 1 cola o 2 colas");
        System.out.println("2.Ingresar numero de cajas");
        System.out.println("3.Cajera en entrenmiento");
        System.out.println("4.Salir");
        System.out.println("------------------------------------------------------------");

        do {

            switch (option) {
                case 1:
                    //L.NumeroDeColas();
                    break;
                case 2:
                    //L.NumeroDeCajas();
                    break;
                case 3:
                    //L.TipoDeCajero();
                    break;
                case 4:
                    System.out.println("Ha salido dem4 la simulacion");
                    break;

            }
            if (option != 1 && option != 2) {
                System.out.println("Opcion no valida");
            }
        }
        while (option != 1 && option != 2) ;

    }

}

