
public class testing {

    public static void main(String args[]){
    	
    	DatabaseQueries db = new DatabaseQueries();
    	DayGUI day = new DayGUI(db);
        
        day.createTable();
    }
}
