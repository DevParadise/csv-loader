package csvloader.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import csvloader.dto.Book;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CSVHelper {
	public static List<Book> csvToBooks(String filePath) {
		File file = new File(filePath);
		try (
				InputStream is = new FileInputStream(file);
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			) {
			List<Book> books = new ArrayList<Book>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for (CSVRecord csvRecord : csvRecords) {
				Book book = Book.builder()
						.title(csvRecord.get("Title"))
						.author(csvRecord.get("Author"))
						.genre(csvRecord.get("Genre"))
						.build();
				books.add(book);
			}
			
			return books;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}