package ready;

import java.util.Scanner;

/*
 Арифметическая прогрессия - это последовательность чисел, 
обладающая особым свойством - каждое следующее значение больше предыдущего 
на фиксированную величину (назовем её "шагом" прогрессии).

Т.е. разность между (K+1)-ым и K-ым значениями одинакова для любых K.

Раз так, арифметическая прогрессия полностью определяется 
начальным значением (A) и шагом (B). Первые несколько значений можно выразить как

A,  (A + B),  (A + 2*B),  (A + 3*B), ...
Наша задача - вычислить сумму первых нескольких членов арифметической прогрессии. 
Статья в википедии - или какой-нибудь другой источник могут быть весьма полезны 
если вы сталкиваетесь с такими последовательностями впервые.


Входные данные: первая строка содержит число тестов.
Остальные строки содержат тесты, по три значения в каждом: A B N где A 
это начальное значение последовательности, 

B её шаг, а N количество первых членов которые нужно просуммировать.
Ответ должен содержать результат (сумму первых членов) для каждой тестовой последовательности, через пробел.

Формула вычисления N-ного члена A(N)=A(N-1) + D;

Пример:

входные данные:
2
5 2 3
3 0 10

ответ:
21 30


 */
/**
 * Problemm 8
 *
 * @author vvm решено
 */
public class ArithmeticProgression {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of lines :");
        int numOfLines = in.nextInt();
        int[] sumsOfTree = new int[numOfLines];

        /* считываем по 3 числа  e - колличество которое нужно просуммировать*/
        for (int i = 0; i < sumsOfTree.length; i++) {
            int q, w, e;
            q = in.nextInt();
            w = in.nextInt();
            e = in.nextInt();

            int[] arZap = new int[e];

            arZapolnit(q, w, arZap);
            for (int j = 0; j < arZap.length; j++) {
                sumsOfTree[i] = summAr(arZap);
            }
        }

        in.close();

        System.out.println("Сумма");
        for (int i = 0; i < sumsOfTree.length; i++) {
            System.out.print(sumsOfTree[i] + " ");
        }
    }

    // заполнить массив
    public static void arZapolnit(int a, int dif, int[] ar) {

        int len = ar.length;
        ar[0] = a;

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                ar[i] = a;
            } else {
                ar[i] += (ar[i - 1] + dif);
            }
        }

    }

    /* вычислить и вернуть сумму */
    public static int summAr(int[] ar) {
        int summ = ar[0];
        int len = ar.length;
        for (int i = 0; i < len; i++) {
            if (i == 0); else {
                summ += ar[i];
            }
        }
        return summ;
    }
}
