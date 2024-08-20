import java.util.Scanner;

public class Exercicio_01 {
    public static int[] EntraDados() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite quantas horas e quantos minutos voce caminha por dia (2:30):");
            String[] entrada = scanner.nextLine().split(":");
            int horas = Integer.parseInt(entrada[0]);
            int minutos = Integer.parseInt(entrada[1]);
            System.out.println("Digite quantos dias por semana você faz caminhada:");
            int dias = scanner.nextInt();
            if(horas >=0 && dias >= 0 && minutos>= 0){
                scanner.close();
                int []dados = {horas, minutos, dias};
                return dados;
            }
        }

    }

    public static double CalculaCaloriasDias(int horas , int minutos){
        final int calorias = 230;
        double calorias_dia;
        double calorias_minuto = minutos * (calorias/60);
        calorias_dia = calorias_minuto + (horas*calorias);
        System.err.println("Calorias dia:" + calorias_dia);
        return calorias_dia;
    }

    public static double CalculaCaloriasSemana(double  calorias_dia, int dias){
        double calorias_semana = calorias_dia * dias;
        System.err.println("Calorias semana:" + calorias_semana);
        return calorias_semana;
    }

    public static double CalculaCaloriasMes(double calorias_semana){
        final double semanas_mes = 4.5;
        double calorias_mes = calorias_semana*semanas_mes;
        System.err.println("Calorias mes:" + calorias_mes);
        return calorias_mes;

    }


    public static void Exercicio_01() {
        int []vet = EntraDados();
        int horas = vet[0];
        int minutos = vet[1];
        int dias = vet[2];
        double calorias_dia = CalculaCaloriasDias(horas, minutos);
        double calorias_Semana = CalculaCaloriasSemana(calorias_dia, dias);
        double calorias_mes = CalculaCaloriasMes(calorias_Semana);
    }

    //public static void Exercicio_02() {}

    public static void main(String[] args) throws Exception {
        Exercicio_01();
    }
}
