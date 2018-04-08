package Thalia;

import java.util.List;

public class requestResponse {
	
	private shows info;
	private int sid;
	private String setion_name;
	private int starting_seat_id;
	private String status;
	private int total_amount;
	private List<Seating> seating;
	
	
	public shows getInfo() {
		return info;
	}
	public void setInfo(shows info) {
		this.info = info;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSetion_name() {
		return setion_name;
	}
	public void setSetion_name(String setion_name) {
		this.setion_name = setion_name;
	}
	public int getStarting_seat_id() {
		return starting_seat_id;
	}
	public void setStarting_seat_id(int starting_seat_id) {
		this.starting_seat_id = starting_seat_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public List<Seating> getSeating() {
		return seating;
	}
	public void setSeating(List<Seating> seating) {
		this.seating = seating;
	}
	
	
	  	public boolean isNil() {
        return false;
    }
}
