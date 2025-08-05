package cine.infraestructura.entrada.terminal.metodos;

public class ImprimirAsientos {
    private final int filas;
    private final int columnas;
    private final String[][] asientos;

    public ImprimirAsientos(int filas, int columnas, String[][] asientos) {
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = asientos;
    }

    public void mostrar() {
        char letra = 'A';

        System.out.println(" ".repeat(9) + "█".repeat(40) + "-".repeat(6) + " PANTALLA " + "-".repeat(6) + "█".repeat(40));
        System.out.println();
        for (int i = 0; i < filas; i++) {
            System.out.print("  → " + letra + "    ");
            for (int j = 0; j < columnas; j++) {
                if (asientos[i][j].equals("X")) {
                    System.out.print(" │[X]│ ");
                } else {
                    System.out.print(" (" + asientos[i][j] + ") ");
                }
            }
            letra++;
            System.out.println();
        }
        System.out.println("Asientos disponibles: " + (filas*columnas - asientos.length));
    }
}