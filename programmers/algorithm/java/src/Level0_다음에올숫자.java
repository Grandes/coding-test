public class Level0_다음에올숫자 {

//    https://school.programmers.co.kr/learn/courses/30/lessons/120924
    public static void main(String[] args) {

//        int[] common = {1, 2, 3, 4};  // result : 5
        int[] common = {2, 4, 8};  // result : 16

        // 등차 혹은 등비수열...
        int result = solution(common);

        System.out.println("result : " + result);
    }

    public static int solution(int[] common) {
        int answer = 0;

        if(common[2] - common[1] == common[1] - common[0]) {
            // 등차수열
            answer = common[common.length -1] + common[1] - common[0];
        } else {
            // 등비수열
            answer = common[common.length -1] * common[1] / common[0];
        }

        return answer;
    }
}
