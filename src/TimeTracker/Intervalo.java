package TimeTracker;

public class Intervalo extends Tarea{
    String i_ID;
    String i_inicio;
    String i_final;
    int i_tiempo;
    
    public Intervalo(String ID, String start){
        i_ID = ID;
        i_inicio = start;
    }
    
    //getters
    public String get_ID(){
        return i_ID;
    }
    
    public String get_inicio(){
        return i_inicio;
    }
    
    public String get_final(){
        return i_final;
    }
    
    public int get_tiempo(){ //podría calcular el tiempo también
        return i_tiempo;
    }
    
    //setters
    public void set_ID(String ID){
        i_ID = ID;
    }
    
    public void set_inicio(String start){
        i_inicio = start;
    }
    
    public void set_fecha_final(String finish){
        i_final = finish;
    }
    
    public void set_tiempo(int time){ //¿necesaria?
        i_tiempo = time;
    }
    
    public void contar_tiempo(){}
    public void actualizar(){}
}