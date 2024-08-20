
import java.util.Scanner;

public class Exercicio_02 {

    /*
     * Em uma eleição para síndico de um edifício de 13 andares, cada candidato
     * é representado pelo número do seu apartamento. Os apartamentos têm números
     * terminando em 01 ou 02, precedidos pelo andar em que estão;
     * por exemplo: 101 e 102 para o 1º andar, 401 e 402 para o 4º andar.
     * Votos com o número 00 são considerados brancos e votos com qualquer número inválido
     * são considerados nulos. A eleição termina ao receber um voto com valor 999.
     * 
     * Escreva um programa em Java que receba os votos da eleição e informe seu resultado,
     * tanto em votos absolutos como em porcentagem. O resultado não precisa estar na ordem
     * decrescente do número de votos, mas precisa informar quem venceu a eleição e incluir votos nulos
     * e brancos.
     */
    public static int[] coletaVotos() {
        Scanner scan = new Scanner(System.in);
        int[] votos = new int[26]; // 13 andares * 2 apartamentos
        int voto;
        int votosBrancos = 0;
        int votosNulos = 0;

        System.out.println("Adicione seu voto, coloque a numeração do apartamento do candidato que deseja votar:");
        while (true) {
            voto = scan.nextInt();
            if (voto == 999) {
                break;
            } else if (voto == 0) {
                votosBrancos++;
            } else if (voto % 100 == 1 || voto % 100 == 2) {
                int indice = (voto / 100 - 1) * 2 + (voto % 100 - 1);
                if (indice >= 0 && indice < votos.length) {
                    votos[indice]++;
                } else {
                    votosNulos++;
                }
            } else {
                votosNulos++;
            }
        }

        System.out.printf("Votos Brancos: %d\n", votosBrancos);
        System.out.printf("Votos Nulos: %d\n", votosNulos);

        return votos;
    }

    public static void calculaResultado(int[] votos) {
        int totalVotos = 0;
        int maxVotos = 0;
        int vencedor = -1;

        for (int i = 0; i < votos.length; i++) {
            totalVotos += votos[i];
            if (votos[i] > maxVotos) {
                maxVotos = votos[i];
                vencedor = i;
            }
        }

        for (int i = 0; i < votos.length; i++) {
            int apartamento = (i / 2 + 1) * 100 + (i % 2 + 1);
            double porcentagem = (double) votos[i] / totalVotos * 100;
            System.out.printf("Apartamento %d recebeu %d votos (%.2f%%)\n", apartamento, votos[i], porcentagem);
        }

        if (vencedor >= 0) {
            int apartamentoVencedor = (vencedor / 2 + 1) * 100 + (vencedor % 2 + 1);
            System.out.printf("O apartamento vencedor é o %d com %d votos.\n", apartamentoVencedor, maxVotos);
        }
    }

    public static void main(String[] args) {
        int[] votos = coletaVotos();
        calculaResultado(votos);
    }
}
