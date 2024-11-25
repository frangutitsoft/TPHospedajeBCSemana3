package controlador;

import modelo.MedioDeAlojamiento;

import java.util.ArrayList;

public class Controlador {
    private final ArrayList<MedioDeAlojamiento> alojamientos;

    public Controlador() {
        alojamientos = new ArrayList<>();
    }

    public boolean agregarAlojamiento(MedioDeAlojamiento alojamiento) {
        if (alojamientos.stream().anyMatch(a -> a.getDatosCliente().getRutcliente().equals(alojamiento.getDatosCliente().getRutcliente()))) {
            return false; // El cliente ya tiene un alojamiento asignado
        }
        alojamientos.add(alojamiento);
        return true;
    }

    public ArrayList<MedioDeAlojamiento> obtenerAlojamientos() {
        return alojamientos;
    }

    public MedioDeAlojamiento buscarAlojamientoPorCliente(String rut) {
        return alojamientos.stream()
                .filter(a -> a.getDatosCliente().getRutcliente().equals(rut))
                .findFirst()
                .orElse(null);
    }

    public int calcularTotalAdicional() {
        return alojamientos.stream()
                .filter(a -> a instanceof Hotel)
                .mapToInt(a -> ((Hotel) a).adicional())
                .sum();
    }

    public int calcularTotalBonoDescuento() {
        return alojamientos.stream()
                .mapToInt(MedioDeAlojamiento::bonoDescuento)
                .sum();
    }

    public void aplicarIncrementoCabanas() {
        alojamientos.stream()
                .filter(a -> a instanceof Cabagna)
                .forEach(a -> a.setValorBaseNoche(((Cabagna) a).incrementaValorBase()));
    }

    public int cantidadAlojamientos() {
        return alojamientos.size();
    }
}

