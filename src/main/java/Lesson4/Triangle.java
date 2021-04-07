package Lesson4;

import java.util.Scanner;

public class Triangle {
    public int a, b, c;

    public Triangle (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float getAreaOfTriangle() {
        float p = (a + b + c) / 2f;
        return (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public boolean triangleIsImpossible (int a, int b, int c) {
        return (a + b <= c || a + c <= b || b + c <= a);
    }

    public boolean repeatAction (int repeat) {
        return repeat == 1;
    }

    public static void main(String[] args) {

        System.out.println("===================================================");
        System.out.println("Вычисляем площадь треугольника по длинам его сторон");
        System.out.println("===================================================");

        Triangle triangle = new Triangle(0, 0, 0);

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("\n Длина стороны a:");
            int a = in.nextInt();
            System.out.println("Длина стороны b:");
            int b = in.nextInt();
            System.out.println("Длина стороны c:");
            int c = in.nextInt();

            if (triangle.triangleIsImpossible(a, b, c)) {
                System.out.println("Такой треугольник невозможен");
            }
            else {
                triangle.getAreaOfTriangle();
                System.out.println("Площадь этого треугольника: " + triangle.getAreaOfTriangle());
            }

            System.out.println("\nИзменим длины сторон?\n клавиша 1 - ДА\n любая другая цифра - НЕТ");
            int repeat = in.nextInt();

            if (triangle.repeatAction(repeat)) {
                System.out.println("Начинаем заново...");
            }
            else {
                System.out.println("       Пока-пока!");
                return;
            }
        } while (true);
    }
}
