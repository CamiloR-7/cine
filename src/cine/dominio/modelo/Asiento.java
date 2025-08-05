package cine.dominio.modelo;

import cine.infraestructura.entrada.servicios.sucursal.Sala;

public record Asiento(
        Long id,
        String fila,
        int numero,
        Sala sala
) {
}