package com.fdm.Generate;

public class FetchUrlAppMain {
	
	public static void main(String[] args) {
		FetchUrlsApp fetch = new FetchUrlsApp(new Extractor());
		fetch.start();
	}

}
