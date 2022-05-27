/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr1.fabricamonedaytimbre;

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
 * @date 9 mar. 2022
 */
public abstract class Dinero  implements java.io.Serializable{
    private static final long SerialVersionUID=1L;
    protected double valor;
    protected int anyo;

    public Dinero(double valor, int anyo) {
        if (valor < 0) {
                throw new IllegalArgumentException("El valor no puede ser negativo.");
            }
        this.valor = valor;
        this.anyo = anyo;
    }
    public Dinero(Dinero obj){
        valor=obj.valor;
        anyo=obj.anyo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    
    public boolean equals(Dinero obj){
        if(obj instanceof Moneda&& this instanceof Moneda)
        return anyo==obj.anyo&&valor==obj.valor;
        else if(obj instanceof Billete&& this instanceof Billete)
            return anyo==obj.anyo&&valor==obj.valor;
        else
            return false;
    }
    
    public int compareTo(Dinero obj) {
    if(this.anyo<obj.anyo)
        return -1;
    else if(obj.anyo<this.anyo)
        return 1;
    else{
        if(obj.valor>this.valor)
            return 1;
        else if(obj.valor<this.valor)
            return -1;
        else
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Valor=" + valor + "\n Año=" + anyo +"\n";
    }
}
