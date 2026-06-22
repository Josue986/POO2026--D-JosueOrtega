package ej_tallerpadel;

public class Ej_TallerPadel {
    public static void main(String[] args) {
        // 1. Creo  objeto partidoPadelOriginal
        PartidoPadel partidoOriginal = new PartidoPadel("Juan/Pedro", "Carlos/Luis", "6-3 / 7-5");
        String archivoBinario = "partido.dat";
        String archivoTexto = "partido.txt";

        System.out.println(" OBJETO ORIGINAL. ");
        System.out.println(partidoOriginal);
        System.out.println();

        // 2. Archivo Binario (.dat):
        System.out.println("--- Persistencia Binaria ---");
        GestorPadelBinario.guardarPartido(partidoOriginal, archivoBinario);
        PartidoPadel partidoCargadoBinario = GestorPadelBinario.cargarPartido(archivoBinario);
        System.out.println("Objeto recuperado de .dat: " + partidoCargadoBinario);
        System.out.println("--------------------------------------------------------------\n");

        // 3. Archivo de Texto (.txt):
        System.out.println("--- Persistencia de Texto ---");
        GestorPadelTexto.guardarPartido(partidoOriginal, archivoTexto);
        PartidoPadel partidoCargadoTexto = GestorPadelTexto.cargarPartido(archivoTexto);
        System.out.println("Objeto recuperado de .txt: " + partidoCargadoTexto);
        System.out.println("--------------------------------------------------------------");
    }
}
