package Thalia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowManager implements InterfaceShows {
	
    private static List<shows> Shows = new ArrayList<shows>();
    private static List<shows> allShows = new ArrayList<shows>();

    private int location;
    private static List<Section> Sections = new ArrayList<Section>();
    
    

    public List<shows> getAllShows() {    		
        return(Shows);
    }

    public shows createShow(String name, String web, String date, String time) {
        shows s= new shows(name, web, date, time);
        Shows.add(s);
        return(s);
    }

    private shows findById(int lid) {
    	location = 0;
        Iterator<shows> li = Shows.listIterator();
        
        while(li.hasNext()) {
        		
        		shows s = li.next();
        
        		if(s.matchesId(lid))
            		return(s);
        		
        		location++;
        }
        return(new NullShow());
    }
    
    public void updateShow(int id, shows s) {
    		findById(id);
    		for(int i=0; i<Shows.size(); i++) {
    			if(Shows.get(i).getID().equals(Integer.toString(id))){
    				Shows.set(i, s);
    			}
    		}	
    }

	public shows getShowDetail(int lid) {
		return(findById(lid));
	}
	
	public Section getSpecificSection(int lid, int sid) {
		shows sh = getShowDetail(lid);
		Sections = sh.getSections();
		for(int i=0; i<Sections.size(); i++) {
			Section s = Sections.get(i);
			if(s.getSid().equals(Integer.toString(sid))) {
				return s;
    			}
		}
			return(new NullSection());
	}
}
