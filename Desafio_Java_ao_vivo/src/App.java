
import java.util.Scanner;

public class App {

    /*Uma caminhada em passo regular consome 230 calorias por hora. 
    Supondo que uma pessoa mantém uma rotina de caminhadas, faça um programa Java que leia quantas horas
    e minutos uma pessoa caminha por dia, quantos dias por semana ela faz esta caminhada e responda com o 
    total de calorias gastas por dia, por semana e por mês. Para o cálculo mensal, considere 4,5 semanas.  */
    public static void EntraDados(int horas, int minutos, int dias) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite quantas horas e quantos minutos voce caminha por dia (2:30):");
        String[] dados = scanner.nextLine().split(":");
        horas = Integer.parseInt(dados[0]);
        minutos = Integer.parseInt(dados[1]);
        System.out.println("Digite quantos dias por semana você faz caminhada:");
        dias = scanner.nextInt();
        scanner.close();
    }

    public static void Exercicio_01() {
        final int calorias_hora = 230;
        final double semanas_mes = 4.5;
        int horas;
        int minutos;
        int dias;
        EntraDados(horas, minutos, dias);

        //CalculaCaloriasDias(horas, minutos);
        //double calorias_Semana = CalculaCaloriasSemana(horas, minutos, dias);
        //CalculaCaloriasMes();
    }

    public static void Exercicio_02() {

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
