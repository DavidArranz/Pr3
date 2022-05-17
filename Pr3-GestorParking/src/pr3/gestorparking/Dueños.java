/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr3.gestorparking;

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
public class Dueños {
    private String dni;
    private String nom;
    private String ap;
    private String dir;
    private String tel;
    private String cuenta_bank;

    public Dueños(String dni, String nom, String ap, String dir, String tel, String cuenta_bank) {
        this.dni = dni;
        this.nom = nom;
        this.ap = ap;
        this.dir = dir;
        this.tel = tel;
        this.cuenta_bank = cuenta_bank;
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
    
}
