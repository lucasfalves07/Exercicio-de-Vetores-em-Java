/*48º) Realizando através de busca binária iterativa, resolver o exercício no. 36 desta lista. */

import java.util.Scanner;

public class Ex48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Digitar a quantidade de alunos matriculados
        System.out.println("Digite a quantidade de alunos matriculados:");
        int quantidadeAlunos = scanner.nextInt();

        // Criar vetores para armazenar os RAs e as notas
        int[] ra = new int[quantidadeAlunos];
        double[] nota = new double[quantidadeAlunos];

        // Menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("A) Cadastrar RA de todos os alunos matriculados.");
            System.out.println("B) Cadastrar NOTA de prova para todos os alunos matriculados.");
            System.out.println("C) Realizar a busca linear e apresentar a NOTA para um determinado RA.");
            System.out.println("D) Sair do programa.");

            // Digitar a opção escolhida
            System.out.println("Digite a opção escolhida:");
            char opcao = scanner.next().charAt(0);

            // Realizar a ação escolhida
            switch (opcao) {
                case 'A':
                    cadastrarRa(ra, quantidadeAlunos, scanner);
                    break;
                case 'B':
                    cadastrarNota(nota, quantidadeAlunos, scanner);
                    break;
                case 'C':
                    buscarNota(ra, nota, quantidadeAlunos, scanner);
                    break;
                case 'D':
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void cadastrarRa(int[] ra, int quantidadeAlunos, Scanner scanner) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Digite o RA do aluno " + (i + 1) + ":");
            ra[i] = scanner.nextInt();
        }
    }

    public static void cadastrarNota(double[] nota, int quantidadeAlunos, Scanner scanner) {
        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Digite a nota do aluno " + (i + 1) + ":");
            nota[i] = scanner.nextDouble();
        }
    }

    public static void buscarNota(int[] ra, double[] nota, int quantidadeAlunos, Scanner scanner) {
        System.out.println("Digite o RA do aluno que deseja buscar:");
        int raBuscar = scanner.nextInt();

        // Busca binária iterativa
        int indice = buscaBinaria(ra, raBuscar);

        if (indice != -1) {
            System.out.println("Nota do aluno: " + nota[indice]);
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public static int buscaBinaria(int[] ra, int raBuscar) {
        int inicio = 0;
        int fim = ra.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (ra[meio] == raBuscar) {
                return meio;
            } else if (ra[meio] < raBuscar) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1; // não encontrado
    }
}