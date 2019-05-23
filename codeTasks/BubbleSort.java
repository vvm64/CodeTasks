package ready;
// решено

/*
Bubble Sort
Problem #27 

 Перед решением этой задачи рекомендуется попробовать Пузырек в Массиве.

Сортировка - это перестановка элементов массива по какому-то простому правилу, 
основанному на сравнении. Представьте что нам дан массив:

a = [3, 1, 4, 1, 5, 9, 2, 6]
и мы хотим чтобы его элементы расположились в "неубывающем" порядке - т.е. 
если один элемент стоит раньше другого, то он должен быть меньше или равен этому другому.

Выражаясь математически, для любых индексов i и j если i < j тогда и a[i] <= a[j].

Сортировка Пузырьком - один из простейших способов осуществления такого упорядочивания. 
Мы опишем её даже немного проще чем обычно:

Сделайте проход по массиву, проверяя каждую пару соседних элементов 
(N-1 пара в массиве из N элементов).
Если в какой-то паре с индексами indexes i и i+1 обнаруживается что a[i] <= a[i+1] 
- т.е. больший элемент идёт раньше - меняем эти два элемента местами.
Повторяем такие "проходы" до тех пор пока не окажется что за весь проход ничего не поменяли.
Очевидно, что если на протяжении прохода по массиву ни одну пару не пришлось обменять, 
то массив уже отсортирован и последующие проходы ничего не изменят.

Для обмена элементов с индексами i и j существует несколько вариантов. 
Классический способ основан на использовании вспомогательной переменной t - вот так:

t = a[i]
a[i] = a[j]
a[j] = t
Входные данные указывают размер массива в первой строке - и элементы массива 
во второй (целые числа через пробел).
Ответ должен содержать два значения - количество проходов 
которые потребовались для того чтобы отсортировать массив 
по вышеописанному алгоритму - и суммарное количество обменов элементов (во всех этих проходах).

Пример:

входные данные:
8
3 1 4 1 5 9 2 6

ответ:
5 8
Заметьте что количество проверок пар (и количество обменов) приблизительно пропорционально N^2 где 
N это размер массива так что время затрачиваемое алгоритмом растёт гораздо быстрее 
чем размер массива - поэтому такой способ на практике используется только 
для небольших массивов (или в качестве составной части более сложных алгоритмов).
 */
/**
 *
 * @author vvm
 *
 */
import java.util.Scanner;

public class BubbleSort {

    public static int nPasses = 0; // колличество проходов
    public static int nSwaps = 0; // колличество обменов

    public static void main(String[] args) {

        int[] tosortAr;
        try (Scanner in = new Scanner(System.in)) {
            int numTr = in.nextInt();
            tosortAr = new int[numTr];
            for (int i = 0; i < numTr; i++) {
                tosortAr[i] = in.nextInt();
            }
        }

        bubbleSort4(tosortAr);

        //ucomment to see sorted array
        for (int i = 0; i < tosortAr.length; i++) {
            System.out.print("tosortAr = " + tosortAr[i] + " ");
        }

        System.out.println();
        System.out.println(nPasses + " " + nSwaps);
    }
    // сортировка пузырьком

    public static void bubbleSort4(int[] ar) {
        boolean swapped = true;
        int last = ar.length - 2;
        //  if(swapped==true) while {swapped=false}
        while (swapped) {
            swapped = false;
            for (int i = 0; i <= last; i++) {
                if (ar[i] > ar[i + 1]) {
                    // pair is out of order, swap them 
                    swap(ar, i, i + 1);
                    swapped = true; // swapping occurred 
                    if (swapped == true) {
                        BubbleSort.nSwaps++;
                    }
                }
            }
            // moved to end 
            last--;
            BubbleSort.nPasses++;
        }
    }

    private static void swap(int[] arr, int from, int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }

}
