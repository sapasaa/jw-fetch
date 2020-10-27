package com.fdm.Generate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FetchUrlsApp {
	
	private final static String BASEURL = "https://www.jw.org/en/library/bible/study-bible/books/json/data/";
	private Extractor ext;
	private int param1;
	private int param2;
	
	 
	
	public FetchUrlsApp(Extractor ext, int param1, int param2) {
		super();
		this.ext = ext;
		this.param1 = param1;
		this.param2 = param2;
	}

	public void start() {
		ArrayList <String> validURLs = new ArrayList<String>();
		
		

		while(true) {
			
			try {
				String nextStringURL = getNext();
				InputStream response = ext.getChapter(nextStringURL);
				
				if(response != null) {
					validURLs.add(nextStringURL);
					System.out.println(validURLs.size() + ": " + nextStringURL);

				}
				
			} catch (Exception e) {
				updateParams();
			}
			
			if(this.getParam1()>=67000000) {
				break;
			}
			
		}
		
		
		storeURLs(validURLs);
		
		
	}
	
	private void storeURLs(ArrayList<String> validURLs) {

		try {
		    String fileName="jw-api.txt";
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter(fileName));
			
			for (String string : validURLs) {
			    writer.write(string);
			    writer.newLine();
			}
		    writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private void updateParams() {
	
		// round to the nearest million
		param1 = (int) (Math.ceil(param1/1000000.00)*1000000);
		param2 = param1 + 999;
		
		
	}

	private String getNext() {
		param1 = param1 + 1000;
		param2 = param2 + 1000;
		return BASEURL + param1 + "-" + param2;
	}

	public int getParam1() {
		return param1;
	}

	public int getParam2() {
		return param2;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}

	public void setParam2(int param2) {
		this.param2 = param2;
	}
	
	


}
