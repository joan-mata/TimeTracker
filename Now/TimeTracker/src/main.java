import java.io.IOException;
import java.lang.Thread;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timetracker.*;

public class Main {
  private static Reloj Reloj;
  
  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in); //Para introducir elementos por terminal
    
    logger.trace("Estoy en el Main");
        
    Thread time = new Thread(Reloj.getInstance());
    time.start();

    Proyecto root = new Proyecto("Root", null, Reloj.getInstance());
    Proyecto softwareDesing = new Proyecto("Software design", root);
    Proyecto softwareTesting = new Proyecto("Software testing", root);
    Proyecto databases = new Proyecto("Databases", root);
    Proyecto problems = new Proyecto("Problems", softwareDesing);
    Proyecto projectTimeTracker = new Proyecto("Project time tracker", softwareDesing);

    Tarea transportation = new Tarea("transportation", root);
    Tarea firstList = new Tarea("first list", problems);
    Tarea secondList = new Tarea("second list", problems);
    Tarea readHandout = new Tarea("read handout", projectTimeTracker);
    Tarea firstMilestone = new Tarea("first milestone", projectTimeTracker);    

    Tag tags = new Tag();
    tags.anadirTag(softwareDesing.getNombre(), "java");
    tags.anadirTag(softwareDesing.getNombre(), "flutter");
    tags.anadirTag(softwareTesting.getNombre(), "c++");
    tags.anadirTag(softwareTesting.getNombre(), "Java");
    tags.anadirTag(softwareTesting.getNombre(), "python");
    tags.anadirTag(databases.getNombre(), "SQL");
    tags.anadirTag(databases.getNombre(), "python");
    tags.anadirTag(databases.getNombre(), "C++");
    tags.anadirTag(firstList.getNombre(), "java");
    tags.anadirTag(secondList.getNombre(), "Dart");
    tags.anadirTag(firstMilestone.getNombre(), "Java");
    tags.anadirTag(firstMilestone.getNombre(), "IntellJ");

    String tagSearch = "java";
    logger.info("Actividades con tag {}: {}", tagSearch, tags.searchTag(tagSearch));

    logger.info("Start Test\n");
    logger.info("Transportation starts:\n");
    transportation.start();
    sleep(4);
    transportation.stop();
    logger.info("Transportation stop\n");
    sleep(2);
    logger.info("First list starts\n");
    firstList.start();
    sleep(6);
    logger.info("Second list start\n");
    secondList.start();
    sleep(4);
    firstList.stop();
    logger.info("First list stop\n");
    sleep(2);
    secondList.stop();
    logger.info("Second list stop\n");
    sleep(2);
    logger.info("Transportation starts\n");
    transportation.start();
    sleep(4);
    transportation.stop();
    logger.info("Transportation stop\n");

    JSONObject json = root.getJson();
    String jsonString = json.toString();
    Path path = Paths.get("json.txt");
    try {
      Files.writeString(path, jsonString, StandardCharsets.UTF_8);
    } catch (IOException e) {
      logger.error("{}", e);
    }
    
    logger.info("End of test\n");
    time.stop();
  }

  public static void sleep(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      logger.error("{}", e);
    }
  }
}


