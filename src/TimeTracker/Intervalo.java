package TimeTracker;

import java.util.Scanner;
import java.lang.Object;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

public class Intervalo implements Observer{
   // Intervalo observer = new Intervalo();  tendriamos que diferenciar cada observer, osea cada intervalo que monitorizamos, una lista por ejemplo
    private LocalDateTime i_fecha_inicial;
    private LocalDateTime i_fecha_final;
    private LocalDateTime i_tiempo_total;
    private Tarea i_tarea_superior;
    private boolean i_booleano;
    
    public Intervalo(Tarea t, LocalDateTime start){
        i_tarea_superior = t;
        i_fecha_inicial = start;
        i_booleano = true;
        
    }
    
    public Intervalo(Intervalo i){
        this.i_tarea_superior = i.i_get_tarea_superior();
        this.i_fecha_inicial = i.i_get_fecha_inicial();
        this.i_booleano = i.i_get_booleano();
    }
    
    //getters
    public LocalDateTime i_get_fecha_inicial(){
        return this.i_fecha_inicial;
    }
    
    public LocalDateTime i_get_fecha_final(){
        return this.i_fecha_final;
    }
    
    public LocalDateTime i_get_tiempo(){
        this.i_calcular_tiempo_total();
        return this.i_tiempo_total;
    }
    
    public boolean i_get_booleano(){
        return this.i_booleano;
    }
    
    public Tarea i_get_tarea_superior(){
        return this.i_tarea_superior;
    }
    
    //setters
    public void i_set_fecha_inicial(LocalDateTime start){
        this.i_fecha_inicial = start;
    }
    
    public void i_set_fecha_final(LocalDateTime finish){
        this.i_fecha_final = finish;
    }
    
    public void i_cambiar_booleano(){
        if(i_booleano){
            i_booleano = false;
        }
        else{
            i_booleano = true;
        }
    }
    
    public void i_cambiar_tiempos(LocalDateTime finish){
        this.i_fecha_final = finish;
        this.i_calcular_tiempo_total();
    }
    
    public void i_calcular_tiempo_total(){
        //Calculamos el tiempo utilizado
        int i_segundos_inicial = i_fecha_inicial.getSecond();
        this.i_tiempo_total = i_fecha_final.minusSeconds(i_segundos_inicial); //REVISAR QUE FUNCIONE CAMBIO DE INT A LONG
    }
    
    @Override
    public void update(Observable o, Object arg) {
        this.i_set_fecha_final((LocalDateTime) arg);
    }

    public void i_mostrar(){
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "", i_fecha_inicial, "", i_fecha_final, "", i_tiempo_total);
        i_tarea_superior.t_mostrar();
    }
    
    /*
    observable.addObserver(observer);
    observable.start();
    assertEquals(observer.update(), "hora"); //no tengo claro si va hora, args, nada, o otra cosa
     */
}
