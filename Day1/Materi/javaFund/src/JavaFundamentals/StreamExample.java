package JavaFundamentals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        // Buat List angka
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Traditional approach
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        System.out.println("Bilangan genap (tradisional): " + evenNumbers);
        // Menggunakan Java Stream untuk mengambil bilangan genap dan menjadikannya List baru
        List<Integer> evenNumbersStream = numbers.stream().filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Bilangan genap (Java Stream): " +
                evenNumbersStream);

        //Latihan
        List<Integer> collectionA = Arrays.asList(1, 2, 3);
        List<Integer> collectionB = Arrays.asList(2, 3, 4);
        List<Integer> collectionC = collectionA.stream().distinct().filter(collectionB::contains)
                .collect(Collectors.toList());
        // bisa menggunakan for each jug
//        for (int i = 0;i<collectionA.size();i++){
//            for (int j = 0; j < collectionB.size(); j++) {
//                if (collectionA.get(i).equals(collectionB.get(j))){
//                    collectionC.add(collectionA.get(i));
//                }
//            }
//        }
        System.out.println("Intersection of Collection A and B is : " + collectionC);

    }
}
