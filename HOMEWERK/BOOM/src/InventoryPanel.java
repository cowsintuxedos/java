import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;


public class InventoryPanel extends JPanel{
	String[] columns;
	Object[][] date;

	public InventoryPanel() {
		super();
		this.setSize(new Dimension (400,200));
		initialize();
		//setLayout(new GridLayout());
		setVisible(true);
	}
	
	private void initialize() {
		Object[][] foo = 
		   {{"Apples", new Double(42.01)},
			{"Bananas", new Double(12.34)},
			{"Bread", new Double(56.78)},
			{"Water", new Double(2147483647)}};
		String[] columns = {"Name", "Price"};
		JTable table = new JTable(foo, columns);
		add(table);
		}
	}

// 2147483647 

