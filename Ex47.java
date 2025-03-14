/*47º) Realizando através de busca binária iterativa, resolver o exercício no. 35 desta lista. */

import java.util.Scanner;

public class Ex47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Digitar a quantidade de corredores inscritos
        System.out.println("Digite a quantidade de corredores inscritos:");
        int quantidadeCorredores = scanner.nextInt();

        // Criar uma matriz para armazenar as informações
        int[][] matriz = new int[quantidadeCorredores][3];

        // Digitar as informações dos corredores
        for (int i = 0; i < quantidadeCorredores; i++) {
            System.out.println("Digite o número de inscrição do corredor " + (i + 1) + ":");
            matriz[i][0] = scanner.nextInt();

            System.out.println("Digite a posição de chegada do corredor " + (i + 1) + ":");
            matriz[i][1] = scanner.nextInt();

            System.out.println("Digite o tempo de prova do corredor " + (i + 1) + " em segundos:");
            matriz[i][2] = scanner.nextInt();
        }

        // Realizar a busca da posição de chegada e do tempo de prova para um determinado corredor
        System.out.println("Digite o número de inscrição do corredor que deseja buscar:");
        int numeroInscricaoBuscar = scanner.nextInt();

        // Busca binária iterativa
        int indice = buscaBinaria(matriz, numeroInscricaoBuscar);

        if (indice != -1) {
            System.out.println("Posição de chegada: " + matriz[indice][1]);
            System.out.println("Tempo de prova: " + matriz[indice][2] + " segundos");
        } else {
            System.out.println("Corredor não encontrado");
        }
    }

    public static int buscaBinaria(int[][] matriz, int numeroInscricaoBuscar) {
        int inicio = 0;
        int fim = matriz.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (matriz[meio][0] == numeroInscricaoBuscar) {
                return meio;
            } else if (matriz[meio][0] < numeroInscricaoBuscar) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // não encontrado
    }
}