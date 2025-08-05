package cine.infraestructura.entrada.terminal.metodos;

import java.util.Set;

public class CrearMatrizAsientos {
    private final int filas;
    private final int columnas;
    private final Set<String> asientosOcupados;

    public CrearMatrizAsientos(int filas, int columnas, Set<String> asientosOcupados) {
        this.filas = filas;
        this.columnas = columnas;
        this.asientosOcupados = asientosOcupados;
    }

    public String[][] parsear() {
        char letra = 'A';
        String[][] asientos = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String asiento = letra + Integer.toString(j + 1);
                if (asientosOcupados.contains(asiento)) {
                    asientos[i][j] = "X";
                } else {
                    asientos[i][j] = asiento;
                }
            }
            letra++;
        }
        return asientos;
    }
}