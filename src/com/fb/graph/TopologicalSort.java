package com.fb.graph;

import java.util.ArrayList;
import java.util.List;

import com.yahoo.algos.Stack;

public class TopologicalSort<T> {

	/**
	 * Used for sorting the constraints between edges, history punch cards ordering.
	 * So if edge u--->v then u comes before v in toposort
	 * Can be done only on DAG. no cycles
	 *(a) Manufacturing processes
	 *(b) Course b can be taken after a so toposort is a->b
	 *
	 *NOTE: the way this works is we add to a stack when a node is completely done(its leafs are done)
	 */
//	private static UnDirectedGraph<T> graph;
//	public TopologicalSort(UnDirectedGraph<T> graph){
//		this.graph = graph;
//	}
	
	private Stack<T> stackTopoNodes; 
	private List<T> visitedNodes = new ArrayList<T>();
	private DirectedGraph<T> graph;
	public TopologicalSort(DirectedGraph<T> graph){
		this.graph = graph.reverseGraph();
		stackTopoNodes = new Stack<T>(graph.size()); 
	}
	
	public List<T> sort(){
		//Perform DFS on all nodes
		for(T node: graph){
			if(!visitedNodes.contains(node)){
				dfs(node);
			}
		}
		while(!stackTopoNodes.isEmpty()){
			System.out.println(stackTopoNodes.pop());
		}
		return null;
	}
	
	private  void dfs(T node){
		visitedNodes.add(node);
		for(T leaf : graph.getAdjacentNodes(node)){
			if(!visitedNodes.contains(leaf)){
				dfs(leaf);
			}
		}
		stackTopoNodes.push(node);
	}
	
	public static void main(String[] args) {
		DirectedGraph<GraphNode> dg = new DirectedGraph<GraphNode>();
		GraphNode zero = new GraphNode("0");GraphNode one = new GraphNode("1");GraphNode two = new GraphNode("2");GraphNode three = new GraphNode("3");GraphNode four = new GraphNode("4");
		GraphNode five = new GraphNode("5");GraphNode six = new GraphNode("6");GraphNode seven = new GraphNode("7");GraphNode eight = new GraphNode("8");GraphNode nine = new GraphNode("9");
		dg.addNode(zero);dg.addNode(one);dg.addNode(two);dg.addNode(three);dg.addNode(four);dg.addNode(five);dg.addNode(six);dg.addNode(seven);
		dg.addEdge(zero, five);dg.addEdge(zero, one);dg.addEdge(zero, two);dg.addEdge(zero, six);
		dg.addEdge(six, seven);
		dg.addEdge(five,three);dg.addEdge( five,four);
		/*
		 *             0
		 *          / / \ \
		 *        5  1  2  6
		 *      /  \      / 
		 *    3     4    7
		*/
		
		TopologicalSort<GraphNode> sort = new TopologicalSort<GraphNode>(dg);
		sort.sort();
//		DFS<GraphNode> dfs = new DFS<GraphNode>(dg);
//		dfs.dfs(zero);
//		System.out.println(dfs.getVisitedNodes());

		FindCycle<GraphNode> fc = new FindCycle<GraphNode>(dg);
		try {
			fc.findCycle();
			System.out.println("No Cycle Detected");
		} catch (IllegalStateException ex) {
			System.out.println("Cycle Detected");
		}
		
	}

}
