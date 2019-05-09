package UsageCaculator.Model;

public class QueryTargetType {
	String target;
	String organizationId;
	String spaceId;
	String serviceName;
	String metricName;
	QueryIntervalTypeEnum intervalType;
	String refId;
	String type;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOrganizationId() {
		return organizationId.replace("|", ",").replace("(", "").replace(")", "");
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public QueryIntervalTypeEnum getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(QueryIntervalTypeEnum intervalType) {
		this.intervalType = intervalType;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpaceId() {
		return spaceId.replace("|", ",").replace("(", "").replace(")", "");
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

}
