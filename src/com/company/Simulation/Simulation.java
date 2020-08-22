package com.company.Simulation;

import com.company.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {

    private ServiceArea servicearea;

    public void Data() {
        try {
            Scanner lector = new Scanner(new File("C:\\Users\\taera\\IdeaProjects\\ProyectoFinalEstructurasdeDatos\\src\\com\\company\\Files\\SimulationFIle.txt"));
            int simulationTime = 0;
            while (lector.hasNextLine()) {
                String[] colapersonas = lector.nextLine().split(",");
                servicearea.insertPersonP(colapersonas[0]);


            }
            lector.close();
            System.out.println("Se han cargado" + simulationTime +"time");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

}
