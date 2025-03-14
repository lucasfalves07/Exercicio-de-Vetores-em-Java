/*37º) Em um serviço de check-in de uma companhia aérea, após a apresentação de seu
R.G, o passageiro deve receber o primeiro número do assento vago disponível na
aeronave, afim de realizar sua viagem. Para isto, a companhia aérea conta com um
programa, realizado em linguagem Java. Esse programa informa ao operador, quando
solicitado, o número do primeiro assento que estiver vago. Após isto, o operador digita
o número do R.G. do passageiro, para realizar a reserva do assento. O programa deverá
informar quando o avião estiver lotado e em que assento encontra-se determinado R.G.
digitado. Deverão existir opções para cancelar a reserva de um determinado assento e
para cancelar todas as reservas de assento de uma só vez. Elaborar este programa. */

import java.util.Scanner;

public class Ex37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Definir o número de assentos na aeronave
        int numeroAssentos = 150;

        // Criar um vetor para armazenar os dados dos assentos
        String[] assentos = new String[numeroAssentos];

        // Inicializar os assentos como vagos
        for (int i = 0; i < numeroAssentos; i++) {
            assentos[i] = "VAGO";
        }

        // Menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("A) Verificar o primeiro assento vago");
            System.out.println("B) Realizar reserva de assento");
            System.out.println("C) Cancelar reserva de assento");
            System.out.println("D) Cancelar todas as reservas de assento");
            System.out.println("E) Verificar o assento de um R.G. específico");
            System.out.println("F) Sair do programa");
            System.out.println("Escolha uma opção:");
            char opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'A':
                    verificarAssentoVago(assentos);
                    break;
                case 'B':
                    realizarReserva(assentos, scanner);
                    break;
                case 'C':
                    cancelarReserva(assentos, scanner);
                    break;
                case 'D':
                    cancelarTodasReservas(assentos);
                    break;
                case 'E':
                    verificarAssentoRG(assentos, scanner);
                    break;
                case 'F':
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void verificarAssentoVago(String[] assentos) {
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i].equals("VAGO")) {
                System.out.println("O primeiro assento vago é o número " + (i + 1));
                return;
            }
        }
        System.out.println("O avião está lotado.");
    }

    public static void realizarReserva(String[] assentos, Scanner scanner) {
        System.out.println("Digite o número do R.G. do passageiro:");
        String rg = scanner.next();
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i].equals("VAGO")) {
                assentos[i] = rg;
                System.out.println("Reserva realizada com sucesso. O passageiro está sentado no assento número " + (i + 1));
                return;
            }
        }
        System.out.println("O avião está lotado.");
    }

    public static void cancelarReserva(String[] assentos, Scanner scanner) {
        System.out.println("Digite o número do assento que deseja cancelar:");
        int numeroAssento = scanner.nextInt() - 1;
        if (assentos[numeroAssento].equals("VAGO")) {
            System.out.println("O assento já está vago.");
        } else {
            assentos[numeroAssento] = "VAGO";
            System.out.println("Reserva cancelada com sucesso.");
        }
    }

    public static void cancelarTodasReservas(String[] assentos) {
        for (int i = 0; i < assentos.length; i++) {
            assentos[i] = "VAGO";
        }
        System.out.println("Todas as reservas canceladas com sucesso.");
    }

    public static void verificarAssentoRG(String[] assentos, Scanner scanner) {
        System.out.println("Digite o número do R.G. do passageiro:");
        String rg = scanner.next();
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i].equals(rg)) {
                System.out.println("O passageiro está sentado no assento número " + (i + 1));
                return;
            }
        }
        System.out.println("O passageiro não está sentado em nenhum assento.");
    }
}