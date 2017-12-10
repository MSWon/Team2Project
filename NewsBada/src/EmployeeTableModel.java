
import java.util.List;

import javax.swing.table.AbstractTableModel;

class EmployeeTableModel extends AbstractTableModel {

	private static final int LAST_NAME_COL = 0;
	private static final int FIRST_NAME_COL = 1;

	private String[] columnNames = { "Title", "Url"};
	private List<Employee> employees;

	public EmployeeTableModel(List<Employee> theEmployees) {
		employees = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Employee tempEmployee = employees.get(row);

		switch (col) {
		case LAST_NAME_COL:
			return tempEmployee.getA_title();
		case FIRST_NAME_COL:
			return tempEmployee.getUrl();
		default:
			return tempEmployee.getA_title();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
