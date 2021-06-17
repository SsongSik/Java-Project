package windowVIew1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignPanel {

	static JFrame frame;
	private JTextField IDinput;
	private JPasswordField PWinput;
	private JTextField Nameinput;
	private JTextField Addressinput;
	private JTextField Majorinput;
	private JTextField Numinput;
	private CHwewonDeungrok cHwewonDeungrok;
	private ActionListen actionListener;
	private LoginPanel loginPanel;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public SignPanel() {
		this.actionListener = new ActionListen();
//		this.loginPanel = new LoginPanel();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 625, 466);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uBA85\uC9C0\uB300\uD559\uAD50 \uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setFont(new Font("배달의민족 도현", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(216, 10, 245, 50);
		panel.add(lblNewLabel_3);
		
		IDinput = new JTextField();
		IDinput.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		IDinput.setColumns(10);
		IDinput.setBounds(149, 69, 339, 42);
		panel.add(IDinput);
		
		JLabel lblNewLabel_4 = new JLabel("\uC544\uC774\uB514 :");
		lblNewLabel_4.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(76, 68, 71, 42);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		lblNewLabel_4_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(66, 120, 71, 42);
		panel.add(lblNewLabel_4_1);
		
		PWinput = new JPasswordField();
		PWinput.setFont(new Font("굴림", Font.PLAIN, 13));
		PWinput.setBounds(149, 121, 339, 42);
		panel.add(PWinput);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uC774\uB984 :");
		lblNewLabel_4_2.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(76, 172, 71, 42);
		panel.add(lblNewLabel_4_2);
		
		Nameinput = new JTextField();
		Nameinput.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		Nameinput.setColumns(10);
		Nameinput.setBounds(149, 173, 339, 42);
		panel.add(Nameinput);
		
		JLabel lblNewLabel_4_3 = new JLabel("\uC8FC\uC18C :");
		lblNewLabel_4_3.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		lblNewLabel_4_3.setBounds(76, 224, 71, 42);
		panel.add(lblNewLabel_4_3);
		
		Addressinput = new JTextField();
		Addressinput.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		Addressinput.setColumns(10);
		Addressinput.setBounds(149, 225, 339, 42);
		panel.add(Addressinput);
		
		JLabel lblNewLabel_4_4 = new JLabel("\uD559\uACFC :");
		lblNewLabel_4_4.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		lblNewLabel_4_4.setBounds(76, 276, 61, 42);
		panel.add(lblNewLabel_4_4);
		
		Majorinput = new JTextField();
		Majorinput.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		Majorinput.setColumns(10);
		Majorinput.setBounds(149, 277, 339, 42);
		panel.add(Majorinput);
		
		JLabel lblNewLabel_4_4_1 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		lblNewLabel_4_4_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		lblNewLabel_4_4_1.setBounds(66, 328, 71, 42);
		panel.add(lblNewLabel_4_4_1);
		
		Numinput = new JTextField();
		Numinput.setFont(new Font("배달의민족 도현", Font.PLAIN, 13));
		Numinput.setColumns(10);
		Numinput.setBounds(149, 329, 339, 42);
		panel.add(Numinput);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListener.Signaction(IDinput.getText(), PWinput.getText(), Nameinput.getText(), Addressinput.getText(), Majorinput.getText(),Numinput.getText() );
				loginPanel = new LoginPanel();
				frame.setVisible(false);
				loginPanel.frame.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
		btnNewButton.setBounds(149, 380, 339, 64);
		panel.add(btnNewButton);
	}

}
