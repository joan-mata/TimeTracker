package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;

public class Tarea extends Actividad{
    private Proyecto t_proyecto_superior;
    private ArrayList<Intervalo> t_intervalo;
   

    //Constructor
    public Tarea(String name){
        super(name);
        this.t_proyecto_superior = null;
    }
    
    public Tarea(String name, Proyecto p){
        super(name);
        this.t_proyecto_superior = p;
    }

    //Funciones
    public void añadir_intervalo(Intervalo i) {
        if(t_intervalo.isEmpty()){
            t_intervalo = new ArrayList<Intervalo>();
            t_intervalo.add(i);
        }
        else{
            t_intervalo.add(i);
        }   
    }

    public void eliminar_intervalo(Intervalo i){
        t_intervalo.remove(i);
    }
    
    public void t_mostrar(){
        a_mostrar();
        if(p_proyecto_superior != null){
            p_proyecto_superior.p_mostrar();
        }
    }
    
    public void start(){
        //Inicializas el intervalo que toca, nuevo en la lista y lo muestras
    }
    //FUNCIONES PRUEBAS
    
}
