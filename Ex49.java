/*49º) Elaborar um programa, em linguagem Java, capaz de receber, via teclado, 10
elementos tipo int de um vetor e um outro elemento tipo int com o qual será feita uma
busca binária recursiva no vetor digitado, ao longo de todos os seus índices e no sentido
do menor para o maior índice. O programa deverá informar o valor do menor índice do
vetor que contém o elemento igual ao valor digitado. Ex.:
Índice: 0 1 2 3 4 5 6 7 8 9
Elementos Digitados: 7 3 4 5 8 4 7 8 9 4
Número Digitado: 4 -> Resposta: O número 4 está localizado no índice 2 do vetor. */

import java.util.Scanner;

public class Ex49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Digitar os 10 elementos do vetor
        int[] vetor = new int[10];
        System.out.println("Digite os 10 elementos do vetor:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.nextInt();
        }

        // Digitar o número a ser buscado
        System.out.println("Digite o número a ser buscado:");
        int numeroBuscar = scanner.nextInt();

        // Busca binária recursiva
        int indice = buscaBinariaRecursiva(vetor, numeroBuscar, 0, 9);

        if (indice != -1) {
            System.out.println("O número " + numeroBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O número " + numeroBuscar + " não foi encontrado no vetor.");
        }
    }

    public static int buscaBinariaRecursiva(int[] vetor, int numeroBuscar, int inicio, int fim) {
        if (inicio > fim) {
            return -1; // não encontrado
        }

        int meio = (inicio + fim) / 2;

        if (vetor[meio] == numeroBuscar) {
            // Verificar se é o menor índice
            if (meio == 0 || vetor[meio - 1] != numeroBuscar) {
                return meio;
            } else {
                return buscaBinariaRecursiva(vetor, numeroBuscar, inicio, meio - 1);
            }
        } else if (vetor[meio] < numeroBuscar) {
            return buscaBinariaRecursiva(vetor, numeroBuscar, meio + 1, fim);
        } else {
            return buscaBinariaRecursiva(vetor, numeroBuscar, inicio, meio - 1);
        }
    }
}