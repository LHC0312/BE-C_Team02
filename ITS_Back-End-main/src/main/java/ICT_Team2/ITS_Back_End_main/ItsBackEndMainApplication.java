package ICT_Team2.ITS_Back_End_main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ItsBackEndMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsBackEndMainApplication.class, args);
	}

}
