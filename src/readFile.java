import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class readFile {
	public static BufferedReader reader;
	public static ArrayList<String>Triptxt=new ArrayList();
	public static ArrayList<String>LineId=new ArrayList();
	public static ArrayList<String>Direction=new ArrayList();
	public static ArrayList<String>Order=new ArrayList();
	public static ArrayList<String>StopId=new ArrayList();

	public static ArrayList<String>Distancetxt=new ArrayList();
	public static ArrayList<String>OriginId=new ArrayList();
	public static ArrayList<String>DestinationId=new ArrayList();
	public static ArrayList<String>Dist=new ArrayList();
	public static ArrayList<Integer>distance=new ArrayList();
	public static ArrayList<String>origin_dest=new ArrayList();
	public static HashMap<String,Integer>dist_edg=new HashMap();


	public static ArrayList<String>Stoptxt=new ArrayList();
	public static ArrayList<String>StopId_StopTxt=new ArrayList();
	public static ArrayList<String>temp_stopıd=new ArrayList();
	public static ArrayList<String>StopName=new ArrayList();
	public static ArrayList<String>NeighborStops=new ArrayList();
	public static ArrayList<String>NeighborIds=new ArrayList();
	public static ArrayList<String>NeighborDistance=new ArrayList();
    public static HashMap<String,String>stopıd_of_neighs=new HashMap();

	public static HashMap<String,String>line_info=new HashMap();
	public static ArrayList<String>LineTxt=new ArrayList();
	public static ArrayList<String>Line_ıd_key=new ArrayList();
	public static ArrayList<String>Line_no=new ArrayList();
	public static ArrayList<String>Line_name=new ArrayList();
	public static ArrayList<String>Vehicle_type=new ArrayList();
	
	public static ArrayList<String>TestStopTxt=new ArrayList();
	public static ArrayList<String>OriginStopId=new ArrayList();
	public static ArrayList<String>DestinationStopId=new ArrayList();
	public static ArrayList<String>OriginStopName=new ArrayList();
	public static ArrayList<String>DestinationStopName=new ArrayList();
	public static ArrayList<Integer>Criteria=new ArrayList();
	
	public static void Stoptxt_read() throws IOException
	{
		reader=new BufferedReader(new FileReader("Stop.txt"));
		String linestops;
		while ((linestops = reader.readLine()) != null) 
		{
			if (linestops.isEmpty())
			{
				linestops=linestops.trim();
				continue;
			}
			String[] partstop = linestops.split(";");
			try {
				for(int j=0;j<partstop.length;j++)
				{
					if(partstop[j].isEmpty())
					{
						partstop[j]=partstop[j].trim();
						continue;
					}
					else 
					{
						Stoptxt.add(partstop[j].toLowerCase());
					}
				}				
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}
		}
		reader.close();
		for(int k=0;k<=5;k++)
		{
			Stoptxt.remove(0);					
		}
		for(int i=0;i<Stoptxt.size();i+=6)
		{
			StopId_StopTxt.add(Stoptxt.get(i));
		}
		for(int i=1;i<Stoptxt.size();i+=6)
		{
			StopName.add(Stoptxt.get(i));
		}
		for(int i=5;i<Stoptxt.size();i+=6)
		{
			String str=Stoptxt.get(i);
			String newStr=str.replaceAll("null","0:0");
			NeighborStops.add(newStr);
		}	
		String replace_sign;
		for(int i=0;i<NeighborStops.size();i++)
		{
			replace_sign=NeighborStops.get(i).toString().replace('.','#');
			stopıd_of_neighs.put(StopId_StopTxt.get(i), replace_sign);	
		}
	}
	public static void Triptxt_read() throws IOException
	{
		reader=new BufferedReader(new FileReader("Trip.txt"));
		String line;
		while ((line = reader.readLine()) != null) 
		{
			if (line.isEmpty())
			{
				line=line.trim();
				continue;
			}
			String[] parts = line.split(";");
			try {
				for(int j=0;j<parts.length;j++)
				{
					if(parts[j].isEmpty())
					{
						parts[j]=parts[j].trim();
						continue;
					}
					else 
					{
						Triptxt.add(parts[j].toLowerCase());
					}
				}				
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}
		}
		reader.close();
		for(int k=0;k<=3;k++)
		{
			Triptxt.remove(0);					
		}		
		for(int i=0;i<Triptxt.size();i+=4)
		{
			LineId.add(Triptxt.get(i));
		}
		for(int i=1;i<Triptxt.size();i+=4)
		{
			Direction.add(Triptxt.get(i));
		}
		for(int i=2;i<Triptxt.size();i+=4)
		{
			Order.add(Triptxt.get(i));
		}
		for(int i=3;i<Triptxt.size();i+=4)
		{
			StopId.add(Triptxt.get(i));
		}
	}
	public static void Distancetxt_read() throws IOException
	{
		reader=new BufferedReader(new FileReader("Distance.txt"));
		String linedistance;
		while ((linedistance = reader.readLine()) != null) 
		{
			if (linedistance.isEmpty())
			{
				linedistance=linedistance.trim();
				continue;
			}
			String[] partsdist = linedistance.split(";");
			try {
				for(int j=0;j<partsdist.length;j++)
				{
					if(partsdist[j].isEmpty())
					{
						partsdist[j]=partsdist[j].trim();
						continue;
					}
					else 
					{
						Distancetxt.add(partsdist[j].toLowerCase());
					}
				}				
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}
		}
		reader.close();
		for(int k=0;k<=2;k++)
		{
			Distancetxt.remove(0);					
		}
		for(int i=0;i<Distancetxt.size();i+=3)
		{
			OriginId.add(Distancetxt.get(i));
		}
		for(int i=1;i<Distancetxt.size();i+=3)
		{
			DestinationId.add(Distancetxt.get(i));
		}
		for(int i=2;i<Distancetxt.size();i+=3)
		{
			distance.add(Integer.parseInt(Distancetxt.get(i)));
		}
		for(int i=0;i<OriginId.size();i++)
		{
			dist_edg.put(OriginId.get(i)+"-"+DestinationId.get(i), distance.get(i));
		}
	}
	public static void LineTxt_read() throws IOException
	{
		reader=new BufferedReader(new FileReader("Line.txt"));
		String line_infos;
		while ((line_infos = reader.readLine()) != null) 
		{
			if (line_infos.isEmpty())
			{
				line_infos=line_infos.trim();
				continue;
			}
			String[] partlines= line_infos.split(";");
			try {
				for(int j=0;j<partlines.length;j++)
				{
					if(partlines[j].isEmpty())
					{
						partlines[j]=partlines[j].trim();
						continue;
					}
					else 
					{
						LineTxt.add(partlines[j].toLowerCase());
					}
				}				
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}
		}
		reader.close();
		for(int k=0;k<=3;k++)
		{
			LineTxt.remove(0);					
		}

		for(int i=0;i<LineTxt.size();i+=4)
		{
			Line_ıd_key.add(LineTxt.get(i));
		}

		for(int i=1;i<LineTxt.size();i+=4)
		{
			Line_no.add(LineTxt.get(i));
		}
		for(int i=2;i<LineTxt.size();i+=4)
		{
			Line_name.add(LineTxt.get(i));
		}
		for(int i=3;i<LineTxt.size();i+=4)
		{
			Vehicle_type.add(LineTxt.get(i));
		}
		for(int i=0;i<Line_ıd_key.size();i++)
		{
			line_info.put(Line_ıd_key.get(i), Line_no.get(i)+"_"+Line_name.get(i)+"_"+Vehicle_type.get(i));
		}
	}
	public static void TestTxt_read() throws IOException
	{
		reader=new BufferedReader(new FileReader("test_stops.txt"));
		String tests;
		while ((tests = reader.readLine()) != null) 
		{
			if (tests.isEmpty())
			{
				tests=tests.trim();
				continue;
			}
			String[] part_tests= tests.split(";");
			try {
				for(int j=0;j<part_tests.length;j++)
				{
					if(part_tests[j].isEmpty())
					{
						part_tests[j]=part_tests[j].trim();
						continue;
					}
					else 
					{
						TestStopTxt.add(part_tests[j].toLowerCase());
					}
				}				
			}catch(ArrayIndexOutOfBoundsException e)
			{
			}
		}
		reader.close();
		for(int k=0;k<=4;k++)
		{
			TestStopTxt.remove(0);					
		}
		for(int i=0;i<TestStopTxt.size();i+=5)
		{
			OriginStopId.add(TestStopTxt.get(i));
		}
		for(int i=1;i<TestStopTxt.size();i+=5)
		{
			DestinationStopId.add(TestStopTxt.get(i));
		}
		for(int i=2;i<TestStopTxt.size();i+=5)
		{
			OriginStopName.add(TestStopTxt.get(i));
		}
		for(int i=3;i<TestStopTxt.size();i+=5)
		{
			DestinationStopName.add(TestStopTxt.get(i));
		}
		for(int i=4;i<TestStopTxt.size();i+=5)
		{
			String a=TestStopTxt.get(i);
			int b=Integer.parseInt(a);
			Criteria.add(b);	
		}
	}
}