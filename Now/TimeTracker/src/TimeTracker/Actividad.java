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
  private String actNombre;
  private LocalDateTime actLdtFechaInicial;
  private LocalDateTime actLdtFechaFinal;
  private String actFechaInicial;
  private String actFechaFinal;
  private int actTiempoTotal;
  private Proyecto actProyectoSuperior;
  private String actClase;
  
  Logger logger = LoggerFactory.getLogger(Actividad.class);

  public Actividad(String name, Proyecto p, String clase) { //constructor
    this.actNombre = name;
    this.actTiempoTotal = 0;
    this.actProyectoSuperior = p;
    this.actClase = clase;
  }

  //GETTERS
  public String getNombre() {
    return this.actNombre;
  }

  public String getFechaInicial() {
    return this.actFechaInicial;
  }

  public String getFechaFinal() {
    return this.actFechaFinal;
  }

  public int getTiempoTotal() {

    return this.actTiempoTotal;
  }

  public Proyecto getProyectoSuperior() {
    return this.actProyectoSuperior;
  }

  //SETTERS
  public void setNombre(String name) {
    this.actNombre = name;
  }

  //Asignas la fecha inicial de la actividad y de sus proyectos superiores si los tuviera
  public void setFechaInicial(LocalDateTime start) {
    if (this. == null) {
      this.actLdtFechaInicial = start;
      //Le damos el formato deseado al String fecha_inicial
      actFechaInicial = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    if (actProyectoSuperior != null) {
      actProyectoSuperior.setFechaInicial(start);
    }
  }

  /*Asignas la fecha final y el tiempo total de la actividad
  Tambien de us proyectos superiores si los tuviera*/
  public void setFechaFinal(LocalDateTime finish) {
  	//Precondiciones
  	assert (finish > actLdtFechaInicial): "El tiempo final es inferior al tiempo inicial.";

    actLdtFechaFinal = finish;
    actFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    this.actTiempoTotal = setTiempoTotal();

    assert (actTiempoTotal > 0): "El tiempo total es inferior o igual a 0.";
    assert (actTiempoTotal%2 == 0): "El tiempo total es impar.";

    //Actualizamos el tiempo final y total del proyecto superior
    if (actProyectoSuperior != null) {
      this.actProyectoSuperior.setFechaFinal(finish);
    }
  }

  //Calcula el tiempo total, cada subtarea a su manera
  abstract public int setTiempoTotal();

  //muestra por pantalla los datos de la actividad
  public void aMostrar() {
    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Actividad:",
        actNombre, actFechaInicial, "", actFechaFinal, "", actTiempoTotal);
    if (actProyectoSuperior != null) {
      actProyectoSuperior.aMostrar();
    }
  }

  abstract public JSONObject getJSON();
}

