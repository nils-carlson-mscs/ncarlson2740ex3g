package ex3g;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.text.DecimalFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PayrollForm extends JFrame {
	private Payroll employee;
	
	private JTextField txtHours;
	private JLabel lblTotalHours;
	private JLabel lblGorssPay;
	private JList EmployeeList;
	private DefaultListModel employeeListModel;
	private JTextField txtEmpID;
	private JTextField txtEmpName;
	private JTextField txtRate;
	private PayrollObjMapper payrollObjMapper;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollForm frame = new PayrollForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayrollForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				do_this_windowClosing(arg0);
			}
		});
		setTitle("COMC2740_ncarlsonex2e");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 445);
		JPanel contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 38, 359, 74);
		contentPane.add(scrollPane);
		
		//EmployeeList = new JList();
//		employeeListModel = new DefaultListModel();
//		employeeListModel.addElement(new Payroll(101, "Nils Carlson", 10.0));
//		employeeListModel.addElement(new Payroll(102, "patti Weigand", 20.0));
//		employeeListModel.addElement(new Payroll(103, "Lyle Stelter", 30.0));
//		employeeListModel.addElement(new Payroll(104, "Neva Burdick", 40.0));
//		employeeListModel.addElement(new Payroll(105, "Lisa Laing", 50.0));
		payrollObjMapper = new PayrollObjMapper("ex3g.txt");
		employeeListModel = payrollObjMapper.getAllPayroll();
		
		
        EmployeeList = new JList(employeeListModel);
		EmployeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_EmployeeList_mouseClicked(arg0);
			}
		});
		EmployeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(EmployeeList);
		
		JLabel lblSelectEmployees = new JLabel("Select Employees:");
		lblSelectEmployees.setBounds(31, 11, 112, 14);
		contentPane.add(lblSelectEmployees);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(32, 186, 90, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(31, 213, 112, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblPayRate = new JLabel("Pay Rate:");
		lblPayRate.setBounds(31, 238, 64, 14);
		contentPane.add(lblPayRate);
		
		JLabel lblEnterHours = new JLabel("Enter Hours:");
		lblEnterHours.setBounds(31, 263, 91, 14);
		contentPane.add(lblEnterHours);
		
		JLabel lblNewLabel = new JLabel("Total Hours:");
		lblNewLabel.setBounds(31, 288, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGrossPay = new JLabel("Gross Pay:");
		lblGrossPay.setBounds(31, 313, 64, 14);
		contentPane.add(lblGrossPay);
		
		txtHours = new JTextField();
		txtHours.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				do_txtHours_focusGained(arg0);
			}
		});
		txtHours.setHorizontalAlignment(SwingConstants.RIGHT);
		txtHours.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtHours.setText("0.00");
		txtHours.setBounds(119, 260, 86, 20);
		contentPane.add(txtHours);
		txtHours.setColumns(10);
		
		lblTotalHours = new JLabel("0.00");
		lblTotalHours.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalHours.setBounds(156, 288, 46, 14);
		contentPane.add(lblTotalHours);
		
		lblGorssPay = new JLabel("$0.00");
		lblGorssPay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGorssPay.setBounds(88, 313, 112, 14);
		contentPane.add(lblGorssPay);
		
		JButton btnClearForm = new JButton("Clear Form");
		btnClearForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnClearForm_actionPerformed(arg0);
			}
		});
		btnClearForm.setBounds(188, 357, 144, 23);
		contentPane.add(btnClearForm);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAdd_actionPerformed(e);
			}
		});
		btnAdd.setBounds(249, 259, 46, 23);
		contentPane.add(btnAdd);
		
		JButton btnClearHours = new JButton("Clear");
		btnClearHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnClearHours_actionPerformed(e);
			}
		});
		btnClearHours.setBounds(305, 259, 89, 23);
		contentPane.add(btnClearHours);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnUpdate_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(33, 357, 89, 23);
		contentPane.add(btnUpdate);
		
		txtEmpID = new JTextField();
		txtEmpID.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEmpID.setText("000");
		txtEmpID.setBounds(144, 183, 61, 20);
		contentPane.add(txtEmpID);
		txtEmpID.setColumns(10);
		
		txtEmpName = new JTextField();
		txtEmpName.setBounds(144, 211, 133, 20);
		contentPane.add(txtEmpName);
		txtEmpName.setColumns(10);
		
		txtRate = new JTextField();
		txtRate.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRate.setBounds(119, 235, 86, 20);
		contentPane.add(txtRate);
		txtRate.setColumns(10);
	}
	protected void do_EmployeeList_mouseClicked(MouseEvent arg0) {
		employee = (Payroll) EmployeeList.getSelectedValue();
		this.txtEmpID.setText(Integer.toString(employee.getId()));
		this.txtEmpName.setText(employee.getName());
		this.txtRate.setText(Double.toString(employee.getPayRate()));
		
		//format hours and gross pay
		DecimalFormat hoursfmt = new DecimalFormat ("0.00");
		this.lblTotalHours.setText(hoursfmt.format(employee.getHours()));
		
		DecimalFormat grossfmt = new DecimalFormat ("$####.00");
		this.lblGorssPay.setText(grossfmt.format(employee.calcGrossPay()));
		
	}
	
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		Payroll emp1 = (Payroll) EmployeeList.getSelectedValue();
		emp1.addHours(Double.parseDouble(this.txtHours.getText()));
		
		// display hours and gross pay
		DecimalFormat hoursfmt = new DecimalFormat("0.00");
		this.lblTotalHours.setText(hoursfmt.format(emp1.getHours()));
		
		DecimalFormat grossPayfmt = new DecimalFormat("$#,###.00");
		this.lblGorssPay.setText(grossPayfmt.format(emp1.calcGrossPay()));
		this.txtHours.setText("0.00");
		this.txtHours.requestFocus();
	}
	protected void do_btnClearHours_actionPerformed(ActionEvent e) {
		this.lblTotalHours.setText("0.00");
		this.lblGorssPay.setText("0.00");
	}
	
	protected void do_btnClearForm_actionPerformed(ActionEvent arg0) {
		this.txtEmpID.setText("0");
		this.txtEmpName.setText("");
		this.lblGorssPay.setText("$0.00");
		this.lblTotalHours.setText("0.00");
		this.txtRate.setText("$0.00");
		
	}
	
	protected void do_txtHours_focusGained(FocusEvent arg0) {
		this.txtHours.selectAll();
	}
	
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		int id = Integer.parseInt(this.txtEmpID.getText());
		double rate = Double.parseDouble(this.txtRate.getText());
		Payroll payroll = (Payroll) EmployeeList.getSelectedValue();
		if (!payroll.setId(id)) {
			JOptionPane.showMessageDialog(null, "Invalid empoyee ID. \nMust be > 100");
			txtEmpID.setText("100");
			txtEmpID.requestFocus();
		}
		
		else if (!payroll.setPayRate(rate)) {
			JOptionPane.showMessageDialog(null, "Invalid Pay Rate. \nMust be >= 7.25 and <= 100");
			txtRate.setText("7.25");
			txtRate.requestFocus();
		}
		
		else  if (!payroll.setName(txtEmpName.getText())) {
			JOptionPane.showMessageDialog(null, "Employee must have name!");
			txtEmpName.setText(employee.getName());
			txtEmpName.requestFocus();
		}
		EmployeeList.repaint();
	}

	private void If(boolean b) {
		// TODO Auto-generated method stub
		
	}
	protected void do_this_windowClosing(WindowEvent arg0) {
		if (payrollObjMapper != null)
			payrollObjMapper.writeAllPayroll(employeeListModel);
		
	}
}
