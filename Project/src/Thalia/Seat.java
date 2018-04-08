package Thalia;

public class Seat{
		
		String cid;
		String seat;
		String status;
		
	public Seat(int id, int s) {
		seat = Integer.toString(s);
		status = "available";
		cid=Integer.toString(id);

	}
	
	public String getStatus() {
		return status;
	}
	
	public String getCid() {
		return cid;
	}
	
	public String getSeat() {
		return seat;
	}

	public void setCid(int CID) {
		this.cid = Integer.toString(CID);
	}

	public void setSeat(int SEAT) {
		this.seat = Integer.toString(SEAT);
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

