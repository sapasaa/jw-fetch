package com.fdm.App;

public class AppMain {
	
	public static void main(String[] args) {
		App app = new App(new Fetcher(), new Parser(), new Storer());
		app.start();
	}

}
