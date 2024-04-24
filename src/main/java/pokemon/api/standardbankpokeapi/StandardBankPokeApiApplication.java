package pokemon.api.standardbankpokeapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pokemon.api.standardbankpokeapi.entities.PokemonApiUser;
import pokemon.api.standardbankpokeapi.entities.Role;
import pokemon.api.standardbankpokeapi.services.PokemonUserService;

@SpringBootApplication
public class StandardBankPokeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardBankPokeApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ModelMapper getModelMapper() {
		var mapper = new ModelMapper();
		mapper.getConfiguration().setSkipNullEnabled(true);
		return mapper;
	}

	@Bean
	CommandLineRunner run(PokemonUserService pokemonUserService) {
		return args -> {  // inserting data after application is up
			pokemonUserService.save(new PokemonApiUser("James Kirk", "james@enterprise.com", "123456", Role.ADMIN));
			pokemonUserService.save(new PokemonApiUser("Spock", "spock@enterprise.com", "123456", Role.ADMIN));
			pokemonUserService.save(new PokemonApiUser("Leonard McCoy", "mccoy@enterprise.com", "123456", Role.USER));
			pokemonUserService.save(new PokemonApiUser("Montgomery Scott", "scott@enterprise.com", "123456", Role.USER));
		};
	}
}
