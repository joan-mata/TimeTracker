import TimeTracker.*;

import java.util.Scanner;
//import java.lang.*;
import java.lang.Thread;

//import classes.java;


public class main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in); //Para introducir elementos por terminal
        Scanner entrada2 = new Scanner(System.in); //Para introducir elementos por terminal

        System.out.println("¿Qué test quieres realizar? \n" + "(exit = -1)");
        int test = entrada.nextInt();
        
        
        while(test != -1){
            switch (test) {
                case 0: //Utilizado para probar el programa y sus elementos
                    System.out.printf("\n%-20s%-20s%-20s\n", "", "", "TEST DE PRUEBAS");
                    // ******** ESCRIBIR CODIGO PARA PRUEBAS AQUÍ ******** \\
                    
                    //Agregar i crear reloj
                    Proyecto root_prueba = new Proyecto("Root", null);
                    Proyecto p_p1 = new Proyecto("P1", root_prueba);
                    Tarea t1 = new Tarea("t1", p_p1);

                
                    t1.start();
                    try{
                        Thread.sleep(4000);
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println(e);
                    }
                    t1.stop();

                    
                    // ******** ESCRIBIR CODIGO PARA PRUEBAS HASTA AQUÍ ******** \\
                    break;
                
                case 1: //Milestone 1
                    System.out.printf("\n%-20s%-20s%-20s\n", "", "", "MILESTONE 1");
                    
                    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "", "", "Fecha Inicial", "", "Fecha Final", "", "Duración");

                    //Declaramos y creamos los proyectos y tareas que necesitaremos en este test
                    /*Proyecto m1_apB_p_root = new Proyecto("Root", null);
                    Tarea m1_apB_t_transportation = new Tarea("Transportation", m1_apB_p_root);
                    Tarea m1_apB_t_first_list = new Tarea("First list", m1_apB_p_root);
                    Tarea m1_apB_t_second_list = new Tarea("Second list", m1_apB_p_root);*/

                    Proyecto m1_p_root = new Proyecto("Root", null);
                    Proyecto m1_p_software_desing = new Proyecto("Software design", m1_p_root);
                    Proyecto m1_p_software_testing = new Proyecto("Software testing", m1_p_root);
                    Proyecto m1_p_databases = new Proyecto("Databases", m1_p_root);
                    Proyecto m1_p_problems = new Proyecto("Problems", m1_p_software_desing);
                    Proyecto m1_p_project_time_tracker = new Proyecto("Project time tracker", m1_p_software_desing); 

                    Tarea m1_t_transportation = new Tarea("transportation", m1_p_root);
                    Tarea m1_t_first_list = new Tarea("first list", m1_p_problems);
                    Tarea m1_t_second_list = new Tarea("second list", m1_p_problems);
                    Tarea m1_t_read_handout = new Tarea("read handout", m1_p_project_time_tracker);
                    Tarea m1_t_first_milestone = new Tarea("first milestone", m1_p_project_time_tracker);
                    
                    System.out.println("Start Test\n");
                    System.out.println("Transportation starts:\n");
                    //CODIGO
                    m1_t_transportation.start();
                    sleep(6);
                    System.out.println("Transportation stop\n");
                    m1_t_transportation.stop();
                    sleep(2);
                    System.out.println("First list starts\n");
                    m1_t_first_list.start();
                    sleep(6);
                    System.out.println("Second list start\n");
                    m1_t_second_list.start();
                    sleep(4);
                    System.out.println("First list stop\n");
                    m1_t_first_list.stop();
                    sleep(2);
                    System.out.println("Second list stop\n");
                    m1_t_second_list.stop();
                    sleep(2);                    
                    System.out.println("Transportation starts\n");
                    m1_t_transportation.start();
                    sleep(4);
                    System.out.println("Transportation stop\n");
                    m1_t_transportation.stop();
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

    public static void sleep(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}


