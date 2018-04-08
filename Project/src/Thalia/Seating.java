package Thalia;

import java.util.ArrayList;
import java.util.List;

public class Seating{
		
		String row;
		public List<Seat> seats = new ArrayList<Seat>();
		
	public Seating(int r) {
		row = Integer.toString(r);
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getRow() {
		return row;
	}

	public void setRow(int ROW) {
		
		this.row = Integer.toString(ROW);
	}
	

}
