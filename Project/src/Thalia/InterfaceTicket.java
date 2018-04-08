package Thalia;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceTicket {

	ticket createTicket(int price, int wid, int sid, String section_n);
	List<ticket> getAllTickets();
	ticket getTicketDetail(int tid);
	void donateTicket(ArrayList<Integer> tic);
}
