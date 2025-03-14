/*34)Elaborar um programa, em linguagem Java, capaz de carregar uma string, digitada
em um vetor do tipo char, com no máximo 15 posições, formando uma espécie de base
de dados. Após isto, o programa deverá solicitar a digitação de um caractere,
denominado caractere de busca, o qual será localizado no vetor anterior. O programa
deverá apresentar, em tela, o resultado de uma busca linear, informando o índice do
vetor no qual se encontra o caractere de busca (utilizar o tamanho máximo do vetor ou
o tamanho máximo da string digitada como terminadores da operação, caso o caractere
de busca não seja localizado). A busca linear deverá ser um método que se utilize de
passagem de parâmetros e o vetor não deverá ser uma variável global do programa. */

import java.util.Scanner;

public class Ex34 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = new char[15];
        
        // Carregar a string no vetor de caracteres
        System.out.println("Digite uma string com até 15 caracteres:");
        String input = scanner.nextLine();
        
        int length = Math.min(input.length(), 15);
        for (int i = 0; i < length; i++) {
            charArray[i] = input.charAt(i);
        }
        
        // Solicitar o caractere de busca
        System.out.print("Digite o caractere que deseja buscar: ");
        char searchChar = scanner.next().charAt(0);
        
        // Realizar a busca linear
        int index = linearSearch(charArray, searchChar, length);
        
        // Exibir o resultado da busca
        if (index != length) {
            System.out.println("Caractere encontrado no índice: " + index);
        } else {
            System.out.println("Caractere não encontrado no vetor.");
        }
        
        scanner.close();
    }
    
    // Método de busca linear
    public static int linearSearch(char[] array, char key, int length) {
        for (int i = 0; i < length; i++) {
            if (array[i] == key) {
                return i; // Retorna o índice do caractere encontrado
            }
        }
        return length; // Retorna o tamanho máximo caso não encontre o caractere
    }
}
