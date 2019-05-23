package ready;

/*#22
Two Printers
Problem #22 

foreach (string item in s)
        {
            int[] arr = item.Split(' ').Select(x => int.Parse(x)).ToArray();
            int p1 = (int)SqlDecimal.Round((SqlDecimal)arr[1] * arr[2] /
                (arr[0] + arr[1]), 0);
            int p2 = (int)SqlDecimal.Round((SqlDecimal)arr[0] * arr[2] /
                (arr[0] + arr[1]), 0);
            int time1 = p1 * arr[0];
            int time2 = p2 * arr[1];
            if (time1 > time2)
                Console.Write(time1 + " ");
            else
                Console.Write(time2 + " ");
        }
        Console.Read();
    }
}

  Мой коллега рассказал мне эту задачку после посещения собеседования 
в местном офисе Oracle. Надеюсь я запомнил её достаточно точно.

Джон и Мэри основали полиграфическую компанию J&M publishing house 
- для этого они купили пару старых принтеров и пачку бумаги.

И вот их первая коммерческая сделка - требуется напечатать документ состоящий из N страниц.

Оказывается принтеры работают с неодинаковой скоростью. Один печатает страницу за X секунд, а другой за Y.

И вот теперь Джон и Мэри пытаются подсчитать какое минимальное время 
они могут затратить на печать всего документа.

Входные данные содержат количество тест-кейсов в первой строке.

Далее следуют сами тесты по одному в каждой строке.

Каждый из них содержит по три целых числа - X Y N, где N не превышает 1,000,000,000.
Ответ должен содержать минимальные времена печати для каждого случая, через пробел.
Пример:

входные данные:
2
1 1 5
3 5 4

ответ:
3 9
 */
/**
 *
 * @author vvm
 *
 * 95328486 272870597 171551293 183769504 159466256 416951279 64206116 8514620
 * 105266135 236017302 246950400 500169994 427171444 294980906 257084900
 * 412131344 414970458
 *
 *
 * решено: http://www.cyberforum.ru/algorithms/thread1923213.html
 */
import java.util.Scanner;

public class TwoPrinters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of lines :");
        int numOfLines = in.nextInt();

        int[] iResult = new int[numOfLines];

        for (int i = 0; i < iResult.length; i++) {
            int x, y, n;
            x = in.nextInt();
            y = in.nextInt();
            n = in.nextInt();

            iResult[i] = minTime(x, y, n);

        }
        in.close();

        for (int i = 0; i < iResult.length; i++) {
            System.out.print(iResult[i] + " ");
        }
    }

    public static int minTime(int x, int y, int n) {
        int nx = n * y / (x + y);
        return Math.min((n - nx) * y, (nx + 1) * x);
    }

}
