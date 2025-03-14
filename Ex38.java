/*38º) Elaborar um programa, em linguagem Java, que utilize apenas métodos iterativos,
capaz de receber, via teclado, 10 elementos tipo double de um vetor e um outro
elemento tipo double com o qual será feita uma busca linear no vetor digitado, ao longo
de todos os seus índices, no sentido do menor índice para o maior índice. O programa
deverá informar o valor do maior índice do vetor que contém o elemento igual ao valor
digitado. Ex.:
Índice: 0 1 2 3 4 5 6 7 8 9
Elementos Digitados: 7 3 4 5 8 4 7 4 9 8
Número Digitado: 4 -> Resposta: O número 4 está localizado no índice 7 do vetor. */

import java.util.Scanner;

public class Ex38 {
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

        // Busca linear
        int indice = buscaLinear(vetor, numeroBuscar);

        if (indice != -1) {
            System.out.println("O número " + numeroBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O número " + numeroBuscar + " não foi encontrado no vetor.");
        }
    }

    public static int buscaLinear(double[] vetor, double numeroBuscar) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numeroBuscar) {
                return i;
            }
        }
        return -1; // não encontrado
    }
}