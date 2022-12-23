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
                .collect(Collectors.joining(""));
        System.out.println(toChuckCode(result));
    }

    private static String toChuckCode(String str) {
        var bits = str.split("");
        List<String> parts = new ArrayList<>();
        int count = 1;
        String current = bits[0];
        for (int i = 1; i < bits.length; i++) {
            if (bits[i].equals(bits[i - 1])) {
                count++;
            } else {
                parts.add(pad(count, current, ""));
                count = 1;
                current = bits[i];
            }
        }
        parts.add(pad(count, current, ""));

        return parts.stream()
                .map(Main::convertToZeros)
                .collect(Collectors.joining(" "));
    }

    private static String convertToZeros(String group) {
        var first = group.substring(0, 1);
        return first.equals("1") ?
                "0 " + pad(group.length(), "0", "") :
                "00 " + pad(group.length(), "0", "");
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