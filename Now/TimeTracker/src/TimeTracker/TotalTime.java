package timetracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TotalTime {
  private LocalDateTime ttLdtTiempoInicial;
  private LocalDateTime ttLdtTiempoFinal;
  private Actividad ttActividad;
  private static final Logger logger = LoggerFactory.getLogger(TotalTime.class);

  public TotalTime(Actividad root) {
    this.ttActividad = root;
    assert ttInvariant() : "Invariante";
  }

  public TotalTime(Actividad root, int ini, int fin) {
    this.ttActividad = root;
    this.ttLdtTiempoInicial = root.getLdtFechaInicial().plusSeconds(ini);
    this.ttLdtTiempoFinal = root.getLdtFechaInicial().plusSeconds(fin);
    assert ttInvariant() : "Invariante";
  }

  protected boolean ttInvariant() {
    return ttActividad.getProyectoSuperior() == null;
  }

  public int getTtTotalTime(Actividad a) {
    logger.trace("Estoy en el método getTtTotalTime de la clase TotalTime");
    logger.debug("Actividad {}", a);
    assert ttInvariant() : "Invariante";
    assert (ttLdtTiempoInicial != null) : "Tiempo inicial és null";
    assert (ttLdtTiempoFinal != null) : "Tiempo final és null";
    return a.getTtTotalTime(ttLdtTiempoInicial, ttLdtTiempoFinal);
  }

  public int getTtTotalTime(Actividad a, int ini, int fin) {
    logger.trace("Estoy en el método getTtTotalTime de la clase TotalTime");
    logger.debug("Actividad {}", a);
    assert ttInvariant() : "Invariante";
    this.ttLdtTiempoInicial = ttActividad.getLdtFechaInicial().plusSeconds(ini);
    this.ttLdtTiempoFinal = ttActividad.getLdtFechaInicial().plusSeconds(fin);
    assert ttInvariant() : "Invariante";
    return a.getTtTotalTime(ttLdtTiempoInicial, ttLdtTiempoFinal);
  }

}