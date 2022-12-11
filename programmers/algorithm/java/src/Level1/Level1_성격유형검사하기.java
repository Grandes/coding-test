package Level1;

import java.util.HashMap;

public class Level1_성격유형검사하기 {
    public static void main(String[] args) {
        // result :TCMA
//        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] choices = {5, 3, 2, 7, 5};
        // result :RCJA
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        String solution = solution(survey, choices);
        System.out.println("solution: " + solution);
    }

    // R / T
    // C / F
    // J / M
    // A / N

    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] surveyAll = {"R","T","C","F","J","M","A","N"};
        HashMap<String, Integer> result = new HashMap<>();
        for(String surveyCase : surveyAll) {
            result.put(surveyCase, 0);
        }

        for(int i = 0; i < survey.length; i++) {
            String a = survey[i].split("")[0];
            String b = survey[i].split("")[1];

            if(choices[i] > 4) {
                result.put(b, result.get(b) + choices[i] - 4);
            } else if(choices[i] < 4) {
                result.put(a, result.get(a) + 4 - choices[i]);
            }
        }

        for(int i = 0; i < (surveyAll.length / 2); i++) {
            int j = i * 2;
            if(result.get(surveyAll[j]) > result.get(surveyAll[j + 1])) {
                answer.append(surveyAll[j]);
            } else if(result.get(surveyAll[j]) < result.get(surveyAll[j + 1])) {
                answer.append(surveyAll[j + 1]);
            } else {
                answer.append(surveyAll[j]);
            }
        }

        return answer.toString();
    }
}
