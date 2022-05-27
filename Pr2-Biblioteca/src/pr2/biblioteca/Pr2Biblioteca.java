/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr2.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David Arranz
 */
public class Pr2Biblioteca {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Empleados> empleados = new ArrayList<>();
    static ArrayList<Libros> libros = new ArrayList<>();
    static ArrayList<Usuarios> usuarios = new ArrayList<>();
    static String path;

    public static void main(String[] args) throws Exception {
        

        int ex = 0, op, op2, p;
            String resp;
            System.out.println("Desea abrir un archivo existente[s/n]");
            resp = sc.next();
            if (resp.equals("s") || resp.equals("S")) {
                System.out.println("Introduzca la direccion");
                path = sc.next();
                if (!path.matches("/\\z")) {
                    path = path + "/";
                }
                if (Files.exists(Paths.get(path + "empleados")) && Files.exists(Paths.get(path + "libros")) && Files.exists(Paths.get(path + "usuarios"))) {
                    readFile(path);
                    
                } else {
                    System.out.println("ERROR: el fichero indicado no existe o no es del tipo requerido");
                }

            } else if (resp.equals("n") || resp.equals("N")) {
            } else {
                System.out.println("ERROR:opcion invalida"); 
            }

        
        //start();
        
        while (ex != 1) {
            menu();
            System.out.println("Introduzca la opcion a realizar");
            try {
                op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        addLibro();
                        break;
                    case 2:
                        menu2();
                        System.out.println("Introduzca la opcion de busqueda");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduzca la informacion de busqueda(prestado si/no):");
                        switch (op2) {
                            case 1:
                                buscarLibro(sc.nextLine(), 1);
                                break;
                            case 2:
                                buscarLibro(sc.nextLine(), 2);
                                break;
                            case 3:
                                buscarLibro(sc.nextLine(), 3);
                                break;
                            case 4:
                                String est = sc.nextLine();
                                if (est.equals("si") || est.equals("SI")) {
                                    buscarLibro(true);
                                } else if (est.equals("no") || est.equals("NO")) {
                                    buscarLibro(false);
                                } else {
                                    System.out.println("ERROR:Informacion invalida");
                                }
                                break;
                            case 5:
                                buscarLibro(sc.nextInt());
                                sc.nextLine();
                                break;
                            case 6:
                                buscarLibro(sc.nextLine(), 4);
                                break;
                            case 7:
                                buscarLibro(sc.nextDouble());
                                sc.nextLine();
                                break;
                            case 8:
                                buscarLibro(sc.nextLine(), 5);
                                break;
                            case 9:
                                buscarLibro(sc.nextLine(), 6);
                                break;
                        }
                        break;
                    case 3:
                        HashMap<Integer, Libros> rBusqueda = new HashMap<>();
                        menu2();
                        System.out.println("Introduzca la opcion de busqueda");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduzca la informacion de busqueda(prestado si/no):");
                        switch (op2) {
                            case 1:
                                rBusqueda = buscarLibro(sc.nextLine(), 1);
                                break;
                            case 2:
                                rBusqueda = buscarLibro(sc.nextLine(), 2);
                                break;
                            case 3:
                                rBusqueda = buscarLibro(sc.nextLine(), 3);
                                break;
                            case 4:
                                String est = sc.nextLine();
                                if (est.equals("si") || est.equals("SI")) {
                                    rBusqueda = buscarLibro(true);
                                } else if (est.equals("no") || est.equals("NO")) {
                                    rBusqueda = buscarLibro(false);
                                } else {
                                    System.out.println("ERROR:Informacion invalida");
                                }
                                break;
                            case 5:
                                rBusqueda = buscarLibro(sc.nextInt());
                                sc.nextLine();
                                break;
                            case 6:
                                rBusqueda = buscarLibro(sc.nextLine(), 4);
                                break;
                            case 7:
                                rBusqueda = buscarLibro(sc.nextDouble());
                                sc.nextLine();
                                break;
                            case 8:
                                rBusqueda = buscarLibro(sc.nextLine(), 5);
                                break;
                            case 9:
                                rBusqueda = buscarLibro(sc.nextLine(), 6);
                                break;
                            default:
                                System.out.println("opcion incorrecta");
                                rBusqueda = null;
                        }
                        if (rBusqueda != null) {
                            System.out.println("Introduce la posicion del libro a eliminar");
                            p = sc.nextInt();
                            sc.nextLine();
                            libros.remove(rBusqueda.get(p));
                        }
                        break;
                    case 4:
                        alquilar();
                        break;
                    case 5:
                        devolver();
                        break;
                    case 6:
                        menu6();
                        System.out.println("Introduzca la opcion deseada");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        switch (op2) {
                            case 1:
                                listarEmpleados();
                                break;
                            case 2:
                                addEmpleado();
                                break;
                            case 3:
                                delEmpleado();
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                        break;
                    case 7:
                        menu7();
                        System.out.println("Introduzca la opcion deseada");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        switch (op2) {
                            case 1:
                                listarUsuarios();
                                break;
                            case 2:
                                addUsuarios();
                                break;
                            case 3:
                                delUsuarios();
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                        break;
                    case 8:
                        String res;
                        while (ex != 1) {

                            
                            System.out.println("Desea guardar los cambios?[s/n]");
                            res = sc.nextLine();
                            if (res.equals("s") || res.equals("S")) {
                                if (path == null) {
                                    System.out.println("Introduce la ruta de destino");
                                    path = sc.next();
                                    sc.nextLine();
                                    File file = new File(path);
                                    file.mkdir();
                                    if (!path.matches("/\\z")) {
                                        path = path + "/";
                                    }
                                }
                                writeFile(path);
                                ex = 1;
                                break;
                            } else if (res.equals("n") || res.equals("N")) {
                                ex = 1;
                            } else {
                                System.out.println("ERROR:opcion invalida");
                            }
                        }
                        break;
                    default:
                        System.out.println("ERROR:opcion invalida");

                }
            } catch (InputMismatchException ex1) {
                System.out.println("ERROR:El valor introducido no es del tipo esperado");
                sc.nextLine();
            } catch (NullPointerException ex1) {
                System.out.println("ERROR:El valor esta fuera del limite de la lista");
                sc.nextLine();
            } catch (IllegalArgumentException ex1){
                System.out.println("ERROR:El argumento introducido es invalido\n"
                        +ex1);
            }
        }

    }

    public static void start() {
        //empleados
        empleados.add(new Empleados("1", "Alberto"));
        empleados.add(new Empleados("2", "Encarna"));
        empleados.add(new Empleados("3", "Estela"));
        empleados.add(new Empleados("4", "Manolo"));
        empleados.add(new Empleados("5", "Agustín"));
        //usuarios
        usuarios.add(new Usuarios("usu1"));
        usuarios.add(new Usuarios("usu2"));
        usuarios.add(new Usuarios("usu3"));
        usuarios.add(new Usuarios("usu4"));
        usuarios.add(new Usuarios("usu5"));
        //libros
        libros.add(new Libros("titulo1", "autor1", "editorial1", 1, "1", 1));
        libros.add(new Libros("titulo2", "autor2", "editorial2", 2, "2", 2));
        libros.add(new Libros("titulo3", "autor3", "editorial3", 3, "3", 3));
        libros.add(new Libros("titulo4", "autor4", "editorial4", 4, "4", 4));
    }

    public static void menu() {
        System.out.println("     MENU\n"
                + "****************\n"
                + "1.Añadir libro\n"
                + "2.Buscar libro\n"
                + "3.Eliminar libro\n"
                + "4.Alquilar libro\n"
                + "5.Devolver libro\n"
                + "6.Gestionar empleados\n"
                + "7.Gestionar usuarios\n"
                + "8.Salir");
    }

    public static void menu2() {
        System.out.println(""
                + "1.Título\n"
                + "2.Autor\n"
                + "3.Editorial\n"
                + "4.Estado del prestamo\n"
                + "5.Ubicacion\n"
                + "6.ISBN\n"
                + "7.Precio\n"
                + "8.Nombre del empleado que lo ha alquilado\n"
                + "9.Nombre del usuario que lo ha prestado\n");
    }

    public static void menu6() {
        System.out.println(""
                + "1.Listar empleados\n"
                + "2.Dar de alta nuevo empleado\n"
                + "3.dar de baja un empleado\n"
        );
    }

    public static void menu7() {
        System.out.println(""
                + "1.Listar usuarios\n"
                + "2.Dar de alta nuevo usuario\n"
                + "3.Dar de baja un empleado\n");
    }

    public static void addLibro() {
        String titulo;
        String autor, editorial, isbn;
        int ubicacion;
        double precio;
        System.out.println("Introduce el titulo:");
        titulo = sc.nextLine();
        System.out.println("Introduce el autor:");
        autor = sc.nextLine();
        System.out.println("Introduce el ISBN:");
        isbn = sc.nextLine();
        System.out.println("Introduce la editorial");
        editorial = sc.nextLine();
        System.out.println("Introduce la ubicacion:");
        ubicacion = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el precio:");
        precio = sc.nextDouble();
        if(precio < 0){System.out.println("ERROR: precio no puede ser un valor negativo");throw new IllegalArgumentException("valor menor que cero es invalido");}
        sc.nextLine();
        libros.add(new Libros(titulo, autor, editorial, ubicacion, isbn, precio));
        System.out.println("Libro añadido con exito");
    }

    public static HashMap buscarLibro(String str, int i) {
        if (!libros.isEmpty()) {
            Iterator<Libros> it = libros.iterator();
            HashMap<Integer, Libros> hm = new HashMap<>();
            int cont = 1;
            if (i == 1) {
                while (it.hasNext()) {
                    Libros l = it.next();
                    if (l.getTitulo().equals(str)) {
                        hm.put(cont, l);
                        System.out.println("Libro " + cont + ":");
                        System.out.println(l.toString());
                        cont++;
                    }
                }
                if (cont == 1) {
                    System.out.println("No se han encontrado libros con este titulo.");
                }
                return hm;
            } else if (i == 2) {
                while (it.hasNext()) {
                    Libros l = it.next();
                    if (l.getAutor().equals(str)) {
                        hm.put(cont, l);
                        System.out.println("Libro " + cont + ":");
                        l.toString();
                        cont++;
                    }
                }
                if (cont == 1) {
                    System.out.println("No se han encontrado libros con este autor.");
                }
                return hm;
            } else if (i == 3) {
                while (it.hasNext()) {
                    Libros l = it.next();
                    if (l.getEditorial().equals(str)) {
                        hm.put(cont, l);
                        System.out.println("Libro " + cont + ":");
                        l.toString();
                        cont++;
                    }
                }
                if (cont == 1) {
                    System.out.println("No se han encontrado libros con esta editorial.");
                }
                return hm;
            } else if (i == 4) {
                while (it.hasNext()) {
                    Libros l = it.next();
                    if (l.getIsbn().equals(str)) {
                        hm.put(cont, l);
                        System.out.println("Libro " + cont + ":");
                        l.toString();
                        cont++;
                    }
                }
                if (cont == 1) {
                    System.out.println("No se han encontrado libros con este ISBN.");
                }
                return hm;
            } else if (i == 5) {
                while (it.hasNext()) {
                    Libros l = it.next();
                    if (l.getPrestado_por().equals(str)) {
                        hm.put(cont, l);
                        System.out.println("Libro " + cont + ":");
                        l.toString();
                        cont++;
                    }
                }
                if (cont == 1) {
                    System.out.println("No se han encontrado libros con este empleado.");
                }
                return hm;
            } else {
                while (it.hasNext()) {
                    Libros l = it.next();
                    if (l.getUsu().equals(str)) {
                        hm.put(cont, l);
                        System.out.println("Libro " + cont + ":");
                        l.toString();
                        cont++;;
                    }
                }
                if (cont == 1) {
                    System.out.println("No se han encontrado libros con este usuario.");
                }
                return hm;
            }
        } else {
            System.out.println("No hay libros");
            return null;
        }
    }

    public static HashMap buscarLibro(boolean est) {
        if (!libros.isEmpty()) {
            Iterator<Libros> it = libros.iterator();
            HashMap<Integer, Libros> hm = new HashMap<>();
            int cont = 1;
            while (it.hasNext()) {
                Libros l = it.next();
                if (l.isEstado_p() == est) {
                    hm.put(cont, l);
                    System.out.println("Libro " + cont + ":");
                    System.out.println(l.toString());
                    cont++;
                }
            }
            if (cont == 1) {
                System.out.println("No se han encontrado libros con los que se pueda operar.");
                return null;
            }
            return hm;
        } else {
            System.out.println("No hay libros");
            return null;
        }
    }

    public static HashMap buscarLibro(int ubi) {
        if (!libros.isEmpty()) {
            Iterator<Libros> it = libros.iterator();
            HashMap<Integer, Libros> hm = new HashMap<>();
            int cont = 1;
            while (it.hasNext()) {
                Libros l = it.next();
                if (l.getUbicacion() == ubi) {
                    hm.put(cont, l);
                    System.out.println("Libro " + cont + ":");
                    System.out.println(l.toString());
                    cont++;
                }
            }
            if (cont == 1) {
                System.out.println("No se han encontrado libros con este ISBN.");
            }
            return hm;
        } else {
            System.out.println("No hay libros");
            return null;
        }
    }

    public static HashMap buscarLibro(double p) {
        if (!libros.isEmpty()) {
            Iterator<Libros> it = libros.iterator();
            HashMap<Integer, Libros> hm = new HashMap<>();
            int cont = 1;
            while (it.hasNext()) {
                Libros l = it.next();
                if (l.getPrecio() == p) {
                    hm.put(cont, l);
                    System.out.println("Libro " + cont + ":");
                    System.out.println(l.toString());
                    cont++;
                }
            }
            if (cont == 1) {
                System.out.println("No se han encontrado libros con este ISBN.");
            }
            return hm;
        } else {
            System.out.println("No hay libros");
            return null;
        }
    }

    public static void alquilar() {
        HashMap<Integer, Libros> rBusqueda = new HashMap<>();
        int p;
        rBusqueda = buscarLibro(false);
        System.out.println("Introduce la posicion del libro a alquilar.");
        p = sc.nextInt();
        sc.nextLine();
        rBusqueda.get(p).setEstado_p(true);
        System.out.println("Introduce el usuario al que se el presta");
        String usu = sc.nextLine();
        rBusqueda.get(p).setUsu(usu);
        System.out.println("Introduce el empleado que presta el libro");
        String empl = sc.nextLine();
        rBusqueda.get(p).setPrestado_por(empl);
    }

    public static void devolver() {
        HashMap<Integer, Libros> rBusqueda = new HashMap<>();
        int p;
        rBusqueda = buscarLibro(true);
        if (rBusqueda != null) {
            System.out.println("Introduce la posicion del libro a devolver.");
            p = sc.nextInt();
            sc.nextLine();
            rBusqueda.get(p).setEstado_p(false);
            rBusqueda.get(p).setUsu(null);
            rBusqueda.get(p).setPrestado_por(null);
            System.out.println("Exito");
        }

    }

    public static void listarEmpleados() {
        for (Empleados e : empleados) {
            System.out.println("-" + e.getName());
        }
    }

    public static void addEmpleado() {
        System.out.println("Introduce el ID");
        String id = sc.nextLine();
        System.out.println("Introduce el nombre");
        String name = sc.nextLine();
        empleados.add(new Empleados(id, name));
        System.out.println("Añadido con exito");
    }

    public static void delEmpleado() {
        System.out.println("Introduce el nombre del empleado:");
        String nom = sc.nextLine();
        Iterator<Empleados> it = empleados.iterator();
        int i = 0;
        while (it.hasNext()) {
            Empleados e = it.next();
            if (e.getName().equals(nom)) {
                it.remove();
                i = 1;
            }
        }
        if (i == 0) {
            System.out.println("No se han encontrado empleados con ese nomrbe");
        } else {
            System.out.println("Eliminado con exito");
        }
    }

    public static void listarUsuarios() {
        for (Usuarios e : usuarios) {
            System.out.println("-" + e.getName());
        }
    }

    public static void addUsuarios() {
        System.out.println("Introduce el nombre");
        String name = sc.nextLine();
        usuarios.add(new Usuarios(name));
        System.out.println("Añadido con exito");
    }

    public static void delUsuarios() {
        System.out.println("Introduce el nombre del usuario:");
        String nom = sc.nextLine();
        Iterator<Usuarios> it = usuarios.iterator();
        int i = 0;
        while (it.hasNext()) {
            Usuarios e = it.next();
            if (e.getName().equals(nom)) {
                it.remove();
                i = 1;
            }
        }
        if (i == 0) {
            System.out.println("No se han encontrado usuarios con ese nomrbe");
        } else {
            System.out.println("Eliminado con exito");
        }

    }

    public static void readFile(String path) {
        try {
            FileInputStream fise = new FileInputStream(path + "empleados");
            ObjectInputStream oise = new ObjectInputStream(fise);
            empleados = (ArrayList<Empleados>) oise.readObject();
            oise.close();
            fise.close();
            FileInputStream fisl = new FileInputStream(path + "libros");
            ObjectInputStream oisl = new ObjectInputStream(fisl);
            libros = (ArrayList<Libros>) oisl.readObject();
            oisl.close();
            fisl.close();
            FileInputStream fisu = new FileInputStream(path + "empleados");
            ObjectInputStream oisu = new ObjectInputStream(fisu);
            usuarios = (ArrayList<Usuarios>) oisu.readObject();
            oisu.close();
            fisu.close();
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println(ioe);
        }
    }

    public static void writeFile(String path) {
        try {
            FileOutputStream fose = new FileOutputStream(path + "empleados");
            ObjectOutputStream oose = new ObjectOutputStream(fose);
            oose.writeObject(empleados);
            oose.flush();
            oose.close();
            fose.close();
            FileOutputStream fosl = new FileOutputStream(path + "libros");
            ObjectOutputStream oosl = new ObjectOutputStream(fosl);
            oosl.writeObject(libros);
            oosl.flush();
            oosl.close();
            fosl.close();
            FileOutputStream fosu = new FileOutputStream(path + "usuarios");
            ObjectOutputStream oosu = new ObjectOutputStream(fosu);
            oosu.writeObject(usuarios);
            oosu.flush();
            oosu.close();
            fosu.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
