package Level1;

import java.util.*;

public class Level1_신고결과받기 {
    public static void main(String[] args) {
        // result : [0,0]
//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;

        // result : [2,1,1,0]
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] solution = solution(id_list, report, k);
        System.out.println("solution: " + Arrays.toString(solution));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> id_report_list = new HashMap<>();
        Map<String, HashSet<String>> id_list_report = new HashMap<>();

        for(String id : id_list) {
            id_report_list.put(id, 0);
            id_list_report.put(id, new HashSet<>());
        }
        for(String reportString : report_set) {
            String[] splitResult = reportString.split(" ");
            id_report_list.put(splitResult[1], id_report_list.getOrDefault(splitResult[1], 0) + 1);
            id_list_report.get(splitResult[0]).add(splitResult[1]);
        }
        for(int i = 0; i < id_list.length; i++) {
            int resultCount = 0;
            for(String tempId : id_list_report.get(id_list[i])) {
                if(id_report_list.get(tempId) >= k)
                    resultCount++;
            }
            answer[i] = resultCount;
        }

        return answer;
    }

    public static int[] solution_another(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> report_set = new HashSet<>(Arrays.asList(report));
        HashMap<String, Integer> reported = new HashMap<>();

        for (String user_id: id_list) {
            reported.put(user_id, 0);
        }

        for (String i: report_set) {
            reported.put(i.split(" ")[1], reported.get(i.split(" ")[1]) + 1);
        }

        for (String i: report_set) {
            if (reported.get(i.split(" ")[1]) >= k) {
                answer[Arrays.asList(id_list).indexOf(i.split(" ")[0])] += 1;
            }
        }

        return answer;
    }
}
