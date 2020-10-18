package TimeTracker;

import java.lang.*;

public class Proyecto extends Actividad{
    private String p_nombre;
    private Proyecto p_proyecto_superior;
    private String p_fecha_inicial;
    private String p_fecha_final;
    private int p_tiempo_total;
    
    public Proyecto(String name, Proyecto p){ //constructor
        this.p_nombre = name;
        //p_proyecto_superior = p;
        this.p_fecha_inicial = "";
        this.p_fecha_final = "";
        this.p_tiempo_total = 0;
    }
    
    public Proyecto(Proyecto p){ //constructor copia
        this.p_nombre = ;
        this.p_proyecto_superior = ;
        this.p_fecha_inicial = ;
        this.p_fecha_final = ;
        this.p_tiempo_total = ;
    }
    
    //getters
    public String get_nombre(){
        return this.p_nombre;
    }
    
    public Proyecto get_proyecto(){
        
    }
    
    public String get_fecha_inicial(){
        return this.p_fecha_inicial;
    }
    
    public String get_fecha_final(){
        return this.p_fecha_final;
    }
    
    public int get_tiempo_total(){ //podría calcular el tiempo también
        return this.p_tiempo_total;
    }
    
    //setters
    public void set_nombre(String name){
        this.p_nombre = name;
    }
    
    public void set_proyecto(Proyecto p){
        this.p_proyecto_superior = p;
    }

    public void set_fecha_inicial(String start){
        this.p_fecha_inicial = start;
    }
    
    public void set_fecha_final(String finish){
        this.p_fecha_final = finish;
    }
    
    public void set_tiempo_total(int time){ //¿necesaria?
        this.p_tiempo_total = time;
    }
    
    
    //funciones
    public void añadir(Actividad Activity){}
    public void eliminar(Actividad Activity){}
    public void getChild(){}
    public void empezar(){}
    public void detener(){}
}
