package MODELO;

public class alquiler {


    private  int idalquiler;
    private  int idarrendatario;
    private  int idpropiedades;
    private String nombreArrendatario;
    private String nombrePropiedad;

    public alquiler(int idalquiler, int idarrendatario, int idpropiedades, String nombreArrendatario, String nombrePropiedad) {
        this.idalquiler = idalquiler;
        this.idarrendatario = idarrendatario;
        this.idpropiedades = idpropiedades;
        this.nombreArrendatario = nombreArrendatario;
        this.nombrePropiedad = nombrePropiedad;
    }

    public alquiler(String nombreArrendatario, String nombrePropiedad) {
        this.nombreArrendatario = nombreArrendatario;
        this.nombrePropiedad = nombrePropiedad;
    }

    public alquiler(int idalquiler) {
        this.idalquiler= idalquiler;
    }


    public int getIdalquiler() {
        return idalquiler;
    }

    public void setIdalquiler(int idalquiler) {
        this.idalquiler = idalquiler;
    }

    public int getIdarrendatario() {
        return idarrendatario;
    }

    public void setIdarrendatario(int idarrendatario) {
        this.idarrendatario = idarrendatario;
    }

    public int getIdpropiedades() {
        return idpropiedades;
    }

    public void setIdpropiedades(int idpropiedades) {
        this.idpropiedades = idpropiedades;
    }

    public String getNombreArrendatario() {
        return nombreArrendatario;
    }

    public void setNombreArrendatario(String nombreArrendatario) {
        this.nombreArrendatario = nombreArrendatario;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }
}
