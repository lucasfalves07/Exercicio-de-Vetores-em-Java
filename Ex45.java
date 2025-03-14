/*45º) Realizando através de busca binária iterativa, resolver o exercício no. 33 desta lista. */

import java.util.Scanner;

public class Ex45 {
    public static void main(String[] args) {
        char[] vetor = new char[15];
        Scanner scanner = new Scanner(System.in);

        // Carregar o vetor com uma string de 15 caracteres digitada pelo operador
        System.out.println("Digite uma string de 15 caracteres:");
        String str = scanner.next();
        for (int i = 0; i < 15; i++) {
            vetor[i] = str.charAt(i);
        }

        // Solicitar a digitação do caractere de busca
        System.out.println("Digite o caractere de busca:");
        char caractereBusca = scanner.next().charAt(0);

        // Busca linear
        int indiceLinear = buscaLinear(vetor, caractereBusca);
        if (indiceLinear != -1) {
            System.out.println("O caractere de busca foi encontrado no índice " + indiceLinear + " (busca linear)");
        } else {
            System.out.println("O caractere de busca não foi encontrado (busca linear)");
        }

        // Busca binária iterativa
        int indiceBinaria = buscaBinaria(vetor, caractereBusca);
        if (indiceBinaria != -1) {
            System.out.println("O caractere de busca foi encontrado no índice " + indiceBinaria + " (busca binária)");
        } else {
            System.out.println("O caractere de busca não foi encontrado (busca binária)");
        }
    }

    public static int buscaLinear(char[] vetor, char caractereBusca) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == caractereBusca) {
                return i;
            }
        }
        return -1; // não encontrado
    }

    public static int buscaBinaria(char[] vetor, char caractereBusca) {
        int inicio = 0;
        int fim = vetor.length - 1;

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