import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input for BalancedBrackets
        System.out.println("Balanced Brackets");
        System.out.println("Balanced Brackets: " + BalancedBrackets.isBalanced(scanner.nextLine()));
        // Read input for DecodeString
        System.out.println("Decode String");
        System.out.println("Decode String: " + DecodeString.decodeString(scanner.nextLine()));

        scanner.close();


    }
}