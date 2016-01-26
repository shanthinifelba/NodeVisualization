
public class RoughNodes {
	int id;
	String name;
	int type;
	String machine;
	int length;
	public int Nodex;
	public int Nodey;
	public RoughNodes()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLength() {
		return id;
	}
	public void setLength(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	@Override
	public String toString() {
		return "RoughNodes [id=" + id + ", name=" + name + ", type=" + type
				+ ", machine=" + machine + "]";
	}
	
	public int getNodex() {
		return Nodex;
	}
	public void setNodex(int nodex) {
		Nodex = nodex;
	}
	public int getNodey() {
		return Nodey;
	}
	public void setNodey(int nodey) {
		Nodey = nodey;
	}
	
}
