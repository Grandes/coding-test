package Level1;

import java.util.HashMap;

public class Level1_중복된문자제거 {
    public static void main(String[] args) {
        // result : "peol"
        String my_string = "people";
        // result : "We arthwold"
//        String my_string = "We are the world";

        String solution = solution(my_string);
        System.out.println("solution : " + solution);
    }

    public static String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        String[] my_stringArray = my_string.split("");
        HashMap<String, Integer> my_stringArrayCount = new HashMap<>();
        for (String s : my_stringArray) {
            if (my_stringArrayCount.getOrDefault(s, 0) == 0) {
                answer.append(s);
            }

            my_stringArrayCount.put(s, my_stringArrayCount.getOrDefault(s, 0) + 1);
        }

        return answer.toString();
    }
}
