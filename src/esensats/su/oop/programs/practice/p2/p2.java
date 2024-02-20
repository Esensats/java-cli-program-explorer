package esensats.su.oop.programs.practice.p2;

import java.util.Scanner;

import esensats.su.oop.Program;
import esensats.su.oop.ScannerStatic;

public class p2 {
    private static final Scanner in = ScannerStatic.scan();

    public static final Program p1_1 = new Program() {
        @Override
        public boolean execute() {

            Double x, a, b, y;

            System.out.println("Enter x: ");
            while (!in.hasNextDouble()) {
                System.out.println("Invalid input");
                in.next();
            }
            x = in.nextDouble();

            System.out.println("Enter a: ");
            while (!in.hasNextDouble()) {
                System.out.println("Invalid input");
                in.next();
            }
            a = in.nextDouble();

            System.out.println("Enter b: ");
            while (!in.hasNextDouble()) {
                System.out.println("Invalid input");
                in.next();
            }
            b = in.nextDouble();

            if (x <= 3)
                y = b + 2 * Math.log10(x);
            else
                y = (x * x) / (x * x + a);

            System.out.printf("y = %f\n", y);
            return true;
        }
    };

    public static final Program p1_2 = new Program() {
        @Override
        public boolean execute() {
            Double x, y, a, b;

            System.out.println("Enter x: ");
            while (!in.hasNextDouble()) {
                System.out.println("Invalid input");
                in.next();
            }
            x = in.nextDouble();

            System.out.println("Enter a: ");
            while (!in.hasNextDouble()) {
                System.out.println("Invalid input");
                in.next();
            }
            a = in.nextDouble();

            System.out.println("Enter b: ");
            while (!in.hasNextDouble()) {
                System.out.println("Invalid input");
                in.next();
            }
            b = in.nextDouble();

            if (x > 0)
                y = a + (1 / 2) * Math.exp(-x);
            else
                y = Math.cos(b * x + 1);

            System.out.printf("y = %f\n", y);

            return true;
        }
    };

    public static final Program p2_1 = new Program() {
        private Double f(Integer n, Double x) {
            Double sum = 0.0;
            for (Integer i = 1; i <= n; i++) {
                sum += 1.0 / i;
            }
            Double a = sum * ((Math.pow(x, n + 1) / (n + 1.0)));
            return a;
        }

        @Override
        public boolean execute() {
            Double S = 0.0;

            Double x;
            do {
                System.out.println("Enter x: ");
                while (!in.hasNextDouble()) {
                    System.out.println("Invalid input. -1 <= x < 1");
                    in.next();
                }
                x = in.nextDouble();
            } while (x >= 1 || x < -1);

            S = f(10, x) * 2;

            System.out.println("S = " + S);

            return true;
        }
    };

}
