package cine.infraestructura.entrada.servicios.sucursal;

import java.util.UUID;

public record Sala(
        UUID uuid,
        String nombre,
        int asientosTotales
) {
}







//    private void marcar(String asiento) {
//        for (int i = 0; i < filas; i++) {
//            for (int j = 0; j < columnas; j++) {
//                if (asientos[i][j].equals(asiento)) {
//                    asientos[i][j] = "X";
//                }
//            }
//        }
//    }
//
//    public boolean reservarAsiento(String asiento) {
//        if (validarAsiento(asiento)) {
//            if (!ocupadosSet.contains(asiento)) {
//                marcar(asiento);
//                ocupadosSet.add(asiento);
//                return true;
//            }
//            System.out.printf("El asiento %s está ocupado.", asiento);
//            return false;
//        }
//        System.out.printf("El asiento %s no es válido.%n", asiento);
//        return false;
//    }
