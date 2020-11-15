package timetracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;
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

  public Actividad(String name, Proyecto p, String clase) {
    this.actNombre = name;
    this.actProyectoSuperior = p;
    this.actTiempoTotal = -100; //un valor muy pequeño para trabajar con él
    this.actClase = clase;

    assert actInvariant(): "Invariante";
  }

  protected boolean actInvariant() {
    return actTiempoTotal == -100 || (actTiempoTotal > 0 && actTiempoTotal % 2 == 0);
  }

  public String getNombre() {
    assert actInvariant(): "Invariante";
    return this.actNombre;
  }

  public String getFechaInicial() {

    assert actInvariant(): "Invariante";
    return this.actFechaInicial;
  }

  public String getFechaFinal() {

    assert actInvariant(): "Invariante";
    return this.actFechaFinal;
  }

  public int getTiempoTotal() {

    assert actInvariant(): "Invariante";
    return this.actTiempoTotal;
  }

  public Proyecto getProyectoSuperior() {

    assert actInvariant(): "Invariante";
    return this.actProyectoSuperior;
  }

  //Asignas la fecha inicial de la actividad y de sus proyectos superiores si los tuviera
  public void setFechaInicial(LocalDateTime start) {
    assert actInvariant(): "Invariante";

    if (this.actLdtFechaInicial == null) {
      this.actLdtFechaInicial = start;
      //Le damos el formato deseado al String fecha_inicial
      actFechaInicial = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    if (actProyectoSuperior != null) {
      actProyectoSuperior.setFechaInicial(start);
    }

    assert actInvariant(): "Invariante";
  }

  /*Asignas la fecha final y el tiempo total de la actividad
  Tambien de us proyectos superiores si los tuviera*/
  public void setFechaFinal(LocalDateTime finish) {
    assert actInvariant(): "Invariante";

    assert (finish.isAfter(actLdtFechaInicial)) : "El tiempo final es inferior al tiempo inicial.";

    actLdtFechaFinal = finish;
    actFechaFinal = finish.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    this.actTiempoTotal = setTiempoTotal();


    //Actualizamos el tiempo final y total del proyecto superior
    if (actProyectoSuperior != null) {
      this.actProyectoSuperior.setFechaFinal(finish);
    }
    assert actInvariant(): "Invariante";
  }

  //Calcula el tiempo total, cada subtarea a su manera
  public abstract int setTiempoTotal();

  //muestra por pantalla los datos de la actividad
  public void actMostrar() {
    assert actInvariant(): "Invariante";

    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Actividad:",
        actNombre, actFechaInicial, "", actFechaFinal, "", actTiempoTotal);
    if (actProyectoSuperior != null) {
      actProyectoSuperior.actMostrar();
    }

    assert actInvariant(): "Invariante";
  }

  public abstract JSONObject getJson();
}

