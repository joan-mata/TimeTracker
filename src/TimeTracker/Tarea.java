package TimeTracker;

public class Tarea{ //extends Actividad{
    private String t_nombre;
    private String t_fecha_inicial;
    private String t_fecha_final;
    private int t_tiempo_total;
    
    private Actividad t_actividad_superior;
    
    //Constructor
    public Tarea(String name){
        this.t_nombre = name;
        this.t_fecha_inicial = "";
        this.t_fecha_final = "";
        this.t_tiempo_total = 0;
    }
    
    //Getters
    public String get_nombre(){
        return this.t_nombre;
    }
    
    public String get_fecha_inicial(){
        return this.t_fecha_inicial;
    }
    
    public String get_fecha_final(){
        return this.t_fecha_final;
    }
    
    public int get_tiempo_total(){ //podría calcular el tiempo también
        return this.t_tiempo_total;
    }
    
    //Setters
    public void set_nombre(String name){
        this.t_nombre = name;
    }
    
    public void set_fecha_inicial(String start){
        this.t_fecha_inicial = start;
    }
    
    public void set_fecha_final(String finish){
        this.t_fecha_final = finish;
    }
    
    public void set_tiempo_total(int time){ //¿necesaria?
        this.t_tiempo_total = time;
    }
    
    public void set_completo(String name, String initial, String end, int time){
        this.set_nombre(name);
        this.set_proyecto(p);
        this.set_fecha_inicial(initial);
        this.set_fecha_final(end);
        this.set_tiempo_total(time);
    }
    
    public void modificar_tarea(Tarea t){
        //Cambiamos toda la info menos el nombre
        this.t_fecha_inicial = t.get_fecha_inicial();
        this.t_fecha_final = t.get_fecha_final();
        this.t_tiempo_total = t.get_tiempo_total();
    }
    
    //Funciones
    public void inicio(){}
    public void fin(){}
    
    //FUNCIONES PRUEBAS
    public void comprueba_getters(){ 
        System.out.println("Nombre: " + this.get_nombre() + "\n");
        System.out.println("F. Inicio: " + this.get_fecha_inicial() + "\n");
        System.out.println("F. Final: " + this.get_fecha_final() + "\n");
        System.out.println("T. Total: " + this.get_tiempo_total() + "\n");
    }

    public void comprueba_setters(String name, String initial, String end, int time){
        this.set_nombre(name);
        this.set_fecha_inicial(initial);
        this.set_fecha_final(end);
        this.set_tiempo_total(time);

        comprueba_getters();
    }
}
