package TimeTracker;

import java.lang.Object;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Actividad {
    private String a_nombre;
    private LocalDateTime a_fecha_inicial;   
    private LocalDateTime a_fecha_final;
    private int a_tiempo_total;
    //private Reloj a_reloj;
    private Rellotge a_reloj;
    
    public Actividad(String name){ //contructor
        this.a_nombre = name;
        this.a_tiempo_total = 0;
    }
    
    //getters
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
    //public Reloj a_getInstance(){
    public Rellotge a_getInstance(){
        return a_reloj.r_getInstance();
    }
    
    //setters
    public void set_nombre(String name){
        this.a_nombre = name;
    }


    public void set_fecha_inicial(LocalDateTime start){
        if(this.a_fecha_inicial == null){
            this.a_fecha_inicial = start;
        }
    }
    
    public void set_fecha_final(LocalDateTime finish){
        this.a_fecha_final = finish;
        this.calcular_tiempo_total();
    }
    
    public void calcular_tiempo_total(){
        //Calculamos el tiempo utilizado
        LocalDateTime total;
        int a_segundos_inicial = a_fecha_inicial.getSecond();
        total = a_fecha_final.minusSeconds(a_segundos_inicial);
        this.a_tiempo_total = total.getSecond();
    }
    
    //Funciones
    public void actualizar(String name, LocalDateTime start){ //REVISAR!!!!
        set_nombre(name);
        set_fecha_inicial(start);
    }
    
    public void a_mostrar(){
        System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Actividad:", a_nombre, a_fecha_inicial, "", a_fecha_final, "", a_tiempo_total);
    }
    
    
    
    //FUNCIONES PRUEBAS
    
}
