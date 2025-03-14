/*36º) Elaborar um programa, em linguagem Java, que receba, via digitação, a quantidade
de alunos matriculados em uma universidade e apresente um menu contendo 3
possibilidades de escolha para o operador, realizando as respectivas funções:
A) Cadastrar RA de todos os alunos matriculados. (Utilizar um vetor do tipo int
para o RA, ocupando os mesmos índices do respectivo vetor de NOTA);
B) Cadastrar NOTA de prova para todos os alunos matriculados. (Utilizar um vetor
do tipo double para a NOTA, ocupando os mesmos índices do respectivo vetor
de RA);
C) Realizar a busca linear e apresentar a NOTA para um determinado RA, a ser
digitado;
D) Sair do programa. */

import java.util.Scanner;

public class Ex36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar a quantidade de alunos matriculados
        System.out.print("Digite a quantidade de alunos matriculados: ");
        int qtdAlunos = scanner.nextInt();
        
        int[] raAlunos = new int[qtdAlunos];
        double[] notas = new double[qtdAlunos];
        
        boolean raCadastrado = false;
        boolean notaCadastrada = false;
        
        char opcao;
        do {
            // Exibir menu de opções
            System.out.println("\nMENU:");
            System.out.println("A) Cadastrar RAs");
            System.out.println("B) Cadastrar Notas");
            System.out.println("C) Buscar Nota de um RA");
            System.out.println("D) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().toUpperCase().charAt(0);
            
            switch (opcao) {
                case 'A':
                    // Cadastrar os RAs
                    for (int i = 0; i < qtdAlunos; i++) {
                        System.out.print("Digite o RA do aluno " + (i + 1) + ": ");
                        raAlunos[i] = scanner.nextInt();
                    }
                    raCadastrado = true;
                    break;
                
                case 'B':
                    if (!raCadastrado) {
                        System.out.println("Primeiro cadastre os RAs antes das notas (opção A).");
                        break;
                    }
                    // Cadastrar as notas
                    for (int i = 0; i < qtdAlunos; i++) {
                        System.out.print("Digite a nota do aluno com RA " + raAlunos[i] + ": ");
                        notas[i] = scanner.nextDouble();
                    }
                    notaCadastrada = true;
                    break;
                case 'C':
                    if (!raCadastrado) {
                        System.out.println("Cadastre os RAs primeiro.");
                        break;
                    }
                    System.out.print("Digite o RA do aluno para buscar a nota: ");
                    int raBusca = scanner.nextInt();
                    int index = buscarNota(raAlunos, raBusca);
                    if (index != -1 && notaCadastrada) {
                        System.out.println("RA: " + raBusca + ", Nota: " + notas[index]);
                    } else {
                        System.out.println("RA não encontrado ou nota não cadastrada ainda.");
                    }
                    break;
                case 'D':
                    // Sair do programa
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 'D');
        
        scanner.close();
    }
    
    // Método para buscar um RA no vetor
    public static int buscarNota(int[] ras, int raBusca) {
        for (int i = 0; i < ras.length; i++) {
            if (ras[i] == raBusca) {
                return i;
            }
        }
        return -1;
    }
}