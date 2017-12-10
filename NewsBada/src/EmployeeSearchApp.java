
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;
import java.awt.Font;

public class EmployeeSearchApp extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	private JTable table;

	private EmployeeDAO employeeDAO;
	
	/**


	/**
	 * Create the frame.
	 */
	public EmployeeSearchApp() {
		
		// create the DAO
		try {
			employeeDAO = new EmployeeDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		setTitle("Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterLastName = new JLabel("Enter the Title");
		lblEnterLastName.setFont(new Font("±¼¸²", Font.BOLD, 18));
		panel.add(lblEnterLastName);
		
		lastNameTextField = new JTextField();
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(15);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get last name from the text field

				// Call DAO and get employees for the last name

				// If last name is empty, then get all employees

				// Print out employees				
				
				try {
					String A_title = lastNameTextField.getText();

					List<Employee> employees = null;

					if (A_title != null && A_title.trim().length() > 0) {
						employees = employeeDAO.searchEmployees(A_title);
					} else {
						employees = employeeDAO.getAllEmployees();
					}
					
					// create the model and update the "table"
					EmployeeTableModel model = new EmployeeTableModel(employees);
					
					table.setModel(model);
					
					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		panel.add(btnSearch);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}

}
