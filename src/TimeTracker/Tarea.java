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
        this.t_intervalo = new ArrayList<Intervalo>();
    }
    
    public void t_cambiar_tiempos(LocalDateTime finish){
        set_fecha_final(finish);
        if(t_proyecto_superior != null){
            this.t_proyecto_superior.p_cambiar_tiempos(finish);
        }
    }
    
    public Proyecto t_get_proyecto_superior(){
        return this.t_proyecto_superior;
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
            set_fecha_inicial(hora);
            if (t_proyecto_superior != null){
                t_proyecto_superior.p_set_fecha_inicial(hora);
            }
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
    
    
    
    
    
    //FUNCIONES DE PRUEBA
    public void comprueba_getters(){ //Incluir en Proyecto y Actividad
        System.out.println("Nombre: " + get_nombre() + "\n");
        System.out.println("Proyecto Superior: " + t_get_proyecto_superior() + "\n");
        System.out.println("F. Inicio: " + get_fecha_inicial() + "\n");
        System.out.println("F. Final: " + get_fecha_final() + "\n");
        System.out.println("T. Total: " + get_tiempo_total() + "\n");
    }
    
    public void comprueba_setters(String name, Proyecto p){ //Incluir en Proyecto y Actividad
        set_nombre(name);
        comprueba_getters();
    }
}
