package TriangleTest;

import Lesson4.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    Triangle correctT = new Triangle(3, 4, 5);
    Triangle wrongT = new Triangle(3, 4, 7);

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }

    @Test
    public void correctTriangle() {
        float s = 6f;
        Assertions.assertEquals(correctT.getAreaOfTriangle(), s);
    }

    @Test //при этих двух проверках метода boolean не смог избавиться от обязательного ввода параметров, как это сделать?
    public void isImpossibleTrue() {
        Assertions.assertTrue(wrongT.triangleIsImpossible(3, 4, 7));
    }

    @Test
    public void isImpossibleFalse() {
        Assertions.assertFalse(correctT.triangleIsImpossible(3, 4, 7));
    }
}
