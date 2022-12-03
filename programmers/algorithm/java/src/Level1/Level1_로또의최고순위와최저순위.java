package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Level1_로또의최고순위와최저순위 {
    public static void main(String[] args) {
        // result = 3,5
//        int[] lottos = {44, 1, 0, 0, 31, 25};
//        int[] win_nums = {31, 10, 45, 1, 6, 19};
        // result = 1,6
//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};
        // result = 1,1
//        int[] lottos = {45, 4, 35, 20, 3, 9};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};


        // result = 3,5
        int[] lottos = {1,2,3,4,5,6};
        int[] win_nums = {7,8,9,10,11,12};
        int[] solution = solution(lottos, win_nums);

        System.out.println("solution : " + Arrays.toString(solution));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        int zeroCount = 0;
        for(int lotto : lottos) {
            if(lotto == 0)
                zeroCount++;
        }

        int sameCount = 0;
        for (int winNum : win_nums) {
            for (int lotto : lottos) {
                if (lotto == winNum) {
                    sameCount++;
                    break;
                }
            }
        }

        answer[0] = answer[0] - (sameCount + zeroCount);
        if(zeroCount == 6) {
            answer[1] = answer[1] - 1;
        } else {
            answer[1] = answer[1] - sameCount;
        }
        if(answer[0] > 6) answer[0]--;
        if(answer[1] > 6) answer[1]--;

        return answer;
    }

    // 성능이 압도적!!!
    public static int[] solution_best(int[] lottos, int[] win_nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int zeroCount = 0;

        for(int lotto : lottos) {
            if(lotto == 0) {
                zeroCount++;
                continue;
            }
            map.put(lotto, true);
        }


        int sameCount = 0;
        for(int winNum : win_nums) {
            if(map.containsKey(winNum)) sameCount++;
        }

        int maxRank = 7 - (sameCount + zeroCount);
        int minRank = 7 - sameCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}



















