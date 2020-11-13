package TimeTracker;


import org.json.*;
import java.lang.Object;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*Clase Actividad,
Su función es generalizar dos subclases (Proyecto y Tarea) */
public abstract class Actividad {
  private String aNombre;
  private LocalDateTime aLdtFechaInicial;
  private LocalDateTime aLdtFechaFinal;
  private String aFechaInicial;
  private String aFechaFinal;
  private int aTiempoTotal;
  private Proyecto aProyectoSuperior;
  private String aClase;
  
  Logger logger = LoggerFactory.getLogger(Actividad.class);

  public Actividad(String name, Proyecto p, String clase) { //constructor
    this.aNombre = name;
    this.aTiempoTotal = 0;
    this.aProyectoSuperior = p;
    this.aClase = clase;
  }

  //GETTERS
  public String getNombre() {
    return this.aNombre;
  }

  public String getFechaInicial() {
    return this.aFechaInicial;
  }

  public String getFechaFinal() {
    return this.aFechaFinal;
  }

  public int getTiempoTotal() {
    return this.aTiempoTotal;
  }

  public Proyecto getProyectoSuperior() {
    return this.aProyectoSuperior;
  }

  //SETTERS
  public void setNombre(String name) {
    this.aNombre = name;
  }

  //Asignas la fecha inicial de la actividad y de sus proyectos superiores si los tuviera
  public void setFechaInicial(LocalDateTime start) {
    if (this.aLdtFechaInicial == null) {
      this.aLdtFechaInicial = start;
      //Le damos el formato deseado al String fecha_inicial
      aFechaInicial = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    if (aProyectoSuperior != null) {
      aProyectoSuperior.setFechaInicial(start);
    }
  }

  /*Asignas la fecha final y el tiempo total de la actividad
  Tambien de us proyectos superiores si los tuviera*/
  public void setFechaFinal(LocalDateTime finish) {
  	//Precondiciones
  	assert (finish > aLdtFechaInicial): "El tiempo final es inferior al tiempo inicial.";

    aLdtFechaFinal = finish;
    aFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    this.aTiempoTotal = setTiempoTotal();

    assert (aTiempoTotal > 0): "El tiempo total es inferior o igual a 0.";
    assert (aTiempoTotal%2 == 0): "El tiempo total es impar.";

    //Actualizamos el tiempo final y total del proyecto superior
    if (aProyectoSuperior != null) {
      this.aProyectoSuperior.setFechaFinal(finish);
    }
  }

  //Calcula el tiempo total, cada subtarea a su manera
  abstract public int setTiempoTotal();

  //muestra por pantalla los datos de la actividad
  public void aMostrar() {
    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Actividad:",
        aNombre, aFechaInicial, "", aFechaFinal, "", aTiempoTotal);
    if (aProyectoSuperior != null) {
      aProyectoSuperior.aMostrar();
    }
  }

  abstract public JSONObject getJSON();
}

