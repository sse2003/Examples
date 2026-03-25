package org.sse.examples.other;

import java.util.LinkedList;
import java.util.List;

public class Brackets2 {
    public static void main(String[] args) {

        /*
         * Нужно сгенерировать все правильные скобочные последовательности со скобками одного вида,
         * где количество скобок равно k
         *
         * Вариант решения рекурсией
         * */

        int k = 3;

        var list = process(k, k, "", new LinkedList<String>());

        System.out.println(list);
        System.out.println("Total: " + list.size());

    }

    public static List<String> process(int in, int out, String current, List<String> list) {
        if (in == 0 && out == 0) {
            list.add(current);
            return list;
        }

        if (in == out) {
            // Открываем скобку
            process(in - 1, out, current + "(", list);
            return list;
        }

        if (in < out) {
            // Тут 2 варианта: еще раз открыть скобку, или закрыть скобку
            if (in > 0)
                process(in - 1, out, current + "(", list);
            if (out > 0)
                process(in, out - 1, current + ")", list);

            return list;
        }

        return list;
    }

    private static boolean check(String str) {
        int b = 0;
        for (var c : str.toCharArray()) {
            if (c == ')') b--;
            else if (c == '(') b++;
            else throw new RuntimeException();

            if (b < 0) return false;
        }
        return b == 0;
    }

}
