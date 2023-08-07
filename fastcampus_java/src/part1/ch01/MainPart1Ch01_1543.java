package part1.ch01;

import java.util.Scanner;

public class MainPart1Ch01_1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;
        int startIndex = 0;
        while (true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0)
                break;
            count++;
            startIndex = findIndex + word.length();
        }
        System.out.println(count);

        String replaced = doc.replaceAll(word, "");
        int length = doc.length() - replaced.length();
        int replacedCount = length / word.length();
        System.out.println(replacedCount);
    }
}
