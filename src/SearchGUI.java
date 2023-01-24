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

public class SearchGUI{
	private JButton searchButton;
	private JTextField searchField;
	private Connection conn;
	private JTable databaseTable;
	private DefaultTableModel tableModel;
	private String mealName;
	private DatabaseQueries db;
	
	public SearchGUI(DatabaseQueries db) {
		this.db = db;
	}
  
	public void setMeal(String mealName) { this.mealName = mealName; }
	
	public String getMeal() { return this.mealName;}
	
	public void createTable() {
		tableModel = new DefaultTableModel();
		//tableModel.setRowCount(500);
		//String[] cols = {"ID", "name", "groupName", "calories", "fat", "protein", "carbs", "sugar", "fiber", "cholesterol", "satFat"};
		String[] cols = { "ID", "name", "calories", "fat", "protein", "carbs", "sugar", "fiber", "cholest.", "satFat"};
		
		for(int i = 0; i < cols.length; i++) {
			tableModel.addColumn(cols[i]);
		}
		
		String mealName = this.mealName;
		
		databaseTable.getTableHeader().setReorderingAllowed(false);
        databaseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					db.addItemToMeal(databaseTable.getValueAt(databaseTable.getSelectedRow(), 1).toString(), mealName);
	        		//System.out.println("row selected: " + databaseTable.getValueAt(databaseTable.getSelectedRow(), 0).toString());	
				}

			}
        });
        
	}

	public String getColName(int index) {
		return databaseTable.getColumnName(index);
	}
	
	public void populateTable(ResultSet rs) throws SQLException {
		try {
			while(rs.next()) {
				String ID = rs.getString("ID");
				String foodName = rs.getString("name");
				String groupName = rs.getString("groupName");
				double calories = rs.getDouble("calories");
				double fat = rs.getDouble("fat");
				double protein = rs.getDouble("protein");
				double carbs = rs.getDouble("carbs");
				double sugar = rs.getDouble("sugar");
				double fiber = rs.getDouble("fiber");
				double cholesterol = rs.getDouble("cholesterol");
				double satFat = rs.getDouble("satFat");
				//tableModel.insertRow(0, new Object[] { ID, foodName, groupName, calories, fat, protein, carbs, sugar, fiber, cholesterol, satFat });
				tableModel.insertRow(0, new Object[] { ID, foodName, calories, fat, protein, carbs, sugar, fiber, cholesterol, satFat });
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void searchButtonListener() {
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String test = searchField.getText();
				ResultSet rs = db.issueSearchQuery(test);
				try {
					// have to reset the table first
					populateTable(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
    public JPanel buildSearch(){
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(50);
        searchButton = new JButton("Search");
        searchPanel.setSize(2000, 2000);
        databaseTable = new JTable() {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int col, java.util.EventObject e) {
        		return false;
        	}
        };
        
        databaseTable.setPreferredSize(new Dimension(100000, 100000));
        createTable();
        databaseTable.setModel(tableModel);
        JScrollPane scrollBar = new JScrollPane(databaseTable);
        scrollBar.setPreferredSize(new Dimension(900, 900)); // need to fix bug with scrollbar
        setColumnWidths(10);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(scrollBar);
        searchButtonListener();
        return searchPanel;
    }

    public void setColumnWidths(int numCols) {
    	for(int i = 0; i < numCols; i++) {
    		databaseTable.getColumnModel().getColumn(i).setPreferredWidth(15);
    	}
    	
    	databaseTable.getColumnModel().getColumn(1).setPreferredWidth(250);
    }
    
}
