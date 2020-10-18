package TimeTracker;

import java.lang.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Actividad {
    private String a_ID;
    private String a_nombre;
    private Proyecto a_proyecto;
    private String a_fecha_inicial;   
    private String a_fecha_final;
    private int a_tiempo_total;
    private Reloj a_reloj;

    public Actividad(String name, Proyecto p){ //contructor
        
        LocalDateTime myDateObj = LocalDateTime.now(); //cogemos fecha y hora de la creacion de la actividad
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"); //cambiamos formato
        this.a_ID = myDateObj.format(myFormatObj); //ID es la dehca y la hora cambaida el fomato
        
        this.a_nombre = name;
        this.a_proyecto = new Proyecto(p);
        this.a_fecha_inicial = "";
        this.a_fecha_final = "";
        this.a_tiempo_total = 0;
    }
    
    //getters
    public String get_ID(){ //get_ID(this)
        return this.a_ID;
    }
    
    public String get_nombre(){
        return this.a_nombre;
    }
    
    public Proyecto get_proyecto(){
        return this.a_proyecto;
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
        this.a_proyecto.set_nombre(p.get_nombre());
        this.a_proyecto.set_proyecto(p.get_proyecto());
        this.a_proyecto.set_fecha_inicial(p.get_fecha_inicial());
        this.a_proyecto.set_fecha_final(p.get_fecha_final());
        this.a_proyecto.set_tiempo_total(p.get_tiempo_total());
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
    
    public void set_completo(String name, Proyecto p, String initial, String end, int time){
        this.set_nombre(name);
        this.set_proyecto(p);
        this.set_fecha_inicial(initial);
        this.set_fecha_final(end);
        this.set_tiempo_total(time);
    }
    
    public void modificar_actividad(Actividad a){
        //Cambiamos toda la info menos el nombre
        this.a_fecha_inicial = a.get_fecha_inicial();
        this.a_fecha_final = a.get_fecha_final();
        this.a_tiempo_total = a.get_tiempo_total();
        this.a_proyecto = a.get_proyecto();
    }
    
    //Funciones
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
    
    //FUNCIONES PRUEBAS
    public void comprueba_getters(){
        System.out.println("Nombre: " + this.get_nombre() + "\n");
        System.out.println("Proyecto Superior: " + this.get_proyecto() + "\n");
        System.out.println("F. Inicio: " + this.get_fecha_inicial() + "\n");
        System.out.println("F. Final: " + this.get_fecha_final() + "\n");
        System.out.println("T. Total: " + this.get_tiempo_total() + "\n");
    }

    public void comprueba_setters(String name, Proyecto p, String initial, String end, int time){
        this.set_nombre(name);
        this.set_proyecto(p);
        this.set_fecha_inicial(initial);
        this.set_fecha_final(end);
        this.set_tiempo_total(time);

        comprueba_getters();
    }
}
