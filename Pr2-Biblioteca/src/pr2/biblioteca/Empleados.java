/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr2.biblioteca;

import java.io.Serializable;
import java.util.HashMap;

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
 * @date 25 mar. 2022
 */
public class Empleados implements Serializable{
   
    private static final long SerialVersionUID=1L;
    private String idEmpleado;
    private String name;
    private static HashMap<String,String> hm=new HashMap<>();
    
    public Empleados(String idEmpleado, String name) {
        this.idEmpleado = idEmpleado;
        this.name = name;
        if(hm.containsKey(idEmpleado)){
            throw new IllegalArgumentException("Un empleado con este ID ya esta registrado");
        }
        else
        hm.put(idEmpleado, name);
    }
    public void verHM(){
        System.out.println(hm.toString());
    }
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
