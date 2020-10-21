package TimeTracker;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.lang.Thread;

//Esta clase se encargará de acceder a la hora del dispositivo e ir actualizando a sus observadores
class Reloj extends Observable implements Runnable{
    private int periodo;
    private static Reloj uniqueInstance;
    private Boolean empezar;
    private static Thread time;

    //Constructor donde inicializamos el periodo mediante el cual irá actualizando la hora a los observadores.
    private Reloj() {
        this.periodo = 2;
        empezar = true;
    }
    
    public int get_periodo(){
        return this.periodo;
    }
    //Método que devuelve la instancia del reloj para asegurar que solo hay un reloj corriendo para todos los observadores.
    //synchronized no permite a dos thred o mas entrar a la vez en la función, entran de uno en uno
    public static synchronized Reloj getInstance() { 
        if(uniqueInstance == null) {
            uniqueInstance = new Reloj();
            time =  new Thread(uniqueInstance);
        }
        return uniqueInstance;
    }

    public void Notify(){
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        setChanged();
        notifyObservers(hora); //Notifica a los observadores y les envia el objeto del reloj.
        
    }
    
    public void stop(){
        time.suspend();
    }
    
    public void start(){
        if(empezar != false){
            time.start();
        }
        else{
            time.resume();
        }
    }
    
    //Función que actualiza la hora y notifica a los observadores.
    @Override
    public void run(){ //Declaración de la función
        this.empezar = false;
        while(!Thread.interrupted()){
            try{
                Thread.sleep(1000 * periodo);
                Notify();
                System.out.println(LocalDateTime.now());
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
