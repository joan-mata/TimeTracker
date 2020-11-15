package timetracker;

import java.lang.Object;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

  
/*Clase Intervalo, tratada como observer
Trata de dividir una tarea en los lapsos de tiempos utilizados para finalizarla*/
public class Intervalo implements Observer {
  private LocalDateTime intLdtFechaInicial;
  private LocalDateTime intLdtFechaFinal;
  private String intFechaInicial;
  private String intFechaFinal;
  private int intTiempoTotal;
  private Tarea intTareaSuperior;
  private String intClase;
  
  Logger logger = LoggerFactory.getLogger(Intervalo.class);

  public Intervalo(Tarea t, LocalDateTime start) {
    this.intClase = "intervalo";
    this.intTareaSuperior = t;
    this.intLdtFechaInicial = start;
    this.intFechaInicial = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    this.intTiempoTotal = -100; //un valor muy pequeño para trabajar con él
    System.out.println(start + " " + LocalDateTime.now());

    assert intInvariant(): "Invariante";
  }

  protected boolean intInvariant() {
    return intLdtFechaInicial != null &&
      (intTiempoTotal == -100 || (intTiempoTotal > 0 && intTiempoTotal % 2 == 0));
  }

  public int intGetTiempoTotal() {
    assert intInvariant(): "Invariante";
    this.intSetTiempoTotal();
    assert intInvariant(): "Invariante";
    return this.intTiempoTotal;
  }

  //Asigna la fecha final del intervalo y calcula el tiempo total
  public void intSetFechaFinal(LocalDateTime finish) {
    assert intInvariant(): "Invariante";
    assert (finish.isAfter(intLdtFechaInicial)) :
        "El tiempo final es inferior al tiempo inicial.";

    intLdtFechaFinal = finish;
    intFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    this.intSetTiempoTotal();
    this.intTareaSuperior.setFechaFinal(finish);

    assert intInvariant(): "Invariante";
  }

  public void intSetTiempoTotal() {
    assert intInvariant(): "Invariante";
    int intSegundosInicial = intLdtFechaInicial.getSecond();
    LocalDateTime total = intLdtFechaFinal.minusSeconds(intSegundosInicial);

    assert (total.getSecond() >= intTiempoTotal) :
        "El tiempo total futuro es inferior al tiempo total anterior.";
    this.intTiempoTotal = total.getSecond();
    assert intInvariant(): "Invariante";

  }

  //muestra las variables del intervalo
  public void intMostrar() {
    assert intInvariant(): "Invariante";

    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "",
        intFechaInicial, "", intFechaFinal, "", intTiempoTotal);
    intTareaSuperior.actMostrar();

    assert intInvariant(): "Invariante";
  }

  public JSONObject getJson() {
    assert intInvariant(): "Invariante";

    JSONObject jo = new JSONObject();
    try {
      jo.put("class", intClase);
      jo.put("initialDate", intFechaInicial);
      jo.put("finalDate", intFechaFinal);
      jo.put("duration", intTiempoTotal);
    } catch (JSONException e) {
      e.printStackTrace();
    }

    assert intInvariant(): "Invariante";
    return jo;
  }

  //Sobreescribe los datos para que los pueda ver el observer
  @Override
  public void update(Observable o, Object arg) {
    assert intInvariant(): "Invariante";

    this.intSetFechaFinal((LocalDateTime) arg);
    this.intMostrar();

    assert intInvariant(): "Invariante";
  }
}
