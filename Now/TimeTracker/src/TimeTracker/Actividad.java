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
  private Reloj actReloj;
  
  private static final Logger logger = LoggerFactory.getLogger(Actividad.class);

  public Actividad(String name, Proyecto p, String clase) {
    this.actNombre = name;
    this.actProyectoSuperior = p;
    this.actTiempoTotal = -100; //un valor muy pequeño para trabajar con él
    this.actClase = clase;
    assert actInvariant(): "Invariante";
  }

  public Actividad(String name, Proyecto p, String clase, Reloj r) {
    this.actNombre = name;
    this.actProyectoSuperior = p;
    this.actTiempoTotal = -100; //un valor muy pequeño para trabajar con él
    this.actClase = clase;
    assert (p == null) : "No es ROOT";
    this.actReloj = r;
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

    logger.debug("Fecha inicial asignada.");
    logger.trace("Estoy en el método setFechaInicial de la clase Actividad.");
    
    if (this.actLdtFechaInicial == null) {
      this.actLdtFechaInicial = start;
      //Le damos el formato deseado al String fecha_inicial
      actFechaInicial = actLdtFechaInicial.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    if (actProyectoSuperior != null) {
      actProyectoSuperior.setFechaInicial(actLdtFechaInicial);
    }

    logger.debug("{}", actFechaInicial);

    assert actInvariant(): "Invariante";
  }

  /*Asignas la fecha final y el tiempo total de la actividad
  Tambien de us proyectos superiores si los tuviera*/
  public void setFechaFinal(LocalDateTime finish) {
    assert actInvariant(): "Invariante";

    logger.debug("Fecha final asignada.");
    logger.debug("Tiempo total asignado.");
    logger.trace("Estoy en el método setFechaFinal de la clase Actividad.");

    assert (finish.isAfter(actLdtFechaInicial)) : "El tiempo final es inferior al tiempo inicial.";

    actLdtFechaFinal = finish;
    actFechaFinal = actLdtFechaFinal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    this.actTiempoTotal = setTiempoTotal();

    logger.debug("{}", actFechaFinal);


    //Actualizamos el tiempo final y total del proyecto superior
    if (actProyectoSuperior != null) {
      this.actProyectoSuperior.setFechaFinal(actLdtFechaFinal);
    }
    assert actInvariant(): "Invariante";
  }

  //Calcula el tiempo total, cada subtarea a su manera
  public abstract int setTiempoTotal();

  public void setActReloj() {
    logger.debug("SetActReloj()");
    if (actProyectoSuperior == null) {
      logger.debug("CHANGEFLAG()");
      actReloj.changeFlag(searchFlag());
    }
    else {
      actProyectoSuperior.setActReloj();
    }
  }
  public abstract boolean searchFlag();

  //muestra por pantalla los datos de la actividad
  public void actMostrar() {
    assert actInvariant(): "Invariante";
    
    logger.trace("Estoy en el método actMostra de la clase Actividad.");

    logger.info("Interval: (n){} (f.i){} (f.f){} (t.t){}", actNombre, actFechaInicial, actFechaFinal, actTiempoTotal);

    if (actProyectoSuperior != null) {
      actProyectoSuperior.actMostrar();
    }

    assert actInvariant(): "Invariante";
  }

  public abstract JSONObject getJson();
}

