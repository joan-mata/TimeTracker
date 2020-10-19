package TimeTracker;

import java.lang.*;
import java.util.ArrayList;

public class Proyecto extends Actividad{ 
    private Proyecto p_proyecto_superior;
    private List<Tarea> p_tarea;

    //Constructores
    public Proyecto(String name, Proyecto p){
        super (name);
        
        if(p == null){  //En este caso, el proyecto actual es el root
            this.p_proyecto_superior = null;
        }
        else { //Tiene un proyecto superior
            this.p_proyecto_superior = p;
        }
    }

    public void añadir_tarea(Tarea t) {
        if(p_tarea.isEmpty()){
            p_tarea = new ArrayList<Tarea>();
            p_tarea.add(t);
        }
        else{
            p_tarea.add(t);
        }   
    }

    public void eliminar_tarea(Tarea t){
        p_tarea.remove(t);
    }

    
    /*
    //funciones
    public void getChild(){}
    */    
}
