package modelo;

public class Hospederia extends MedioDeAlojamiento {

    public Boolean esFumador;

    public Hospederia(int valorBaseNoche, DatosCliente datosCliente, String tipoTemporada, int cantidadNoches, int capacidad, Boolean esFumador) {
        super(valorBaseNoche, datosCliente, tipoTemporada, cantidadNoches, capacidad);
        this.esFumador = esFumador;
    }

    public Boolean getEsFumador() {
        return esFumador;
    }

    public void setEsFumador(Boolean esFumador) {
        this.esFumador = esFumador;
    }
}
