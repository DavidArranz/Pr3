/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pr2.biblioteca;

import java.io.Serializable;

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
public class Libros implements Serializable{
   
    private static final long SerialVersionUID=1L;
    private String titulo;
    private String autor;
    private String editorial;
    private boolean estado_p=false;
    private int ubicacion;
    private String isbn;
    private double precio;
    private String prestado_por;
    private String usu;

    public Libros(String titulo, String autor, String editorial, int ubicacion, String isbn, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.ubicacion = ubicacion;
        this.isbn = isbn;
        this.precio = precio;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isEstado_p() {
        return estado_p;
    }

    public void setEstado_p(boolean estado_p) {
        this.estado_p = estado_p;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPrestado_por() {
        return prestado_por;
    }

    public void setPrestado_por(String prestado_por) {
        this.prestado_por = prestado_por;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }
    
    @Override
    public String toString(){
        String resto;
        if(usu!=null)
            resto=" -Prestado por: "+prestado_por+"\n -Usuario: "+usu+"\n";
        else
            resto="";
        if(estado_p==true){
        return " -Titulo: "+titulo+"\n"
                + " -Autor: "+autor+"\n"
                + " -Editorial: "+editorial+"\n"
                + " -Estado: prestado\n"
                + " -Ubicacion: "+ubicacion+"\n"
                + " -ISBN: "+isbn+"\n"
                + " -Precio: "+precio+"\n"+resto;}
        else{
        return " -Titulo: "+titulo+"\n"
                + " -Autor: "+autor+"\n"
                + " -Editorial: "+editorial+"\n"
                + " -Estado: sin prestar\n"
                + " -Ubicacion: "+ubicacion+"\n"
                + " -ISBN: "+isbn+"\n"
                + " -Precio: "+precio+"\n"+resto;}
    }
}
