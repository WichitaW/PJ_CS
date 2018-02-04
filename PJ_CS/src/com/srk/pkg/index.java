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
		//start
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/srk/img/large_PSU_logo.gif")));
		frame.setTitle("�к��Ѵ���ҧ�͹�ͧ��Ҩ���� �Ҥ�Ԫ��Է�ҡ�ä���������");
		frame.setBounds(300, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//button
		JButton professor = new JButton("�Ѵ����Ҩ����");
		professor.setFont(new Font("Angsana New", Font.BOLD, 26));
		professor.setForeground(Color.BLACK);
		professor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action professor
				professor profes = new professor();
				profes.professor();
			}
		});
		
		JButton student = new JButton("�Ѵ��ùѡ�֡��");
		student.setFont(new Font("Angsana New", Font.BOLD, 26));
		student.setForeground(Color.BLACK);
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action student
				student stu = new student();
				stu.student();
			}
		});
		
		JButton subject = new JButton("�Ѵ�������Ԫ�");
		subject.setFont(new Font("Angsana New", Font.BOLD, 26));
		subject.setForeground(Color.BLACK);
		subject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action subject
				subject sj = new subject();
				sj.subject();
			}
		});
		
		JButton room = new JButton("�Ѵ�����ͧ���¹");
		room.setFont(new Font("Angsana New", Font.BOLD, 26));
		room.setForeground(Color.BLACK);
		room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//action room
				room r = new room();
				r.room();
			}
		});
		
		JButton timetable = new JButton("�Ѵ���ҧ�͹");
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
