package Thalia;

import java.util.List;

public interface InterfaceSeating {
	
	List<Section> getAllSeats();
	Section createSections(String sct_name, int sID, int price);
	
	Seating createSeating(int r);
	
	Seat createSeats(int id, int seat);
	
	Section getSectionDetail(int id);

}
