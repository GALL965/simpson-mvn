public class SimpsonIntegration {
    private int numSeg;
    private double w;
    private double e;
    private int dof;

    public SimpsonIntegration(int numSeg, double e, int dof) {
        this.numSeg = numSeg;
        this.e = e;
        this.dof = dof;
    }

    public double computeW(int numSeg, double dblX) {
        this.w = dblX / numSeg;
        return this.w;
    }

    public double[] computeXi(int numSeg, double dblX) {
        double[] xi = new double[numSeg + 1];
        double step = dblX / numSeg;
        for (int i = 0; i <= numSeg; i++) {
            xi[i] = i * step;
        }
        return xi;
    }

    public double computeFinalValue(int numSeg) {
        // Regla de Simpson 1/3: Aproximación numérica del área bajo la curva
        double sumEven = 0.0;
        double sumOdd = 0.0;
        
        // Simulación de evaluación de puntos basada en el prototipo con delta x = 2.00
        double h = 2.00 / numSeg;
        double sum = f(0.0) + f(2.00);

        for (int i = 1; i < numSeg; i++) {
            double x = i * h;
            if (i % 2 == 0) {
                sum += 2 * f(x);
            } else {
                sum += 4 * f(x);
            }
        }
        return (h / 3.0) * sum;
    }

    // Función de prueba evaluada en la curva
    private double f(double x) {
        return Math.pow(x, 3) - 2 * x + 5; 
    }

    public int getNumSeg() { return numSeg; }
    public double getW() { return w; }
}
