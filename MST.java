package standard_lib;
import java.awt.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EdgeWeightedGraph G = new EdgeWeightedGraph(5);
		G.addEdge(new Edge(1, 2, 5));
		G.addEdge(new Edge(1, 3, 3));
		G.addEdge(new Edge(1, 4, 6));
		G.addEdge(new Edge(2, 3, 4));
		G.addEdge(new Edge(2, 4, 7));
		G.addEdge(new Edge(3, 4, 5));
		MST_Kruskal kr = new MST_Kruskal(G);
		System.out.println("MST Kruskal");
		for(Edge e: kr.edges()){
			System.out.printf("Edge: %d %d %f\n", e.v, e.w, e.weight);
		}
		
		System.out.println("MST Prim");
		PrimMST prim = new PrimMST(G, 1);
		for(Edge e: prim.edges()){
			System.out.printf("Edge: %d %d %f\n", e.v, e.w, e.weight);
		}
		
	}
}

class MST_Kruskal{
	public Queue<Edge> mst = new LinkedList<Edge>();
	public MST_Kruskal(EdgeWeightedGraph G){
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(G.edge_num(), new EdgeComparator());
		for (Edge e: G.edges()){
			pq.add(e);
		}
		UnionFind u = new UnionFind(G.V);
		while (!pq.isEmpty() && mst.size() < G.V-1){
			Edge e = pq.poll();
			int v = e.either(); int w = e.other(v);
			if (!u.find(v,  w)){
				u.unite(v, w);
				mst.add(e);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
}

class EdgeComparator implements Comparator<Edge>{

	@Override
	public int compare(Edge arg0, Edge arg1) {
		// TODO Auto-generated method stub
		if (arg0.weight > arg1.weight) return 1;
		else if (arg0.weight == arg1.weight) return 0;
		return -1;
	}
	
}

class PrimMST{
	public boolean[] marked;
	public Queue<Edge> mst;
	public PriorityQueue<Edge> pq;
	
	public PrimMST(EdgeWeightedGraph G, int source){
		pq = new PriorityQueue<Edge>(G.edge_num(), new EdgeComparator());
		mst = new LinkedList<Edge>();
		marked = new boolean[G.V];
		visit(G, source);
		while (!pq.isEmpty() && mst.size() < G.V -1){
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (marked[v] && marked[w]) continue;
			mst.add(e);
			if (!marked[v]) visit(G, v);
			if (!marked[w]) visit(G, w);
		}
		
	}

	public void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for (Edge e:G.adj(v)) if (!marked[e.other(v)]) pq.add(e);
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
}
