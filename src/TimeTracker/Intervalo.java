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
    
    //getters
    public LocalDateTime get_inicio(){
        return this.i_fecha_inicial;
    }
    
    public LocalDateTime get_final(){
        return this.i_fecha_final;
    }
    
    public LocalDateTime get_tiempo(){
        //Calculamos el tiempo utilizado
        int i_segundos_inicial = i_fecha_inicial.getSecond();
        this.i_tiempo_total = i_fecha_final.minusSeconds(i_segundos_inicial); //REVISAR QUE FUNCIONE CAMBIO DE INT A LONG

        return this.i_tiempo_total;
    }
    
    public boolean get_booleano(){
        return this.i_booleano;
    }
    
    //setters
    public void setI_fecha_inicial(LocalDateTime start){
        this.i_fecha_inicial = start;
    }
    
    public void setI_fecha_final(LocalDateTime finish){
        this.i_fecha_final = finish;
    }
    
    public void cambiar_booleano(){
        if(i_booleano){
            i_booleano = false;
        }
        else{
            i_booleano = true;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setI_fecha_final((LocalDateTime) arg);
    }

    public void i_mostrar(){
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "", i_fecha_inicial, " ", i_fecha_final, "", i_tiempo_total);
        i_tarea_superior.t_mostrar();
    }
    
    /*
    observable.addObserver(observer);
    observable.start();
    assertEquals(observer.update(), "hora"); //no tengo claro si va hora, args, nada, o otra cosa
     */
}
