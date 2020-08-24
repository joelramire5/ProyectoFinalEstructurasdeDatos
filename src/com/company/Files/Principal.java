package com.company.Files;

public class Principal {

    public static void main(String[] args) {

        Logica L = new Logica();

        L.Data(8);
        L.obtenerTiempoPromedioColas();
        L.obtenerTiempoPromedioTramites();
        L.obtenerTiempoPromedioTotal();
        L.obtenerPersonasenColaYPromedio();

    }
}
