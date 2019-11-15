package standard_lib;
import java.util.ArrayList;

public class EdgeWeightedGraph {
	public int V;
	public ArrayList<Edge> all_edges;
	public ArrayList<Edge>[] adjacent;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V){
		this.V = V;
		all_edges = new ArrayList<Edge>();
		adjacent = new ArrayList[V];
		for (int i=0; i<V; i++){
			adjacent[i] = new ArrayList<Edge>();
		}
	}
	
	public void addEdge(Edge e){
		all_edges.add(e);
		int v = e.either();
		int w = e.other(v);
		adjacent[v].add(e);
		adjacent[w].add(e);
	}
	
	public Iterable<Edge> adj(int v){
		return adjacent[v];
	}
	
	public Iterable<Edge> edges(){
		// return all edges in graph
		return all_edges;
	}
	
	public int edge_num(){
		return this.all_edges.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
