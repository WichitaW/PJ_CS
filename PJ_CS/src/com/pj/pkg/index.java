package com.pj.pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import cmd.pkg.frame2;
import cmd.pkg.room;
import cmd.pkg.student;
import cmd.pkg.subject;
import cmd.pkg.timetable;

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
		//start
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/pj/img/large_PSU_logo.gif")));
		frame.setTitle("ระบบจัดตารางสอนของคณาจารย์ ภาควิชาวิทยาการคอมพิวเตอร์");
		frame.setBounds(300, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start button professor
		JButton professor = new JButton("จัดการอาจารย์");
		professor.setFont(new Font("Angsana New", Font.BOLD, 26));
		professor.setForeground(Color.BLACK);
		
		professor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action professor
				professor professor = new professor();	
				frame.dispose();	
				professor.setVisible(true);
			}
		});		//stop button professor
			
		JButton student = new JButton("จัดการนักศึกษา");
		student.setFont(new Font("Angsana New", Font.BOLD, 26));
		student.setForeground(Color.BLACK);
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action student
				student stu = new student();
				stu.student();
			}
		});
		
		JButton subject = new JButton("จัดการรายวิชา");
		subject.setFont(new Font("Angsana New", Font.BOLD, 26));
		subject.setForeground(Color.BLACK);
		subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action subject
				subject sj = new subject();
				sj.subject();
			}
		});
		
		JButton room = new JButton("จัดการห้องเรียน");
		room.setFont(new Font("Angsana New", Font.BOLD, 26));
		room.setForeground(Color.BLACK);
		room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action room
				room r = new room();
				r.room();
			}
		});
		
		JButton timetable = new JButton("จัดตารางสอน");
		timetable.setFont(new Font("Angsana New", Font.BOLD, 26));
		timetable.setForeground(Color.BLACK);
		timetable.addActionListener(new ActionListener() {
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
						.addComponent(timetable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(room, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(subject, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(student, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addComponent(professor, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
					.addGap(134))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(professor, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(student, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(subject, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(room, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(timetable, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(86))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}



}