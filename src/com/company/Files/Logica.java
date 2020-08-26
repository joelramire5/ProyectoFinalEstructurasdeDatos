package com.company.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Logica {

    private static Scanner input = new Scanner(System.in);


    ArrayList<Persona> listaPersonas = new ArrayList<>();

    Queue<Persona> prioridad = new LinkedList<>();
    Queue<Persona> noprioridad = new LinkedList<>();


    Caja[] cajas;
    int tiempoTramiteTotal=0;
    int personaAtendidas=0;


    private void procesoDeColasUno(int cantidadDeCajas){

        for(int  i = 0; i < cantidadDeCajas; i++){

            if(cajas[i].estaocupada()){

                System.out.println("La persona en la caja " + i + " es la persona id: " + cajas[i].persona.id);

                if(cajas[i].persona.tiempoTranscurridoEnTramite == cajas[i].persona.tiempoTramite){
                    tiempoTramiteTotal = tiempoTramiteTotal+cajas[i].persona.tiempoTramite;
                    personaAtendidas++;

                    cajas[i].persona.isInCaja = false;
                    cajas[i].persona.tramiteTerminado = true;
                    System.out.println("Una persona id: " +cajas[i].persona.id + " ha terminado su tramite con un tiempo de:" + cajas[i].persona.tiempoTranscurridoEnTramite);
                    cajas[i].persona = null;

                }else{
                    cajas[i].persona.tiempoTranscurridoEnTramite++;
                    System.out.println("Se ha aumentado el tiempo de tramite de una persona id: " +cajas[i].persona.id + " con un tiempo tramite transcurrido: " +cajas[i].persona.tiempoTranscurridoEnTramite );
                }
            }
        }
    }

    private void procesoDeColasDos(int cantidadDeCajas){


        if(!prioridad.isEmpty()){

            for(int  i = 0; i < cantidadDeCajas; i++) {

                if (!cajas[i].estaocupada()) {
                    System.out.println("Se ha pasado una persona id: " + prioridad.peek().id + " de prioridad a una caja");
                    Persona persona=prioridad.poll();
                    persona.generarTiempo();
                    cajas[i].persona = persona;
                    if(cajas[i].persona != null){
                        cajas[i].persona.isInCaja = true;
                    }
                    break;
                }
            }
        }
        if(!noprioridad.isEmpty()) {

            for (int i = 0; i < cantidadDeCajas; i++) {

                if (!cajas[i].estaocupada()) {
                    System.out.println("Se ha pasado una persona id: " + noprioridad.peek().id + " de no prioridad a una caja");
                    Persona persona=noprioridad.poll();
                    persona.generarTiempo();
                    cajas[i].persona = persona;
                    cajas[i].persona.isInCaja = true;
                }
            }
        }
    }


    private void procesoDeColasTres(){
        if(prioridad != null){

            Queue<Persona> prioridadTemp = new LinkedList<>();

            while(!prioridad.isEmpty()){
                if(prioridad.peek() != null){
                    prioridad.peek().tiempoCola++;
                    System.out.println("Se ha incrementado el tiempo en cola de una persona id: " + prioridad.peek().id + " de prioridad con un tiempo en cola total: " + prioridad.peek().tiempoCola);
                    prioridadTemp.add(prioridad.poll());
                }
            }

            prioridad = prioridadTemp;

        }
        if(noprioridad != null){

            Queue<Persona> prioridadTemp = new LinkedList<>();

            while(!noprioridad.isEmpty()){
                if(noprioridad.peek() != null){
                    noprioridad.peek().tiempoCola++;
                    System.out.println("Se ha incrementado el tiempo en cola de una persona id: " + noprioridad.peek().id + " de no prioridad con un tiempo en cola total: " + noprioridad.peek().tiempoCola);
                    prioridadTemp.add(noprioridad.poll());
                }
            }
            noprioridad = prioridadTemp;

        }

    }

    private void procesoDeColasCuatro(String []Personas, int cantidadCajas){
        Persona persona;

        for(int i = 0; i < Integer.parseInt(Personas[1]); i++){
            persona = new Persona();
            listaPersonas.add(persona);
            boolean agregadoCaja = false;

            for(int e = 0; e < cantidadCajas; e++){

                if(!cajas[e].estaocupada()){
                    cajas[e].persona = persona;
                    persona.isInCaja = true;
                    agregadoCaja = true;
                    System.out.println("Se ha agregado una persona id:" + persona.id+  " de prioridad nueva a la caja " + e + " con un tiempo de tramite de: " + persona.tiempoTramite);

                    break;
                }
            }

            if(!agregadoCaja){
                prioridad.add(persona);
                System.out.println("Se ha agregado una persona id:" + persona.id+  " de prioridad nueva a la cola con un tiempo de tramite de: " + persona.tiempoTramite);

            }

        }

        for(int i = 0; i < Integer.parseInt(Personas[0]); i++){
            persona = new Persona();
            listaPersonas.add(persona);
            boolean agregadoCaja = false;

            for(int e = 0; e < cantidadCajas; e++){

                if(!cajas[e].estaocupada()){
                    cajas[e].persona = persona;
                    persona.isInCaja = true;
                    agregadoCaja = true;
                    System.out.println("Se ha agregado una persona id:" + persona.id +  " de no prioridad nueva a la caja " + e + " con un tiempo de tramite de: " + persona.tiempoTramite);

                    break;
                }
            }

            if(!agregadoCaja){
                noprioridad.add(persona);
                System.out.println("Se ha agregado una persona id:" + persona.id +  " de no prioridad nueva a la cola con un tiempo de tramite de: " + persona.tiempoTramite);

            }

        }
    }

    private void initCajas(int cantidadCajas){
        cajas = new Caja[cantidadCajas];
        for(int  i = 0; i < cantidadCajas; i++){
            cajas[i] = new Caja(false);
        }
    }

    public void Data(int cantidadCajas) {

        initCajas(cantidadCajas);


        try {
            int contador = 1;
            Scanner lector = new Scanner(new File("C:\\Users\\taera\\IdeaProjects\\ProyectoFinalEstructurasdeDatos\\src\\com\\company\\Files\\SimulationFIle.txt"));
            while (lector.hasNextLine()) {
                String[] Personas = lector.nextLine().split(",");

                Persona persona;

                System.out.println("\n\nMinuto " + contador + "\n\n");
                contador++;

                //Primer proceso
                procesoDeColasUno(cantidadCajas);
                //Segundo proceso
                procesoDeColasDos(cantidadCajas);
                //Tercer proceso
                procesoDeColasTres();
                //Cuarto proceoso
                procesoDeColasCuatro(Personas, cantidadCajas);


            }
            lector.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void personasencola() {


    }


    public void obtenerTiempoPromedioColas(){

        int contadorTiempos  = 0;

        for(int  i =0; i < listaPersonas.size(); i++){

            contadorTiempos += listaPersonas.get(i).tiempoCola;

        }
        System.out.println(" Tiempo Promedio de Espera en colas: " + contadorTiempos/listaPersonas.size());
    }
    public void obtenerTiempoPromedioTramites(){


        System.out.println("Promedio de tramites: " +tiempoTramiteTotal/personaAtendidas);
    }

    public void obtenerTiempoPromedioTotal(){


        int contadorTiempos  = 0;

        for(int  i =0; i < listaPersonas.size(); i++){

            contadorTiempos += listaPersonas.get(i).tiempoTranscurridoEnTramite + listaPersonas.get(i).tiempoCola;
            //System.out.println(listaPersonas.get(i).tiempoTranscurridoEnTramite);

        }
        System.out.println("Promedio de tiempo total: " + contadorTiempos/listaPersonas.size());
    }

    public void obtenerPersonasenColaYPromedio(){


        int contadorTiempos  = 0;
        int contadorPersonasCola = 0;

        for(int  i =0; i < listaPersonas.size(); i++){

            if(!listaPersonas.get(i).tramiteTerminado){
                contadorPersonasCola++;
                contadorTiempos += listaPersonas.get(i).tiempoCola;
            }
        }
        System.out.println("Personas que se quedaron en cola: " + contadorPersonasCola + ", promedio de tiempo total en cola: " + contadorTiempos/contadorPersonasCola);
    }


}


