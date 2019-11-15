package standard_lib;

public class DirectedEdge {
	public static int v, w;
	public static double weight;
	
	public DirectedEdge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from(){
		return v;
	}
	
	public int to(){
		return w;
	}
	
	public double weight(){
		return weight;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
