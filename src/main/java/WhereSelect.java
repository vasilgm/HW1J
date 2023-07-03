/* Задание
1) Дана строка sql-запроса "select * from students where ".
Сформируйте часть WHERE этого запроса, используя StringBuilder или String.
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

package Homework_2.src.main.java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class WhereSelect {
    public static void main(String[] args) {
        createFile();
        String string = stringRead(new File("string"));
        System.out.println(string);
        whereSelect(string);
    }

    static void createFile() {
        try {
            File file = new File("string");
            if (!file.exists()) {
                String newstring = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
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

    static void whereSelect(String string) {
        StringBuilder somestring = new StringBuilder("select * from students where ");
        String[] sql = string.split(" ");

        boolean firstCondition = true;

        for (String condition : sql) {
            if (condition.contains("null")) {
                continue;
            } else {
                if (!firstCondition) {
                    somestring.append(" AND ");
                }
                somestring.append(condition);
                firstCondition = false;
            }
        }

        somestring = new StringBuilder(somestring.toString().replace("{", ""));
        somestring = new StringBuilder(somestring.toString().replace("}", ""));
        somestring = new StringBuilder(somestring.toString().replace(":", "="));
        somestring = new StringBuilder(somestring.toString().replace(",", " "));

        System.out.println(somestring);
    }
}