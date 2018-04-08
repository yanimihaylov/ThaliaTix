package Thalia;

import java.util.ArrayList;
import java.util.List;

public class subscribeDonations {
	
		private String did;
		private String wid;
		private int count;
		private String status;
		private List<String> tickets = new ArrayList<String>();
		private patron patron_info;
		
		public subscribeDonations(int wID, int c) {
			wid = Integer.toString(wID);
			count = c;

			this.did = Integer.toString(UniqueIdGenerator.getUniqueDonationID());
		}
		
		public subscribeDonations() {
			
		}
		
		public boolean isNil() {
	        return false;
	    }
		
		public boolean matchesId(int DID) {
			return(this.did.equals(Integer.toString(DID)));
		}
		
		public String getDid() {
			return did;
		}

		public void setDid(int DID) {
			this.did = Integer.toString(DID);
		}

		public String getWid() {
			return wid;
		}

		public void setWid(int WID) {
			this.wid = Integer.toString(WID);
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public List<String> getTickets() {
			return tickets;
		}

		public void setTickets(List<String> tickets) {
			this.tickets = tickets;
		}

		public patron getPatron_info() {
			return patron_info;
		}

		public void setPatron_info(patron patron_info) {
			this.patron_info = patron_info;
		}
		
		
}
