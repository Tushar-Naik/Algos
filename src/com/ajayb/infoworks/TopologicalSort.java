package com.ajayb.infoworks;


import java.util.*; // For List, Map.

public final class TopologicalSort {

    public static <T> List<T> sort(DirectedAcyclicGraph<T> g) {
        /* Construct the reverse graph from the input graph. */
        DirectedAcyclicGraph<T> gRev = reverseGraph(g);

        /* Maintain two structures - a set of visited nodes (so that once we've
         * added a node to the list, we don't label it again), and a list of
         * nodes that actually holds the topological ordering.
         */
        List<T> result = new ArrayList<T>();
        Set<T> visited = new HashSet<T>();

        Set<T> expanded = new HashSet<T>();

        /* Fire off a DFS from each node in the graph. */
        for (T node : gRev)
            explore(node, gRev, result, visited, expanded);

        /* Hand back the resulting ordering. */
        return result;
    }


    public static <T> void explore(T node, DirectedAcyclicGraph<T> g,
                                   List<T> ordering, Set<T> visited,
                                   Set<T> expanded) {
        if (visited.contains(node)) {
            if (expanded.contains(node)) return;
            throw new IllegalArgumentException("Graph contains a cycle.");
        }

        /* Mark that we've been here */
        visited.add(node);

        /* Recursively explore all of the node's predecessors. */
        for (T predecessor : g.edgesFrom(node))
            explore(predecessor, g, ordering, visited, expanded);

        ordering.add(node);

        /* Similarly, mark that this node is done being expanded. */
        expanded.add(node);
    }

    private static <T> DirectedAcyclicGraph<T> reverseGraph(DirectedAcyclicGraph<T> g) {
        DirectedAcyclicGraph<T> result = new DirectedAcyclicGraph<T>();

        /* Add all the nodes from the original graph. */
        for (T node : g)
            result.addNode(node);

        /* Scan over all the edges in the graph, adding their reverse to the
         * reverse graph.
         */
        for (T node : g)
            for (T endpoint : g.edgesFrom(node))
                result.addEdge(endpoint, node);

        return result;
    }
}
