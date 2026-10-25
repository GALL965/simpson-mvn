package edu.usbi;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" PROYECTO 5a: REGLA DE SIMPSON (Distribución t)  ");
        System.out.println("==================================================");

        int numSeg = 10;
        double e = 0.00001;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el limite x: ");
        double x = scanner.nextDouble();

        System.out.print("Introduce los grados de libertad (dof): ");
        int dof = scanner.nextInt();

        SimpsonIntegration simpson = new SimpsonIntegration(numSeg, e, dof, x);
        double resultadoFinal = simpson.computeFinalValue();

        System.out.println("--------------------------------------------------");
        System.out.printf("Integral de 0 a %.4f con dof=%d: %.5f\n", x, dof, resultadoFinal);
        System.out.println("==================================================");
    }
}
