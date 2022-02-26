package part2.ch20;

public class EdgePB implements Comparable<EdgePB> {
    public int weight;
    public String node1;
    public String node2;

    public EdgePB(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
    }

    @Override
    public int compareTo(EdgePB edgePB) {
        return this.weight - edgePB.weight;
    }
}
