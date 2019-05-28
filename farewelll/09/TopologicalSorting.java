package nine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TopologicalSorting {
    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return new ArrayList<DirectedGraphNode>();
        }
        LinkedList<DirectedGraphNode> data = new LinkedList<>();
        Set<DirectedGraphNode> gray = new HashSet<>();
        Set<DirectedGraphNode> dark = new HashSet<>();
        for (DirectedGraphNode node : graph) {
            if (!gray.contains(node) && !dark.contains(node)) {
                dfs(node, gray, dark, data);
            }
        }
        return new ArrayList<DirectedGraphNode>(data);
    }

    void dfs(DirectedGraphNode node, Set<DirectedGraphNode> gray, Set<DirectedGraphNode> dark, LinkedList<DirectedGraphNode> data) {
        gray.add(node);
        for (DirectedGraphNode haier : node.neighbors) {
            if (!gray.contains(haier) && !dark.contains(haier)) {
                dfs(haier, gray, dark, data);
            }
        }
        dark.add(node);
        gray.remove(node);
        data.addFirst(node);
    }
}
