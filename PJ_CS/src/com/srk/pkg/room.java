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

public class room {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void room() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					room window = new room();
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
	public room() {
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
		
		JLabel label = new JLabel("จัดการห้องเรียน");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		JButton addRoom = new JButton("เพิ่ม");
		addRoom.setForeground(Color.BLACK);
		addRoom.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton showRoom = new JButton("เรียกดู/แก้ไข");
		showRoom.setForeground(Color.BLACK);
		showRoom.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton saveRoom = new JButton("บันทึกการใช้ห้อง");
		saveRoom.setForeground(Color.BLACK);
		saveRoom.setFont(new Font("Angsana New", Font.BOLD, 20));
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(241)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(showRoom, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addComponent(addRoom, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveRoom, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
								.addComponent(backhome, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(addRoom, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(showRoom, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(saveRoom, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(backhome, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
