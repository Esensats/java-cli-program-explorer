// ~/programs/practice/p1/p1.java

package esensats.su.oop.programs.practice.p1;

import java.util.Scanner;

import esensats.su.oop.Program;
import esensats.su.oop.ScannerStatic;

public class p1 {
    private static final Scanner in = ScannerStatic.scan();

    public static final Program multiply = new Program() {
        @Override
        public boolean execute() {
            double a, b;

            System.out.println("Введите два числа: ");

            if (in.hasNextDouble())
                a = in.nextDouble();
            else
                a = 0;
            if (in.hasNextDouble())
                b = in.nextDouble();
            else
                b = 0;

            double res = a * b;
            System.out.printf("Произведение: %f\n", res);
            return true;
        }
    };
}
