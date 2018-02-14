package com.pj.pkg.pf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.proteanit.sql.DbUtils;

import com.pj.db.sqliteConnection;
import com.pj.pkg.index;
import com.pj.pkg.professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class P_addTimeProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField text_pName;
	private JComboBox combo_pCode;
	private JComboBox combo_pDay;
	private JComboBox combo_pTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_addTimeProfessor frame = new P_addTimeProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	
	public void fillComboBox(){
		try {
			String query="select * from professor";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				combo_pCode.addItem(rs.getString("pCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public P_addTimeProfessor() {
		//start
		initialize();
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		connection=sqliteConnection.dbConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/pj/img/large_PSU_logo.gif")));
		setTitle("ระบบจัดตารางสอนของคณาจารย์ ภาควิชาวิทยาการคอมพิวเตอร์");
		setBounds(300, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("เพิ่มเวลาว่าง");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		combo_pCode = new JComboBox();	
		combo_pCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from professor where pCode=?";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1, (String)combo_pCode.getSelectedItem());
			
					ResultSet rs=pst.executeQuery();
					
					while(rs.next()){
						text_pName.setText(rs.getString("pName"));
					}
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		combo_pCode.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_pCode.setBackground(Color.WHITE);
		contentPane.add(combo_pCode);
		fillComboBox();
		
		JLabel label_1 = new JLabel("รหัสอาจารย์ :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("ชื่อ - นามสกุล :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_pName = new JTextField();
		text_pName.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pName.setColumns(10);
		
		JLabel label_3 = new JLabel("วันว่าง :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Angsana New", Font.PLAIN, 20));

//Day
		String[] dayStrings = { "-", "จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์" };
		combo_pDay = new JComboBox(dayStrings);
		combo_pDay.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_pDay.setBackground(Color.WHITE);
		combo_pDay.setModel(new DefaultComboBoxModel(new String[] {"-", "จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์"}));
		combo_pDay.setSelectedIndex(0);

		JLabel label_4 = new JLabel("เวลาว่าง :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
//Time	
		String[] timeStrings = { "-", "08.00-09.00", "09.00-10.00", "10.00-11.00", "11.00-12.00", "13.00-14.00", "14.00-15.00", "15.00-16.00", "16.00-17.00" };
		combo_pTime = new JComboBox(timeStrings);
		combo_pTime.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_pTime.setBackground(Color.WHITE);
		combo_pTime.setModel(new DefaultComboBoxModel(new String[] {"-", "08.00-09.00", "09.00-10.00", "10.00-11.00", "11.00-12.00", "13.00-14.00", "14.00-15.00", "15.00-16.00", "16.00-17.00"}));
		combo_pTime.setSelectedIndex(0);
		
		
		JButton savetimeprofes = new JButton("บันทึก");
		savetimeprofes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//save time professor
				try {					
					String query="insert into timeprofessor (pCode,pName,pDay,pTime) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);

					pst.setString(1, (String)combo_pCode.getSelectedItem());
					
					pst.setString(2, text_pName.getText());
					
					String day=combo_pDay.getSelectedItem().toString();
					pst.setString(3, day);
					
					String time=combo_pTime.getSelectedItem().toString();
					pst.setString(4, time);
			
					pst.execute();
					JOptionPane.showMessageDialog(null, "บันทึกสำเร็จ");
					pst.close();
					
					
			//		text_pName.setText("");
					combo_pDay.setSelectedIndex(0);
					combo_pTime.setSelectedIndex(0);
	
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
				}
				fillComboBox();
				combo_pCode.setSelectedIndex(0);
				text_pName.setText("");
			}
		});
		savetimeprofes.setForeground(Color.BLACK);
		savetimeprofes.setFont(new Font("Angsana New", Font.BOLD, 20));
		savetimeprofes.setBackground(Color.WHITE);
		
		JButton backprofes = new JButton("กลับ");
		backprofes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close
				professor professor = new professor();	
				dispose();	
				professor.setVisible(true);
			}
		});
		backprofes.setForeground(Color.BLACK);
		backprofes.setFont(new Font("Angsana New", Font.BOLD, 20));
		backprofes.setBackground(Color.WHITE);
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(combo_pCode, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(savetimeprofes, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(204)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(combo_pTime, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(204)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(combo_pDay, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(198)
								.addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(combo_pCode, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_pDay, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_pTime, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(savetimeprofes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
