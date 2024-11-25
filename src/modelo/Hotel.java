package modelo;

public class Hotel extends Hospederia{

    private Boolean conDesayuno;

    public Hotel(int valorBaseNoche, DatosCliente datosCliente, String tipoTemporada, int cantidadNoches, int capacidad, Boolean esFumador, Boolean conDesayuno) {
        super(valorBaseNoche, datosCliente, tipoTemporada, cantidadNoches, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public Boolean getConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(Boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

    public int adicional() {
        // Obtiene el subtotal utilizando el método de la clase padre
        int subtotal = subtotal();
        // Verifica las condiciones
        if (esFumador && conDesayuno) {
            // Calcula y devuelve el 30% del subtotal
            return (int) (subtotal * 0.3);
        }
        // Si las condiciones no se cumplen, el adicional es 0
        return 0;
    }

    public int valoraCancelar() {
        // Obtiene el subtotal utilizando el método de la clase padre
        int subtotal = subtotal();
        // Verifica las condiciones
        if (TipoTemporada == "Baja") {
            // descuenta el 25% del subtotal si es temporada baja
            return (int) (subtotal - bonoDescuento());
        }
        if (TipoTemporada == "Media") {
            // descuenta el 12,5% del subtotal si es temporada media
            return (int) (subtotal - bonoDescuento());
        }

        if (esFumador && conDesayuno) {
            // adiciona el 30% del subtotal si la persona es fumadora y pide desayuno
            return (int) (subtotal + adicional());
        }

        // Si las condiciones no se cumplen, el adicional es 0
        return valoraCancelar();
    }

}
