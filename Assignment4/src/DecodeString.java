import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                int count = countStack.pop();
                String decoded = stringStack.pop();
                for (int i = 0; i < count; i++) {
                    decoded += currentString;
                }
                currentString = decoded;
            } else {
                currentString += ch;
            }
        }
        return currentString;
    }
}