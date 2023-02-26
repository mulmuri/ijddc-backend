package uos.urbanscience.ijddc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class IjddcApplication {

	public static void main(String[] args) {
		SpringApplication.run(IjddcApplication.class, args);
	}

}
