package ready;
// решено
/*
 Array Checksum
 Problem #17 

Контрольные суммы (чексуммы) - это небольшие значения вычисляемые по сравнительно 
большим объёмам данных, чтобы убедиться в их консистентности - т.е. чтобы определить 
что данные не были случайно повреждены, изменены, частично утрачены.

Например если Анна посылает файл Бобу, она может вычислить его чексумму и сообщить 
её Бобу. Он также посчитает сумму по полученному файлу и сможет понять, принял ли он 
файл целиком или, быть может, потерял кусок из-за обрыва связи (а может его подредактировала 
коварная Ева?).

Другой популярный пример - все банковские карты (в т.ч. те которые вы наверняка используете) 
содержат контрольную сумму в последней цифре номера, на тот случай если вы набирая 
этот номер случайно поменяете пару цифр местами или наберете какую-то одну неверно.
(вы можете узнать об этом подробнее из задачи Luhn Algorithm).

Для работы с несколькими следующими задачами нам понадобится подобный способ 
определения корректности полученного массива. Поэтому попрактикуемся сейчас 
с соответствующим алгоритмом чтобы избежать ошибок в дальнейшем.

Условие задачи
Нам дан массив для которого нужно посчитать контрольную сумму. 
Делается это следующим образом: 

каждый элемент (начиная с первого) 
добавляем к текущему результату и умножаем то что получилось на 113 - то что получилось 
берем по модулю 10000007 - оно и будет новым значением результата, и так далее.

Статья о контрольной сумме содержит пример таких вычислений.

Входные данные содержат длину массива в первой строке.
Значения массива следуют во второй строке, через пробел.
Ответ должен содержать единственное число - получившуюся чексумму.

Пример:

входные данные:
6
3 1 4 1 5 9

ответ:
8921379

Все значения массива будут в диапазоне от 0 до 1 000 000 000 - 
не забудьте 
принять меры против возможного 
переполнения промежуточного результата!
 */

/**
 *
 * @author vvm
 */
import java.math.BigInteger;
import java.util.Scanner;

public class ArrayChecksum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numAr; // размер массива
        numAr = in.nextInt();
        int[] iAr = new int[numAr];// массив для хранения  введенных чисел
        BigInteger[] baAr = new BigInteger[numAr];
        for (int i = 0; i < numAr; i++) {
            iAr[i] = in.nextInt();
            baAr[i] = BigInteger.valueOf(iAr[i]);
        }
        in.close();

        System.out.print(midRes(baAr));

    }

    // 
    public static BigInteger midRes(BigInteger[] bAr) {

        BigInteger limit = BigInteger.valueOf(10000007);
        BigInteger result = BigInteger.ZERO;
        BigInteger seed = BigInteger.valueOf(113);

        for (int i = 0; i < bAr.length; i++) {
            result = result.add(bAr[i]);
            result = result.multiply(seed);
            //result =karaZuba(result,seed); you can use Karazuba method. можно использовать метод Карацубы 
            result = result.remainder(limit);
        }
        return result;
    }
    /* KaraZuba method to multiply , метод Карацубы для умножения но не нужен для BigInteger*/
 /* public static BigInteger karaZuba(BigInteger x, BigInteger y) {
    int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);
        N = (N / 2) + (N % 2);
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));
        BigInteger ac = karaZuba(a, c);
        BigInteger bd = karaZuba(b, d);
        BigInteger abcd = karaZuba(a.add(b), c.add(d));
        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }*/
}
