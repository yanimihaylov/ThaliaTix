package Thalia;

import java.util.List;

public interface interfaceSub {
	
	subscribeDonations createSub(int wid, int c);
	subscribeDonations getSubDetail(int did);
	subscribeDonations getSpecificSub(int wid, int did);
	subscribeDonations checkStatus (subscribeDonations sd);
}
