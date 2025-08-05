package cine.infraestructura.entrada.terminal.consola.utils;

import java.util.List;

public final class TextoUtils {

    private TextoUtils() {}

    public static int calcularCantidadDeTextos(List<String> bloque) {
        return bloque.size();
    }

    public static int calcularTextoMasLargo(List<String> bloque) {
        return bloque.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static int calcularMitadExacta(int longitud) {
        return (longitud % 2 == 0) ? (longitud / 2) - 1 : (longitud / 2);
    }
}