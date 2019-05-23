package ready;

/*
Average of an array
Problem #16 

Статистика - это важная отрасль математики, притом очень популярная в программировании. 
По сути это вычисление общих характеристик некоего набора данных. 
Подумайте хотя бы о статистике посещений и просмотров страниц сайта. 
Знакомство с этой дисциплиний обычно начинается с вычисления среднего значения.

Среднее (average, avg) значение для набора чисел определяется 
как их сумма деленная на их количество, например:

avg(2, 3, 7) = (2 + 3 + 7) / 3 = 4
avg(20, 10) = (20 + 10) / 2 = 15

Вам будут даны несколько списков чисел (массивов) - для каждого из них нужно найти среднее.

Входные данные в первой строке содержат количество списков.

Остальные строки содержат по одному списку чисел каждая.

Числа в каждом списке целые и положительные. 
Конец списка отмечен значением 0 - его не нужно включать в расчеты!!!
Ответ должен содержать средние значения для каждого из списков, 
округлённые до ближайшего целого (см задачу на округление), разделенные пробелами.

Пример:
входные данные:
3
2 3 7 0
20 10 0
1 0

ответ:
4 15 1

 */
/**
 *
 * @author vvm
 *
 * Math.round String[] data = s.split(" ");
 *
 *
 * Pattern pattern = Pattern.compile("\\d+"); String word =
 * "test123test444test"; // мой пример строки Matcher matcher =
 * pattern.matcher(word); int start = 0; while (matcher.find(start)) { String
 * value = word.substring(matcher.start(), matcher.end()); int result =
 * Integer.parseInt(value); System.out.println(result); start = matcher.end(); }
 *
 * String str = "11 34 3 45 23 5 67"; int[] numArr = Arrays.stream(str.split("
 * ")).mapToInt(Integer::parseInt).toArray();
 *
 *
 */
/*
Вычислить среднее значение для каждой строки не учитывая последние нули

Пример:
входные данные:
3
2 3 7 0
20 10 0
1 0

ответ:
4 15 1

 */
// решено
import java.io.IOException;
import java.util.Arrays;

import java.util.Scanner;

public class AverageOfAnArray {

    public String[] astrAr;

    public static void main(String[] args) throws IOException {

        AverageOfAnArray myAverOfAr = new AverageOfAnArray();

        Scanner in = new Scanner(System.in);
        int numAr;
        numAr = Integer.parseInt(in.nextLine());
        // numAr = in.nextInt();
        myAverOfAr.astrAr = new String[numAr];
        for (int i = 0; i < myAverOfAr.astrAr.length; i++) {
            myAverOfAr.astrAr[i] = in.nextLine();
        }
        in.close();

        // перебираем массив строк и выводим для каждого среднее
        for (String x : myAverOfAr.astrAr) {
            String str = myAverOfAr.replaceNull(x); // удалить нули

            String[] strAr = str.split(" ");
            int[] intArray = Arrays.stream(strAr).mapToInt((Integer::parseInt)).toArray();

            double result = 0; // для показа результата
            double count = 0; // колличество целых в массиве

            for (int i = 0; i < intArray.length; i++, count++) {
                // System.out.print("intArray = "+intArray[i]+" ");
                result += intArray[i];
            }

            result = Math.round(result / count);
            System.out.print((int) result + " ");

            intArray = null;
            strAr = null;
        }
    }

    public String replaceNull(String str) {
        return str.replaceAll("(^0+)|(?<= )(0+)", "");
    }

}
    
    
 
/*
Алгоритм решения
a = [int(x) for x in input().split()]
avg = sum(a) / (len(a) - 1)
*/
