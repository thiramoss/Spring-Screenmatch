package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSeries;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=10e073f4");
		System.out.println(json);
		ConverterDados conversor = new ConverterDados();

		DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
		System.out.println(dados);
	}
}
