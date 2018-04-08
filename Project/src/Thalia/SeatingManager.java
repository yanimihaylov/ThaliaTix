package Thalia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SeatingManager implements InterfaceSeating {
	
		private static List<Section> Sections = new ArrayList<Section>();
	
	   public Section createSections(String sct_name, int sID, int price) {
		   Section s= new Section(sct_name, sID, price);
		   Sections.add(s);
	       return(s);
	    }
	   
	   public List<Section> getAllSeats() {
	        return(Sections);
	    }

	public Seating createSeating(int r) {
		Seating s = new Seating(r);
		return s;
	}

	public Seat createSeats(int id, int seat) {
		Seat s = new Seat(id, seat);
		return s;
	}
	
	public Section getSectionDetail(int lid) {
        return(findById(lid));
	}
	
	private Section findById(int lid) {
        Iterator<Section> li = Sections.listIterator();
        
        while(li.hasNext()) {
        		
        		Section sec = li.next();
        
        		if(sec.matchesId(lid))
            		return(sec);

        }
        return(new NullSection());
    }
}