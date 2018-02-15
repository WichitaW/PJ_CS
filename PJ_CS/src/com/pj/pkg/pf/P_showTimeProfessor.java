package com.pj.pkg.pf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.pj.db.sqliteConnection;
import com.pj.pkg.index;
import com.pj.pkg.professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class P_showTimeProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField text_num;
	private JTextField text_name;
	private JTable table_showtime;
	private JComboBox combo_code;
	private JComboBox combo_day;
	private JComboBox combo_time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_showTimeProfessor frame = new P_showTimeProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public void refreshTable(){
		try {
			
			String query="select * from timeprofessor";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_showtime.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Connection connection=null;
	
	public void fillComboBox(){
		try {
			String query="select * from professor";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				combo_code.addItem(rs.getString("pCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public P_showTimeProfessor()  {
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
		
		JLabel label = new JLabel("เรียกดู/แก้ไข เวลาว่าง");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		JButton backhome = new JButton("กลับ");
		backhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close
				professor professor = new professor();	
				dispose();	
				professor.setVisible(true);
			}
		});
		backhome.setForeground(Color.BLACK);
		backhome.setFont(new Font("Angsana New", Font.BOLD, 20));
		backhome.setBackground(Color.WHITE);
		
		text_num = new JTextField();
		text_num.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_num.setColumns(10);
		
		JLabel label_1 = new JLabel("ลำดับ :");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("รหัสอาจารย์ :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_3 = new JLabel("ชื่อ - นามสกุล :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_name = new JTextField();
		text_name.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_name.setColumns(10);

//save
		JButton btn_save = new JButton("บันทึก");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					String query="insert into timeprofessor (pCode,pName,pDay,pTime) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);

					pst.setString(1, (String)combo_code.getSelectedItem());
					
					pst.setString(2, text_name.getText());
					
					String day=combo_day.getSelectedItem().toString();
					pst.setString(3, day);
					
					String time=combo_time.getSelectedItem().toString();
					pst.setString(4, time);
			
					pst.execute();
					JOptionPane.showMessageDialog(null, "บันทึกสำเร็จ");
					pst.close();
					
					
			//		text_pName.setText("");
					combo_day.setSelectedIndex(0);
					combo_time.setSelectedIndex(0);
	
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
				}
				fillComboBox();
				combo_code.setSelectedIndex(0);
				text_name.setText("");
			}
		});
		btn_save.setForeground(Color.BLACK);
		btn_save.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//update	
		JButton btn_update = new JButton("แก้ไข");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="update timeprofessor set no='"+text_num.getText()+"', pCode='"+combo_code.getSelectedItem().toString()+"', pName='"+text_name.getText()+"', pDay='"+combo_day.getSelectedItem().toString()+"', pTime='"+combo_time.getSelectedItem().toString()+"' where no='"+text_num.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
						
					pst.execute();
					JOptionPane.showMessageDialog(null, "แก้ไขสำเร็จ");
					pst.close();
			
					text_num.setText("");
					combo_code.setSelectedIndex(0);
					text_name.setText("");
					combo_day.setSelectedIndex(0);
					combo_time.setSelectedIndex(0);
					
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "แก้ไขไม่สำเร็จ");
				}
				refreshTable();
			}
		});
		btn_update.setForeground(Color.BLACK);
		btn_update.setFont(new Font("Angsana New", Font.BOLD, 18));

//delete
		JButton btn_delete = new JButton("ลบ");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from professor where no='"+text_num.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
						
					pst.execute();
					JOptionPane.showMessageDialog(null, "ลบข้อมูลสำเร็จ");
					pst.close();
					
					text_num.setText("");
					combo_code.setSelectedIndex(0);
					text_name.setText("");
					combo_day.setSelectedIndex(0);
					combo_time.setSelectedIndex(0);
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ลบข้อมูลไม่สำเร็จ");
				}
				refreshTable();
			}
		});
		btn_delete.setForeground(Color.BLACK);
		btn_delete.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//search		
		JButton btn_search = new JButton("ค้นหา");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from timeprofessor";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_showtime.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		btn_search.setForeground(Color.BLACK);
		btn_search.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JButton btn_clear = new JButton("ล้าง");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn_clear.setForeground(Color.BLACK);
		btn_clear.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//table		
		JScrollPane scrollPane = new JScrollPane();
		table_showtime = new JTable();
		scrollPane.setViewportView(table_showtime);
		table_showtime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			//		fillComboBox();
					int row=table_showtime.getSelectedRow();
					String textpNum=(table_showtime.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from timeprofessor where no='"+textpNum+"' ";
					
					PreparedStatement pst=connection.prepareStatement(query);
			
					ResultSet rs=pst.executeQuery();
					
					while(rs.next()){
						text_num.setText(rs.getString("no"));
						combo_code.setSelectedItem(rs.getString("pCode"));
						text_name.setText(rs.getString("pName"));
						combo_day.setSelectedItem(rs.getString("pDay"));
						combo_time.setSelectedItem(rs.getString("pTime"));
					}
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		String[] dayStrings = { "-", "จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์" };
		combo_day = new JComboBox(dayStrings);
		combo_day.setSelectedIndex(0);
		combo_day.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_day.setBackground(Color.WHITE);
		
		JLabel label_4 = new JLabel("วันว่าง :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_5 = new JLabel("เวลาว่าง :");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		String[] timeStrings = { "-", "08.00-09.00", "09.00-10.00", "10.00-11.00", "11.00-12.00", "13.00-14.00", "14.00-15.00", "15.00-16.00", "16.00-17.00" };
		combo_time = new JComboBox(timeStrings);
		combo_time.setSelectedIndex(0);
		combo_time.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_time.setBackground(Color.WHITE);

//code show name
		combo_code = new JComboBox();
		combo_code.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String query="select * from professor where pCode=?";
					PreparedStatement pst=connection.prepareStatement(query);
					
					pst.setString(1, (String)combo_code.getSelectedItem());
			
					ResultSet rs=pst.executeQuery();
					
					while(rs.next()){
						text_name.setText(rs.getString("pName"));
					}
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		combo_code.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_code.setBackground(Color.WHITE);
		fillComboBox();
		text_name.setText("");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(8)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
											.addGap(1)
											.addComponent(text_num, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(102)
													.addComponent(combo_code, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(29)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(38)
													.addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(btn_update, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(6)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(combo_time, 0, 171, Short.MAX_VALUE)
												.addComponent(combo_day, 0, 171, Short.MAX_VALUE))))
									.addGap(51)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
									.addGap(22))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(267)
							.addComponent(backhome, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(2))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(text_num, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(combo_code, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(combo_day, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(combo_time, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(288)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_update, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_clear, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addGap(10)
					.addComponent(backhome, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}
}
