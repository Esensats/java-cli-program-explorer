package esensats.su.oop;

import esensats.su.oop.programs.labs.l1.l1;
import esensats.su.oop.programs.labs.l2.l2;
import esensats.su.oop.programs.practice.p1.p1;
import esensats.su.oop.programs.practice.p2.p2;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Route rootRoute = new Route("ООП - Сатыбалдин Есен")
                    .addChild(new Route("Лабораторные работы")
                            .addChild(new Route("Лаб. №1")
                                    .addChild(new Route("Конвертация температуры", l1.p1_1))
                                    .addChild(new Route("Среднее арифметическое", l1.p1_2))
                                    .addChild(new Route("Площадь и периметр прямоугольника", l1.p2_1))
                                    .addChild(new Route("Десятичное в двоичное", l1.p2_2))
                                    .addChild(new Route("Вычисление формулы", l1.p2_3)))
                            .addChild(new Route("Лаб. №2")
                                    .addChild(new Route("Значения выражений", l2.t1_1))
                                    .addChild(new Route("Числа между 0 и 1", l2.t1_2))))
                    .addChild(new Route("Практические работы")
                            .addChild(new Route("Прак. №1")
                                    .addChild(new Route("Произведение двух чисел", p1.multiply)))
                            .addChild(new Route("Прак. №2")
                                    .addChild(new Route("Условные выражения")
                                            .addChild(new Route("Задание 1", p2.p1_1))
                                            .addChild(new Route("Задание 2", p2.p1_2))
                                            .addChild(new Route("Задание 3.", p2.p1_1)))
                                    .addChild(new Route("Работа с циклами")
                                            .addChild(new Route("Задание 1", p2.p2_1))
                                            .addChild(new Route("Задание 2.", p2.p1_2))
                                            .addChild(new Route("Задание 3.", p2.p1_2))
                                            .addChild(new Route("Задание 4.", p2.p1_1)))));

            Navigation navigation = new Navigation(rootRoute);

            navigation.init();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ScannerStatic.close();
        }
    }
}
