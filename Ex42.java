/*42º) Elaborar um programa, em linguagem Java, capaz de receber 10 elementos
diferentes do tipo char, em ordem crescente, armazená-los em um vetor do mesmo tipo
e tamanho, no sentido do menor para o maior índice. O programa deverá pedir ao
operador para que digite mais um caractere, o qual será localizado no determinado
vetor. O programa apresentará em tela o resultado de uma busca binária por todos os
índices, do menor para o maior, informando ao operador o número do índice do vetor
no qual se encontra o caractere digitado, ou, se for o caso, que o caractere não se
encontra no vetor (utilizar o tamanho máximo do vetor como terminador da busca no
vetor). Utilizar um método iterativo de busca binária construído com passagem de
parâmetros.*/

import java.util.Scanner;

public class Ex42 {
    public static void main(String[] args) {
        char[] vetor = new char[10];
        Scanner scanner = new Scanner(System.in);

        // Leitura dos 10 elementos do vetor
        System.out.println("Digite 10 caracteres diferentes em ordem crescente:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.next().charAt(0);
        }

        // Leitura do caractere a ser buscado
        System.out.println("Digite um caractere para buscar:");
        char caractere = scanner.next().charAt(0);

        // Busca binária
        int indice = buscaBinaria(vetor, caractere);

        // Impressão do resultado
        if (indice != -1) {
            System.out.println("O caractere '" + caractere + "' foi encontrado no índice " + indice);
        } else {
            System.out.println("O caractere '" + caractere + "' não foi encontrado no vetor");
        }
    }

    public static int buscaBinaria(char[] vetor, char caractere) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == caractere) {
                return meio;
            } else if (vetor[meio] < caractere) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // não encontrado
    }
}


