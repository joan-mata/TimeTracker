package TimeTracker;

import java.lang.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Actividad{
    private String a_ID;
    private String a_nombre;
    private Proyecto a_proyecto;
    private String a_fecha_inicial;   
    private String a_fecha_final;
    private int a_tiempo_total;
    private Reloj a_reloj;

    public Actividad(String name, Proyecto p1){ //contructor
        
        LocalDateTime myDateObj = LocalDateTime.now(); //cogemos fecha y hora de la creacion de la actividad
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"); //cambiamos formato
        this.a_ID = myDateObj.format(myFormatObj); //ID es la dehca y la hora cambaida el fomato
        
        this.a_nombre = name;
        //this.a_proyecto = p1;
        this.a_fecha_inicial = "";
        this.a_fecha_final = "";
        this.a_tiempo_total = 0;
        
        //System.out.println(a_ID + ", " + a_nombre);
    }
    
    //getters
    public String get_ID(){ //get_ID(this)
        return this.a_ID;
    }
    
    public String get_nombre(){
        return this.a_nombre;
    }
    
    public Proyecto get_proyecto(){
        
    }
    
    public String get_fecha_inicial(){
        return this.a_fecha_inicial;
    }
    
    public String get_fecha_final(){
        return this.a_fecha_final;
    }
    
    public int get_tiempo_total(){ //podría calcular el tiempo también
        return this.a_tiempo_total;
    }
    
    //setters
    public void set_ID(String ID){
        this.a_ID = ID;
    }
    
    public void set_nombre(String name){
        this.a_nombre = name;
    }
    
    public void set_proyecto(Proyecto p){
        this.a_proyecto = p;
    }

    public void set_fecha_inicial(String start){
        this.a_fecha_inicial = start;
    }
    
    public void set_fecha_final(String finish){
        this.a_fecha_final = finish;
    }
    
    public void set_tiempo_total(int time){ //¿necesaria?
        this.a_tiempo_total = time;
    }
    
    //crear() == contructor ¿no?
    
    public void actualizar(String ID, String name, String start){
        set_ID(ID);
        set_nombre(name);
        set_fecha_inicial(start);
    }
    
    public void Start(){ //iniciar la tarea
        a_reloj.start(); //inciamos el crono
        System.out.println("\nHemos inicado la actividad");
    }
    
    public void Stop(){ //finalizamos la tarea
        //a_reloj.notify(); //paramos el crono
        System.out.println("Hemos finalizado la actividad");
    }
}
