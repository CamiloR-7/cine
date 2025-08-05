package cine.infraestructura.entrada.servicios;

import java.time.LocalDate;

public record Pelicula(
        Long id,
        String titulo,
        String genero,
        int duracion,
        String director,
        LocalDate estreno,
        String sinopsis,
        String posterUrl,
        String lenguaje,
        boolean estaActiva
) {
}