package csvloader;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "csv-loader")
@Getter
@Setter
public class CsvLoaderConfig {

	private String path;
	private String file;
}
