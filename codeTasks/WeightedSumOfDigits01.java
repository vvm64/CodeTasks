package ready;

/*
Weighted sum of digits
Problem #13 

Эта программа - младший брат более сложных алгоритмов 
- для подсчёта контрольных сумм (вроде CRC), хэш-функций (например, MD5) 
на строках и т.п. Помимо того она даст нам ещё одно упражнение по разбиению чисел на цифры. 
Возможно вы пожелаете решить сначала похожую задачу Sum of Digits.

Давайте сосчитаем сумму цифр, как и раньше, но теперь 
умножая каждую цифру на её порядковый номер (позицию) в числе, 
считая слева, начиная с единицы - т.е. задавая "вес" каждой цифры. 
Например для числа 1776 мы вычислим такую взвешенную сумму цифр (назовем её "wsd") как:

wsd(1776) = 1 * 1 + 7 * 2 + 7 * 3 + 6 * 4 = 60

Входные данные задают в первой строке общее количество тестов.
Сами тестовые значения заданы во второй строке. 
Для каждого из них нужно сосчитать "взвешенную сумму цифр".
Ответ - как обычно, выведите результаты для каждого теста через пробел.

Пример:

входные данные:
3
9 15 1776

ответ:
9 11 60


Author's notes on this problem
This task has no trics. It just presents you a concept of calculating some code over the string which could be used to see whether strings are different.

The only thing to note is that it is not necessary to convert string to number. Instead you can convert each next character to int
(in C/C++ it looks like ch -'0' for example).

This would be very helpful if the numbers are very long and could not fit into normal integer or long variable.
 */
/**
 *
 * @author vvm
 *
 * решено
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WeightedSumOfDigits01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numAr; // размер массива
        numAr = in.nextInt();
        int[] iAr = new int[numAr];// массив для хранения  введенных чисел

        for (int i = 0; i < numAr; i++) {
            iAr[i] = in.nextInt();
        }
        in.close();

        // выводим результат для каждого числа
        for (int i = 0; i < iAr.length; i++) {
            System.out.print(wsd(iAr[i]) + " ");
        }
    }

    public static int wsd(int n) {
        int sum = 0;
        int chislo;
        ArrayList<Integer> ilist = new ArrayList<>();

        do {
            chislo = n % 10;
            ilist.add(chislo); // добавить число в список
        } while ((n /= 10) != 0);

        Collections.reverse(ilist);

        for (int i = 0; i < ilist.size(); i++) {
            sum += ilist.get(i) * (i + 1);
        }
        return sum;
    }
}
