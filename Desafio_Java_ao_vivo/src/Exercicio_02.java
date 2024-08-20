
import java.util.Scanner;

public class Exercicio_02 {

    /*
     * Em uma eleição para síndico de um edifício de 13 andares, cada candidato
     *  é representado pelo número do seu apartamento. Os apartamentos têm números 
     * terminando em 01 ou 02, precedidos pelo andar em que estão
     * ; por exemplo: 101 e 102 para o 1º andar, 401 e 402 para o 4º andar. 
     * Votos com o número 00 são considerados brancos e votos com qualquer número inválido 
     * são considerados nulos. A eleição termina ao receber um voto com valor 999.


        Escreva um programa em Java que receba os votos da eleição e informe seu resultado,
         tanto em votos absolutos como em porcentagem. O resultado não precisa estar na ordem 
         decrescente do número de votos, mas precisa informar quem venceu a eleição e incluir votos nulos 
         e brancos.
     */

    public static int []ColetaVotos(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Adicione seu voto, coloque a numeração do apartamento do candidato que deseja votar:");
        int voto = 0;
        int operador = 0;
        int numero_de_votos = 30;
        int []votos = new int[numero_de_votos];
        while (voto != 999) {
            voto = scan.nextInt();
            if(voto % 101 == 0 || voto % 102 == 0){
                votos[operador] = voto;
                operador++;
            }
        }
        return votos;
     }

    public static int MaisVotados(int []votos){
        int vencedor = 0;
        int votado = 0;
        int apartamento = 101;
        int porcentagem = votos.length / 100;
        for(int j = 0; j < 28; j++){
            for(int i = 0; i < votos.length; i++ ){
                if(apartamento == votos[i]){
                    votado++;
                }
                if(apartamento % 101 == 0){
                   apartamento++; 
                }
                else{
                    apartamento += 99;
                }
            }
            if(vencedor < votado){
                vencedor = votado;
            }
            System.out.printf("Apartamento %d recebeu %d vots", apartamento, votado);
            System.out.printf("Apartamento %d recebeu %d % dos votos", apartamento, votado*porcentagem);

            System.out.println();
        }
        return vencedor;

    }
    public static void main(String[] args) throws Exception {
        int []votos = ColetaVotos();
        MaisVotados(votos);
    }
}
