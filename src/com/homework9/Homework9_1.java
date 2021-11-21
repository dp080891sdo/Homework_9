package com.homework9;

import java.util.Arrays;
import java.util.Scanner;

public class Homework9_1 {
    /*
    1) В банк положили s денег.
    Какой станет сумма вклада через n лет, если процент 1,5% добавляется к сумме вклада ежемесячно.
    Написать метод который принимает 2 параметра - s, n и возвращает сумму денег на счету.
     */

    public static final double PERSENT = 0.015;
    public static final int MONTH = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input amount");
        int amount = scanner.nextInt();
        System.out.println("Input year");
        int year = scanner.nextInt();

        double array[] = new double[year * MONTH];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = amount;
            } else {
                array[i] = array[i - 1] + array[i - 1] * PERSENT;
            }
        }
        System.out.println("The amount of the deposit in " + year + " years will be " + array[year * MONTH - 1]);

    }
}

class Homework9_2_1 {
    /*
2) Реализовать метод который вернет строку String,
в которой через пробел все числа от 1 до 99 со следующими изменениями:
(!!!Сам метод не должен ничего печатать в консоль, он просто должен вернуть строку!!!)
- если число кратно 3 то вывести вместо него Hello
- если число кратно 5 то вывести вместо него World
- если число кратно и 3 и 5 то вывести вместо него HelloWorld
     */

    public static void main(String[] args) {
        int array[] = new int[99];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] % 3 == 0) && (array[i] % 5 == 0)) {
                array[i] = 155;
            } else if (array[i] % 3 == 0) {
                array[i] = 333;
            } else if (array[i] % 5 == 0) {
                array[i] = 555;
            }
        }
        String string = Arrays.toString(array);

        string = string.replace(",", "");

        string = string.replace("155", "HelloWorld");

        string = string.replace("555", "World");

        string = string.replace("333", "Hello");
        System.out.println(string);
    }
}

class Homework9_2_2 {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if ((i % 5 != 0) && (i % 3 != 0) && (i % 15 != 0)) {
                System.out.print(i + " ");
            } else {
                if (i % 5 == 0) {
                    System.out.print("Hello ");
                }
                if (i % 3 == 0) {
                    System.out.print("World ");
                }
                if (i % 15 == 0) {
                    System.out.print("HelloWorld ");
                }
            }
        }
    }
}

class Homework9_3 {
    /*
3*) Написать метод который ищет при помощи бинарного поиска есть ли число в отсортированном массиве.
Входящие параметры: массив и число.
(считаем что массива который нам передали отсортирован, проверять это не нужно)
     */

    public static void main(String[] args) {
        int array[] = new int[99];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
        int number = (int) (Math.random() * array.length) + 1;
        int first = array[0];
        int last = array[array.length - 1];
        System.out.println(number);
        System.out.println(first);
        System.out.println(last);

        binarySearch(array, first, last, number);

    }

    public static void binarySearch(int[] array, int first, int last, int number) {
        int middle = (first + last) / 2;
        while ((array[middle] != number) && (first <= last)) {
            if (array[middle] > number) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
            middle = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println("The number " + number + " is in array");
        } else {
            System.out.println("Error");
        }
    }
}