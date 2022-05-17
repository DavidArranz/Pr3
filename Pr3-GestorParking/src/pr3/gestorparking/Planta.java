/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr3.gestorparking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 *
 * "Hola Mundo.java"
 *
 * Creada el siete de octubre de 2021, 12:10
 *
 * Desarrollada por David Arranz en la empresa IES El Grao el dia siete de
 * octubre de 2021
 *
 * Puede contactar conmigo en 10802894@ieselgrao.org
 *
 * /**
 *
 * @author David Arranz
 * @version 1.0
 * @date 9 may. 2022
 */
//DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
public class Planta {

    private static int plazas_lib = 20;
    public static Vehiculo[] pt1 = new Vehiculo[20];

    public Planta(int plazas_lib) {
    }

    public int getPlazas_lib() {
        return plazas_lib;
    }

    public void setPlazas_lib(int plazas_lib) {
        this.plazas_lib = plazas_lib;
    }

    public Vehiculo getVehiculo(int p) {
        return pt1[p - 1];
    }

    public boolean addcar(Vehiculo v) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv == null) {
                pt1[i] = v;
                return false;
            }
            i++;
        }
        return true;
    }

    public double delcar(String m, String dni) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv != null) {
                if (vv.getMatricula().equals(m) && vv.getDni().equals(dni)) {
                    double p = calculoPrecio(pt1[i]);
                    pt1[i] = null;
                    return p;
                }
            }
            i++;
        }
        return -1;
    }

    public double calculoPrecio(Vehiculo v) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        double PRECIO = 0.0003;//€ por segundo
        String f1, f2;
        int s1 = 0;
        String[] splitted1 = new String[6];
        String[] splitted2 = new String[6];
        f1 = v.getFyh_entrada();
        f2 = LocalDateTime.now().format(myFormatObj);
        splitted1 = f1.split("-");
        splitted2 = f1.split("-");
        if (!splitted1[0].equals(splitted2[0])) {
            s1 = Integer.valueOf(splitted2[0]) - Integer.valueOf(splitted1[0]) * 31536000;
        }
        if (!splitted1[1].equals(splitted2[1])) {
            s1 = Integer.valueOf(splitted2[1]) - Integer.valueOf(splitted1[1]) * 2629800;
        }
        if (!splitted1[2].equals(splitted2[2])) {
            s1 = Integer.valueOf(splitted2[2]) - Integer.valueOf(splitted1[2]) * 86400;
        }
        if (!splitted1[3].equals(splitted2[3])) {
            s1 = Integer.valueOf(splitted2[3]) - Integer.valueOf(splitted1[3]) * 3600;
        }
        if (!splitted1[4].equals(splitted2[4])) {
            s1 = Integer.valueOf(splitted2[4]) - Integer.valueOf(splitted1[4]) * 60;
        }
        if (!splitted1[5].equals(splitted2[5])) {
            s1 = Integer.valueOf(splitted2[5]) - Integer.valueOf(splitted1[5]);
        }
        System.out.println("Su importe es de " + s1 * PRECIO + "€");
        return s1 * PRECIO;

    }

    public int getPlazasLibres() {
        int i = 0, j = 0;
        for (Vehiculo vv : pt1) {
            if (pt1[i] == null) {
                j++;
            }
            i++;
        }
        return j;
    }

    public int buscarPorMatricula(String m) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv != null) {
                if (vv.getMatricula().equals(m)) {
                    pt1[i] = null;
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
    
    public boolean buscarPorDni(String dni) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv != null) {
                if (vv.getDni().equals(dni)) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public int plazaPorDni(String dni) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv != null) {
                if (vv.getDni().equals(dni)) {
                    pt1[i] = null;
                    return i+1;
                }
            }
            i++;
        }
        return -1;
    }

    public boolean mostrarCoche(int p) {
        if (pt1[p] == null) {
            return false;
        } else {
            System.out.println(pt1[p].toString());
        }
        return true;
    }

    public int recuentoPorMarca(String m) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv != null) {
                if (vv.getMarca().equals(m)) {
                    i++;
                }
            }
        }
        return i;
    }

    public int recuentoPorColor(String c) {
        int i = 0;
        for (Vehiculo vv : pt1) {
            if (vv != null) {
                if (vv.getColor().equals(c)) {
                    i++;
                }
            }
        }
        return i;
    }

}
