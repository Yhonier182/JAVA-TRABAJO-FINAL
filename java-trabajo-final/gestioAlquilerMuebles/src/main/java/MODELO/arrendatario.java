/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELO;

/**
 * @author JHONIER ARIAS
 */
public class arrendatario {

    private int identificacion;
    private String nombre;
    private String apellido;
    private int contacto;
    private String referencias;
    private int propiedadAlquilada;


    public arrendatario(int identificacion, String nombre, String apellido, int contacto, String referencias ) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.referencias = referencias;

    }

    public arrendatario(String nombre, String apellido, int contacto, String referencias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.referencias = referencias;
    }




    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPropiedadAlquilada() {
        return propiedadAlquilada;
    }

    public void setPropiedadAlquilada(int propiedadAlquilada) {
        this.propiedadAlquilada = propiedadAlquilada;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
}
