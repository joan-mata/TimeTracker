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
    private int i_tiempo_total;
    private Tarea i_tarea_superior;
    
    public Intervalo(Tarea t, LocalDateTime start){
        i_tarea_superior = t;
        i_fecha_inicial = start;        
    }
    
    public Intervalo(Intervalo i){
        this.i_tarea_superior = i.i_get_tarea_superior();
        this.i_fecha_inicial = i.i_get_fecha_inicial();
    }
    
    //GETTERS
    public LocalDateTime i_get_fecha_inicial(){
        return this.i_fecha_inicial;
    }
    
    public LocalDateTime i_get_fecha_final(){
        return this.i_fecha_final;
    }
    
    public Tarea i_get_tarea_superior(){
        return this.i_tarea_superior;
    }
    
    //SETTERS
    public void i_set_fecha_inicial(LocalDateTime start){
        if(this.i_fecha_inicial == null){
            this.i_fecha_inicial = start;
        }
    }
    
    public void i_set_fecha_final(LocalDateTime finish){
        this.i_fecha_final = finish;
        this.i_tarea_superior.set_fecha_final(finish);

        //Calcular tiempo total
        LocalDateTime total;
        int i_segundos_inicial = i_fecha_inicial.getSecond();
        total = i_fecha_final.minusSeconds(i_segundos_inicial);
        this.i_tiempo_total = total.getSecond();

    }

    //FUNCIONES
    public void i_mostrar(){
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "", i_fecha_inicial, "", i_fecha_final, "", i_tiempo_total);
        i_tarea_superior.a_mostrar();
    }
    
    @Override
    public void update(Observable o, Object arg) { 
        this.i_set_fecha_final((LocalDateTime) arg);
        this.i_tarea_superior.set_fecha_final((LocalDateTime) arg);
        System.out.println("Update\n");
        this.i_mostrar();
    }


    
    /*
    observable.addObserver(observer);
    observable.start();
    assertEquals(observer.update(), "hora"); //no tengo claro si va hora, args, nada, o otra cosa
     */
}
