package Thalia;

import java.util.List;

public interface InterfaceShows {
	
    List<shows> getAllShows();
    shows createShow(String name, String web, String date, String time);
    shows getShowDetail(int lid);
    void updateShow(int id, shows s);
    Section getSpecificSection(int lid, int sid);   
}