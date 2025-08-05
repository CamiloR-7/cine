package cine.infraestructura.entrada.terminal.consola.menu;

import cine.infraestructura.entrada.terminal.consola.ui.Formato;
import cine.infraestructura.entrada.terminal.consola.ui.Ui;
import cine.infraestructura.entrada.terminal.consola.utils.TextoUtils;

import java.util.List;

public class Menu extends Ui {
    private final List<String> titulo;
    private final List<String> opciones;
    private final int anchoTitulo;
    private final int altoTitulo;
    private final int lineaMediaTitulo;
    private final int anchoOpciones;
    private final int altoOpciones;
    private final int rango1;
    private final int rango2;

    public Menu(Formato formato, List<List<String>> textos, int paddingTitulo, int paddingOpciones) {
        super(formato, textos);
        this.titulo = textos.getFirst();
        this.opciones = textos.get(1);
        this.anchoTitulo = TextoUtils.calcularTextoMasLargo(titulo)  + paddingTitulo;
        this.altoTitulo = TextoUtils.calcularCantidadDeTextos(titulo);
        this.lineaMediaTitulo = TextoUtils.calcularMitadExacta(altoTitulo);
        this.anchoOpciones = TextoUtils.calcularTextoMasLargo(opciones)  + paddingOpciones;
        this.altoOpciones = TextoUtils.calcularCantidadDeTextos(opciones);
        this.rango1 = 8;
        this.rango2 = 7;
    }

    private String[] formatearTextoEncabezado(List<String> textos, int ancho, int alto) {
        String[] lineas = new String[alto];

        for (int i = 0; i < textos.size(); i++) {
            int espaciosRestantes = ancho - textos.get(i).length();
            int extraIzquierda = espaciosRestantes / 2;
            int extraDerecha = espaciosRestantes - extraIzquierda;

            String linea = formato.vertical() +
                    " ".repeat(extraIzquierda) +
                    textos.get(i) +
                    " ".repeat(extraDerecha) +
                    formato.vertical();

            lineas[i] = linea;
        }

        return lineas;
    }

    public String crearEncabezado() {
        StringBuilder encabezado = new StringBuilder();
        encabezado.append(" ".repeat(rango1))
                .append(formato.esquinaSupIzq())
                .append(formato.horizontal().repeat(anchoTitulo))
                .append(formato.esquinaSupDer())
                .append("\n");

        String[] textos = formatearTextoEncabezado(titulo, anchoTitulo, altoTitulo);
        for (int i = 0; i < altoTitulo; i++) {
            if (i < lineaMediaTitulo) {
                encabezado.append(" ".repeat(rango1))
                        .append(textos[i])
                        .append("\n");
            } else if (i == lineaMediaTitulo) {
                StringBuilder sb = new StringBuilder(textos[i]);
                sb.deleteCharAt(0);
                sb.insert(0, formato.cruceDer());

                encabezado.append(formato.esquinaSupIzq())
                        .append(formato.horizontal().repeat(rango2))
                        .append(sb)
                        .append("\n");
            } else {
                encabezado.append(formato.vertical())
                        .append(" ".repeat(rango2))
                        .append(textos[i])
                        .append("\n");
            }
        }
        encabezado.append(formato.vertical())
                .append(" ".repeat(rango2))
                .append(formato.esquinaInfIzq())
                .append(formato.horizontal().repeat(anchoTitulo))
                .append(formato.esquinaInfDer());

        return encabezado.toString();
    }

    private String crearUnion() {
        StringBuilder union = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            union.append(formato.vertical()).append("\n");
        }
        union.append(formato.esquinaInfIzq())
                .append(formato.horizontal().repeat(anchoTitulo - 10))
                .append(formato.esquinaSupDer());

        return union.toString();
    }

    private String[] formatearTextoOpciones(List<String> textos, int ancho, int alto) {
        String[] lineas = new String[alto];

        for (int i = 0; i < textos.size(); i++) {
            int espaciosRestantes = ancho - textos.get(i).length();
            int extraIzquierda = espaciosRestantes / 2;
            int extraDerecha = espaciosRestantes - extraIzquierda;

            String linea = formato.vertical() +
                    " " +
                    (i+1) +
                    ". " +
                    textos.get(i) +
                    " ".repeat(extraIzquierda) +
                    " ".repeat(extraDerecha) +
                    formato.vertical();

            lineas[i] = linea;
        }

        return lineas;
    }

    private String crearOpciones() {
        StringBuilder opciones = new StringBuilder();
        opciones.append(" ".repeat(anchoTitulo - 10 - anchoOpciones/2))
                .append(formato.esquinaSupIzq())
                .append(formato.horizontal().repeat(anchoOpciones/2))
                .append(formato.cruceAbajo())
                .append(formato.horizontal().repeat(TextoUtils.calcularMitadExacta(anchoOpciones) + 4))
                .append(formato.esquinaSupDer())
                .append("\n");

        String[] textos = formatearTextoOpciones(this.opciones, anchoOpciones, altoOpciones);

        for (int i = 0; i < altoOpciones; i++) {
            opciones.append(" ".repeat(anchoTitulo - 10 - anchoOpciones/2))
                    .append(textos[i])
                    .append("\n");
        }

        opciones.append(" ".repeat(anchoTitulo - 10 - anchoOpciones/2))
                .append(formato.esquinaInfIzq())
                .append(formato.horizontal().repeat(anchoOpciones + 4))
                .append(formato.esquinaInfDer());

        return opciones.toString();
    }

    @Override
    public String ui() {
        return crearEncabezado() + "\n" +  crearUnion() + "\n" + crearOpciones();
    }
}