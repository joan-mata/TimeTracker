package timetracker;

import java.lang.Thread;
import java.time.LocalDateTime;
import java.util.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//Esta clase se encargará de acceder a la hora del dispositivo e ir actualizando a sus observadores
public class Reloj extends Observable implements Runnable {
  private int periodo;
  private static Reloj uniqueInstance;
  private boolean flag = false;
  
  //Logger logger = LoggerFactory.getLogger(Reloj.class);
  private static final Logger logger = LoggerFactory.getLogger(Reloj.class);

  /*Constructor donde inicializamos el periodo mediante el cual irá
  actualizando la hora a los observadores.*/
  private Reloj() {
    this.periodo = 2;
  }

  /*Método que devuelve la instancia del reloj para asegurar que
  solo hay un reloj corriendo para todos los observadores.
  synchronized no permite a dos thread o mas entrar a la vez
  en la función, entran de uno en uno */
  public static synchronized Reloj getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new Reloj();
      logger.info("Reloj instanciado");
    }
    logger.trace("Estoy en el método getInstance de la clase Reloj");
    return uniqueInstance;
  }

  public void changeFlag(boolean f) {
    flag = f;
  }

  public void notificar() {
    logger.debug("Entré notificar()");

    if (flag) {
      setChanged();
      logger.debug("Entré setChanged()");
    }
    //Notifica a los observadores y les envia el objeto del reloj.
    notifyObservers(LocalDateTime.now());
    logger.debug("Final notificar(), now={}", LocalDateTime.now());
  }

  //Función que actualiza la hora y notifica a los observadores.
  @Override
  public void run() {
    while (!Thread.interrupted()) {
      try {
        Thread.sleep(1000 * periodo);
        notificar();
      } catch (InterruptedException e) {
        logger.error("{}", e);
      }
    }
  }
}
