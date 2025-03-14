/*54º) Realizando através de busca binária recursiva, resolver o exercício no. 44 desta lista. */

import java.util.Scanner;

public class Ex54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um vetor para armazenar os números
        int[] vetor = new int[15];

        // Carregar o vetor com números digitados pelo operador
        System.out.println("Digite 15 números:");
        for (int i = 0; i < 15; i++) {
            vetor[i] = scanner.nextInt();
        }

        // Solicitar a digitação do número de busca
        System.out.println("Digite o número de busca:");
        int numeroBuscar = scanner.nextInt();

        // Realizar a busca linear
        int indice = buscaLinear(vetor, numeroBuscar);

        // Apresentar o resultado da busca linear
        if (indice != -1) {
            System.out.println("O número " + numeroBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O número " + numeroBuscar + " não foi encontrado no vetor.");
        }
    }

    public static int buscaLinear(int[] vetor, int numeroBuscar) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numeroBuscar) {
                return i;
            }
        }
        return -1; // não encontrado
    }
}