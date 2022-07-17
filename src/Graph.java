import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
public class Graph 
{
	static ArrayList<Vertex>Vertices=new ArrayList();//Array of stops
	static ArrayList<String>Lineıd_direction=new ArrayList();//Array of lineıd and direction of buses 
	static ArrayList<String>temp_removes=new ArrayList();
	static Vertex first; // start stop 
	static Vertex second; // next stop 
	static Vertex v;// added element of Vertices array 
	static Vertex from; // source vertex in Dijkstra algorithm
	static Vertex to; // neighbor of source vertex in Dijkstra algorithm
	static int ıd_integer; // ıd information parse the String to integer 
	static String str;// String temp Lineıd with Linedirection
	static String current;//temp to LineId_direction array of 0.index element
	static String next;//temp to LineId_direction array of 1.index element
	static int firstId;//in addEdge method temp to firststopıd 
	static int secondId;//in addEdge method temp to firststopıd 
	static int weight;//to set of Vertex weight
	static String line_ıdd;//in addEdge method
	static String line_no;//in addEdge method
	static String line_name;//in addEdge method
	static String vehictype;//in addEdge method
	static String line_info_temp;//in addEdge method
	static String direction;//in addEdge method
	static String ss;//String to change integer stopıd information
	static String neighs;//temp to StopTxt information about neighboors
	static String key_n;//temp to neighbor ıd of source
	static String val_dist;//temp to neighborıd and sourceıd of pathdistance
	static int n_ıd;//neighboor ıd type of integer for neighs 
	static int p_ıd;//source ıd type integer for key_n
	static int walk_dist;//integer type of walk_dist
	static int infinitiy_weight=Integer.MAX_VALUE;
	static HashMap<String,Edge>edgeee=new HashMap();//all edge temp
	static HashMap<String,Edge>tripedge=new HashMap();//only temp to edge according to triptxt and distancetxt
	static HashMap<String,Edge>walk_edge=new HashMap();//only temp to edge according to stoptxt
	static int Ori_ıd;//Origin stop ıd in Dijkstra method
	static int Dest_ıd;//destination stop ıd in Dijkstra method
	static Vertex source;//Origin vertex 
	static Vertex destination;//Destinstion vertex 
	static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>( new VertexComparator()); //order according to weight of vertices
	static LinkedList<Vertex>parents=new LinkedList();//temp to parents of destination vertex
	static LinkedList<Vertex>parent_main=new LinkedList();//temp to parents of destination vertex from beginning to end 
	static Vertex fromvertex;//Vertex fromvertex(from stop)
	static Vertex toVertex;//Vertex tovertex(to stop)
	public static void AddVertex(String stopıd,String stopname) throws IOException
	{
		ıd_integer=Integer.parseInt(stopıd);
		v=new Vertex(ıd_integer,stopname,infinitiy_weight);
		Vertices.add(v);

	}
	public static void Lineıd_direction_string(String Lineıd,String direction )
	{
		str=Lineıd+"_"+direction;
		Lineıd_direction.add(str);
	}
	public static void AddEdges() throws IOException
	{
		try {
			while(!Lineıd_direction.isEmpty()) {
				current=Lineıd_direction.get(0);
				next=Lineıd_direction.get(1);
				if(current.equalsIgnoreCase(next))
				{
					firstId=Integer.parseInt(readFile.StopId.get(0));
					secondId=Integer.parseInt(readFile.StopId.get(1));
					for(int i=0;i<Vertices.size();i++)
					{
						if(Vertices.get(i).getStopId()==firstId)
						{
							from=Vertices.get(i);
						}
						if(Vertices.get(i).getStopId()==secondId)
						{
							to=Vertices.get(i);							
						}
					}
					String[]c_li=current.split("_");
					line_ıdd=c_li[0];
					direction=c_li[1];
					temp_removes.add(Lineıd_direction.get(0));
					Lineıd_direction.remove(0);
					readFile.StopId.remove(0);
				}	
				else if(!current.equalsIgnoreCase(next))
				{
					temp_removes.add(Lineıd_direction.get(0));
					Lineıd_direction.remove(0);
					readFile.StopId.remove(0);
				}
				if(readFile.dist_edg.containsKey(firstId+"-"+secondId))
				{
					weight=readFile.dist_edg.get(firstId+"-"+secondId);
				}
				else if(!readFile.dist_edg.containsKey(firstId+"-"+secondId))
				{
					weight=625;
				}
				if(readFile.line_info.get(line_ıdd)!=null)
				{
					line_info_temp=readFile.line_info.get(line_ıdd);
					String []line_pie=line_info_temp.split("_");
					line_no=line_pie[0];
					line_name=line_pie[1];
					vehictype=line_pie[2];
				}
				try {
					Edge e=new Edge(from,to,weight,line_ıdd,line_no,line_name,vehictype,direction);
					from.AddEdgeÇıkan(e);
					to.AddEdgeGiren(e);
					edgeee.put(firstId+"-"+secondId, e);
					tripedge.put(firstId+"-"+secondId, e);
				}catch(IndexOutOfBoundsException e)
				{
				}
			}
		}catch(IndexOutOfBoundsException e)
		{
		}
	}
	public void addWalkedEdges()
	{
		try {
			for(int i=0;i<Vertices.size();i++)
			{
				ss=Integer.toString(Vertices.get(i).getStopId());
				if(readFile.stopıd_of_neighs.containsKey(ss))
				{
					neighs=readFile.stopıd_of_neighs.get(ss);
					String []n=neighs.split("#");
					for(int v=0;v<n.length;v++)
					{
						String nkey_val[]=n[v].split(":");
						key_n=nkey_val[0];
						val_dist=nkey_val[1];
						n_ıd=Integer.parseInt(key_n);
						p_ıd=Integer.parseInt(ss);
						walk_dist=Integer.parseInt(val_dist);
						if(Vertices.get(i).getStopId()==p_ıd)
						{
							from=Vertices.get(i);
						}
						for(int a=0;a<Vertices.size();a++)
						{
							if(Vertices.get(a).getStopId()==n_ıd)
							{
								to=Vertices.get(a);
								break;
							}
							else if(Vertices.get(a).getStopId()!=n_ıd)
							{
								continue;
							}
						}
						try {

							Edge walkedge=new Edge(from,to,walk_dist,"0","0","0","0","0");
							from.AddEdgeÇıkan(walkedge);
							to.AddEdgeGiren(walkedge);
							walk_edge.put(p_ıd+"-"+n_ıd,walkedge);
							edgeee.put(p_ıd+"-"+n_ıd,walkedge);
						}catch(IndexOutOfBoundsException e)
						{	
						}
					}
				}
			}
		}catch(IndexOutOfBoundsException e)	
		{
		}
	}
	public  void Dijkstra_Algorithm(String OriginStopId,String DestinationStopId,String OriginStopName,String DestinationStopName,int criteria)
	{
		if(criteria==1)
		{
			Ori_ıd=Integer.parseInt(OriginStopId);
			Dest_ıd=Integer.parseInt(DestinationStopId);
			for(int i=0;i<Vertices.size();i++)
			{
				if(Vertices.get(i).getStopId()==Ori_ıd)
				{
					source=Vertices.get(i);
				}
				if(Vertices.get(i).getStopId()==Dest_ıd)
				{
					destination=Vertices.get(i);
				}
			}
			source.setWeight(0);
			pq.add(source);
			while(!pq.isEmpty())
			{
				fromvertex=pq.poll();
				if(fromvertex.isVisited()==false)
				{
					for(Edge d:fromvertex.getÇıkanEdges())
					{
						toVertex=d.getDestination();		
						if(toVertex.getWeight()>(d.getPathweight()+fromvertex.getWeight()))
						{
							toVertex.setWeight(d.getPathweight()+fromvertex.getWeight());
							toVertex.setParent(fromvertex);	
						}
						pq.add(toVertex);
					}
				}
				fromvertex.setVisited(true);
			}
			int dd=destination.getWeight();
			while(destination!=null)
			{
				Vertex v=destination;
				parents.add(v);
				destination=v.getParent();
			}
			for(int i=parents.size()-1;i>=0;i--)
			{
				parent_main.add(parents.get(i));
			}
			System.out.println("******** "+OriginStopId+"-"+"---->"+DestinationStopId+" - "+OriginStopName+"---->"+DestinationStopName +"-"+criteria+" *******");
			System.out.println("Distance :"+ dd);		
			try {
				for(int i=0;i<parent_main.size();i++)
				{
					Vertex a=parent_main.get(i);
					Vertex b=parent_main.get(i+1);
					if(edgeee.containsKey(a.getStopId()+"-"+b.getStopId()))
					{
						System.out.print(a.getStopId()+"--->"+b.getStopId()+" ===> ");
						if(!(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineNo()+"--"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineName())+"-"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getDirection())));
						else if((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println("Walk :" +edgeee.get(a.getStopId()+"-"+b.getStopId()).getPathweight()+" m");
					}
				}
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}catch(NullPointerException e)
			{
			}catch(IndexOutOfBoundsException e)
			{
			}
			fromvertex.setWeight(0);
			for(int i=0;i<Vertices.size();i++)
			{
				Vertices.get(i).setParent(null);
				Vertices.get(i).setVisited(false);
				Vertices.get(i).setWeight(Integer.MAX_VALUE);
			}
			parents.clear();
         pq.clear();
		}
		else if(criteria==2)
		{
			Ori_ıd=Integer.parseInt(OriginStopId);
			Dest_ıd=Integer.parseInt(DestinationStopId);
			for(int i=0;i<Vertices.size();i++)
			{
				if(Vertices.get(i).getStopId()==Ori_ıd)
				{
					source=Vertices.get(i);
				}
				if(Vertices.get(i).getStopId()==Dest_ıd)
				{
					destination=Vertices.get(i);
				}
			}
			source.setWeight(1);
			pq.add(source);
			while(!pq.isEmpty())
			{
				fromvertex=pq.poll();
				if(fromvertex.isVisited()==false)
				{
					for(Edge ed:fromvertex.getÇıkanEdges())
					{
						toVertex=ed.getDestination();
						if(fromvertex.getWeight()<toVertex.getWeight())
						{
							toVertex.setWeight(fromvertex.getWeight()+1);
							toVertex.setParent(fromvertex);
						}
						pq.add(toVertex);
					}

				}
				fromvertex.setVisited(true);
			}
           int cc= destination.getWeight();
			while(destination!=null)
			{
				Vertex v=destination;
				parents.add(v);
				destination=v.getParent();
			}
			for(int i=parents.size()-1;i>=0;i--)
			{
				parent_main.add(parents.get(i));
			}
			System.out.println("******** "+OriginStopId+"-"+"---->"+DestinationStopId+" - "+OriginStopName+"---->"+DestinationStopName +"-"+criteria+" ********");
			System.out.println("Stop Counts :"+ cc);	
			try {
				for(int i=0;i<parent_main.size();i++)
				{
					Vertex a=parent_main.get(i);
					Vertex b=parent_main.get(i+1);
					if(edgeee.containsKey(a.getStopId()+"-"+b.getStopId()))
					{
						System.out.print(a.getStopId()+"--->"+b.getStopId()+" ===> ");
						if(!(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineNo()+"--"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineName())+"-"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getDirection())));
						else if((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println("Walk ");
					}
				}
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}catch(NullPointerException e)
			{

			}catch(IndexOutOfBoundsException e)
			{
			}
			fromvertex.setWeight(1);
			for(int i=0;i<Vertices.size();i++)
			{
				Vertices.get(i).setParent(null);
				Vertices.get(i).setVisited(false);
				Vertices.get(i).setWeight(Integer.MAX_VALUE);
			}
			parents.clear();
			pq.clear();
		}

	}
	public void Dijkstra_Algorithm_s(String OriginStopId,String DestinationStopId,int criteria)
	{
		if(criteria==1)
		{
			Ori_ıd=Integer.parseInt(OriginStopId);
			Dest_ıd=Integer.parseInt(DestinationStopId);
			for(int i=0;i<Vertices.size();i++)
			{
				if(Vertices.get(i).getStopId()==Ori_ıd)
				{
					source=Vertices.get(i);
				}
				if(Vertices.get(i).getStopId()==Dest_ıd)
				{
					destination=Vertices.get(i);
				}
			}
			String originname=source.getStopName();
			String destinationname=destination.getStopName();
			source.setWeight(0);
			pq.add(source);
			while(!pq.isEmpty())
			{
				fromvertex=pq.poll();
				if(fromvertex.isVisited()==false)
				{
					for(Edge d:fromvertex.getÇıkanEdges())
					{
						toVertex=d.getDestination();		
						if(toVertex.getWeight()>(d.getPathweight()+fromvertex.getWeight()))
						{
							toVertex.setWeight(d.getPathweight()+fromvertex.getWeight());
							toVertex.setParent(fromvertex);	
						}
						pq.add(toVertex);
					}
				}
				fromvertex.setVisited(true);
			}
			int dd=destination.getWeight();
			while(destination!=null)
			{
				Vertex v=destination;
				parents.add(v);
				destination=v.getParent();
			}
			for(int i=parents.size()-1;i>=0;i--)
			{
				parent_main.add(parents.get(i));
			}
			System.out.println("******** "+OriginStopId+"-"+"---->"+DestinationStopId+" - "+originname+"---->"+destinationname+"-"+criteria+" *******");
			System.out.println("Distance :"+ dd);		
			try {
				for(int i=0;i<parent_main.size();i++)
				{
					Vertex a=parent_main.get(i);
					Vertex b=parent_main.get(i+1);
					if(edgeee.containsKey(a.getStopId()+"-"+b.getStopId()))
					{
						System.out.print(a.getStopId()+"--->"+b.getStopId()+" ===> ");
						if(!(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineNo()+"--"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineName())+"-"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getDirection())));
						else if((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println("Walk :" +edgeee.get(a.getStopId()+"-"+b.getStopId()).getPathweight()+" m");
					}
				}
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}catch(NullPointerException e)
			{
			}catch(IndexOutOfBoundsException e)
			{
			}
			fromvertex.setWeight(0);
			for(int i=0;i<Vertices.size();i++)
			{
				Vertices.get(i).setParent(null);
				Vertices.get(i).setVisited(false);
				Vertices.get(i).setWeight(Integer.MAX_VALUE);
			}
			parents.clear();
         pq.clear();
		}
		else if(criteria==2)
		{
			Ori_ıd=Integer.parseInt(OriginStopId);
			Dest_ıd=Integer.parseInt(DestinationStopId);
			for(int i=0;i<Vertices.size();i++)
			{
				if(Vertices.get(i).getStopId()==Ori_ıd)
				{
					source=Vertices.get(i);
				}
				if(Vertices.get(i).getStopId()==Dest_ıd)
				{
					destination=Vertices.get(i);
				}
			}
			String originname=source.getStopName();
			String destinationname=destination.getStopName();
			source.setWeight(1);
			pq.add(source);
			while(!pq.isEmpty())
			{
				fromvertex=pq.poll();
				if(fromvertex.isVisited()==false)
				{
					for(Edge ed:fromvertex.getÇıkanEdges())
					{
						toVertex=ed.getDestination();
						if(fromvertex.getWeight()<toVertex.getWeight())
						{
							toVertex.setWeight(fromvertex.getWeight()+1);
							toVertex.setParent(fromvertex);
						}
						pq.add(toVertex);
					}

				}
				fromvertex.setVisited(true);
			}
           int cc= destination.getWeight();
			while(destination!=null)
			{
				Vertex v=destination;
				parents.add(v);
				destination=v.getParent();
			}
			for(int i=parents.size()-1;i>=0;i--)
			{
				parent_main.add(parents.get(i));
			}
			System.out.println("******** "+OriginStopId+"-"+"---->"+DestinationStopId+" - "+originname+"---->"+destinationname +"-"+criteria+" *******");
			System.out.println("Stop Counts :"+ cc);	
			try {
				for(int i=0;i<parent_main.size();i++)
				{
					Vertex a=parent_main.get(i);
					Vertex b=parent_main.get(i+1);
					if(edgeee.containsKey(a.getStopId()+"-"+b.getStopId()))
					{
						System.out.print(a.getStopId()+"--->"+b.getStopId()+" ===> ");
						if(!(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineNo()+"--"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineName())+"-"+(edgeee.get(a.getStopId()+"-"+b.getStopId()).getDirection())));
						else if((edgeee.get(a.getStopId()+"-"+b.getStopId()).getLineId().equalsIgnoreCase("0")))
							System.out.println("Walk ");
					}
				}
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}catch(NullPointerException e)
			{

			}catch(IndexOutOfBoundsException e)
			{
			}
			fromvertex.setWeight(1);
			for(int i=0;i<Vertices.size();i++)
			{
				Vertices.get(i).setParent(null);
				Vertices.get(i).setVisited(false);
				Vertices.get(i).setWeight(Integer.MAX_VALUE);
			}
			parents.clear();
			pq.clear();
		}

	}
}
