package com.srk.pkg;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class P_addTimeProfessor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public static void addTimeProfessor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_addTimeProfessor window = new P_addTimeProfessor();
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

	public P_addTimeProfessor() {
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
		
		JLabel lblNewLabel = new JLabel("เพิ่มเวลาว่าง");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.BLACK);
		
		JButton saveprofes = new JButton("บันทึก");
		saveprofes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//save professor
			}
		});
		saveprofes.setForeground(Color.BLACK);
		saveprofes.setFont(new Font("Angsana New", Font.BOLD, 20));
		saveprofes.setBackground(Color.WHITE);
		
		JButton backprofes = new JButton("กลับ");
		backprofes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back professor
				professor profes = new professor();
				profes.professor();
			}
		});
		backprofes.setBackground(Color.WHITE);
		backprofes.setForeground(Color.BLACK);
		backprofes.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(216)
					.addComponent(saveprofes, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addGap(47)
					.addComponent(backprofes, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
					.addGap(217))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(308)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backprofes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(saveprofes, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(42))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
