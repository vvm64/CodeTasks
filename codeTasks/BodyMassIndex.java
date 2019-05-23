package ready;

// ok

/*
Body Mass Index
Problem #28


Применим наши навыки программирования к некой квази-научной проблеме, 
поскольку заниматься лишь абстрактными упражнениями бывает скучно.

В 19 веке была предложена несложная мера "относительной упитанности" тела человека. 
Она вычисляется на основании только роста и веса, и называется 
Индекс Массы Тела (Body Mass Index = BMI). Определяется она как вес делённый на рост в квадрате:

BMI = вес / рост^2
Здесь вес берется в килограммах, а рост в метрах.

На основании этого показателя выделяют четыре категории:

Underweight     -           BMI < 18.5      (недостаточная масса)
Normal weight   -   18.5 <= BMI < 25.0      (норма)
Overweight      -   25.0 <= BMI < 30.0      (избыточная масса)
Obesity         -   30.0 <= BMI             (ожирение)
Например, если я вешу 80 кг а мой рост 173 см то можно вычислить:

BMI = 80 / (1.73)^2 = 26.7
т.е. присутствует избыточный вес.

Мы не будем обсуждать насколько правильна эта оценка 
(конечно она не учитывает многих факторов - пола, возраста, особенностей скелета) 
- вместо этого вам просто нужно определить категории для нескольких человек по их показателям.

Входные данные - указывают количество человек (подопытных!) в первой строке.
Остальные строки содержат параметры одного человека каждая - вес в килограммах и рост в метрах.
Ответ должен содержать одно из слов under, normal, over, obese (см. категории выше) 
для каждого из исследуемых людей, через пробел.

Пример:

входные данные:
3
80 1.73
55 1.58
49 1.91

ответ:
over normal under
 */
/**
 *
 * @author vvm
 *
 * решено
 */
import java.util.Arrays;
import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numAr;
        numAr = Integer.parseInt(in.nextLine());

        String[] myArStr = new String[numAr];

        for (int i = 0; i < numAr; i++) {

            myArStr[i] = in.nextLine();

            String tStr = myArStr[i];
            //myArStr[i]= myArStr[i].trim();
            tStr = tStr.trim();
            String[] strAr = tStr.split(" ");
            double[] dArr = Arrays.stream(strAr).mapToDouble((Double::parseDouble)).toArray();
            //System.out.println("  dArr  = "+ dArr[0] +" " +dArr[1]);
            String str = bodyMassIndex(dArr[0], dArr[1]);
            System.out.print(str + " ");
            tStr = null;
            dArr = null;
        }
        in.close();

    }

    public static String bodyMassIndex(double ves, double rost) {
        // BMI = вес / рост^2

        // Underweight     -           BMI < 18.5      (недостаточная масса)
        // Normal weight   -   18.5 <= BMI < 25.0      (норма)
        // Overweight      -   25.0 <= BMI < 30.0      (избыточная масса) over
        // Obesity         -   30.0 <= BMI             (ожирение) 
        String str = "";
        double BMI = (double) ves / Math.pow(rost, 2);

        if (Double.compare(BMI, 18.5) < 0) // if (BMI<18.5 )
        {
            str = "under";
        }
        if ((Double.compare(BMI, 18.5) == 0 || Double.compare(BMI, 18.5) > 0) && Double.compare(BMI, 25.0) < 0) //if ( 18.5 <= BMI || BMI< 25.0  )
        {
            str = "normal";
        }
        if ((Double.compare(BMI, 25.0) == 0 || Double.compare(BMI, 25.0) > 0) && Double.compare(BMI, 30.0) < 0) // if ( 25.0 <= BMI || BMI< 30.0 )
        {
            str = "over";
        }
        if (Double.compare(BMI, 30.0) == 0 || Double.compare(BMI, 30.0) > 0) // if ( BMI >=30.0 ) {
        {
            str = "obese";
        }

        //int  result = Double.compare(BMI, 20);
        return str;

    }

}
