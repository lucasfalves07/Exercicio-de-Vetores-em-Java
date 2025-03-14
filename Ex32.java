/*32º) Elaborar um programa, em linguagem Java, capaz de carregar, em um vetor do tipo
int, 15 números digitados pelo operador, formando uma espécie de base de dados. Após
isto, o programa deverá solicitar a digitação de outro número, denominado número de
busca, o qual será localizado no vetor anterior. O programa deverá apresentar, em tela,
o resultado de uma busca linear, informando o índice do vetor no qual se encontra o
número de busca (utilizar o tamanho máximo do vetor como terminador da operação,
caso o número de busca não seja localizado). A busca linear deverá ser um método que
se utilize de passagem de parâmetros e o vetor não deverá ser variável global do
programa.*/


import java.util.Scanner;

public class Ex32 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[15];
        
        // Carregar os 15 números no vetor
        System.out.println("Digite 15 números:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        // Solicitar o número de busca
        System.out.print("Digite o número que deseja buscar: ");
        int searchNumber = scanner.nextInt();
        
        // Realizar a busca linear
        int index = linearSearch(numbers, searchNumber);
        
        // Exibir o resultado da busca
        if (index != numbers.length) {
            System.out.println("Número encontrado no índice: " + index);
        } else {
            System.out.println("Número não encontrado no vetor.");
        }
        
        scanner.close();
    }
    
    // Método de busca linear
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i; // Retorna o índice do número encontrado
            }
        }
        return array.length; // Retorna o tamanho máximo caso não encontre o número
    }
}

