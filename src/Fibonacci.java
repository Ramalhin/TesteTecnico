import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int num = scanner.nextInt();

        if (isFibonacci(num)) {
            System.out.println("O número " + num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + num + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }

    public static boolean isFibonacci(int n) {
        int a = 0;
        int b = 1;
        if (n == 0 || n == 1) {
            return true;
        }

        int c;
        while (b < n) {
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println("A sequencia de fibonnanci é:  0, 1, 1, 2, 3, 5, 8, 13, 21, 34... ");
        return b == n;


    }

}
