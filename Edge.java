package standard_lib;

public class Edge {
	public int v;
	public int w;
	public double weight;
	
	public Edge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either(){
		return v;
	}
	
	public int other(int vertex){
		if (vertex == v) return w;
		return v;
	}
	
	public int compareTo(Edge e){
		if (this.weight > e.weight) return 1;
		else if (this.weight == e.weight) return 0;
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
