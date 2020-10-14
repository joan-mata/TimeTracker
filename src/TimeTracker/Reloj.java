import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;

class Reloj extends Observable {
  private int periodo;
  private LocalDateTime hora;
  private Timer timer;

  public Reloj(int period) {
    this.periodo = periodo;
  }
  public void start() {
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
      public void run() {
        notify();
      }
    };
    timer.scheduleAtFixedRate(task, 0, 1000 * periodo);
  }
  public void set_periodo(period) {
    this.periodo = period;
  }
  public void notify(){
    hora = LocalDateTime.now();
    notifyObservers(this);
  }
}
