package cine.infraestructura.entrada.terminal.comandos;

public class ComandoSalir implements MenuComando {
    @Override
    public String getNombre() {
        return "Salir";
    }

    @Override
    public void ejecutar() {
        System.exit(0);
    }
}
