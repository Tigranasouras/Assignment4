import java.util.*;
public class BalancedBrackets {
    public static String isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); //push it!
            }  else {
                if (stack.isEmpty()) {
                    return "Nah"; // nothing to pop!
                }
                char open = stack.pop(); // pop it!
                if ((ch == ')' && open != '(') ||
                        (ch == '}' && open != '{') ||
                        (ch == ']' && open != '[')) {
                    return "Nah"; // mismatched!
                }
            }
        }
        if (stack.isEmpty()) { // my return statement
            return "Yeppie";
        } else {
            return "Nah";
        }
    }
}
