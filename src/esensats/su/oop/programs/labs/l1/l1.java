package esensats.su.oop.programs.labs.l1;

import java.util.Scanner;

import esensats.su.oop.Program;
import esensats.su.oop.ScannerStatic;

public class l1 {
    private static final Scanner in = ScannerStatic.scan();

    public static final Program p1_1 = new Program() {
        @Override
        public boolean execute() throws Exception {
            double cel;

            System.out.println("Введите температуру по цельсию: ");

            if (in.hasNextDouble())
                cel = in.nextDouble();
            else
                cel = 0;

            double far = cel * (9 / 5) + 32;
            System.out.printf("Температура по Фаренгейту: %f\n", far);
            return true;
        }
    };

    public static final Program p1_2 = new Program() {
        @Override
        public boolean execute() throws Exception {
            int a, b, c;
            System.out.println("Введите три числа: ");
            if (in.hasNextInt())
                a = in.nextInt();
            else
                a = 0;
            if (in.hasNextInt())
                b = in.nextInt();
            else
                b = 0;
            if (in.hasNextInt())
                c = in.nextInt();
            else
                c = 0;
            double avg = (a + b + c) / 3.0;
            System.out.printf("Среднее арифметическое: %f\n", avg);
            return true;
        }
    };

    public static final Program p2_1 = new Program() {
        @Override
        public boolean execute() throws Exception {
            double a, b;
            System.out.println("Введите два края прямоугольника: ");
            if (in.hasNextDouble())
                a = in.nextDouble();
            else
                a = 0;
            if (in.hasNextDouble())
                b = in.nextDouble();
            else
                b = 0;
            double area = a * b;
            double perimeter = (a + b) * 2;
            System.out.printf("Площадь прямоугольника: %f\n", area);
            System.out.printf("Периметр прямоугольника: %f\n", perimeter);
            return true;
        }
    };

    public static final Program p2_2 = new Program() {
        @Override
        public boolean execute() throws Exception {
            int a;
            System.out.println("Введите число: ");
            if (in.hasNextInt())
                a = in.nextInt();
            else
                a = 0;
            System.out.printf("Число в двоичном формате: %s\n", Integer.toBinaryString(a));
            return true;
        }
    };

    public static final Program p2_3 = new Program() {
        @Override
        public boolean execute() throws Exception {
            System.out.print("4,0 * (1 - (1,0/3) + (1,0/5) - (1,0/7) + (1,0/9) - (1,0/11)) = ");
            double result = 4.0 * (1 - (1.0 / 3) + (1.0 / 5) - (1.0 / 7) + (1.0 / 9) - (1.0 / 11));
            System.out.printf("%f\n", result);
            return true;
        }
    };
}
