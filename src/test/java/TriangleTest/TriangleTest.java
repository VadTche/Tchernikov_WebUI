package TriangleTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class TriangleTest {

    public int a, b, c;

    public TriangleTest(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }
//--------------------------------------------------------------
    public float getAreaOfTriangle() {
    float p = (a + b + c) / 2f;
    return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
//--------------------------------------------------------------
    @Test
    public void isImpossibleTrue() {
        Assert.assertTrue(triangleIsImpossible(2, 3, 5));
    }
    @Test
    public void isImpossibleFalse() {
        Assert.assertFalse(triangleIsImpossible(3, 3, 5));
    }
    public boolean triangleIsImpossible(int a, int b, int c) {
        return (a + b <= c || a + c <= b || b + c <= a);
    }
//--------------------------------------------------------------
    @Test
    public void testRepeatActionNegative() {
        Assert.assertFalse(repeatAction(0));
    }
    @Test
    public void testRepeatActionPositive() {
        Assert.assertTrue(repeatAction(1));
    }
    public boolean repeatAction(int repeat) {
        return repeat == 1;
    }
//---------------------------------------------------------------
    public void startTest () {

        System.out.println("===================================================");
        System.out.println("Вычисляем площадь треугольника по длинам его сторон");
        System.out.println("===================================================");

        TriangleTest triangle = new TriangleTest(0, 0, 0);

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n Длина стороны a:");
            int a = in.nextInt();
            System.out.println("Длина стороны b:");
            int b = in.nextInt();
            System.out.println("Длина стороны c:");
            int c = in.nextInt();

            if (triangle.triangleIsImpossible(a, b, c)) {
                System.out.println("Такой треугольник невозможен!");
            } else {
                triangle.getAreaOfTriangle();
                System.out.println("Площадь этого треугольника: " + triangle.getAreaOfTriangle());
            }

            System.out.println("\nИзменим длины сторон?\n клавиша 1 - ДА\n любая другая цифра - НЕТ");
            int repeat = in.nextInt();

            if (triangle.repeatAction(repeat)) {
                System.out.println("Начинаем заново...");
            } else {
                System.out.println("       Пока-пока!");
                return;
            }
        } while (true);
    }
}
