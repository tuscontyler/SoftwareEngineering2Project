import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn; 

public class MealPlanGUI {

	
	public DatabaseQueries db;
		
	public MealPlanGUI(DatabaseQueries db) {
		this.db = db;
	}
		
	public void createTable() {
		
		SpringLayout springLayout = new SpringLayout();
		JFrame mealPlanFrame = new JFrame();
		mealPlanFrame.setSize(1400, 800);
		mealPlanFrame.getContentPane().setLayout(springLayout);
		mealPlanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel helloPanel = new JPanel();
		JLabel helloLabel = new JLabel("Meal Planner");
		helloPanel.setBackground(new Color(112,146,85));
		helloPanel.setPreferredSize(new Dimension(1200, 40));
		helloPanel.add(helloLabel);
		
		JButton dayBtn = new JButton("Day");
		JButton recipeBtn = new JButton("Recipes");
		JButton mealPlanBtn = new JButton("Meal Planning");
		JButton shoppingBtn = new JButton("Shopping List");
		JButton restaurantBtn = new JButton("Restaurant Finder");
		JButton createMealBtn = new JButton("Create Meal Plan");
		
		JButton mAddButton = new JButton("Add");
		JButton mRemoveButton = new JButton("Remove");
		JButton tAddButton = new JButton("Add");
		JButton tRemoveButton = new JButton("Remove");
		JButton wAddButton = new JButton("Add");
		JButton wRemoveButton = new JButton("Remove");
		JButton thAddButton = new JButton("Add");
		JButton thRemoveButton = new JButton("Remove");
		JButton fAddButton = new JButton("Add");
		JButton fRemoveButton = new JButton("Remove");
		JButton satAddButton = new JButton("Add");
		JButton satRemoveButton = new JButton("Remove");
		JButton sunAddButton = new JButton("Add");
		JButton sunRemoveButton = new JButton("Remove");
		
		dayBtn.setBackground(new Color(254,127,45));
		recipeBtn.setBackground(new Color(254,127,45));
		mealPlanBtn.setBackground(new Color(254,127,45));
		shoppingBtn.setBackground(new Color(254,127,45));
		restaurantBtn.setBackground(new Color(254,127,45));
		mAddButton.setBackground(new Color(112,146,85));
		mRemoveButton.setBackground(new Color(112,146,85));
		tAddButton.setBackground(new Color(112,146,85));
		tRemoveButton.setBackground(new Color(112,146,85));
		wAddButton.setBackground(new Color(112,146,85));
		wRemoveButton.setBackground(new Color(112,146,85));
		thAddButton.setBackground(new Color(112,146,85));
		thRemoveButton.setBackground(new Color(112,146,85));
		fAddButton.setBackground(new Color(112,146,85));
		fRemoveButton.setBackground(new Color(112,146,85));
		satAddButton.setBackground(new Color(112,146,85));
		satRemoveButton.setBackground(new Color(112,146,85));
		sunAddButton.setBackground(new Color(112,146,85));
		sunRemoveButton.setBackground(new Color(112,146,85));
		createMealBtn.setBackground(new Color(112,146,85));
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(new Color(252,202,70));
		
		//Monday Panel===================================================================================
		JPanel MondayLogPanel = new JPanel();
		JTextArea MondayLogText = new JTextArea();
		JLabel MondayLogLabel = new JLabel("Monday Meal Plan");
		MondayLogPanel.setBackground(new Color(254,127,45));
		MondayLogPanel.setPreferredSize(new Dimension(300, 160));
		MondayLogText.setPreferredSize(new Dimension(280, 120));
		MondayLogText.setText(db.getAllFoods("monday"));
		MondayLogText.setEditable(false);
		MondayLogPanel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, MondayLogText, 30, SpringLayout.NORTH, MondayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, MondayLogText, 10, SpringLayout.NORTH, MondayLogPanel);
		MondayLogPanel.add(MondayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, MondayLogLabel, 10, SpringLayout.NORTH, MondayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, MondayLogLabel, 10, SpringLayout.WEST, MondayLogPanel);
		MondayLogPanel.add(MondayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, MondayLogPanel, 60, SpringLayout.SOUTH, helloPanel);
		springLayout.putConstraint(SpringLayout.WEST, MondayLogPanel, 20, SpringLayout.WEST, mealPlanFrame.getContentPane());
		mealPlanFrame.add(MondayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, mAddButton, 0, SpringLayout.NORTH, MondayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, mAddButton, 5, SpringLayout.EAST, MondayLogPanel);
		mealPlanFrame.getContentPane().add(mAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, mRemoveButton, 10, SpringLayout.SOUTH, mAddButton);
		springLayout.putConstraint(SpringLayout.WEST, mRemoveButton, 5, SpringLayout.EAST, MondayLogPanel);
		mealPlanFrame.getContentPane().add(mRemoveButton);
		
		//Tuesday Panel=================================================================================
		JPanel TuesdayLogPanel = new JPanel();
		JTextArea TuesdayLogText = new JTextArea();
		JLabel TuesdayLogLabel = new JLabel("Tuesday Meal Plan");
		TuesdayLogPanel.setBackground(new Color(254,127,45));
		TuesdayLogPanel.setPreferredSize(new Dimension(300, 160));
		TuesdayLogText.setPreferredSize(new Dimension(280, 120));
		TuesdayLogText.setText(db.getAllFoods("tuesday"));
		TuesdayLogText.setEditable(false);
		TuesdayLogPanel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, TuesdayLogText, 30, SpringLayout.NORTH, TuesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, TuesdayLogText, 10, SpringLayout.NORTH, TuesdayLogPanel);
		TuesdayLogPanel.add(TuesdayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, TuesdayLogLabel, 10, SpringLayout.NORTH, TuesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, TuesdayLogLabel, 10, SpringLayout.WEST, TuesdayLogPanel);
		TuesdayLogPanel.add(TuesdayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, TuesdayLogPanel, 20, SpringLayout.SOUTH, MondayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, TuesdayLogPanel, 0, SpringLayout.WEST, MondayLogPanel);
		mealPlanFrame.add(TuesdayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, tAddButton, 0, SpringLayout.NORTH, TuesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, tAddButton, 5, SpringLayout.EAST, TuesdayLogPanel);
		mealPlanFrame.getContentPane().add(tAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, tRemoveButton, 10, SpringLayout.SOUTH, tAddButton);
		springLayout.putConstraint(SpringLayout.WEST, tRemoveButton, 5, SpringLayout.EAST, TuesdayLogPanel);
		mealPlanFrame.getContentPane().add(tRemoveButton);
		
		//Wednesday Panel===============================================================================
		JPanel WednesdayLogPanel = new JPanel();
		JTextArea WednesdayLogText = new JTextArea();
		JLabel WednesdayLogLabel = new JLabel("Wednesday Meal Plan");
		WednesdayLogPanel.setBackground(new Color(254,127,45));
		WednesdayLogPanel.setPreferredSize(new Dimension(300, 160));
		WednesdayLogText.setPreferredSize(new Dimension(280, 120));
		WednesdayLogText.setText(db.getAllFoods("wednesday"));
		WednesdayLogText.setEditable(false);
		WednesdayLogPanel.setLayout(springLayout);

		springLayout.putConstraint(SpringLayout.NORTH, WednesdayLogText, 30, SpringLayout.NORTH, WednesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, WednesdayLogText, 10, SpringLayout.NORTH, WednesdayLogPanel);
		WednesdayLogPanel.add(WednesdayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, WednesdayLogLabel, 10, SpringLayout.NORTH, WednesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, WednesdayLogLabel, 10, SpringLayout.WEST, WednesdayLogPanel);
		WednesdayLogPanel.add(WednesdayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, WednesdayLogPanel, 20, SpringLayout.SOUTH, TuesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, WednesdayLogPanel, 0, SpringLayout.WEST, TuesdayLogPanel);
		mealPlanFrame.add(WednesdayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, wAddButton, 0, SpringLayout.NORTH, WednesdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, wAddButton, 5, SpringLayout.EAST, WednesdayLogPanel);
		mealPlanFrame.getContentPane().add(wAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, wRemoveButton, 10, SpringLayout.SOUTH, wAddButton);
		springLayout.putConstraint(SpringLayout.WEST, wRemoveButton, 5, SpringLayout.EAST, WednesdayLogPanel);
		mealPlanFrame.getContentPane().add(wRemoveButton);
		
		//Thursday Panel==================================================================================
		JPanel ThursdayLogPanel = new JPanel();
		JTextArea ThursdayLogText = new JTextArea();
		JLabel ThursdayLogLabel = new JLabel("Thursday Meal Plan");
		ThursdayLogPanel.setBackground(new Color(254,127,45));
		ThursdayLogPanel.setPreferredSize(new Dimension(300, 160));
		ThursdayLogText.setPreferredSize(new Dimension(280, 120));
		ThursdayLogText.setText(db.getAllFoods("thursday"));
		ThursdayLogText.setEditable(false);
		ThursdayLogPanel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, ThursdayLogText, 30, SpringLayout.NORTH, ThursdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, ThursdayLogText, 10, SpringLayout.NORTH, ThursdayLogPanel);
		ThursdayLogPanel.add(ThursdayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, ThursdayLogLabel, 10, SpringLayout.NORTH, ThursdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, ThursdayLogLabel, 10, SpringLayout.WEST, ThursdayLogPanel);
		ThursdayLogPanel.add(ThursdayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, ThursdayLogPanel, 0, SpringLayout.NORTH, MondayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, ThursdayLogPanel, 50, SpringLayout.EAST, mAddButton);
		mealPlanFrame.add(ThursdayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, thAddButton, 0, SpringLayout.NORTH, ThursdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, thAddButton, 5, SpringLayout.EAST, ThursdayLogPanel);
		mealPlanFrame.getContentPane().add(thAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, thRemoveButton, 10, SpringLayout.SOUTH, thAddButton);
		springLayout.putConstraint(SpringLayout.WEST, thRemoveButton, 5, SpringLayout.EAST, ThursdayLogPanel);
		mealPlanFrame.getContentPane().add(thRemoveButton);
		
		//Friday Panel====================================================================================
		JPanel FridayLogPanel = new JPanel();
		JTextArea FridayLogText = new JTextArea();
		JLabel FridayLogLabel = new JLabel("Friday Meal Plan");
		FridayLogPanel.setBackground(new Color(254,127,45));
		FridayLogPanel.setPreferredSize(new Dimension(300, 160));
		FridayLogText.setPreferredSize(new Dimension(280, 120));
		FridayLogText.setText(db.getAllFoods("friday"));
		FridayLogText.setEditable(false);
		FridayLogPanel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, FridayLogText, 30, SpringLayout.NORTH, FridayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, FridayLogText, 10, SpringLayout.NORTH, FridayLogPanel);
		FridayLogPanel.add(FridayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, FridayLogLabel, 10, SpringLayout.NORTH, FridayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, FridayLogLabel, 10, SpringLayout.WEST, FridayLogPanel);
		FridayLogPanel.add(FridayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, FridayLogPanel, 20, SpringLayout.SOUTH, ThursdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, FridayLogPanel, 0, SpringLayout.WEST, ThursdayLogPanel);
		mealPlanFrame.add(FridayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, fAddButton, 0, SpringLayout.NORTH, FridayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, fAddButton, 5, SpringLayout.EAST, FridayLogPanel);
		mealPlanFrame.getContentPane().add(fAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, fRemoveButton, 10, SpringLayout.SOUTH, fAddButton);
		springLayout.putConstraint(SpringLayout.WEST, fRemoveButton, 5, SpringLayout.EAST, FridayLogPanel);
		mealPlanFrame.getContentPane().add(fRemoveButton);
		
		//Saturday Panel====================================================================================
		JPanel SaturdayLogPanel = new JPanel();
		JTextArea SaturdayLogText = new JTextArea();
		JLabel SaturdayLogLabel = new JLabel("Saturday Meal Plan");
		SaturdayLogPanel.setBackground(new Color(254,127,45));
		SaturdayLogPanel.setPreferredSize(new Dimension(300, 160));
		SaturdayLogText.setPreferredSize(new Dimension(280, 120));
		SaturdayLogText.setText(db.getAllFoods("saturday"));
		SaturdayLogText.setEditable(false);
		SaturdayLogPanel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, SaturdayLogText, 30, SpringLayout.NORTH, SaturdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, SaturdayLogText, 10, SpringLayout.NORTH, SaturdayLogPanel);
		SaturdayLogPanel.add(SaturdayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, SaturdayLogLabel, 10, SpringLayout.NORTH, SaturdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, SaturdayLogLabel, 10, SpringLayout.WEST, SaturdayLogPanel);
		SaturdayLogPanel.add(SaturdayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, SaturdayLogPanel, 0, SpringLayout.NORTH, MondayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, SaturdayLogPanel, 50, SpringLayout.EAST, thAddButton);
		mealPlanFrame.add(SaturdayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, satAddButton, 0, SpringLayout.NORTH, SaturdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, satAddButton, 5, SpringLayout.EAST, SaturdayLogPanel);
		mealPlanFrame.getContentPane().add(satAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, satRemoveButton, 10, SpringLayout.SOUTH, satAddButton);
		springLayout.putConstraint(SpringLayout.WEST, satRemoveButton, 5, SpringLayout.EAST, SaturdayLogPanel);
		mealPlanFrame.getContentPane().add(satRemoveButton);
		
		//Sunday Panel====================================================================================
		JPanel SundayLogPanel = new JPanel();
		JTextArea SundayLogText = new JTextArea();
		JLabel SundayLogLabel = new JLabel("Sunday Meal Plan");
		SundayLogPanel.setBackground(new Color(254,127,45));
		SundayLogPanel.setPreferredSize(new Dimension(300, 160));
		SundayLogText.setPreferredSize(new Dimension(280, 120));
		SundayLogText.setText(db.getAllFoods("sunday"));
		SundayLogText.setEditable(false);
		SundayLogPanel.setLayout(springLayout);
		
		springLayout.putConstraint(SpringLayout.NORTH, SundayLogText, 30, SpringLayout.NORTH, SundayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, SundayLogText, 10, SpringLayout.NORTH, SundayLogPanel);
		SundayLogPanel.add(SundayLogText);
		
		springLayout.putConstraint(SpringLayout.NORTH, SundayLogLabel, 10, SpringLayout.NORTH, SundayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, SundayLogLabel, 10, SpringLayout.WEST, SundayLogPanel);
		SundayLogPanel.add(SundayLogLabel);
		
		springLayout.putConstraint(SpringLayout.NORTH, SundayLogPanel, 20, SpringLayout.SOUTH, SaturdayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, SundayLogPanel, 0, SpringLayout.WEST, SaturdayLogPanel);
		mealPlanFrame.add(SundayLogPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, sunAddButton, 0, SpringLayout.NORTH, SundayLogPanel);
		springLayout.putConstraint(SpringLayout.WEST, sunAddButton, 5, SpringLayout.EAST, SundayLogPanel);
		mealPlanFrame.getContentPane().add(sunAddButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, sunRemoveButton, 10, SpringLayout.SOUTH, sunAddButton);
		springLayout.putConstraint(SpringLayout.WEST, sunRemoveButton, 5, SpringLayout.EAST, SundayLogPanel);
		mealPlanFrame.getContentPane().add(sunRemoveButton);
		
		//Buttons along top
		
		springLayout.putConstraint(SpringLayout.NORTH, helloPanel, 25, SpringLayout.NORTH, mealPlanFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, helloPanel, 25, SpringLayout.WEST, mealPlanFrame.getContentPane());
		mealPlanFrame.getContentPane().add(helloPanel);
		
		springLayout.putConstraint(SpringLayout.NORTH, dayBtn, 75, SpringLayout.NORTH, mealPlanFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dayBtn, 80, SpringLayout.WEST, mealPlanFrame.getContentPane());
		mealPlanFrame.getContentPane().add(dayBtn);
		
		springLayout.putConstraint(SpringLayout.NORTH, recipeBtn, 75, SpringLayout.NORTH, mealPlanFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, recipeBtn, 600, SpringLayout.WEST, dayBtn);
		mealPlanFrame.getContentPane().add(recipeBtn);
		
		springLayout.putConstraint(SpringLayout.NORTH, mealPlanBtn, 75, SpringLayout.NORTH, mealPlanFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mealPlanBtn, 95, SpringLayout.WEST, recipeBtn);
		mealPlanFrame.getContentPane().add(mealPlanBtn);
		
		springLayout.putConstraint(SpringLayout.NORTH, shoppingBtn, 75, SpringLayout.NORTH, mealPlanFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, shoppingBtn, 130, SpringLayout.WEST, mealPlanBtn);
		mealPlanFrame.getContentPane().add(shoppingBtn);
		
		springLayout.putConstraint(SpringLayout.NORTH, restaurantBtn, 75, SpringLayout.NORTH, mealPlanFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, restaurantBtn, 130, SpringLayout.WEST, shoppingBtn);
		mealPlanFrame.getContentPane().add(restaurantBtn);
		
		springLayout.putConstraint(SpringLayout.SOUTH, createMealBtn, 500, SpringLayout.SOUTH, recipeBtn);
		springLayout.putConstraint(SpringLayout.WEST, createMealBtn, 800, SpringLayout.WEST, mealPlanFrame.getContentPane());
		mealPlanFrame.getContentPane().add(createMealBtn);
		
		
		mAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(MondayLogPanel, springLayout, MondayLogText, "monday");
			}
			
		});
		
		tAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(TuesdayLogPanel, springLayout, TuesdayLogText, "tuesday");
			}
			
		});
		
		wAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(WednesdayLogPanel, springLayout, WednesdayLogText, "wednesday");
			}
			
		});
		
		thAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(ThursdayLogPanel, springLayout, ThursdayLogText, "thursday");
			}
			
		});
		
		fAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(FridayLogPanel, springLayout, FridayLogText, "friday");
			}
			
		});
		
		satAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(SaturdayLogPanel, springLayout, SaturdayLogText, "saturday");
			}
			
		});
		
		sunAddButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddMealToDay(SundayLogPanel, springLayout, SundayLogText, "sunday");
			}
			
		});
		
		mRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, MondayLogPanel, MondayLogLabel, MondayLogText, "monday");
			}
			
		});
		
		tRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, TuesdayLogPanel, TuesdayLogLabel, TuesdayLogText, "tuesday");
			}
			
		});
		
		wRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, WednesdayLogPanel, WednesdayLogLabel, WednesdayLogText, "wednesday");
			}
			
		});
		
		thRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, ThursdayLogPanel, ThursdayLogLabel, ThursdayLogText, "thursday");
			}
			
		});
		
		fRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, FridayLogPanel, FridayLogLabel, FridayLogText, "friday");
			}
			
		});
		
		satRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, SaturdayLogPanel, SaturdayLogLabel, SaturdayLogText, "saturday");
			}
			
		});
		
		sunRemoveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildRemoveMealFromDay(springLayout, SundayLogPanel, SundayLogLabel, SundayLogText, "sunday");
			}
			
		});

		mealPlanFrame.setVisible(true);
		
		dayBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DayGUI dailyGUI = new DayGUI(db);
				dailyGUI.createTable();
				mealPlanFrame.dispose();
			}
			
		});
		
		recipeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RecipeGUI recipeGUI = new RecipeGUI(db);
				recipeGUI.buildRecipeGUI();
				mealPlanFrame.dispose();
			}
			
		});
		
		shoppingBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ShoppingGUI shoppingGUI = new ShoppingGUI(db);
				shoppingGUI.createTable();
			}
			
		});
		
		createMealBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildCreateMealPlanGUI();
			}
			
		});
		
		restaurantBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RestaurantGUI restaurantGUI = new RestaurantGUI(db);
				restaurantGUI.createTable();
			}
			
		});
	}
	

	public void buildAddMealToDay(JPanel logPanel, SpringLayout spring, JTextArea dayTA, String dayName)
	{
		JFrame foodLogEntryFrame = new JFrame();
		foodLogEntryFrame.setSize(950, 800);
		foodLogEntryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		foodLogEntryFrame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JButton saveBtn = new JButton("Save");
		JButton cancelBtn = new JButton("Cancel");
		SearchGUI search = new SearchGUI(db);
		search.setMeal(dayName);
		JPanel searchPanel = search.buildSearch();
		saveBtn.setSize(20, 20);
		panel.add(saveBtn);
		panel.add(searchPanel);
		foodLogEntryFrame.add(panel);
		
		saveBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
			
				logPanel.remove(dayTA);
				dayTA.setText(db.getAllFoods(dayName));
				
				spring.putConstraint(SpringLayout.NORTH, dayTA, 30, SpringLayout.NORTH, logPanel);
				spring.putConstraint(SpringLayout.WEST, dayTA, 10, SpringLayout.NORTH, logPanel);
				logPanel.add(dayTA);
				
				logPanel.validate();
				logPanel.repaint();
				foodLogEntryFrame.dispose();
			}
			
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				foodLogEntryFrame.dispose();
			}
			
		});
		
		foodLogEntryFrame.setVisible(true);
	}
	
	public void buildRemoveMealFromDay(SpringLayout spring, JPanel logPanel, JLabel dayLabel, JTextArea dayTA, String dayName) {
		
		JFrame removeMealFrame = new JFrame();
		removeMealFrame.setSize(480, 250);
		removeMealFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		removeMealFrame.setLocationRelativeTo(null);
		removeMealFrame.setLayout(spring);
		
		String longDayString = db.getAllFoods(dayName);
		String[] mealsInDay = longDayString.split("\\n");
		int size = mealsInDay.length;
		JCheckBox[] mealsInDayCB = new JCheckBox[size];
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(350, 200));
		panel.setBackground(new Color(254,127,45));
		panel.setLayout(new GridLayout(size,1));
		
		for(int i = 0; i < size; i++) {
			mealsInDayCB[i] = new JCheckBox(mealsInDay[i]);
			panel.add(mealsInDayCB[i]);
		}
		
		JButton removeBtn = new JButton("Remove");
		JButton cancelBtn = new JButton("Cancel");
		
		spring.putConstraint(SpringLayout.NORTH, panel, 20, SpringLayout.NORTH, removeMealFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, removeMealFrame.getContentPane());
		removeMealFrame.getContentPane().add(panel);
		
		spring.putConstraint(SpringLayout.SOUTH, removeBtn, -50, SpringLayout.SOUTH, removeMealFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, removeBtn, 10, SpringLayout.EAST, panel);
		removeMealFrame.getContentPane().add(removeBtn);
		
		spring.putConstraint(SpringLayout.NORTH, cancelBtn, 10, SpringLayout.SOUTH, removeBtn);
		spring.putConstraint(SpringLayout.WEST, cancelBtn, 0, SpringLayout.WEST, removeBtn);
		removeMealFrame.getContentPane().add(cancelBtn);
		
		removeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				for(int i = 0; i < mealsInDayCB.length; i++) {
					
					if(mealsInDayCB[i].isSelected()) {
						db.removeItemFromMeal(mealsInDayCB[i].getText(), dayName);
					}
				}
				
				logPanel.removeAll();
				dayTA.setText(db.getAllFoods(dayName));

				spring.putConstraint(SpringLayout.NORTH, dayTA, 30, SpringLayout.NORTH, logPanel);
				spring.putConstraint(SpringLayout.WEST, dayTA, 10, SpringLayout.NORTH, logPanel);
				logPanel.add(dayTA);
				
				spring.putConstraint(SpringLayout.NORTH, dayLabel, 10, SpringLayout.NORTH, logPanel);
				spring.putConstraint(SpringLayout.WEST, dayLabel, 10, SpringLayout.WEST, logPanel);
				logPanel.add(dayLabel);
				
				logPanel.validate();
				logPanel.repaint();
				
				removeMealFrame.dispose();
			}
			
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				removeMealFrame.dispose();
			}
			
		});
		
		removeMealFrame.setVisible(true);
	}
	
	
	public void buildCreateMealPlanGUI() {
		
		SpringLayout spring = new SpringLayout();
		JFrame createMealPlan = new JFrame();
		createMealPlan.setSize(700, 700);
		createMealPlan.getContentPane().setLayout(spring);
		createMealPlan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMealPlan.setLocationRelativeTo(null);
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Create Meal Plan");
		headerPanel.setBackground(new Color(112,146,85));
		headerPanel.setPreferredSize(new Dimension(650,40));
		headerPanel.add(headerLabel);
		
		JButton mpAddButton = new JButton("Add");
		JButton mpRemoveButton = new JButton("Remove");
		mpAddButton.setBackground(new Color(112,146,85));
		mpRemoveButton.setBackground(new Color(112,146,85));

		JButton saveBtn = new JButton("Save");
		JButton cancelBtn = new JButton("Cancel");
		
		JPanel inputBckgdPanel = new JPanel();
		inputBckgdPanel.setBackground(new Color(254,127,45));
		inputBckgdPanel.setPreferredSize(new Dimension(550,575));
		JPanel mealPlanInfoPanel = new JPanel();
		mealPlanInfoPanel.setLayout(new GridLayout(8,2,10,2));
		mealPlanInfoPanel.setPreferredSize(new Dimension(530, 150));
		
		JLabel nameLabel = new JLabel("  Meal Plan Name: ");

		JLabel perServingLabel = new JLabel("  Nutritional Info (grams per serving)");
		JLabel calLabel = new JLabel("  Calories: ");
		JLabel carbLabel = new JLabel("  Carbs: ");
		JLabel proteinLabel = new JLabel("  Protein: ");
		JLabel fatLabel = new JLabel("  Fat: ");
		JLabel blank = new JLabel("");
		
		JTextField nameTF = new JTextField();
		JTextField calTF = new JTextField();
		JTextField carbTF = new JTextField();
		JTextField proteinTF = new JTextField();
		JTextField fatTF = new JTextField();
		
		mealPlanInfoPanel.add(nameLabel);
		mealPlanInfoPanel.add(nameTF);
		
		mealPlanInfoPanel.add(perServingLabel);
		mealPlanInfoPanel.add(blank);
		mealPlanInfoPanel.add(calLabel);
		mealPlanInfoPanel.add(calTF);
		mealPlanInfoPanel.add(carbLabel);
		mealPlanInfoPanel.add(carbTF);
		mealPlanInfoPanel.add(proteinLabel);
		mealPlanInfoPanel.add(proteinTF);
		mealPlanInfoPanel.add(fatLabel);
		mealPlanInfoPanel.add(fatTF);
		
		JLabel DailyMealPlan = new JLabel("Daily :");
		JTextField DailyTF = new JTextField();
		DailyTF.setPreferredSize(new Dimension(500, 300));
		
		inputBckgdPanel.setLayout(spring);
		spring.putConstraint(SpringLayout.NORTH, mealPlanInfoPanel, 10, SpringLayout.NORTH, inputBckgdPanel);
		spring.putConstraint(SpringLayout.WEST, mealPlanInfoPanel, 10, SpringLayout.WEST, inputBckgdPanel);
		inputBckgdPanel.add(mealPlanInfoPanel);
		
		spring.putConstraint(SpringLayout.NORTH, DailyMealPlan, 20, SpringLayout.SOUTH, mealPlanInfoPanel);
		spring.putConstraint(SpringLayout.WEST, DailyMealPlan, 15, SpringLayout.WEST, inputBckgdPanel);
		inputBckgdPanel.add(DailyMealPlan);
		
		spring.putConstraint(SpringLayout.NORTH, DailyTF, 5, SpringLayout.SOUTH, DailyMealPlan);
		spring.putConstraint(SpringLayout.WEST, DailyTF, 0, SpringLayout.WEST, DailyMealPlan);
		inputBckgdPanel.add(DailyTF);
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 25, SpringLayout.NORTH, createMealPlan.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 15, SpringLayout.WEST, createMealPlan.getContentPane());
		createMealPlan.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, inputBckgdPanel, 10, SpringLayout.SOUTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, inputBckgdPanel, 15, SpringLayout.WEST, headerPanel);
		createMealPlan.getContentPane().add(inputBckgdPanel);
		
		spring.putConstraint(SpringLayout.NORTH, mpAddButton, 350, SpringLayout.NORTH, DailyMealPlan);
		spring.putConstraint(SpringLayout.WEST, mpAddButton, 200, SpringLayout.WEST, DailyMealPlan);
		createMealPlan.getContentPane().add(mpAddButton);
		
		spring.putConstraint(SpringLayout.NORTH, mpRemoveButton, 0, SpringLayout.NORTH, mpAddButton);
		spring.putConstraint(SpringLayout.WEST, mpRemoveButton, 65, SpringLayout.WEST, mpAddButton);
		createMealPlan.getContentPane().add(mpRemoveButton);
		
		spring.putConstraint(SpringLayout.SOUTH, cancelBtn, -25, SpringLayout.SOUTH, createMealPlan.getContentPane());
		spring.putConstraint(SpringLayout.WEST, cancelBtn, 10, SpringLayout.EAST, inputBckgdPanel);
		createMealPlan.getContentPane().add(cancelBtn);
		
		spring.putConstraint(SpringLayout.SOUTH, saveBtn, -10, SpringLayout.NORTH, cancelBtn);
		spring.putConstraint(SpringLayout.WEST, saveBtn, 0, SpringLayout.WEST, cancelBtn);
		createMealPlan.getContentPane().add(saveBtn);

		
		createMealPlan.setVisible(true);
		
		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				createMealPlan.dispose();
			}
			
		});

	}
	
}
