package Thalia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class testCases {
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
	private interfaceOrders iord = new orderManager();
	private InterfaceTicket itic = new ticketManager();
	private interfaceSub isub = new subManager();
	private requestShows rs = new requestShows();
	private Section sec;
	private initTheater it = new initTheater();
	private 
	int createdShowObjects=0;
	int price=0;


    @Before
    public void setUp() throws Exception {	
		
		Section sec1 = iseat.createSections("Front Right", 123, 250);
		price = sec1.getPrice();
		sec1 = it.initFrontRight();
		sec1.setPrice(price);
		
		Section sec2 = iseat.createSections("Front Center", 124, 350);
		price = sec2.getPrice();
		sec2 = it.initFrontCenter();
		sec2.setPrice(price);
		
		Section sec3 = iseat.createSections("Front Left", 125, 350);
		price = sec3.getPrice();
		sec3 = it.initFrontLeft();
		sec3.setPrice(price);
		
		Section sec4 = iseat.createSections("Main Right", 126, 350);
		Section sec5 = iseat.createSections("Main Center", 127, 350);
		Section sec6 = iseat.createSections("Main Left", 128, 350);
		
		shows sh1 = is.createShow("name", "web", "date", "time");
		sh1.add(0, sec1);
		createdShowObjects++;
		shows sh2 = is.createShow("name", "web", "date", "time");
		sh2.add(0, sec1);
		sh2.add(1, sec2);
		createdShowObjects++;
		shows sh3 = is.createShow("name", "web", "date", "time");
		sh3.add(0, sec1);
		sh3.add(1, sec2);
		sh3.add(2, sec3);
		createdShowObjects++;	
		
		orders ord = iord.createOrder(1, 123, "name", "phone", "email", "b_a", "cc_n", "cc_exp_d");
		orders ord1 = iord.createOrder(1, 124, "name", "phone", "email", "b_a", "cc_n", "cc_exp_d");
		
		ticket tic = itic.createTicket(65, 1, 123, "Front Right");
		ticket tic1 = itic.createTicket(90, 2, 125, "Front Left");

    }
    
    
    @Test
    public void test_initTheater() {

		Section sec1 = iseat.createSections("Front Right", 123, 250);
		Section sec2 = iseat.createSections("Front Center", 124, 350);
		Section sec3 = iseat.createSections("Front Left", 125, 350);
		Section sec4 = iseat.createSections("Main Right", 126, 350);
		Section sec5 = iseat.createSections("Main Center", 127, 350);
		Section sec6 = iseat.createSections("Main Left", 128, 350);
		it.create();
		
    		sec1 = it.initFrontRight();
    		assertTrue(sec1.getSeating().get(0).getSeats().get(0).getCid().equals("201"));
    		assertTrue(sec1.getSeating().get(1).getSeats().get(0).getCid().equals("213"));
    		assertTrue(sec1.getSeating().get(2).getSeats().get(0).getCid().equals("225"));
    		assertTrue(sec1.getSeating().get(3).getSeats().get(0).getCid().equals("238"));

    		sec2 = it.initFrontCenter();
    		assertTrue(sec2.getSeating().get(0).getSeats().get(0).getCid().equals("205"));
    		assertTrue(sec2.getSeating().get(1).getSeats().get(0).getCid().equals("217"));
    		assertTrue(sec2.getSeating().get(2).getSeats().get(0).getCid().equals("229"));
    		assertTrue(sec2.getSeating().get(3).getSeats().get(0).getCid().equals("242"));
    		
    		sec3 = it.initFrontLeft();
    		assertTrue(sec3.getSeating().get(0).getSeats().get(0).getCid().equals("209"));
    		assertTrue(sec3.getSeating().get(1).getSeats().get(0).getCid().equals("221"));
    		assertTrue(sec3.getSeating().get(2).getSeats().get(0).getCid().equals("234"));
    		assertTrue(sec3.getSeating().get(3).getSeats().get(0).getCid().equals("248"));

    		
    		sec4 = it.initMainRight();
    		assertTrue(sec4.getSeating().get(0).getSeats().get(0).getCid().equals("252"));
    		assertTrue(sec4.getSeating().get(1).getSeats().get(0).getCid().equals("268"));
    		assertTrue(sec4.getSeating().get(2).getSeats().get(0).getCid().equals("285"));

    		
    		sec5 = it.initMainCenter();
    		assertTrue(sec5.getSeating().get(0).getSeats().get(0).getCid().equals("257"));
    		assertTrue(sec5.getSeating().get(1).getSeats().get(0).getCid().equals("273"));
    		assertTrue(sec5.getSeating().get(2).getSeats().get(0).getCid().equals("290"));
    		
    		sec6 = it.initMainLeft();
    		assertTrue(sec6.getSeating().get(0).getSeats().get(0).getCid().equals("263"));
    		assertTrue(sec6.getSeating().get(1).getSeats().get(0).getCid().equals("280"));
    		assertTrue(sec6.getSeating().get(2).getSeats().get(0).getCid().equals("298"));
    }
    
    @Test
    public void test_nullShow(){
    		shows s = is.getShowDetail(20000);
    		assertTrue(s.isNil());
    }
    @Test
    public void test_nullOrder(){
    		orders ord = iord.getOrderDetail(20000);
    		assertTrue(ord.isNil());
    }
    @Test
    public void test_nullSection(){
    		Section s = iseat.getSectionDetail(20000);
    		assertTrue(s.isNil());
    }
    @Test
    public void test_nullTicket(){
    		ticket t = itic.getTicketDetail(20000);
    		assertTrue(t.isNil());
    }
    
    @Test
    public void test_nullSubD(){
    		subscribeDonations sub = isub.getSubDetail(20000);
    		assertTrue(sub.isNil());
    }
    
    @Test
    public void test_createShow() {
    		shows s = is.createShow("name", "web", "date", "time");
    		createdShowObjects++;
    		assertTrue(s.getShowInfo().getName().equals("name") && s.getShowInfo().getWeb().equals("web") && s.getShowInfo().getDate().equals("date") && s.getShowInfo().getTime().equals("time"));
    		
    }

    
    @Test
    public void test_getShowDetail() {
    		shows s = is.getShowDetail(1);
    		assertTrue(s.getID().equals("1"));
    }
    
    @Test
    public void test_getAllShows() {
    		List<shows> all = new ArrayList<shows>();
    		all=is.getAllShows();
    		for(int i=0; i<all.size(); i++) {
    			assertTrue(all.get(i).getID().equals(Integer.toString(i+1)));
    		}
    }
    
    @Test
    public void test_getSpecificSection() {
    		sec = is.getSpecificSection(2, 124);

    		assertTrue(sec.getPrice()==350);
    }
    
    
    @Test
    public void nullSectons(){
    		Section s = iseat.getSectionDetail(20000);
    		assertTrue(s.isNil());
    }
    
    @Test
    public void test_createSections() {
    		Section s = iseat.createSections("testSec", 123, 200);
    		assertTrue(s.getPrice()==200 && s.getSection_name().equals("testSec") &&
    				s.getSid().equals("123"));
    }
    
    @Test
    public void test_getAllSections() {
    		List<Section> all = new ArrayList<Section>();
    		all=iseat.getAllSeats();
    			assertTrue(all.get(0).getSid().equals("123") && all.get(0).getPrice()==250);
    			assertTrue(all.get(2).getSid().equals("124") && all.get(2).getPrice()==350);
    }
    
    @Test
    public void test_createSeats() {
    		Seat seat = iseat.createSeats(1, 1);
    		assertTrue(seat.getStatus().equals("available") && seat.getCid().equals("1") && seat.getSeat().equals("1"));
    }
    
    @Test
    public void test_createSeating() {
    		Seating seating = iseat.createSeating(1);
    		Seat seat = iseat.createSeats(1, 1);
    		Seat seat1 = iseat.createSeats(2, 2);
    		List<Seat> seatList = new ArrayList<Seat>();
    		seatList.add(seat);
    		seatList.add(seat1);
    		seating.setSeats(seatList);
    		
    		assertTrue(seating.getRow().equals("1") && seating.getSeats().get(0).status.equals("available")
    				&& seating.getSeats().get(1).status.equals("available"));
    		
    }
    
    @Test
    public void test_getSectionDetail() {
    		Section s = iseat.getSectionDetail(126);
    		assertTrue(s.getSection_name().equals("Main Right"));
    }
    
    
    @Test
    public void test_createOrder() {
    		orders ord = iord.createOrder(1, 123, "name", "phone", "email", "b_a", "cc_n", "cc_exp_d");
    		patron pat = ord.getPat();
    		assertTrue(pat.getName().equals("name") && 
    				pat.getPhone().equals("phone") &&
    				pat.getEmail().equals("email") &&
    				pat.getBilling_address().equals("b_a") &&
    				pat.getCc_number().equals("cc_n") &&
    				pat.getCc_exp_date().equals("cc_exp_d"));
    }
    
    @Test
    public void test_getAllOrders() {
    		List<orders> all = new ArrayList<orders>();
    		all=iord.getAllOrders();
    			assertTrue(all.get(0).getSid().equals("123") && all.get(0).getOid().equals("1"));
    			assertTrue(all.get(1).getSid().equals("124") && all.get(1).getOid().equals("2"));
    }
    
    @Test
    public void test_getOrderDetail() {
    		orders ord = iord.getOrderDetail(1);
    		assertTrue(ord.getOid().equals("1") && ord.getSid().equals("123"));
    }
    
    @Test
    public void test_createTicket() {
    		ticket tic = itic.createTicket(250, 1, 123, "Front Right");
    		assertTrue(tic.getPrice()==250 &&
    				tic.getSid().equals("123") &&
    				tic.getWid().equals("1"));
    }
    
    @Test
    public void test_getAllTickets() {
    		List<ticket> all = new ArrayList<ticket>();
    		all=itic.getAllTickets();
    			assertTrue(all.get(0).getSid().equals("123") && all.get(0).getTid().equals("1"));
    			assertTrue(all.get(1).getSid().equals("125") && all.get(1).getTid().equals("2"));
    }
    
    
    @Test
    public void test_autoShows() {
    		requestResponse response = rs.autoShows(1, 123, 3, 200);
    		assertTrue(response.getSeating().get(0).getSeats().get(0).getCid().equals("201"));
    		
    		 response = rs.autoShows(1, 123, 3, 205);
     	 assertTrue(response.getSeating().get(0).getSeats().get(0).getCid().equals("213"));
     	 
     	 response = rs.autoShows(1, 123, 5, 200);
     	 assertTrue(response.getStatus().equals("Error 5 contiguous seats not avalable"));
    }
    
    
    @Test
    public void test_createSub() {
    		subscribeDonations subD = isub.createSub(1, 3);
    		assertTrue(subD.getWid().equals("1") && subD.getCount()==3);
    }
    
    
    
}
