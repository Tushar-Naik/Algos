package com.fb.graph;

import java.util.HashSet;
import java.util.Set;

import com.yahoo.algos.MyQueue;

public class BFS<T> {

	/**
	 * Level ordering
	 * Shortest path 
	 */
	private final UnDirectedGraph<T> graph;
	private final MyQueue<T> queue;
	Set<T> visitedNodes = new HashSet<T>();

	public BFS(UnDirectedGraph<T> graph){
		this.graph = graph;
		queue = new MyQueue<T>(graph.size());
	}
	
	private void bfs(T root){
		queue.enqueue(root);
		visitedNodes.add(root);
		while(!queue.isEmpty()){
			T node = queue.dequeue();
			//visited node
			System.out.print(" "+node);
			for(T leaf: graph.getAdjacentNodes(node)){
				if(!visitedNodes.contains(leaf)){
					visitedNodes.add(leaf);   //Note we mark here, in DFS we marked at sysout
					queue.enqueue(leaf);
				}
			}
		}
	}
	
	public Set<T> getVisitedNodes(){
		return visitedNodes;
	}
	
	public static void main(String[] args) {

		UnDirectedGraph<GraphNode> dg = new UnDirectedGraph<GraphNode>();
		GraphNode zero = new GraphNode("0");GraphNode one = new GraphNode("1");GraphNode two = new GraphNode("2");GraphNode three = new GraphNode("3");GraphNode four = new GraphNode("4");
		GraphNode five = new GraphNode("5");GraphNode six = new GraphNode("6");GraphNode seven = new GraphNode("7");GraphNode eight = new GraphNode("8");GraphNode nine = new GraphNode("9");
		dg.addNode(zero);dg.addNode(one);dg.addNode(two);dg.addNode(three);dg.addNode(four);dg.addNode(five);dg.addNode(six);dg.addNode(seven);
		dg.addEdge(zero, five);dg.addEdge(zero, one);dg.addEdge(zero, two);dg.addEdge(zero, six);
		dg.addEdge(six, seven);
		dg.addEdge(five,three);dg.addEdge(four, five);
		dg.addEdge(four, five);//Just for sake not in graph. to show that bfs works on cyclic also
		/*
		 *             0
		 *          / / \ \
		 *        5  1  2  6
		 *      /  \      / 
		 *    3     4    7
		*/
		

		BFS<GraphNode> bfs = new BFS<GraphNode>(dg);
		bfs.bfs(zero);
	}

}
