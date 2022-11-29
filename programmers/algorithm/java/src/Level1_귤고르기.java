import java.util.ArrayList;
import java.util.HashMap;

public class Level1_귤고르기 {
    public static void main(String[] args) {

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};  // result : 3
//        int k = 4;
//        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};  // result : 2
//        int k = 2;
//        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};  // result : 1

        System.out.println("Level1_귤고르기.main");
        System.out.println("solution : " + solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> box = new HashMap<>();
        for (int j : tangerine) {
            box.put(j, box.getOrDefault(j, 0) + 1);
        }

        ArrayList<Integer> sizes = new ArrayList<>(box.values());
        sizes.sort(((o1, o2) -> o2 - o1));

        int count = 0;
        for (Integer size : sizes) {
            count += size;
            answer++;
            if (count >= k) {
                return answer;
            }
        }

        return answer;
    }
}
