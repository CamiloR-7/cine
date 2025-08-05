package cine.dominio.repositorio;

import cine.dominio.modelo.Reserva;

public interface ReservaRepositorio {
    Reserva verReserva();
    Reserva reservar();
    Reserva eliminarReserva();
}