/*40º) Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
capaz de receber, via teclado, 10 elementos tipo char de um vetor e um outro elemento
tipo char com o qual será feita uma busca linear no vetor digitado, ao longo de todos os
seus índices, no sentido do maior índice para o menor índice. O programa deverá
informar o valor do maior índice do vetor que contém o elemento igual ao valor digitado.
Ex.:
Índice: 0 1 2 3 4 5 6 7 8 9
Elementos Digitados: c d a b k a f g a w
Caractere Digitado: a -> Resposta: O caractere a está localizado no índice 8 do vetor. */

import java.util.Scanner;

public class Ex40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um vetor para armazenar os elementos
        char[] vetor = new char[10];

        // Digitar os elementos do vetor
        System.out.println("Digite os 10 elementos do vetor:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.next().charAt(0);
        }

        // Digitar o caractere a ser buscado
        System.out.println("Digite o caractere a ser buscado:");
        char caractereBuscar = scanner.next().charAt(0);

        // Busca linear recursiva
        int indice = buscaLinearRecursiva(vetor, caractereBuscar, 9);

        if (indice != -1) {
            System.out.println("O caractere " + caractereBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O caractere " + caractereBuscar + " não foi encontrado no vetor.");
        }
    }

    public static int buscaLinearRecursiva(char[] vetor, char caractereBuscar, int indice) {
        if (indice < 0) {
            return -1; // não encontrado
        } else if (vetor[indice] == caractereBuscar) {
            return indice;
        } else {
            return buscaLinearRecursiva(vetor, caractereBuscar, indice - 1);
        }
    }
}