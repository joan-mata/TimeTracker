package TimeTracker;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Actividad{
    private String a_ID;
    private String a_nombre;
    private String a_fecha_inicial;   
    private String a_fecha_final;
    private int a_tiempo_total;

    public Actividad(String name){ //contructor
        
        LocalDateTime myDateObj = LocalDateTime.now(); //cogemos fecha y hora de la creacion de la actividad
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"); //cambiamos formato
        a_ID = myDateObj.format(myFormatObj); //ID es la dehca y la hora cambaida el fomato
        
        a_nombre = name;
        a_fecha_inicial = "";
        a_fecha_final = "";
        a_tiempo_total = 0;
        
        //System.out.println(a_ID + ", " + a_nombre);
    }
    
    //getters
    public String get_ID(){ //get_ID(this)
        return a_ID;
    }
    
    public String get_nombre(){
        return a_nombre;
    }
    
    public String get_fecha_inicial(){
        return a_fecha_inicial;
    }
    
    public String get_fecha_final(){
        return a_fecha_final;
    }
    
    public int get_tiempo_total(){ //podría calcular el tiempo también
        return a_tiempo_total;
    }
    
    //setters
    public void set_ID(String ID){
        a_ID = ID;
    }
    
    public void set_nombre(String name){
        a_nombre = name;
    }
    
    public void set_fecha_inicial(String start){
        a_fecha_inicial = start;
    }
    
    public void set_fecha_final(String finish){
        a_fecha_final = finish;
    }
    
    public void set_tiempo_total(int time){ //¿necesaria?
        a_tiempo_total = time;
    }
    
    //crear() == contructor ¿no?
    
    public void actualizar(String ID, String name, String start){
        set_ID(ID);
        set_nombre(name);
        set_fecha_inicial(start);
    }
    
}
