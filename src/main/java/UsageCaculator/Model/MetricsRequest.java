package UsageCaculator.Model;

//選擇要量測的service
public class MetricsRequest {
	String serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
}
