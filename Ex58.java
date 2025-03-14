/*58º) Realizando através de busca binária recursiva, resolver o exercício no. 48 desta lista. */

import java.util.Scanner;

public class Ex58 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Digitar a quantidade de alunos matriculados
        System.out.println("Digite a quantidade de alunos matriculados:");
        int quantidadeAlunos = scanner.nextInt();

        // Criar vetores para armazenar os RA e NOTA
        int[] ra = new int[quantidadeAlunos];
        double[] nota = new double[quantidadeAlunos];

        // Apresentar o menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("A) Cadastrar RA de todos os alunos matriculados");
            System.out.println("B) Cadastrar NOTA de prova para todos os alunos matriculados");
            System.out.println("C) Realizar a busca linear e apresentar a NOTA para um determinado RA");
            System.out.println("D) Sair do programa");
            System.out.println("Digite a opção desejada:");
            char opcao = scanner.next().charAt(0);

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
                    System.out.println("Opção inválida. Por favor, digite novamente.");
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
            System.out.println("Digite a NOTA do aluno " + (i + 1) + ":");
            nota[i] = scanner.nextDouble();
        }
    }

    public static void buscarNota(int[] ra, double[] nota, int quantidadeAlunos, Scanner scanner) {
        System.out.println("Digite o RA do aluno que deseja buscar:");
        int raBuscar = scanner.nextInt();
        int indice = buscaBinariaRecursiva(ra, raBuscar, 0, quantidadeAlunos - 1);
        if (indice != -1) {
            System.out.println("NOTA do aluno: " + nota[indice]);
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public static int buscaBinariaRecursiva(int[] ra, int raBuscar, int inicio, int fim) {
        if (inicio > fim) {
            return -1; // não encontrado
        }
        int meio = (inicio + fim) / 2;
        if (ra[meio] == raBuscar) {
            return meio;
        } else if (ra[meio] < raBuscar) {
            return buscaBinariaRecursiva(ra, raBuscar, meio + 1, fim);
        } else {
            return buscaBinariaRecursiva(ra, raBuscar, inicio, meio - 1);
        }
    }
}
