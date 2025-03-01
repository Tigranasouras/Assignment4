import java.util.*;

public class InfixToPostFix {
    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        Map<Character, Integer> superiority = new HashMap<>();
        superiority.put('+', 1);
        superiority.put('-', 1);
        superiority.put('*', 2);
        superiority.put('/', 2);
        superiority.put('^', 3);

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result += ch; // add operand to result
            } else if (ch == '(') {
                stack.push(ch); // push it!
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop(); // pop '('
            } else {
                while (!stack.isEmpty() && superiority.containsKey(stack.peek()) && superiority.get(stack.peek()) >= superiority.get(ch)) {
                    result += stack.pop();
                }
                stack.push(ch); // push operator
            }
        }

        while (!stack.isEmpty()) { // pop remaining operators
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String input = scanner.nextLine();
        System.out.println("Postfix expression: " + infixToPostfix(input));
        scanner.close();
    }
}
