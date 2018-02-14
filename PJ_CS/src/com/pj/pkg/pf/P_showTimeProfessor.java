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

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.pj.pkg.index;
import com.pj.pkg.professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class P_showTimeProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	public P_showTimeProfessor()  {
		initialize();
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
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
		
		JButton button = new JButton("กลับ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close
				professor professor = new professor();	
				dispose();	
				professor.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Angsana New", Font.BOLD, 20));
		button.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setFont(new Font("Angsana New", Font.BOLD, 16));
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("ลำดับ :");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("รหัสอาจารย์ :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Angsana New", Font.BOLD, 16));
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("ชื่อ - นามสกุล :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Angsana New", Font.BOLD, 16));
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("บันทึก");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JButton button_2 = new JButton("แก้ไข");
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JButton button_3 = new JButton("ลบ");
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JButton button_4 = new JButton("ค้นหา");
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JButton button_5 = new JButton("ล้าง");
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("Angsana New", Font.BOLD, 18));
		
		JScrollPane scrollPane = new JScrollPane();
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
									.addGap(88)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
											.addGap(3)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
											.addGap(35)
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
											.addGap(17)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(31)
											.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addGap(12)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
											.addGap(31)
											.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(284)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
