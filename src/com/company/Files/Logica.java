package com.company.Files;

import com.company.Files.Cola.Cola;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Logica {

    private static Scanner input = new Scanner(System.in);

    //Caja cajasrep = new Caja();

    //ArrayList<Integer> prioridad = new ArrayList<>();
    //ArrayList<Integer> noprioridad = new ArrayList<>();

    ArrayList<Persona> listaPersonas = new ArrayList<>();

    Queue<Persona> prioridad = new LinkedList<>();
    Queue<Persona> noprioridad = new LinkedList<>();

    //arreglar a dinamico
    Caja[] cajas;

    Cola colaprioridad = new Cola();
    Cola colanoprioridad = new Cola();


    int simulationTime = 0;

    private void procesoDeColasTiempo(int cantidadDeCajas){

        for(int  i = 0; i < cantidadDeCajas; i++){


            if(cajas[i].estaocupada()){

                if(cajas[i].persona.tiempoTranscurridoEnTramite == cajas[i].persona.tiempoTramite){
                    cajas[i].persona = null;
                }else{
                    cajas[i].persona.tiempoTranscurridoEnTramite++;
                }

            }


        }
    }

    private void procesoDeColasDos(int cantidadDeCajas){

        //Crear en estructura de cola propia un metodod que devuelva si esta vacia
        if(!prioridad.isEmpty()){

            for(int  i = 0; i < cantidadDeCajas; i++) {

                if (!cajas[i].estaocupada()) {
                    cajas[i].persona = prioridad.poll();
                    if(cajas[i].persona != null){
                        cajas[i].persona.isInCaja = true;
                    }

                }
            }
        }
        if(!noprioridad.isEmpty()) {

            for (int i = 0; i < cantidadDeCajas; i++) {

                if (!cajas[i].estaocupada()) {
                    cajas[i].persona = noprioridad.poll();
                    cajas[i].persona.isInCaja = true;
                }

            }
        }
    }

    private void procesoDeColasTres(){
        if(prioridad != null){

            Queue<Persona> prioridadTemp = new LinkedList<>();

            for(int i = 0; i < prioridad.size();i++){
                prioridad.peek().tiempoCola++;
                prioridadTemp.add(prioridad.poll());
            }

            prioridad = prioridadTemp;

        }
        if(noprioridad != null){

            Queue<Persona> prioridadTemp = new LinkedList<>();

            for(int i = 0; i < noprioridad.size();i++){
                noprioridad.peek().tiempoCola++;
                prioridadTemp.add(noprioridad.poll());
            }

            noprioridad = prioridadTemp;

        }

    }

    public void Data(int cantidadCajas) {

        cajas = new Caja[cantidadCajas];
        cajas[0] = new Caja(false);
        cajas[1] = new Caja(false);

        //Esta ejeciucion es por minuto
        try {
            Scanner lector = new Scanner(new File("C:\\Users\\taera\\IdeaProjects\\ProyectoFinalEstructurasdeDatos\\src\\com\\company\\Files\\SimulationFIle.txt"));
            while (lector.hasNextLine()) {
                String[] Personas = lector.nextLine().split(",");

                Persona persona;

               //Primer proceso
                procesoDeColasTiempo(cantidadCajas);
                //Segundo proceso
                procesoDeColasDos(cantidadCajas);
                //Tercer proceso
                procesoDeColasTres();

                for(int i = 0; i < Integer.parseInt(Personas[1]); i++){
                    persona = new Persona();
                    listaPersonas.add(persona);

                    for(int e = 0; e < cantidadCajas; e++){

                        if(!cajas[e].estaocupada()){
                            cajas[e].persona = persona;
                            persona.isInCaja = true;
                            //break;
                        }else{
                            prioridad.add(persona);
                        }

                    }

                }

                for(int i = 0; i < Integer.parseInt(Personas[0]); i++){
                    persona = new Persona();
                    listaPersonas.add(persona);

                    for(int e = 0; e < cantidadCajas; e++){

                        if(!cajas[e].estaocupada()){
                            cajas[e].persona = persona;
                            persona.isInCaja = true;
                            //break;
                        }else{
                            noprioridad.add(persona);
                        }

                    }

                }


                //noprioridad.add(Integer.parseInt(Personas[0]));
                //prioridad.add(Integer.parseInt(Personas[1]));


            }
            lector.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void personasencola() {


        }
      /*
    public void ocuparcaja() {
        for (int i = 0; i < cajas.length; i++) {

            if (cajasrep.estaocupada() == null) {
                if (!colaprioridad.estaVacia()) {
                    Persona persona = colaprioridad.quitar();
                }
            }


        }
    }*/

    public void obtenerTiempoPromedio(){

        int promedio;
        int contadorTiempos  = 0;

        for(int  i =0; i < listaPersonas.size(); i++){

            contadorTiempos += listaPersonas.get(i).tiempoCola;

        }

        System.out.println("Promedio de colas: " + contadorTiempos/listaPersonas.size());


    }

}



