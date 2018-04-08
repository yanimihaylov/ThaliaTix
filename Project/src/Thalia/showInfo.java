package Thalia;

public class showInfo {
	
	private String name;
	private String web;
	private String date;
	private String time;
	
	
	public showInfo(String name, String web, String date, String time) {
		this.name = name;
		this.web = web;
		this.date = date;
		this.time = time;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	

}
