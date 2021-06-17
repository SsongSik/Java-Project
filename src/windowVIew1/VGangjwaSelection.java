package windowVIew1;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import control.CLecture;
import valueObject.OLecture;

public class VGangjwaSelection extends JTable {
	private static final long serialVersionUID = 1L;
	//components
	private DefaultTableModel model;
	private CLecture cLecture;
	
	
	public void addRow(String filename, DefaultTableModel tm2) {
		this.cLecture = new CLecture();
		Vector<OLecture> oLectures = this.cLecture.getAll(filename);

		
		String[] row = new String[tm2.getColumnCount()];
		for(OLecture oLecture : oLectures) {
			row[1] = oLecture.getLectureName();
			row[2] = oLecture.getProfName();
			row[4] = oLecture.getTime();
			row[0] = oLecture.getId();
			row[3] = oLecture.getCredits();
			tm2.addRow(row);
		}
		this.updateUI();
	}
	public void bagRow(String filename, DefaultTableModel tm) {
		this.cLecture = new CLecture();
		Vector<OLecture> oLectures = this.cLecture.Windowgetall(filename);
	
		String[] row = new String[tm.getColumnCount()];
		for(OLecture oLecture : oLectures) {
			row[1] = oLecture.getLectureName();
			row[2] = oLecture.getProfName();
			row[4] = oLecture.getTime();
			row[0] = oLecture.getId();
			row[3] = oLecture.getCredits();
			tm.addRow(row);
		}
		this.updateUI();
	}
	
}
