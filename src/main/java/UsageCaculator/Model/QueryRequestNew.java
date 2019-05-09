package UsageCaculator.Model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
//@Component註解,只是要讓此類可被Controller注入
public class QueryRequestNew {
	int panelId;
	QueryRangType range;
	QueryRangRawType rangeRaw;
	String interval;
	long intervalMs;
	List<QueryTargetType> targets;
	String format;
	int maxDataPoints;
	QueryScopedVarsType scopedVars;
	public int getPanelId() {
		return panelId;
	}
	public void setPanelId(int panelId) {
		this.panelId = panelId;
	}
	public QueryRangType getRange() {
		return range;
	}
	public void setRange(QueryRangType range) {
		this.range = range;
	}
	public QueryRangRawType getRangeRaw() {
		return rangeRaw;
	}
	public void setRangeRaw(QueryRangRawType rangeRaw) {
		this.rangeRaw = rangeRaw;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public long getIntervalMs() {
		return intervalMs;
	}
	public void setIntervalMs(long intervalMs) {
		this.intervalMs = intervalMs;
	}
	public List<QueryTargetType> getTargets() {
		return targets;
	}
	public void setTargets(List<QueryTargetType> targets) {
		this.targets = targets;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getMaxDataPoints() {
		return maxDataPoints;
	}
	public void setMaxDataPoints(int maxDataPoints) {
		this.maxDataPoints = maxDataPoints;
	}
	public QueryScopedVarsType getScopedVars() {
		return scopedVars;
	}
	public void setScopedVars(QueryScopedVarsType scopedVars) {
		this.scopedVars = scopedVars;
	}
	
}
