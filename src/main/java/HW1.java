//Первый семинар.
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

import java.util.Random;
import java.util.Arrays;

public class HW1 {
    public static void main(String[] args) {

        int i = new Random().nextInt(0,2000);
        System.out.println(i);
        int n = Integer.toBinaryString(i).length();
        System.out.println(n);

        int x1 = 0;
        int y1 = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j%n == 0)
            {
                x1++;
            }
        }
        System.out.println(x1);
        int[] m1 = new int[x1];
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j%n == 0)
            {
                m1[y1]=j;
                y1++;
            }
        }
        System.out.println(Arrays.toString(m1));

        int x2 = 0;
        int y2 = 0;
        for (int j = i; j >= Short.MIN_VALUE; j--) {
            if (j%n != 0)
            {
                x2++;
            }
        }
        System.out.println(x2);
        int[] m2 = new int[x2];
        for (int j = i; j >= Short.MIN_VALUE; j--) {
            if (j%n != 0)
            {
                m2[y2]=j;
                y2++;
            }
        }
        System.out.println(Arrays.toString(m2));
    }
}
