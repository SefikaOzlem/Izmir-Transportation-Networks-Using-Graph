
import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {
	private int StopId;
	private String StopName;
	private ArrayList<Edge>girenEdges;
	private ArrayList<Edge>çıkanEdges;
	private int weight;
	private Vertex Parent;
	private boolean isVisited;
	public Vertex(int  stopıd,String stopName,int weight)
	{
		this.StopId=stopıd;
		this.StopName=stopName;
		girenEdges=new ArrayList();
		çıkanEdges=new ArrayList();
		this.weight=weight;
	}
	public int getStopId()
	{
		return StopId;
	}
	public void setStopId(int stopId) 
	{
		StopId = stopId;
	}
	public String getStopName()
	{
		return StopName;
	}
	public void setStopName(String stopName)
	{
		StopName = stopName;
	}
	public int getWeight()
	{
		return weight;
	}
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	public Vertex getParent() 
	{
		return Parent;
	}
	public void setParent(Vertex parent) 
	{
		Parent = parent;
	}
	public ArrayList<Edge> getGirenEdges() 
	{
		return girenEdges;
	}
	public ArrayList<Edge> getÇıkanEdges() 
	{
		return çıkanEdges;
	}
	public void AddEdgeGiren(Edge e)
	{
		this.girenEdges.add(e);
	}
	public void AddEdgeÇıkan(Edge e)
	{
		this.çıkanEdges.add(e);
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited)
	{
		this.isVisited = isVisited;
	}
}
