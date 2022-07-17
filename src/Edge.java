
public class Edge {
	private Vertex Source;
	private Vertex Destination;
	private int pathweight;
	private String LineId;
	private String LineNo;
	private String direction;
	private String LineName;
	private String VehicleType;
	public Edge(Vertex origin,Vertex dest,int pathweight,String LineId,String Line_No,String Line_name,String vehictype,String direction)
	{
		this.Source=origin;
		this.Destination=dest;
		this.pathweight=pathweight;
		this.LineId=LineId;
		this.direction=direction;
		this.LineNo=Line_No;
		this.LineName=Line_name;
		this.VehicleType=vehictype;
	}
	public Edge(Vertex origin,Vertex dest,int pathweight)
	{
		this.Source=origin;
		this.Destination=dest;
		this.pathweight=pathweight;
	}
	public String getLineName() {
		return LineName;
	}

	public void setLineName(String lineName) {
		LineName = lineName;
	}
	public String getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}
	public Vertex getSource() {
		return Source;
	}
	public void setSource(Vertex source) {
		Source = source;
	}
	public Vertex getDestination() {
		return Destination;
	}
	public void setDestination(Vertex destination) {
		Destination = destination;
	}
	public int getPathweight() {
		return pathweight;
	}
	public void setPathweight(int pathweight) {
		this.pathweight = pathweight;
	}
	public String getLineId() {
		return LineId;
	}
	public void setLineId(String lineId) {
		LineId = lineId;
	}
	public String getLineNo() {
		return LineNo;
	}
	public void setLineNo(String lineNo) {
		LineNo = lineNo;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
