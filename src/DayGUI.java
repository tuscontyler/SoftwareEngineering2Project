import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class DayGUI {

public DatabaseQueries db;
	
	public DayGUI(DatabaseQueries db) {
		this.db = db;
	}
	
	public void createTable() {
		SpringLayout spring = new SpringLayout();
		JFrame dailyFrame = new JFrame();
		dailyFrame.setSize(1400, 800);
		dailyFrame.getContentPane().setLayout(spring);
		dailyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dailyFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("/logo.png"));
		JPanel helloPanel = new JPanel();
		JLabel helloLabel = new JLabel("Today");
		helloPanel.setBackground(new Color(112,146,85));
		helloPanel.setPreferredSize(new Dimension(1200, 40));
		helloPanel.add(helloLabel);
		
		JButton recipeBtn = new JButton("Recipes");
		JButton mealPlanBtn = new JButton("Meal Planning");
		JButton shoppingBtn = new JButton("Shopping List");
		JButton restaurantBtn = new JButton("Restaurant Finder");
		
		recipeBtn.setBackground(new Color(254,127,45));
		mealPlanBtn.setBackground(new Color(254,127,45));
		shoppingBtn.setBackground(new Color(254,127,45));
		restaurantBtn.setBackground(new Color(254,127,45));
		
		//JPanel graphPanel = new JPanel();
		//graphPanel.setBackground(new Color(252,202,70));
		//graphPanel.setPreferredSize(new Dimension(550, 150));
		
		// remove the next 2 lines if u want the GUI to work normally
		//DailyMacrosGUI macroGUI = new DailyMacrosGUI(db);
		//JPanel macroPanel = macroGUI.buildMacroTable();
		
		JButton macroBtn = new JButton("View Daily Macros");
		macroBtn.setBackground(new Color(252,202,70));
		
		JPanel dayLogPanel = new JPanel();
		JTextArea bfastLogTA = new JTextArea();
		JTextArea lunchLogTA = new JTextArea();
		JTextArea dinnerLogTA = new JTextArea();
		JTextArea snackLogTA = new JTextArea();
		JLabel dayLogLabel = new JLabel("Daily Food Log");
		JLabel bfastLabel = new JLabel("Breakfast");
		JLabel lunchLabel = new JLabel("Lunch");
		JLabel dinnerLabel = new JLabel("Dinner");
		JLabel snackLabel = new JLabel("Snack");
		JButton addBfastBtn = new JButton("+");
		JButton addLunchBtn = new JButton("+");
		JButton addDinnerBtn = new JButton("+");
		JButton addSnackBtn = new JButton("+");

		bfastLabel.setBackground(Color.WHITE);
		lunchLabel.setBackground(Color.WHITE);
		dinnerLabel.setBackground(Color.WHITE);
		snackLabel.setBackground(Color.WHITE);
		dayLogPanel.setBackground(new Color(254,127,45));
		dayLogPanel.setPreferredSize(new Dimension(500, 520));
		bfastLogTA.setPreferredSize(new Dimension(480, 95));
		bfastLogTA.setText(db.getAllFoods("breakfast"));
		lunchLogTA.setPreferredSize(new Dimension(480, 95));
		lunchLogTA.setText(db.getAllFoods("lunch"));
		dinnerLogTA.setPreferredSize(new Dimension(480, 95));
		dinnerLogTA.setText(db.getAllFoods("dinner"));
		snackLogTA.setPreferredSize(new Dimension(480, 95));
		snackLogTA.setText(db.getAllFoods("snack"));
		bfastLogTA.setEditable(false);
		lunchLogTA.setEditable(false);
		dinnerLogTA.setEditable(false);
		snackLogTA.setEditable(false);
		addBfastBtn.setPreferredSize(new Dimension(50,20));
		addLunchBtn.setPreferredSize(new Dimension(50,20));
		addDinnerBtn.setPreferredSize(new Dimension(50,20));
		addSnackBtn.setPreferredSize(new Dimension(50,20));
		dayLogPanel.setLayout(spring);
		
		spring.putConstraint(SpringLayout.NORTH, dayLogLabel, 10, SpringLayout.NORTH, dayLogPanel);
		spring.putConstraint(SpringLayout.WEST, dayLogLabel, 10, SpringLayout.WEST, dayLogPanel);
		dayLogPanel.add(dayLogLabel);
		
		spring.putConstraint(SpringLayout.NORTH, bfastLogTA, 55, SpringLayout.NORTH, dayLogPanel);
		spring.putConstraint(SpringLayout.WEST, bfastLogTA, 10, SpringLayout.WEST, dayLogPanel);
		dayLogPanel.add(bfastLogTA);
		
		spring.putConstraint(SpringLayout.SOUTH, bfastLabel, 0, SpringLayout.NORTH, bfastLogTA);
		spring.putConstraint(SpringLayout.WEST, bfastLabel, 0, SpringLayout.WEST, bfastLogTA);
		dayLogPanel.add(bfastLabel);
		
		spring.putConstraint(SpringLayout.SOUTH, addBfastBtn, 0, SpringLayout.NORTH, bfastLogTA);
		spring.putConstraint(SpringLayout.EAST, addBfastBtn, 0, SpringLayout.EAST, bfastLogTA);
		dayLogPanel.add(addBfastBtn);
		
		spring.putConstraint(SpringLayout.NORTH, lunchLogTA, 25, SpringLayout.SOUTH, bfastLogTA);
		spring.putConstraint(SpringLayout.WEST, lunchLogTA, 10, SpringLayout.WEST, dayLogPanel);
		dayLogPanel.add(lunchLogTA);
		
		spring.putConstraint(SpringLayout.SOUTH, lunchLabel, 0, SpringLayout.NORTH, lunchLogTA);
		spring.putConstraint(SpringLayout.WEST, lunchLabel, 0, SpringLayout.WEST, lunchLogTA);
		dayLogPanel.add(lunchLabel);
		
		spring.putConstraint(SpringLayout.SOUTH, addLunchBtn, 0, SpringLayout.NORTH, lunchLogTA);
		spring.putConstraint(SpringLayout.EAST, addLunchBtn, 0, SpringLayout.EAST, lunchLogTA);
		dayLogPanel.add(addLunchBtn);
		
		spring.putConstraint(SpringLayout.NORTH, dinnerLogTA, 25, SpringLayout.SOUTH, lunchLogTA);
		spring.putConstraint(SpringLayout.WEST, dinnerLogTA, 10, SpringLayout.WEST, dayLogPanel);
		dayLogPanel.add(dinnerLogTA);
		
		spring.putConstraint(SpringLayout.SOUTH, dinnerLabel, 0, SpringLayout.NORTH, dinnerLogTA);
		spring.putConstraint(SpringLayout.WEST, dinnerLabel, 0, SpringLayout.WEST, dinnerLogTA);
		dayLogPanel.add(dinnerLabel);
		
		spring.putConstraint(SpringLayout.SOUTH, addDinnerBtn, 0, SpringLayout.NORTH, dinnerLogTA);
		spring.putConstraint(SpringLayout.EAST, addDinnerBtn, 0, SpringLayout.EAST, dinnerLogTA);
		dayLogPanel.add(addDinnerBtn);
		
		spring.putConstraint(SpringLayout.NORTH, snackLogTA, 25, SpringLayout.SOUTH, dinnerLogTA);
		spring.putConstraint(SpringLayout.WEST, snackLogTA, 10, SpringLayout.WEST, dayLogPanel);
		dayLogPanel.add(snackLogTA);
		
		spring.putConstraint(SpringLayout.SOUTH, snackLabel, 0, SpringLayout.NORTH, snackLogTA);
		spring.putConstraint(SpringLayout.WEST, snackLabel, 0, SpringLayout.WEST, snackLogTA);
		dayLogPanel.add(snackLabel);
		
		spring.putConstraint(SpringLayout.SOUTH, addSnackBtn, 0, SpringLayout.NORTH, snackLogTA);
		spring.putConstraint(SpringLayout.EAST, addSnackBtn, 0, SpringLayout.EAST, snackLogTA);
		dayLogPanel.add(addSnackBtn);
		
		JPanel NotesPanel = new JPanel();
		JTextArea NotesInfoText = new JTextArea();
		JLabel notesLabel = new JLabel("Today's Notes");
		NotesPanel.setBackground(new Color(112,146,85));
		NotesPanel.setPreferredSize(new Dimension(550, 210));
		NotesInfoText.setPreferredSize(new Dimension(530, 160));
		NotesInfoText.setEditable(false);
		//notesViewing.setBackground(new Color(112,146,85));
		//notesViewing.setPreferredSize(new Dimension(40, 25));
		NotesPanel.setLayout(spring);
		
		spring.putConstraint(SpringLayout.NORTH, NotesInfoText, 40, SpringLayout.NORTH, NotesPanel);
		spring.putConstraint(SpringLayout.WEST, NotesInfoText, 10, SpringLayout.WEST, NotesPanel);
		NotesPanel.add(NotesInfoText);
		
		spring.putConstraint(SpringLayout.NORTH, notesLabel, 20, SpringLayout.NORTH, NotesPanel);
		spring.putConstraint(SpringLayout.WEST, notesLabel, 10, SpringLayout.WEST, NotesPanel);
		NotesPanel.add(notesLabel);
		
		spring.putConstraint(SpringLayout.NORTH, helloPanel, 25, SpringLayout.NORTH, dailyFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, helloPanel, 25, SpringLayout.WEST, dailyFrame.getContentPane());
		dailyFrame.getContentPane().add(helloPanel);
		
		spring.putConstraint(SpringLayout.NORTH, recipeBtn, 75, SpringLayout.NORTH, dailyFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, recipeBtn, 600, SpringLayout.WEST, dailyFrame.getContentPane());
		dailyFrame.getContentPane().add(recipeBtn);
		
		spring.putConstraint(SpringLayout.NORTH, mealPlanBtn, 75, SpringLayout.NORTH, dailyFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, mealPlanBtn, 95, SpringLayout.WEST, recipeBtn);
		dailyFrame.getContentPane().add(mealPlanBtn);
		
		spring.putConstraint(SpringLayout.NORTH, shoppingBtn, 75, SpringLayout.NORTH, dailyFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, shoppingBtn, 130, SpringLayout.WEST, mealPlanBtn);
		dailyFrame.getContentPane().add(shoppingBtn);
		
		spring.putConstraint(SpringLayout.NORTH, restaurantBtn, 75, SpringLayout.NORTH, dailyFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, restaurantBtn, 130, SpringLayout.WEST, shoppingBtn);
		dailyFrame.getContentPane().add(restaurantBtn);
		
		//spring.putConstraint(SpringLayout.NORTH, macroPanel, 125, SpringLayout.NORTH, dailyFrame.getContentPane());
		//spring.putConstraint(SpringLayout.WEST, macroPanel, 600, SpringLayout.WEST, dailyFrame.getContentPane());
		//dailyFrame.getContentPane().add(macroPanel);
		
		spring.putConstraint(SpringLayout.NORTH, macroBtn, 50, SpringLayout.NORTH, dayLogPanel);
		spring.putConstraint(SpringLayout.WEST, macroBtn, 600, SpringLayout.WEST, dailyFrame.getContentPane());
		dailyFrame.getContentPane().add(macroBtn);
	
		spring.putConstraint(SpringLayout.NORTH, dayLogPanel, 125, SpringLayout.NORTH, dailyFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, dayLogPanel, 25, SpringLayout.WEST, dailyFrame.getContentPane());
		dailyFrame.getContentPane().add(dayLogPanel);
		
		spring.putConstraint(SpringLayout.NORTH, NotesPanel, 100, SpringLayout.SOUTH, macroBtn);
		spring.putConstraint(SpringLayout.WEST, NotesPanel, 75, SpringLayout.EAST, dayLogPanel);
		dailyFrame.getContentPane().add(NotesPanel);
		
		dailyFrame.setVisible(true);
		
		recipeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RecipeGUI recipeGUI = new RecipeGUI(db);
				recipeGUI.buildRecipeGUI();
				dailyFrame.dispose();
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
				dailyFrame.dispose();
			}
			
		});

		addBfastBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddLogEntryGUI(dayLogPanel, spring, bfastLogTA, "breakfast");
			}
			
		});
		
		addLunchBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddLogEntryGUI(dayLogPanel, spring, lunchLogTA, "lunch");
			}
			
		});

		addDinnerBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddLogEntryGUI(dayLogPanel, spring, dinnerLogTA, "dinner");
			}
			
		});
		
		addSnackBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildAddLogEntryGUI(dayLogPanel, spring, snackLogTA, "snack");
			}
			
		});
		
		restaurantBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				RestaurantGUI restaurantGUI = new RestaurantGUI(db);
				restaurantGUI.createTable();
			}
		});
		
		macroBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DailyMacrosGUI macroGUI = new DailyMacrosGUI(db);
				macroGUI.buildMacroTable();
			}
		});
	
		
	}
	
	public void buildAddLogEntryGUI(JPanel logPanel, SpringLayout spring, JTextArea mealTA, String mealName)
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
		search.setMeal(mealName);
		JPanel searchPanel = search.buildSearch();
		saveBtn.setSize(20, 20);
		panel.add(saveBtn);
		panel.add(searchPanel);
		foodLogEntryFrame.add(panel);
		
		saveBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {				
			
				logPanel.remove(mealTA);
				mealTA.setText(db.getAllFoods(mealName));
				if(mealName.equalsIgnoreCase("breakfast")) {

					spring.putConstraint(SpringLayout.NORTH, mealTA, 55, SpringLayout.NORTH, logPanel);
					spring.putConstraint(SpringLayout.WEST, mealTA, 10, SpringLayout.WEST, logPanel);
				}
				else if(mealName.equalsIgnoreCase("lunch")) {

					spring.putConstraint(SpringLayout.NORTH, mealTA, 175, SpringLayout.NORTH, logPanel);
					spring.putConstraint(SpringLayout.WEST, mealTA, 10, SpringLayout.WEST, logPanel);
				}
				else if(mealName.equalsIgnoreCase("dinner")) {

					spring.putConstraint(SpringLayout.NORTH, mealTA, 295, SpringLayout.NORTH, logPanel);
					spring.putConstraint(SpringLayout.WEST, mealTA, 10, SpringLayout.WEST, logPanel);
				}
				else if(mealName.equalsIgnoreCase("snack")) {
					
					spring.putConstraint(SpringLayout.NORTH, mealTA, 415, SpringLayout.NORTH, logPanel);
					spring.putConstraint(SpringLayout.WEST, mealTA, 10, SpringLayout.WEST, logPanel);
				}

				logPanel.add(mealTA);
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
}

	