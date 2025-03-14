/*46º) Realizando através de busca binária iterativa, resolver o exercício no. 34 desta lista. */

import java.util.Scanner;

public class Ex46 {
    public static void main(String[] args) {
        char[] vetor = new char[15];
        Scanner scanner = new Scanner(System.in);

        // Carregar o vetor com uma string digitada pelo operador
        System.out.println("Digite uma string (máximo 15 caracteres):");
        String str = scanner.next();
        int tamanho = str.length();
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = str.charAt(i);
        }

        // Solicitar a digitação do caractere de busca
        System.out.println("Digite o caractere de busca:");
        char caractereBusca = scanner.next().charAt(0);

        // Busca linear
        int indiceLinear = buscaLinear(vetor, caractereBusca, tamanho);
        if (indiceLinear != -1) {
            System.out.println("O caractere de busca foi encontrado no índice " + indiceLinear + " (busca linear)");
        } else {
            System.out.println("O caractere de busca não foi encontrado (busca linear)");
        }

        // Busca binária iterativa
        int indiceBinaria = buscaBinaria(vetor, caractereBusca, tamanho);
        if (indiceBinaria != -1) {
            System.out.println("O caractere de busca foi encontrado no índice " + indiceBinaria + " (busca binária)");
        } else {
            System.out.println("O caractere de busca não foi encontrado (busca binária)");
        }
    }

    public static int buscaLinear(char[] vetor, char caractereBusca, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == caractereBusca) {
                return i;
            }
        }
        return -1; // não encontrado
    }

    public static int buscaBinaria(char[] vetor, char caractereBusca, int tamanho) {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == caractereBusca) {
                return meio;
            } else if (vetor[meio] < caractereBusca) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // não encontrado
    }
}