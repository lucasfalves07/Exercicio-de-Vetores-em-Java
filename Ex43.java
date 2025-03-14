/*43º) Tomando o exercício anterior como base, desenvolver dois métodos de busca
especiais, um linear e outro binário (iterativo), para o mesmo vetor e o mesmo elemento
chave, informando ao final, ao invés do índice onde foi encontrado o elemento chave,
quantas tentativas foram necessárias para se localizar ou não o elemento chave pelos
dois métodos. Com o programa sendo executado diversas vezes, para diversos valores
armazenados ou não no vetor, redigir um comparativo entre os métodos de busca linear
e busca binária, tentando concluir quando devemos utilização de um método é
vantajosa em relação ao outro. */

import java.util.Scanner;

public class Ex43 {
    public static void main(String[] args) {
        char[] vetor = new char[10];
        Scanner scanner = new Scanner(System.in);

        // Leitura dos 10 elementos do vetor
        System.out.println("Digite 10 caracteres diferentes em ordem crescente:");
        for (int i = 0; i < 10; i++) {
            vetor[i] = scanner.next().charAt(0);
        }

        // Leitura do caractere a ser buscado
        System.out.println("Digite um caractere para buscar:");
        char caractere = scanner.next().charAt(0);

        // Busca linear
        int tentativasLinear = buscaLinear(vetor, caractere);

        // Busca binária
        int tentativasBinaria = buscaBinaria(vetor, caractere);

        // Impressão dos resultados
        System.out.println("Busca Linear: " + tentativasLinear + " tentativas");
        System.out.println("Busca Binária: " + tentativasBinaria + " tentativas");

        // Comparativo
        if (tentativasLinear < tentativasBinaria) {
            System.out.println("A busca linear foi mais eficiente para este caso.");
        } else if (tentativasLinear > tentativasBinaria) {
            System.out.println("A busca binária foi mais eficiente para este caso.");
        } else {
            System.out.println("Ambas as buscas tiveram o mesmo desempenho.");
        }
    }

    public static int buscaLinear(char[] vetor, char caractere) {
        int tentativas = 0;
        for (int i = 0; i < vetor.length; i++) {
            tentativas++;
            if (vetor[i] == caractere) {
                return tentativas;
            }
        }
        return tentativas; // não encontrado
    }

    public static int buscaBinaria(char[] vetor, char caractere) {
        int tentativas = 0;
        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {
            tentativas++;
            int meio = (inicio + fim) / 2;

            if (vetor[meio] == caractere) {
                return tentativas;
            } else if (vetor[meio] < caractere) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return tentativas; // não encontrado
    }
}