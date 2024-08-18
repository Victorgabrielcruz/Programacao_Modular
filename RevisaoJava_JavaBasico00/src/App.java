
import java.util.Scanner;

public class App {
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Exercicio 1-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=

    /**
     * Solicita ao usuário uma sequência de números inteiros separados por
     * espaço ou ponto e vírgula.
     *
     * @return a sequência de números inserida pelo usuário
     */
    public static String receberEntradaNumerica() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma sequência de números inteiros separados por espaço ou ponto e vírgula:");
        String entrada = scanner.nextLine();
        return entrada;
    }

    /**
     * Converte a string de entrada em um vetor de inteiros. Aceita separadores
     * de espaços ou ponto e vírgula.
     *
     * @param entrada a sequência de números como string
     * @return um vetor de inteiros correspondente à sequência fornecida
     */
    public static int[] transformarStringParaVetorInteiros(String entrada) {
        String[] partes = entrada.replace(";", " ").split("\\s+");
        int[] vetor = new int[partes.length];
        for (int i = 0; i < partes.length; i++) {
            vetor[i] = Integer.parseInt(partes[i]);
        }
        return vetor;
    }

    /**
     * Inverte os elementos de um vetor de inteiros.
     *
     * @param vetor o vetor de inteiros a ser invertido
     */
    public static void reverterVetor(int[] vetor) {
        for (int i = 0; i < vetor.length / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[vetor.length - 1 - i];
            vetor[vetor.length - 1 - i] = temp;
        }
    }

    /**
     * Exibe o vetor de inteiros invertido.
     *
     * @param vetor o vetor invertido a ser exibido
     */
    public static void imprimirVetorInvertido(int[] vetor) {
        System.out.print("Vetor invertido: ");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Executa o exercício 01, onde o usuário insere uma sequência de números
     * inteiros e o programa inverte os elementos do vetor.
     */
    public static void exercicio01() {
        String input = receberEntradaNumerica();
        int[] vetor = transformarStringParaVetorInteiros(input);
        reverterVetor(vetor);
        imprimirVetorInvertido(vetor);
    }

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Exercicio 6-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=
    /**
     * Solicita ao usuário a entrada de um número de dois dígitos.
     *
     * @return o número inserido pelo usuário
     */
    public static int lerNumero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número de 2 dígitos para multiplicar por 11:");
        return scanner.nextInt();
    }

    /**
     * Calcula o resultado da multiplicação do número por 11 utilizando a
     * técnica de soma dos dígitos.
     *
     * @param numero o número de dois dígitos
     * @return o resultado da multiplicação
     */
    public static int calcularMultiplicacaoPor11(int numero) {
        int unidade = numero % 10;
        int dezena = numero / 10;
        int soma = unidade + dezena;

        if (soma >= 10) {
            return (dezena + 1) * 100 + (soma % 10) * 10 + unidade;
        } else {
            return dezena * 100 + soma * 10 + unidade;
        }
    }

    /**
     * Exibe o resultado da multiplicação para o usuário.
     *
     * @param numero o número inserido pelo usuário
     * @param resultado o resultado da multiplicação por 11
     */
    public static void exibirResultado(int numero, int resultado) {
        System.out.println("Resultado de " + numero + " x 11 = " + resultado);
    }

    /**
     * Executa o exercício 06, onde o usuário insere um número de 2 dígitos e é
     * calculado o resultado de multiplicar esse número por 11.
     */
    public static void exercicio06() {
        int numero = lerNumero();
        int resultado = calcularMultiplicacaoPor11(numero);
        exibirResultado(numero, resultado);
    }

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Exercicio 8-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=
    /**
     * Solicita ao usuário uma data no formato DD/MM/2024.
     *
     * @return a data inserida pelo usuário
     */
    public static String obterData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma data no formato DD/MM/2024:");
        String data = scanner.nextLine();
        return data;
    }

    /**
     * Extrai o dia da data fornecida.
     *
     * @param data a data no formato DD/MM/2024
     * @return o dia da data fornecida
     */
    public static int pegarDia(String data) {
        return Integer.parseInt(data.substring(0, 2));
    }

    /**
     * Extrai o mês da data fornecida.
     *
     * @param data a data no formato DD/MM/2024
     * @return o mês da data fornecida
     */
    public static int pegarMes(String data) {
        return Integer.parseInt(data.substring(3, 5));
    }

    /**
     * Calcula o número total de dias desde 01/01/2024 até a data fornecida.
     *
     * @param dia o dia da data fornecida
     * @param mes o mês da data fornecida
     * @return o total de dias passados desde 01/01/2024
     */
    public static int computarTotalDias(int dia, int mes) {
        int[] diasMes = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // Dias em cada mês de 2024 (ano bissexto)
        int totalDias = dia;

        for (int i = 1; i < mes; i++) {
            totalDias += diasMes[i];
        }
        return totalDias;
    }

    /**
     * Calcula o dia da semana com base no total de dias passados desde
     * 01/01/2024.
     *
     * @param totalDias o total de dias desde 01/01/2024
     * @return o nome do dia da semana correspondente
     */
    public static String determinarDiaSemana(int totalDias) {
        String[] diasSemana = {"Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira",
            "Sábado", "Domingo"};
        return diasSemana[(totalDias - 1) % 7];
    }

    /**
     * Exibe o resultado calculado do dia da semana com base na data fornecida.
     *
     * @param data a data inserida pelo usuário
     * @param diaSemana o dia da semana correspondente à data
     */
    public static void mostrarResultado(String data, String diaSemana) {
        System.out.println("O dia " + data + " será uma " + diaSemana);
    }

    /**
     * Executa o exercício 08, onde o usuário insere uma data no formato
     * DD/MM/2024 e o programa calcula qual dia da semana corresponde à data
     * fornecida.
     */
    public static void exercicio08() {
        String data = obterData();
        int dia = pegarDia(data);
        int mes = pegarMes(data);
        int totalDias = computarTotalDias(dia, mes);
        String diaSemana = determinarDiaSemana(totalDias);

        mostrarResultado(data, diaSemana);
    }

//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Menu-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=
    /**
     * Exibe o menu e executa o exercício selecionado.
     */
    public static void menu() {
        int op;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha um número do exercício de 1 , 6 ou 8, caso deseja sair 9 para sair:");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    exercicio01();
                    break;
                case 6:
                    exercicio06();
                    break;
                case 8:
                    exercicio08();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Main-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=

    public static void main(String[] args) {
        menu();
    }
}
