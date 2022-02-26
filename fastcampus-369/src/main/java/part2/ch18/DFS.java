package part2.ch18;

// Depth-First Search : 깊이 우선 탐색
// 시간 복잡도 O(V + E) 노드 + 간선
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        DFS dfs = new DFS();
        HashMap<String, ArrayList<String>> graph = dfs.sample_BFS();
        String startNode = "A";
        System.out.println("graph : " + graph);

        ArrayList<String> result = dfs.dfsFunc(graph, startNode);

        System.out.println("result : " + result);

    }

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

    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while(needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size()-1);

            if(!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        return visited;
    }

}
