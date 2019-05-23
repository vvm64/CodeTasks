package ready;

// вроде ок

/*
Vowel Count
Problem #20 

 Эта простая задача познакомит нас с обработкой текстовых строк. 
Вам даны несколько строчек текста - и для каждой из них требуется подсчитать 
количество гласных (т.е. букв a, o, u, i, e, y).

Несмотря на простоту этот принцип важен, к примеру, в алгоритмах взлома шифров. 
Вы можете посмотреть задачу Caesar Cipher Cracker чтобы убедиться в этом.

Входные данные - в первой строке указано количество строк подлежащих обработке.
Дальше следуют сами строки, состоящие только из маленьких английских (латинских) букв и пробелов.
Ответ должен содержать количество гласных для каждой строки.

Пример:

входные данные:
4
abracadabra
pear tree
o a kak ushakov lil vo kashu kakao
my pyx

ответ:
5 4 13 2
 */
/**
 *
 * @author vvm
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VowelCount2 {

    public static char[] vowelsEn = new char[]{'e', 'y', 'u', 'i', 'o', 'a'};
    //гласная true , другая буква или символ - false

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowelsEn) //ищем среди массива гласных
        {
            if (c == d) {
                return true; //гласная true
            }
        }
        return false;// другая буква или цифра
    }

    public static int countStr(String str) {
        int icount = 0;
        char chars[] = str.toCharArray();
        int len = chars.length; // номер последнего элемента

        for (int i = 0; i < len; i++) {
            if (isVowel(chars[i])) {
                icount++;
            }
        }
        return icount;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(reader.readLine());
            String[] sarray = new String[num];
            int[] countVowels = new int[num];
            for (int i = 0; i < num; i++) {
                sarray[i] = reader.readLine();
            }

            for (int i = 0; i < num; i++) {
                countVowels[i] = countStr(sarray[i]);
            }

            for (int i = 0; i < num; i++) {
                System.out.print(countVowels[i] + " ");
            }

        } catch (IOException ex) {
            Logger.getLogger(VowelCount2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
