package Thalia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class orderManager implements interfaceOrders{
	
	private static List<orders> orders = new ArrayList<orders>();
	int location;

		public orders createOrder(int wid, int sid, String name, String phone, String email, String b_a, String cc_n, String cc_exp_d ) {
			orders ord = new orders(wid, sid, name, phone, email, b_a, cc_n, cc_exp_d);
			orders.add(ord);
			return ord;
		}
		
		public List<orders> getAllOrders(){
			return orders;
		}
		
		public orders getOrderDetail(int oid) {
			return(findById(oid));
		}
		
		
	    private orders findById(int oid) {
	    	location = 0;
	        Iterator<orders> li = orders.listIterator();
	        
	        while(li.hasNext()) {
	        		
	        		orders ord = li.next();
	        
	        		if(ord.matchesId(oid))
	            		return(ord);
	        		
	        		location++;
	        }
	        return(new NullOrder());
	    }
}
