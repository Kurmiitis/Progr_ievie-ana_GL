package application;



public class Heroes {
	private String name;
	private String type;
	private String atk_type;
	private int base_dmg;

	
	public Heroes(String name, String type, String atk_type, int base_dmg) {
		super();
		this.name = name;
		this.type = type;
		this.atk_type = atk_type;
		this.base_dmg = base_dmg;

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

	public String getAtk_type() {
		return atk_type;
	}

	public void setAtk_type(String atk_type) {
		this.atk_type = atk_type;
	}

	public int getBase_dmg() {
		return base_dmg;
	}

	public void setBase_dmg(int base_dmg) {
		this.base_dmg = base_dmg;
	}

	
	
	
	
}
