package edu.usbi;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner scanner = new Scanner(System.in)) {
            int numSeg = readInt(scanner, args, 0, "Numero inicial de segmentos");
            double error = readDouble(scanner, args, 1, "Error aceptable");
            int dof = readInt(scanner, args, 2, "Grados de libertad");
            double xLimit = readDouble(scanner, args, 3, "Limite x");

            SimpsonIntegration integration = new SimpsonIntegration(numSeg, error, dof, xLimit);
            System.out.printf("Integral de 0 a %.5f con dof=%d: %.5f%n", xLimit, dof, integration.computeFinalValue());
        } catch (IllegalArgumentException | ArithmeticException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }
    }

    private static int readInt(Scanner scanner, String[] args, int index, String label) {
        if (args.length > index) {
            return Integer.parseInt(args[index]);
        }
        System.out.print(label + ": ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static double readDouble(Scanner scanner, String[] args, int index, String label) {
        if (args.length > index) {
            return Double.parseDouble(args[index]);
        }
        System.out.print(label + ": ");
        return Double.parseDouble(scanner.nextLine().trim());
    }
}
