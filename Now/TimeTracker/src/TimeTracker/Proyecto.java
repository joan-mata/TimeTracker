package timetracker;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*Clase proyecto extendidad de Actividad
Es utilizada para generalizar las partes de un trabajo o entrega.
Tiene acceso a una lista de sus proyectos inferiores, en el caso que tuviese. 
Lo mismo con las tareas que pudieran depender de él.*/
public class Proyecto extends Actividad {
  private ArrayList<Tarea> proListaTareas;
  private ArrayList<Proyecto> proListaProyectos;
  
  private static final Logger logger = LoggerFactory.getLogger(Proyecto.class);

  //CONSTRUCTORES
  public Proyecto(String name, Proyecto p) {
    super(name, p, "Proyecto");
    this.proListaTareas = new ArrayList<Tarea>();
    this.proListaProyectos = new ArrayList<Proyecto>();
    if (this.getProyectoSuperior() != null) {
      this.getProyectoSuperior().anadirProyecto(this);
    }

    assert actInvariant() : "Invariante";
  }

  public Proyecto(String name, Proyecto p, Reloj r) {
    super(name, p, "Proyecto", r);
    this.proListaTareas = new ArrayList<Tarea>();
    this.proListaProyectos = new ArrayList<Proyecto>();
    if (this.getProyectoSuperior() != null) {
      this.getProyectoSuperior().anadirProyecto(this);
    }

    assert actInvariant() : "Invariante";
  }

  public void anadirTarea(Tarea t) {
    assert actInvariant() : "Invariante";
    proListaTareas.add(t);
    assert actInvariant() : "Invariante";
  }

  public void anadirProyecto(Proyecto p) {
    assert actInvariant() : "Invariante";
    proListaProyectos.add(p);
    assert actInvariant() : "Invariante";

  }

  //Calcula el tiempo total del proyecto
  @Override
  public int setTiempoTotal() {   
    assert actInvariant() : "Invariante";
    
    logger.debug("Tiempo de proyecto calculado.");
    logger.trace("Estoy en el método setTiempoTotal de la clase Proyecto.");

    int totalTime = 0;
    int k;
    for (int i = 0; i < proListaTareas.size(); i++) {
      k = proListaTareas.get(i).setTiempoTotal();
      if (k > 0) { //Prevenir que no sume con tiempoTotal sin inicializar (=-100)
        totalTime += k;
      }
    }
    for (int i = 0; i < proListaProyectos.size(); i++) {
      k = proListaProyectos.get(i).setTiempoTotal();
      if (k > 0) { //Prevenir que no sume con tiempoTotal sin inicializar (=-100)
        totalTime += k;
      }
    }

    logger.debug("{}", totalTime);

    assert actInvariant() : "Invariante";
    return totalTime;
  }

  @Override
  public boolean searchFlag() {
    assert actInvariant() : "Invariante";
    boolean flag = false;
    int i = 0;
    while (i < proListaTareas.size() && !flag) {
      flag = proListaTareas.get(i).searchFlag();
      i++;
    }
    i = 0;
    while (i < proListaProyectos.size() && !flag) {
      flag = proListaProyectos.get(i).searchFlag();
      i++;
    }
    assert actInvariant() : "Invariante";
    return flag;
  }

  //Crea un objeto JSON con los datos del proyecto 
  //y un array JSON con los datos de los proyectos, tareas e intervalos hijos
  @Override
  public JSONObject getJson() {      
    assert actInvariant() : "Invariante";
        
    logger.info("Generando JSON...");
    logger.trace("Estoy en el método getJson de la clase Proyecto.");
    
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
      logger.error("{}", e);
    }
    assert actInvariant() : "Invariante";
    return jo;
  }
  
}