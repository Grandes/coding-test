import java.util.Arrays;

public class Level0_연속된수의합 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/120923
    public static void main(String[] args) {
        int num = 4;
        int total = 14;

//        num total result
//        3	12	[3, 4, 5]
//        5	15	[1, 2, 3, 4, 5]
//        4	14	[2, 3, 4, 5]
//        5	5	[-1, 0, 1, 2, 3]

        int[] result = solution(num, total);
        System.out.println("resut : " + Arrays.toString(result));
    }

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];

        int arrayMiddle = total / num;
        if((total % num) == 0) {
            for(int i = 0; i < num; i++) {
                answer[i] = arrayMiddle - (num / 2) + i;
            }
        } else {
            for(int i = 0; i < num; i++) {
                answer[i] = arrayMiddle - (num / 2) + i + 1;
            }
        }

        Arrays.sort(answer);
        return answer;
    }

    public static int[] bestSolution(int num, int total) {
        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        int start = (total - check) / num + 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start + i ;
        }
        return answer;
    }
}
