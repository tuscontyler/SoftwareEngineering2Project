import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ShoppingGUI {
	
	public DatabaseQueries db;
	private ArrayList<String> items;
	private JCheckBox[] itemsCB;

		
		public ShoppingGUI(DatabaseQueries db) {
			this.db = db;
			
		}
		
	public void createTable() {
		
		Shopping ShoppingList = new Shopping(db);
		
		SpringLayout spring = new SpringLayout();
		JFrame buildShoppingFrame = new JFrame();
		buildShoppingFrame.setSize(700, 700);
		buildShoppingFrame.getContentPane().setLayout(spring);
		buildShoppingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		buildShoppingFrame.setLocationRelativeTo(null);
		
		JPanel headerPanel = new JPanel();
		JLabel headerLabel = new JLabel("Shopping List");
		headerPanel.setBackground(new Color(254,127,45));
		headerPanel.setPreferredSize(new Dimension(650,40));
		headerPanel.add(headerLabel);
		
		JButton addBtn = new JButton("Add");
		JButton removeBtn = new JButton("Remove");
		JButton cancelBtn = new JButton("Cancel");
		
		//new 
		JTextField searchBar = new JTextField();
		searchBar.setPreferredSize(new Dimension(300, 25));
		
		
		JPanel bckgdPanel = new JPanel();
		bckgdPanel.setBackground(new Color(112,146,85));
		bckgdPanel.setPreferredSize(new Dimension(550,575));
		JPanel itemsPanel = new JPanel();
		itemsPanel.setLayout(new GridLayout(20,1));
		itemsPanel.setPreferredSize(new Dimension(530, 500));
		bckgdPanel.setLayout(spring);
		
		items = ShoppingList.getCurrentList();
		itemsCB = new JCheckBox[items.size()];
		
		for(int i = 0; i < itemsCB.length; i++) {
			itemsCB[i] = new JCheckBox(items.get(i));
			itemsPanel.add(itemsCB[i]);
		}
		
		spring.putConstraint(SpringLayout.NORTH, itemsPanel, 20, SpringLayout.NORTH, bckgdPanel);
		spring.putConstraint(SpringLayout.WEST, itemsPanel, 10, SpringLayout.WEST, bckgdPanel);
		bckgdPanel.add(itemsPanel);
		
		spring.putConstraint(SpringLayout.SOUTH, searchBar, -10, SpringLayout.SOUTH, bckgdPanel);
		spring.putConstraint(SpringLayout.WEST, searchBar, 50, SpringLayout.WEST, bckgdPanel);
		bckgdPanel.add(searchBar);
		
		spring.putConstraint(SpringLayout.SOUTH, addBtn, -10, SpringLayout.SOUTH, bckgdPanel);
		spring.putConstraint(SpringLayout.WEST, addBtn, 15, SpringLayout.EAST, searchBar);
		bckgdPanel.add(addBtn);
		
		spring.putConstraint(SpringLayout.SOUTH, removeBtn, 0, SpringLayout.SOUTH, addBtn);
		spring.putConstraint(SpringLayout.WEST, removeBtn, 10, SpringLayout.EAST, addBtn);
		bckgdPanel.add(removeBtn);
		
		spring.putConstraint(SpringLayout.NORTH, headerPanel, 25, SpringLayout.NORTH, buildShoppingFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, headerPanel, 15, SpringLayout.WEST, buildShoppingFrame.getContentPane());
		buildShoppingFrame.getContentPane().add(headerPanel);
		
		spring.putConstraint(SpringLayout.NORTH, bckgdPanel, 10, SpringLayout.SOUTH, headerPanel);
		spring.putConstraint(SpringLayout.WEST, bckgdPanel, 15, SpringLayout.WEST, headerPanel);
		buildShoppingFrame.getContentPane().add(bckgdPanel);
		
		spring.putConstraint(SpringLayout.SOUTH, cancelBtn, -25, SpringLayout.SOUTH, buildShoppingFrame.getContentPane());
		spring.putConstraint(SpringLayout.WEST, cancelBtn, 10, SpringLayout.EAST, bckgdPanel);
		buildShoppingFrame.getContentPane().add(cancelBtn);

		
		buildShoppingFrame.setVisible(true);
		
		
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String textInput = searchBar.getText();
				ShoppingList.addToList(textInput);
				
				bckgdPanel.remove(itemsPanel);
				itemsPanel.removeAll();
				itemsPanel.setLayout(new GridLayout(20,1));
				items = ShoppingList.getCurrentList();
				itemsCB = new JCheckBox[items.size()];
				
				for(int i = 0; i < itemsCB.length; i++) {
					itemsCB[i] = new JCheckBox(items.get(i));
					itemsPanel.add(itemsCB[i]);
				}
				
				spring.putConstraint(SpringLayout.NORTH, itemsPanel, 20, SpringLayout.NORTH, bckgdPanel);
				spring.putConstraint(SpringLayout.WEST, itemsPanel, 10, SpringLayout.WEST, bckgdPanel);
				bckgdPanel.add(itemsPanel);
				
				bckgdPanel.validate();
				bckgdPanel.repaint();
			}
			
		});
		
		removeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				bckgdPanel.remove(itemsPanel);
				itemsPanel.removeAll();
				itemsPanel.setLayout(new GridLayout(20,1));
				
				for(int i = 0; i < itemsCB.length; i++) {
					
					if(itemsCB[i].isSelected()) {
						ShoppingList.deleteItemFromList(itemsCB[i].getText());
					}
					
				}
				
				items = ShoppingList.getCurrentList();
				itemsCB = new JCheckBox[items.size()];
				
				for(int i = 0; i < itemsCB.length; i++) {
					itemsCB[i] = new JCheckBox(items.get(i));
					itemsPanel.add(itemsCB[i]);
				}
				
				spring.putConstraint(SpringLayout.NORTH, itemsPanel, 20, SpringLayout.NORTH, bckgdPanel);
				spring.putConstraint(SpringLayout.WEST, itemsPanel, 10, SpringLayout.WEST, bckgdPanel);
				bckgdPanel.add(itemsPanel);
				
				bckgdPanel.validate();
				bckgdPanel.repaint();
			}
			
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				buildShoppingFrame.dispose();
			}
			
		});
		
		
		

		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
