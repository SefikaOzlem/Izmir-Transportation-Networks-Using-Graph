
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Opr {

	static Graph g=new Graph();
	static Scanner scan=new Scanner(System.in);
	public static void operations() throws IOException
	{
		readFile.Stoptxt_read();
		readFile.Triptxt_read();
		readFile.Distancetxt_read();
		readFile.LineTxt_read();
		readFile.TestTxt_read();
		for(int i=0;i<readFile.StopId_StopTxt.size();i++)
		{
			g.AddVertex(readFile.StopId_StopTxt.get(i), readFile.StopName.get(i));
		}
		for(int i=0;i<readFile.LineId.size();i++)
		{
			g.Lineıd_direction_string(readFile.LineId.get(i), readFile.Direction.get(i));
		}
		g.AddEdges();
		g.addWalkedEdges();	
		for(Edge e:g.edgeee.values())
		{
			//System.out.println(e.getSource().getStopId()+"-"+e.getDestination().getStopId()+"="+e.getPathweight()+"--"+e.getLineId()+"-"+e.getLineNo()+"/"+e.getLineName()+"/"+e.getVehicleType()+"/"+e.getDirection());;
		}
        System.out.println("Press 1 to view testfile   ----   2 to do research");
		while(true)
		{
			System.out.println("Option : ");
			int test=scan.nextInt();
			System.out.println();
			if(test==1)
			{
				Time.start();
				for(int i=0;i<readFile.DestinationStopName.size();i++)
				{	
					g.Dijkstra_Algorithm(readFile.OriginStopId.get(i), readFile.DestinationStopId.get(i), readFile.OriginStopName.get(i), readFile.DestinationStopName.get(i),readFile.Criteria.get(i));
				}
				Time.stop();
				double  t=Time.getElapsedSeconds();
			    System.out.println("The total time :"+t);
			}
			else if(test==2)
			{
		       try {
				System.out.println("Origin Id:");
				String originId=scan.next();	
				System.out.println("Destination Id:");
				String destinationId=scan.next();
				System.out.println("For Minimum Distance--> 1       For Fewer Stop--> 2");
				int crt=scan.nextInt();
				Time.start();
				g.Dijkstra_Algorithm_s(originId, destinationId, crt);
				Time.stop();
				double s=Time.getElapsedSeconds();
				System.out.println("Search time : "+s);
		       }catch(NullPointerException e)
		       {
		    	   System.out.println("THE STOP ID WAS NOT FOUND ");
		       }catch(InputMismatchException e)
		       {
		    	   System.out.println("Please enter a value of type number");
		       }
		       catch(NumberFormatException e)
		       {
		    	   System.out.println("Please enter value of type number");
		       }
			}
			System.out.println();
		}
	}
}
