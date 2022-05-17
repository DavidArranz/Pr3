/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr3.gestorparking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
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
    static Planta sup = new Planta(0);
    static Planta inf = new PlantaBaja(0);

    public static void main(String[] args) {
        int op;
        A:
        while (true) {
            menu();
            System.out.print("Introduce al opcion a realizar: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    if (sup.getPlazas_lib() > 0) {
                        asignarPlaza(true);

                    } else if (inf.getPlazas_lib() > 0) {
                        asignarPlaza(false);
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
                    break A;
                default:
                    System.out.print("ERROR: opcion invalida");
            }
        }
    }

    static public void menu() {
        System.out.println("1. Asignar\n"
                + "2. Desasignar\n"
                + "3. Disponivilidad\n"
                + "4. Buscar coche\n"
                + "5. Datos de un coche\n"
                + "6. Estadisticas\n"
                + "7. Salir");
    }

    static public void menu3() {
        System.out.println("1. Plazas disponibles en el piso superior\n"
                + "2. Plazas disponibles en el piso inferior\n"
                + "3. Plazas disponibles en total");
    }
    
    static public void menu6(){
        System.out.println("Mostrar el numero de coches por...\n"
                + "1-Numero de coches de una marca en el parking\n"
                + "2-Numero de cohes del color en el parking\n"
                + "3-Numero de coches en una franja horaria");
    }

    static public void asignarPlaza(boolean piso) {
        String fyh_entrada, dni, matricula, marca, modelo, color, descripcion, fyj_entrada;
        boolean desperfectos;

        System.out.println("Introduce la matricula");
        matricula = sc.next();
        if (sup.buscarPorMatricula(matricula)!=-1&&inf.buscarPorMatricula(matricula)!=-1) {
            if (piso) {
                sup.setPlazas_lib(sup.getPlazas_lib() - 1);
                sup.addcar(sup.getVehiculo(inf.buscarPorMatricula(matricula)));
            } else {
                inf.setPlazas_lib(inf.getPlazas_lib() - 1);
                inf.addcar(inf.getVehiculo(inf.buscarPorMatricula(matricula)));
            }
        } else {
            System.out.println("Introduce el dni del conductor");
            dni = sc.next();
            System.out.println("Introduce la marca");
            marca = sc.next();
            System.out.println("Introduce el modelo");
            modelo = sc.next();
            System.out.println("Introduce el color");
            color = sc.next();
            System.out.println("Introduce si tieno o no desperfectos [s/n]: ");
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
                throw new IllegalArgumentException("ERROR: la respuesta a de se 's' o 'n'");
            }
            
            if (piso) {
                sup.setPlazas_lib(sup.getPlazas_lib() - 1);
                sup.addcar(new Vehiculo(dni, matricula, marca, modelo, color, desperfectos, descripcion));
            } else {
                inf.setPlazas_lib(inf.getPlazas_lib() - 1);
                inf.addcar(new Vehiculo(dni, matricula, marca, modelo, color, desperfectos, descripcion));
            }
        }
    }

    static public void desasignarPlaza() {
        System.out.println("Introduce la matricula del Vehiculo: ");
        String m = sc.next();
        System.out.println("Introduzca el dni");
        String dni = sc.next();
        if (sup.delcar(m, dni) == -1 && inf.delcar(m, dni) == -1) {
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
                System.out.println(sup.getPlazasLibres());
                break;
            case 2:
                System.out.println(inf.getPlazasLibres());
                break;
            case 3:
                System.out.println(sup.getPlazasLibres() + inf.getPlazasLibres());
                break;
            default:
                System.out.print("ERROR: opcion incorrecta.");
        }

    }

    static public void buscarCoche() {
        String dni;
        System.out.println("Introduce el dni del conductor");
        dni = sc.next();
        if (sup.buscarPorDni(dni)) {
            if (inf.buscarPorDni(dni)) {
                System.out.println("Su coche no se encuentra en el parking");
            } else {
                System.out.println("Su coche se encuentra en la plaza " + (20 + inf.plazaPorDni(dni)));
            }
        } else {
            System.out.println("Su coche se encuentra en la plaza " + inf.plazaPorDni(dni));
        }
    }

    static public void datosPorPlaza() {
        System.out.println("Introduce la plaza [1-50]");
        int p = sc.nextInt()-1;
        if (sup.mostrarCoche(p)==null) {
            if (inf.mostrarCoche(p)==null) {
                System.out.println("La plaza esta vacia");
            } else {
                System.out.println(inf.mostrarCoche(p));
            }
        } else {
            System.out.println(sup.mostrarCoche(p));
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
            n = sup.recuentoPorMarca(marca);
            n += inf.recuentoPorMarca(marca);
            if(n==0){
                System.out.println("No hay coches de esta marca en el parking");
            }else
                System.out.println("Hay "+n+" coches de la marca "+marca);
        } else if (op == 2) {
            System.out.println("Introduce el color");
            color = sc.next();
            n = sup.recuentoPorColor(color);
            n += inf.recuentoPorColor(color);
            if(n==0){
                System.out.println("No hay coches de esta marca en el parking");
            }else
                System.out.println("Hay "+n+" coches de la marca "+color);
        } else if (op == 3) {
                entradas();
        } else {
            System.out.println("Error: opcion incorrecta");
        }
    }
    
    static public void entradas(){
        
        System.out.println("Introduzca la fecha menor [yyyy-MM-dd-hh-mm-ss]:");
        String f1 = sc.next();
        if(!dateFormatCheck(f1)){throw new IllegalArgumentException("ERROR: la fecha no tiene el formato esperado");}
        System.out.println("Introduzca la fecha mayor [yyyy-MM-dd-hh-mm-ss]:");
        String f2 = sc.next();
        if(!dateFormatCheck(f2)){throw new IllegalArgumentException("ERROR: la fecha no tiene el formato esperado");}
        
        System.out.println(sup.calculoEntradas(f1,f2)+" vehiculos");
    
    }
    static public boolean dateFormatCheck(String f){
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-1][0-9]-[0-3][0-9]-[0-2][0-9](-[0-5][0-9]){3}");
        return pattern.matcher(f).matches();
    }
    
}
