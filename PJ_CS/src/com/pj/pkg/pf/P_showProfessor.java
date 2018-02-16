package com.pj.pkg.pf;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JComboBox;
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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JTextField text_pNumber;
	
	public void refreshTable(){
		try {
			
			String query="select * from professor";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_showPro.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
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
		
//text number
		JLabel label_3 = new JLabel("ลำดับ :");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_pNumber = new JTextField();
		text_pNumber.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pNumber.setColumns(10);
		
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
						String query="select * from professor";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table_showPro.setModel(DbUtils.resultSetToTableModel(rs));
						
						pst.close();
						rs.close();
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
				table_showPro.setModel(new DefaultTableModel());
				text_pNumber.setText("");
				text_pCode.setText("");
				text_pName.setText("");
			}
		});
		btn_clearsearch.setForeground(Color.BLACK);
		btn_clearsearch.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//byn save professor
		JButton btnsave = new JButton("บันทึก");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
						String query="insert into professor (pNumber,pCode,pName) values (?,?,?)";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.setString(1, text_pNumber.getText());
						pst.setString(2, text_pCode.getText());
						pst.setString(3, text_pName.getText());
						
						pst.execute();
						JOptionPane.showMessageDialog(null, "บันทึกสำเร็จ");
						pst.close();
						
						text_pNumber.setText("");
						text_pCode.setText("");
						text_pName.setText("");		
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ถูกต้อง");
				}
				refreshTable();
			}
		});
		btnsave.setForeground(Color.BLACK);
		btnsave.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//update
		JButton btnupdate = new JButton("แก้ไข");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="update professor set pNumber='"+text_pNumber.getText()+"', pCode='"+text_pCode.getText()+"', pName='"+text_pName.getText()+"' where pNumber='"+text_pNumber.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
						
					pst.execute();
					JOptionPane.showMessageDialog(null, "แก้ไขสำเร็จ");
					pst.close();
			
					text_pNumber.setText("");
					text_pCode.setText("");
					text_pName.setText("");
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "แก้ไขไม่สำเร็จ");
				}
				refreshTable();
			}
		});
		btnupdate.setForeground(Color.BLACK);
		btnupdate.setFont(new Font("Angsana New", Font.BOLD, 18));

//delete
		JButton button = new JButton("ลบ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="delete from professor where pNumber='"+text_pNumber.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
						
					pst.execute();
					JOptionPane.showMessageDialog(null, "ลบข้อมูลสำเร็จ");
					pst.close();
					
					text_pNumber.setText("");
					text_pCode.setText("");
					text_pName.setText("");
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ลบข้อมูลไม่สำเร็จ");
				}
				refreshTable();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Angsana New", Font.BOLD, 18));
		
//table	
		JScrollPane scrollPane = new JScrollPane();
		table_showPro = new JTable();
		table_showPro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table_showPro);
		table_showPro.setFont(new Font("Angsana New", Font.PLAIN, 18));
		
		table_showPro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row=table_showPro.getSelectedRow();
					String textpNum=(table_showPro.getModel().getValueAt(row, 0)).toString();
					
					String query="select * from professor where pNumber='"+textpNum+"' ";
					
					PreparedStatement pst=connection.prepareStatement(query);
			
					ResultSet rs=pst.executeQuery();
					
					while(rs.next()){
						text_pNumber.setText(rs.getString("pNumber"));
						text_pCode.setText(rs.getString("pCode"));
						text_pName.setText(rs.getString("pName"));
					}
					pst.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
				

		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_pName, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(text_pNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
									.addComponent(text_pCode, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnsave, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnupdate, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addComponent(btn_clearsearch, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
						.addComponent(btn_searchPro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(277)
					.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(287, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnsave, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pCode, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pNumber, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnupdate, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(btn_searchPro, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_clearsearch, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
