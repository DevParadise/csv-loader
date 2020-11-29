package csvloader.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import csvloader.CsvLoaderConfig;
import csvloader.csv.CSVHelper;
import csvloader.dto.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CsvLoaderServiceImpl implements CsvLoaderService {

	final static String rootPath = System.getProperty("user.dir");
	
	@Autowired
	private CsvLoaderConfig csvLoaderConfig;

	@Override
	public void loader() {
		String filePath = rootPath + File.separator + csvLoaderConfig.getPath() 
							+ File.separator + csvLoaderConfig.getFile();
		if (File.separator.equals("\\")) {
			filePath = filePath.replace("/", File.separator);
		}
		else if (File.separator.equals("/")) {
			filePath = filePath.replace("\\", File.separator);
		}
		System.out.println(filePath);		
		log.info("filePath->{}", filePath);

		try {
			List<Book> books = CSVHelper.csvToBooks(filePath);
			for (Book book: books) {
				log.info(book.toString());
			}
		} catch (Exception e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}


	}

}
