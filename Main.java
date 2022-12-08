package chucknorris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var input = readInput();

        System.out.println("The result:");
        var result = input.chars()
                .mapToObj(Integer::toBinaryString)
                .map(Main::zeroPadToSeven)
                .map(Main::toChuckCode)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static String toChuckCode(String str) {
        var bits = str.split("");
        List<String> parts = new ArrayList<>();
        String first = bits[0];
        for (int i = 0, j = 0; i < bits.length; i++) {
            // count the bits that are the same as the first
            // make the part and push to the list
            // reassign the first var to the next one
            // repeat until the end
        }
        return parts.stream().collect(Collectors.joining(" "));
    }

    private static String zeroPadToSeven(String str) {
        return str.length() == 7 ?
                str :
               pad(7 - str.length(), "0", str);
    }

    private static String pad(int size, String pad, String toPad) {
        var sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(pad);
        }
        return sb.append(toPad).toString();
    }

    private static String readInput() {
        System.out.println("Input string:");
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}