package part2.ch20;

public class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;
    }

    // System.out.println() 으로 객체 자체 출력
    public String toString() {
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }
}
