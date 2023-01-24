import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Recipe {

	private String name;
	private String ingredients;
	private String directions;
	private int timeToCook;
	private int numServings;
	private int calories;
	private int carbs;
	private int protein;
	private int fat;
	private boolean bfast;
	private boolean lunch;
	private boolean dinner;
	private boolean snack;
	private boolean vegan;
	private boolean glutenFree;
	private DatabaseQueries db;
	
	public Recipe(DatabaseQueries db)
	{
		name = "";
		directions = "";
		timeToCook = 0;
		numServings = 0;
		calories = 0;
		carbs = 0;
		protein = 0;
		fat = 0;
		bfast = false;
		lunch = false;
		dinner = false;
		snack = false;
		vegan = false;
		glutenFree = false;
		this.db = db;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setIngredients(String ingredients)
	{
		this.ingredients = ingredients;
	}
	
	public String getIngredients()
	{
		return ingredients;
	}
	
	public void setDirections(String directions)
	{
		this.directions = directions;
	}
	
	public String getDirections()
	{
		return directions;
	}
	
	public void setTimeToCook(int time)
	{
		this.timeToCook = time;
	}
	
	public int getTimeToCook()
	{
		return timeToCook;
	}
	
	public void setNumServings(int servings)
	{
		this.numServings = servings;
	}
	
	public int getNumServings()
	{
		return numServings;
	}
	
	public void setCalories(int calories)
	{
		this.calories = calories;
	}
	
	public int getCalories()
	{
		return calories;
	}
	
	public void setCarbs(int carbs)
	{
		this.carbs = carbs;
	}
	
	public int getCarbs()
	{
		return carbs;
	}
	
	public void setProtein(int protein)
	{
		this.protein = protein;
	}
	
	public int getProtein()
	{
		return protein;
	}
	
	public void setFat(int fat)
	{
		this.fat = fat;
	}
	
	public int getFat()
	{
		return fat;
	}
	
	public void setBfast(boolean bfast)
	{
		this.bfast = bfast;
	}
	
	public boolean isBfast()
	{
		return bfast;
	}
	
	public void setLunch(boolean lunch)
	{
		this.lunch = lunch;
	}
	
	public boolean isLunch()
	{
		return lunch;
	}
	
	public void setDinner(boolean dinner)
	{
		this.dinner = dinner;
	}
	
	public boolean isDinner()
	{
		return dinner;
	}
	
	public void setSnack(boolean snack)
	{
		this.snack = snack;
	}
	
	public boolean isSnack()
	{
		return snack;
	}
	
	public void setVegan(boolean vegan)
	{
		this.vegan = vegan;
	}
	
	public boolean isVegan()
	{
		return vegan;
	}
	
	public void setGlutenFree(boolean gf)
	{
		this.glutenFree = gf;
	}
	
	public boolean isGlutenFree()
	{
		return glutenFree;
	}
	
	public void addToDatabase()
	{
		db.addItemToRecipes(name, ingredients, directions, timeToCook, numServings, calories, carbs, protein, fat,
				bfast, lunch, dinner, snack, vegan, glutenFree);
	}
	
	public void loadFromDatabase(String name) {
		this.name = name;
		
		ResultSet rs = db.getItemFromRecipes(name);
		
		try {
			while(rs.next()) {
				String longIngredients = rs.getString("ingredients");
				String longDirections = rs.getString("directions");
				this.timeToCook = rs.getInt("timeToCook");
				this.numServings = rs.getInt("numServings");
				this.calories = rs.getInt("calories");
				this.carbs = rs.getInt("carbs");
				this.protein = rs.getInt("protein");
				this.fat = rs.getInt("fat");
				
				String[] splitIngredients = longIngredients.split(",");
				String[] splitDirections = longDirections.split("\\n");
				String[] lineSplitDirections;
				
				String formattedIngredients = "";
				for(int i = 0; i < splitIngredients.length; i++) {
					formattedIngredients += splitIngredients[i] + "\n";
				}
				this.ingredients = formattedIngredients;
				
				String formattedDirections = "";
				for(int i = 0; i < splitDirections.length; i++) {
					
					if(splitDirections[i].length() > 85) {
						lineSplitDirections = splitDirections[i].split("(?<=\\G.{85})");
						formattedDirections += (i+1) + ". ";
						
						for(int j = 0; j < lineSplitDirections.length; j++) {
							
							formattedDirections += lineSplitDirections[j];
							if(j < (lineSplitDirections.length - 1)) {
								formattedDirections += "-" + "\n";
							}
							else {
								formattedDirections += "\n";
							}
						}
					}
					else {
						formattedDirections += (i+1) + ". " + splitDirections[i] + "\n";
					}
					
				}
				
				this.directions = formattedDirections;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveToDatabase() {
		
		db.addItemToSavedRecipes(this.name);	
	}
	
	public void unsaveFromDatabase() {
		
		db.deleteItemFromSavedRecipes(this.name);
	}
	
	public String getSavedListFromDatabase() {
		
		return db.getAllSavedRecipes();
	}
}
