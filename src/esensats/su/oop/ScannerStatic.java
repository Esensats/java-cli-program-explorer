package esensats.su.oop;

import java.util.Scanner;

public class ScannerStatic {
    static Scanner scan;

    private ScannerStatic() {
    }

    public static synchronized Scanner scan() {
        if (scan == null) {
            scan = new Scanner(System.in);
        }
        return scan;
    }

    public static synchronized void close() {
        scan.close();
    }
}
