/*57º) Realizando através de busca binária recursiva, resolver o exercício no. 47 desta lista. */

import java.util.Scanner;

public class Ex57 {
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
        int[] resultadoBusca = buscaBinariaRecursiva(matriz, numeroInscricaoBuscar, 0, quantidadeCorredores - 1);

        // Apresentar o resultado da busca
        if (resultadoBusca != null) {
            System.out.println("Posição de chegada: " + resultadoBusca[1]);
            System.out.println("Tempo de prova: " + resultadoBusca[2] + " segundos");
        } else {
            System.out.println("Corredor não encontrado");
        }
    }

    public static int[] buscaBinariaRecursiva(int[][] matriz, int numeroInscricaoBuscar, int inicio, int fim) {
        if (inicio > fim) {
            return null; // não encontrado
        }
        int meio = (inicio + fim) / 2;
        if (matriz[meio][0] == numeroInscricaoBuscar) {
            return matriz[meio];
        } else if (matriz[meio][0] < numeroInscricaoBuscar) {
            return buscaBinariaRecursiva(matriz, numeroInscricaoBuscar, meio + 1, fim);
        } else {
            return buscaBinariaRecursiva(matriz, numeroInscricaoBuscar, inicio, meio - 1);
        }
    }
}