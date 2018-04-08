package Thalia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class subManager implements interfaceSub{
	private int location;
	
	private InterfaceTicket itic = new ticketManager();
	private static List<ticket> tics = new ArrayList<ticket>();
	private static List<subscribeDonations> subs = new ArrayList<subscribeDonations>();
	
	public subscribeDonations createSub(int wid, int c) {
		subscribeDonations s = new subscribeDonations(wid, c);
		subs.add(s);
		return s;
	}
	
	public subscribeDonations getSubDetail(int did) {
		return(findById(did));
	}
	
	public subscribeDonations getSpecificSub(int wid, int did) {
		subscribeDonations sh = getSubDetail(did);
				if(sh.getDid().equals(Integer.toString(did))) {
					return sh;
    				}
			return(new nullSub());
	}
 
    private subscribeDonations findById(int did) {
    	location = 0;
        Iterator<subscribeDonations> li = subs.listIterator();
        
        while(li.hasNext()) {
        		
        	subscribeDonations s = li.next();
        
        		if(s.matchesId(did))
            		return(s);
        		
        		location++;
        }
        return(new nullSub());
    }
    
    public subscribeDonations checkStatus (subscribeDonations sd) {
    		tics = itic.getAllTickets();
    		if(sd.getTickets().size()==sd.getCount()) {
    			return sd;
    		}
    		
    		for(int i=0; i<tics.size(); i++) {
    			if(tics.get(i).getStatus().equals("donating") && (sd.getTickets().size()<sd.getCount())) {
    				sd.getTickets().add(tics.get(i).getTid());
    				tics.get(i).setStatus("donated");
    			}
    		}
    		return sd;

    }
}
