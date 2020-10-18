package TimeTracker;

import java.util.ArrayList;

public class Tarea extends Actividad{
    private Proyecto t_proyecto_superior;
    private List<Intervalo> t_intervalo;
   

    //Constructor
    public Tarea(String name){
        super(name);
    }

    public Tarea(String name, Proyecto p){
        super(name);
        this.t_proyecto_superior = p;
    }
    
    public void add_interval(Intervalo i){
        t_intervalo.add_interval(i);
    }

    public void añadir_intervalo(Tarea t) {
        if(p_tarea.isEmpty()){
            p_tarea = new ArrayList<Tarea>();
        }
        else{
            p_tarea.add(t);
        }   
    }

    public void eliminar_intervalo(Tarea t){
        p_tarea.remove(t);
    }
    
    //FUNCIONES PRUEBAS
    
}
