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
            Proyecto p = g_lista_proyectos.get(index);
            p.añadir_tarea(t);
            g_lista_proyectos.remove(index);
            g_lista_proyectos.add(index, p);
        }
    }
        
    public void g_modificar_proyecto(Proyecto p){
        int index = g_lista_proyectos.indexOf(p);
        g_lista_proyectos.remove(index);
        g_lista_proyectos.add(index, p);
    }
    
    public void g_modificar_tarea(Tarea t){
        int index_tarea = g_lista_tareas.indexOf(t);
        g_lista_tareas.remove(index_tarea);
        g_lista_tareas.add(index_tarea, t);
        if (t.t_get_proyecto_superior() != null){
            int index_proyecto_superior = g_lista_proyectos.indexOf(t.t_get_proyecto_superior());
            Proyecto p = g_lista_proyectos.get(index_proyecto_superior);
            p.añadir_tarea(t);
            g_lista_proyectos.remove(index_proyecto_superior);
            g_lista_proyectos.add(index_proyecto_superior, p);
        }
    }
    
    public void g_borrar_proyecto(Proyecto p){
        g_lista_proyectos.remove(p);
    }
    
    public void g_borrar_tarea(Tarea t){
        g_lista_tareas.remove(t);
    }
    
    //Funciones
    
    
    //funcoines prueba
    public Proyecto g_return_proyecto(Proyecto p){
        int index = g_lista_proyectos.indexOf(p);
        Proyecto pr = g_lista_proyectos.get(index);
        return pr;
    }
    
    public Tarea g_return_tarea(Tarea t){
        int index = g_lista_tareas.indexOf(t);
        Tarea ta = g_lista_tareas.get(index);
        return ta;
    }
}
