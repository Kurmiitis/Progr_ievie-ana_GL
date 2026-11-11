package application;

public class Items {
	private String name;
	private String type;
	private String desc;
	private int cost;
	
	public Items(String name, String type, String desc, int cost) {
		super();
		this.name = name;
		this.type = type;
		this.desc = desc;
		this.cost=cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getCost() {
		return cost;
		}
	public void setCost(int cost) {
		this.cost = cost;	

	}
	
	@Override
    public String toString() {
        return String.format("%s (%dg)", name, cost); // Example: "Divine Rapier (6300g)"
	}
}
