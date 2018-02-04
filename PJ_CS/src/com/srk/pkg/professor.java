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


public class professor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public static void professor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professor window = new professor();
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

	public professor() {
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
		
		JLabel lblNewLabel = new JLabel("ข้อมูลอาจารย์");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.BLACK);
		
		JButton addPro = new JButton("เพิ่มอาจารย์");
		addPro.setFont(new Font("Angsana New", Font.BOLD, 20));
		addPro.setForeground(Color.BLACK);
		
		JButton showPro = new JButton("เรียกดู/แก้ไข อาจารย์");
		showPro.setForeground(Color.BLACK);
		showPro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton addTimePro = new JButton("เพิ่มเวลาว่าง");
		addTimePro.setForeground(Color.BLACK);
		addTimePro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton showTimePro = new JButton("เรียกดู/แก้ไข เวลาว่าง");
		showTimePro.setForeground(Color.BLACK);
		showTimePro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton backhome = new JButton("กลับหน้าหลัก");
		backhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back index
				index index = new index();
				index.main(null);
			}
		});
		backhome.setBackground(Color.WHITE);
		backhome.setForeground(Color.BLACK);
		backhome.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(238)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addPro, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(243))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(backhome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(showTimePro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(addTimePro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addComponent(showPro, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addGap(243))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addGap(46)
					.addComponent(addPro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(showPro, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addTimePro, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(showTimePro, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addGap(51)
					.addComponent(backhome, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(42))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
