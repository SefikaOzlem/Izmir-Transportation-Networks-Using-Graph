import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {
	@Override
	public int compare(Vertex V1, Vertex V2) {
            if (V1.getWeight()> V2.getWeight()) 
                return 1; 
            else if (V1.getWeight() < V2.getWeight()) 
                return -1; 
                            return 0; 
            } 
	}
