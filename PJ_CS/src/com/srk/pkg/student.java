package com.srk.pkg;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class student {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void student() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/srk/img/large_PSU_logo.gif")));
		frame.setTitle("ระบบจัดตารางสอนของคณาจารย์ ภาควิชาวิทยาการคอมพิวเตอร์");
		frame.setBounds(300, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("ข้อมูลนักศึกษา");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		JButton button = new JButton("เพิ่ม");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton button_1 = new JButton("เรียกดู/แก้ไข");
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton button_2 = new JButton("กลับหน้าหลัก");
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Angsana New", Font.BOLD, 20));
		button_2.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(239)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addGap(242))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(57)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(60)
					.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(74))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
