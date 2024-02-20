package esensats.su.oop.programs.labs.l2;

import java.util.Scanner;

import esensats.su.oop.Program;
import esensats.su.oop.ScannerStatic;
import esensats.su.oop.exceptions.InvalidInputException;

public class l2 {
    private static final Scanner in = ScannerStatic.scan();

    public static final Program t1_1 = new Program() {
        @Override
        public boolean execute() throws Exception {
            String str = STR
                . """
                a) (101 + 0) / 3 = \{ 101 / 3.0 }
                b) 3.0e-6 * 10000000.1 = \{ 3.0e-6 * (1e7 + .1) }
                c) true && true = \{ true && true }
                d) false && true = \{ false }
                e) (false && false) || (true && true) = \{ false || (true && true) }
                f) (false || false) && (true && true) = \{ false || false }
                """;
            System.out.print(str);
            return true;
        };
    };

    public static final Program t1_2 = new Program() {
        @Override
        public boolean execute() throws Exception {
            System.out.print("Введите два числа: ");
            Double n1, n2;
            
            if(!in.hasNextDouble())
                throw new InvalidInputException();
            n1 = in.nextDouble();
            if(!in.hasNextDouble())
                    throw new InvalidInputException();
            n2 = in.nextDouble();

            System.out.printf("Числа между 0 и 1: %s", (n1 >= 0 && n1 <= 1 && n2 >= 0 && n2 <= 1));

            return true;
        };
    };
}
