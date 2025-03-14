/*52º) Realizando através de busca binária recursiva, resolver o exercício no. 42 desta lista. */

import java.util.Scanner;

public class Ex52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar um vetor para armazenar os elementos
        char[] vetor = new char[10];

        // Digitar os elementos do vetor em ordem crescente
        System.out.println("Digite os 10 elementos do vetor em ordem crescente:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.next().charAt(0);
        }

        // Digitar o caractere a ser buscado
        System.out.println("Digite o caractere a ser buscado:");
        char caractereBuscar = scanner.next().charAt(0);

        // Busca binária iterativa
        int indice = buscaBinariaIterativa(vetor, caractereBuscar, 0, vetor.length - 1);

        if (indice != -1) {
            System.out.println("O caractere " + caractereBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O caractere " + caractereBuscar + " não se encontra no vetor.");
        }

        // Busca binária recursiva
        indice = buscaBinariaRecursiva(vetor, caractereBuscar, 0, vetor.length - 1);

        if (indice != -1) {
            System.out.println("O caractere " + caractereBuscar + " está localizado no índice " + indice + " do vetor.");
        } else {
            System.out.println("O caractere " + caractereBuscar + " não se encontra no vetor.");
        }
    }

    public static int buscaBinariaIterativa(char[] vetor, char caractereBuscar, int inicio, int fim) {
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == caractereBuscar) {
                return meio;
            } else if (vetor[meio] < caractereBuscar) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1; // não encontrado
    }

    public static int buscaBinariaRecursiva(char[] vetor, char caractereBuscar, int inicio, int fim) {
        if (inicio > fim) {
            return -1; // não encontrado
        }
        int meio = (inicio + fim) / 2;
        if (vetor[meio] == caractereBuscar) {
            return meio;
        } else if (vetor[meio] < caractereBuscar) {
            return buscaBinariaRecursiva(vetor, caractereBuscar, meio + 1, fim);
        } else {
            return buscaBinariaRecursiva(vetor, caractereBuscar, inicio, meio - 1);
        }
    }
}