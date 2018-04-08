package Thalia;

public class ticket {
	
	private String tid;
	private int price;
	private String status;
	private String wid;
	private showInfo showInfo;
	private patron patronInfo;
	private String sid;
	private String section_name;
	private Seating seating;
	private String row;
	private String cid;
	
	public ticket() {
		
	}
	
	public ticket(int pr, int wID, int sID, String section_n) {
		price = pr;
		wid = Integer.toString(wID);
		sid = Integer.toString(sID);
		section_name = section_n;
		status = "open";
		
		this.tid = Integer.toString(UniqueIdGenerator.getUniqueTicketID());
	}
	
	
	public boolean isNil() {
        return false;
    }
	
	public boolean matchesId(int TID) {
		return(Integer.toString(TID).equals( this.tid));
	}

	public String getRow() {
		return row;
	}

	public void setRow(int ROW) {
		this.row = Integer.toString(ROW);
	}

	public String getCid() {
		return cid;
	}

	public void setCid(int CID) {
		this.cid = Integer.toString(CID);
	}

	public String getTid() {
		return tid;
	}

	public void setTid(int TID) {
		this.tid = Integer.toString(TID);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(int WID) {
		this.wid = Integer.toString(WID);
	}

	public showInfo getShowInfo() {
		return showInfo;
	}

	public void setShowInfo(showInfo showInfo) {
		this.showInfo = showInfo;
	}

	public patron getPatronInfo() {
		return patronInfo;
	}

	public void setPatronInfo(patron patronInfo) {
		this.patronInfo = patronInfo;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(int SID) {
		this.sid = Integer.toString(SID);
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public Seating getSeating() {
		return seating;
	}

	public void setSeating(Seating seating) {
		this.seating = seating;
	}
}
