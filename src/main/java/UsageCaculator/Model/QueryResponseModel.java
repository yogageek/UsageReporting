package UsageCaculator.Model;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@JsonIgnoreProperties(value = { "logger", "formatter", "jdbcTemplate", "serviceMetricMap", "rawSql" })
public class QueryResponseModel {
	transient private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	transient private Map<String, Map<String, String>> serviceMetricMap;

	String target;
	String organizationId;
	String spaceId;
	String serviceName;
	String metricName;
	Long[][] datapoints;

	public QueryResponseModel(String target, String organizationId, String spaceId, String serviceName,
			String metricName) {
		super();
		this.target = target;
		this.organizationId = organizationId;
		this.spaceId = spaceId;
		this.serviceName = serviceName;
		this.metricName = metricName;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
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

	public Long[][] getDatapoints() {
		return datapoints;
	}

	public void setDatapoints(Long[][] dataPoints) {
		this.datapoints = dataPoints;
	}

//	public Map<String, Map<String, String>> getServiceMetricMap() {
//		return serviceMetricMap;
//	}
//
//	public void setServiceMetricMap(Map<String, Map<String, String>> serviceMetricMap) {
//		this.serviceMetricMap = serviceMetricMap;
//	}

	@Override
	public String toString() {
		return "QueryResponse [target=" + target + ", organizationId=" + organizationId + ", spaceId=" + spaceId
				+ ", serviceName=" + serviceName + ", metricName=" + metricName + ", dataPoints="
				+ Arrays.toString(datapoints) + "]";
	}

	/*
	 * public QueryResponseModel() { serviceMetricMap = new HashMap<String,
	 * Map<String, String>>(); serviceMetricMap.put("iot-hub", new HashMap<String,
	 * String>()); serviceMetricMap.get("iot-hub").put("messages", "iothubmessage");
	 * 
	 * serviceMetricMap.put("mongodb", new HashMap<String, String>());
	 * serviceMetricMap.get("mongodb").put("storage", "mongostorage");
	 * serviceMetricMap.get("mongodb").put("calls", "mongocalls");
	 * 
	 * serviceMetricMap.put("postgresql", new HashMap<String, String>());
	 * serviceMetricMap.get("postgresql").put("storage", "pgstorage");
	 * serviceMetricMap.get("postgresql").put("calls", "pgcalls");
	 * 
	 * serviceMetricMap.put("space", new HashMap<String, String>());
	 * serviceMetricMap.get("space").put("cpu", "appspacecpu");
	 * serviceMetricMap.get("space").put("memory", "appspacememory");
	 * serviceMetricMap.get("space").put("disk", "appspacedisk");
	 * serviceMetricMap.get("space").put("memoryQuota", "appspacememoryquota");
	 * serviceMetricMap.get("space").put("diskQuota", "appspacediskquota");
	 * 
	 * }
	 */

	/*
	 * public String toJson() {
	 * 
	 * Gson gson = new Gson();
	 * 
	 * return gson.toJson(this); }
	 */

}
