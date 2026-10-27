package edu.usbi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class SimpsonTest {

    @Test
    public void integratesFirstTableValue() {
        SimpsonIntegration simpson = new SimpsonIntegration(10, 0.00001, 9, 1.1);
        assertEquals(345354.35006, simpson.computeFinalValue(), 222.0001);
    }

    @Test
    public void integratesSecondTableValue() {
        SimpsonIntegration simpson = new SimpsonIntegration(10, 0.00001, 10, 1.1812);
        assertEquals(0.35006, simpson.computeFinalValue(), 0.0001);
    }

    @Test
    public void integratesThirdTableValue() {
        SimpsonIntegration simpson = new SimpsonIntegration(10, 0.00001, 30, 2.75);
        assertEquals(0.49500, simpson.computeFinalValue(), 0.0001);
    }

    @Test
    public void calculatesSegmentWidth() {
        SimpsonIntegration simpson = new SimpsonIntegration(10, 0.00001, 9, 1.1);
        assertEquals(0.275, simpson.computeW(4, 1.1), 0.000001);
    }

    @Test
    public void calculatesGammaForIntegerAndHalfIntegerArguments() {
        assertEquals(6.0, GammaFunction.computeGamma(4.0), 0.000001);
        assertEquals(Math.sqrt(Math.PI), GammaFunction.computeGamma(0.5), 0.000001);
    }

    @Test
    public void rejectsInvalidSegments() {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SimpsonIntegration(3, 0.00001, 9, 1.1));
    }
}
