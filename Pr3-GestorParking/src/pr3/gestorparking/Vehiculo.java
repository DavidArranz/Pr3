/* hola2
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr3.gestorparking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

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
public class Vehiculo implements java.io.Serializable{
    private static final long SerialVersionUID=1L;
    private String dni;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private boolean desperfectos;
    private String descripcion;
    private String fyh_entrada;
    //private static ArrayList<Vehiculo> alv = new ArrayList<>();
    private static ArrayList<String> entradas = new ArrayList<>();
    static DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    

    public Vehiculo(String dni, String matricula, String marca, String modelo, String color, boolean desperfectos, String descripcion) {
        this.dni = dni;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.desperfectos = desperfectos;
        this.descripcion = descripcion;
        this.fyh_entrada = LocalDateTime.now().format(myFormatObj);
    //    alv.add(this);
        entradas.add(fyh_entrada);
        
    }

    public String getDni() {
        return dni;
        
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDesperfectos() {
        return desperfectos;
    }

    public void setDesperfectos(boolean desperfectos) {
        this.desperfectos = desperfectos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFyh_entrada() {
        return fyh_entrada;
    }
    
    public static void setEntrada(String entrada) {
        entradas.add(entrada);
    }
    
    public static void setEntradas(ArrayList<String> entradas) {
        Vehiculo.entradas = entradas;
    }
    
    public static ArrayList getEntradas(){
        return entradas;
    }
    
    /*public static Vehiculo repetido(String matricula){
        Iterator<Vehiculo> it = alv.iterator();
        Vehiculo l;
        while(it.hasNext()){
            l=it.next();
            if(l.getMatricula().equals(matricula))
                return l;
        }
        return null;
        
    }*/

    @Override
    public String toString() {
        return "Vehiculo{" + "dni=" + dni + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", desperfectos=" + desperfectos + ", descripcion=" + descripcion + ", Fecha de entrada=" + fyh_entrada + '}';
    }
    
    
}
