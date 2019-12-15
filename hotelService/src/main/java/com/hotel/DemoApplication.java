package com.hotel;

import com.hotel.model.Hotel;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	HotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {

		File newFile = new File("src/main/resources/singapore.xlsx");
		Map<String, String> mapping = new
				HashMap<String, String>();
		mapping.put("name", "name");
		mapping.put("host_name", "host_name");
		mapping.put("neighbourhood_group", "neighbourhood_group");
		mapping.put("neighbourhood", "neighbourhood");
		mapping.put("latitude", "latitude");
		mapping.put("longitude", "longitude");
		mapping.put("room_type", "room_type");
		mapping.put("price", "price");

		HeaderColumnNameTranslateMappingStrategy<Hotel> strategy =
				new HeaderColumnNameTranslateMappingStrategy<Hotel>();
		strategy.setType(Hotel.class);
		strategy.setColumnMapping(mapping);
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader
					("src/main/resources/data.csv"));
		}
		catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<Hotel> list = csvToBean.parse(strategy, csvReader);
		for (Hotel e : list) {
			hotelRepository.save(e);
		}
	}
}
