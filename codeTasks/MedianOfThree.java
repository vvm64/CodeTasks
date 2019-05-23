package ready;

import java.util.Scanner;

/*
 Median of Three
Problem #41


Вы вероятно уже решили задачу Minimum of Three - и она показалась лёгкой? Давайте теперь слегка изменим условие, чтобы получилось более сложное упражнение.

Вновь будут даны тройки чисел, но теперь нужно выбрать среднее из них - т.е. то, которое останется если отбросить наибольший и наименьший элементы. Такое число называется медианой (множества, массива и т.п.)

Не думайте что это всего лишь "очередное дурацкое упражнение" - выбор медианы является частью мощного и популярного алгоритма быстрой сортировки (QuickSort) например.

Входные данные - первая строка содержит количество тестовых наборов чисел.
Остальные строки содержат сами наборы (тройки) - по одной в каждой строке.
Ответ должен содержать медианы этих троек, разделенные пробелами.

Пример:

входные данные:
3
7 3 5
15 20 40
300 550 137

ответ:
5 20 300
 */
/**
 *
 * @author vvm
 */
public class MedianOfThree {

    public static int myMid(int a, int b, int c) {
        if (((b < a) && (a < c)) || ((b > a) && (a > c))) {
            return a;
        }
        if ((a < b && b < c) || (a > b && b > c)) {
            return b;
        }
        if ((a < c && c < b) || (a > c && c > b)) {
            return c;
        } else {
            return c;
        }
    }

    public static int myMid2(int a, int b, int c) {

        if (((b < a) && (a < c)) || ((b > a) && (a > c))) {
            c = a;
        }

        if (((a < b) && (b < c)) || ((a > b) && (b > c))) {
            c = b;
        }
        return c;

    }

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Number of lines :");
            int numOfLines = in.nextInt();
            int[] minsOfTree = new int[numOfLines];

            for (int i = 0; i < minsOfTree.length; i++) {
                int q, w, e;
                q = in.nextInt();
                w = in.nextInt();
                e = in.nextInt();
                System.out.print(myMid2(q, w, e) + " ");
            }
            /*System.out.println("1,2,3  = "+myMid2(1,2,3));
            System.out.println("2,1,3  = "+myMid2(2,1,3));
            System.out.println("3,2,1  = "+myMid2(3,2,1));
            System.out.println("3,1,2  = "+myMid2(3,1,2));
            System.out.println("3,1,2  = "+myMid2(1,3,2));
             */
        }
    }
}
