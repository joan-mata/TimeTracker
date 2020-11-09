import TimeTracker.*;

import TimeTracker.Reloj;
import org.json.*;
import java.lang.Thread;
import java.util.Scanner;
import java.lang.Object;
import java.lang.Exception;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

//import classes.java;

public class main {
  private static Reloj m1Reloj;

  /*Función que realiza el código*/
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in); //Para introducir elementos por terminal
    Scanner entrada2 = new Scanner(System.in); //Para introducir elementos por terminal


    System.out.println("¿Qué test quieres realizar? \n" + "(exit = -1)");
    int test = entrada.nextInt();


    while (test != -1) {
      switch (test) {
        case 0: //Utilizado para probar el programa y sus elementos
          System.out.printf("\n%-20s%-20s%-20s\n", "", "", "TEST DE PRUEBAS");
          // ******** ESCRIBIR CODIGO PARA PRUEBAS AQUÍ ******** \\


          // ******** ESCRIBIR CODIGO PARA PRUEBAS HASTA AQUÍ ******** \\
          break;

        case 1: //Milestone 1
          System.out.printf("\n%-20s%-20s%-20s\n", "", "", "MILESTONE 1");

          System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "", "",
              "Fecha Inicial", "", "Fecha Final", "", "Duración");

          Thread time = new Thread(m1Reloj.getInstance());
          time.start();

          Proyecto m1PRoot = new Proyecto("Root", null);
          Proyecto m1PSoftwareDesing = new Proyecto("Software design", m1PRoot);
          Proyecto m1PSoftwareTesting = new Proyecto("Software testing", m1PRoot);
          Proyecto m1PDatabases = new Proyecto("Databases", m1PRoot);
          Proyecto m1PProblems = new Proyecto("Problems", m1PSoftwareDesing);
          Proyecto m1PProjectTimeTracker = new Proyecto("Project time tracker", m1PSoftwareDesing);

          Tarea m1TTransportation = new Tarea("transportation", m1PRoot);
          Tarea m1TFirstList = new Tarea("first list", m1PProblems);
          Tarea m1TSecondList = new Tarea("second list", m1PProblems);
          Tarea m1TReadHandout = new Tarea("read handout", m1PProjectTimeTracker);
          Tarea m1TFirstMilestone = new Tarea("first milestone", m1PProjectTimeTracker);

          System.out.println("Start Test\n");
          System.out.println("Transportation starts:\n");
          //CODIGO
          m1TTransportation.start();
          sleep(4);
          m1TTransportation.stop();
          System.out.println("Transportation stop\n");
          sleep(2);
          System.out.println("First list starts\n");
          m1TFirstList.start();
          sleep(6);
          System.out.println("Second list start\n");
          m1TSecondList.start();
          sleep(4);
          m1TFirstList.stop();
          System.out.println("First list stop\n");
          sleep(2);
          m1TSecondList.stop();
          System.out.println("Second list stop\n");
          sleep(2);
          System.out.println("Transportation starts\n");
          m1TTransportation.start();
          sleep(4);
          m1TTransportation.stop();
          System.out.println("Transportation stop\n");

          JSONObject json = m1PRoot.getJSON();
          String jsonString = json.toString();
          Path path = Paths.get("json.txt");
          try {
              Files.writeString(path, jsonString, StandardCharsets.UTF_8);
          } catch (IOException e) {
            e.printStackTrace();
          }
        
          System.out.println("End of test\n");


          break;

        case 2: //Milestone 2
          System.out.printf("\n%-20s%-20s%-20s\n", "", "", "MILESTONE 2");


          break;

        case 3: //Milestone 3
          System.out.printf("\n%-20s%-20s%-20s\n", "", "", "MILESTONE 3");


          break;

        default: //Cualquier otro número, no hay test
          System.out.println("Test no disponible.\n");
          break;
      }

      System.out.println("¿Otro test?\n" + "(exit = -1)");
      test = entrada.nextInt();
    }
  }

  public static void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}


