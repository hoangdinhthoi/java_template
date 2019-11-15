package standard_lib;

public class UnionFind {
	public int N;
	public int[] id;
	UnionFind(int N){
		this.N = N;
		id = new int[N];
		for (int i=0; i<N; i++){
			id[i] = i;
		}
	}
	
	public void unite(int a, int b){
		int i = root(a);
		int j = root(b);
		id[i] = j;
	}
	
	public int root(int i){
		while (id[i] != i){
			i = id[i];
			id[i] = id[id[i]];
		}
		return i;
	}
	
	public boolean find(int a, int b){
		return root(a) == root(b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionFind u = new UnionFind(10);
	}

}
