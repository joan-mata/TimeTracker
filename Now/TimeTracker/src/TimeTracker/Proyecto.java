package TimeTracker;

import org.json.*;
import java.lang.Object;
import java.util.ArrayList;
import java.time.LocalDateTime;

/*Clase proyecto extendidad de Actividad
Es utilizada para generalizar las partes de un trabajo o entrega.
Tiene acceso a una lista de sus proyectos inferiores, en el caso que tuviese. 
Lo mismo con las tareas que pudieran depender de él.*/
public class Proyecto extends Actividad {
  private ArrayList<Tarea> pListaTareas;
  private ArrayList<Proyecto> pListaProyectos;

  //CONSTRUCTORES
  public Proyecto(String name, Proyecto p) {
    super(name, p, "Proyecto");
    this.pListaTareas = new ArrayList<Tarea>();
    this.pListaProyectos = new ArrayList<Proyecto>();
    if (this.getProyectoSuperior() != null) {
      this.getProyectoSuperior().añadirProyecto(this);
    }
  }


  //FUNCIONES
  public void añadirTarea(Tarea t) {
    pListaTareas.add(t);
  }

  public void añadirProyecto(Proyecto p) {
    pListaProyectos.add(p);
  }

  public void eliminarTarea(Tarea t) {
    pListaTareas.remove(t);
  }

  public void eliminarProyect(Proyecto p) {
    pListaProyectos.remove(p);
  }

  //Calcula el tiempo total del proyecto
  @Override
  public int setTiempoTotal() { //MAL - Demasiada memoria
    int totalTime = 0;
    for (int i = 0; i < pListaTareas.size(); i++) {
      totalTime += pListaTareas.get(i).setTiempoTotal();
    }
    for (int i = 0; i < pListaProyectos.size(); i++) {
      totalTime += pListaProyectos.get(i).setTiempoTotal();
    }
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
      for (int i = 0; i < pListaProyectos.size(); i++) {
        ja.put(pListaProyectos.get(i).getJSON());
      }
      for (int i = 0; i < pListaTareas.size(); i++) {
        ja.put(pListaTareas.get(i).getJSON());
      }
      jo.put("activities", ja);
    } catch (JSONException e) {

    }
    return jo;
  }
  
}