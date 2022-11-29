package Level1;

import java.util.*;

public class Level1_과일장수 {
    public static void main(String[] args) {

//        int k = 3;
//        int m = 4;
//        int[] score = {1, 2, 3, 1, 2, 3, 1};  // result : 8
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};  // result : 33

        System.out.println("Level1_과일장수.main");
        System.out.println("solution : " + solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Integer[] sortScore = Arrays.stream(score).boxed().toArray(Integer[]::new);

        Arrays.sort(sortScore, Collections.reverseOrder());

        for(int z = 1; z < (score.length / 2 + 1); z++) {
            if(z * m > score.length) {
                return answer;
            } else {
                answer += sortScore[z * m - 1] * m;
            }
        }

        return answer;
    }

    public static int solution_best(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i = score.length-m; i >= 0; i-=m) {
            answer += score[i]*m;
        }

        return answer;
    }
}
