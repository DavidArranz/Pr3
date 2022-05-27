/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr3.gestorparking;

import java.io.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author David Arranz
 */
public class Pr3GestorParking {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static Parking p = new Parking();
    static HashMap<Dueño, Boolean> d = new HashMap<>();
    static ArrayList<String> entradas = new ArrayList<>();
    static final String PATH = "/home/alumno/Documentos/Programacion/ficherosProgramas/Proyecto3/";
    static final String PATH_PT1 = "/home/alumno/Documentos/Programacion/ficherosProgramas/Proyecto3/pt1";
    static final String PATH_D = "/home/alumno/Documentos/Programacion/ficherosProgramas/Proyecto3/d";
    static final String PATH_ENTRADAS = "/home/alumno/Documentos/Programacion/ficherosProgramas/Proyecto3/entradas";

    public static void main(String[] args) throws Exception {
        /*
            ELEMENTOS A LEER
        -Array<Vehiculo>: pt1
        -HashMap<boolean,Dueño>: d
        -ArrayList<String>: entradas
         */
        int op;
        File dir = new File(PATH);
        if (!dir.exists()) {
            dir.mkdir();
        } else {
        if (Files.exists(Paths.get(PATH_PT1))) {
            FileInputStream fis = new FileInputStream(PATH_PT1);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Parking.setPt1((Vehiculo[]) ois.readObject());
        }
        if (Files.exists(Paths.get(PATH_D))) {
            FileInputStream fis = new FileInputStream(PATH_D);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Dueño> hola = (ArrayList) ois.readObject();
            System.out.println(hola);
        }//Dueño.setD((HashMap<Boolean, Dueño>)
        if (Files.exists(Paths.get(PATH_ENTRADAS))) {
            FileInputStream fis = new FileInputStream(PATH_ENTRADAS);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vehiculo.setEntradas((ArrayList<String>) ois.readObject());
        }}

        //addDueños();
        while (true) {
            try {
                A:
                while (true) {
                    menu();
                    System.out.print("Introduce al opcion a realizar: ");
                    op = sc.nextInt();
                    switch (op) {
                        case 1:
                            if (p.getPlazas_lib() > 0) {
                                asignarPlaza();
                            } else {
                                System.out.println("Todas las plazas estan ocupadas");
                            }
                            break;
                        case 2:
                            desasignarPlaza();
                            break;
                        case 3:
                            verDisp();
                            break;
                        case 4:
                            buscarCoche();
                            break;
                        case 5:
                            datosPorPlaza();
                            break;
                        case 6:
                            estadisticas();
                            break;
                        case 7:
                            op7();
                            break;
                        case 8:
                            System.out.println("Desea guardar los cambios realizados?[s/n]");
                            String temp = sc.next();
                            if (temp.equals("s") || temp.equals("S")) {
                                opPT1();
                            } else if (!temp.equals("n") && !temp.equals("N")) {
                                System.out.println("Opcion invalida");
                                break;
                            }
                            break A;
                        default:
                            System.out.print("ERROR: opcion invalida");
                    }
                }

            } catch (InputMismatchException ex1) {
                System.out.println("ERROR: has introducido un tipo de dato inesperado.");
              sc.nextLine();
            }
        }
    }

    static public void menu() {
        System.out.println("1. Asignar\n"
                + "2. Desasignar\n"
                + "3. Disponibilidad\n"
                + "4. Buscar coche\n"
                + "5. Datos de un coche\n"
                + "6. Estadisticas\n"
                + "7. Gestion de dueños\n"
                + "8. Salir");
    }

    static public void menu3() {
        System.out.println("1. Plazas disponibles en el piso superior\n"
                + "2. Plazas disponibles en el piso inferior\n"
                + "3. Plazas disponibles en total");
    }

    static public void menu6() {
        System.out.println("Mostrar el numero de coches por...\n"
                + "1-Numero de coches de una marca en el parking\n"
                + "2-Numero de cohes del color en el parking\n"
                + "3-Numero de coches en una franja horaria");
    }

    static public void menu7() {
        System.out.println("1. Añadir dueño\n"
                + "2. Consultar disponibilidad de plazas\n"
                + "3. Mostrar datos por plaza"
                + "4. Saber plaza por dni\n");
    }

    public static void addDueños() throws Exception {
        String dni, nom, ap, dir, tel, cuenta_bank;
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el dni del Dueño");
            dni = sc.next();
            System.out.println("Introduce el nombre del Dueño");
            nom = sc.next();
            System.out.println("Introduce el primer apellido del Dueño");
            ap = sc.next();
            System.out.println("Introduce la direccion del Dueño");
            dir = sc.next();
            System.out.println("Introduce el dni del Dueño");
            tel = sc.next();
            System.out.println("Introduce la cuenta bancaria del Dueño");
            cuenta_bank = sc.next();
            new Dueño(dni, nom, ap, dir, tel, cuenta_bank);
        }
    }

    static public void asignarPlaza() {
        String fyh_entrada, dni, matricula, marca, modelo, color, descripcion, fyj_entrada;
        boolean desperfectos;

        System.out.println("Introduce la matricula");
        matricula = sc.next();
        if (p.buscarPorMatricula(matricula) != -1) {
            p.setPlazas_lib(p.getPlazas_lib() - 1);
            p.addcar(p.getVehiculo(p.buscarPorMatricula(matricula)));
        } else {
            System.out.println("Introduce el dni del conductor");
            dni = sc.next();
            System.out.println("Introduce la marca");
            marca = sc.next();
            System.out.println("Introduce el modelo");
            modelo = sc.next();
            System.out.println("Introduce el color");
            color = sc.next();
            System.out.println("Introduce si tiene o no desperfectos [s/n]: ");
            String temp = sc.next();
            if (temp.equals("s") || temp.equals("S")) {
                desperfectos = true;
                System.out.println("Introduce la descripcion de estos");
                descripcion = sc.nextLine();
                sc.nextLine();
            } else if (temp.equals("n") || temp.equals("N")) {
                desperfectos = false;
                descripcion = null;
            } else {
                throw new IllegalArgumentException("ERROR: la respuesta a de ser 's' o 'n'");
            }
            p.setPlazas_lib(p.getPlazas_lib() - 1);
            p.addcar(new Vehiculo(dni, matricula, marca, modelo, color, desperfectos, descripcion));
        }
    }

    static public void desasignarPlaza() {
        System.out.println("Introduce la matricula del Vehiculo: ");
        String m = sc.next();
        System.out.println("Introduzca el dni");
        String dni = sc.next();
        if (p.delcar(m, dni) == -1) {
            throw new IllegalArgumentException("El dni no esta asociado a la matricula");
        } else {
            System.out.println("Vehiculo desasignado con exito");
        }

    }

    static public void verDisp() {
        int op;
        menu3();
        System.out.println("introduce la opcion:");
        op = sc.nextInt();

        switch (op) {
            case 1:
                System.out.println(p.getPlazasLibresSup());
                break;
            case 2:
                System.out.println(p.getPlazasLibresInf());
                break;
            case 3:
                System.out.println(p.getPlazasLibresSup() + p.getPlazasLibresInf());
                break;
            default:
                System.out.print("ERROR: opcion incorrecta.");
        }

    }

    static public void buscarCoche() {
        String dni;
        System.out.println("Introduce el dni del conductor");
        dni = sc.next();
        if (p.buscarPorDni(dni)) {
            System.out.println("Su coche no se encuentra en el parking");
        } else {
            System.out.println("Su coche se encuentra en la plaza " + p.plazaPorDni(dni));
        }
    }

    static public void datosPorPlaza() {
        System.out.println("Introduce la plaza [1-50]");
        int plaza = sc.nextInt() - 1;
        if (p.mostrarCoche(plaza) == null) {
            System.out.println("La plaza esta vacia");
        } else {
            System.out.println(p.mostrarCoche(plaza));
        }
    }

    static public void estadisticas() {
        String marca, color;
        int n;
        menu6();
        int op = sc.nextInt();
        if (op == 1) {
            System.out.println("Introduce la marca");
            marca = sc.next();
            n = p.recuentoPorMarca(marca);
            if (n == 0) {
                System.out.println("No hay coches de esta marca en el parking");
            } else {
                System.out.println("Hay " + n + " coches de la marca " + marca);
            }
        } else if (op == 2) {
            System.out.println("Introduce el color");
            color = sc.next();
            n = p.recuentoPorColor(color);
            if (n == 0) {
                System.out.println("No hay coches de esta marca en el parking");
            } else {
                System.out.println("Hay " + n + " coches de la marca " + color);
            }
        } else if (op == 3) {
            entradas();
        } else {
            System.out.println("Error: opcion incorrecta");
        }
    }

    static public void entradas() {

        System.out.println("Introduzca la fecha menor [yyyy-MM-dd-hh-mm-ss]:");
        String f1 = sc.next();
        if (!dateFormatCheck(f1)) {
            throw new IllegalArgumentException("ERROR: la fecha no tiene el formato esperado");
        }
        System.out.println("Introduzca la fecha mayor [yyyy-MM-dd-hh-mm-ss]:");
        String f2 = sc.next();
        if (!dateFormatCheck(f2)) {
            throw new IllegalArgumentException("ERROR: la fecha no tiene el formato esperado");
        }

        System.out.println(p.calculoEntradas(f1, f2) + " vehiculos");

    }

    static public boolean dateFormatCheck(String f) {
        Pattern pattern = Pattern.compile("[0-9]{4}-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1])-([0-1][0-9]|2[0-4])(-[0-5][0-9]){2}");
        return pattern.matcher(f).matches();
    }

    static public void opPT1() {
        try {
            if (Parking.getPt1().length != 0) {
                FileOutputStream fos1 = new FileOutputStream(PATH_PT1, false);
                ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                oos1.writeObject(Parking.getPt1());
                oos1.close();
            }else{
                File pt1 = new File(PATH_PT1);
                if(pt1.exists()){
                    pt1.delete();
                }
            }
            if (d.size() != 0) {
                FileOutputStream fos2 = new FileOutputStream(PATH_D, false);
                ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
                oos2.writeObject(d);
                oos2.close();
            }else{
                File d = new File(PATH_D);
                if(d.exists()){
                    d.delete();
                }
            }

            if (Vehiculo.getEntradas().size() != 0) {
                FileOutputStream fos3 = new FileOutputStream(PATH_ENTRADAS, false);
                ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
                oos3.writeObject(Vehiculo.getEntradas());
                oos3.close();
            }else{
                File entradas = new File(PATH_ENTRADAS);
                if(entradas.exists()){
                    entradas.delete();
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void op7() {
        menu7();
        System.out.println("Introduce una opcion");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                if (d.size() == 10) {
                    System.out.println("ERROR: ya hay 10 dueños registrados");
                } else {
                    addD();
                }
                break;
            case 2:
                consultarDisp();
                break;
            case 3:
                System.out.println("Introduce el numero de ");
                consultarPlaza(sc.nextInt());
                break;
            case 4:
                System.out.println("Introduce el dni");
                PlazaPorDni(sc.next());
                break;
            default:
                System.out.println("ERROR: opcion invalida");
        }
    }

    public static void addD() {
        String dni, nom, ap, dir, tel, cuenta_bank;
        System.out.println("Introduce el dni");
        dni = sc.next();
        System.out.println("Introduce el nombre");
        nom = sc.next();
        System.out.println("Introduce el apellido");
        ap = sc.next();
        System.out.println("Introduce la direccion");
        dir = sc.next();
        System.out.println("Introduce el telefono");
        tel = sc.next();
        System.out.println("Introduce la cuenta bancaria");
        cuenta_bank = sc.next();
        try {
            d.put(new Dueño(dni, nom, ap, dir, tel, cuenta_bank), false);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void consultarDisp() {
        int i = 10;
        for (boolean b : d.values()) {
            if (b == true) {
                i--;
            }
        }
        System.out.println("Hay " + i + " plazas disponibles;");
    }
    /***
    * Busca la plaza introducida por argumento en el keyset del HashMap,
    * si p no coincide con ninguna plaza o la plaza no esta ocupada lo indica.
    * @param p 
    */
    public static void consultarPlaza(int p) {
        int i = 0;
        boolean bool = false;
        if(p>10||p<1){}
        else{
        for (Dueño b : d.keySet()) {
            if (i == p - 1 && d.get(b) == true) {
                System.out.println(b.toString());
                bool = true;
            }
        }
        }
        if (!bool) {
            System.out.println("La plaza no esta ocupada");
        }
    }
    /***
     * El metodo compara el argumento con cada uno de los dni de los dueños en el hashmap de dueños
     * Si los dni coinciden, se imprime la posicion del dueño en el hashmap.
     * @param dni 
     */
    public static void PlazaPorDni(String dni) {
        int i = 0;
        for (Dueño b : d.keySet()) {
            if (b.getDni().equals(dni)) {
                i++;
                System.out.println("El dueño tiene la plaza " + i + " reservada.");
            }
        }
    }

}
