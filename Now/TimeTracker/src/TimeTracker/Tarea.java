package timetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*Clase Tarea, extendida de Actividad
Su función es dividir una clase proyecto en partes más pequeñas,
y con ello más sencillas de trabajar.
Tendrá una lista de los intervalos que se han realizado durante la tarea*/
public class Tarea extends Actividad {
  private ArrayList<Intervalo> tarListaIntervalos;
  private Reloj tarReloj;
  
  private static final Logger logger = LoggerFactory.getLogger(Tarea.class);

  public Tarea(String name, Proyecto p) {
    super(name, p, "Tarea");
    this.tarListaIntervalos = new ArrayList<Intervalo>();
    this.getProyectoSuperior().anadirTarea(this);
    assert tarInvariant(): "Invariante";
  }

  public Tarea(String name, Proyecto p, Reloj r) {
    super(name, p, "Tarea", r);
    this.tarListaIntervalos = new ArrayList<Intervalo>();
    this.getProyectoSuperior().anadirTarea(this);
    assert tarInvariant(): "Invariante";
  }

  protected boolean tarInvariant() {
    return actInvariant() && this.getProyectoSuperior() != null;
  }

  //Conseguimos la instancia única del reloj
  public Reloj tarGetInstance() {
    assert tarInvariant(): "Invariante";
    return tarReloj.getInstance();
  }

  //Conseguimos el tiempo total de tarea. al sumar los tiempos de sus intervalos
  @Override
  public int setTiempoTotal() {
    assert tarInvariant(): "Invariante";

    logger.debug("Tiempo de intervalo sumado.");
    logger.trace("Estoy en el método setTiempoTotal de la clase Tarea.");

    int totalTime = 0;
    for (int i = 0; i < tarListaIntervalos.size(); i++) {
      totalTime += tarListaIntervalos.get(i).intGetTiempoTotal();
    }
    logger.debug("{}", totalTime);
    assert (totalTime >= getTiempoTotal()) :
        "El tiempo total futuro es inferior al tiempo total anterior.";
    assert tarInvariant(): "Invariante";
    return totalTime;
  }

  @Override
  public boolean searchFlag() {
    boolean flag = false;
    int i = 0;
    while (i < tarListaIntervalos.size() && !flag) {
      flag = tarListaIntervalos.get(i).isIntflag();
      i++;
    }

    return flag;
  }

  public void anadirIntervalo(Intervalo i) {

    assert tarInvariant(): "Invariante";
    this.tarListaIntervalos.add(i);
    assert tarInvariant(): "Invariante";

  }

  //Inicializas el intervalo que toca, nuevo en la lista y lo muestras
  public void start() {
    assert tarInvariant(): "Invariante";

    logger.trace("Estoy en el método start de la clase Tarea.");

    LocalDateTime hora = LocalDateTime.now();
    Intervalo i = new Intervalo(this, hora);
    //setFechaInicial(hora); //TODO Que lo haga directamente intervalo llamando a iTareaSuperior
    //anadirIntervalo(i);
    tarGetInstance().addObserver(i);
    assert tarInvariant(): "Invariante";
  }

  //Finalizamos la actividad
  public void stop() {
    assert tarInvariant(): "Invariante";

    logger.trace("Estoy en el método stop de la clase Tarea.");

    Intervalo i = this.tarListaIntervalos.get(this.tarListaIntervalos.size() - 1);
    i.stopFlag();
    tarGetInstance().deleteObserver(i);
    assert tarInvariant(): "Invariante";
  }


  //Crea un objeto JSON con los datos del proyecto 
  //y un array JSON con los datos de los intervalos hijos
  @Override
  public JSONObject getJson() {
    assert tarInvariant(): "Invariante";

    logger.info("Generando JSON...");
    logger.trace("Estoy en el método getJson de la clase Tarea.");

    JSONObject jo = new JSONObject();
    try {
      jo.put("name", getNombre());
      jo.put("class", "Tarea");
      jo.put("initialDate", getFechaInicial());
      jo.put("finalDate", getFechaFinal());
      jo.put("duration", getTiempoTotal());
      JSONArray ja = new JSONArray();
      for (int i = 0; i < tarListaIntervalos.size(); i++) {
        ja.put(tarListaIntervalos.get(i).getJson());
      }
      jo.put("intervals", ja);

    } catch (JSONException e) {
      logger.error("{}", e);
    }
    assert tarInvariant(): "Invariante";
    return jo;
  }
}