package UsageCaculator.Model;

public class QueryRangType {
	String from;
	String to;
	QueryRawType raw;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public QueryRawType getRaw() {
		return raw;
	}
	public void setRaw(QueryRawType raw) {
		this.raw = raw;
	}
}
