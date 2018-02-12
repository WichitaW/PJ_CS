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

import javax.swing.JTable;

import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import javax.swing.table.DefaultTableModel;

public class P_showProfessor extends JFrame {

	private JPanel contentPane;
	private JTable table_showPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_showProfessor frame = new P_showProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	private JTextField text_pName;
	private JTextField text_pCode;
	
	public P_showProfessor()  {
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
		
		JLabel label = new JLabel("เรียกดู/แก้ไข อาจารย์");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
//btn back		
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
	
//text code		
		JLabel label_2 = new JLabel("รหัสอาจารย์ :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_pCode = new JTextField();
		text_pCode.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pCode.setColumns(10);
		
//text Name		
		JLabel label_1 = new JLabel("ชื่อ - นามสกุล :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_pName = new JTextField();
		text_pName.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pName.setColumns(10);
		
//btn search		
		JButton btn_searchPro = new JButton("ค้นหา");
		btn_searchPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						
						String quary="select * from professor";
						PreparedStatement pst=connection.prepareStatement(quary);
						ResultSet rs=pst.executeQuery();
						table_showPro.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btn_searchPro.setForeground(Color.BLACK);
		btn_searchPro.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		
//btn clear		
		JButton btn_clearsearch = new JButton("ล้าง");
		btn_clearsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text_pCode.setText("");
				text_pName.setText("");
				table_showPro = new JTable();
			}
		});
		btn_clearsearch.setForeground(Color.BLACK);
		btn_clearsearch.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		
//byn save professor
		JButton button = new JButton("บันทึก");
	if(text_pCode!=null && text_pName!=null){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						String quary="insert into professor (pCode,pName) values (?,?)";
						PreparedStatement pst=connection.prepareStatement(quary);
						pst.setString(1, text_pCode.getText());
						pst.setString(2, text_pName.getText());
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "บันทึกสำเร็จ");
						pst.close();

						text_pCode.setText("");
						text_pName.setText("");				
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
				}				
			}
		});
	} else{
		JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
	}
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//update
		JButton button_1 = new JButton("แก้ไข");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String quary="update professor set pCode='"+text_pCode.getText()+"', pName='"+text_pName.getText()+"'";
					PreparedStatement pst=connection.prepareStatement(quary);
					pst.setString(1, text_pCode.getText());
					pst.setString(2, text_pName.getText());
	
					pst.execute();
					JOptionPane.showMessageDialog(null, "แก้ไขสำเร็จ");
					pst.close();
			
					text_pCode.setText("");
					text_pName.setText("");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//table		
		JScrollPane scrollPane = new JScrollPane();
				
		table_showPro = new JTable();
		table_showPro.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table_showPro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table_showPro);
		table_showPro.setFont(new Font("Angsana New", Font.PLAIN, 18));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(288)
							.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_pCode, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btn_searchPro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_clearsearch, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
					.addGap(157))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(text_pCode, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(btn_searchPro, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_clearsearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
