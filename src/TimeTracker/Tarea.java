package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Tarea extends Actividad{
    private ArrayList<Intervalo> t_lista_intervalos;
       
    //CONSTRUCTOR
    public Tarea(String name, Proyecto p){
        super(name);
        this.t_lista_intervalos = new ArrayList<Intervalo>();
    }
    
    //FUNCIONES
    public void añadir_intervalo(Intervalo i) { //Añadimos intervalo a la lista de intervalos.
        this.t_lista_intervalos.add(i);
    }

    public void eliminar_intervalo(Intervalo i){ //Eliminamos intervalo de la lista de intervalos. 
        t_lista_intervalos.remove(i);
    }
    
    //Inicializas el intervalo que toca, nuevo en la lista y lo muestras
    public void start(){
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        Intervalo i = new Intervalo(this, hora);
        set_fecha_inicial(hora);       
        Reloj time = a_getInstance(); //conseguimos la uniqueInstance
        añadir_intervalo(i);
        time.r_start();
        time.addObserver(i);
        System.out.println("Start tarea\n");
    }
    
    public void stop(){ //finalizamos la actividad
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        Reloj time = a_getInstance(); //conseguimos la uniqueInstance
        Intervalo i = this.t_lista_intervalos.get(this.t_lista_intervalos.size() - 1);
        time.deleteObserver(i);
    }
}