package TimeTracker;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
//import java.lang.Object

//Esta clase se encargará de acceder a la hora del dispositivo e ir actualizando a sus observadores
class Reloj extends Observable {
  private int periodo;
  private LocalDateTime hora;
  private Timer timer;
  private static Reloj uniqueInstance = null;

  //Constructor donde inicializamos el periodo mediante el cual irá actualizando la hora a los observadores.
  private Reloj() {
    this.periodo = 2;
  }
  
  //Método que devuelve la instancia del reloj para asegurar que solo hay un reloj corriendo para todos los observadores. 
  public static Reloj getInstance() {
    if(uniqueInstance == null) {
      return new Reloj();
    } else {
      return uniqueInstance;
    }    
  }
  
  //Función que actualiza la hora y notifica a los observadores.
  public void start() {
    Timer timer = new Timer(); 
    TimerTask task = new TimerTask() {
      public void run() {
        Notify(); //Función a llamar cada 2" mediante scheduleAtFixedRate.
      }
    };
    timer.scheduleAtFixedRate(task, 0, 1000 * periodo); //Método que repite la tarea que se pasa como primer argumento cada 1000*periodo = 2".
  }
  public void Notify(){
    hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
    notifyObservers(this); //Notifica a los observadores y les envia el objeto del reloj.
  }

}
