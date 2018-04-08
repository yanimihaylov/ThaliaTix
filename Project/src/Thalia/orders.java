package Thalia;

import java.util.Date;
import java.util.List;

public class orders {
	
	private String oid;
	
	private String wid;
	private String sid;
	private showInfo showInfo;
	Date dateOrdered;
	private int orderAmount;
	private int numberOfTickets;
	private List<Seating> seats;
	private patron pat;   
	private List<ticket> tickets;

	public orders() {
		
	}
	
	public orders(int wID, int sID, String name, String phone, String email, String b_a, String cc_n, String cc_exp_d) {
		pat = new patron(name, phone, email, b_a, cc_n, cc_exp_d);
		sid = Integer.toString(sID);
		wid = Integer.toString(wID);
		
		dateOrdered = new Date();
		this.oid = Integer.toString(UniqueIdGenerator.getUniqueOrderID());
		
	}
	
	public List<ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<ticket> tickets) {
		this.tickets = tickets;
	}

	public boolean isNil() {
        return false;
    }
	
	public boolean matchesId(int OID) {
		return(this.oid.equals(Integer.toString(OID)));
	}
	
	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public showInfo getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(showInfo showInfo) {
		this.showInfo = showInfo;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(int WID) {
		this.wid = Integer.toString(WID);
	}

	public String getSid() {
		return sid;
	}

	public showInfo getShowI() {
		return showInfo;
	}

	public void setShowI(showInfo showI) {
		this.showInfo = showI;
	}

	public void setSid(int SID) {
		this.sid = Integer.toString(SID);
	}

	public List<Seating> getSeats() {
		return seats;
	}

	public void setSeats(List<Seating> seats) {
		this.seats = seats;
	}

	public patron getPat() {
		return pat;
	}

	public void setPat(patron pat) {
		this.pat = pat;
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(int OID) {
		this.oid = Integer.toString(OID);
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTix) {
		this.numberOfTickets = numberOfTix;
	}

}
