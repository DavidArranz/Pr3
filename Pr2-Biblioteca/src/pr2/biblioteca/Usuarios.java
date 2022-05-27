/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr2.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;

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
public class Usuarios implements Serializable{
   
    private static final long SerialVersionUID=1L;
    private String name;
    private static ArrayList<String> usu=new ArrayList<>();

    public Usuarios(String name) {
        this.name = name;
        if(usu.contains(name)){
            throw new IllegalArgumentException("Ya hay un usuario registrado con ese nombre");
        }
        else
            usu.add(name);
    }

     public void verUsuarios(){
        System.out.println(usu.toString());
    }
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
