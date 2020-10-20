package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Tarea extends Actividad{
    private ArrayList<Intervalo> t_lista_intervalos;
    private Reloj t_reloj;
 
    //CONSTRUCTOR
    public Tarea(String name, Proyecto p){
        super(name, p);
        this.t_lista_intervalos = new ArrayList<Intervalo>();
    }

    public Reloj t_getInstance(){ 
        return t_reloj.getInstance();
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
        Thread time =  new Thread(t_getInstance()); 
        añadir_intervalo(i);
        time.start(); 
        t_getInstance().addObserver(i);
    }
    
    public void stop(){ //finalizamos la actividad
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        Reloj time = t_getInstance(); //conseguimos la uniqueInstance
        Intervalo i = this.t_lista_intervalos.get(this.t_lista_intervalos.size() - 1);
        time.deleteObserver(i);
    }
}