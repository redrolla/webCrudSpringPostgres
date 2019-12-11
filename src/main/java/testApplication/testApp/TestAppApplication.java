package testApplication.testApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

@SpringBootApplication
public class TestAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}
}
