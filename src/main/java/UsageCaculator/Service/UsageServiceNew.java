//package UsageCaculator.Service;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonIOException;
//import com.google.gson.JsonSyntaxException;
//
//import UsageCaculator.Model.QueryRequest;
//import UsageCaculator.Model.QueryResponse;
//import UsageCaculator.Model.QueryTargetType;
//
////query():根據傳入的targettype來查詢指定東西
//@Service
//public class UsageServiceNew {
//	@Autowired
//	DailyUsageNew dailyUsageServiceNew;
//	@Autowired
//	MonthlyUsage monthlyUsageService;
//	@Autowired
//	RealTimeUsage realTimeUsage;
//	@Autowired
//	DaySeriesUsage daySeriesUsage;
//	@Autowired
//	MonthSeriesUsage monthSeriesUsage;
//	@Autowired
//	DayTrendUsage dayTrendUsage;
//	@Autowired
//	MonthTrendUsage monthTrendUsage;
//	@Autowired
//	RealTimeSeriesUsage realTimeSeriesUsage;
//	@Autowired
//	RealTimeTrendUsage realTimeTrendUsage;
//	@Autowired
//	WeeklyTrendUsage weeklyTrendUsage;
//	@Autowired
//	WeeklyUsage weeklyUsage;
//
//	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
//		//測試
//		
////		UsageServiceNew o=new UsageServiceNew();
////		long a=o.getStartTime("2019-01-14T16:00:00.000Z");
////		long b=o.getEndTime("2019-01-16T16:00:00.000Z");
////		System.out.println(a);
////		System.out.println(b);
////		
////		Gson gson = new Gson();
////		// 1. JSON file to Java object
////		QueryRequest queryRequest = gson.fromJson(new FileReader("C:\\requestJson.txt"), QueryRequest.class);
////		UsageServiceNew service = new UsageServiceNew();
////		QueryResponse[] ob = service.queryNew(queryRequest);
//
////		List<String> ssoOrgs = SSOTokenUtil.getOrgs("eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJhbGktd2lzZXBhYXMiLCJpYXQiOjE1NTYxODE0NjIsImV4cCI6MTU1NjE4NTA2MiwidXNlcklkIjoiM2MzZjZiODEtODhlMy00ZTBiLTgxMDAtNjA2YmYxNmZkZDZjIiwidWFhSWQiOiI3MzkwMzEwYS05NDcwLTQ0ZGMtODNjYS05NDkyMmE1ZDliYzEiLCJjcmVhdGlvblRpbWUiOjE1NTU0OTE3NjYwMDAsImxhc3RNb2RpZmllZFRpbWUiOjE1NTYxNTcxNzIwMDAsInVzZXJuYW1lIjoiQ2hpZW5Ic2lhbmcuQ2hlbkBhZHZhbnRlY2guY29tLnR3IiwiZmlyc3ROYW1lIjoiQ2hpZW5Ic2lhbmciLCJsYXN0TmFtZSI6IkNoZW4iLCJjb3VudHJ5IjoiVFciLCJyb2xlIjoiYWRtaW4iLCJncm91cHMiOlsiY2luZHljeXdhbmdAaWlpLm9yZy50dyJdLCJjZlNjb3BlcyI6W3siZ3VpZCI6bnVsbCwic3NvX3JvbGUiOiJhZG1pbiIsInNwYWNlcyI6W119XSwic2NvcGVzIjpbXSwic3RhdHVzIjoiYWN0aXZlIiwib3JpZ2luIjoiU1NPIiwib3ZlclBhZGRpbmciOmZhbHNlLCJzeXN0ZW0iOmZhbHNlLCJyZWZyZXNoVG9rZW4iOiJmMGVhNTA5MC03MmM3LTRhZTQtODk4NC0wZjA5NDU0NTI5NjAifQ.Mh7jfhjoeqqOllOlQfZcVprE77QgAYUBblOcRdGXosiofGebJVd36pj7ZMlnE2TTLv3tsyE6nT51lmj_1d9Txw");		
////
////		UsageServiceNew o=new UsageServiceNew();
////		StringTokenizer orgsSt = new StringTokenizer("df3bd89b-455b-46ee-b908-6eb8c17b8a5c");
////		// StringTokennizer 设置不同分隔符来分隔字符串，默认的分隔符是：空格、制表符（\t）、换行符(\n）、回车符（\r）。 類似split()
////		while (orgsSt.hasMoreElements()) {
////			System.out.println("---");
////			
////			String orgToken = orgsSt.nextToken();
////			System.out.println(orgsSt);
////			System.out.println(ssoOrgs);
////		}
//	}
//
//	public QueryResponse[] queryNew(QueryRequest queryRequest) {
//
//		List<QueryResponse> queryResponseList = new ArrayList<QueryResponse>();
//
//		// 可能有多個target
//		for (QueryTargetType target : queryRequest.getTargets()) {			
//			try {
//			String type = target.getIntervalType().toString();						
//			long startTime = getStartTime(queryRequest.getRange().getFrom());			
//			long endTime = getStartTime(queryRequest.getRange().getTo());	
//			System.out.println("type "+type);
//			System.out.println("startTime "+startTime);
//			System.out.println("endTime "+endTime);
//
//			QueryResponse queryResponse = new QueryResponse();
//			//RealTime->use redis DB
//			if (type == "RealTime") {					
//				queryResponse=(dailyUsageServiceNew.queryDailyUsage(target, startTime, endTime));// 回傳一個QueryReponse格式 //Long dataPoints				
//			}
//			if (type == "Day") {				
//				queryResponse=(dailyUsageServiceNew.queryDailyUsage(target, startTime, endTime));// 回傳一個QueryReponse格式 //Long dataPoints
//			}			
//			queryResponseList.add(queryResponse);//addAll("List")
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();				
//			}
//		}
//		return queryResponseToArray(queryResponseList);//list to array
//	}
//
//	static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//	long getStartTime(String from) {
//		ZoneId utcZone = ZoneId.of("UTC");
//
//		ZonedDateTime zonedDateTimeFrom = LocalDateTime.parse(from, formatter).atZone(utcZone);
//		return zonedDateTimeFrom.toEpochSecond() * 1000;
//	}
//	long getEndTime(String end) {
//		ZoneId utcZone = ZoneId.of("UTC");
//
//		ZonedDateTime zonedDateTimeFrom = LocalDateTime.parse(end, formatter).atZone(utcZone);
//		return zonedDateTimeFrom.toEpochSecond() * 1000;
//	}
//
//	private QueryResponse[] queryResponseToArray(List<QueryResponse> queryResponsesList) {
//		QueryResponse[] queryResponses = new QueryResponse[queryResponsesList.size()];
//
//		for (int i = 0; i < queryResponsesList.size(); i++) {
//			queryResponses[i] = queryResponsesList.get(i);
//		}
//
//		return queryResponses;
//	}
//
//}
