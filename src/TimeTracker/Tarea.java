package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Tarea extends Actividad{
    private Proyecto t_proyecto_superior;
    private ArrayList<Intervalo> t_intervalo;
   
    //private Rellotge t_reloj; //Copia del reloj de Actividad
    
    //Constructor
    public Tarea(String name){
        super(name);
        this.t_proyecto_superior = null;
        this.t_intervalo = new ArrayList<Intervalo>();
    }
    
    public Tarea(String name, Proyecto p){
        super(name);
        this.t_proyecto_superior = p;
        p.añadir_tarea(this);
    }

    //Funciones
    public boolean añadir_intervalo(Intervalo i) {
        //Comprobamos si la lista de intervalos este vacia
        if(t_intervalo.isEmpty() == true){
            this.t_intervalo.add(i);
        }
        //Comprobamos si el último intervalo está abierto
        else if((this.t_intervalo.get(this.t_intervalo.size() - 1)).i_get_booleano() == false){
            this.t_intervalo.add(i);
        }
        //El último intervalo SI está abierto
        else{
            return false;
        }
        return true;
    }

    public void eliminar_intervalo(Intervalo i){
        t_intervalo.remove(i);
    }
    
    public void t_mostrar(){
        a_mostrar();
        if(t_proyecto_superior != null){
           this.t_proyecto_superior.p_mostrar();
        }
    }
    
    //Inicializas el intervalo que toca, nuevo en la lista y lo muestras
    public void start(){
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        Intervalo i = new Intervalo(this, hora);
        Rellotge time = a_getInstance(); //conseguimos la uniqueInstance
        boolean flag = añadir_intervalo(i);
        
        if(flag){ //Solo se ejecuta si no hay ningún intervalo abierto
            time.r_start(this.t_intervalo.get(this.t_intervalo.size() - 1));
            //i.i_mostrar();
        }
        
        
    }
    
    public void stop(){ //finalizamos la actividad
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        Intervalo i = new Intervalo(this, hora);
        Rellotge time = a_getInstance(); //conseguimos la uniqueInstance
        boolean flag = añadir_intervalo(i);
        
        if(!flag){ //Solo se ejecuta si no hay ningún intervalo abierto
            time.r_stop();
        }
    }
    
}
