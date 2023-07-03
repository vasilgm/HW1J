import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

//Задание
//
//        Пусть дан произвольный список целых чисел.
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение
public class HW3 {
    public static void main(String[] args){
        ArrayList<Integer> intarray = new ArrayList<>();
        for (int i =0; i<20; i++){
            intarray.add(new Random().nextInt(50));
        }
        System.out.println(intarray);
        for (int i =0; i<intarray.size(); i++) {
            if (intarray.get(i)%2 ==0){
                intarray.remove(i);
                i--;
            }
        }
        System.out.println(intarray);
        intarray.sort(Comparator.naturalOrder());
        System.out.println(intarray);
        System.out.println(intarray.get(0));
        System.out.println(intarray.get(intarray.size()-1));
        int sum = 0;
        for (int i =0; i<intarray.size(); i++){
            sum = sum + intarray.get(i);
        }
        double med = sum/intarray.size();
        System.out.println(med);
        }


    }


