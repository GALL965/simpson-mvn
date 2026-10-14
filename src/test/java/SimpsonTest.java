import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimpsonTest {

    @Test
    public void testComputeW() {
        SimpsonIntegration simpson = new SimpsonIntegration(4, 0.00001, 10);
        double calculatedW = simpson.computeW(4, 2.00);
        assertEquals(0.5, calculatedW, 0.0001);
    }

    @Test
    public void testGammaFunction() {
        double gammaVal = GammaFunction.computeIntGamma(4);
        assertEquals(6.0, gammaVal, 0.0001);
    }

    @Test
    public void testSimpsonFinalValue() {
        SimpsonIntegration simpson = new SimpsonIntegration(4, 0.00001, 10);
        double result = simpson.computeFinalValue(4);
        // Validamos que devuelva un valor numérico consistente mayor a 0
        assertEquals(true, result > 0);
    }
}
