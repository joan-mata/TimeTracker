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
                    Proyecto p2 = new Proyecto("p2", root);
                    
                    System.out.println("CAMBIO P1-P2\n");
                    
                    System.out.println("\nP1\n");
                    System.out.println("\nP2\n");
                    
                    
                    
                    
                    
                    
                    
                    
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


