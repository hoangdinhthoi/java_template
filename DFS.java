package standard_lib;

import java.util.Stack;

public class DFS {
	public boolean[] visited;
	public int[] edgeTo;
	public int s;
	
	public void pr(){
		for(int i: edgeTo){
			System.out.printf("%d ", i);
		}
	}
	
	public DFS(Graph G, int s){
		visited = new boolean[G.vertices()];
		edgeTo = new int[G.vertices()];
	}
	
	public void dfs(Graph G, int v){
		visited[v] = true;
		for(int w: G.adj(v)){
			if (!visited[w]){
				dfs(G, w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v){
		// check if there's a path from v to the source
		return visited[v];
	}
	
	public Iterable<Integer> PathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x=v; x!=s; x=edgeTo[x]) path.push(x);
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 7;
		Graph g = new Graph(V);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 6);
		g.addEdge(0, 5);
		g.addEdge(6, 4);
		g.addEdge(4, 3);
		g.addEdge(3, 5);
		g.addEdge(4, 5);
		DFS d = new DFS(g, 0);
		d.dfs(g, 0);
		for(int a: d.PathTo(5)){
			System.out.printf("%d ", a);
		}
	}

}
