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

public class DailyMacrosGUI {
	
	public DatabaseQueries db;
	private JTable macroTable;
	private DefaultTableModel tableModel;
	
	public DailyMacrosGUI(DatabaseQueries db) {
		this.db = db;
	}
	
	public void createTable() {
		tableModel = new DefaultTableModel();
		String[] cols = { "meal", "calories", "fat", "protein", "carbs", "sugar", "fiber", "cholest.", "satFat"};
		
		for(int i = 0; i < cols.length; i++) {
			tableModel.addColumn(cols[i]);
		}
		
		populateTable();
        
	}
	
	public void populateTable() {
		String[] mealNames = { "breakfast", "lunch", "dinner", "snack"};
		for(int i = 0; i < 4; i++) {
			String name = mealNames[i];
			ArrayList<Double> values = db.getMacros(name);
			tableModel.insertRow(0, new Object[] { name, (int)(values.get(0).doubleValue()), (int)(values.get(1).doubleValue()), (int)(values.get(2).doubleValue()), 
													 	 (int)(values.get(3).doubleValue()), (int)(values.get(4).doubleValue()), 
													 	 (int)(values.get(5).doubleValue()), (int)(values.get(6).doubleValue()), (int)(values.get(7).doubleValue()) });
		}
		tableModel.insertRow(0,  new Object[] { "meal", "calories", "fat", "protein", "carbs", "sugar", "fiber", "cholest.", "satFat" });
	}
	
	public void buildMacroTable() {

		JFrame macroFrame = new JFrame();
		macroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		macroFrame.setLocation(600, 50);
		macroFrame.setSize(550, 150);
		
		JPanel macroPanel = new JPanel();
		macroPanel.setBackground(new Color(252,202,70));
		macroPanel.setPreferredSize(new Dimension(550, 150));
		
		macroTable = new JTable() {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int col, java.util.EventObject e) {
        		return false;
        	}
        };
        
        macroTable.setPreferredSize(new Dimension(530, 130));
        createTable();
        macroTable.setModel(tableModel);
        macroPanel.add(macroTable);
        macroFrame.add(macroPanel);
        macroFrame.setVisible(true);
        
        
        /*
        spring.putConstraint(SpringLayout.NORTH, macroPanel, 125, SpringLayout.NORTH, frame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, macroPanel, 600, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(macroPanel);
		
		frame.validate();
		frame.repaint();
		*/
        
	}
	
	
}

