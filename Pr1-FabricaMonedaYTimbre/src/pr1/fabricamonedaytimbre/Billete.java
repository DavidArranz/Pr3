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
public class Billete extends Dinero implements java.io.Serializable{
    private static final long SerialVersionUID=1L;
    private double altura;
    private double anchura;

    public Billete(double altura, double anchura, double valor, int anyo) {
        super(valor, anyo);
        if (altura < 0) {
            throw new IllegalArgumentException("La altura no puede ser negativo.");
        }
        if (anchura < 0) {
            throw new IllegalArgumentException("La anchura no puede ser negativo.");
        }
        this.altura = altura;
        this.anchura = anchura;
    }

    public Billete(Billete obj) {
        super(obj);
        this.altura = obj.altura;
        this.anchura = obj.anchura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAnchura() {
        return anchura;
    }

    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }
    
    @Override
    public String toString() {
        return "BILLETE\n"+super.toString()+"Altura: "+altura+"\n"
                + "Anchura: "+anchura+"\n";
    }
}
