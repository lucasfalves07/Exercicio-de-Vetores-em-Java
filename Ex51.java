/*51º) Resolver o exercício anterior desta lista, com os dados ordenados crescentemente,
ou seja, o dado com o valor mais baixo deverá estar posicionado no menor índice do
vetor e o dado com o valor mais alto deverá estar posicionado no maior índice do vetor. */

import java.util.Scanner;

public class Ex51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Digitar os 10 elementos do vetor
        char[] vetor = new char[10];
        System.out.println("Digite os 10 elementos do vetor:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.next().charAt(0);
        }

        // Ordenar o vetor em ordem crescente
        vetor = ordenarVetorCrescente(vetor);

        // Digitar o caractere a ser buscado
        System.out.println("Digite o caractere a ser buscado:");
        char caractereBuscar = scanner.next().charAt(0);

        // Busca linear recursiva
        int indice = buscaLinearRecursiva(vetor, caractereBuscar, 0);

        if (indice != -1) {
            System.out.println("O caractere " + caractereBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O caractere " + caractereBuscar + " não foi encontrado no vetor.");
        }
    }

    public static char[] ordenarVetorCrescente(char[] vetor) {
        return ordenarVetorCrescente(vetor, 0, vetor.length - 1);
    }

    public static char[] ordenarVetorCrescente(char[] vetor, int inicio, int fim) {
        if (inicio >= fim) {
            return vetor;
        }

        if (vetor[inicio] > vetor[fim]) {
            char temp = vetor[inicio];
            vetor[inicio] = vetor[fim];
            vetor[fim] = temp;
        }

        return ordenarVetorCrescente(vetor, inicio + 1, fim - 1);
    }

    public static int buscaLinearRecursiva(char[] vetor, char caractereBuscar, int indice) {
        if (indice >= vetor.length) {
            return -1; // não encontrado
        }

        if (vetor[indice] == caractereBuscar) {
            return indice;
        }

        return buscaLinearRecursiva(vetor, caractereBuscar, indice + 1);
    }
}