package Thalia;

import java.util.List;

public interface interfaceOrders {
	
	orders createOrder(int wid, int sid, String name, String phone, String email, String b_a, String cc_n, String cc_exp_d);
	List<orders> getAllOrders();
	orders getOrderDetail(int oid);
}
