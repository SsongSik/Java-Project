package windowVIew1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CIndex;
import valueObject.OHwewon;
import valueObject.OIndex;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
public class Sugangsincheong {

	static JFrame frame;
	private JTable Bag;
	private JTable Sugang;
	private JTable lecture;
	private CIndex cIndex;
	private ActionListen actionListener;
	private VGangjwaSelection vGangjwaSelection;
	private Sugangsincheong sugangsincheong;
	private OHwewon oHwewon1;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param oHwewon 
	 */
	public Sugangsincheong(OHwewon oHwewon) {
		this.actionListener = new ActionListen();
		this.oHwewon1 = oHwewon;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1160, 558);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
//		
		
		JComboBox Campus = new JComboBox();
		Campus.setToolTipText("");
		Campus.setBounds(79, 10, 244, 23);
		panel.add(Campus);
		
		this.cIndex = new CIndex();
		Vector<OIndex> indices = this.cIndex.getAll("root");
		Vector v = new Vector();
		String s[] = new String[indices.size()];
		String s1[] = new String[indices.size()];
		int i=0;
		for(OIndex oIndex : indices) {
			s[i]=oIndex.getFileName();
//			s1[i]=oIndex.getFileName();
			i++;
		}
		Campus.setModel(new DefaultComboBoxModel(s));	

		Bag = new JTable();
		Bag.setModel(new DefaultTableModel(
			new Object[][] {
				{"강좌번호", "강좌명", "교수명", "학점", "시간"}
			},
			new String[] {
					"강좌번호", "강좌명", "교수명", "학점", "시간"
			}
		));
		Bag.setBounds(416, 113, 328, 375);
		panel.add(Bag);
		
		vGangjwaSelection = new VGangjwaSelection();
		DefaultTableModel tm = (DefaultTableModel) Bag.getModel();
		tm.setNumRows(1);
		String filename = "user/"+oHwewon1.getId()+"_bag.txt";
		vGangjwaSelection.bagRow(filename, tm);
		
		
		
		Sugang = new JTable();
		Sugang.setModel(new DefaultTableModel(
			new Object[][] {
				{"강좌번호", "강좌명", "교수명", "학점", "시간"}
			},
			new String[] {
					"강좌번호", "강좌명", "교수명", "학점", "시간"
			}
		));
		

		Sugang.setBounds(820, 113, 328, 375);
		panel.add(Sugang);
		
		vGangjwaSelection = new VGangjwaSelection();
		DefaultTableModel tm1 = (DefaultTableModel) Sugang.getModel();
		tm1.setNumRows(1);
		String filename1 = "user/"+oHwewon1.getId()+"_sinchoen.txt";
		vGangjwaSelection.bagRow(filename1, tm1);
		
		JComboBox College = new JComboBox();
		College.setBounds(463, 10, 244, 23);
		panel.add(College);
		
		JComboBox Department = new JComboBox();
		Department.setBounds(883, 10, 244, 23);
		panel.add(Department);
		
		lecture = new JTable();
		lecture.setModel(new DefaultTableModel(
			new Object[][] {
				{"강좌번호", "강좌명", "교수명", "학점", "시간"}
			},
			new String[] {
					"강좌번호", "강좌명", "교수명", "학점", "시간"
			}
		));
		lecture.setBounds(12, 113, 328, 375);
		panel.add(lecture);
		
	
		JLabel lblNewLabel = new JLabel("책가방");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 29));
		lblNewLabel.setBounds(513, 43, 143, 61);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("강좌목록");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(104, 42, 133, 61);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("수강신청");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(929, 42, 143, 61);
		panel.add(lblNewLabel_1_1);
		
		JButton miridamgi = new JButton("담기");
		miridamgi.setFont(new Font("굴림", Font.PLAIN, 9));
		
		//담기버튼
		miridamgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = lecture.getSelectedRow();
				if(num1==-1) {
					JOptionPane.showMessageDialog(null, "선택해주세요.");
				}
				else {
				String text="";
				text += (String)lecture.getValueAt(num1, 0)+" ";
				text += (String)lecture.getValueAt(num1, 1)+" ";
				text += (String)lecture.getValueAt(num1, 2)+" ";
				text += (String)lecture.getValueAt(num1, 3)+" ";
				text += (String)lecture.getValueAt(num1, 4);
				actionListener.WindowMSave(filename, text); 
				tm.setNumRows(1);
				vGangjwaSelection.bagRow(filename, tm);
				}
			}
		});
		miridamgi.setBounds(346, 226, 58, 39);
		panel.add(miridamgi);
		
		//책가방삭제버튼
		JButton delete = new JButton("삭제");
		delete.setFont(new Font("굴림", Font.PLAIN, 9));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Bag.getSelectedRow();
				if(num1==-1) {
					JOptionPane.showMessageDialog(null, "선택해주세요.");
				}else {
				String text="";
				text += (String)Bag.getValueAt(num1, 0)+" ";
				text += (String)Bag.getValueAt(num1, 1)+" ";
				text += (String)Bag.getValueAt(num1, 2)+" ";
				text += (String)Bag.getValueAt(num1, 3)+" ";
				text += (String)Bag.getValueAt(num1, 4);
				actionListener.WindowMDelete(filename, text);
				tm.setNumRows(1);
				vGangjwaSelection.bagRow(filename, tm);
				}
			}
		});
		delete.setBounds(346, 287, 58, 39);
		panel.add(delete);
		
		JButton sincheong = new JButton("신청");
		sincheong.setFont(new Font("굴림", Font.PLAIN, 9));
		//수강신청버튼
		sincheong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Bag.getSelectedRow();
				String text="";
				if(num1==-1) {
					JOptionPane.showMessageDialog(null, "선택해주세요.");
				}
				else {
				text += (String)Bag.getValueAt(num1, 0)+" ";
				text += (String)Bag.getValueAt(num1, 1)+" ";
				text += (String)Bag.getValueAt(num1, 2)+" ";
				text += (String)Bag.getValueAt(num1, 3)+" ";
				text += (String)Bag.getValueAt(num1, 4);
				actionListener.WindowMSave(filename1, text);
				tm1.setNumRows(1);
				vGangjwaSelection.bagRow(filename1, tm1);
				}
			}
		});
		sincheong.setBounds(750, 226, 58, 39);
		panel.add(sincheong);
		
		JButton sincheongdelete = new JButton("삭제");
		sincheongdelete.setFont(new Font("굴림", Font.PLAIN, 9));
		sincheongdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1 = Sugang.getSelectedRow();
				if(num1==-1) {
					JOptionPane.showMessageDialog(null, "선택해주세요.");
				}
				else {
				String text="";
				text += (String)Sugang.getValueAt(num1, 0)+" ";
				text += (String)Sugang.getValueAt(num1, 1)+" ";
				text += (String)Sugang.getValueAt(num1, 2)+" ";
				text += (String)Sugang.getValueAt(num1, 3)+" ";
				text += (String)Sugang.getValueAt(num1, 4);
				actionListener.WindowMDelete(filename1, text);
				tm1.setNumRows(1);
				vGangjwaSelection.bagRow(filename1, tm1);
				}
			}
		});
		sincheongdelete.setBounds(750, 287, 58, 39);
		panel.add(sincheongdelete);
		
		JLabel lblNewLabel_2 = new JLabel("\uCEA0\uD37C\uC2A4");
		lblNewLabel_2.setBounds(35, -3, 76, 48);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB2E8\uACFC\uB300");
		lblNewLabel_2_1.setBounds(416, -3, 76, 48);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uD559\uACFC");
		lblNewLabel_2_1_1.setBounds(841, -3, 76, 48);
		panel.add(lblNewLabel_2_1_1);
		
		Campus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String collegename []= actionListener.collge(Campus.getSelectedItem().toString());
				College.setModel(new DefaultComboBoxModel(collegename));
			}
		});
		College.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String departmentname [] = actionListener.collge(College.getSelectedItem().toString());
				Department.setModel(new DefaultComboBoxModel(departmentname));
			}
		});
		vGangjwaSelection = new VGangjwaSelection();
//		vGangjwaSelection.initialize();
		Department.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vGangjwaSelection = new VGangjwaSelection();
				DefaultTableModel tm = (DefaultTableModel) lecture.getModel();
				tm.setNumRows(1);
				String filename = Department.getSelectedItem().toString();
				vGangjwaSelection.addRow(filename, tm);
			}
		});
	}
}
