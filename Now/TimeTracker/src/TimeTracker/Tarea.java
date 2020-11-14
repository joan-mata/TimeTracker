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
  
  Logger logger = LoggerFactory.getLogger(Tarea.class);

  public Tarea(String name, Proyecto p) {
    super(name, p, "Tarea");
    this.tarListaIntervalos = new ArrayList<Intervalo>();
    this.getProyectoSuperior().anadirTarea(this);
  }

  //Conseguimos la instancia única del reloj
  public Reloj tarGetInstance() {
    return tarReloj.getInstance();
  }

  //Conseguimos el tiempo total de tarea. al sumar los tiempos de sus intervalos
  @Override
  public int setTiempoTotal() {
    int totalTime = 0;
    for (int i = 0; i < tarListaIntervalos.size(); i++) {
      totalTime += tarListaIntervalos.get(i).intGetTiempoTotal();
    }

    assert (totalTime >= getTiempoTotal()) :
        "El tiempo total futuro es inferior al tiempo total anterior.";

    return totalTime;
  }

  public void anadirIntervalo(Intervalo i) {
    this.tarListaIntervalos.add(i);
  }

  public void eliminarIntervalo(Intervalo i) {
    this.tarListaIntervalos.remove(i);
  }

  //Inicializas el intervalo que toca, nuevo en la lista y lo muestras
  public void start() {
    LocalDateTime hora = LocalDateTime.now(); //Guarda la hora actual del sistema.
    Intervalo i = new Intervalo(this, hora);
    setFechaInicial(hora); //TODO Que lo haga directamente intervalo llamando a iTareaSuperior
    anadirIntervalo(i);
    tarGetInstance().addObserver(i);
  }

  //Finalizamos la actividad
  public void stop() {
    Intervalo i = this.tarListaIntervalos.get(this.tarListaIntervalos.size() - 1);
    tarGetInstance().deleteObserver(i);
  }

  @Override
  public JSONObject getJson() {
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
      e.printStackTrace();
    }
    return jo;
  }
}