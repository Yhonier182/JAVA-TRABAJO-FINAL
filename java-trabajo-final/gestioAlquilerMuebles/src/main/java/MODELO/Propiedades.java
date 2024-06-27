package MODELO;

public class Propiedades {

    private int idpropiedades;
    private  String nombrePropiedad;
    private String direccion;
    private  String tipoDePropiedad;
    private String tamano;
    private  int numhabitaciones;
    private  int  precio;
    private String disponibilidad;




    public Propiedades(int idpropiedades, String nombrePropiedad, String direccion, String tipoDePropiedad, String tamano, int numhabitaciones, int precio, String disponibilidad) {
        this.idpropiedades = idpropiedades;
        this.nombrePropiedad = nombrePropiedad;
        this.direccion = direccion;
        this.tipoDePropiedad = tipoDePropiedad;
        this.tamano = tamano;
        this.numhabitaciones = numhabitaciones;
        this.precio = precio;
        this.disponibilidad = disponibilidad;

    }

    public Propiedades(String nombrePropiedad, String direccion, String tipoDePropiedad, String tamano, int numhabitaciones, int precio, String disponibilidad) {
        this.nombrePropiedad = nombrePropiedad;
        this.direccion = direccion;
        this.tipoDePropiedad = tipoDePropiedad;
        this.tamano = tamano;
        this.numhabitaciones = numhabitaciones;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public int getIdpropiedades() {
        return idpropiedades;
    }

    public void setIdpropiedades(int idpropiedades) {
        this.idpropiedades = idpropiedades;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDePropiedad() {
        return tipoDePropiedad;
    }

    public void setTipoDePropiedad(String tipoDePropiedad) {
        this.tipoDePropiedad = tipoDePropiedad;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getNumhabitaciones() {
        return numhabitaciones;
    }

    public void setNumhabitaciones(int numhabitaciones) {
        this.numhabitaciones = numhabitaciones;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
