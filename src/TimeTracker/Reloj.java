package TimeTracker;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
//import java.lang.Object

class Reloj extends Observable {
  private int periodo;
  private LocalDateTime hora;
  private Timer timer;
  private static Reloj uniqueInstance = null;

  private Reloj() {
    this.periodo = 2;
  }
  
  public static Reloj getInstance() {
    if(uniqueInstance == null) {
      return new Reloj();
    } else {
      return uniqueInstance;
    }    
  }
  
  public void start() {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      public void run() {
        Notify();
      }
    };
    timer.scheduleAtFixedRate(task, 0, 1000 * periodo);
  }
  public void set_periodo(int period) {
    this.periodo = period;
  }
  public void Notify(){
    hora = LocalDateTime.now();
    notifyObservers(this);
  }
}
