package UsageCaculator.Model;

public class SeriesUsageData {
	String org_id;
	String org_name;
	double quantity;

	public SeriesUsageData(){
		
	}
	
	public String getOrg_id() {
		return org_id;
	}

	public SeriesUsageData(String org_id, String org_name, double quantity) {
		super();
		this.org_id = org_id;
		this.org_name = org_name;
		this.quantity = quantity;
	}

	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
