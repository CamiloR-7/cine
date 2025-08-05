package cine.infraestructura.salida;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ConexionArchivo {
    private final String ruta;
    private final Path rutaArchivo;

    public ConexionArchivo(String ruta) {
        this.ruta = ruta;
        this.rutaArchivo = Path.of(ruta);
    }

    public void contenido() {
        try (BufferedReader reader = Files.newBufferedReader(rutaArchivo)) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public List<String> listar(String identificador) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith(identificador)) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }

}
