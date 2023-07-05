import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Sem4 {
    static Scanner scanner;
    public static void main(String[] args){
        scanner = new Scanner(System.in);
        ArrayList<String> ma = new ArrayList<>();
        ArrayList<String> ms = new ArrayList<>();
        ArrayList<String> md = new ArrayList<>();
        ArrayList<Integer> mf = new ArrayList<>();
        ArrayList<Boolean> mz = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        while (true) {
            System.out.println("Введите фамилию -> ");
            ma.add(scanner.nextLine());
            System.out.println("Введите имя -> ");
            ms.add(scanner.nextLine());
            System.out.println("Введите отчество -> ");
            md.add(scanner.nextLine());
            System.out.println("Введите возраст -> ");
            mf.add(Integer.valueOf(scanner.nextLine()));
            System.out.println("Введите пол -> ");
            mz.add(scanner.nextLine().toLowerCase().contains("ж"));
            id.add(mz.size()-1);
            System.out.println("Продолжить ввод да/нет? -> ");
            String tmp = scanner.nextLine();
            if (tmp.toLowerCase().contains("нет")) break;
        }
        for (int i = 0; i < ma.size(); i++) {
            System.out.println(ma.get(i)+ " "+ ms.get(i).toUpperCase().charAt(0)+"."+ md.get(i).toUpperCase().charAt(0)+"."+" "+mf.get(i)+" "+(mz.get(i)?"Ж":"М"));
        }

        System.out.println("Сортировать по возрасту да/нет? -> ");
        String tmp = scanner.nextLine();
        if (tmp.toLowerCase().contains("да")){
        id.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o2, Integer o1) {
                if (mz.get(o1)) return 1;
                else return -1;
            }
        });
            id.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o2, Integer o1) {
                    if (mz.get(o2)) return mf.get(o2)-mf.get(o1);
                    return 0;
                }
            });
            id.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o2, Integer o1) {
                    if (!mz.get(o1)) return mf.get(o2)-mf.get(o1);
                    return 0;
                }
            });

            for (int i = 0; i < id.size(); i++) {
                System.out.println(ma.get(id.get(i))+ " "+ ms.get(id.get(i)).toUpperCase().charAt(0)+"."+ md.get(id.get(i)).toUpperCase().charAt(0)+"."+" "+mf.get(id.get(i))+" "+(mz.get(id.get(i))?"Ж":"М"));
            }

        }

        }

        }


