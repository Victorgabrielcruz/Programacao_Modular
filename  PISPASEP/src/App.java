import java.util.Scanner;

public class App {

    /**
    * Recebe um número PIS/PASEP do usuário e armazena seus dígitos em um array de inteiros.
    * 
    * @return Um array de inteiros contendo os dígitos do número PIS/PASEP.
    */
    public static int[] RecebePisPaes(int[] pisPaes) {
        int tamanho = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número PIS/PASEP (sem o dígito verificador):");
        String input = scanner.nextLine().replaceAll(" ", "");;
        VerificaComprimeto(input, tamanho);
        
        for (int i = 0; i < input.length(); i++) {
            pisPaes[i] = Character.getNumericValue(input.charAt(i));
        }
        
        scanner.close();
        
        return pisPaes;
    }

    /**
     * Verifica o tamanho de uma string ou array, e caso não seja do tamanho desejado retorna uma excessão
     * @param input String ou array que deve ser verificado que deve ser verificada
     * @param tamanho Tamanho que a string ou array deve ter
     * @throws IllegalArgumentException Se o número fornecido não tiver exatamente o numero de digitos necessarios.
     */
    public static void VerificaComprimeto(String input , int tamanho){
        if (input.length() != tamanho) {
            String erro = "De se ter " + tamanho + " digitos";

            throw new IllegalArgumentException(erro);
        }
    }

    /**
     * Aplica pesos fixos aos dígitos do número PIS/PASEP.
     * Cada dígito é multiplicado por um peso correspondente, e o resultado é armazenado em um novo array.
     * 
     * @param pisPaes Um array de inteiros contendo os dígitos do número PIS/PASEP.
     * @return Um array de inteiros contendo os resultados das multiplicações dos dígitos pelos pesos.
     */ 
    public static int[] AplicarPeso(int[] pisPaes) {
        int tamanho = 10;
        int[] pesos = {3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] resultados = new int[tamanho];

        for (int i = 0; i < pisPaes.length; i++) {

            resultados[i] = pisPaes[i] * pesos[i];

        }
        
        return resultados;
    }
    
    /**
    * Calcula a soma dos resultados das multiplicações dos dígitos do número PIS/PASEP pelos pesos.
    * 
    * @param resultados Um array de inteiros contendo os resultados das multiplicações.
    * @return A soma dos resultados das multiplicações.
    */
    public static int SomaResultado(int[] resultados) {
        int soma = 0;
        
        for (int resultado : resultados) {

            soma += resultado;

        }
        
        return soma;
    }
    
    /**
    * Calcula o resto da divisão da soma dos resultados por 11.
    * 
    * @param soma A soma dos resultados das multiplicações.
     * @return O resto da divisão da soma por 11.
    */
    public static int CalculaResto(int soma) {

        return soma % 11;

    }

    /**
    * Calcula o dígito verificador com base no resto da divisão da soma dos resultados por 11.
    * Se o resultado for 10, o dígito verificador é 0.
    * 
    * @param resto O resto da divisão da soma por 11.
    * @return O dígito verificador calculado.
    */
    public static int CalculaDigitoVerificador(int resto) {
        int digitoVerificador = 11 - resto;

        if (digitoVerificador == 10) {

            digitoVerificador = 0;

        }

        return digitoVerificador;
    }

    /**
    * Compara o dígito verificador calculado com o dígito verificador informado.
    * 
    * @param digitoCalculado O dígito verificador calculado pela função `CalculaDigitoVerificador`.
    * @param digitoInformado O dígito verificador informado pelo usuário.
    * @return Retorna uma mensagem para usuario informando o digito verificado, caso o digito verificador esteja errado retorna uma mensagem informando o ocorrido
    */
    public static void CompararDigitoVerificador(int digitoCalculado, int digitoInformado) {
        String resposta = "Algo deu errado";

        if (digitoCalculado == digitoInformado){

            resposta = "O digito verificador é " + digitoCalculado;

        }

        System.err.println(resposta);
    }

    public static void main(String[] args) throws Exception {
        final int TAMANHO = 10;
        int[] pisPaes = new int[TAMANHO];
        int resultadoOperacao;
        int digitoVerificadorInformado;
        int digitoVerificador;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o digito verificador");
        digitoVerificadorInformado =  scanner.nextInt();

        pisPaes = RecebePisPaes(pisPaes);

        pisPaes = AplicarPeso(pisPaes);

        resultadoOperacao = SomaResultado(pisPaes);

        resultadoOperacao = CalculaResto(resultadoOperacao);

        digitoVerificador = CalculaDigitoVerificador(resultadoOperacao);

        CompararDigitoVerificador(digitoVerificador, digitoVerificadorInformado);

        scanner.close();
    }
}
