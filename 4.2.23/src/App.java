
import java.util.Scanner;

public class App {

    /**
     * Método principal para calcular e exibir o valor da série 1. A série 1
     * segue a fórmula: S = 1/N + 2/(N-1) + 3/(N-2) + ... + N/1 O método
     * continua pedindo valores de N até que o valor 0 seja informado.
     */
    public static void Serie_1() {
        double n;
        double s;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.err.println("Informe o valor de N");
            n = scanner.nextDouble();
            if (n == 0) {
                break;
            }
            s = somarSerie1(n);
            System.out.println("Resultado Série 1: " + s);
        }
    }

    /**
     * Calcula o valor da Série 1 para um dado N. A fórmula usada é: S = 1/N +
     * 2/(N-1) + ... + N/1
     *
     * @param n O valor de N fornecido pelo usuário.
     * @return O valor calculado da série S.
     */
    public static double somarSerie1(double n) {
        double soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i / (n - i + 1); // Implementa a lógica da Série 1
        }
        return soma;
    }

    /**
     * Método principal para calcular e exibir o valor da série 2. A série 2
     * segue a fórmula harmônica: H = 1 + 1/2 + 1/3 + ... + 1/N O método
     * continua pedindo valores de N até que o valor 0 seja informado.
     */
    public static void Serie_2() {
        double n;
        double h;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.err.println("Informe o valor de N");
            n = scanner.nextDouble();
            if (n == 0) {
                break;
            }
            h = somarSerie2(n);
            System.out.println("Resultado Série 2: " + h);
        }
    }

    /**
     * Calcula o valor da Série 2 (série harmônica) para um dado N. A fórmula
     * usada é: H = 1 + 1/2 + 1/3 + ... + 1/N
     *
     * @param n O valor de N fornecido pelo usuário.
     * @return O valor calculado da série H.
     */
    public static double somarSerie2(double n) {
        double soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += 1.0 / i;
        }
        return soma;
    }

    /**
     * Exibe o menu e executa a serie do exercício selecionado.
     */
    public static void menu() {
        int op;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Escolha se deseja calcular: \n [1]Serie_01 \n [2]Serie_02 \n [3]Sair \n Digite apenas o numero da opção: ");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    Serie_1();
                    break;
                case 2:
                    Serie_2();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
