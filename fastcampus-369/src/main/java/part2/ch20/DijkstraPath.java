package part2.ch20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

// 최단경로 알고리즘
// 1. 단일 출발 > 다익스트라 알고리즘
// 2. 단일 도착
// 3. 단일 쌍
// 4. 전체 쌍
public class DijkstraPath {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        DijkstraPath dijkstraPath = new DijkstraPath();
        System.out.println(dijkstraPath.dijkstraFunc(graph,"A"));
    }

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        HashMap<String, Integer> distances = new HashMap<>();

        for(String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        // 알고리즘
        while(priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if(distances.get(currentNode) < currentDistance) {
                // 위의 while문으로 다시 돌아간다.
                continue;
            }

            nodeList = graph.get(currentNode);
            for (Edge edge : nodeList) {
                adjacentNode = edge;
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }

        return distances;
    }



    public void priorityQueueTest() {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        // add, offer 둘 다 같은 기능
        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.offer(new Edge(1, "C"));
        priorityQueue.offer(new Edge(7, "D"));

        System.out.println(priorityQueue);

        // PriorityQueue 최상단의 값을 가져오기만 하고 삭제하지는 않는다.
        Edge Test = priorityQueue.peek();

        // PriorityQueue 최상단의 값을 가져오며 삭제한다.
        Edge edge1 = priorityQueue.poll();
        System.out.println(edge1);
        System.out.println(priorityQueue);
    }

}
