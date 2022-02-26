package part2.ch20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath {
    public static void main(String[] args) {
        PrimPath primPath = new PrimPath();
        
        ArrayList<EdgePB> myedges = primPath.sample();

        System.out.println(primPath.primFunc("A", myedges));
    }

    private ArrayList<EdgePB> primFunc(String startNode, ArrayList<EdgePB> edges) {
        EdgePB currentNode, poppedEdge, adjacentEdgeNode;
        ArrayList<EdgePB> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<EdgePB> priorityQueue;
        ArrayList<String> connectedNodes = new ArrayList<>();

        ArrayList<EdgePB> mst = new ArrayList<>();

        HashMap<String, ArrayList<EdgePB>> adjacentEdges = new HashMap<>();

        for(EdgePB edge : edges) {
            currentNode = edge;
            if(!adjacentEdges.containsKey(currentNode.node1)) {
                adjacentEdges.put(currentNode.node1, new ArrayList<>());
            }
            if(!adjacentEdges.containsKey(currentNode.node2)) {
                adjacentEdges.put(currentNode.node2, new ArrayList<>());
            }
        }

        for(EdgePB edge : edges) {
            currentNode = edge;
            currentEdgeList = adjacentEdges.get(currentNode.node1);
            currentEdgeList.add(new EdgePB(currentNode.weight, currentNode.node1, currentNode.node2));
            currentEdgeList = adjacentEdges.get(currentNode.node2);
            currentEdgeList.add(new EdgePB(currentNode.weight, currentNode.node2, currentNode.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<EdgePB>());
        priorityQueue = new PriorityQueue<EdgePB>();
        priorityQueue.addAll(candidateEdgeList);
//        for (EdgePB edgePB : candidateEdgeList) {
//            priorityQueue.add(edgePB);
//        }

        while(priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                connectedNodes.add(poppedEdge.node2);
                mst.add(new EdgePB(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<EdgePB>());
                for (EdgePB edge : adjacentEdgeNodes) {
                    adjacentEdgeNode = edge;
                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }

    public ArrayList<EdgePB> sample() {
        ArrayList<EdgePB> myedges = new ArrayList<>();
        myedges.add(new EdgePB(7, "A", "B"));
        myedges.add(new EdgePB(5, "A", "D"));
        myedges.add(new EdgePB(8, "B", "C"));
        myedges.add(new EdgePB(9, "B", "D"));
        myedges.add(new EdgePB(7, "D", "E"));
        myedges.add(new EdgePB(5, "C", "E"));
        myedges.add(new EdgePB(7, "B", "E"));
        myedges.add(new EdgePB(6, "D", "F"));
        myedges.add(new EdgePB(8, "E", "F"));
        myedges.add(new EdgePB(9, "E", "G"));
        myedges.add(new EdgePB(11, "F", "G"));
        
        return myedges;
    }
    
}
