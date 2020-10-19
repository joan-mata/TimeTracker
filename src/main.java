import TimeTracker.*;

import java.util.Scanner;
//import java.lang.*;
import java.lang.Thread;

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
                    Proyecto root_prueba = new Proyecto("Root", null);

                    Tarea t1 = new Tarea("t1");
                
                    t1.start();
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        //e.printStackTrace();
                        System.out.println(e);
                    }
                    t1.stop();
                    
                    // ******** ESCRIBIR CODIGO PARA PRUEBAS HASTA AQUÍ ******** \\
                    break;
                
                case 1: //Milestone 1
                    System.out.println("=> Milestone 1.");
                    
                    //Declaramos y creamos los proyectos y tareas que necesitaremos en este test
                    Proyecto m1_root = new Proyecto("Root", null);
                    Tarea m1_t_transportation = new Tarea("Transportation", m1_root);
                    Tarea m1_t_first_list = new Tarea("First list", m1_root);
                    Tarea m1_t_second_list = new Tarea("Second list", m1_root);
                    
                    System.out.println("Start Test");
                    System.out.println("Transportation starts:");
                    //CODIGO
                    //m1_t_transportation.start();
                    //continue...
                    try{
                        Thread.sleep(4000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }                    System.out.println("Transportation stops");
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }                    System.out.println("First list starts");
                    //Codigo
                    try{
                        Thread.sleep(6000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }                    System.out.println("Second list start");
                    try{
                        Thread.sleep(4000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }                    //Codigo
                    System.out.println("First list stops");
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    //Codigo
                    System.out.println("Second list stops");
                    try{
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }                    //Codigo
                    System.out.println("Transportation starts");
                    ///Codigo
                    try{
                        Thread.sleep(4000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("Transportation stops");
                    System.out.println("End of test");
                    
                    break;
                
                case 2: //Milestone 2
                    System.out.println("Milestone 2.");



                    break;
                
                case 3: //Milestone 3
                    System.out.println("Milestone 3.");



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


