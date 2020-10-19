package TimeTracker;

import java.lang.Object;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Actividad {
    private String a_nombre;
    private LocalDateTime a_fecha_inicial;   
    private LocalDateTime a_fecha_final;
    private LocalDateTime a_tiempo_total;
    private Reloj a_reloj;

    public Actividad(String name){ //contructor
        this.a_nombre = name;
        this.a_fecha_inicial = null;
        this.a_fecha_final = null;
        this.a_tiempo_total = null;
    }
    
    //getters
    public String get_nombre(){
        return this.a_nombre;
    }
    
    public LocalDateTime get_fecha_inicial(){
        return this.a_fecha_inicial;
    }
    
    public LocalDateTime get_fecha_final(){
        return this.a_fecha_final;
    }
    
    public LocalDateTime get_tiempo_total(){
        //Calculamos el tiempo utilizado
        int segundos_inicial = a_fecha_inicial.getSecond();
        this.a_tiempo_total = a_fecha_final.minusSeconds(segundos_inicial); //REVISAR QUE FUNCIONE CAMBIO DE INT A LONG

        return this.a_tiempo_total;
    }
    
    //setters
    public void set_nombre(String name){
        this.a_nombre = name;
    }


    public void set_fecha_inicial(LocalDateTime start){
        this.a_fecha_inicial = start;
    }
    
    public void set_fecha_final(LocalDateTime finish){
        this.a_fecha_final = finish;
    }
        
    //Funciones
    public void actualizar(String name, LocalDateTime start){ //REVISAR!!!!
        set_nombre(name);
        set_fecha_inicial(start);
    }
    
    public Reloj start(){ //iniciar la actividad => DEBE ESTAR EN TAREA
        Reloj time = a_reloj.getInstance(); //conseguimos la uniqueInstance
        time.start();
        time.Notify();
        System.out.println(a_reloj.getInstance());
        
        return time;
    }
    
    public void stop(){ //finalizamos la actividad
        //a_reloj.notify(); //paramos el crono
        System.out.println("Hemos finalizado la actividad");
    }
    
    public void a_mostrar(){
        System.out.println("%-20s%-20s%-20s%-20s%-20s", "Actividad:", a_nombre, a_fecha_inicial, a_fecha_final, a_tiempo_total);
    }
    
    //FUNCIONES PRUEBAS
    
}
