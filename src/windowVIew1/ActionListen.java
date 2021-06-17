package windowVIew1;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import control.CHwewonDeungrok;
import control.CIndex;
import control.CLecture;
import control.CLogin;
import control.WindowControl;
import valueObject.OHwewon;
import valueObject.OIndex;
import valueObject.OLogin;

public class ActionListen {
	
	private CHwewonDeungrok cHwewonDeungrok;
	private CLogin cLogin;
	private CIndex cIndex;
	private CLecture cLecture;
	private DefaultTableModel model;
	private WindowControl windowControl;
	
	public OHwewon Loginaction(String ID, String PW) {
		OLogin oLogin = new OLogin();
		oLogin.setId(ID);
		oLogin.setPassword(PW);
		cLogin = new CLogin();
		OHwewon oHwewon = cLogin.validate(oLogin);
		if (oHwewon != null) {
			
			return oHwewon;
	    }
		else {
			JOptionPane.showConfirmDialog(null, "로그인 실패");
			return null;
		}
	}
	
	public void Signaction(String ID, String PW, String Name, String Address, String Major, String Phonenum) {
		OHwewon oHwewon = new OHwewon();
		oHwewon.setId(ID);
		oHwewon.setPassword(PW);
		oHwewon.setName(Name);
		oHwewon.setAddress(Address);
		oHwewon.setHwakgwa(Major);
		oHwewon.setPhoneNum(Phonenum);
		
		
		cHwewonDeungrok = new CHwewonDeungrok();
		cHwewonDeungrok.saveHwewon(oHwewon);
		JOptionPane.showMessageDialog(null, Name+"님 회원가입 되셨습니다.");
	}
	
	public String[] collge(String filename) {
		this.cIndex = new CIndex();
		Vector<OIndex> indices1 = this.cIndex.getAll(filename);
		Vector v1 = new Vector();
		String s1[] = new String[indices1.size()];
		int j=0;
		for(OIndex oIndex : indices1) {
			s1[j]=oIndex.getFileName();
			j++;
		}
		return s1;
	}
	
	public void WindowMSave(String filename, String text) {
		WindowControl windowControl = new WindowControl();
		windowControl.WindowCMSave(filename, text);
	}
	
	public void WindowMDelete(String filename, String text) {
		WindowControl windowControl = new WindowControl();
		windowControl.WindowCMDelete(filename, text);
	}
	
	
}
