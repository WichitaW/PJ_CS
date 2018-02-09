package com.pj.pkg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class P_addTimeProfessor extends JFrame {

	private JPanel contentPane;
	private JTextField text_pName;
	private JTextField text_pDay;
	private JTextField text_pTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_addTimeProfessor frame = new P_addTimeProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public P_addTimeProfessor() {
		//start
		initialize();
	}
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(index.class.getResource("/com/pj/img/large_PSU_logo.gif")));
		setTitle("ระบบจัดตารางสอนของคณาจารย์ ภาควิชาวิทยาการคอมพิวเตอร์");
		setBounds(300, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("เพิ่มเวลาว่าง");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Angsana New", Font.BOLD, 26));
		
		JComboBox combo_pCode = new JComboBox();
		combo_pCode.setFont(new Font("Angsana New", Font.BOLD, 16));
		combo_pCode.setBackground(Color.WHITE);
		
		JLabel label_1 = new JLabel("รหัสอาจารย์ :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("ชื่อ - สกุล :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_pName = new JTextField();
		text_pName.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pName.setColumns(10);
		
		text_pDay = new JTextField();
		text_pDay.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pDay.setColumns(10);
		
		JLabel label_3 = new JLabel("วันว่าง :");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		JLabel label_4 = new JLabel("เวลาว่าง :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Angsana New", Font.PLAIN, 20));
		
		text_pTime = new JTextField();
		text_pTime.setFont(new Font("Angsana New", Font.BOLD, 16));
		text_pTime.setColumns(10);
		
		JButton savetimeprofes = new JButton("บันทึก");
		savetimeprofes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add
				
			}
		});
		savetimeprofes.setForeground(Color.BLACK);
		savetimeprofes.setFont(new Font("Angsana New", Font.BOLD, 20));
		savetimeprofes.setBackground(Color.WHITE);
		
		JButton backprofes = new JButton("กลับ");
		backprofes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//close
				professor professor = new professor();	
				dispose();	
				professor.setVisible(true);
			}
		});
		backprofes.setForeground(Color.BLACK);
		backprofes.setFont(new Font("Angsana New", Font.BOLD, 20));
		backprofes.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(combo_pCode, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(text_pDay, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(text_pTime, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(savetimeprofes, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(combo_pCode, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(text_pName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(text_pDay, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(text_pTime, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(savetimeprofes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(backprofes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
