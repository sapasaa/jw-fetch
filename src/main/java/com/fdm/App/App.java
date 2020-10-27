package com.fdm.App;



public class App {
	
	private Fetcher fet;
	private Parser pars;
	private Storer st;
	
	
	public App(Fetcher fet, Parser pars, Storer st) {
		super();
		this.fet = fet;
		this.pars = pars;
		this.st = st;
	}


	public void start() {
		System.out.println("App starting....");
		
	}
	
	

}
