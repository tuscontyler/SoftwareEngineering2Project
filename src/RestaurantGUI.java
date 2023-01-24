import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class RestaurantGUI {

	public DatabaseQueries db;
	
	public RestaurantGUI(DatabaseQueries db) {
		this.db = db;
	}
	
	public void createTable() {
		
		SpringLayout spring = new SpringLayout();
		JFrame viewRestaurantFrame = new JFrame();
	
		viewRestaurantFrame.setSize(700, 800);
		viewRestaurantFrame.getContentPane().setLayout(spring);
		viewRestaurantFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewRestaurantFrame.setLocationRelativeTo(null);
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Local Restaurants");
		headerPanel.setBackground(new Color(112,146,85));
		headerPanel.setPreferredSize(new Dimension(600, 40));
		headerPanel.add(headerLabel);
		
		JPanel MapPanel = new JPanel();
		JLabel MapImage = new JLabel("");
		ImageIcon image = new ImageIcon(this.getClass().getResource("/map.JPG"));
		MapImage.setIcon(image);
		
		JLabel MapLabel = new JLabel("Google Map");
		MapPanel.setBackground(new Color(254,127,45));
		MapPanel.setPreferredSize(new Dimension(400,300));
		MapImage.setPreferredSize(new Dimension(400, 300));
		MapPanel.setLayout(spring);
		

		JPanel searchFilterPanel = new JPanel();
		JCheckBox applebeesCB = new JCheckBox("Applebee's");
		JCheckBox arbysCB = new JCheckBox("Arby's");
		JCheckBox burgerkingCB = new JCheckBox("Burger King");
		JCheckBox kfcCB = new JCheckBox("KFC");
		JCheckBox mcdonaldsCB = new JCheckBox("McDonald's");
		JCheckBox pizzahutCB = new JCheckBox("Pizza Hut");
		JCheckBox popeyesCB = new JCheckBox("Popeyes");
		JCheckBox subwayCB = new JCheckBox("Subway");
		JCheckBox tacobellCB = new JCheckBox("Taco Bell");
		JCheckBox wendysCB = new JCheckBox("Wendy's");
		
		searchFilterPanel.setLayout(new GridLayout(2,3));
		searchFilterPanel.add(applebeesCB);
		searchFilterPanel.add(arbysCB);
		searchFilterPanel.add(burgerkingCB);
		searchFilterPanel.add(kfcCB);
		searchFilterPanel.add(mcdonaldsCB);
		searchFilterPanel.add(pizzahutCB);
		searchFilterPanel.add(popeyesCB);
		searchFilterPanel.add(subwayCB);
		searchFilterPanel.add(tacobellCB);
		searchFilterPanel.add(wendysCB);
		searchFilterPanel.setPreferredSize(new Dimension(600, 100));
		
		JTextField searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(450, 30));
		JButton searchBtn = new JButton("Search");
		
		spring.putConstraint(SpringLayout.NORTH, MapImage, 40, SpringLayout.NORTH, MapPanel);
		spring.putConstraint(SpringLayout.WEST, MapImage, 10, SpringLayout.WEST, MapPanel);
		MapPanel.add(MapImage);
		
		spring.putConstraint(SpringLayout.NORTH, MapLabel, 20, SpringLayout.NORTH, MapPanel);
		spring.putConstraint(SpringLayout.WEST, MapLabel, 10, SpringLayout.WEST, MapPanel);
		MapPanel.add(MapLabel);

		JButton closeBtn = new JButton("Close");
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 30, SpringLayout.NORTH, viewRestaurantFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 25, SpringLayout.WEST, viewRestaurantFrame.getContentPane());
		viewRestaurantFrame.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, MapPanel, 75, SpringLayout.NORTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, MapPanel, 50, SpringLayout.WEST, viewRestaurantFrame.getContentPane());
		viewRestaurantFrame.getContentPane().add(MapPanel);
		
		spring.putConstraint(SpringLayout.SOUTH, searchFilterPanel, 100, SpringLayout.SOUTH, MapPanel);
		spring.putConstraint(SpringLayout.WEST, searchFilterPanel, 50, SpringLayout.WEST, viewRestaurantFrame.getContentPane());
		viewRestaurantFrame.getContentPane().add(searchFilterPanel);
		
		spring.putConstraint(SpringLayout.SOUTH, searchBar, 30, SpringLayout.SOUTH, searchFilterPanel);
		spring.putConstraint(SpringLayout.WEST, searchBar, 50, SpringLayout.WEST, viewRestaurantFrame.getContentPane());
		viewRestaurantFrame.getContentPane().add(searchBar);
		
		spring.putConstraint(SpringLayout.NORTH, searchBtn, 0, SpringLayout.NORTH, searchBar);
		spring.putConstraint(SpringLayout.WEST, searchBtn, 10, SpringLayout.EAST, searchBar);
		viewRestaurantFrame.getContentPane().add(searchBtn);
		
		spring.putConstraint(SpringLayout.SOUTH, closeBtn, -60, SpringLayout.SOUTH, viewRestaurantFrame.getContentPane());
		spring.putConstraint(SpringLayout.EAST, closeBtn, -10, SpringLayout.EAST, MapPanel);
		viewRestaurantFrame.getContentPane().add(closeBtn);
		
		viewRestaurantFrame.setVisible(true);
		
		searchBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String test = searchBar.getText();
				boolean[] filters = {applebeesCB.isSelected(), arbysCB.isSelected(), burgerkingCB.isSelected(), 
						kfcCB.isSelected(), mcdonaldsCB.isSelected(), pizzahutCB.isSelected(), popeyesCB.isSelected(), 
						subwayCB.isSelected(), tacobellCB.isSelected(), wendysCB.isSelected()};
				
				buildSearchRestaurantGUI(test, filters, spring);
			}
			
		});
		
		closeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				viewRestaurantFrame.dispose();
			}
			
		});
	}
	
	public void buildSearchRestaurantGUI(String searchString, boolean[] filters, SpringLayout spr)
	{
	
		{
			//similar to recipeGUI using the restaurant filters to search
			
			JFrame searchRestaurantFrame = new JFrame();
			SpringLayout spring = new SpringLayout();
			searchRestaurantFrame.setLayout(spring);
			searchRestaurantFrame.setSize(800, 650);
			searchRestaurantFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			searchRestaurantFrame.setLocationRelativeTo(null);

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
			String[] cols = {"Name",  "Calories", "Carbs (g)", "Protein (g)", "Fat (g)"};
			
			for(int i = 0; i < cols.length; i++) {
				tableModel.addColumn(cols[i]);
			}
			
			dbTable.getTableHeader().setReorderingAllowed(false);

			ResultSet rs = db.issueSearchRestaurantQuery(searchString, filters);
			
			try {
				while(rs.next()) {
					String restaurant = rs.getString("name");
					int calories = rs.getInt("calories");
					int carbs = rs.getInt("carbs");
					int protein = rs.getInt("protein");
					int fat = rs.getInt("fat");
					
					tableModel.insertRow(0, new Object[] {restaurant, calories, carbs, protein, fat});
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
			
			spring.putConstraint(SpringLayout.NORTH, headerPanel, 10, SpringLayout.NORTH, searchRestaurantFrame.getContentPane());
			spring.putConstraint(SpringLayout.WEST, headerPanel, 10, SpringLayout.WEST, searchRestaurantFrame.getContentPane());
			searchRestaurantFrame.getContentPane().add(headerPanel);
			
			spring.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, headerPanel);
			spring.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, searchRestaurantFrame.getContentPane());
			searchRestaurantFrame.getContentPane().add(scrollPane);
			
			spring.putConstraint(SpringLayout.WEST, cancelBtn, 10, SpringLayout.EAST, scrollPane);
			spring.putConstraint(SpringLayout.SOUTH, cancelBtn, 0, SpringLayout.SOUTH, scrollPane);
			searchRestaurantFrame.getContentPane().add(cancelBtn);
			
			searchRestaurantFrame.setVisible(true);

			cancelBtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					searchRestaurantFrame.dispose();
				}
				
			});
			

			
			}


	}


}

