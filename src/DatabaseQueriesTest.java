import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DatabaseQueriesTest {
	
	@Test
	void issueSearchQueryTest() throws SQLException {
		
		DatabaseQueries sut = new DatabaseQueries();
		//sut.createDatabase(); // need to change to an interface later
		ResultSet test = sut.issueSearchQuery("chicken");
		test.next();
		String result = test.getString("name");
		
		assertEquals("Almond Chicken", result);
	}
	
	@Test
	void deleteAllItemsFromMealTest() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();
		sut.deleteAllItemsFromMeal("breakfast");
		
		Connection conn = sut.getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from breakfast");
		rs.next();
		int result = rs.getInt("count(*)");
		
		assertEquals(0, result);
	}
	
	@Test
	void deleteAllItemsFromDayTest() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();
		sut.deleteAllItemsFromMeal("monday");
		
		Connection conn = sut.getConn();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from monday");
		rs.next();
		int result = rs.getInt("count(*)");
		
		assertEquals(0, result);
	}
	
	// tests both add and delete to ensure nothing tested is added to real database table 
	@Test
	void addAndDeleteItemToMealTest() {
		DatabaseQueries sut = new DatabaseQueries();
		sut.addItemToMeal("egg", "breakfast");
		boolean result = sut.itemExistsInMeal("egg", "breakfast");
		
		assertTrue(result);
		sut.removeItemFromMeal("egg", "breakfast");
	}
	
	@Test
	void queryDatabaseByIDTest() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();
		String result = sut.queryDatabaseByName("Wendys Crispy Chicken Sandwich");
		
		assertEquals("Wendys Crispy Chicken Sandwich", result);
	}
	
	@Test
	void getNumberItemsInTableTest() {
		DatabaseQueries sut = new DatabaseQueries();
		sut.addItemToMeal("egg", "breakfast");
		int result = sut.getNumberItemsInTable("breakfast");
		
		assertEquals(1, result);
		sut.removeItemFromMeal("egg", "breakfast");
	}
	
	@Test
	void getFoodNamesTest() {
		DatabaseQueries sut = new DatabaseQueries();
		sut.removeAllItemsFromMeal("breakfast");
		sut.addItemToMeal("egg", "breakfast");
		ArrayList<String> foodNames = sut.getFoodNames("breakfast");
		String result = foodNames.get(0);
		
		assertEquals("egg", result);
		sut.removeItemFromMeal("egg", "breakfast");
	}
	
	@Test
	void getAllFoodsTest() {
		DatabaseQueries sut = new DatabaseQueries();
		sut.addItemToMeal("egg", "breakfast");
		String result = sut.getAllFoods("breakfast");
		
		assertEquals("egg\n", result);
		sut.removeItemFromMeal("egg", "breakfast");
	}
	
	@Test
	void removeAllItemsFromMealTest() {
		DatabaseQueries sut = new DatabaseQueries();
		sut.addItemToMeal("egg", "breakfast");
		sut.addItemToMeal("bacon", "breakfast");
		sut.removeAllItemsFromMeal("breakfast");
		int result = sut.getNumberItemsInTable("breakfast");
		
		assertEquals(0, result);
	}
	
	@Test
	void getMacrosTest() {
		DatabaseQueries sut = new DatabaseQueries();
		sut.removeAllItemsFromMeal("breakfast");
		sut.addItemToMeal("Almonds", "breakfast");
		sut.addItemToMeal("Almonds Salted", "breakfast");
		
		ArrayList<Double> results = sut.getMacros("breakfast");
		// results.get(0) will get the total number of calories in the breakfast table
		assertEquals(1180, results.get(0));
		
		sut.removeAllItemsFromMeal("breakfast");
	}
	
	
	@Test
	void addItemToRecipesTest() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();

		sut.addItemToRecipes("a recipe", "ingredients", "directions", 100, 1, 100, 100, 100, 100, false, false, false, false, false, false);
		boolean result = sut.itemExistsInRecipes("a recipe");
		assertEquals(true, result);
		
		sut.deleteItemFromRecipes("a recipe");
	}
	
	@Test
	void getItemFromRecipesTest() throws SQLException  {
		DatabaseQueries sut = new DatabaseQueries();
		
		sut.addItemToRecipes("a recipe", "ingredients", "directions", 100, 1, 100, 100, 100, 100, false, false, false, false, false, false);
		ResultSet rs = sut.getItemFromRecipes("a recipe");
		rs.next();
		String ingredientsStr = rs.getString("ingredients");
		
		assertTrue(ingredientsStr.equalsIgnoreCase("ingredients"));
		sut.deleteItemFromRecipes("a recipe");
	}
	
	@Test
	void deleteItemFromRecipesTest() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();
		
		sut.addItemToRecipes("a recipe", "ingredients", "directions", 100, 1, 100, 100, 100, 100, false, false, false, false, false, false);
		boolean result = sut.itemExistsInRecipes("a recipe");
		assertTrue(result);
		sut.deleteItemFromRecipes("a recipe");
		boolean newResult = sut.itemExistsInRecipes("a recipe");
		
		assertFalse(newResult);
	}
	
	@Test
	void addItemToSavedRecipesTest() {
		DatabaseQueries sut = new DatabaseQueries();

		sut.addItemToSavedRecipes("my recipe");
		boolean result = sut.itemExistsInSavedRecipes("my recipe");
		assertEquals(true, result);
		
		sut.deleteItemFromSavedRecipes("my recipe");
	}
	
	@Test
	void deleteItemFromSavedRecipesTest() {
		DatabaseQueries sut = new DatabaseQueries();
		
		sut.addItemToSavedRecipes("my recipe");
		boolean result = sut.itemExistsInSavedRecipes("my recipe");
		assertTrue(result);
		
		
		sut.deleteItemFromSavedRecipes("my recipe");
		boolean newResult = sut.itemExistsInSavedRecipes("my recipe");
		assertFalse(newResult);
	}	
	
	@Test
	void addItemToShoppingList() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();

		sut.addItemToShoppingList("item on shopping list");
		boolean result = sut.itemExistsInShoppingList("item on shopping list");
		assertTrue(result);

		sut.deleteItemFromShoppingList("item on shopping list");
	}
	/*
	@Test
	void getItemFromShoppinglist() throws SQLException  {
		DatabaseQueries sut = new DatabaseQueries();
		
		sut.addItemToShoppinglist(1,"item on shopping list");
		ResultSet rs = sut.getItemFromShoppinglist("item on shopping list");
		rs.next();
		
		
		assertTrue(ingredientsStr.equalsIgnoreCase("ingredients"));
		sut.deleteItemFromRecipes("a recipe");
	}
	*/
	@Test
	void deleteItemFromShoppingList() throws SQLException {
		DatabaseQueries sut = new DatabaseQueries();

		sut.addItemToShoppingList("item on shopping list");
		boolean result = sut.itemExistsInShoppingList("item on shopping list");
		assertTrue(result);
		
		sut.deleteItemFromShoppingList("item on shopping list");
		boolean newResult = sut.itemExistsInShoppingList("item on shopping list");
		assertFalse(newResult);
	}
	
}
