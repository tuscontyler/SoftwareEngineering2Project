import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class RecipeGUI {
	
	private DatabaseQueries db;
	private JFrame recipeFrame;
	private JCheckBox[] savedRecipesCB;
	
	public RecipeGUI(DatabaseQueries db) {
		this.db = db;
		recipeFrame = new JFrame();
	}
	
	public void getCurrentSavedRecipesCB() {
		
		Recipe tempRecipe = new Recipe(db);
		String savedRecipesList = tempRecipe.getSavedListFromDatabase();
		String[] split = savedRecipesList.split("\\n");
		
		savedRecipesCB = new JCheckBox[split.length];
		for(int i = 0; i < split.length; i++) {
			savedRecipesCB[i] = new JCheckBox(split[i]);
		}
	}

	public void buildRecipeGUI()
	{
		SpringLayout spring = new SpringLayout();
		recipeFrame.setSize(1400, 800);
		recipeFrame.getContentPane().setLayout(spring);
		recipeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Recipes");
		headerPanel.setBackground(new Color(112,146,85));
		headerPanel.setPreferredSize(new Dimension(1200, 40));
		headerPanel.add(headerLabel);
		
		JButton dailyBtn = new JButton("Today");
		JButton recipeBtn = new JButton("Recipes");
		JButton mealPlanBtn = new JButton("Meal Planning");
		JButton shoppingBtn = new JButton("Shopping List");
		JButton restaurantBtn = new JButton("Restaurant Finder");
		dailyBtn.setBackground(new Color(254,127,45));
		recipeBtn.setBackground(new Color(254,127,45));
		mealPlanBtn.setBackground(new Color(254,127,45));
		shoppingBtn.setBackground(new Color(254,127,45));
		restaurantBtn.setBackground(new Color(254,127,45));
		
		JPanel searchFilterPanel = new JPanel();
		JCheckBox bfastCB = new JCheckBox("Breakfast");
		JCheckBox lunchCB = new JCheckBox("Lunch");
		JCheckBox dinnerCB = new JCheckBox("Dinner");
		JCheckBox glutenCB = new JCheckBox("Gluten-Free");
		JCheckBox veganCB = new JCheckBox("Vegetarian");
		JCheckBox snackCB = new JCheckBox("Snack");
		
		searchFilterPanel.setLayout(new GridLayout(2,3));
		searchFilterPanel.add(bfastCB);
		searchFilterPanel.add(lunchCB);
		searchFilterPanel.add(dinnerCB);
		searchFilterPanel.add(snackCB);
		searchFilterPanel.add(veganCB);
		searchFilterPanel.add(glutenCB);
		searchFilterPanel.setPreferredSize(new Dimension(300, 75));
		
		JTextField searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(450, 30));
		JButton searchBtn = new JButton("Search");
		
		//JPanel userInfoPanel = new JPanel();
		//userInfoPanel.setBackground(new Color(252,202,70));
		//userInfoPanel.setPreferredSize(new Dimension(400, 175));
		
		JPanel savedBckgdPanel = new JPanel();
		JPanel savedRecipesPanel = new JPanel();
		JLabel savedRecipesLabel = new JLabel("My Saved Recipes");
		JButton viewBtn = new JButton("View Recipe");
		JButton addToMealBtn = new JButton("Add to Meal");
		JButton removeBtn = new JButton("Remove from List");
		JButton uploadBtn = new JButton("Upload Recipe");		
		savedBckgdPanel.setBackground(new Color(254,127,45));
		savedBckgdPanel.setPreferredSize(new Dimension(650, 300));
		savedRecipesPanel.setPreferredSize(new Dimension(630, 250));
		
		GridLayout gridLayout = new GridLayout(10,1);
		savedRecipesPanel.setLayout(gridLayout);
		
		getCurrentSavedRecipesCB();
		for(int i = 0; i < savedRecipesCB.length; i++) {
			savedRecipesPanel.add(savedRecipesCB[i]);
		}
		
		savedBckgdPanel.setLayout(spring);
		spring.putConstraint(SpringLayout.NORTH, savedRecipesPanel, 40, SpringLayout.NORTH, savedBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, savedRecipesPanel, 10, SpringLayout.WEST, savedBckgdPanel);
		savedBckgdPanel.add(savedRecipesPanel);
		
		spring.putConstraint(SpringLayout.NORTH, savedRecipesLabel, 15, SpringLayout.NORTH, savedBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, savedRecipesLabel, 10, SpringLayout.WEST, savedBckgdPanel);
		savedBckgdPanel.add(savedRecipesLabel);
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 25, SpringLayout.NORTH, recipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 25, SpringLayout.WEST, recipeFrame.getContentPane());
		recipeFrame.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, dailyBtn, 75, SpringLayout.NORTH, recipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, dailyBtn, 80, SpringLayout.WEST, recipeFrame.getContentPane());
		recipeFrame.getContentPane().add(dailyBtn);
		
		spring.putConstraint(SpringLayout.NORTH, recipeBtn, 75, SpringLayout.NORTH, recipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, recipeBtn, 600, SpringLayout.WEST, dailyBtn);
		recipeFrame.getContentPane().add(recipeBtn);
		
		spring.putConstraint(SpringLayout.NORTH, mealPlanBtn, 75, SpringLayout.NORTH, recipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, mealPlanBtn, 95, SpringLayout.WEST, recipeBtn);
		recipeFrame.getContentPane().add(mealPlanBtn);
		
		spring.putConstraint(SpringLayout.NORTH, shoppingBtn, 75, SpringLayout.NORTH, recipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, shoppingBtn, 130, SpringLayout.WEST, mealPlanBtn);
		recipeFrame.getContentPane().add(shoppingBtn);
		
		spring.putConstraint(SpringLayout.NORTH, restaurantBtn, 75, SpringLayout.NORTH, recipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, restaurantBtn, 130, SpringLayout.WEST, shoppingBtn);
		recipeFrame.getContentPane().add(restaurantBtn);
		
		spring.putConstraint(SpringLayout.NORTH, searchFilterPanel, 50, SpringLayout.SOUTH, dailyBtn);
		spring.putConstraint(SpringLayout.WEST, searchFilterPanel, 100, SpringLayout.WEST, recipeFrame.getContentPane());
		recipeFrame.getContentPane().add(searchFilterPanel);
		
		spring.putConstraint(SpringLayout.NORTH, searchBar, 10, SpringLayout.SOUTH, searchFilterPanel);
		spring.putConstraint(SpringLayout.WEST, searchBar, 100, SpringLayout.WEST, recipeFrame.getContentPane());
		recipeFrame.getContentPane().add(searchBar);
		
		spring.putConstraint(SpringLayout.NORTH, searchBtn, 0, SpringLayout.NORTH, searchBar);
		spring.putConstraint(SpringLayout.WEST, searchBtn, 10, SpringLayout.EAST, searchBar);
		recipeFrame.getContentPane().add(searchBtn);
		
		spring.putConstraint(SpringLayout.NORTH, savedBckgdPanel, 75, SpringLayout.SOUTH, searchBar);
		spring.putConstraint(SpringLayout.WEST, savedBckgdPanel, 50, SpringLayout.WEST, recipeFrame.getContentPane());
		recipeFrame.getContentPane().add(savedBckgdPanel);
		
		//spring.putConstraint(SpringLayout.NORTH, userInfoPanel, -10, SpringLayout.NORTH, searchFilterPanel);
		//spring.putConstraint(SpringLayout.WEST, userInfoPanel, 50, SpringLayout.EAST, searchBtn);
		//recipeFrame.getContentPane().add(userInfoPanel);
		
		spring.putConstraint(SpringLayout.NORTH, viewBtn, 40, SpringLayout.NORTH, savedBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, viewBtn, 10, SpringLayout.EAST, savedBckgdPanel);
		recipeFrame.getContentPane().add(viewBtn);
		
		spring.putConstraint(SpringLayout.NORTH, addToMealBtn, 20, SpringLayout.SOUTH, viewBtn);
		spring.putConstraint(SpringLayout.WEST, addToMealBtn, 10, SpringLayout.EAST, savedBckgdPanel);
		recipeFrame.getContentPane().add(addToMealBtn);
		
		spring.putConstraint(SpringLayout.NORTH, removeBtn, 20, SpringLayout.SOUTH, addToMealBtn);
		spring.putConstraint(SpringLayout.WEST, removeBtn, 10, SpringLayout.EAST, savedBckgdPanel);
		recipeFrame.getContentPane().add(removeBtn);
		
		spring.putConstraint(SpringLayout.SOUTH, uploadBtn, -10, SpringLayout.SOUTH, savedBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, uploadBtn, 10, SpringLayout.EAST, savedBckgdPanel);
		recipeFrame.getContentPane().add(uploadBtn);
		
		recipeFrame.setVisible(true);
		
		dailyBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DayGUI dailyGUI = new DayGUI(db);
				dailyGUI.createTable();
				recipeFrame.dispose();
			}
			
		});
		
		recipeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		shoppingBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ShoppingGUI shoppingGUI = new ShoppingGUI(db);
				shoppingGUI.createTable();
			}
			
		});
		
		mealPlanBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				MealPlanGUI mealplanGUI = new MealPlanGUI(db);
				mealplanGUI.createTable();
				recipeFrame.dispose();
			}
			
		});
		
		restaurantBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				RestaurantGUI restaurantGUI = new RestaurantGUI(db);
				restaurantGUI.createTable();
			}

		});
		
		searchBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String test = searchBar.getText();
				boolean[] filters = {bfastCB.isSelected(), lunchCB.isSelected(), dinnerCB.isSelected(), 
						snackCB.isSelected(), veganCB.isSelected(), glutenCB.isSelected()};
				
				buildSearchRecipeGUI(test, filters, spring, savedBckgdPanel, savedRecipesPanel);
			}
			
		});
		
		viewBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < savedRecipesCB.length; i++) {
					
					if(savedRecipesCB[i].isSelected()) {
						buildViewRecipeGUI(savedRecipesCB[i].getText());
					}
				}
				
			}
			
		});
		
		uploadBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildUploadRecipeGUI();
			}
			
		});
		
		removeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				for(int i = 0; i < savedRecipesCB.length; i++) {
					
					if(savedRecipesCB[i].isSelected()) {
						Recipe savedRecipe = new Recipe(db);
						savedRecipe.setName(savedRecipesCB[i].getText());
						savedRecipe.unsaveFromDatabase();
					}
				}
				
				savedBckgdPanel.remove(savedRecipesPanel);
				savedRecipesPanel.removeAll();
				GridLayout newGridLayout = new GridLayout(10,1);
				savedRecipesPanel.setLayout(newGridLayout);
				
				getCurrentSavedRecipesCB();
				
				for(int j = 0; j < savedRecipesCB.length; j++) {
					savedRecipesPanel.add(savedRecipesCB[j]);
				}
				
				spring.putConstraint(SpringLayout.NORTH, savedRecipesPanel, 40, SpringLayout.NORTH, savedBckgdPanel);
				spring.putConstraint(SpringLayout.WEST, savedRecipesPanel, 10, SpringLayout.WEST, savedBckgdPanel);
				savedBckgdPanel.add(savedRecipesPanel);

				savedBckgdPanel.validate();
				savedBckgdPanel.repaint();
			}
		});
		
	}
	
	public void buildSearchRecipeGUI(String searchString, boolean[] filters, SpringLayout spr, JPanel panel, JPanel listPanel)
	{
		JFrame searchRecipeFrame = new JFrame();
		SpringLayout spring = new SpringLayout();
		searchRecipeFrame.setLayout(spring);
		searchRecipeFrame.setSize(800, 650);
		searchRecipeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchRecipeFrame.setLocationRelativeTo(null);
	
		JButton saveBtn = new JButton("Save Recipe");
		JButton cancelBtn = new JButton("Cancel");
		
		JTable dbTable = new JTable() {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int col, java.util.EventObject e) {
        		return false;
        	}
        };
		
        JScrollPane scrollPane = new JScrollPane(dbTable);
        scrollPane.setPreferredSize(new Dimension(650, 550));
        dbTable.setPreferredSize(new Dimension(620, 550));
		DefaultTableModel tableModel = new DefaultTableModel();
		dbTable.setAutoCreateColumnsFromModel(true);
		String[] cols = {"Name", "Time (min)", "Servings", "Calories", "Carbs (g)", "Protein (g)", "Fat (g)"};
		
		for(int i = 0; i < cols.length; i++) {
			tableModel.addColumn(cols[i]);
		}
		
		dbTable.getTableHeader().setReorderingAllowed(false);
		dbTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					
					String name = dbTable.getValueAt(dbTable.getSelectedRow(), 0).toString();
					Recipe recipeToSave = new Recipe(db);
					recipeToSave.setName(name);
					recipeToSave.saveToDatabase();
				}

			}
        });
		
		ResultSet rs = db.issueSearchRecipeQuery(searchString, filters);
		
		try {
			while(rs.next()) {
				String recipeName = rs.getString("recipeName");
				int timeToCook = rs.getInt("timeToCook");
				int numServings = rs.getInt("numServings");
				int calories = rs.getInt("calories");
				int carbs = rs.getInt("carbs");
				int protein = rs.getInt("protein");
				int fat = rs.getInt("fat");
				
				tableModel.insertRow(0, new Object[] {recipeName, timeToCook, numServings, calories, carbs, protein, fat});
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		dbTable.setModel(tableModel);
		dbTable.getColumnModel().getColumn(0).setPreferredWidth(250);
		
		
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Search Results");
		headerPanel.setBackground(new Color(112,146,85));
		headerPanel.setPreferredSize(new Dimension(760, 30));
		headerPanel.add(headerLabel);
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 10, SpringLayout.NORTH, searchRecipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 10, SpringLayout.WEST, searchRecipeFrame.getContentPane());
		searchRecipeFrame.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, searchRecipeFrame.getContentPane());
		searchRecipeFrame.getContentPane().add(scrollPane);
		
		spring.putConstraint(SpringLayout.WEST, cancelBtn, 10, SpringLayout.EAST, scrollPane);
		spring.putConstraint(SpringLayout.SOUTH, cancelBtn, 0, SpringLayout.SOUTH, scrollPane);
		searchRecipeFrame.getContentPane().add(cancelBtn);
		
		spring.putConstraint(SpringLayout.WEST, saveBtn, 10, SpringLayout.EAST, scrollPane);
		spring.putConstraint(SpringLayout.SOUTH, saveBtn, -10, SpringLayout.NORTH, cancelBtn);
		searchRecipeFrame.getContentPane().add(saveBtn);
		
		searchRecipeFrame.setVisible(true);
		
		saveBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				searchRecipeFrame.dispose();
				
				panel.remove(listPanel);
				listPanel.removeAll();
				GridLayout gridLayout = new GridLayout(10,1);
				listPanel.setLayout(gridLayout);
				
				getCurrentSavedRecipesCB();
				
				for(int i = 0; i < savedRecipesCB.length; i++) {
					listPanel.add(savedRecipesCB[i]);
				}
				
				spr.putConstraint(SpringLayout.NORTH, listPanel, 40, SpringLayout.NORTH, panel);
				spr.putConstraint(SpringLayout.WEST, listPanel, 10, SpringLayout.WEST, panel);
				panel.add(listPanel);

				panel.validate();
				panel.repaint();
			}
			
		});

		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				searchRecipeFrame.dispose();
			}
			
		});
		
	}
	
	public void buildUploadRecipeGUI()
	{
		SpringLayout spring = new SpringLayout();
		JFrame uploadRecipeFrame = new JFrame();
		uploadRecipeFrame.setSize(900, 800);
		uploadRecipeFrame.getContentPane().setLayout(spring);
		uploadRecipeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		uploadRecipeFrame.setLocationRelativeTo(null);
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Upload A Recipe");
		headerPanel.setBackground(new Color(112,146,85));
		headerPanel.setPreferredSize(new Dimension(850,40));
		headerPanel.add(headerLabel);
		
		JButton saveBtn = new JButton("Save");
		JButton cancelBtn = new JButton("Cancel");
		
		JPanel inputBckgdPanel = new JPanel();
		inputBckgdPanel.setBackground(new Color(254,127,45));
		inputBckgdPanel.setPreferredSize(new Dimension(750,575));
		JPanel recipeInfoPanel = new JPanel();
		recipeInfoPanel.setLayout(new GridLayout(8,2,10,2));
		recipeInfoPanel.setPreferredSize(new Dimension(530, 200));
		
		JLabel nameLabel = new JLabel("  Recipe Name: ");
		JLabel timeLabel = new JLabel("  Time to Cook: ");
		JLabel servingLabel = new JLabel("  Servings: ");
		JLabel perServingLabel = new JLabel("  Nutritional Info (per serving)");
		JLabel calLabel = new JLabel("  Calories: ");
		JLabel carbLabel = new JLabel("  Carbs (g): ");
		JLabel proteinLabel = new JLabel("  Protein (g): ");
		JLabel fatLabel = new JLabel("  Fat (g): ");
		JLabel blank = new JLabel("");
		
		JTextField nameTF = new JTextField();
		JTextField timeTF = new JTextField();
		JTextField servingTF = new JTextField();
		JTextField calTF = new JTextField();
		JTextField carbTF = new JTextField();
		JTextField proteinTF = new JTextField();
		JTextField fatTF = new JTextField();
		
		recipeInfoPanel.add(nameLabel);
		recipeInfoPanel.add(nameTF);
		recipeInfoPanel.add(timeLabel);
		recipeInfoPanel.add(timeTF);
		recipeInfoPanel.add(servingLabel);
		recipeInfoPanel.add(servingTF);
		recipeInfoPanel.add(perServingLabel);
		recipeInfoPanel.add(blank);
		recipeInfoPanel.add(calLabel);
		recipeInfoPanel.add(calTF);
		recipeInfoPanel.add(carbLabel);
		recipeInfoPanel.add(carbTF);
		recipeInfoPanel.add(proteinLabel);
		recipeInfoPanel.add(proteinTF);
		recipeInfoPanel.add(fatLabel);
		recipeInfoPanel.add(fatTF);
		
		JPanel ingredientsPanel = new JPanel();
		ingredientsPanel.setBackground(new Color(254,127,45));
		ingredientsPanel.setPreferredSize(new Dimension(260,320));
		ingredientsPanel.setLayout(new GridLayout(15,1,0,2));
		JLabel ingredientsLabel = new JLabel("Ingredients");
		JTextField[] ingredients = new JTextField[15];
		
		for(int i = 0; i < ingredients.length; i++) {
			
			ingredients[i] = new JTextField();
			ingredientsPanel.add(ingredients[i]);
		}
		
		JPanel directionsPanel = new JPanel();
		directionsPanel.setBackground(new Color(254,127,45));
		directionsPanel.setPreferredSize(new Dimension(410,310));
		directionsPanel.setLayout(new GridLayout(8,1,0,5));
		JLabel directionsLabel = new JLabel("Directions (No need to number them, we'll do it for you!)");
		JTextField[] directions = new JTextField[8];
		
		for(int i = 0; i < directions.length; i++) {
			
			directions[i] = new JTextField();
			directions[i].setPreferredSize(new Dimension(410,45));
			directionsPanel.add(directions[i]);
		}
		
		//ingredientsTF.setPreferredSize(new Dimension(250, 300));
		//directionsTF.setPreferredSize(new Dimension(400, 300));
		
		JPanel filterCBPanel = new JPanel();
		filterCBPanel.setPreferredSize(new Dimension(150, 200));
		filterCBPanel.setLayout(new GridLayout(7,1));
		JLabel filterLabel = new JLabel("Filters");
		JCheckBox bfastCB = new JCheckBox("Breakfast");
		JCheckBox lunchCB = new JCheckBox("Lunch");
		JCheckBox dinnerCB = new JCheckBox("Dinner");
		JCheckBox snackCB = new JCheckBox("Snack");
		JCheckBox veganCB = new JCheckBox("Vegetarian");
		JCheckBox glutenFreeCB = new JCheckBox("Gluten Free");
		filterCBPanel.add(filterLabel);
		filterCBPanel.add(bfastCB);
		filterCBPanel.add(lunchCB);
		filterCBPanel.add(dinnerCB);
		filterCBPanel.add(snackCB);
		filterCBPanel.add(veganCB);
		filterCBPanel.add(glutenFreeCB);
		
		inputBckgdPanel.setLayout(spring);
		spring.putConstraint(SpringLayout.NORTH, recipeInfoPanel, 10, SpringLayout.NORTH, inputBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, recipeInfoPanel, 10, SpringLayout.WEST, inputBckgdPanel);
		inputBckgdPanel.add(recipeInfoPanel);
		
		spring.putConstraint(SpringLayout.NORTH, filterCBPanel, 0, SpringLayout.NORTH, recipeInfoPanel);
		spring.putConstraint(SpringLayout.WEST, filterCBPanel, 20, SpringLayout.EAST, recipeInfoPanel);
		inputBckgdPanel.add(filterCBPanel);
		
		spring.putConstraint(SpringLayout.NORTH, ingredientsLabel, 10, SpringLayout.SOUTH, recipeInfoPanel);
		spring.putConstraint(SpringLayout.WEST, ingredientsLabel, 10, SpringLayout.WEST, inputBckgdPanel);
		inputBckgdPanel.add(ingredientsLabel);
		
		spring.putConstraint(SpringLayout.NORTH, ingredientsPanel, 5, SpringLayout.SOUTH, ingredientsLabel);
		spring.putConstraint(SpringLayout.WEST, ingredientsPanel, 0, SpringLayout.WEST, ingredientsLabel);
		inputBckgdPanel.add(ingredientsPanel);
		
		spring.putConstraint(SpringLayout.NORTH, directionsLabel, 0, SpringLayout.NORTH, ingredientsLabel);
		spring.putConstraint(SpringLayout.WEST, directionsLabel, 20, SpringLayout.EAST, ingredientsPanel);
		inputBckgdPanel.add(directionsLabel);
		
		spring.putConstraint(SpringLayout.NORTH, directionsPanel, 5, SpringLayout.SOUTH, directionsLabel);
		spring.putConstraint(SpringLayout.WEST, directionsPanel, 0, SpringLayout.WEST, directionsLabel);
		inputBckgdPanel.add(directionsPanel);
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 25, SpringLayout.NORTH, uploadRecipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 15, SpringLayout.WEST, uploadRecipeFrame.getContentPane());
		uploadRecipeFrame.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, inputBckgdPanel, 10, SpringLayout.SOUTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, inputBckgdPanel, 0, SpringLayout.WEST, headerPanel);
		uploadRecipeFrame.getContentPane().add(inputBckgdPanel);
		
		spring.putConstraint(SpringLayout.SOUTH, cancelBtn, -25, SpringLayout.SOUTH, uploadRecipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, cancelBtn, 10, SpringLayout.EAST, inputBckgdPanel);
		uploadRecipeFrame.getContentPane().add(cancelBtn);
		
		spring.putConstraint(SpringLayout.SOUTH, saveBtn, -10, SpringLayout.NORTH, cancelBtn);
		spring.putConstraint(SpringLayout.WEST, saveBtn, 0, SpringLayout.WEST, cancelBtn);
		uploadRecipeFrame.getContentPane().add(saveBtn);

		
		uploadRecipeFrame.setVisible(true);
		
		saveBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Recipe newRecipe = new Recipe(db);
				newRecipe.setName(nameTF.getText());
				
				String ingredientsString = "";
				for(int i = 0; i < ingredients.length; i++) {
					
					if(!ingredients[i].getText().equalsIgnoreCase("")) {
						ingredientsString += ingredients[i].getText() + ",";
					}
				}
				newRecipe.setIngredients(ingredientsString);
				
				String directionsString = "";
				for(int i = 0; i < directions.length; i++) {
					
					if(!ingredients[i].getText().equalsIgnoreCase("")) {
						directionsString += directions[i].getText() + "\n";
					}
				}
				newRecipe.setDirections(directionsString);
				
				newRecipe.setTimeToCook(Integer.parseInt(timeTF.getText()));
				newRecipe.setNumServings(Integer.parseInt(servingTF.getText()));
				newRecipe.setCalories(Integer.parseInt(calTF.getText()));
				newRecipe.setCarbs(Integer.parseInt(carbTF.getText()));
				newRecipe.setProtein(Integer.parseInt(proteinTF.getText()));
				newRecipe.setFat(Integer.parseInt(fatTF.getText()));
				newRecipe.setBfast(bfastCB.isSelected());
				newRecipe.setLunch(lunchCB.isSelected());
				newRecipe.setDinner(dinnerCB.isSelected());
				newRecipe.setSnack(snackCB.isSelected());
				newRecipe.setVegan(veganCB.isSelected());
				newRecipe.setGlutenFree(glutenFreeCB.isSelected());
				newRecipe.addToDatabase();
				
				System.out.println(ingredientsString);
				System.out.println(directionsString);
				
				uploadRecipeFrame.dispose();
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				uploadRecipeFrame.dispose();
			}
			
		});

	}
	
	public void buildViewRecipeGUI(String recipeName)
	{
		SpringLayout spring = new SpringLayout();
		JFrame viewRecipeFrame = new JFrame();
		viewRecipeFrame.setSize(700, 800);
		viewRecipeFrame.getContentPane().setLayout(spring);
		viewRecipeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewRecipeFrame.setLocationRelativeTo(null);
		viewRecipeFrame.setResizable(false);
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel(recipeName);
		headerPanel.setBackground(new Color(112,146,85));
		headerPanel.setPreferredSize(new Dimension(600, 40));
		headerPanel.add(headerLabel);
		
		JPanel ingredientsBckgd = new JPanel();
		ingredientsBckgd.setBackground(new Color(254,127,45));
		ingredientsBckgd.setPreferredSize(new Dimension(350, 270));
		JTextArea ingredientsTA = new JTextArea();
		JLabel ingredientsLabel = new JLabel("Ingredients");
		ingredientsTA.setPreferredSize(new Dimension(330, 230));
		ingredientsTA.setEditable(false);
		ingredientsBckgd.setLayout(spring);
		
		JPanel directionsBckgd = new JPanel();
		directionsBckgd.setBackground(new Color(254,127,45));
		directionsBckgd.setPreferredSize(new Dimension(500, 250));
		JTextArea directionsTA = new JTextArea();
		JLabel directionsLabel = new JLabel("Directions");
		directionsTA.setPreferredSize(new Dimension(480, 210));
		directionsTA.setEditable(false);
		directionsBckgd.setLayout(spring);
		
		spring.putConstraint(SpringLayout.NORTH, ingredientsTA, 30, SpringLayout.NORTH, ingredientsBckgd);
		spring.putConstraint(SpringLayout.WEST, ingredientsTA, 10, SpringLayout.WEST, ingredientsBckgd);
		ingredientsBckgd.add(ingredientsTA);
		
		spring.putConstraint(SpringLayout.NORTH, ingredientsLabel, 10, SpringLayout.NORTH, ingredientsBckgd);
		spring.putConstraint(SpringLayout.WEST, ingredientsLabel, 10, SpringLayout.WEST, ingredientsBckgd);
		ingredientsBckgd.add(ingredientsLabel);
		
		spring.putConstraint(SpringLayout.NORTH, directionsTA, 30, SpringLayout.NORTH, directionsBckgd);
		spring.putConstraint(SpringLayout.WEST, directionsTA, 10, SpringLayout.WEST, directionsBckgd);
		directionsBckgd.add(directionsTA);
		
		spring.putConstraint(SpringLayout.NORTH, directionsLabel, 10, SpringLayout.NORTH, directionsBckgd);
		spring.putConstraint(SpringLayout.WEST, directionsLabel, 10, SpringLayout.WEST, directionsBckgd);
		directionsBckgd.add(directionsLabel);
		
		JPanel detailsBckgdPanel = new JPanel();
		JTextArea detailsTA = new JTextArea();
		JLabel detailsLabel = new JLabel("Recipe Details");
		detailsBckgdPanel.setBackground(new Color(252,202,70));
		detailsBckgdPanel.setPreferredSize(new Dimension(200, 270));
		detailsTA.setPreferredSize(new Dimension(180, 230));
		detailsBckgdPanel.setLayout(spring);
		
		Recipe recipeToView = new Recipe(db);
		recipeToView.loadFromDatabase(recipeName);
		
		ingredientsTA.setText(recipeToView.getIngredients());
		directionsTA.setText(recipeToView.getDirections());
				
		detailsTA.setText("\n  Time to Cook: " + recipeToView.getTimeToCook() + " min"
				+ "\n\n  Servings: " + recipeToView.getNumServings() 
				+ "\n\n  Per Serving"
				+ "\n      Calories: " + recipeToView.getCalories()
				+ "\n      Carbs: " + recipeToView.getCarbs() + " g"
				+ "\n      Protein: " + recipeToView.getProtein() + " g"
				+ "\n      Fat: " + recipeToView.getFat() + " g");
		
		spring.putConstraint(SpringLayout.NORTH, detailsTA, 30, SpringLayout.NORTH, detailsBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, detailsTA, 10, SpringLayout.WEST, detailsBckgdPanel);
		detailsBckgdPanel.add(detailsTA);
		
		spring.putConstraint(SpringLayout.NORTH, detailsLabel, 10, SpringLayout.NORTH, detailsBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, detailsLabel, 10, SpringLayout.WEST, detailsBckgdPanel);
		detailsBckgdPanel.add(detailsLabel);
	
		JButton closeBtn = new JButton("Close");
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 30, SpringLayout.NORTH, viewRecipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 25, SpringLayout.WEST, viewRecipeFrame.getContentPane());
		viewRecipeFrame.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, ingredientsBckgd, 75, SpringLayout.NORTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, ingredientsBckgd, 50, SpringLayout.WEST, viewRecipeFrame.getContentPane());
		viewRecipeFrame.getContentPane().add(ingredientsBckgd);
		
		spring.putConstraint(SpringLayout.NORTH, detailsBckgdPanel, 75, SpringLayout.NORTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, detailsBckgdPanel, 40, SpringLayout.EAST, ingredientsBckgd);
		viewRecipeFrame.getContentPane().add(detailsBckgdPanel);
		
		spring.putConstraint(SpringLayout.NORTH, directionsBckgd, 20, SpringLayout.SOUTH, ingredientsBckgd);
		spring.putConstraint(SpringLayout.WEST, directionsBckgd, 50, SpringLayout.WEST, viewRecipeFrame.getContentPane());
		viewRecipeFrame.getContentPane().add(directionsBckgd);
		
		spring.putConstraint(SpringLayout.SOUTH, closeBtn, -60, SpringLayout.SOUTH, viewRecipeFrame.getContentPane());
		spring.putConstraint(SpringLayout.EAST, closeBtn, -10, SpringLayout.EAST, detailsBckgdPanel);
		viewRecipeFrame.getContentPane().add(closeBtn);
		
		viewRecipeFrame.setVisible(true);
		
		closeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				viewRecipeFrame.dispose();
			}
			
		});
	}
}
