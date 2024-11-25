package vista;

import controlador.Controlador;
import modelo.Hotel;
import modelo.MedioDeAlojamiento;

import java.util.Scanner;

public class App {
    private Controlador controlador;
    private Scanner scanner;

    public App() {
        controlador = new Controlador();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar Medio de Alojamiento");
            System.out.println("2. Mostrar medios de alojamiento");
            System.out.println("3. Datos de un cliente X");
            System.out.println("4. Total adicional");
            System.out.println("5. Total bono descuento");
            System.out.println("6. Cantidad medios de alojamiento X");
            System.out.println("7. Valor a cancelar por un cliente X");
            System.out.println("8. Aplicar incremento del valor base");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> ingresarMedioDeAlojamiento();
                case 2 -> mostrarMediosDeAlojamiento();
                case 3 -> datosCliente();
                case 4 -> totalAdicional();
                case 5 -> totalBonoDescuento();
                case 6 -> cantidadMediosDeAlojamiento();
                case 7 -> valorCancelarCliente();
                case 8 -> aplicarIncremento();
                case 9 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 9);
    }

    private void ingresarMedioDeAlojamiento() {
        System.out.println("Ingrese el tipo de alojamiento (Carpa, Cabaña, Hotel): ");
        String tipo = scanner.nextLine();
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("RUT del cliente: ");
        String rut = scanner.nextLine();
        DatosCliente cliente = new DatosCliente(nombre, rut);

        System.out.print("Valor base por noche: ");
        int valorBaseNoche = scanner.nextInt();
        System.out.print("Tipo de temporada (Alta, Media, Baja): ");
        scanner.nextLine();
        String temporada = scanner.nextLine();
        System.out.print("Cantidad de noches: ");
        int cantidadNoches = scanner.nextInt();
        System.out.print("Capacidad: ");
        int capacidad = scanner.nextInt();

        MedioDeAlojamiento alojamiento = switch (tipo.toLowerCase()) {
            case "hotel" -> {
                System.out.print("¿Con desayuno? (true/false): ");
                boolean conDesayuno = scanner.nextBoolean();
                System.out.print("¿Fumador? (true/false): ");
                boolean esFumador = scanner.nextBoolean();
                yield new Hotel(valorBaseNoche, cliente, temporada, cantidadNoches, capacidad, esFumador, conDesayuno);
            }
            case "cabaña" -> {
                System.out.print("¿Fumador? (true/false): ");
                boolean esFumador = scanner.nextBoolean();
                System.out.print("Capacidad de la cabaña: ");
                int capacidadCabagna = scanner.nextInt();
                yield new Cabagna(valorBaseNoche, cliente, temporada, cantidadNoches, capacidad, esFumador, capacidadCabagna);
            }
            default -> null; // Manejo para tipo "Carpa" o casos no válidos
        };

        if (alojamiento != null && controlador.agregarAlojamiento(alojamiento)) {
            System.out.println("Alojamiento registrado exitosamente.");
        } else {
            System.out.println("El cliente ya tiene un alojamiento asignado o el tipo no es válido.");
        }
    }

    private void mostrarMediosDeAlojamiento() {
        var alojamientos = controlador.obtenerAlojamientos();
        if (alojamientos.isEmpty()) {
            System.out.println("No hay alojamientos registrados.");
        } else {
            alojamientos.forEach(a -> System.out.println(a.toString()));
        }
    }

    private void datosCliente() {
        System.out.print("Ingrese el RUT del cliente: ");
        String rut = scanner.nextLine();
        MedioDeAlojamiento alojamiento = controlador.buscarAlojamientoPorCliente(rut);
        if (alojamiento != null) {
            System.out.println("Alojamiento: " + alojamiento.toString());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private void totalAdicional() {
        System.out.println("Total adicional: " + controlador.calcularTotalAdicional());
    }

    private void totalBonoDescuento() {
        System.out.println("Total bono descuento: " + controlador.calcularTotalBonoDescuento());
    }

    private void cantidadMediosDeAlojamiento() {
        System.out.println("Cantidad total de alojamientos: " + controlador.cantidadAlojamientos());
    }

    private void valorCancelarCliente() {
        System.out.print("Ingrese el RUT del cliente: ");
        String rut = scanner.nextLine();
        MedioDeAlojamiento alojamiento = controlador.buscarAlojamientoPorCliente(rut);
        if (alojamiento instanceof Hotel) {
            System.out.println("Valor a cancelar: " + ((Hotel) alojamiento).valoraCancelar());
        } else {
            System.out.println("Cliente no encontrado o no corresponde a un hotel.");
        }
    }

    private void aplicarIncremento() {
        controlador.aplicarIncrementoCabanas();
        System.out.println("Incremento aplicado a las cabañas donde corresponde.");
    }

    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }
}
