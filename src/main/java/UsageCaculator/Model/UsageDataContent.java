package UsageCaculator.Model;

public class UsageDataContent {
	long time;
	double quantity;

	public UsageDataContent(long time, double quantity) {
		// TODO Auto-generated constructor stub
		this.time = time;
		this.quantity = quantity;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
