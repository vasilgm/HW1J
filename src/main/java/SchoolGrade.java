/*Дополнительные задания

2) Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика.
*/
package Homework_2.src.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolGrade {


    public static void main(String[] args) {
        createFile();
        String string = stringRead(new File("school"));
        System.out.println(string);
        String[] arraystring = changeString(string);
        printStrings(arraystring);
    }


    static void createFile() {
        try {
            File file = new File("school");
            if (!file.exists()) {
                String newstring = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, " +
                        "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, " +
                        "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                FileWriter writer = new FileWriter(file);
                writer.write(newstring);
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при создании файла.");
        }
    }


    static String stringRead(File file) {
        String newstring = "";
        try {
            FileReader reader = new FileReader(file);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
            return newstring = builder.toString();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при парсинге строки.");
        }
        return newstring;
    }

    static String[] changeString(String string) {
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains("[")) {
                strings[i] = strings[i].replace("[", "");
            }
            if (strings[i].contains("]")) {
                strings[i] = strings[i].replace("]", "");
            }
            if (strings[i].contains("{")) {
                strings[i] = strings[i].replace("{", "");
            }
            if (strings[i].contains("}")) {
                strings[i] = strings[i].replace("}", "");
            }
            if (strings[i].contains(",")) {
                strings[i] = strings[i].replace(",", " ");
            }
            if (strings[i].contains(":")) {
                strings[i] = strings[i].replace(":", " ");
            }
            if (strings[i].contains("\"")) {
                strings[i] = strings[i].replace("\"", "");
            }
            if (strings[i].contains("предмет")) {
                strings[i] = strings[i].replace("предмет", "по предмету");
            }
            if (strings[i].contains("фамилия")) {
                strings[i] = strings[i].replace("фамилия", "");
            }
            if (strings[i].contains("оценка")) {
                strings[i] = strings[i].replace("оценка", "получил");
            }
        }
        return strings;
    }

    static void printStrings(String[] array) {
        StringBuilder builder = new StringBuilder("Студент");
        for (String str : array) {
            System.out.println(builder.toString() + str);
        }
    }
}

