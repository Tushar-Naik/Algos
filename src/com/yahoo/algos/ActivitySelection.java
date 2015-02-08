package com.yahoo.algos;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	/**
	 * Show timings given select which all can be seen. Or time when train in station
	 */
	public static void main(String[] args) {
		int[] start = { 7, 0, 4, 8, 4, 5 };// { 1, 3, 0, 5, 8, 5 };
		int[] finish = { 9, 10, 5, 9, 10, 7 };// { 2, 4, 6, 7, 9, 9 };
		Pair[] pairs = new Pair[start.length];
		for (int i = 0; i < start.length; i++) {
			pairs[i] = new Pair(start[i], finish[i]);
		}
		Arrays.sort(pairs);
		System.out.println("Following are the show times, which a user can see");
		// First one will be always chosen
		System.out.println(pairs[0]);
		int lastUsedIndex = 0;
		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i].startTime >= pairs[lastUsedIndex].endTime) {
				lastUsedIndex = i;
				System.out.println(pairs[i]);
			}
		}

	}

}


class Pair implements Comparable<Pair> {
	int startTime;
	int endTime;

	/**
	 * @param start
	 * @param end
	 */
	public Pair(int start, int end) {
		this.startTime = start;
		this.endTime = end;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pair [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(Pair o) {
		return endTime - o.endTime;
	}

}

class MComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		return o1.endTime - o2.endTime;
	}

}

