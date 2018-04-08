package Thalia;

import java.util.ArrayList;
import java.util.List;

public class shows {
	
	private String wid;
	
	private String name;
	private String web;
	private String date;
	private String time;
	
	private showInfo show_info;
	private List<Section> seating_info = new ArrayList<Section>();
	
	public shows() {
		
	}
	
	public shows(String name, String web, String date, String time) {
		show_info = new showInfo(name, web, date, time);
		
		int widInt = UniqueIdGenerator.getUniqueShowID();
		wid = Integer.toString(widInt);
	}
	
	
	public showInfo getShowInfo() {
		return show_info;
	}
	
	
	public void setShowInfo(showInfo showInfo) {
		this.show_info = showInfo;
	}

	public String getID() {
		return this.wid;
	}
	
	public boolean matchesId(int wID) {
		String widString = Integer.toString(wID);
		return(widString.equalsIgnoreCase(this.wid));
	}
	
	public boolean isNil() {
        return false;
    }

	public String getName() {
		return name;
	}

	public String getWeb() {
		return web;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}
	
	public List<Section> getSections(){
		return seating_info;
	}

	public void setSections(List<Section> sections) {
		this.seating_info = sections;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}
	
	public void add(int loc, Section sec) {
		seating_info.add(loc, sec);
	}
	
	public void set(int loc, Section sec) {
		seating_info.set(loc, sec);
	}

}
