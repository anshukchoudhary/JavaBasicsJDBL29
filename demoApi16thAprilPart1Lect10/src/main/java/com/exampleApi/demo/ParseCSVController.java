package com.exampleApi.demo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParseCSVController {

	// make an api to parse a CSV controller
	// parse the file and extract the content
	// create person object and return the list of persons
	//http://localhost:8080/file/parsing
	@PostMapping("/file/parsing")
	public List<Person> parseBulkFile(HttpServletRequest hsr) throws IOException, ServletException {

		// here we will receive the files

		Part p1 = hsr.getPart("part1");
		Part p2 = hsr.getPart("part2");

		System.out.println("value of part1 ---- " + p1);
		System.out.println("value of part12 ---- " + p2);

		CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
		CSVParser csvParser = new CSVParser(new InputStreamReader(p1.getInputStream()), csvFormat);

		List<Person> personList = new ArrayList<>();

		List<CSVRecord> records = csvParser.getRecords();

		for (CSVRecord record : records) {
			if (record.getRecordNumber() == 1) {
				continue;
			}
			int id = Integer.parseInt(record.get(0));
			String firstName = record.get(1);
			String lastName = record.get(2);
			int age = Integer.parseInt(record.get(3));
			String dob = record.get(4);

			personList.add(new Person(id, firstName, lastName, age, dob));

		}

		return personList;

	}

}
