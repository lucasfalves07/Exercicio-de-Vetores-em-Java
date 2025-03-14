/*55º) Realizando através de busca binária recursiva, resolver o exercício no. 45 desta lista. */

import java.util.Scanner;

public class Ex55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um vetor para armazenar os caracteres
        char[] vetor = new char[15];

        // Carregar o vetor com uma string digitada pelo operador
        System.out.println("Digite uma string com 15 caracteres:");
        String string = scanner.next();
        for (int i = 0; i < 15; i++) {
            vetor[i] = string.charAt(i);
        }

        // Solicitar a digitação do caractere de busca
        System.out.println("Digite o caractere de busca:");
        char caractereBuscar = scanner.next().charAt(0);

        // Realizar a busca linear
        int indice = buscaLinear(vetor, caractereBuscar);

        // Apresentar o resultado da busca linear
        if (indice != -1) {
            System.out.println("O caractere '" + caractereBuscar + "' está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O caractere '" + caractereBuscar + "' não foi encontrado no vetor.");
        }
    }

    public static int buscaLinear(char[] vetor, char caractereBuscar) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == caractereBuscar) {
                return i;
            }
        }
        return -1; // não encontrado
    }
}