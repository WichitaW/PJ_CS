package com.srk.pkg;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class subject {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void subject() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					subject window = new subject();
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
	public subject() {
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
		
		JLabel label = new JLabel("จัดการข้อมูลรายวิชา");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		JButton addSubject = new JButton("เพิ่ม");
		addSubject.setForeground(Color.BLACK);
		addSubject.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton showSubject = new JButton("เรียกดู/แก้ไข");
		showSubject.setForeground(Color.BLACK);
		showSubject.setFont(new Font("Angsana New", Font.BOLD, 20));
		
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
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
					.addGap(14))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(241)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(showSubject, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(backhome, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addGap(240))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addSubject, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
							.addGap(240))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(60)
					.addComponent(addSubject, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(28)
					.addComponent(showSubject, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(60)
					.addComponent(backhome, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(71))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
