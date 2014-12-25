package com.ajayb.infoworks;

import java.util.*;

/**
 * Using DFS to identify the subgraphs
 */
public class SubgraphIdentifier {

    public static <T> List<Set<T>> identifySubgraphs(DirectedAcyclicGraph<T> g) {
        List<Set<T>> subGraphs = new ArrayList<Set<T>>();
        Set<T> subGraph = new HashSet<T>();

        /* Fire off a DFS from each node in the graph. */
        for (T node : g) {
            if (subGraph.contains(node)) {
                continue;
            }
            subGraph = new HashSet<T>();
            explore(node, g, subGraph);
            subGraphs.add(subGraph);
        }

        Collections.sort(subGraphs, Collections.reverseOrder(new Comparator<Set<?>>() {
            @Override
            public int compare(Set<?> o1, Set<?> o2) {
                return Integer.valueOf(o1.size()).compareTo(o2.size());
            }
        }));

        return subGraphs;
    }

    public static <T> void explore(T node, DirectedAcyclicGraph<T> g,
                                   Set<T> visited) {
        visited.add(node);

        /* Recursively explore all of the node's predecessors. */
        for (T predecessor : g.edgesFrom(node))
            explore(predecessor, g, visited);

    }
}
