package Thalia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/")
public class REST_shows {
	
	private InterfaceShows is = new ShowManager();
	private InterfaceSeating iseat = new SeatingManager();
	private interfaceOrders iord = new orderManager();
	private InterfaceTicket itic = new ticketManager();
	private interfaceSub isub = new subManager();
	private requestShows rs = new requestShows();
	private initTheater it = new initTheater();
	Section initSection;
	Seating initSeating;
	Seat initSeat;

	
	@PostConstruct
    public void postConstruct() {
        //Initialize theater seating
    		
	}
	
	@GET
	@Path("/thalia")
	public Response initTheater() {
		it.create();
        return Response.status(Response.Status.OK).entity("Theater Built!").build();
	}
    
    
    //CREATE SHOWS
	@Path("/shows")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createShows(String json) {
		
        Gson gson = new Gson();
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
		JsonElement showJSON = obj.get("show_info");
		
		JsonArray seatJSON = obj.getAsJsonArray("seating_info");
		
		
		String showString = showJSON.toString();
		
        shows s = gson.fromJson(showString, shows.class); 
        shows ns = is.createShow(s.getName(), s.getWeb(), s.getDate(), s.getTime());
        
        for(int i = 0; i < seatJSON.size(); i++)
        {
        		JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
        		Section sec = gson.fromJson(seatJSONobj, Section.class);
        		Section nsec = iseat.createSections(sec.getSection_name(), Integer.parseInt(sec.getSid()), sec.getPrice());
        		
        		if(sec.getSid().equals("123")) {
        			nsec = it.initFrontRight();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("124")) {
        			nsec = it.initFrontCenter();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("125")) {
        			nsec = it.initFrontLeft();        
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("126")) {
        			nsec = it.initMainRight();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("127")) {
        			nsec = it.initMainCenter();        		
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("128")) {
        			nsec = it.initMainLeft();}
        		
        		ns.add(i, nsec);
        		

        }  
     
	Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	String st = gsonb.toJson(ns);
	JsonObject returnObj = gson.fromJson(st, JsonObject.class);
	returnObj.remove("name");
	returnObj.remove("web");
	returnObj.remove("date");
	returnObj.remove("time");
	returnObj.remove("showInfo");
	returnObj.remove("seating_info");

	st = gsonb.toJson(returnObj);

	
	     
	return Response.ok(st).build();
    }
    
    //UPDATE SHOWS
    @Path("/shows/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response makeLamp(@PathParam("id") int showID, String json) {
    	
    		int id = showID;
    		Gson gson = new Gson();
        shows sIn = is.getShowDetail(id);
        shows s = gson.fromJson(json, shows.class);
        
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
		JsonElement showJSON = obj.get("show_info");
		
		JsonArray seatJSON = obj.getAsJsonArray("seating_info");
		
		
		String showString = showJSON.toString();
		
        showInfo sInfo = gson.fromJson(showString, showInfo.class);
        s.setShowInfo(sInfo);
        
        for(int i = 0; i < seatJSON.size(); i++)
        {
        		JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
        		Section sec = gson.fromJson(seatJSONobj, Section.class);
        		Section nsec = iseat.createSections(sec.getSection_name(), Integer.parseInt(sec.getSid()), sec.getPrice());
        		
        		if(sec.getSid().equals("123")) {
        			nsec = it.initFrontRight();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("124")) {
        			nsec = it.initFrontCenter();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("125")) {
        			nsec = it.initFrontLeft();        
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("126")) {
        			nsec = it.initMainRight();
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("127")) {
        			nsec = it.initMainCenter();        		
        			nsec.setPrice(sec.getPrice());}
        		if(sec.getSid().equals("128")) {
        			nsec = it.initMainLeft();}
        		
        		s.set(i, nsec);
        		

        }  
        
        s.setWid(Integer.toString(id));
        
        if (sIn.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + id).build();
        }
        else {
        		is.updateShow(id, s);
        		return Response.status(Response.Status.ACCEPTED).build();        
        		}
    }
    
    
  //VIEW SHOW
    @Path("/shows/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificShow(@PathParam("id") int wid) {
        // call the "Get Show Detail" use case
        shows s = is.getShowDetail(wid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
        	
        	
        	
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s);
            
            JsonObject obj = gson.fromJson(st, JsonObject.class);
            //obj.getAsJsonObject().remove("price");
            JsonArray objArr = obj.getAsJsonArray("seating_info"); 
            for(int i=0; i<objArr.size(); i++) {
            		
            		objArr.get(i).getAsJsonObject().remove("seating");
            		objArr.get(i).getAsJsonObject().remove("section_name");
            		
            }
            
            st = gson.toJson(obj);
            
            return Response.ok(st).build();
        }
    }
    
    //VIEW ALL SHOWS
    @Path("/shows")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShows() {
        // calls the "Get All Shows" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<shows> showsList = is.getAllShows();

        String s = gson.toJson(showsList);
        JsonArray objArr = gson.fromJson(s, JsonArray.class);
        
        for(int i=0; i<objArr.size(); i++) {
	        objArr.get(i).getAsJsonObject().remove("seating_info");
        }
        s = gson.toJson(objArr);
        
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    
    
    //VIEW SHOW SECTIONS
    @Path("/shows/{id}/sections")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowSections(@PathParam("id") int wid) {
        // call the "Get Show Detail" use case
        shows s = is.getShowDetail(wid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
        	
        	
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(s.getSections());
            
            JsonArray objArr = gson.fromJson(st, JsonArray.class);
            for(int i=0; i<objArr.size(); i++) {
            		objArr.get(i).getAsJsonObject().remove("seating");
            }
            st = gson.toJson(objArr);
            return Response.ok(st).build();
        }
    }
    
    
  //VIEW SHOW SPECIFIC SECTION
    @Path("/shows/{id}/sections/{sid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowSpecificSection(@PathParam("id") int wid, @PathParam("sid") int sid) {
        // call the "Get Show Section" use case
    		shows sh = is.getShowDetail(wid);
        Section s = is.getSpecificSection(wid, sid);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            String shSt = gson.toJson(sh);
            
            JsonObject obj = gson.fromJson(shSt, JsonObject.class);
            obj.getAsJsonObject().remove("seating_info");

            
            shSt = gson.toJson(obj);
            String secSt = gson.toJson(s);
            
            
            shSt = shSt.substring(0, shSt.length()-2);
            secSt = secSt.substring(1);
            
            String totalString =  shSt + ", " + secSt;
            return Response.ok(totalString).build();
        }
    }
    
    
    //SUBSCRIBE TO DONATIONS
    @Path("/shows/{wid}/donations")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response subscribe(@PathParam("wid") int wid,String json) {
 		
        Gson gson = new Gson();
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
 		JsonElement patronJSON = obj.get("patron_info");
 		JsonElement countJSON = obj.get("count");

 		
 		String patronString = patronJSON.toString();
        patron pat = gson.fromJson(patronString, patron.class);
        
 	
 		int countInt = Integer.parseInt(countJSON.toString());
 		
 		subscribeDonations subD = isub.createSub(wid, countInt);
 		subD.setPatron_info(pat);
 		
 		
		
		Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	 	String ret = gsonb.toJson(subD);
	 	
	 	JsonObject result = gson.fromJson(ret, JsonObject.class);
	 	result.remove("patron_info");
	 	result.remove("wid");
	 	result.remove("count");
	 	result.remove("tickets");
	 	String resultString = gson.toJson(result);
	 	     
	 	return Response.ok(resultString).build();
    }
    
    
    //STATUS OF REQUEST FOR DONATED TICKETS
    @Path("/shows/{id}/donations/{did}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificSub(@PathParam("id") int wid, @PathParam("did") int did) {
        // call the "Get status for donations" use case	
    		subscribeDonations s = isub.getSpecificSub(wid, did);
    		s = isub.checkStatus(s);
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + did).build();
        } else {
        	
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String res = gson.toJson(s);        
            
            JsonObject obj = gson.fromJson(res, JsonObject.class);
            /*JsonArray arr = obj.getAsJsonArray("tickets");
            for(int i= 0; i<arr.size(); i++) {
            		JsonObject tObject = arr.get(i).getAsJsonObject();
            }*/
            
            res = gson.toJson(obj);        

            return Response.ok(res).build();
        }
    }
    
    
    
    
    ///////////////////////////////SEATING///////////////////////////////
   

    
    //REQUEST SEATS AUTO OR SEATING
    @Path("/seating")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutoSeats(@QueryParam("show") Integer wid, @QueryParam("section") int sid, @QueryParam("count") int count, @QueryParam("starting_seat_id") int cid) {
    	
    	
    		if(wid == null) {
    			// calls the "Get All Seats" use case
    	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
    	        String s = gson.toJson(iseat.getAllSeats());
    	        JsonArray objArr = gson.fromJson(s, JsonArray.class);
    	        
    	        for(int i=0; i<objArr.size(); i++) {
    		        objArr.get(i).getAsJsonObject().remove("price");
    		        objArr.get(i).getAsJsonObject().remove("seating");
    	        }
    	        s = gson.toJson(objArr);
    	        return Response.status(Response.Status.OK).entity(s).build();
    			
    		}
    		
        // call the "Request seats" use case
        requestResponse response = rs.autoShows(wid, sid, count, cid);
        if (response.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(response);
            
            JsonObject obj = gson.fromJson(st, JsonObject.class);
            
            obj.getAsJsonObject("info").remove("seating_info");
            
            st = gson.toJson(obj);
            return Response.ok(st).build();
        }
    }
    
    
    
    //VIEW SPECIFIC SECTION
    @Path("/seating/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificSection(@PathParam("id") int wid) {
        // call the "Get Show Detail" use case
        Section s = iseat.getSectionDetail(wid);
        
        if (s.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + wid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            
            String st = gson.toJson(s);
            
            JsonObject obj = gson.fromJson(st, JsonObject.class);
            obj.getAsJsonObject().remove("price");
            
            for(int i=0; i<obj.getAsJsonArray("seating").size(); i++) {
            	
            		JsonArray ja = obj.getAsJsonArray("seating").get(i).getAsJsonObject().getAsJsonArray("seats");
            		
            		for(int j=0; j<ja.size(); j++) {
            			ja.get(j).getAsJsonObject().remove("cid");
            			ja.get(j).getAsJsonObject().remove("status");
            		}
            		
            }
            st = gson.toJson(obj);
            return Response.ok(st).build();
        }
    }
    

    
    
    
    ///////////////////////////////ORDERS///////////////////////////////

    //CREATE ORDERS
 	@Path("/orders")
     @POST
     @Produces(MediaType.APPLICATION_JSON)
     public Response createOrders(String json) {
 		
         Gson gson = new Gson();
         
        int price=0;
        int ticketCount=0;
         
        JsonObject obj = gson.fromJson(json, JsonObject.class);
 		JsonElement patronJSON = obj.get("patron_info");
 		JsonElement widJSON = obj.get("wid");
 		JsonElement sidJSON = obj.get("sid");
 		
 		JsonArray seatJSON = obj.getAsJsonArray("seats");
 		
 		//JsonObject seatObj = seatJSON.getAsJsonObject();
 		
 		String patronString = patronJSON.toString();
 		
 		int widInt = Integer.parseInt(widJSON.toString().substring(1,widJSON.toString().length()-1));		
 		int sidInt = Integer.parseInt(sidJSON.toString().substring(1,sidJSON.toString().length()-1));
 		
         patron pat = gson.fromJson(patronString, patron.class); 
         orders ord = iord.createOrder(widInt, sidInt, pat.getName(), pat.getPhone(), pat.getEmail(), pat.getBilling_address(), pat.getCc_number(), pat.getCc_exp_date());
  		 shows s = is.getShowDetail(widInt);         
  		
  		 ord.setShowI(s.getShowInfo());
  		 ord.setWid(widInt);
  		 ord.setSid(sidInt);
  		 
  		List<ticket> ticArray = new ArrayList<ticket>();
         for(int i = 0; i < seatJSON.size(); i++)
         {
        	 	JsonObject seatJSONobj = seatJSON.get(i).getAsJsonObject();
     		Seat st = gson.fromJson(seatJSONobj, Seat.class);
     		int cid = Integer.parseInt(st.getCid());

     		
            Section sec = is.getSpecificSection(widInt, sidInt);
            price = sec.getPrice();
            String name = sec.getSection_name();

     		List<Seating> secArray = sec.getSeating();
     		
     		
     		for(int k=0; k<secArray.size(); k++) {
     			List<Seat> seats = secArray.get(k).getSeats();
     			
     			for(int j=0; j<seats.size(); j++) {
     				if(seats.get(j).getCid().equals(Integer.toString(cid))) {
     					seats.get(j).setStatus("");
     					
     					//create ticket
     					ticket t = itic.createTicket(price, widInt, sidInt, name);
     					t.setPatronInfo(ord.getPat());
     					t.setShowInfo(ord.getShowI());
     					t.setCid(cid);
     					t.setRow(k+1);
     					ticketCount++;
     					ticArray.add(t);
     					
     				}
     			}
     		}
         }
         
         ord.setTickets(ticArray);
         price*=ticketCount;
         ord.setNumberOfTickets(ticketCount);
         ord.setOrderAmount(price);
 	Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
 	String ret = gsonb.toJson(ord);
 	
 	JsonObject returnObj = gson.fromJson(ret, JsonObject.class);
 	returnObj.remove("sid");
 	returnObj.remove("numberOfTickets");
 	returnObj.remove("pat");
 	JsonArray returnTic = returnObj.getAsJsonArray("tickets");
 	
 	List<String> tIDs = new ArrayList<String>();
 	
 	for(int i=0; i<returnTic.size(); i++) {
 		returnTic.get(i).getAsJsonObject().remove("price");
 		returnTic.get(i).getAsJsonObject().remove("status");
 		returnTic.get(i).getAsJsonObject().remove("wid");
 		returnTic.get(i).getAsJsonObject().remove("showInfo");
 		returnTic.get(i).getAsJsonObject().remove("patronInfo");
 		returnTic.get(i).getAsJsonObject().remove("sid");
 		returnTic.get(i).getAsJsonObject().remove("section_name");
 		returnTic.get(i).getAsJsonObject().remove("row");
 		returnTic.get(i).getAsJsonObject().remove("cid");
 		
 		//String tID = returnTic.get(i).getAsJsonObject().get("tid").toString(); 
 		//tIDs.add(tID);
 	}
 	
 	//returnObj.remove("tickets");
 	     
 	ret = gsonb.toJson(returnObj);
 	return Response.ok(ret).build();
     }
 	
 	
    //VIEW ALL ORDERS
    @Path("/orders")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders() {
        // calls the "Get All Shows" use case
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<orders> showsList = iord.getAllOrders();
        String s = gson.toJson(showsList);
        
        JsonArray objArr = gson.fromJson(s, JsonArray.class);
        for(int i=0; i<objArr.size(); i++) {
        		objArr.get(i).getAsJsonObject().remove("sid");
        		objArr.get(i).getAsJsonObject().remove("tickets");
        }
        
        s =gson.toJson(objArr);
        return Response.status(Response.Status.OK).entity(s).build();
    }
    
    
    //VIEW ORDERS BY DATE
    @Path("/ordersD")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAutoSeats(@QueryParam("start_date") String startD, @QueryParam("end_date") String endD) {
            // calls the "Get All Shows" use case
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            
            List<orders> ordersList = iord.getAllOrders();
            List<orders> dateList = new ArrayList<orders>();
            
            for(int i=0; i<ordersList.size(); i++) {
            		orders ord = ordersList.get(i);
            		Date dOrdered = ord.getDateOrdered();
            		SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDD");
            		Date dStart = null;
            		Date dEnd = null;
            		
            		
            		try {
						dStart = formatter.parse(startD);
					} catch (ParseException e) {
						e.printStackTrace();
					}
            		
            		try {
						dEnd = formatter.parse(endD);
					} catch (ParseException e) {

						e.printStackTrace();
					}
            		
            		System.out.println("START " +dStart);
            		System.out.println("END " +dEnd);
            		System.out.println("ORDERED " +dOrdered);
            		System.out.println("-----");	
            		System.out.println(dOrdered.before(dEnd));
            		System.out.println(dOrdered.after(dStart));
            		System.out.println("-----NEW------");
            		System.out.println(dOrdered.before(dStart));
            		System.out.println(dOrdered.after(dEnd));
            		System.out.println("-----");
            		
            		
            			if((dOrdered.before(dEnd))&&(dOrdered.after(dStart))) {
            				System.out.println("adding");
            				dateList.add(ord);
            			}
            		
            }
            
            String s = gson.toJson(dateList);
            return Response.status(Response.Status.OK).entity(s).build();
        }
    
    //VIEW ORDER
    @Path("/orders/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificOrder(@PathParam("id") int oid) {
        // call the "Get Show Detail" use case
        orders ord = iord.getOrderDetail(oid);
        if (ord.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + oid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(ord);
            
            
            JsonObject obj = gson.fromJson(st, JsonObject.class);
            obj.remove("sid");
            		
            		JsonArray ticArr = obj.getAsJsonArray("tickets");
            		for(int j = 0; j<ticArr.size(); j++) {
            			
            			ticArr.get(j).getAsJsonObject().remove("price");
            			ticArr.get(j).getAsJsonObject().remove("wid");
            			ticArr.get(j).getAsJsonObject().remove("showInfo");
            			ticArr.get(j).getAsJsonObject().remove("patronInfo");
            			ticArr.get(j).getAsJsonObject().remove("sid");
            			ticArr.get(j).getAsJsonObject().remove("section_name");
            			ticArr.get(j).getAsJsonObject().remove("row");
            			ticArr.get(j).getAsJsonObject().remove("cid");
            		}
            
            
            st =gson.toJson(obj);
            return Response.status(Response.Status.OK).entity(st).build();
        }
    }
    
    
    
    
    ///////////////////////////////TICKETS///////////////////////////////
    
    	
    //VIEW TICKET
    @Path("/tickets/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecificTicket(@PathParam("id") int tid) {
        // call the "Get Show Detail" use case
        ticket tic = itic.getTicketDetail(tid);
        if (tic.isNil()) {
            // return a 404
            return Response.status(Response.Status.NOT_FOUND).entity(":( Entity not found for ID: " + tid).build();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String st = gson.toJson(tic);
            return Response.ok(st).build();
        }
    }
    
    //SCAN TICKET
    @Path("/tickets/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response scanTicket(@PathParam("tid") int tid, String json) {
 		
        Gson gson = new Gson();
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
		JsonElement tidJSON = obj.get("tid");
		JsonElement statusJSON = obj.get("status");
		
 		int tidInt = Integer.parseInt(tidJSON.toString().substring(1,tidJSON.toString().length()-1));		
		String statusString = statusJSON.toString().substring(1,statusJSON.toString().length()-1);
		
		List<ticket> tixList = itic.getAllTickets();
		
		for(int i=0; i<tixList.size(); i++) {
			if(tixList.get(i).getTid().equals(Integer.toString(tidInt)))
				tixList.get(i).setStatus(statusString);
		}
		
		
		
		Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	 	String ret = gsonb.toJson(obj);
	 	     
	 	return Response.ok(ret).build();
    }
    
    //DONATE TICKET
    @Path("/tickets/donations")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response donateTicket(String json) {
    		ArrayList<Integer> listInt = new ArrayList<Integer>();
 		
        Gson gson = new Gson();
        
        JsonObject obj = gson.fromJson(json, JsonObject.class);
        JsonArray ticArr = obj.getAsJsonArray("tickets");
        
        for(int i = 0; i<ticArr.size(); i++) {
        		JsonElement tidJSON = ticArr.get(i);
        		int tidInt = Integer.parseInt(tidJSON.toString().substring(1,tidJSON.toString().length()-1));	
        		listInt.add(tidInt);
        }
        
		itic.donateTicket(listInt);
		
		Gson gsonb = new GsonBuilder().setPrettyPrinting().create();
	 	String ret = gsonb.toJson(obj);
	 	     
	 	return Response.ok(ret).build();
    }
    
}

