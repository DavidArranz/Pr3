/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pr1.fabricamonedaytimbre;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author David Arranz
 */
public class Pr1FabricaMonedaYTimbre {

    static ArrayList<Dinero> al = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String PATH = "/home/alumno/Documentos/Programacion/ficherosProgramas/Proyecto2/";
    static final String PATH_AL = "/home/alumno/Documentos/Programacion/ficherosProgramas/Proyecto2/al";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op, ex = 0;
        File dir = new File(PATH);
        if (!dir.exists()) {
            dir.mkdir();
        } else {
            if (Files.exists(Paths.get(PATH_AL))) {
                try {
                    FileInputStream fis = new FileInputStream(PATH_AL);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    al = (ArrayList) ois.readObject();
                } catch (IOException | ClassNotFoundException ex1) {
                    System.out.println(ex1);
                }
            }
        }

        while (ex != 1) {
            menu();
            System.out.println("Introduzca la opcion a realizar");
            try {
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        crear();
                        break;
                    case 2:
                        mostrar();
                        break;
                    case 3:
                        comparar();
                        break;
                    case 4:
                        ordenar();
                        break;
                    case 5:
                        copia();
                        break;
                    case 6:
                        buscar();
                        break;
                    case 7:
                        modDim();
                        break;
                    case 8:
                        eliminar();
                        break;
                    case 9:
                        System.out.println("Desea guardar los cambios realizados?[s/n]");
                        String temp = sc.next();
                        if (temp.equals("s") || temp.equals("S")) {
                            guardar();
                        } else if (!temp.equals("n") && !temp.equals("N")) {
                            System.out.println("Opcion invalida");
                            break;
                        }
                        ex = 1;
                        break;
                    default:
                        System.out.println("-ERROR:opcion invalida-");

                }
            } catch (InputMismatchException | IllegalArgumentException ex1) {
                System.out.println("ERROR:El valor introducido no es del tipo esperado\n"
                        + ex1);
                sc.nextLine();
            } catch (IndexOutOfBoundsException ex1){
                System.out.println("ERROR:Se ha intentado leer una posicion inexistente\n"
                        + ex1);
            }
        }

    }

    /**
     * Muestra por pantalla el menu del programa.
     */
    public static void menu() {
        System.out.println("MENU\n"
                + "--------------------\n"
                + "1.Crear objetos(se almacenan automaticamente)\n"
                + "2.Mostrar objetos\n"
                + "3.Comprobar si hay dos objetos iguales\n"
                + "4.Ordenar ArrayList\n"
                + "5.Crear copia de objetos\n"
                + "6.buscar objetos\n"
                + "7.Modificar los atributos de dimensión de los objetos\n"
                + "8.Eliminar objetos.\n"
                + "9.Salir");
    }

    /**
     * Crea objetos de tipo {@link Billete} o {@link Moneda}. El metodo en caso
     * de que el ArrayList no este vacio primero pregunta que tipo de objeto se
     * desea crear, despues pregunta por los atributos del objeto y finalmente
     * lo crea.
     */
    public static void crear() {
        double valor, diametro, peso, altura, anchura;
        int anyo;
        System.out.println("CREACIÓN DE UN OBJETO\n"
                + "***********************");
        System.out.println("Desea crear un billete o una moneda?[b/m]");
        String d = sc.next();
        if (d.equals("b") || d.equals("B")) {
            System.out.println("Introduce el valor del billete: ");
            valor = sc.nextDouble();
            System.out.println("Introduce el año del billete: ");
            anyo = sc.nextInt();

            System.out.println("Introduce la altura del billete: ");
            altura = sc.nextDouble();

            System.out.println("Introduce la anchura del billete: ");
            anchura = sc.nextDouble();

            al.add(new Billete(altura, anchura, valor, anyo));
            System.out.println("El objeto se añadio al arrayList correctamente.");
        } else if (d.equals("m") || d.equals("M")) {
            System.out.println("Introduce el valor de la moneda: ");
            valor = sc.nextDouble();

            System.out.println("Introduce el año de la moneda: ");
            anyo = sc.nextInt();
            System.out.println("Introduce el diametro de la moneda: ");
            diametro = sc.nextDouble();

            System.out.println("Introduce el peso de la moneda: ");
            peso = sc.nextDouble();
            al.add(new Moneda(diametro, peso, valor, anyo));
            System.out.println("El objeto se añadio al arrayList correctamente.");

        } else {
            System.out.println("Respuesta invalida");
        }
    }

    /**
     * Si el ArrayList tiene objetos llama al metodo {@link mObj} que muestra
     * por pantalla todos los objetos.
     */
    public static void mostrar() {
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            System.out.println("MOSTRAR OBJETOS\n"
                    + "*****************");
            mObj();
        }
    }

    /**
     * En caso de que el arrayList tenga objetos, compara los objetos entre si
     * uno por uno usando el metodo
     * {@link Dinero#equals(pr1.fabricamonedaytimbre.Dinero) Dinero.equals}
     * hasta dar con dos objetos iguales, entonces lo avisa por pantalla y
     * termina el metodo. En caso de no haber objetos iguales, lo avisa tambien
     * por pantalla.
     */
    public static void comparar() {
        //comprueba que hay objetos
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            
            boolean s = false;
            //Se crean dos copias del AL temporales para 
            //evitar error de ConcurrentModificationException
            ArrayList<Dinero> altemp = new ArrayList<>();
            ArrayList<Dinero> altemp2 = new ArrayList<>();
            altemp.addAll(al);
            altemp2.addAll(al);
            //Se crea un array del tamaño del AL
            /*
        en este se ira guardando en cada posicion 
        del primer elemento que tiene repeticiones
        el numero de veces que se repite el mismo
             */
            int[] rep = new int[al.size()];
            for (int i = 0; i < rep.length; i++) {
                rep[i] = 1;
            }
            Iterator<Dinero> it = altemp.iterator();

            A:
            while (it.hasNext()) {
                Dinero d = it.next();
                /*
            si el segundo arrayList temporal no tiene el objeto d
            significa que lo a borrado por lo que o ya se ha comparado
            con el resto o ya a sido comparado y se a encontrado igualdad
            por lo que no sirve de nada volver a compararlo.
                 */
                if (!altemp2.contains(d)) {
                    continue;
                }
                /*
            El segundo iterador hay que crearlo aqui para que se reinicie, si no
            el hasNext() saltaria el while siempre.
                 */
                Iterator<Dinero> it2 = altemp2.iterator();
                while (it2.hasNext()) {
                    Dinero d2 = it2.next();
                    //si d y d2 son el mismo objeto no se tiene en cuenta y se borra
                    if (d == d2) {
                        it2.remove();
                        continue;
                    }
                    //si son iguales, en la posicion de d en el array rep se suma 1 y se elimina
                    if (d.equals(d2)) {
                        rep[al.indexOf(d)]++;
                        it2.remove();
                        s = true;
                    }

                }
            }
            if (s == false) {
                System.out.println("No hay dos iguales");
            } else {
                System.out.println("VER QUE OBJETOS SE REPITEN\n"
                    + "********************************");
                for (int i = 0; i < rep.length; i++) {
                    if (rep[i] != 1) {
                        System.out.println("Repetido " + rep[i] + " veces:");

                        if (al.get(i) instanceof Billete) {
                            System.out.println(((Billete) al.get(i)).toString());
                        } else if (al.get(i) instanceof Moneda) {
                            System.out.println(((Moneda) al.get(i)).toString());
                        }

                    }
                }

            }
        }
    }

    /**
     * En caso de que haya objetos en el ArrayList ordena mediante un comparador
     * y el metodo
     * {@link Dinero#compareTo(pr1.fabricamonedaytimbre.Dinero) Dinero.compareTo}
     * despues llama al metodo {@link mObj} que muestra los objetos por
     * pantalla.
     */
    public static void ordenar() {
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            System.out.println("ORDENAR ARRAYLIST\n"
                    + "*******************");
            Collections.sort(al, new Comparator<Dinero>() {
                @Override
                public int compare(Dinero d1, Dinero d2) {
                    return d1.compareTo(d2);
                }
            });
            mObj();
        }

    }

    /**
     * En caso de que haya objetos en el ArrayList pide la posicion del objeto a
     * copiar y determina si es {@link Moneda} o {@link Billete} , despues llama
     * al constructor copia de la clase y crea una copia;
     */
    public static void copia() {
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            System.out.println("CREAR COPIA DE OBJETOS\n"
                    + "************************");
            System.out.println("Introduce la posicion del elemento a copiar[1-" + al.size() + "]: ");
            int pos = sc.nextInt() - 1;
            if (al.get(pos) instanceof Billete) {
                al.add(new Billete((Billete) al.get(pos)));
            } else {
                al.add(new Moneda((Moneda) al.get(pos)));
            }
            System.out.println("Copia creada con exito");
        }

    }

    /**
     * En caso de que haya objetos en el ArrayList pide la posicion de un
     * objeto, determina el tipo de objeto que es y llama al metodo .toString de
     * su clase.
     */
    public static void buscar() {
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            int pos;
            System.out.println("BUSCAR OBJETOS\n"
                    + "****************");
            System.out.println("Introduce la posicion del elemento a buscar[1-" + al.size() + "]: ");
            pos = sc.nextInt() - 1;
            if(pos<0 || pos>=al.size()){throw new IndexOutOfBoundsException("No se puede buscar un objeto fuera del rango[1-" + al.size() + "]");}
            if (al.get(pos) instanceof Billete) {
                ((Billete) al.get(pos)).toString();
            } else {
                System.out.println(((Moneda) al.get(pos)).toString());
            }
        }
    }

    /**
     * En caso de que haya objetos en el ArrayList modifica los valores que
     * especifican las dimensiones de los objetos
     */
    public static void modDim() {
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            int pos;
            System.out.println("MODIFICAR ATRIBUTOS DE DIMENSION\n"
                    + "**********************************");
            System.out.println("Introduce la posicion del elemento a modificar[1-" + al.size() + "]: ");
            pos = sc.nextInt() - 1;
            Dinero d = al.get(pos);
            if (d instanceof Billete) {
                System.out.println("Introduce la Altura: ");
                ((Billete) d).setAltura(sc.nextDouble());
                System.out.println("Introduce la Anchura: ");
                ((Billete) d).setAnchura(sc.nextDouble());
            } else {
                System.out.println("Introduce el diametro: ");
                ((Moneda) d).setDiametro(sc.nextDouble());
                System.out.println("Introduce el peso: ");
                ((Moneda) d).setPeso(sc.nextDouble());
            }
            System.out.println("Los valores se modificaron correctamente.");
        }
    }

    public static void eliminar() {
        if (al.size() == 0) {
            System.out.println("No hay objetos en la lista.");
        } else {
            System.out.println("ELIMINAR OBJETOS\n"
                    + "******************");
            System.out.println("Introduce la posicion del elemento a elliminar[1-" + al.size() + "]: ");
            al.remove(al.get(sc.nextInt() - 1));
        }
    }

    public static void mObj() {
        for (Dinero d : al) {
            if (d instanceof Billete) {
                System.out.println(((Billete) d).toString());
            } else {
                System.out.println(((Moneda) d).toString());
            }
        }
    }

    public static void guardar() {
        try {
            if (al.size() != 0) {
                FileOutputStream fos1 = new FileOutputStream(PATH_AL, false);
                ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
                oos1.writeObject(al);
                oos1.close();
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
