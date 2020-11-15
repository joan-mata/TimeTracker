package timetracker;

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*Clase proyecto extendidad de Actividad
Es utilizada para generalizar las partes de un trabajo o entrega.
Tiene acceso a una lista de sus proyectos inferiores, en el caso que tuviese. 
Lo mismo con las tareas que pudieran depender de él.*/
public class Proyecto extends Actividad {
  private ArrayList<Tarea> proListaTareas;
  private ArrayList<Proyecto> proListaProyectos;
  
  Logger logger = LoggerFactory.getLogger(Proyecto.class);

  //CONSTRUCTORES
  public Proyecto(String name, Proyecto p) {
    super(name, p, "Proyecto");
    this.proListaTareas = new ArrayList<Tarea>();
    this.proListaProyectos = new ArrayList<Proyecto>();
    if (this.getProyectoSuperior() != null) {
      this.getProyectoSuperior().anadirProyecto(this);
    }

    assert actInvariant(): "Invariante";
  }


  //FUNCIONES
  public void anadirTarea(Tarea t) {
    assert actInvariant(): "Invariante";
    proListaTareas.add(t);
    assert actInvariant(): "Invariante";
  }

  public void anadirProyecto(Proyecto p) {
    assert actInvariant(): "Invariante";
    proListaProyectos.add(p);
    assert actInvariant(): "Invariante";

  }

  //Calcula el tiempo total del proyecto
  @Override
  public int setTiempoTotal() {
    assert actInvariant(): "Invariante";

    int totalTime = 0;
    for (int i = 0; i < proListaTareas.size(); i++) {
      totalTime += proListaTareas.get(i).setTiempoTotal();
    }
    for (int i = 0; i < proListaProyectos.size(); i++) {
      totalTime += proListaProyectos.get(i).setTiempoTotal();
    }

    assert (totalTime >= getTiempoTotal()) :
        "El tiempo total futuro es inferior al tiempo total anterior.";

    assert actInvariant(): "Invariante";
    return totalTime;
  }

  @Override
  public JSONObject getJson() {
    assert actInvariant(): "Invariante";
    JSONObject jo = new JSONObject();
    try {
      jo.put("name", getNombre());
      jo.put("class", "Proyecto");
      jo.put("initialDate", getFechaInicial());
      jo.put("finalDate", getFechaFinal());
      jo.put("duration", getTiempoTotal());
      JSONArray ja = new JSONArray();
      for (int i = 0; i < proListaProyectos.size(); i++) {
        ja.put(proListaProyectos.get(i).getJson());
      }
      for (int i = 0; i < proListaTareas.size(); i++) {
        ja.put(proListaTareas.get(i).getJson());
      }
      jo.put("activities", ja);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    assert actInvariant(): "Invariante";
    return jo;
  }
  
}