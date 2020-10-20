package TimeTracker;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
//import java.lang.Object

//Esta clase se encargará de acceder a la hora del dispositivo e ir actualizando a sus observadores
class Reloj extends Observable {
    //Reloj observable = new Reloj(); //no se para que sirve pero da error
    private int periodo;
    private Timer timer;
    private static Reloj uniqueInstance;

    //Constructor donde inicializamos el periodo mediante el cual irá actualizando la hora a los observadores.
    private Reloj() {
        this.periodo = 2;
        this.uniqueInstance = null;
    }
      
    //Método que devuelve la instancia del reloj para asegurar que solo hay un reloj corriendo para todos los observadores.
    public static Reloj getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Reloj();
        }
        return uniqueInstance;
    }
      
    //Función que actualiza la hora y notifica a los observadores.
    public void r_start() {
        System.out.println("Start reloj\n");
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Notify(); //Función a llamar cada 2" mediante scheduleAtFixedRate.
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000 * periodo); //Método que repite la tarea que se pasa como primer argumento cada 1000*periodo = 2".
        System.out.println("Stop reloj\n");
    }
        
    public void Notify(){
        LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
        notifyObservers(hora); //Notifica a los observadores y les envia el objeto del reloj.
    }
}
