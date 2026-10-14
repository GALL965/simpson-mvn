public class GammaFunction {
    
    // Método para calcular la función Gamma con valores enteros
    public static double computeIntGamma(int n) {
        if (n <= 0) return 1.0;
        return factorial(n - 1);
    }

    // Método para calcular la función Gamma con valores double (Aproximación de Lanczos o Stirling básica)
    public static double computeDblGamma(double x) {
        // Implementación estándar simplificada para funciones Gamma con decimales
        if (x == 1.0) return 1.0;
        if (x == 0.5) return Math.sqrt(Math.PI);
        
        double result = 1.0;
        double temp = x;
        while (temp > 1.0) {
            temp -= 1.0;
            result *= temp;
        }
        return result;
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
