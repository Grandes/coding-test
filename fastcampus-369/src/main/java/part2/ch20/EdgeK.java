package part2.ch20;

public class EdgeK implements Comparable<EdgeK> {
    public int weight;
    public String nodeV;
    public String nodeU;

    public EdgeK(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(EdgeK edgeK) {
        return this.weight - edgeK.weight;
    }
}
