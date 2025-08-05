package cine;

import cine.infraestructura.entrada.terminal.consola.menu.Menu;
import cine.infraestructura.entrada.terminal.consola.ui.Formato;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Formato formato = new Formato("═","║","╔","╗","╚","╝","╣","╠","╦","╩","╬");

        List<String> titulo = List.of("Mi nombre","es","Camilo Andres Regueros Chavez");
        List<String> opciones = List.of("26 años","185 cm","81 kg", "Masculino");

        List<List<String>> textos = List.of(titulo,opciones);

        Menu menu = new Menu(formato, textos, 5, 2);

        System.out.println(menu.ui());


    }
}