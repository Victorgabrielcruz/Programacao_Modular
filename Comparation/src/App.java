import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {

    /**
     * Compara dois arquivos byte a byte.
     *
     * @param arquivo1 O caminho do primeiro arquivo.
     * @param arquivo2 O caminho do segundo arquivo.
     * @throws IOException Se ocorrer um erro ao abrir ou ler os arquivos.
     */
    public static void ComparaArquivos(String arquivo1, String arquivo2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(arquivo1);
                FileInputStream fis2 = new FileInputStream(arquivo2)) {

            int posicao = 1;
            ComparaArquivosByte(fis1, fis2, posicao);

        } catch (IOException e) {
            System.err.println("Erro ao abrir ou comparar arquivos: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Compara byte a byte dois fluxos de entrada de arquivos.
     *
     * @param fis1    O fluxo de entrada do primeiro arquivo.
     * @param fis2    O fluxo de entrada do segundo arquivo.
     * @param posicao A posição inicial do byte que está sendo comparado.
     * @throws IOException Se ocorrer um erro durante a leitura dos arquivos.
     */
    public static void ComparaArquivosByte(FileInputStream fis1, FileInputStream fis2, int posicao) throws IOException {
        int byte1, byte2;

        while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
            if (byte1 != byte2) {
                System.out.println("Arquivos são diferentes. Primeira diferença no byte: " + posicao);
                return;
            }
            posicao++;
        }

        if (fis1.read() == -1 && fis2.read() == -1) {
            System.out.println("Os arquivos são idênticos.");
        } else {
            System.out.println("Arquivos são diferentes. Um dos arquivos é maior.");
        }
    }

    /**
     * Recebe o caminho de um arquivo do usuário.
     *
     * @return O caminho do arquivo informado pelo usuário.
     */
    public static String RecebeArquivo() {
        Scanner scanne = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo conforme o exemplo (caminho/para/arquivo1.txt):");
        String arquivo = scanne.nextLine();
        return arquivo;
    }

    /**
     * Método principal que executa o programa.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        try {
            String arquivo1 = RecebeArquivo();
            String arquivo2 = RecebeArquivo();
            ComparaArquivos(arquivo1, arquivo2);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
