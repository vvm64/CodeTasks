package ready;

/*
 *  
Reverse String
Problem #30   Tags: strings arrays 
Переворот строки - очень простая задача - для тех кто начинает изучать текстовые строки...

Входные данные содержат одну строку из латинских букв и пробелов.
Ответ должен содержать строку такой же длины, но с символами в обратном порядке.

Пример:

входные данные:
four score and seven years ago

ответ:
oga sraey neves dna erocs ruof

Внимание хотя некоторые языки имеют готовую встроенную функцию для обращения строки, 
пожалуйста, попытайтесь реализовать алгоритм самостоятельно - т.е. 
рассматривая строку как массив символов, и оперируя с ними "на месте", 
переставляя их некоторым образом
- а не создавая новую строку (не выделяя дополнительной памяти).


 */
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author vvm решено
 */
public class ReverseString {

    public static void main(String[] args) {
        // 1. ввод строк
        // 2. разбиение на слова
        // 3. переворот строк
        Scanner in = new Scanner(System.in);
        String strIn = in.nextLine(); // ввод строки
        Stack stack = new Stack();

        char inChars[] = strIn.toCharArray(); // преобразование в массив

        for (int i = 0; i < inChars.length; i++) { // заталкивание в стек
            stack.push(inChars[i]);
        }
        String strOut = "";
        while (stack.empty() != true) { // выталкивание из стека в обратном порядке
            strOut += stack.pop();
        }
        System.out.println(strOut);
    }
}
