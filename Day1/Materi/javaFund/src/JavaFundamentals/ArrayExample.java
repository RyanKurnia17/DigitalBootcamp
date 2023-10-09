package JavaFundamentals;

public class ArrayExample {
    public static void main(String[] args) {
        // Declare and initialize an array of integers
        int[] numbers = { 1, 2, 3, 4, 5 };
        // Iterate through the array using a for loop
        System.out.println("Using a for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
        // Iterate through the array using an enhanced for loop (for-each loop)
        System.out.println("\nUsing an enhanced for loop (for-each loop):");
        for (int number : numbers) {
            System.out.println("Element: " + number);
        }
    }
}
