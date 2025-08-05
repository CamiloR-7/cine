package cine.infraestructura.entrada.terminal.metodos;

public class ValidarAsiento {
    private final int filas;
    private final int columnas;
    private final String asiento;

    public ValidarAsiento(int filas, int columnas, String asiento) {
        this.filas = filas;
        this.columnas = columnas;
        this.asiento = asiento;
    }

    public boolean validar() {
        char letraMax = (char) ('A' + filas - 1);
        String letraRegex = "[A-" + letraMax + "]";

        String numeroRegex;

        if (columnas < 10) {
            numeroRegex = "[1-" + columnas + "]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(?:[1-9]|");
            int decenas = columnas / 10;
            int resto = columnas % 10;

            for (int i = 1; i <= decenas; i++) {
                int limiteSuperior = (i == decenas) ? resto : 9;

                if (limiteSuperior == 0) {
                    sb.append(i).append("0");
                } else {
                    sb.append(i).append("[0-").append(limiteSuperior).append("]");
                }

                if (i < decenas) {
                    sb.append("|");
                }
            }
            sb.append(")");
            numeroRegex = sb.toString();
        }
        String regex = "^" + letraRegex + numeroRegex + "$";
        return asiento.matches(regex);
    }
}