package com.yahoo.algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;


public class JobSequencing {

	/**
	 * http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
	 * Input: Four Jobs with following deadlines and profits
		  JobID    Deadline      Profit
		    a        4            20   
		    b        1            10
		    c        1            40  
		    d        1            30
		Output: Following is maximum profit sequence of jobs
		        c, a   
		
		
		Input:  Five Jobs with following deadlines and profits
		   JobID     Deadline     Profit
		     a         2           100
		     b         1           19
		     c         2           27
		     d         1           25
		     e         3           15
		Output: Following is maximum profit sequence of jobs
		        c, a, e
	 */
	
	private static class Tuple{
		String jobName;
		int deadline;
		public Tuple(String jobName, int deadline) {
			this.jobName = jobName;
			this.deadline = deadline;
		}
		@Override
		public String toString() {
			return "Tuple [jobName=" + jobName + ", deadline=" + deadline + "]";
		}
		
	}
	
	private static Comparator<Integer> comp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};
	
	private static void sequence(){
		TreeMap<Integer, Tuple> map = new TreeMap<Integer, Tuple>(comp);
		map.put(100, new Tuple("a", 2));
		map.put(19, new Tuple("b", 1));
		map.put(27, new Tuple("c", 2));
		map.put(25, new Tuple("d", 1));
		map.put(15, new Tuple("e", 3));
		
		List<String> selected = new ArrayList<String>();
		int count = 0; 
		for(Entry<Integer, Tuple> entry : map.entrySet()){
			if ( (count+1) <= entry.getValue().deadline  ){
				selected.add(entry.getValue().jobName);
				count++; 
			}
		}
		System.out.println(selected);
	}
	
	public static void main(String[] args) {
		sequence();
	}

}
