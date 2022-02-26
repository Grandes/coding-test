package part2.ch18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Btreadth-Frist Search : 너비우선탐색
// 시간 복잡도 O(V + E) 노드 + 간선
public class BFS {
    public static void main(String[] args) {

        BFS bfs = new BFS();
        HashMap<String, ArrayList<String>> graph = bfs.sample_BFS();
        String startNode = "A";
        System.out.println("graph : " + graph);

        ArrayList<String> result = bfs.bfsFunc(graph, startNode);

        System.out.println("result : " + result);
    }

    // 기본 선언 HashMap<키타입, 값타입> 변수 = new HashMap<>();
    public HashMap<String, ArrayList<String>> sample_BFS() {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();

        graph.put("A", new ArrayList<>(Arrays.asList("B","C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A","D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A","G","H","I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B","E","F")));
        graph.put("E", new ArrayList<>(List.of("D")));
        graph.put("F", new ArrayList<>(List.of("D")));
        graph.put("G", new ArrayList<>(List.of("C")));
        graph.put("H", new ArrayList<>(List.of("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C","J")));
        graph.put("J", new ArrayList<>(List.of("I")));

        return graph;
    }

    public ArrayList<String> bfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while(needVisit.size() > 0) {
            String node = needVisit.remove(0);

            if(!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        return visited;
    }


}
