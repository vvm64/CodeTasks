package ready;

import java.util.Scanner;


/*
Sum in Loop
Problem #2 

Теперь наша задача научиться писать циклы - т.е. программировать повторяющиеся действия.
Требуется найти сумму нескольких чисел (больше чем двух). 
Цикл типа FOR будет удобен поскольку количество суммируемых значений известно заранее.

первая строка содержит N - количество складываемых значений;
вторая строка содержит сами эти значения (целые).
Ответ должен содержать единственное число - подсчитанную сумму.

Пример:

исходные данные:
8
10 20 30 40 5 6 7 8

ответ:
126
 */
/**
 *
 * @author vvm
 *
 * решено
 */
public class MySummInLoop {

    public static void main(String[] args) {
        System.out.println("Please enter number");
        Scanner in = new Scanner(System.in);
        int n, summ = 0;

        n = Integer.parseInt(in.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = in.nextInt();
            summ += numbers[i];
        }
        in.close();
        System.out.println(summ);
    }
}
