package standard_lib;

import java.util.ArrayList;

public class DiGraph {
	public int V;
	public ArrayList<Integer>[] adjacent;
	
	@SuppressWarnings("unchecked")
	public DiGraph(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		adjacent = new ArrayList[V];
		for(int i=0; i<V; i++){
			adjacent[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int a, int b){
		// There a way from a to b 
		adjacent[a].add(b);
	}
	
	public Iterable<Integer> adj(int a){
		return adjacent[a];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
