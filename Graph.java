package standard_lib;

import java.util.*;

public class Graph {
	public int V;
	public ArrayList<Integer>[] adjacent;
	
	@SuppressWarnings("unchecked")
	Graph(int V){
		this.V = V;
		adjacent = new ArrayList[V];
		for(int i=0; i<V; i++){
			adjacent[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int a, int b){
		adjacent[a].add(b);
		adjacent[b].add(a);
	}
	
	public Iterable<Integer> adj(int a){
		return adjacent[a];
	}
	
	public int vertices(){
		return V;
	}
	public static int test(int[] a){
		a[0] += 1;
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {1,2,3,4};
		int i = test(a);
		System.out.println(i);
		System.out.println(a[0]);
	}

}
