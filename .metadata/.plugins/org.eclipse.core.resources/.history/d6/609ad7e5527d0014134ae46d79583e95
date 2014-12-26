package com.fb.graph;

public class GraphNode implements Comparable<GraphNode>{

	//int value;
	private String value;
	
	public GraphNode(String value){
		this.value = value;
	}
	
	@Override
	public int hashCode(){
		//return ((Integer)value).hashCode();
		return value.hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if( !(obj instanceof GraphNode)){
			return false;
		}
		return ((GraphNode)obj).getValue().equals(this.getValue());
	}
	
	@Override
	public String toString(){
		return value;
	}

	@Override
	public int compareTo(GraphNode node){
		if(! (node instanceof GraphNode)  )
			throw new IllegalStateException(); 
		return this.value.compareTo(node.getValue());
	}
	
	public String getValue() {
		return value;
	}
	

}
