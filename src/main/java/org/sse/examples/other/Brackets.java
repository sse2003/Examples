package org.sse.examples.other;

public class Brackets {
    public static void main(String[] args) {

        /*
         * Нужно сгенерировать все правильные скобочные последовательности со скобками одного вида,
         * где количество скобок равно k
         *
         * Вариант решения с числовым перебором
         * */

        int k = 3;
        int brackets = k * 2;
        long max = ((1 << k) - 1) << k; // 111000
        long min = (1 << (k * 2 - 1)); // 100000
        int total = 0;

        System.out.println("max:" + max);
        System.out.println("min:" + min);

        for (long i = max; i > min; i--) {
            if (check(i, brackets)) {
                total++;
                System.out.println(toBracketString(i));
            }
        }

        System.out.println("Total: " + total);

    }

    private static String toBracketString(long v) {
        StringBuilder result = new StringBuilder();

        while (v > 0) {
            if ((v & 1) == 1) result.insert(0, "(");
            else result.insert(0, ")");
            v = v >> 1;
        }
        return result.toString();
    }

    private static boolean check(long v, int brackets) {
        int b = 0;

        for (int i = brackets - 1; i >= 0; i--) {
            // 111000
            boolean vb = ((v >> i) & 1) == 1;
            if (vb) b++;
            else b--;

            if (b < 0) return false;
        }
        return b == 0;
    }

}
