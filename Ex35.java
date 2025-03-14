/*35)Elaborar um programa, em linguagem Java, capaz de controlar os dados de uma
prova de atletismo, onde, via matriz, possamos armazenar, através de digitação, a
quantidade de corredores inscritos na prova, o número de inscrição de cada um, sua
posição de chegada e seu respectivo tempo de prova, conforme os mesmos forem
passando pela linha de chegada. Os atletas inscritos que não ultrapassarem a linha de
chegada deverão ter cadastrados 0 (zero) para a posição de chegada e tempo de prova.
Ao término da digitação, o programa deverá realizar a busca da posição de chegada e
do tempo de prova, para um determinado corredor, dada a digitação de seu número de
inscrição. Utilizar matriz para armazenamento das informações, porém não sendo
globais. O número de inscrição deve ser variável do tipo int. O tempo de prova deve ser
em segundos e armazenado em variável do tipo int. */

import java.util.Scanner;

public class Ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar a quantidade de corredores
        System.out.print("Digite a quantidade de corredores inscritos: ");
        int qtdCorredores = scanner.nextInt();
        
        // Criar matriz para armazenar os dados [número inscrição, posição chegada, tempo de prova]
        int[][] corredores = new int[qtdCorredores][3];
        
        // Entrada de dados dos corredores
        for (int i = 0; i < qtdCorredores; i++) {
            System.out.print("Digite o número de inscrição do corredor " + (i + 1) + ": ");
            corredores[i][0] = scanner.nextInt();
            
            System.out.print("Digite a posição de chegada (0 se não finalizou): ");
            corredores[i][1] = scanner.nextInt();
            
            System.out.print("Digite o tempo de prova em segundos (0 se não finalizou): ");
            corredores[i][2] = scanner.nextInt();
        }
        
        // Solicitar número de inscrição para busca
        System.out.print("Digite o número de inscrição do corredor para busca: ");
        int numBusca = scanner.nextInt();
        
        // Realizar busca do corredor
        int index = buscarCorredor(corredores, numBusca);
        
        // Exibir resultado da busca
        if (index != -1) {
            System.out.println("Número de inscrição: " + corredores[index][0]);
            System.out.println("Posição de chegada: " + corredores[index][1]);
            System.out.println("Tempo de prova: " + corredores[index][2] + " segundos");
        } else {
            System.out.println("Corredor não encontrado.");
        }
        
        scanner.close();
    }
    
    // Método para buscar um corredor pelo número de inscrição
    public static int buscarCorredor(int[][] corredores, int numInscricao) {
        for (int i = 0; i < corredores.length; i++) {
            if (corredores[i][0] == numInscricao) {
                return i; // Retorna o índice do corredor encontrado
            }
        }
        return -1; // Retorna -1 se o corredor não for encontrado
    }
}
