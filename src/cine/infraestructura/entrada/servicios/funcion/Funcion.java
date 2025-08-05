package cine.infraestructura.entrada.servicios.funcion;

import cine.infraestructura.entrada.servicios.sucursal.Sala;
import cine.infraestructura.entrada.servicios.Pelicula;

import java.time.LocalDateTime;
import java.util.UUID;

public record Funcion(
        UUID id,
        LocalDateTime horaInicio,
        Sala sala,
        Pelicula pelicula
) {
}