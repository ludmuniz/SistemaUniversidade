package main.java.br.edu.amazonia.ui.util;

import java.util.Scanner;

public class ConsoleUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número inteiro (00) válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Digite um número válido (0.00): ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpa buffer
        return valor;
    }

    public static String lerLinha(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static boolean lerBoolean(String mensagem) {
        System.out.print(mensagem);
        String entrada = scanner.nextLine().trim().toLowerCase();
        return entrada.startsWith("s");
    }
}
