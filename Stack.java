//Даден е код на модифициран програмски јазик каде функциите се претставени со отворен и затворен таг ("imeFunkcija" и "endimeFunkcija"). Ваша задача е да дефинирате дали даден програмски код е валиден.
//
//
//
//        Пример валиден код:
//
//        func1
//
//        func2
//
//        endfunc2
//
//        func3
//
//        endfunc3
//
//        endfunc1
//
//
//
//        Пример невалиден код (испуштен е затворен таг за func3):
//
//        func1
//
//        func2
//
//        endfunc2
//
//        func3
//
//        endfunc1
//
//
//
//        Влез: Код со модифициран програмски јазик, каде секој таг е напишан во нов ред. Се внесуваат тагови се додека не се внесе "x".
//
//
//
//        Излез: "Valid" - доколку е валиден кодот, "Invalid" - доколку не е валиден кодот.
//
//        /
//
//        We are given code in a modified programming language is given, where functions are represented by an opening and closing tag ("functionName" and "endfunctionName"). Your task is to determine whether the given code is valid.
//
//
//
//        Example of valid code:
//
//        func1
//
//        func2
//
//        endfunc2
//
//        func3
//
//        endfunc3
//
//        endfunc1
//
//
//        Example of invalid code (missing closing tag for func3):
//        func1
//
//        func2
//
//        endfunc2
//
//        func3
//
//        endfunc1
//
//
//
//        Input: Code in a modified programming language, where each tag is written in a new line. Tags are entered until "x" is entered.
//
//        Output: "Valid" if the code is valid, "Invalid" if the code is not valid.
//
//        For example:
//
//        Input	Result
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc3
//        endfunc1
//        x
//        Valid
//        func1
//        func2
//        endfunc2
//        func3
//        endfunc1
//        x
//        Invalid




import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true) {
            String line = scanner.nextLine().trim();

            if (line.equals("x")) {
                break; // Exit the loop when "x" is encountered.
            }

            if (line.startsWith("end")) {
                // Handle closing tag
                if (stack.isEmpty() || !stack.peek().equals(line.substring(3))) {
                    System.out.println("Invalid");
                    return;
                }
                stack.pop();
            } else {
                // Handle opening tag
                stack.push(line);
            }
        }

        // If the stack is empty, all tags were matched correctly
        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
