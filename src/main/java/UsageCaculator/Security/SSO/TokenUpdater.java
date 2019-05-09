package UsageCaculator.Security.SSO;
//package SSO;
//
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.util.Collections;
//
//import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
//import org.apache.http.conn.ssl.SSLContextBuilder;
//import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.web.client.RestTemplate;
//
//import com.google.gson.Gson;
//
//import SSOData.SSOAuthResponse;
//
//@SpringBootApplication
//@EnableScheduling
//public class TokenUpdater {
//	static String token;
//	static Gson gson = new Gson();
//	@Value("${ssouri}")
//	private static String ssoURI;// = "https://portal-sso-develop.wise-paas.com/v1.3";
//	@Value("${ssoaccount}")
//	private static String ssoAccount;
//	@Value("${ssopassword}")
//	private static String ssoPassword;
//
//	@Scheduled(cron = "${token.cron.expression}")
//	static void update() {
//		System.out.println(ssoURI);
//		try {
//			String body = "{\"username\":\"" + ssoAccount + "\",\"password\":\"" + ssoPassword + "\"}";
//			final HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//			SSLContextBuilder builder = new SSLContextBuilder();
//
//			builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
//
//			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());
//			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
//			requestFactory.setHttpClient(httpclient);
//			RestTemplate restTemplate = new RestTemplate(requestFactory);
//			HttpHeaders headers = new HttpHeaders();
//			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//			HttpEntity<String> entity = new HttpEntity<String>(body, headers);
//			ResponseEntity<String> response = restTemplate.exchange(ssoURI + "/auth/native", HttpMethod.POST, entity,
//					String.class);
//			if (response.getStatusCode() == HttpStatus.OK) {
//				SSOAuthResponse ssoAuthResponse = gson.fromJson(response.getBody(), SSOAuthResponse.class);
//				token = ssoAuthResponse.getAccessToken();
//
//				// System.out.println("token" + token);
//			} else {
//				System.out.println("Get Token fail, status code = " + response.getStatusCode());
//			}
//		} catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	static String getToken() {
//		return token;
//	}
//}
