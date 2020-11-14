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
    System.out.println(start + " " + LocalDateTime.now());
  }

  public int intGetTiempoTotal() {
    return this.intTiempoTotal;
  }

  //Asigna la fecha final del intervalo y calcula el tiempo total
  public void intSetFechaFinal(LocalDateTime finish) {
    assert (finish.isAfter(intLdtFechaInicial)) :
        "El tiempo final es inferior al tiempo inicial.";


    intLdtFechaFinal = finish;
    intFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    //Calcular tiempo total
    int intSegundosInicial = intLdtFechaInicial.getSecond();
    LocalDateTime total = intLdtFechaFinal.minusSeconds(intSegundosInicial);

    assert (total.getSecond() >= intTiempoTotal) :
        "El tiempo total futuro es inferior al tiempo total anterior.";
    this.intTiempoTotal = total.getSecond();
    this.intTareaSuperior.setFechaFinal(finish);

    //Postcondiciones
    assert (intTiempoTotal > 0) : "El tiempo total es inferior o igual a 0.";
    assert (intTiempoTotal % 2 == 0) : "El tiempo total es impar.";

  }

  //muestra las variables del intervalo
  public void intMostrar() {
    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "",
        intFechaInicial, "", intFechaFinal, "", intTiempoTotal);
    intTareaSuperior.actMostrar();
  }

  public JSONObject getJson() {
    JSONObject jo = new JSONObject();
    try {
      jo.put("class", intClase);
      jo.put("initialDate", intFechaInicial);
      jo.put("finalDate", intFechaFinal);
      jo.put("duration", intTiempoTotal);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return jo;
  }
  

  //Sobreescribe los datos para que los pueda ver el observer
  @Override
  public void update(Observable o, Object arg) {
    this.intSetFechaFinal((LocalDateTime) arg);
    this.intMostrar();
  }
}
