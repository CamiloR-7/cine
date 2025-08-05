package cine.infraestructura.entrada.terminal.consola.ui;

public record Formato(
        String horizontal,
        String vertical,
        String esquinaSupIzq,
        String esquinaSupDer,
        String esquinaInfIzq,
        String esquinaInfDer,
        String cruceDer,
        String cruceIzq,
        String cruceArriba,
        String cruceAbajo,
        String cruceCentro
) {}