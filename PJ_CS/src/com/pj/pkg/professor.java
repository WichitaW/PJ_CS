package com.pj.pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

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

import com.pj.db.sqliteConnection;
import com.pj.pkg.pf.P_addProfessor;
import com.pj.pkg.pf.P_addTimeProfessor;
import com.pj.pkg.pf.P_showProfessor;
import com.pj.pkg.pf.P_showTimeProfessor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

public class professor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professor frame = new professor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	
	
	public professor() {
		//start
		initialize();
		connection=sqliteConnection.dbConnection();
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 700, 500);
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/pj/img/large_PSU_logo.gif")));
		setTitle("ระบบจัดตารางสอนของคณาจารย์ ภาควิชาวิทยาการคอมพิวเตอร์");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("ข้อมูลอาจารย์");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		JButton addPro = new JButton("เพิ่มอาจารย์");
		addPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//page addProfessor
				P_addProfessor P_addProfessor = new P_addProfessor();
				dispose();
				P_addProfessor.setVisible(true);
			}
		});
		addPro.setForeground(Color.BLACK);
		addPro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton showPro = new JButton("เรียกดู/แก้ไข อาจารย์");
		showPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//page showProfessor
				P_showProfessor P_showProfessor = new P_showProfessor();
				dispose();
				P_showProfessor.setVisible(true);
			}
		});
		showPro.setForeground(Color.BLACK);
		showPro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton addTimePro = new JButton("เพิ่มเวลาว่าง");
		addTimePro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//page addTimeProfessor
				P_addTimeProfessor P_addTimeProfessor = new P_addTimeProfessor();
				dispose();
				P_addTimeProfessor.setVisible(true);
			}
		});
		addTimePro.setForeground(Color.BLACK);
		addTimePro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton showTimePro = new JButton("เรียกดู/แก้ไข เวลาว่าง");
		showTimePro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//page showTimeProfessor
				P_showTimeProfessor P_showTimeProfessor = new P_showTimeProfessor();
				dispose();
				P_showTimeProfessor.setVisible(true);
			}
		});
		showTimePro.setForeground(Color.BLACK);
		showTimePro.setFont(new Font("Angsana New", Font.BOLD, 20));
		
		JButton backhome = new JButton("กลับหน้าหลัก");
		backhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//back index
				index index = new index();
				dispose();
				index.main(null);
			}
		});
		backhome.setForeground(Color.BLACK);
		backhome.setFont(new Font("Angsana New", Font.BOLD, 20));
		backhome.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(addPro, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(showPro, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(addTimePro, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(showTimePro, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(226)
							.addComponent(backhome, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addGap(39)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(addPro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(showPro, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addTimePro, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(showTimePro, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(backhome, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
