/**
 * 
 */
package com.assignment3.searchlog.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment3.searchlog.entities.KeyWord;
import com.opencsv.CSVWriter;

/**
 * @author Sai Pavan
 *
 */
@Service("SearchLogServices")
public class SearchLogServices {

	@Autowired
	private static List<KeyWord> searchLogs = new ArrayList<KeyWord>();

	/**
	 * 
	 */
	public SearchLogServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void saveOrUpdateSearchLog(String keyword) {
		
		
		if (searchLogs.isEmpty()) {
			System.out.println("here");
			ArrayList<Date> dates = new ArrayList<Date>();
			dates.add(new Date());
			KeyWord newKeyword = new KeyWord(keyword.toUpperCase(), dates, 1);
			searchLogs.add(newKeyword);
		} else {
			if (searchLogs.contains(new KeyWord(keyword))) {
				System.out.println("here1");
				int i = searchLogs.indexOf(new KeyWord(keyword));
				KeyWord existing = searchLogs.get(i);
				Date d = new Date();
				existing.getSearchTimeList().add(d);
				existing.setFrequency((existing.getFrequency() + 1));

			} else {
				ArrayList<Date> dates = new ArrayList<Date>();
				dates.add(new Date());
				KeyWord newKeyword = new KeyWord(keyword.toUpperCase(), dates, 1);
				searchLogs.add(newKeyword);
			}
		}
		writeLogstoCsv();

	}

	public void writeLogstoCsv() {
		File file = new File("searchlog.csv");
		if (file.exists())
			file.delete();
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file, false);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = { "KeyWord", "Frequency", "Times Of Request" };
			writer.writeNext(header);
			System.out.println(searchLogs.toString());
			Iterator<KeyWord> itr = searchLogs.iterator();

			// add data to csv - Writing data utilization record in .csv file
			while (itr.hasNext()) {
				KeyWord key = itr.next();
				String keywordName = key.getKeyword();
				List<Date> dates = key.getSearchTimeList();
				int frequency = key.getFrequency();
				String stringofDates = "";
				for (Date d : dates) {
					stringofDates = stringofDates.concat(d.toString()).concat(",");
				}
				stringofDates = stringofDates.substring(0, stringofDates.lastIndexOf(",") - 1);
				System.out.println(stringofDates);
				String[] data1 = { keywordName,Integer.toString(frequency), stringofDates,  };
				writer.writeNext(data1);
			}
			// closing writer connection
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
