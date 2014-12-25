package com.ajayb.infoworks;

import java.util.*;

/**
 * Directed Acyclic graph implementation. Auto corrects itself when a cycle is detected
 */
public class DirectedAcyclicGraph<T> implements Iterable<T> {

    private final Map<T, Set<T>> mGraph = new HashMap<T, Set<T>>();

    public boolean addNode(T node) {
        if (mGraph.containsKey(node))
            return false;

        mGraph.put(node, new HashSet<T>());
        return true;
    }

    public void addEdge(T start, T dest) {
        addEdge(start, dest, false);
    }

    public void addEdge(T start, T dest, boolean identifyCycle) {
        /* Confirm both endpoints exist. */
        if (!mGraph.containsKey(start) || !mGraph.containsKey(dest))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        /* Add the edge. */
        mGraph.get(start).add(dest);

        if (identifyCycle) {
            try {
                TopologicalSort.sort(this);
            } catch (Exception e) {
                System.out.printf("Cycle created. Hence removing the edge from : %s to : %s%n", start, dest);
                removeEdge(start, dest);
            }
        }
    }

    public void removeEdge(T start, T dest) {
        /* Confirm both endpoints exist. */
        if (!mGraph.containsKey(start) || !mGraph.containsKey(dest))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        mGraph.get(start).remove(dest);
    }

    public boolean edgeExists(T start, T end) {
        /* Confirm both endpoints exist. */
        if (!mGraph.containsKey(start) || !mGraph.containsKey(end))
            throw new NoSuchElementException("Both nodes must be in the graph.");

        return mGraph.get(start).contains(end);
    }

    public Set<T> edgesFrom(T node) {
        /* Check that the node exists. */
        Set<T> arcs = mGraph.get(node);
        if (arcs == null)
            throw new NoSuchElementException("Source node does not exist.");

        return Collections.unmodifiableSet(arcs);
    }

    public Iterator<T> iterator() {
        return mGraph.keySet().iterator();
    }

    public int size() {
        return mGraph.size();
    }

    public boolean isEmpty() {
        return mGraph.isEmpty();
    }
}

