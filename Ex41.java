/*41º) Elaborar um programa, em linguagem Java, que utilize apenas métodos recursivos,
capaz de receber, via teclado, 10 elementos tipo double de um vetor e um outro
elemento tipo double com o qual será feita uma busca linear no vetor digitado, ao longo
de todos os seus índices, no sentido do menor índice para o maior índice. O programa
deverá informar o valor do maior índice do vetor que contém o elemento igual ao valor
digitado. Ex.:
Índice: 0 1 2 3 4 5 6 7 8 9
Elementos Digitados: 7 3 4 5 8 4 7 4 9 8
Número Digitado: 4 -> Resposta: O número 4 está localizado no índice 7 do vetor. */

import java.util.Scanner;

public class Ex41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um vetor para armazenar os elementos
        double[] vetor = new double[10];

        // Digitar os elementos do vetor
        System.out.println("Digite os 10 elementos do vetor:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.nextDouble();
        }

        // Digitar o número a ser buscado
        System.out.println("Digite o número a ser buscado:");
        double numeroBuscar = scanner.nextDouble();

        // Busca linear recursiva
        int indice = buscaLinearRecursiva(vetor, numeroBuscar, 0);

        if (indice != -1) {
            System.out.println("O número " + numeroBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O número " + numeroBuscar + " não foi encontrado no vetor.");
        }
    }

    public static int buscaLinearRecursiva(double[] vetor, double numeroBuscar, int indice) {
        if (indice >= vetor.length) {
            return -1; // não encontrado
        } else if (vetor[indice] == numeroBuscar) {
            // Verificar se é o último índice com o valor buscado
            if (indice == vetor.length - 1 || vetor[indice + 1] != numeroBuscar) {
                return indice;
            } else {
                return buscaLinearRecursiva(vetor, numeroBuscar, indice + 1);
            }
        } else {
            return buscaLinearRecursiva(vetor, numeroBuscar, indice + 1);
        }
    }
}