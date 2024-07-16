package cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02")
@EnableJpaRepositories("cat.itacademy.barcelonactiva.torres.eugenia.s05.t01.n02.S05T01N02TorresEugenia.model.repository")
public class S05T01N02TorresEugeniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N02TorresEugeniaApplication.class, args);
	}
}
