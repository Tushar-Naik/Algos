package com.fb.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.yahoo.algos.Stack;

public class OrderCharacters {

	/**
	 * http://www.geeksforgeeks.org/flipkart-interview-set-2-sde-2/
	 *  Given a dictionary of unknown language and characters. Find out order between characters.
		Example :
		ab
		bcd
		ce
		de
		Output : a, b, c, d, e
		
		I am trying topological sort
	 */
	
	
	public static void main(String[] args) {
		DirectedGraph<GraphNode> dg = new DirectedGraph<GraphNode>();
		
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");
		GraphNode d = new GraphNode("d");
		GraphNode e = new GraphNode("e");
		dg.addNode(a);dg.addNode(b);dg.addNode(c);dg.addNode(d);dg.addNode(e);
		
		dg.addEdge(a, b);dg.addEdge(b, c);dg.addEdge(c, d);dg.addEdge(c, e);dg.addEdge(d, e);
		
		findOrder(dg);
		
		/*
		 *             a
		 *          /    
		 *        b       
		 *      /         
		 *    c
 		 *   / \
		 *  d---e       
		*/
	}

	private static void findOrder(DirectedGraph<GraphNode> dg) {
		Set<GraphNode> visited = new HashSet<GraphNode>();
		Stack<GraphNode> stack = new Stack<GraphNode>(dg.size());
		
		for(GraphNode node: dg){
			if(!visited.contains(node)){
				dfs(node, dg, visited, stack);
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}

	private static void dfs(GraphNode node, DirectedGraph<GraphNode> dg, Set<GraphNode> visited, Stack<GraphNode> stack ) {
		if (node==null) return;
		System.out.println(node); visited.add(node);
		for(GraphNode leaf : dg.getAdjacentNodes(node)){
			if (!visited.contains(leaf)){
				dfs(leaf, dg, visited, stack);
			}
		}
		stack.push(node);
		
	}
	
	

}
