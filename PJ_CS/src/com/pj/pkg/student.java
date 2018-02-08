package com.pj.pkg;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton addStudent = new JButton("เพิ่ม");
		addStudent.setForeground(Color.BLACK);
		addStudent.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton showStudent = new JButton("เรียกดู/แก้ไข");
		showStudent.setForeground(Color.BLACK);
		showStudent.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton backhome = new JButton("กลับหน้าหลัก");
		backhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back index
				index index = new index();
				index.main(null);
			}
		});
		backhome.setForeground(Color.BLACK);
		backhome.setFont(new Font("Angsana New", Font.BOLD, 20));
		backhome.setBackground(Color.WHITE);
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
						.addComponent(backhome, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(showStudent, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(addStudent, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addGap(242))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(102)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(57)
					.addComponent(addStudent, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(29)
					.addComponent(showStudent, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(60)
					.addComponent(backhome, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(74))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
