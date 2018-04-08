package Thalia;

public class initTheater {
	
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
	Section initSection;
	Seating initSeating;
	Seat initSeat;
	int cid;
	public void create() {
		
		initSection = initFrontRight();
		initSection = initFrontCenter();
		initSection = initFrontLeft();
		initSection = initMainRight();
		initSection = initMainCenter();
		initSection = initMainLeft();

	}
	
	public Section initFrontRight() {
		//Front Right
				initSection = iseat.createSections("Front right", 123, 0);
				for(int row = 1; row<=4; row++) {
					initSeating = iseat.createSeating(row);
					
					cid=0;
					if(row==1)
						cid+=200;
					if(row==2)
						cid+=212;
					if(row==3)
						cid+=224;
					if(row==4)
						cid+=237;
					
					for(int seat = 1; seat<=4; seat++) {

						initSeat = iseat.createSeats(cid+seat, seat);
						initSeating.seats.add(initSeat);
					}
					initSection.seating.add(initSeating);
				}
		return initSection;

	}
	
	public Section initFrontCenter() {
		//Front Center
				initSection = iseat.createSections("Front center", 124, 0);
				for(int row = 1; row<=2; row++) {
					initSeating = iseat.createSeating(row);
					
					cid=0;
					if(row==1)
						cid+=204;
					if(row==2)
						cid+=216;

					
					for(int seat = 5; seat<=8; seat++) {
						initSeat = iseat.createSeats(cid+seat-4, seat);
						initSeating.seats.add(initSeat);
					}
					initSection.seating.add(initSeating);
				}
				
				initSeating = iseat.createSeating(3);
					cid=0;
					cid+=228;
				for(int seat = 5; seat<=9; seat++) {
					initSeat = iseat.createSeats(cid+seat-4, seat);
					initSeating.seats.add(initSeat);
				}
				initSection.seating.add(initSeating);
				
				initSeating = iseat.createSeating(4);
					cid=0;
					cid+=241;
				for(int seat = 5; seat<=10; seat++) {
					initSeat = iseat.createSeats(cid+seat-4, seat);
					initSeating.seats.add(initSeat);
				}
				initSection.seating.add(initSeating);
				
				return initSection;

	}
	
	public Section initFrontLeft() {
		//Front Left
				initSection = iseat.createSections("Front left", 125, 0);
				for(int row = 1; row<=4; row++) {
					initSeating = iseat.createSeating(row);
					
					cid=0;
					if(row==1)
						cid+=208;
					if(row==2)
						cid+=220;
					if(row==3)
						cid+=233;
					if(row==4)
						cid+=247;
					
					for(int seat = 1; seat<=4; seat++) {
						initSeat = iseat.createSeats(cid+seat, seat);
						initSeating.seats.add(initSeat);
					}
					initSection.seating.add(initSeating);
				}
				return initSection;

	}
	
	public Section initMainRight() {
		//Main Right
		initSection = iseat.createSections("Main right", 126, 0);
		for(int row = 5; row<=7; row++) {
			initSeating = iseat.createSeating(row);
			
			cid=0;
			if(row==5)
				cid+=251;
			if(row==6)
				cid+=267;
			if(row==7)
				cid+=284;
					
			for(int seat = 1; seat<=5; seat++) {
				initSeat = iseat.createSeats(cid+seat, seat);
				initSeating.seats.add(initSeat);
			}
			initSection.seating.add(initSeating);
		}
		return initSection;

	}
	
	public Section initMainCenter() {
		//Main Center
		initSection = iseat.createSections("Main center", 127, 0);
		
		initSeating = iseat.createSeating(5);
		for(int seat = 6; seat<=11; seat++) {
			cid=0;
			cid+=256;
			initSeat = iseat.createSeats(cid+seat-5, seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(6);
		for(int seat = 6; seat<=12; seat++) {
			cid=0;
			cid+=272;
			initSeat = iseat.createSeats(cid+seat-5, seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(7);
		for(int seat = 6; seat<=13; seat++) {
			cid=0;
			cid+=289;
			initSeat = iseat.createSeats(cid+seat-5, seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		return initSection;

	}
	
	public Section initMainLeft() {
		//Main Left
		initSection = iseat.createSections("Main left", 128, 0);
		
		initSeating = iseat.createSeating(5);
		for(int seat = 12; seat<=16; seat++) {
			cid=0;
			cid+=262;
			initSeat = iseat.createSeats(cid+seat-11, seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(6);
		for(int seat = 13; seat<=17; seat++) {
			cid=0;
			cid+=279;
			initSeat = iseat.createSeats(cid+seat-12, seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
		
		initSeating = iseat.createSeating(7);
		for(int seat = 14; seat<=18; seat++) {
			cid=0;
			cid+=297;
			initSeat = iseat.createSeats(cid+seat-13, seat);
			initSeating.seats.add(initSeat);
		}
		initSection.seating.add(initSeating);
				
		return initSection;

	}
	
	
}
