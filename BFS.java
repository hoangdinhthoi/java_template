package standard_lib;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public boolean[] visited;
	public int[] edgeTo;
	BFS(Graph G, int s){
		visited = new boolean[G.vertices()];
		edgeTo = new int[G.vertices()];
	}
	public void bfs(Graph G, int s){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()){
			int v = q.poll();
			for (int w: G.adj(v)){
				if (!visited[w]){
					q.add(w);
					visited[w] = true;
					edgeTo[w] = v;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
