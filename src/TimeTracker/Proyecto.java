package TimeTracker;

import java.lang.*;
import Actividad.java;

public class Proyecto{ //extends Actividad ~Me da error ¿Porqué?~
    private String p_nombre;
    private Proyecto p_proyecto_superior;
    private String p_fecha_inicial;
    private String p_fecha_final;
    private int p_tiempo_total;
    
    private Actividad[] p_actividad;
    
    //Constructores
    public Proyecto(String name, Proyecto p){
        this.p_nombre = name;
        this.p_fecha_inicial = "";
        this.p_fecha_final = "";
        this.p_tiempo_total = 0;
        
        if(p != null){ //Tiene un proyecto superior
            this.p_proyecto_superior = new Proyecto(p);
        }
        else { //En este caso, el proyecto actual es el root
            this.p_proyecto_superior = null;
        }
    }
    
    public Proyecto(Proyecto p){ //constructor copia
        this.p_nombre = p.get_nombre();
        this.p_proyecto_superior = p.get_proyecto();
        this.p_fecha_inicial = p.get_fecha_inicial();
        this.p_fecha_final = p.get_fecha_final();
        this.p_tiempo_total = p.get_tiempo_total();
    }
    
    
    //getters
    public String get_nombre(){
        return this.p_nombre;
    }
    
    public Proyecto get_proyecto(){
        return p_proyecto_superior;
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
    
    public void set_proyecto(Proyecto p){ //Set Proyecto Superior
        if(p != null){ //Tiene un proyecto superior
            this.p_proyecto_superior = new Proyecto(p);
        }
        else { //En este caso, el proyecto actual es el root
            this.p_proyecto_superior = null;
        }
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
    
    public void set_completo(String name, Proyecto p, String initial, String end, int time){
        this.set_nombre(name);
        this.set_proyecto(p);
        this.set_fecha_inicial(initial);
        this.set_fecha_final(end);
        this.set_tiempo_total(time);
    }
    
    public void modificar_proyecto(Proyecto p){
        //Cambiamos toda la info menos el nombre
        this.p_fecha_inicial = p.get_fecha_inicial();
        this.p_fecha_final = p.get_fecha_final();
        this.p_tiempo_total = p.get_tiempo_total();
        this.p_proyecto_superior = p.get_proyecto();
    }
    
    //funciones
    public void añadir(Actividad Activity){}
    public void eliminar(Actividad Activity){}
    public void getChild(){}
    public void empezar(){}
    public void detener(){}
    
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
