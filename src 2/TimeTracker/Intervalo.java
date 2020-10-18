package TimeTracker;

import java.util.Observer;

public class Intervalo extends Observer{
    private LocalDateTime i_fecha_inicial;
    private LocalDateTime i_fecha_final;
    private LocalDateTime i_tiempo_total;
    private Tarea i_tarea_superior;
    
    public Intervalo(Tarea t, LocalDateTime start){
        i_tarea_superior = t;
        i_fecha_inicial = start;
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
        int i_segundos_inicial = i_fecha_inicial.getSeconds();
        this.i_tiempo_total = i_fecha_final.minusSeconds(long(i_segundos_inicial)); //REVISAR QUE FUNCIONE CAMBIO DE INT A LONG

        return this.i_tiempo_total;
    }
    
    //setters
    public void set_inicio(LocalDateTime start){
        this.i_fecha_inicial = start;
    }
    
    public void set_fecha_final(LocalDateTime finish){
        this.i_fecha_final = finish;
    }
}