/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr3.gestorparking;

import java.util.HashMap;
import static pr3.gestorparking.Pr3GestorParking.sc;

/**
 *
 * "Hola Mundo.java"
 *
 * Creada el siete de octubre de 2021, 12:10
 *
 * Desarrollada por David Arranz  en la empresa IES El Grao el dia siete de octubre de 2021 
 *
 * Puede contactar conmigo en 10802894@ieselgrao.org
 *
 /**
 *
 * @author David Arranz 
 * @version 1.0
 * @date 9 may. 2022
 */
public class Dueño {
    private String dni;
    private String nom;
    private String ap;
    private String dir;
    private String tel;
    private String cuenta_bank;
    private Vehiculo vehiculo;

    public Dueño(String dni, String nom, String ap, String dir, String tel, String cuenta_bank) throws Exception {
        
        this.dni = dni;
        this.nom = nom;
        this.ap = ap;
        this.dir = dir;
        this.tel = tel;
        this.cuenta_bank = cuenta_bank;
        String matricula,marca,modelo,color,descripcion;
        boolean desperfectos;
        System.out.println("Introduce al matricula");
            matricula=sc.next();
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
        vehiculo = new Vehiculo(this.dni,matricula,marca,modelo,color,desperfectos,descripcion);
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCuenta_bank() {
        return cuenta_bank;
    }

    public void setCuenta_bank(String cuenta_bank) {
        this.cuenta_bank = cuenta_bank;
    }

    

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "DNI=" + dni + "\n"
                + "Nombre=" + nom + "\n"
                + "Apellido=" + ap + "\n"
                + "Direccion=" + dir + "\n"
                + "Telefono=" + tel + "\n"
                + "Cuenta bancaria=" + cuenta_bank + "\n"
                + "VEHICULO:\n"
                + vehiculo.toString();
    }
    
    

    
    
    
    
    
    
    
}
