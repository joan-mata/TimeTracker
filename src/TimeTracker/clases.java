//package TimeTracker;

import java.util.Timer;
import java.util.TimerTask;


public class Actividad{
    private String a_ID;
    private String a_nombre;
    private String a_fecha_inicial;   
    private String a_fecha_final;
    private int a_tiempo_total;

    constructor(this, ID, name, start){
        a_ID = ID;
        a_nombre = name;
        a_fecha_inicial = start;
        a_fecha_final = 0;
        a_tiempo_total = 0;
    }
    
    //calcular_tiempo_total(){} = get_tiempo_total()

    //getters
    public String get_ID(){ //get ID(this)
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
    public void set_ID(ID){
        a_ID = ID;
    }
    
    public void set_nombre(name){
        a_nombre = name;
    }
    
    public void set_fecha_inicial(start){
        a_fecha_inicial = start;
    }
    
    public void set_fecha_final(finish){
        a_fecha_final = finish;
    }
    
    public void set_tiempo_total(time){ //¿necesaria?
        a_tiempo_total = time;
    }
    
    //crear() == contructor ¿no?
    
    void actualizar(ID, name, start){
        set_ID(ID);
        set_nombre(name);
        set_fecha_inicial(start);
    }
    
    /*Proyecto.añadir().call(this, actividad){
        añadir(actividad);
    }*/

    void eliminar(actividad);
    void getChild();
    void inicio();
    void detener()
    
}

public class Proyecto extends Actividad{
    public Proyecto(){}
    
    void añadir(Actividad){}
    void eliminar(Actividad){}
    void getChild(){}
    void inicio(){}
    void detener(){}
}

public class Tarea extends Actividad{
    public Tarea(){}
    
    void inicio(){}
    void fin(){}
    
}

public class Intervalo extends Tarea{
    String i_ID;
    String i_inicio;
    String i_final;
    int i_tiempo;
    
    public Intervalo(){}
    
    //getters
    public String get_ID(){
        return i_ID;
    }
    
    public String get_inicio(){
        return i_inicio;
    }
    
    public String get_final(){
        return i_final;
    }
    
    public int get_tiempo(){ //podría calcular el tiempo también
        return i_tiempo;
    }
    
    //setters
    public void set_ID(ID){
        a_ID = ID;
    }
    
    public void set_inicio(start){
        i_inicio = start;
    }
    
    public void set_fecha_final(finish){
        i_final = finish;
    }
    
    public void set_tiempo(time){ //¿necesaria?
        i_tiempo = time;
    }
    
    void contar_tiempo(){}
    void actualizar(){}
}

public class Gestor{
    
    void crear(actividad){}
    void acabar(actividad){}
    void contar(actividad){}
}
