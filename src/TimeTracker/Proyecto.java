package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Proyecto extends Actividad{ 
    private ArrayList<Tarea> p_lista_tareas;

    //CONSTRUCTORES
    public Proyecto(String name, Proyecto p){
        super (name);
        this.p_lista_tareas = new ArrayList<Tarea>();
    }
    
    //FUNCIONES
    public void añadir_tarea(Tarea t) {
        p_lista_tareas.add(t);
    }

    public void eliminar_tarea(Tarea t){
        p_lista_tareas.remove(t);
    }  
}