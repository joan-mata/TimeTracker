package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Proyecto extends Actividad{ 
    private Proyecto p_proyecto_superior;
    private ArrayList<Tarea> p_tarea;

    //Constructores
    public Proyecto(String name, Proyecto p){
        super (name);
        
        if(p == null){  //En este caso, el proyecto actual es el root
            this.p_proyecto_superior = null;
        }
        else { //Tiene un proyecto superior
            this.p_proyecto_superior = p;
        }
        this.p_tarea = new ArrayList<Tarea>();
    }
    
    public Proyecto p_get_proyecto_superior(){
        return this.p_proyecto_superior;
    }
    
    public void p_cambiar_tiempos(LocalDateTime finish){
        set_fecha_final(finish);
        if(p_proyecto_superior != null){
            this.p_proyecto_superior.p_cambiar_tiempos(finish);
        }
    }
    
    public void añadir_tarea(Tarea t) {
            p_tarea.add(t);
    }

    public void eliminar_tarea(Tarea t){
        p_tarea.remove(t);
    }
    
    public void p_mostrar(){
        a_mostrar();
        if(p_proyecto_superior != null){
            this.p_proyecto_superior.p_mostrar();
        }
    }
    
    /*
    //funciones
    public void getChild(){}
    */
    
    
    
    
    
    //FUNCIONES DE PRUEBA
    public void comprueba_getters(){ //Incluir en Proyecto y Actividad
        System.out.println("Nombre: " + get_nombre() + "\n");
        System.out.println("Proyecto Superior: " + p_get_proyecto_superior() + "\n");
        System.out.println("F. Inicio: " + get_fecha_inicial() + "\n");
        System.out.println("F. Final: " + get_fecha_final() + "\n");
        System.out.println("T. Total: " + get_tiempo_total() + "\n");
    }
    
    public void comprueba_setters(String name, Proyecto p){ //Incluir en Proyecto y Actividad
        set_nombre(name);
        comprueba_getters();
    }
}
