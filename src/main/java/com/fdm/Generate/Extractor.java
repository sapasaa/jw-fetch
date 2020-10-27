package com.fdm.Generate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Extractor {
	
	private HttpURLConnection connection;

	public InputStream getChapter(String stringURL) throws Exception {
    
		 InputStream stream = null;

		 try {
				URL url = new URL(stringURL);
				connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("User-Agent", "Mozilla/5.0");
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				
				int status = connection.getResponseCode();
				
				if(status !=200) {
					throw new Exception("server requested " + stringURL + "but returned invalid code of " + status);
				}
				
				stream = connection.getInputStream();
			
			 } catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		 
		return stream;
		 
		
	}

	
}
