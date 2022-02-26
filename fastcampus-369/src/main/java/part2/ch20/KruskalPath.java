package part2.ch20;

import java.util.*;

// 최소 신장 트리 알고리즘 : 크루스칼 알고리즘
public class KruskalPath {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public String find(String node) {
        // path compression 기법
        if(!Objects.equals(this.parent.get(node), node)) {
//        if (this.parent.get(node) != node) {
            this.parent.put(node, find(this.parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if(this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if(Objects.equals(this.rank.get(root1), this.rank.get(root2))) {
//            if(this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    private ArrayList<EdgeK> kruskalFunc(ArrayList<String> vertices, ArrayList<EdgeK> edges) {
        ArrayList<EdgeK> mst = new ArrayList<>();
        EdgeK currentNode;

        // 1.초기화
        for (String vertex : vertices) {
            makeSet(vertex);
        }

        // 2.간선 weight 기반 sorting
        // Collections.sort() : ArrayList 정렬 기능
        Collections.sort(edges);

        for (EdgeK edge : edges) {
            currentNode = edge;
            if (!Objects.equals(find(currentNode.nodeV), find(currentNode.nodeU))) {
                union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        KruskalPath kruskalPath = new KruskalPath();

        ArrayList<String> vertices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<EdgeK> edges = kruskalPath.sample();

        System.out.println(kruskalPath.kruskalFunc(vertices, edges));

    }

    public ArrayList<EdgeK> sample() {
        ArrayList<EdgeK> edges = new ArrayList<>();
        edges.add(new EdgeK(7, "A", "B"));
        edges.add(new EdgeK(5, "A", "D"));
        edges.add(new EdgeK(7, "B", "A"));
        edges.add(new EdgeK(8, "B", "C"));
        edges.add(new EdgeK(9, "B", "D"));
        edges.add(new EdgeK(7, "B", "E"));
        edges.add(new EdgeK(8, "C", "B"));
        edges.add(new EdgeK(5, "C", "E"));
        edges.add(new EdgeK(5, "D", "A"));
        edges.add(new EdgeK(9, "D", "B"));
        edges.add(new EdgeK(7, "D", "E"));
        edges.add(new EdgeK(6, "D", "F"));
        edges.add(new EdgeK(7, "E", "B"));
        edges.add(new EdgeK(5, "E", "C"));
        edges.add(new EdgeK(7, "E", "D"));
        edges.add(new EdgeK(8, "E", "F"));
        edges.add(new EdgeK(9, "E", "G"));
        edges.add(new EdgeK(6, "F", "D"));
        edges.add(new EdgeK(8, "F", "E"));
        edges.add(new EdgeK(11, "F", "G"));
        edges.add(new EdgeK(9, "G", "E"));
        edges.add(new EdgeK(11, "G", "F"));

        return edges;
    }

}
