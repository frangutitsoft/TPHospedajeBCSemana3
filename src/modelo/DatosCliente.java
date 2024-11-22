package modelo;

public class DatosCliente {

    private String nombre;
    private String rutcliente;

    public DatosCliente(String nombre, String rutcliente) {
        this.nombre = nombre;
        this.rutcliente = rutcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutcliente() {
        return rutcliente;
    }

    public void setRutcliente(String rutcliente) {
        this.rutcliente = rutcliente;
    }
}
