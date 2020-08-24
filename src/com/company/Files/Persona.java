package com.company.Files;

public class Persona {

    int tiempoTranscurridoEnTramite;
    int tiempoTramite;
    int tiempoCola;
    boolean isInCaja;


    public Persona(){
        tiempoTranscurridoEnTramite = 0;
        generarTiempo();
        tiempoCola = 0;
        isInCaja = false;
    }

    public void generarTiempo() {
        double tiempoEnCajas = Math.random();

        if (tiempoEnCajas >= 0 && tiempoEnCajas <= 0.30) {
            tiempoTramite = 1;
        } else if (tiempoEnCajas >= 0.20 && tiempoEnCajas <= 0.4) {
            tiempoTramite = 2;
        } else if (tiempoEnCajas >= 0.4 && tiempoEnCajas <= 0.6) {
            tiempoTramite = 3;
        } else if (tiempoEnCajas >= 0.6 && tiempoEnCajas <= 0.8) {
            tiempoTramite = 5;
        } else if (tiempoEnCajas >= 0.8 && tiempoEnCajas <= 0.9) {
            tiempoTramite = 8;
        } else if (tiempoEnCajas >= 0.9 && tiempoEnCajas <= 0.95) {
            tiempoTramite = 13;
        }
        tiempoTramite = (int) (13 + (13 * Math.random()));
    }

    public int getTiempoTramite() {
        return tiempoTramite;
    }

    public void setTiempoTramite(int tiempoTramite) {
        this.tiempoTramite = tiempoTramite;
    }

    public int getTiempoCola() {
        return tiempoCola;
    }

    public void setTiempoCola(int tiempoCola) {
        this.tiempoCola = tiempoCola;
    }
}
