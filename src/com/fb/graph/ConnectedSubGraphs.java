package com.fb.graph;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
/*
 * DO DFS to understand a connected component
 */
public class ConnectedSubGraphs<T>{
	
	private final UnDirectedGraph<T> graph;
	private final ArrayList<T> visitedNodes = new ArrayList<T>();
	private final HashMap<Integer,HashSet<T>> connectedComps = new HashMap<Integer,HashSet<T>>();

	public ConnectedSubGraphs(UnDirectedGraph<T> graph){
		this.graph = graph;
	}
	
	
	//Other WAy
	
	public void findConnectedComponents2(){
		//Iterate across all the Nodes
		
		int count =0;
		for(T node: graph){
			//Run DFS for a node and get back a connected components
			if(!isVisited(node)){
				connectedComps.put(count,new HashSet<T>());
				dfs(node, count++);
			}
		}
		//Connected comps are:
		for(Entry<Integer, HashSet<T>> entry : connectedComps.entrySet()){
			System.out.println(entry.getKey()+ " "+ entry.getValue());
		}
	}
	public void dfs(T node, int count){
		visitedNodes.add(node); connectedComps.get(count).add(node);
		for(T leafNode :graph.getAdjacentNodes(node)){
			if (!isVisited(leafNode)){
				dfs(leafNode, count);
			}
		}
	}	
	//Other way
	
	// one way
	public void findConnectedComponents(){
		List<HashSet<T>> subGraphLists = new ArrayList<HashSet<T>>();
		//Iterate across all the Nodes
		for(T node: graph){
			//Run DFS for a node and get back a connected components
			if(!isVisited(node)){
				HashSet<T> subGraph = new HashSet<T>();
				dfs(node, subGraph);
				subGraphLists.add(subGraph);
			}
		}
		System.out.println(subGraphLists);
	}
	
	public void dfs(T node, HashSet<T> subGraph){
		visitedNodes.add(node); subGraph.add(node);
		for(T leafNode :graph.getAdjacentNodes(node)){
			if (!isVisited(leafNode)){
				dfs(leafNode, subGraph);
			}
		}
	}
	//one way
	
	
	public boolean isVisited(T node){
		return visitedNodes.contains(node);
	}
	
	
	public static void main(String[] args) {
	//      0                7-8
	//  5 	1  2 6
	//	    3       4         9-10-11-12
		
	UnDirectedGraph<GraphNode> dg = new UnDirectedGraph<GraphNode>();
	GraphNode zero = new GraphNode("0");GraphNode one = new GraphNode("1");GraphNode two = new GraphNode("2");GraphNode three = new GraphNode("3");GraphNode four = new GraphNode("4");
	GraphNode five = new GraphNode("5");GraphNode six = new GraphNode("6");GraphNode seven = new GraphNode("7");GraphNode eight = new GraphNode("8");GraphNode nine = new GraphNode("9");
	GraphNode ten = new GraphNode("10");GraphNode eleven = new GraphNode("11");GraphNode twelve = new GraphNode("12");
	
	dg.addNode(zero);dg.addNode(one);dg.addNode(two);dg.addNode(three);dg.addNode(four);dg.addNode(five);dg.addNode(six);
	dg.addNode(seven);dg.addNode(eight);dg.addNode(nine);dg.addNode(ten);dg.addNode(eleven);dg.addNode(twelve);
	
	dg.addEdge(zero, five);dg.addEdge(zero, one);dg.addEdge(zero, two);dg.addEdge(zero, six);
	dg.addEdge(six, four);dg.addEdge(five,three);dg.addEdge(three, four);dg.addEdge(four, five);
	/*
	 *             0
	 *          / / \ \
	 *        5  1  2  6
	 *      /  \       |
	 *    3-----4------|    
	*/
	
	
	
	dg.addEdge(seven, eight);
	dg.addEdge(nine, ten);dg.addEdge(nine, twelve);dg.addEdge(nine, eleven);dg.addEdge(eleven, twelve);
	
	ConnectedSubGraphs<GraphNode> conn = new ConnectedSubGraphs<GraphNode>(dg);
	//conn.findConnectedComponents2();
	conn.findConnectedComponents();
	
	
	}
}
