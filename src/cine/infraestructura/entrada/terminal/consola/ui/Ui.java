package cine.infraestructura.entrada.terminal.consola.ui;

import java.util.List;

public abstract class Ui {
    protected final Formato formato;
    protected final List<List<String>> textos;

    public Ui(Formato formato, List<List<String>> textos) {
        this.formato = formato;
        this.textos = textos;
    }

    protected abstract String ui();
}