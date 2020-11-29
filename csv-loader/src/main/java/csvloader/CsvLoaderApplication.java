package csvloader;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import csvloader.service.CsvLoaderService;
import csvloader.service.CsvLoaderServiceImpl;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CsvLoaderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		//System.out.println(new File(".").getAbsolutePath());
		SpringApplication.run(CsvLoaderApplication.class, args);
	}
	
	@Bean
	public CsvLoaderService getCsvLoaderService() {
		return new CsvLoaderServiceImpl();
	}

	@Override
	public void run(String... args) throws Exception {
		getCsvLoaderService().loader();		
	}

}
