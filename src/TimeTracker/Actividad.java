package TimeTracker;

import java.lang.Object;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Actividad {
    private String a_nombre;
    private LocalDateTime a_fecha_inicial;   
    private LocalDateTime a_fecha_final;
    private int a_tiempo_total;
    private Proyecto a_proyecto_superior;

    //private Reloj a_reloj;
    private Reloj a_reloj;
    
    public Actividad(String name){ //constructor
        this.a_nombre = name;
        this.a_tiempo_total = 0;
    }
    
    //GETTERS
    public String get_nombre(){
        return this.a_nombre;
    }
    
    public LocalDateTime get_fecha_inicial(){
        return this.a_fecha_inicial;
    }
    
    public LocalDateTime get_fecha_final(){
        return this.a_fecha_final;
    }
    
    public int get_tiempo_total(){
        return this.a_tiempo_total;
    }

    public Reloj a_getInstance(){
        return a_reloj.getInstance();
    }
    
    //SETTERS
    public void set_nombre(String name){
        this.a_nombre = name;
    }

    public void set_fecha_inicial(LocalDateTime start){
        if(this.a_fecha_inicial == null){
            this.a_fecha_inicial = start;
        }
        if (a_proyecto_superior != null){
            a_proyecto_superior.set_fecha_inicial(start);
        }
    }
    
    public void set_fecha_final(LocalDateTime finish){
        this.a_fecha_final = finish;

        //Calculamos el tiempo utilizado
        LocalDateTime total;
        int a_segundos_inicial = a_fecha_inicial.getSecond();
        total = a_fecha_final.minusSeconds(a_segundos_inicial);
        this.a_tiempo_total = total.getSecond();

        //Actualizamos el tiempo final y total del proyecto superior
        if(a_proyecto_superior != null){
            this.a_proyecto_superior.set_fecha_final(finish);
        }
    }
    
    
    //FUNCIONES
    public void a_mostrar(){
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Actividad:", a_nombre, a_fecha_inicial, "", a_fecha_final, "", a_tiempo_total);
        if(a_proyecto_superior != null){
            this.a_proyecto_superior.a_mostrar();
        }
    }
        
}
