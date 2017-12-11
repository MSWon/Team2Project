
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.SystemColor;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 393);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterLastName = new JLabel("Enter the Title");
		lblEnterLastName.setForeground(SystemColor.text);
		lblEnterLastName.setFont(new Font("굴림", Font.BOLD, 18));
		panel.add(lblEnterLastName);
		
		lastNameTextField = new JTextField();
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(15);
		
		btnSearch = new JButton("Search");
		btnSearch.setBackground(SystemColor.text);
		btnSearch.setFont(new Font("굴림", Font.BOLD, 17));
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==2){
					int row = table.getSelectedRow();
					TableModel data = table.getModel();
					String url = (String)data.getValueAt(row, 1); // 테이블 내에서 해당 row를 클릭했을때 해당 url 로 접속하도록 ! 
					Desktop desktop = Desktop.getDesktop();
					try {
						desktop.browse(new URI(url));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		scrollPane.setViewportView(table);
		this.setVisible(true);
	}

}
