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
                    Tarea t1 = new Tarea("T1");
                    Tarea t2 = new Tarea("T2");
                    
                    System.out.println("T1\n");
                    t1.comprueba_getters();
                    t1.comprueba_setters("T1Prueba", "Hoy-26-Junio", "Ayer-35-Mayo", 24);

                    System.out.println("\nT2\n");
                    t2.comprueba_getters();
                    t2.comprueba_setters("T2Prueba", "Mañana-15-Enero", "Pasado-40-Diciembre", 35);

                    
                    
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


