/*44º) Realizando através de busca binária iterativa, resolver o exercício no. 32 desta lista. */

import java.util.Scanner;

public class Ex44 {
    public static void main(String[] args) {
        int[] vetor = new int[15];
        Scanner scanner = new Scanner(System.in);

        // Carregar o vetor com 15 números digitados pelo operador
        System.out.println("Digite 15 números:");
        for (int i = 0; i < 15; i++) {
            vetor[i] = scanner.nextInt();
        }

        // Solicitar a digitação do número de busca
        System.out.println("Digite o número de busca:");
        int numeroBusca = scanner.nextInt();

        // Busca linear
        int indiceLinear = buscaLinear(vetor, numeroBusca);
        if (indiceLinear != -1) {
            System.out.println("O número de busca foi encontrado no índice " + indiceLinear + " (busca linear)");
        } else {
            System.out.println("O número de busca não foi encontrado (busca linear)");
        }

        // Busca binária iterativa
        int indiceBinaria = buscaBinaria(vetor, numeroBusca);
        if (indiceBinaria != -1) {
            System.out.println("O número de busca foi encontrado no índice " + indiceBinaria + " (busca binária)");
        } else {
            System.out.println("O número de busca não foi encontrado (busca binária)");
        }
    }

    public static int buscaLinear(int[] vetor, int numeroBusca) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numeroBusca) {
                return i;
            }
        }
        return -1; // não encontrado
    }

    public static int buscaBinaria(int[] vetor, int numeroBusca) {
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == numeroBusca) {
                return meio;
            } else if (vetor[meio] < numeroBusca) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // não encontrado
    }
}