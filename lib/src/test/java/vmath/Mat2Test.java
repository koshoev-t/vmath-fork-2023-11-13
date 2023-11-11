package vmath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Mat2Test {

    @Test
    void givenNoArgs_whenMat2Created_thenMatrixIsIdentity() {
        var m = new Mat2();

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 0.0f);

        assertEquals(m.get(1, 0), 0.0f);
        assertEquals(m.get(1, 1), 1.0f);
    }

    @Test
    void givenArrayArg_whenMat2Created_thenMatrixHasGivenValues() {
        var a = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f
        };
        var m = new Mat2(a);

        assertEquals(m.get(0, 0), 1.0f);
        assertEquals(m.get(0, 1), 2.0f);

        assertEquals(m.get(1, 0), 3.0f);
        assertEquals(m.get(1, 1), 4.0f);
    }

    @Test
    void givenNullArray_whenMat2Created_thenThrowsException() {
        float[] a = null;
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a));
    }

    @Test
    void givenArrayOfInvalidLength_whenMat2Created_thenThrowsException() {
        var a1 = new float[] {
            1.0f, 2.0f,
            3.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a1));

        var a2 = new float[] {
            1.0f, 2.0f,
            3.0f, 4.0f, 5.0f
        };
        assertThrows(IllegalArgumentException.class, () -> new Mat2(a2));
    }

    @Test
    void givenArrayWithNaNs_whenMat2Created_thenThrowsException() {
        float[] a1 = {
            Float.NaN, Float.NaN,
            Float.NaN, Float.NaN
        };
        assertThrows(ArithmeticException.class.class, () -> new Mat2(a1));

        float[] a2 = {
            1.0f, 2.0f,
            3.0f, Float.NaN
        };
        assertThrows(ArithmeticException.class.class, () -> new Mat2(a2));
    }
}
