package TimeTracker;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.lang.Thread;

//Esta clase se encargará de acceder a la hora del dispositivo e ir actualizando a sus observadores
class Reloj extends Observable implements Runnable{
    //Reloj observable = new Reloj(); //no se para que sirve pero da error
    private int periodo;
    private Timer timer;
    private static Reloj uniqueInstance;

    //Constructor donde inicializamos el periodo mediante el cual irá actualizando la hora a los observadores.
    public Reloj() {
        this.periodo = 2;
    }
      
    //Método que devuelve la instancia del reloj para asegurar que solo hay un reloj corriendo para todos los observadores.
    public static Reloj getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Reloj();
        }
        return uniqueInstance;
    }

    public void Notify(){
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        setChanged();
        notifyObservers(hora); //Notifica a los observadores y les envia el objeto del reloj.
        
    }
    
      
    //Función que actualiza la hora y notifica a los observadores.
    @Override
    public void run(){ //Declaración de la función
        while(!Thread.interrupted()){
            try{
                Thread.sleep(1000 * periodo);
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                public void run() {
                    Notify(); //Función a llamar cada 2" mediante scheduleAtFixedRate.
                }
                };
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

/*
//ORIGINAL
public void r_start() {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
    public void run() {
        Notify(); //Función a llamar cada 2" mediante scheduleAtFixedRate.
    }
    };
    timer.scheduleAtFixedRate(task, 0, 1000 * periodo);

}

//VERSION 1  --> NO VA
public void r_start() {
    Thread thread = new Thread();
    thread.run(){
        while(!Thread.interrupted()){
            try{
                Thread.sleep(1000 * periodo);
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                public void run() {
                    Notify(); //Función a llamar cada 2" mediante scheduleAtFixedRate.
                }
                };
                timer.scheduleAtFixedRate(task, 0, 1000 * periodo); //Método que repite la tarea que se pasa como primer argumento cada 1000*periodo = 2".
            }
            catch (InterruptedException e){
                e.printStackTrace();
                //r_ejecutar = false;
            }
        }            
    };

}


//VERSIÓN 2
public void r_start(){
    Thread thread = new Thread(new Runnable(){
        @Override
        public void run(){
            while(!Thread.interrupted()){
                try{
                    Thread.sleep(1000 * periodo);
                    Notify();
                    timer.scheduleAtFixedRate(task, 0, 1000 * periodo);
                    System.out.println("THREAD");

                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    });
}
*/