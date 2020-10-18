/* NOTAS

No consigo unir toods los archivos como un solo pryecto


*/

import TimeTracker.*;

import java.util.Scanner;
import java.lang.*;

//import classes.java;


public class main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in); //Para introducir elementos por terminal

        System.out.println("¿Qué test quieres realizar? \n" + "(exit = -1)");
        int test = entrada.nextInt();
        
        while(test != -1){
            switch (test) {
                case 0: //Utilizado para probar el programa y sus elementos
                    System.out.println("Test de pruebas.");
                    // ******** ESCRIBIR CODIGO PARA PRUEBAS AQUÍ ******** \\
                    
                    //Agregar i crear reloj
                    
                    //Crear proyectos y actividades
                    Proyecto root = new Proyecto("root", null);
                    Proyecto p1 = new Proyecto("p1", root);
                    Actividad act1 = new Actividad("act1", root);
                    Actividad act2 = new Actividad("act2", p1);
                    Actividad act3 = new Actividad("act3", p1);
                    
                    System.out.println("\nACT1\n");
                    act1.set_completo("ACT1", p1, "Ayer-13", "24-Enero", 11);
                    act1.comprueba_getters();
                    
                    System.out.println("\nACT2\n");
                    act2.set_completo("ACT2", p1, "Hoy-26", "35-Mayo", 24);
                    act2.comprueba_getters();
                    
                    System.out.println("\nACT3\n");
                    act3.set_completo("ACT3", p1, "Mañana-43", "15-Julio", 38);
                    act3.comprueba_getters();
                    
                    System.out.println("\nCAMBIO ACT1 por ACT2\n");
                    act1.modificar_actividad(act2);
                    act1.comprueba_getters();
                    
                    System.out.println("\nCAMBIO ACT2 por ACT3\n");
                    act2.modificar_actividad(act3);
                    act2.comprueba_getters();
                    
                    
                    
                    
                    //act1.Start();
                    //System.out.println("Antes de espera");
                    //Thread.sleep(2000);
                    //System.out.println("Despues de espera");
                    //activity.Stop();
                    
                    // ******** ESCRIBIR CODIGO PARA PRUEBAS HASTA AQUÍ ******** \\
                    break;
                
                case 1: //Milestone 1
                    System.out.println("Test 1.");



                    break;
                
                case 2: //Milestone 2
                    System.out.println("Test 2.");



                    break;
                
                case 3: //Milestone 3
                    System.out.println("Test 3.");



                    break;
                
                default: //Cualquier otro número, no hay test
                    System.out.println("Test no disponible.");
                    break;
            }

            System.out.println("¿Otro test?\n" + "(exit = -1)");
            test = entrada.nextInt();

        }
        


    }
}


