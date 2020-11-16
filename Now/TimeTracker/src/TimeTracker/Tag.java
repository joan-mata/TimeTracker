package timetracker;

import java.util.HashMap;
import java.util.ArrayList;
/*import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

public class Tag {
  private HashMap<String, String> tagList;

  //Constructor crea el HashMap vacio, con la función de anadirTag introduciremos los valores de forma que
  //cada entrada sea un tag con un proyecto/tarea como p.e:  tagList(python, databases)
  private Tag() {this.tagList = new HashMap<String, String>();}


  //¡¡¡¡¡¡¡¡FALTA IMPLEMENTAR LAS CRIDAS EN LAS OTRAS CLASES!!!!!!!!!!!!

  //Funciones

  //Introducir nombre de la actividad (proyecto o tarea): act y nombre del tag/keyword: tag
  public void anadirTag(String act, String tag) {
    //assert tagInvariant(): "Invariante";
    tagList.put(tag, act);
    //assert tagInvariant(): "Invariante";
  }

  //searchTag recorrera el HashMap buscando el tag que haya recibido y devolvera un arraylist con todos
  //los matches
  //FALTA HACERLO CASE INSENSITIVE
  public ArrayList<String> searchTag(String tag) {
    ArrayList<String> list = new ArrayList<String>();
    for (String i : tagList.keySet()) {
      if (i == tag) {
        list.add(tagList.get(i));
      }
    }
    return list;
  }

}
