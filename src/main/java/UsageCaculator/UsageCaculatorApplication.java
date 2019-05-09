package UsageCaculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UsageCaculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsageCaculatorApplication.class, args);
	}

}
