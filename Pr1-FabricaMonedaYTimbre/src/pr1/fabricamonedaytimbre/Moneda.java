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
 * Desarrollada por David Arranz en la empresa IES El Grao el dia siete de
 * octubre de 2021
 *
 * Puede contactar conmigo en 10802894@ieselgrao.org
 *
 * /**
 *
 * @author David Arranz
 * @version 1.0
 * @date 9 mar. 2022
 */
public class Moneda extends Dinero implements java.io.Serializable {

    private static final long SerialVersionUID = 1L;
    private double diametro;
    private double peso;

    public Moneda(double diametro, double peso, double valor, int anyo) {
        super(valor, anyo);
        if (diametro < 0) {
            throw new IllegalArgumentException("El diametro no puede ser negativo.");
        }
        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo.");
        }
        this.diametro = diametro;
        this.peso = peso;
    }

    public Moneda(Moneda obj) {
        super(obj);
        this.diametro = obj.diametro;
        this.peso = obj.peso;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "MONEDA\n" + super.toString() + "Diametro: " + diametro + "\n"
                + "Peso: " + peso + "\n";
    }

}
