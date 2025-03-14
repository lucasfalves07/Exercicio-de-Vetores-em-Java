/*39º) Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
capaz de receber, via teclado, 10 elementos tipo int de um vetor e um outro elemento
tipo int com o qual será feita uma busca linear no vetor digitado, ao longo dos seus
índices ímpares somente, no sentido do menor índice para o maior índice. O programa
deverá informar o valor do menor índice do vetor que contém o elemento igual ao valor
digitado. Ex.:
Índice: 0 1 2 3 4 5 6 7 8 9
Elementos Digitados: 7 3 4 5 8 4 7 8 9 4
Número Digitado: 4 -> Resposta: O número 4 está localizado no índice 5 do vetor. */

import java.util.Scanner;

public class Ex39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um vetor para armazenar os elementos
        int[] vetor = new int[10];

        // Digitar os elementos do vetor
        System.out.println("Digite os 10 elementos do vetor:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.nextInt();
        }

        // Digitar o número a ser buscado
        System.out.println("Digite o número a ser buscado:");
        int numeroBuscar = scanner.nextInt();

        // Busca linear recursiva
        int indice = buscaLinearRecursiva(vetor, numeroBuscar, 0);

        if (indice != -1) {
            System.out.println("O número " + numeroBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O número " + numeroBuscar + " não foi encontrado no vetor.");
        }
    }

    public static int buscaLinearRecursiva(int[] vetor, int numeroBuscar, int indice) {
        if (indice >= vetor.length) {
            return -1; // não encontrado
        } else if (vetor[indice] == numeroBuscar && indice % 2 != 0) {
            return indice;
        } else {
            return buscaLinearRecursiva(vetor, numeroBuscar, indice + 1);
        }
    }
}