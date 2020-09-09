package recursiveDescent;

import java.util.Scanner;

/**
 * E -> TE'
 * E' -> +TE' | ε
 * T -> FT'
 * T' -> *FT' | ε
 * F -> (e) | i
 */

public class Recursive {
    static String str = "";
    static int index = 0;
    static int SIGN = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个以#结束的符号串：> ");
        while (sc.hasNext()) {
            str = sc.next();
            index = 0;
            SIGN = 0;

            E();

            if (SIGN != 1 && str.charAt(index) == '#') {
                System.out.println("success");;
            } else {
                System.out.println("error");
            }

            System.out.println();
            System.out.print("请输入一个以#结束的符号串：> ");
        }
    }

    static char getChar() {
        if (index < str.length()) {
            //index++;
            return str.charAt(index);
        }
        return ' ';
    }

    public static void E() {
        T();
        E1();
    }

    public static void E1() {
        char c = getChar();
        if (c == '+') {
            index++;
            T();
            E1();
        }

    }

    public static void T() {
            F();
            T1();
    }

    public static void T1() {
        char c = getChar();
            if (c == '*') {
                index++;
                F();
                T1();
            }

    }

    public static void F() {
        char c = getChar();

        if (c == 'i') {
            index++;
        } else if (c == '(') {
            index++;
            E();
            if (getChar() == ')') {
                index++;
            } else {
                SIGN = 1;
            }
        } else {
            SIGN = 1;
        }
    }
}
