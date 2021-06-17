package windowVIew1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class LoginPanel {

	JFrame frame;
	private JTextField IDField;
	private JPasswordField PWField;
	private ActionListen actionListener;
	private Sugangsincheong sugangsincheong;
	private SignPanel signPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//			SignPanel signPanel = new SignPanel();
//			Sugangsincheong sugangsincheong = new Sugangsincheong();
			LoginPanel main = new LoginPanel();
			main.frame.setVisible(true);	
		}
	/**
	 * Create the application.
	 */
	public LoginPanel() {
		this.actionListener = new ActionListen(); //�׼Ǹ��� Ŭ���� �Ҵ�
		 //�α��ν� ������ûȭ�� �Ҵ�
		 //ȸ������ �Ҵ�
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
		panel.setBounds(0, 0, 632, 466);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel LoginForm = new JLabel("Login");
		LoginForm.setFont(new Font("Yu Gothic", Font.PLAIN, 28));
		LoginForm.setBounds(256, 48, 185, 63);
		panel.add(LoginForm);
		
		JLabel IDinput = new JLabel("ID : ");
		IDinput.setFont(new Font("����ǹ��� ����", Font.PLAIN, 18));
		IDinput.setBounds(74, 143, 101, 71);
		panel.add(IDinput);
		
		JLabel PWinput = new JLabel("PW :");
		PWinput.setFont(new Font("����ǹ��� ����", Font.PLAIN, 18));
		PWinput.setBounds(65, 250, 82, 52);
		panel.add(PWinput);
		
		IDField = new JTextField();
		IDField.setFont(new Font("����ǹ��� ����", Font.PLAIN, 18));
		IDField.setColumns(10);
		IDField.setBounds(147, 150, 297, 58);
		panel.add(IDField);
		
		PWField = new JPasswordField();
		PWField.setFont(new Font("����", Font.PLAIN, 18));
		PWField.setBounds(147, 250, 297, 58);
		panel.add(PWField);
		
		JButton LoginBtn = new JButton("LOG IN");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(check.idpwcheck(IDField.getText(),PWField.getText() )==true) {
//					JOptionPane.showMessageDialog(null, "���������� �α���");
//				}
//				else {
//					JOptionPane.showConfirmDialog(null, "�α��� ����");
//				}
				if(actionListener.Loginaction(IDField.getText(), PWField.getText())!=null) {
					JOptionPane.showMessageDialog(null, "���������� �α���");
					sugangsincheong = new Sugangsincheong(actionListener.Loginaction(IDField.getText(), PWField.getText()));
					frame.setVisible(false);
					sugangsincheong.frame.setVisible(true);
					
				}
			}
		});
		LoginBtn.setBackground(new Color(244, 164, 96));
		LoginBtn.setForeground(Color.YELLOW);
		LoginBtn.setFont(new Font("����ǹ��� ����", Font.PLAIN, 18));
		LoginBtn.setBounds(79, 356, 154, 63);
		panel.add(LoginBtn);
		
		//ȸ������ ��ư ������ �� ȸ������ �гη� �̵�.
		JButton SignBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		SignBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signPanel = new SignPanel();
				signPanel.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		SignBtn.setBackground(new Color(244, 164, 96));
		SignBtn.setForeground(Color.YELLOW);
		SignBtn.setFont(new Font("����ǹ��� ����", Font.PLAIN, 18));
		SignBtn.setBounds(303, 356, 154, 66);
		panel.add(SignBtn);
	}
}
