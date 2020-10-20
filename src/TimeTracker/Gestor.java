package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Gestor{
    private ArrayList<Proyecto> g_lista_proyectos;
    private ArrayList<Tarea> g_lista_tareas;

    public Gestor(){
        g_lista_proyectos = new ArrayList<Proyecto>();
        g_lista_tareas = new ArrayList<Tarea>();
    }
    
    //Inicializar
    public void g_crear_proyecto(Proyecto p){
        g_lista_proyectos.add(p);
    }
    
    public void g_crear_tarea(Tarea t){
        g_lista_tareas.add(t);
        if (t.t_get_proyecto_superior() != null){
            int index = g_lista_proyectos.indexOf(t.t_get_proyecto_superior());
            g_lista_proyectos[index].p_añadir_tarea(t);
        }
    }
                               
    public void g_borrar_proyecto(Proyecto p){
        g_lista_proyectos.remove(p);
    }
    
    public void g_borrar_tarea(Tarea t){
        g_lista_tareas.remove(t);
    }
    
    //Funciones
    
}
