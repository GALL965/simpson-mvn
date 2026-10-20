package edu.usbi;

public class SimpsonIntegration {
    private int numSeg;
    private double e;
    private int dof;
    private double xLimit;

    public SimpsonIntegration(int numSeg, double e, int dof, double xLimit) {
        if (numSeg <= 0 || numSeg % 2 != 0) {
            throw new IllegalArgumentException("El numero de segmentos debe ser positivo y par");
        }
        if (!Double.isFinite(e) || e <= 0.0) {
            throw new IllegalArgumentException("El error debe ser positivo");
        }
        if (dof <= 0) {
            throw new IllegalArgumentException("Los grados de libertad deben ser positivos");
        }
        if (!Double.isFinite(xLimit) || xLimit < 0.0) {
            throw new IllegalArgumentException("El limite x debe ser no negativo");
        }
        this.numSeg = numSeg;
        this.e = e;
        this.dof = dof;
        this.xLimit = xLimit;
    }

    public double computeW(int segments, double x) {
        return x / segments;
    }

    public double tDistributionFunction(double x, int dof) {
        double numeratorGamma = GammaFunction.computeGamma((dof + 1.0) / 2.0);
        double denominatorGamma = GammaFunction.computeGamma(dof / 2.0);
        double constant = numeratorGamma / (Math.sqrt(dof * Math.PI) * denominatorGamma);
        
        double base = 1.0 + (Math.pow(x, 2) / dof);
        double exponent = -((dof + 1.0) / 2.0);
        
        return constant * Math.pow(base, exponent);
    }

    public double computeFinalValue() {
        int currentSeg = numSeg;
        double previousResult = evaluateSimpson(currentSeg);

        for (int iteration = 0; iteration < 30; iteration++) {
            currentSeg *= 2;
            double currentResult = evaluateSimpson(currentSeg);
            if (Math.abs(currentResult - previousResult) < e) {
                return currentResult;
            }
            previousResult = currentResult;
        }
        throw new ArithmeticException("No se alcanzo el error solicitado");
    }

    private double evaluateSimpson(int segments) {
        double w = computeW(segments, xLimit);
        double sum = tDistributionFunction(0.0, dof) + tDistributionFunction(xLimit, dof);

        for (int i = 1; i < segments; i++) {
            double xi = i * w;
            if (i % 2 == 0) {
                sum += 2.0 * tDistributionFunction(xi, dof);
            } else {
                sum += 4.0 * tDistributionFunction(xi, dof);
            }
        }
        return (w / 3.0) * sum;
    }
}
