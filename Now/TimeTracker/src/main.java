import java.io.IOException;
import java.lang.Thread;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.json.JSONObject;
import timetracker.*;

public class Main {
  private static Reloj Reloj;

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in); //Para introducir elementos por terminal

    System.out.println("¿Qué test quieres realizar? \n" + "(exit = -1)");
    int test = entrada.nextInt();

    Proyecto root = new Proyecto("Root", null);
    Proyecto softwareDesing = new Proyecto("Software design", root);
    Proyecto softwareTesting = new Proyecto("Software testing", root);
    Proyecto databases = new Proyecto("Databases", root);
    Proyecto problems = new Proyecto("Problems", softwareDesing);
    Proyecto projectTimeTracker = new Proyecto("Project time tracker", softwareDesing);

    Tarea transportation = new Tarea("transportation", root);
    Tarea firstList = new Tarea("first list", problems);
    Tarea secondList = new Tarea("second list", problems);
    Tarea readHandout = new Tarea("read handout", projectTimeTracker);
    Tarea firstMilestone = new Tarea("first milestone", projectTimeTracker);

    Thread time = new Thread(Reloj.getInstance());
    time.start();

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

          System.out.println("Start Test\n");
          System.out.println("Transportation starts:\n");
          transportation.start();
          sleep(4);
          transportation.stop();
          System.out.println("Transportation stop\n");
          sleep(2);
          System.out.println("First list starts\n");
          firstList.start();
          sleep(6);
          System.out.println("Second list start\n");
          secondList.start();
          sleep(4);
          firstList.stop();
          System.out.println("First list stop\n");
          sleep(2);
          secondList.stop();
          System.out.println("Second list stop\n");
          sleep(2);
          System.out.println("Transportation starts\n");
          transportation.start();
          sleep(4);
          transportation.stop();
          System.out.println("Transportation stop\n");

          JSONObject json = root.getJson();
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


