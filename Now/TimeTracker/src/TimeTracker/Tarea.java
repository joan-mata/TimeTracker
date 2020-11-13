package TimeTracker;


import org.json.*;
import java.lang.Object;
import java.lang.Exception;
import java.util.ArrayList;
import java.time.LocalDateTime;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*Clase Tarea, extendida de Actividad
Su función es dividir una clase proyecto en partes más pequeñas, y con ello más sencillas de trabajar.
Tendrá una lista de los intervalos que se han realizado durante la tarea*/
public class Tarea extends Actividad {
  private ArrayList<Intervalo> tListaIntervalos;
  private Reloj tReloj;
  
  Logger logger = LoggerFactory.getLogger(Tarea.class);

  public Tarea(String name, Proyecto p) {
    super(name, p, "Tarea");
    this.tListaIntervalos = new ArrayList<Intervalo>();
    this.getProyectoSuperior().añadirTarea(this);
  }

  //Conseguimos la instancia única del reloj
  public Reloj tGetInstance() {
    return tReloj.getInstance();
  }

  //Conseguimos el tiempo total de tarea. al sumar los tiempos de sus intervalos
  @Override
  public int setTiempoTotal() {
    int totalTime = 0;
    for (int i = 0; i < tListaIntervalos.size(); i++) {
      totalTime += tListaIntervalos.get(i).iGetTiempoTotal();
    }

    assert (totalTime >= getTiempoTotal()): "El tiempo total futuro es inferior al tiempo total anterior.";

    return totalTime;
  }

  public void añadirIntervalo(Intervalo i) {
    this.tListaIntervalos.add(i);
  }

  public void eliminarIntervalo(Intervalo i) {
    this.tListaIntervalos.remove(i);
  }

  //Inicializas el intervalo que toca, nuevo en la lista y lo muestras
  public void start() {
    LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
    Intervalo i = new Intervalo(this, hora);
    setFechaInicial(hora); //TODO Que lo haga directamente intervalo llamando a iTareaSuperior
    añadirIntervalo(i);
    tGetInstance().addObserver(i);
  }

  //Finalizamos la actividad
  public void stop() {
    Intervalo i = this.tListaIntervalos.get(this.tListaIntervalos.size() - 1);
    tGetInstance().deleteObserver(i);
  }

  @Override
  public JSONObject getJSON() {
    JSONObject jo = new JSONObject();
    try {
      jo.put("name", getNombre());
      jo.put("class", "Tarea");
      jo.put("initialDate", getFechaInicial());
      jo.put("finalDate", getFechaFinal());
      jo.put("duration", getTiempoTotal());
      JSONArray ja = new JSONArray();
      for (int i = 0; i < tListaIntervalos.size(); i++) {
        ja.put(tListaIntervalos.get(i).getJSON());
      }
      jo.put("intervals", ja);

    } catch(JSONException e) {

    }
    return jo;
  }
}