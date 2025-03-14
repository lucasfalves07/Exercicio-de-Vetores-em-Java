/* 53º) Realizando através de busca binária recursiva, resolver o exercício no. 43 desta lista.*/

import java.util.Scanner;

public class Ex53 {
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

        // Busca linear
        int tentativasLinear = buscaLinear(vetor, caractereBuscar);

        // Busca binária iterativa
        int tentativasBinariaIterativa = buscaBinariaIterativa(vetor, caractereBuscar, 0, vetor.length - 1);

        // Busca binária recursiva
        int tentativasBinariaRecursiva = buscaBinariaRecursiva(vetor, caractereBuscar, 0, vetor.length - 1);

        System.out.println("Tentativas necessárias para localizar o elemento chave:");
        System.out.println("Busca Linear: " + tentativasLinear);
        System.out.println("Busca Binária Iterativa: " + tentativasBinariaIterativa);
        System.out.println("Busca Binária Recursiva: " + tentativasBinariaRecursiva);
    }

    public static int buscaLinear(char[] vetor, char caractereBuscar) {
        int tentativas = 0;
        for (int i = 0; i < vetor.length; i++) {
            tentativas++;
            if (vetor[i] == caractereBuscar) {
                return tentativas;
            }
        }
        return tentativas; // não encontrado
    }

    public static int buscaBinariaIterativa(char[] vetor, char caractereBuscar, int inicio, int fim) {
        int tentativas = 0;
        while (inicio <= fim) {
            tentativas++;
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == caractereBuscar) {
                return tentativas;
            } else if (vetor[meio] < caractereBuscar) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return tentativas; // não encontrado
    }

    public static int buscaBinariaRecursiva(char[] vetor, char caractereBuscar, int inicio, int fim) {
        int tentativas = 0;
        if (inicio > fim) {
            return tentativas; // não encontrado
        }
        tentativas++;
        int meio = (inicio + fim) / 2;
        if (vetor[meio] == caractereBuscar) {
            return tentativas;
        } else if (vetor[meio] < caractereBuscar) {
            return buscaBinariaRecursiva(vetor, caractereBuscar, meio + 1, fim);
        } else {
            return buscaBinariaRecursiva(vetor, caractereBuscar, inicio, meio - 1);
        }
    }
}