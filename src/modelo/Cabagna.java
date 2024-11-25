package modelo;

public class Cabagna extends Hospederia{

    private int capacidadcabagna;

    public Cabagna(int valorBaseNoche, DatosCliente datosCliente, String tipoTemporada, int cantidadNoches, int capacidad, Boolean esFumador, int capacidadcabagna) {
        super(valorBaseNoche, datosCliente, tipoTemporada, cantidadNoches, capacidad, esFumador);
        this.capacidadcabagna = capacidadcabagna;
    }

    public int getCapacidadcabagna() {
        return capacidadcabagna;
    }

    public void setCapacidadcabagna(int capacidadcabagna) {
        this.capacidadcabagna = capacidadcabagna;
    }

    public int incrementaValorBase() {
        // Obtiene el subtotal utilizando el método de la clase padre
        int valorBaseNoche = getValorBaseNoche();
        // Verifica las condiciones
        if (capacidadcabagna > 5) {
            // aumenta el valor base de la noche en un %18 si la capacidad de la cabaña supera las 5 personas
            return (int) (valorBaseNoche * 1.18);
        }
        // Si las condiciones no se cumplen, el adicional es 0
        return valorBaseNoche;
    }
}
