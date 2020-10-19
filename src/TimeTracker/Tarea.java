package TimeTracker;

import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDataTime;


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
        p.añadir_tarea(this);
    }

    //Funciones
    public boolean añadir_intervalo(Intervalo i, LocalDataTime start) {
        //Comprobamos si la lista de intervalos este vacia
        if(this.t_intervalo.isEmpty()){
            this.t_intervalo = new ArrayList<Intervalo>(this, start);
            this.t_intervalo.add(i);
        }
        //Comprobamos si el último intervalo está abierto
        else if((this.t_intervalo.get(this.t_intervalo.size() - 1)).get_booleano() == false){
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
        Intervalo i;
        Reloj time = a_reloj.getInstance(); //conseguimos la uniqueInstance
        boolean flag = añadir_intervalo(i, time);
        
        if(flag){ //Solo se ejecuta si no hay ningún intervalo abierto
            i.i_mostrar();
        }
        
        
    }
    
    public void stop(){ //finalizamos la actividad
        //a_reloj.notify(); //paramos el crono
        System.out.println("Hemos finalizado la actividad");
    }
    
}
