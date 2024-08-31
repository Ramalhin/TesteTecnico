import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escreva algo: ");
        String escrita = scanner.nextLine();


        String invertida = inverterString(escrita);
        System.out.println("String invertida: " + invertida);

        scanner.close();
    }


    public static String inverterString(String str) {
        String inversa = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            inversa += str.charAt(i);
        }
        return inversa;
    }
}
