import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseQueries {
	private Connection conn;
	
	public DatabaseQueries() {
		createDatabase();
	}
	
	public void createDatabase() {
		try {
			// create our mysql database connection
			String myDriver = "com.mysql.cj.jdbc.Driver";
			String myUrl = "jdbc:mysql://keytoketo.ct3vbyo501qd.us-east-2.rds.amazonaws.com/";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "admin", "key2ket0user");
			Statement sut = conn.createStatement();
			sut.executeQuery("use foods;");
		    
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	public ResultSet issueSearchQuery(String userString) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from foodItems WHERE name LIKE '%" + userString + "%'");
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	
	public Connection getConn() { return this.conn; }
	
	public void addItemToMeal(String foodName, String mealName) {
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into " + mealName + " VALUES ('" + foodName + "')";
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllItemsFromMeal(String mealName) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from " + mealName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean itemExistsInMeal(String foodName, String mealName) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from " + mealName + " where foodName = '" + foodName + "'");
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void removeItemFromMeal(String foodName, String mealName) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from " + mealName + " where foodName = '" + foodName + "'");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public String getAllFoods(String mealName) {
    	String result = "";
    	int numberItems = getNumberItemsInTable(mealName);
    	ArrayList<String> foodNames = getFoodNames(mealName);
    	
    	if(!foodNames.isEmpty()) {
    		for(int i = 0; i < numberItems; i++) {
    	    	//String newName = queryDatabaseByID(foodNames.get(i));
    	    	//String foodName = getFoodName(newName);
    	    	result += foodNames.get(i) + "\n";
        	}
        	return result;
    	}
    	else {
    		return "";
    	}
    	
    }
    
    public ArrayList<String> getFoodNames(String mealName) {
    	ArrayList<String> foodNames = new ArrayList<String>();
    	try {
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery("select * from " + mealName);
    		while(rs.next()) {
    			String food = rs.getString("foodName");
    			foodNames.add(food);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	return foodNames;
    }
    
    public int getNumberItemsInTable(String tableName) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select count(*) from " + tableName);
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
    }
    
	public String queryDatabaseByName(String foodName) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select name from foodItems where name = '" + foodName + "'");
			rs.next();
			return rs.getString("name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void removeAllItemsFromMeal(String mealName) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("delete from " + mealName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getMacroString(String mealName) {
		ArrayList<Double> values = getMacros(mealName);
		
		return "";
	}
	
	public ArrayList<Double> getMacros(String mealName) {
		ArrayList<Double> values = new ArrayList<Double>();
		double calories = 0;
		double fat = 0;
		double protein = 0;
		double carbs = 0;
		double sugar = 0;
		double fiber = 0;
		double cholesterol = 0;
		double satFat = 0;
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from " + mealName);
			
			while(rs.next()) {
				String food = rs.getString("foodName");
				Statement stmt2 = conn.createStatement();
				ResultSet newRS = stmt2.executeQuery("select * from foodItems where name = '" + food + "'");
				
				while(newRS.next()) {
					calories += newRS.getDouble("calories");
					fat += newRS.getDouble("fat");
					protein += newRS.getDouble("protein");
					carbs += newRS.getDouble("carbs");
					sugar += newRS.getDouble("sugar");
					fiber += newRS.getDouble("fiber");
					cholesterol += newRS.getDouble("cholesterol");
					satFat += newRS.getDouble("satFat");
				}

			}
			
			values.add(calories);
			values.add(fat);
			values.add(protein);
			values.add(carbs);
			values.add(sugar);
			values.add(fiber);
			values.add(cholesterol);
			values.add(satFat);
			
			return values;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addItemToRecipes(String name, String ingredients, String directions, int timeToCook, int numServings,
			int calories, int carbs, int protein, int fat, boolean bfast, boolean lunch, boolean dinner, boolean snack,
			boolean vegan, boolean glutenFree)  {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO recipes VALUES ('" + name + "', '" + ingredients + "', '" 
					+ directions + "', " + timeToCook + ", " + numServings + ", " + calories + ", " 
					+ carbs + ", " + protein + ", " + fat + ", " + bfast + ", " + lunch + ", " + dinner
					+ ", " + snack + ", " + vegan + ", " + glutenFree + ")");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean itemExistsInRecipes(String recipeName) {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from recipes WHERE recipeName = '" + recipeName + "'");
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void deleteItemFromRecipes(String name) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM recipes WHERE recipeName = '" + name + "'");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getItemFromRecipes(String recipeName) {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM recipes WHERE recipeName = '" + recipeName + "'");
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ResultSet issueSearchRecipeQuery(String userString, boolean[] filters) {
		
		String[] filterNames = {"breakfast", "lunch", "dinner", "snack", "vegan", "glutenFree"};
		String sqlSearchRecipe = "SELECT * FROM recipes WHERE recipeName LIKE '%" + userString + "%'";
		
		for(int i = 0; i < filters.length; i++) {
			if(filters[i] == true) 
				sqlSearchRecipe += " AND " + filterNames[i] + " = 1";
		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSearchRecipe);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getAllSavedRecipes() {
		
		String display = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT recipeName FROM savedRecipes");
			while(rs.next()) {
				String name = rs.getString("recipeName");
				
				display += name + "\n";
				
			}
			return display;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addItemToSavedRecipes(String name) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO savedRecipes VALUES ('" + name + "')");
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean itemExistsInSavedRecipes(String recipeName) {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from savedRecipes WHERE recipeName = '" + recipeName + "'");
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void deleteItemFromSavedRecipes(String name) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM savedRecipes WHERE recipeName = '" + name + "'");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addItemToShoppingList(String FoodName) {
		try {
			Statement stmt = conn.createStatement();
			String query = "insert into shoppingList VALUES ('" + FoodName + "')";
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean itemExistsInShoppingList(String FoodName) {

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from shoppingList WHERE foodName = '" + FoodName + "'");
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public void deleteItemFromShoppingList(String FoodName) {

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM shoppingList WHERE foodName = '" + FoodName + "'");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getItemFromShoppingList(String FoodName) {

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM shoppingList WHERE foodName = '" + FoodName + "'");

			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public ResultSet issueSearchRestaurantQuery(String searchString, boolean[] filters) {
		
		String[] filterNames = {"Applebees", "Arbys", "Burger King", "Kfc", "McDonalds", "Pizza Hut", "Popeyes", "Subway", "Taco Bell", "Wendys"};
		
		int count = 0;
		String sqlSearchRestaurant = "select * from foodItems where";
		for(int i = 0; i < filters.length; i++) {
		    if(filters[i] == true) {
		    	count++;
		        if(count == 1) {
		            sqlSearchRestaurant += " name like '%" + searchString + "%' and name like '%" + filterNames[i] + "%'";
		        }
		        else {
		            sqlSearchRestaurant += " or name like '%" + searchString + "%' and name like '%" + filterNames[i] + "%'";
		        }
		        
		    }
		}
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSearchRestaurant);
			
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
