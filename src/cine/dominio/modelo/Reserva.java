package cine.dominio.modelo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Reserva {
    private final UUID id;
    private final UUID clienteId;
    private final UUID funcionId;
    private EstadoReserva estado;
    private final List<Asiento> asientos;
    private final LocalDateTime fechaReserva;


    public Reserva(UUID id, UUID clienteId, UUID funcionId, List<Asiento> asientos, LocalDateTime fechaReserva) {
        this.id = id;
        this.clienteId = clienteId;
        this.funcionId = funcionId;
        this.asientos = asientos;
        this.fechaReserva = fechaReserva;
    }
}
