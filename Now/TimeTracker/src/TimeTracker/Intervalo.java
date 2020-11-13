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
  private LocalDateTime intLdtFechaInicial;
  private LocalDateTime intLdtFechaFinal;
  private String intFechaInicial;
  private String intFechaFinal;
  private int intTiempoTotal;
  private Tarea intTareaSuperior;
  private String intClase = "intervalo";
  
  Logger logger = LoggerFactory.getLogger(Intervalo.class);

  public Intervalo(Tarea t, LocalDateTime start) {
    this.intTareaSuperior = t;
    this.intLdtFechaInicial = start;
    this.intFechaInicial = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    System.out.println(start + " " + LocalDateTime.now());
  }

  //GETTERS
  public String iGetFechaInicial() {
    return this.intFechaInicial;
  }

  public String iGetFechaFinal() {
    return this.intFechaFinal;
  }

  public Tarea iGetTareaSuperior() {
    return this.intTareaSuperior;
  }

  public int iGetTiempoTotal() {
    return this.intTiempoTotal;
  }

//TODO Borrar!!
/*
  //SETTERS
  public void iSetFechaInicial(LocalDateTime start) {
    if (this.intLdtFechaInicial == null) {
      this.intLdtFechaInicial = start;
    }
  }*/

  //Asigna la fecha final del intervalo y calcula el tiempo total
  public void iSetFechaFinal(LocalDateTime finish) {
  	//Precondiciones
  	assert (finish > intLdtFechaInicial): "El tiempo final es inferior al tiempo inicial.";


    intLdtFechaFinal = finish;
    intFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    //Calcular tiempo total
    int iSegundosInicial = intLdtFechaInicial.getSecond();
    LocalDateTime total = intLdtFechaFinal.minusSeconds(iSegundosInicial);

    assert (total.getSecond() >= intTiempoTotal): "El tiempo total futuro es inferior al tiempo total anterior.";
    this.intTiempoTotal = total.getSecond();
    this.intTareaSuperior.setFechaFinal(finish);

    //Postcondiciones
    assert (intTiempoTotal > 0): "El tiempo total es inferior o igual a 0.";
    assert (intTiempoTotal%2 == 0): "El tiempo total es impar.";

  }

  //muestra las variables del intervalo
   public void iMostrar() {
    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Interval:", "", intFechaInicial, "", intFechaFinal, "", intTiempoTotal);
    intTareaSuperior.aMostrar();
  }

  public JSONObject getJSON() {
    JSONObject jo = new JSONObject(); //JSONArray();
    try {
      jo.put("class", intClase);
      jo.put("initialDate", intFechaInicial);
      jo.put("finalDate", intFechaFinal);
      jo.put("duration", intTiempoTotal);
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
