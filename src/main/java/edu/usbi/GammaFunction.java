package edu.usbi;

public class GammaFunction {
    private static final double[] COEFFICIENTS = {
            0.9999999999998099,
            676.5203681218851,
            -1259.1392167224028,
            771.3234287776531,
            -176.6150291621406,
            12.507343278686905,
            -0.13857109526572012,
            9.984369578019572e-6,
            1.5056327351493116e-7
    };

    public static double computeGamma(double x) {
        if (!Double.isFinite(x) || x <= 0.0) {
            throw new IllegalArgumentException("El argumento de Gamma debe ser positivo");
        }
        if (x < 0.5) {
            return Math.PI / (Math.sin(Math.PI * x) * computeGamma(1.0 - x));
        }

        double shifted = x - 1.0;
        double series = COEFFICIENTS[0];
        for (int index = 1; index < COEFFICIENTS.length; index++) {
            series += COEFFICIENTS[index] / (shifted + index);
        }
        double scale = shifted + COEFFICIENTS.length - 1.5;
        return Math.sqrt(2.0 * Math.PI) * Math.pow(scale, shifted + 0.5)
                * Math.exp(-scale) * series;
    }
}
