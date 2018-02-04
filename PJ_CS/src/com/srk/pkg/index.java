package com.srk.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

public class index {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index window = new index();
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
	public index() {
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
		
		//button
		JButton button = new JButton("จัดการอาจารย์");
		button.setFont(new Font("Angsana New", Font.BOLD, 26));
		button.setForeground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action professor
				professor profes = new professor();
				profes.professor();
			}
		});
		
		JButton button_1 = new JButton("จัดการนักศึกษา");
		button_1.setFont(new Font("Angsana New", Font.BOLD, 26));
		button_1.setForeground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action student
				student stu = new student();
				stu.student();
			}
		});
		
		JButton button_2 = new JButton("จัดการรายวิชา");
		button_2.setFont(new Font("Angsana New", Font.BOLD, 26));
		button_2.setForeground(Color.BLACK);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action subject
				subject sj = new subject();
				sj.subject();
			}
		});
		
		JButton button_3 = new JButton("จัดการห้องเรียน");
		button_3.setFont(new Font("Angsana New", Font.BOLD, 26));
		button_3.setForeground(Color.BLACK);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action room
				room room = new room();
				room.room();
			}
		});
		
		JButton button_4 = new JButton("จัดตารางสอน");
		button_4.setFont(new Font("Angsana New", Font.BOLD, 26));
		button_4.setForeground(Color.BLACK);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action timetable
				timetable tTable = new timetable();
				tTable.timetable();
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(button_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(button_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(button_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
					.addGap(134))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(button, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button_3, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button_4, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(86))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}



}
