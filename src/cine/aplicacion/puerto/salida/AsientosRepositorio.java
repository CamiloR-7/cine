package cine.aplicacion.puerto.salida;

import cine.infraestructura.entrada.servicios.sucursal.Sala;

public interface AsientosRepositorio {
    void imprimirAsientos(Sala asiento);
    boolean reservarAsiento(Sala asiento);
    boolean validarAsiento(Sala asiento);
}
