package JavaFundamentals;

public class main {
    public static void main(String[] args) {
        //source 1
        System.out.println("=====Source 1=====");
        String text = "Hello World";
        System.out.println(text);

        //source 2
        System.out.println("\n=====Source 2=====");
        int umur; //deklarasi
        umur = 30; //inisiasi
        //Konstanta memiliki nilai tetap yang tidak dapat diubah setelah diinisialisasi.
        final double PI = 3.14159; //konstanta
        boolean javaMenyenangkan = true;
        char nilai = 'A';
        //Inferensi Tipe (Java 10+):
        var hitung = 42; // Disimpulkan sebagai int
        String nama = "John"; // String adalah sebuah kelas
        int[] angka = {1, 2, 3, 4}; // Array dari bilangan bulat
        System.out.println(nama);

        //source 3
        System.out.println("\n=====Source 3=====");
        // Arithmetic Operators
        int resultAdd = 5 + 3; // Addition
        int resultSub = 7 - 2; // Subtraction
        int resultMul = 4 * 6; // Multiplication
        int resultDiv = 8 / 2; // Division
        int resultMod = 9 % 4; // Modulus
        // Comparison Operators
        boolean isEqual = resultAdd == resultSub;
        boolean isNotEqual = resultMul != resultDiv;
        boolean isGreaterThan = resultAdd > resultSub;
        boolean isLessThan = resultDiv < resultMod;
        // Logical Operators
        boolean condition1 = true;
        boolean condition2 = false;
        boolean logicalAnd = condition1 && condition2; // Logical AND
        boolean logicalOr = condition1 || condition2; // Logical OR
        boolean logicalNot = !condition1; // Logical NOT
        // Assignment Operators
        int number = 42;
        number += 10; // Compound Assignment
        // Increment and Decrement Operators
        int count = 5;
        count++; // Increment by 1
        count--; // Decrement by 1
        // Conditional (Ternary) Operator
        int age = 20;
        String canVote = (age >= 18) ? "Yes" : "No";
        // Expressions
        int expressionResult = resultAdd + resultSub;
        // Output Results
        System.out.println("Arithmetic Operators:");
        System.out.println("Addition: " + resultAdd);
        System.out.println("Subtraction: " + resultSub);
        System.out.println("Multiplication: " + resultMul);
        System.out.println("Division: " + resultDiv);
        System.out.println("Modulus: " + resultMod);
        System.out.println("\nComparison Operators:");
        System.out.println("Equal: " + isEqual);
        System.out.println("Not Equal: " + isNotEqual);
        System.out.println("Greater Than: " + isGreaterThan);
        System.out.println("Less Than: " + isLessThan);
        System.out.println("\nLogical Operators:");
        System.out.println("Logical AND: " + logicalAnd);
        System.out.println("Logical OR: " + logicalOr);
        System.out.println("Logical NOT: " + logicalNot);
        System.out.println("\nAssignment Operators:");
        System.out.println("Number: " + number);
        System.out.println("\nIncrement and Decrement Operators:");
        System.out.println("Count: " + count);
        System.out.println("\nConditional (Ternary) Operator:");
        System.out.println("Can Vote? " + canVote);
        System.out.println("\nExpressions:");
        System.out.println("Expression Result: " + expressionResult);

        //source 4
        System.out.println("\n=====source 4=====");
        // Conditional Statements
        int score = 85;
        if (score >= 90) {
            System.out.println("Excellent");
        } else if (score >= 80) {
            System.out.println("Good");
        } else {
            System.out.println("Average");
        }
        // Loop Statements
        System.out.println("Loop with for:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
        }
        System.out.println("\nLoop with while:");
        int j = 1;
        while (j <= 5) {
            System.out.println("Iteration " + j);
            j++;
        }
        System.out.println("\nLoop with do-while:");
        int k = 1;
        do {
            System.out.println("Iteration " + k);
            k++;
        } while (k <= 5);
        // Switch Statement
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }
        // Break and Continue Statements
        System.out.println("Break and Continue:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Skip iteration 3
            }
            System.out.println("Iteration " + i);
            if (i == 4) {
                break; // Exit the loop at iteration 4
            }
        }
        // Return Statement
        int sum = add(5, 3);
        System.out.println("Sum: " + sum);

    }
    public static int add(int a, int b) {
        return a + b;}
}
