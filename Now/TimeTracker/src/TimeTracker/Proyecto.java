package TimeTracker;

import org.json.*;
import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;


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
      this.getProyectoSuperior().añadirProyecto(this);
    }
  }


  //FUNCIONES
  public void añadirTarea(Tarea t) {
    proListaTareas.add(t);
  }

  public void añadirProyecto(Proyecto p) {
    proListaProyectos.add(p);
  }

  public void eliminarTarea(Tarea t) {
    proListaTareas.remove(t);
  }

  public void eliminarProyect(Proyecto p) {
    proListaProyectos.remove(p);
  }

  //Calcula el tiempo total del proyecto
  @Override
  public int setTiempoTotal() { //MAL - Demasiada memoria
    int totalTime = 0;
    for (int i = 0; i < proListaTareas.size(); i++) {
      totalTime += proListaTareas.get(i).setTiempoTotal();
    }
    for (int i = 0; i < proListaProyectos.size(); i++) {
      totalTime += proListaProyectos.get(i).setTiempoTotal();
    }

    assert (totalTime >= getTiempoTotal()): "El tiempo total futuro es inferior al tiempo total anterior.";

    return totalTime;
  }

  @Override
  public JSONObject getJSON(){
    JSONObject jo = new JSONObject();
    try {
      jo.put("name", getNombre());
      jo.put("class", "Proyecto");
      jo.put("initialDate", getFechaInicial());
      jo.put("finalDate", getFechaFinal());
      jo.put("duration", getTiempoTotal());
      JSONArray ja = new JSONArray();
      for (int i = 0; i < proListaProyectos.size(); i++) {
        ja.put(proListaProyectos.get(i).getJSON());
      }
      for (int i = 0; i < proListaTareas.size(); i++) {
        ja.put(proListaTareas.get(i).getJSON());
      }
      jo.put("activities", ja);
    } catch (JSONException e) {

    }
    return jo;
  }
  
}