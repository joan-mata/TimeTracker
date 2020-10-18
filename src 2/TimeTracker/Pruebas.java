package TimeTracker;

//FUNCIONES
public void comprueba_getters(){ //Incluir en Proyecto y Actividad
    System.out.println("Nombre: " + this.get_nombre() + "\n");
    System.out.println("Proyecto Superior: " + this.get_proyecto() + "\n");
    System.out.println("F. Inicio: " + this.get_fecha_inicial() + "\n");
    System.out.println("F. Final: " + this.get_fecha_final() + "\n");
    System.out.println("T. Total: " + this.get_tiempo_total() + "\n");
}

public void comprueba_getters(){ //Incluir en Tarea
    System.out.println("Nombre: " + this.get_nombre() + "\n");
    System.out.println("F. Inicio: " + this.get_fecha_inicial() + "\n");
    System.out.println("F. Final: " + this.get_fecha_final() + "\n");
    System.out.println("T. Total: " + this.get_tiempo_total() + "\n");
}

public void comprueba_setters(String name, Proyecto p, String initial, String end, int time){ //Incluir en Proyecto y Actividad
    this.set_nombre(name);
    this.set_proyecto(p);
    this.set_fecha_inicial(initial);
    this.set_fecha_final(end);
    this.set_tiempo_total(time);

    comprueba_getters();
}

public void comprueba_setters(String name, Proyecto p, String initial, String end, int time){ //Incluir en Tarea
    this.set_nombre(name);
    this.set_fecha_inicial(initial);
    this.set_fecha_final(end);
    this.set_tiempo_total(time);

    comprueba_getters();
}

//MAIN

//1.- Comprobar constructores y getter (Proyecto y Tarea) [18-oct.-2020 19:06 DL-J]
Proyecto root = new Proyecto("root", null);
Proyecto p1 = new Proyecto("p1", root);
Tarea t1 = new Tarea("act1", root);
Tarea t2 = new Tarea("act2", p1);

System.out.println("ROOT\n");
root.comprueba_getters();
System.out.println("\nP1\n");
p1.comprueba_getters();
System.out.println("\nT1\n");
t1.comprueba_getters();
System.out.println("\nT2\n");
t2.comprueba_getters();

//2.- Comprobar setters (Proyecto y Tarea) [null]







/**********PRUEBAS ANTERIOIRES MAL CODIFICADO *************/
/*
//1.- Comprobar constructores y getters (Proyecto/Actividad) [18-oct.-2020 12:00]
Proyecto root = new Proyecto("root", null);
Proyecto p1 = new Proyecto("p1", root);
Actividad act1 = new Actividad("act1", root);
Actividad act2 = new Actividad("act2", p1);

System.out.println("ROOT\n");
root.comprueba_getters();
System.out.println("\nP1\n");
p1.comprueba_getters();
System.out.println("\nACT1\n");
act1.comprueba_getters();
System.out.println("\nACT2\n");
act2.comprueba_getters();

//2.- Comprobar Setters (Proyecto/Actividad) [18-oct.-2020 12:00]
Proyecto root = new Proyecto("root", null);
Proyecto p1 = new Proyecto("p1", root);
Actividad act1 = new Actividad("act1", root);
Actividad act2 = new Actividad("act2", p1);

System.out.println("ROOT\n");
root.comprueba_setters("RootPrueba", p1, "Hoy-26-Junio", "Ayer-35-Mayo", 24);
System.out.println("\nP1\n");
p1.comprueba_setters("P1Prueba", null, "Mañana-13-Enero", "AnteAyer-25-Diciembre", 4);
System.out.println("\nACT1\n");
act1.comprueba_setters("ACT1Prueba", p1, "Pasado-50-Febrero", "Subjuntivo-12-Julio", 15);
System.out.println("\nACT2\n");
act2.comprueba_setters("ACT2Prueba", root, "Futuro-42-Marzo", "Condicional-28-Abril", 60);

//3.- Comprobar set_completo (Proyecto/Actividad) [18-oct.-2020 13:17]
Proyecto root = new Proyecto("root", null);
Proyecto p1 = new Proyecto("p1", root);
Actividad act1 = new Actividad("act1", root);
Actividad act2 = new Actividad("act2", p1);

System.out.println("ROOT\n");
root.set_completo("RootPrueba", p1, "Hoy-26", "35-Mayo", 24);
root.comprueba_getters();
System.out.println("\nP1\n");
p1.set_completo("P1Prueba", null, "Mañana-13", "25-Diciembre", 4);
p1.comprueba_getters();
System.out.println("\nACT1\n");
act1.set_completo("ACT1Prueba", p1, "Pasado-50", "12-Julio", 15);
act1.comprueba_getters();
System.out.println("\nACT2\n");
act2.set_completo("ACT2Prueba", root, "Futuro-42", "28-Abril", 60);
act2.comprueba_getters();

//4.- Modificamos Proyecto [18-oct.-2020 13:53]
Proyecto root = new Proyecto("root", null);
Proyecto p1 = new Proyecto("p1", root);
Proyecto p2 = new Proyecto("p2", root);

System.out.println("\nROOT\n");
root.set_completo("ROOT", p1, "Ayer-13", "24-Enero", 11);
root.comprueba_getters();

System.out.println("\nP1\n");
p1.set_completo("P1", p1, "Hoy-26", "35-Mayo", 24);
p1.comprueba_getters();

System.out.println("\nP2\n");
p2.set_completo("P2", p1, "Mañana-43", "15-Julio", 38);
p2.comprueba_getters();

System.out.println("\nCAMBIO P1 por P2\n");
p1.modificar_proyecto(p2);
p1.comprueba_getters();

System.out.println("\nCAMBIO P2 por ROOT\n");
p2.modificar_proyecto(root);
p2.comprueba_getters();

//5.- Modificamos Actividad [null]
Proyecto root = new Proyecto("root", null);
Proyecto p1 = new Proyecto("p1", root);
Actividad act1 = new Actividad("act1", root);
Actividad act2 = new Actividad("act2", p1);
Actividad act3 = new Actividad("act3", p1);

System.out.println("\nACT1\n");
act1.set_completo("ACT1", p1, "Ayer-13", "24-Enero", 11);
act1.comprueba_getters();

System.out.println("\nACT2\n");
act2.set_completo("ACT2", p1, "Hoy-26", "35-Mayo", 24);
act2.comprueba_getters();

System.out.println("\nACT3\n");
act3.set_completo("ACT3", p1, "Mañana-43", "15-Julio", 38);
act3.comprueba_getters();

System.out.println("\nCAMBIO ACT1 por ACT2\n");
act1.modificar_actividad(act2);
act1.comprueba_getters();

System.out.println("\nCAMBIO ACT2 por ACT3\n");
act2.modificar_actividad(act3);
act2.comprueba_getters();

//6.- Comprobamos constructores, getters y setters (Tarea) [null]
Tarea t1 = new Tarea("T1");
Tarea t2 = new Tarea("T2");

System.out.println("T1\n");
t1.comprueba_getters();
t1.comprueba_setters("T1Prueba", "Hoy-26-Junio", "Ayer-35-Mayo", 24);

System.out.println("\nT2\n");
t2.comprueba_getters();
t2.comprueba_setters("T2Prueba", "Mañana-15-Enero", "Pasado-40-Diciembre", 35);

//7.- Comprobar set_completo (Tarea) [null]
//8.- Modificar Tarea [null]
*/