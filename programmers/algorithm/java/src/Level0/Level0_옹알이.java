package Level0;

import java.util.Arrays;

public class Level0_옹알이 {
    private static int answer;

//    https://school.programmers.co.kr/learn/courses/30/lessons/120956
    public static void main(String[] args) {
        System.out.println("test");

        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
//        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        System.out.println("result : " + solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] check = {"aya", "ye", "woo", "ma"};
        for (String babblingString : babbling) {
            for (String checkString : check) {
                if (babblingString.contains(checkString)) {
                    babblingString = babblingString.replace(checkString, ".");
                }
                if(babblingString.length() == babblingString.length() - babblingString.replace(".", "").length()) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(babbling));

        return answer;
    }
}
