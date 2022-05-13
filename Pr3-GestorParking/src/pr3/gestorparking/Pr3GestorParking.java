/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr3.gestorparking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
    
    static public void menu3(){
        System.out.println("1. Plazas disponibles en el piso superior\n"
                + "2. Plazas disponibles en el piso inferior\n"
                + "3. Plazas disponibles en total");
    }

    static public void asignarPlaza(boolean piso) {
        String fyh_entrada, dni, matricula, marca, modelo, color, descripcion, fyj_entrada;
        boolean desperfectos;

        System.out.println("Introduce la matricula");
        matricula = sc.next();
        if (Vehiculo.repetido(matricula) != null) {
            if (piso) {
                sup.setPlazas_lib(sup.getPlazas_lib() - 1);
                sup.addcar(Vehiculo.repetido(matricula));
            } else {
                inf.setPlazas_lib(inf.getPlazas_lib() - 1);
                inf.addcar(Vehiculo.repetido(matricula));
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
            fyh_entrada = DateTimeFormatter.ISO_DATE.format(LocalDateTime.now());
            if (piso) {
                sup.setPlazas_lib(sup.getPlazas_lib() - 1);
                sup.addcar(new Vehiculo(dni, matricula, marca, modelo, color, desperfectos, descripcion, fyh_entrada));
            } else {
                inf.setPlazas_lib(inf.getPlazas_lib() - 1);
                inf.addcar(new Vehiculo(dni, matricula, marca, modelo, color, desperfectos, descripcion, fyh_entrada));
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
    
    static public void verDisp(){
        int op;
        menu3();
        System.out.println("introduce la opcion:");
        op=sc.nextInt();
        
        switch(op){
            case 1:
                System.out.println(sup.getPlazasLibres());
                break;
            case 2:
                System.out.println(inf.getPlazasLibres());
                break;
            case 3:
                System.out.println(sup.getPlazasLibres()+inf.getPlazasLibres());
                break;
            default:
                System.out.print("ERROR: opcion incorrecta.");
        }
        
    }
    
    static public void buscarCoche(){
        String dni;
        System.out.println("Introduce el dni del conductor");
        dni=sc.next();
        if(sup.buscarPorDni(dni)==-1){
            if(inf.buscarPorDni(dni)==-1){
                System.out.println("Su coche no se encuentra en el parking");
            } else {
                System.out.println("Su coche se encuentra en la plaza "+(20+inf.buscarPorDni(dni)));
            }
        } else {
            System.out.println("Su coche se encuentra en la plaza "+inf.buscarPorDni(dni));
        }
    }
    
    static public void datosPorPlaza(){
        System.out.println("Introduce la plaza [1-50]");
        int p = sc.nextInt();
        if(!sup.mostrarCoche(p)){
            if(!inf.mostrarCoche(p)){
                System.out.println("La plaza esta vacia");
            } else
                inf.mostrarCoche(p);
        } else
            sup.mostrarCoche(p);
    }
    
    static public void estadisticas(){
        String marca,color;
        System.out.println("Mostrar el numero de coches por...\n"
                + "1-marca\n"
                + "2-color");
        int op=sc.nextInt();
        if(op==1){
            System.out.println("Introduce la marca");
            String m=sc.next();
        } else if(op==2){
            
        } else{
            System.out.println("Error: opcion incorrecta");
        }
    }
}
