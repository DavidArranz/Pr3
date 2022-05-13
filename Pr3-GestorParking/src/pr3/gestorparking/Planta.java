/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr3.gestorparking;

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
 * @date 9 may. 2022
 */
public class Planta {
    private static int plazas_lib=20;
    public static Vehiculo[] pt1 = new Vehiculo[20];
    public Planta(int plazas_lib) {
    }

    public int getPlazas_lib() {
        return plazas_lib;
    }

    public void setPlazas_lib(int plazas_lib) {
        this.plazas_lib = plazas_lib;
    }
    
    public boolean addcar(Vehiculo v){
        int i=0;
        for(Vehiculo vv : pt1){
            if(vv==null){
                pt1[i]=v;
                return true;
            }
            i++;
        }
        return false;
    }
    
    public int delcar(String m,String dni){
        int i=0;
        for(Vehiculo vv : pt1){
            if(vv.getMatricula().equals(m)&&vv.getDni().equals(dni)){
                pt1[i]=null;
                return i;
            }
            i++;
        }
        return -1;
    }
    public int getPlazasLibres(){
        int i=0,j=0;
        for(Vehiculo vv : pt1){
            if(pt1[i]==null){
                j++;
            }
            i++;
        }
        return j;
    }
    
    public int buscarPorDni(String dni){
        int i=0;
        for(Vehiculo vv : pt1){
            if(vv.getDni().equals(dni)){
                pt1[i]=null;
                return i;
            }
            i++;
        }
        return -1;
    }
    public int buscarPorMarca(){
        
        int i=0;
        for(Vehiculo vv : pt1){
            if(vv.getDni().equals(dni)){
                pt1[i]=null;
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public int buscarPorColor(){
        
    }
    
    public boolean mostrarCoche(int p){
        if(pt1[p]==null)
            return false;
        else
            System.out.println(pt1[p].toString());
            return true;
    }
    

    
    
    
}
