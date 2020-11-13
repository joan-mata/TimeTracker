package TimeTracker;

import org.json.*;
import java.util.Scanner;
import java.lang.Object;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Observable;
import java.util.Observer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

  
/*Clase Intervalo, tratada como observer
Trata de dividir una tarea en los lapsos de tiempos utilizados para finalizarla*/
public class Intervalo implements Observer {
  private LocalDateTime iLdtFechaInicial;
  private LocalDateTime iLdtFechaFinal;
  private String iFechaInicial;
  private String iFechaFinal;
  private int iTiempoTotal;
  private Tarea iTareaSuperior;
  private String iClase = "intervalo";
  
  Logger logger = LoggerFactory.getLogger(Intervalo.class);

  public Intervalo(Tarea t, LocalDateTime start) {
    this.iTareaSuperior = t;
    this.iLdtFechaInicial = start;
    this.iFechaInicial = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println(start);
    //" " + LocalDateTime.now()
  }

  //GETTERS
  public String iGetFechaInicial() {
    return this.iFechaInicial;
  }

  public String iGetFechaFinal() {
    return this.iFechaFinal;
  }

  public Tarea iGetTareaSuperior() {
    return this.iTareaSuperior;
  }

  public int iGetTiempoTotal() {
    return this.iTiempoTotal;
  }

  //SETTERS
  public void iSetFechaInicial(LocalDateTime start) {
    if (this.iLdtFechaInicial == null) {
      this.iLdtFechaInicial = start;
     
    }
  }

  //Asigna la fecha final del intervalo y calcula el teimpo total
  public void iSetFechaFinal(LocalDateTime finish) {
    iLdtFechaFinal = finish;
    iFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    //Calcular tiempo total
    int iSegundosInicial = iLdtFechaInicial.getSecond();
    LocalDateTime total = iLdtFechaFinal.minusSeconds(iSegundosInicial);
    this.iTiempoTotal = total.getSecond();
    this.iTareaSuperior.setFechaFinal(finish);

  }

  //muestra las variables del intervalo
   public void iMostrar() {
    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "", iFechaInicial, "", iFechaFinal, "", iTiempoTotal);
    iTareaSuperior.aMostrar();
  }

  public JSONObject getJSON() {
    JSONObject jo = new JSONObject(); //JSONArray();
    try {
      jo.put("class", iClase);
      jo.put("initialDate", iFechaInicial);
      jo.put("finalDate", iFechaFinal);
      jo.put("duration", iTiempoTotal);
    }catch (JSONException e){

    }
      return jo;
  }
  

  //Sobreescribe los datos para que los pueda ver el observer
  @Override
  public void update(Observable o, Object arg) {
    this.iSetFechaFinal((LocalDateTime) arg);
    this.iMostrar();
  }
}
