package part2.ch19;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge> {
    public Integer distance;
    public String vertex;

    public Edge (Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(10, "A");
        Edge edge3 = new Edge(14, "A");
        Edge[] edges = new Edge[]{edge1, edge2, edge3};
        Arrays.sort(edges);

        for (Edge edge : edges) {
            System.out.println(edge.distance);
        }

        Edge edge4 = new Edge(12, "A");
        Edge edge5 = new Edge(10, "A");
        Edge edge6 = new Edge(14, "A");
        Edge[] edges2 = new Edge[]{edge4, edge5, edge6};
        Arrays.sort(edges2, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.distance - o1.distance;
            }
        });

        for (Edge edge : edges2) {
            System.out.println(edge.distance);
        }

    }


}
