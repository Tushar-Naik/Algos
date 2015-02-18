package com.fb.graph;

import java.util.ArrayList;
import java.util.List;

import com.yahoo.algos.MyQueue;


/**
 * Count all possible walks from a source to a destination with exactly k edges
 * Given a directed graph and two vertices �u� and �v� in it, count all possible walks from �u� to �v� with exactly k edges on the walk. 
 */
public class SourceToDestInKPaths<T> {

	DirectedGraph<T> graph;
	MyQueue<QueueNode<T>> queue = null;
	List<T> visited = new ArrayList<T>();
	
	public SourceToDestInKPaths(DirectedGraph<T> dg) {
		this.graph = dg;
		queue = new MyQueue<QueueNode<T>>(dg.size());
	}

	private int path( T source, T dest, int k) {
		queue.enqueue(new QueueNode<T>(source, 0));
		return bfs(dest, k);
	}
	
	private int bfs( T destNode, int k){
		int count = 0;
		while(!queue.isEmpty()){
			QueueNode<T> qnode = queue.dequeue();
			int dist = qnode.dist;
			T node = qnode.node;
			//if dest is reached?
			if(node.equals(destNode) &&  (dist == k )){
				count ++;
			}
			
			for(T leaf : graph.getAdjacentNodes(node)){
				if(!visited.contains(leaf)){
					if(!leaf.equals(destNode)) visited.add(leaf);
					queue.enqueue(new QueueNode<T>(leaf, dist+1));
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		DirectedGraph<GraphNode> dg = new DirectedGraph<GraphNode>();
		GraphNode zero = new GraphNode("0");GraphNode one = new GraphNode("1");GraphNode two = new GraphNode("2");GraphNode three = new GraphNode("3");
		dg.addNode(zero);dg.addNode(one);dg.addNode(two);dg.addNode(three) ;
		dg.addEdge(zero,one);dg.addEdge( one,three);
		dg.addEdge(zero,three);dg.addEdge(zero,two);
		dg.addEdge(two,three);
		
//		GraphNode four = new GraphNode("4");
//		dg.addNode(four);
//		dg.addEdge(two,four);dg.addEdge( four,three);
		
		/*
		 *        0-----1-----
		 *        |\          |
		 *        | \         |
		 *        3--2        | 
		 *        |           |
		 *        |-----------|    
		*/
		
		SourceToDestInKPaths<GraphNode> sourceToDestInKPaths = new SourceToDestInKPaths<GraphNode>(dg);
		System.out.println(sourceToDestInKPaths.path(zero, three, 2));
		
	}
	private class QueueNode<K>{
		int dist;
		K node;
		public QueueNode(K node, int dist){
			this.node = node;
			this.dist = dist;
		}
	}
}
