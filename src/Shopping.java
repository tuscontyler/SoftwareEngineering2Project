import java.util.ArrayList;

public class Shopping {

	
	private DatabaseQueries db;

	Shopping(DatabaseQueries db) {
		
		this.db=db;
	}
	
	public void setShopping(Shopping initShopping)
	{
		//initShopping = shopping;
	}
	
	public void addToList(String input) {
		db.addItemToShoppingList(input);
	}
	
	public void deleteItemFromList(String input) {
		db.deleteItemFromShoppingList(input);
	}
	
	public ArrayList<String> getCurrentList() {
		
		ArrayList<String> shoppingList = db.getFoodNames("shoppingList");
		return shoppingList;
	}
	
	
	//public Shopping getSunday() {
		
//	return shopping;
//}
	
	
}
