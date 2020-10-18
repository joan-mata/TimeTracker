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
                    Proyecto root = new Proyecto("Root", null);
                    Proyecto p1 = new Proyecto("p1", root);

                    Tarea t1 = new Tarea("t1");
                
                    //t1.start();
                    //wait(12);
                    //t2.stop();
                    
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


