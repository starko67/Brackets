package Brackets;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
public class BalanceBrackets {

    public static boolean isBalanced(String exp) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false; // Невозможно сбалансировать скобки, если стек пуст
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false; // Несоответствие типов скобок
                }
            }
        }

        return stack.isEmpty(); // Вернуть true, если стек пуст (все скобки сбалансированы)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp1 = scanner.nextLine();

        System.out.println("exp1: " + isBalanced(exp1));

    }
}

