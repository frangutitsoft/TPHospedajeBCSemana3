package modelo;

public class MedioDeAlojamiento {

protected int valorBaseNoche;
protected DatosCliente datosCliente;
protected String TipoTemporada;
protected int CantidadNoches;
protected int capacidad;

    public MedioDeAlojamiento(int valorBaseNoche, DatosCliente datosCliente, String tipoTemporada, int cantidadNoches, int capacidad) {
        this.valorBaseNoche = valorBaseNoche;
        this.datosCliente = datosCliente;
        TipoTemporada = tipoTemporada;
        CantidadNoches = cantidadNoches;
        this.capacidad = capacidad;
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public String getTipoTemporada() {
        return TipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        TipoTemporada = tipoTemporada;
    }

    public int getCantidadNoches() {
        return CantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        CantidadNoches = cantidadNoches;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int subtotal() {
        return CantidadNoches * valorBaseNoche;
    }

    public int bonoDescuento() {
        // Obtiene el subtotal utilizando el método de la clase padre
        int subtotal = subtotal();
        // Verifica las condiciones
        if (TipoTemporada == "Baja") {
            // Calcula y devuelve el 25% del subtotal si es temporada baja
            return (int) (subtotal * 0.25);
        }
        if (TipoTemporada == "Media") {
            // Calcula y devuelve el 12,5% del subtotal si es temporada media
            return (int) (subtotal * 0.125);
        }
        // Si las condiciones no se cumplen, el adicional es 0
        return 0;
    }


}
