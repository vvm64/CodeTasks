package ready;

import java.util.Scanner;

/*



 
Sums in Loop
Problem #3 
Если вы уже разобрались с простыми циклами по задаче Sum in Loop, то это упражнение будет её несложной модификацией.

Теперь нам даны несколько пар значений, и нужно посчитать сумму каждой пары.

Входные данные содержат в первой строке N - общее количество пар, которые нужно посчитать.
Последующие N строк содержат по одной паре целых чисел каждая.
Ответ должен содержать результаты, разделенные пробелами.

Пример:

входные данные:
3
100 8
15 245
1945 54

ответ:
108 260 1999
 */
/**
 *
 * @author vvm
 */
public class SumsInLoop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of lines :");
        int numOfLines = in.nextInt();
        int[] sumsAr = new int[numOfLines];
        for (int i = 0; i < sumsAr.length; i++) {
            int a, b;
            a = in.nextInt();
            b = in.nextInt();
            sumsAr[i] = a + b;
        }
        in.close();
        for (int i = 0; i < sumsAr.length; i++) {
            System.out.print(sumsAr[i] + " ");
        }
    }
}
