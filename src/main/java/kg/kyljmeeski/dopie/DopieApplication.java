package kg.kyljmeeski.dopie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// token = f4afb5cbba6e4ffeb2c3d8541f14c482
// https://api.football-data.org/v4/competitions/PL/matches?status=TIMED

@SpringBootApplication
public class DopieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DopieApplication.class, args);
	}

}
